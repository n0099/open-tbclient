package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import d.b.c.a.f;
import d.b.j0.o1.c;
import java.util.List;
/* loaded from: classes3.dex */
public class HotForumModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public f f18469e;

    /* renamed from: f  reason: collision with root package name */
    public b f18470f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.j0.o1.b> f18471g;

    /* renamed from: h  reason: collision with root package name */
    public HotSearchInfoData f18472h;
    public List<c> i;
    public String j;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof HotForumSocketResponseMessage;
            if (!z && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                HotForumModel.this.f18470f.onHotForumDataFailed(HotForumModel.this.f18469e.getString(R.string.neterror));
            } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                HotForumModel.this.f18470f.onHotForumDataFailed(HotForumModel.this.f18469e.getString(R.string.neterror));
            } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof HotForumHttpResponseMessage) {
                    HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                    HotForumModel.this.f18471g = hotForumHttpResponseMessage.getForumInfoList();
                    HotForumModel.this.i = hotForumHttpResponseMessage.getTopicInfoList();
                    HotForumModel.this.f18472h = hotForumHttpResponseMessage.getHotSearchInfo();
                    HotForumModel.this.j = hotForumHttpResponseMessage.getTopicInfoTitle();
                    HotForumModel.this.f18470f.onHotForumDataSuccess(HotForumModel.this.f18471g, HotForumModel.this.i, HotForumModel.this.f18472h, HotForumModel.this.j);
                }
                if (z) {
                    HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                    HotForumModel.this.f18471g = hotForumSocketResponseMessage.getForumInfoList();
                    HotForumModel.this.i = hotForumSocketResponseMessage.getTopicInfoList();
                    HotForumModel.this.f18472h = hotForumSocketResponseMessage.getSearchInfo();
                    HotForumModel.this.j = hotForumSocketResponseMessage.getTopicInfoTitle();
                    HotForumModel.this.f18470f.onHotForumDataSuccess(HotForumModel.this.f18471g, HotForumModel.this.i, HotForumModel.this.f18472h, HotForumModel.this.j);
                }
            } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                HotForumModel.this.f18470f.onHotForumDataFailed(responsedMessage.getErrorString());
            } else {
                HotForumModel.this.f18470f.onHotForumDataFailed(HotForumModel.this.f18469e.getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onHotForumDataFailed(String str);

        void onHotForumDataSuccess(List<d.b.j0.o1.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    public HotForumModel(f fVar, b bVar) {
        super(fVar);
        this.f18469e = fVar;
        this.f18470f = bVar;
        C();
    }

    public final void C() {
        registerListener(new a(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116));
    }

    public void D() {
        sendMessage(new HotForumNetMessage());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
