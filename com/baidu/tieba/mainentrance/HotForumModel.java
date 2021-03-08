package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class HotForumModel extends BdBaseModel {
    private com.baidu.adp.base.f eXa;
    private a lkT;
    private List<b> lkU;
    private HotSearchInfoData mHotSearchInfo;
    private List<c> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes7.dex */
    public interface a {
        void NX(String str);

        void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    public HotForumModel(com.baidu.adp.base.f fVar, a aVar) {
        super(fVar);
        this.eXa = fVar;
        this.lkT = aVar;
        dea();
    }

    public void ddZ() {
        sendMessage(new HotForumNetMessage());
    }

    private void dea() {
        registerListener(new com.baidu.adp.framework.listener.a(1001534, CmdConfigSocket.CMD_GET_HOTFORUM) { // from class: com.baidu.tieba.mainentrance.HotForumModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    HotForumModel.this.lkT.NX(HotForumModel.this.eXa.getString(R.string.neterror));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    HotForumModel.this.lkT.NX(HotForumModel.this.eXa.getString(R.string.neterror));
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        HotForumModel.this.lkT.NX(responsedMessage.getErrorString());
                    } else {
                        HotForumModel.this.lkT.NX(HotForumModel.this.eXa.getString(R.string.neterror));
                    }
                } else {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        HotForumModel.this.lkU = hotForumHttpResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.lkT.a(HotForumModel.this.lkU, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                    if (responsedMessage instanceof HotForumSocketResponseMessage) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        HotForumModel.this.lkU = hotForumSocketResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.lkT.a(HotForumModel.this.lkU, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
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
