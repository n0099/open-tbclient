package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class HotForumModel extends BdBaseModel {
    private com.baidu.adp.base.f eVB;
    private a liR;
    private List<b> liS;
    private HotSearchInfoData mHotSearchInfo;
    private List<c> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes8.dex */
    public interface a {
        void NR(String str);

        void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    public HotForumModel(com.baidu.adp.base.f fVar, a aVar) {
        super(fVar);
        this.eVB = fVar;
        this.liR = aVar;
        ddR();
    }

    public void ddQ() {
        sendMessage(new HotForumNetMessage());
    }

    private void ddR() {
        registerListener(new com.baidu.adp.framework.listener.a(1001534, CmdConfigSocket.CMD_GET_HOTFORUM) { // from class: com.baidu.tieba.mainentrance.HotForumModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    HotForumModel.this.liR.NR(HotForumModel.this.eVB.getString(R.string.neterror));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    HotForumModel.this.liR.NR(HotForumModel.this.eVB.getString(R.string.neterror));
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        HotForumModel.this.liR.NR(responsedMessage.getErrorString());
                    } else {
                        HotForumModel.this.liR.NR(HotForumModel.this.eVB.getString(R.string.neterror));
                    }
                } else {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        HotForumModel.this.liS = hotForumHttpResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.liR.a(HotForumModel.this.liS, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                    if (responsedMessage instanceof HotForumSocketResponseMessage) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        HotForumModel.this.liS = hotForumSocketResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.liR.a(HotForumModel.this.liS, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                }
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
