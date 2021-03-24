package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import d.b.b.a.f;
import d.b.i0.n1.c;
import java.util.List;
/* loaded from: classes3.dex */
public class HotForumModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public f f18783e;

    /* renamed from: f  reason: collision with root package name */
    public b f18784f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.b.i0.n1.b> f18785g;

    /* renamed from: h  reason: collision with root package name */
    public HotSearchInfoData f18786h;
    public List<c> i;
    public String j;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof HotForumSocketResponseMessage;
            if (!z && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                HotForumModel.this.f18784f.onHotForumDataFailed(HotForumModel.this.f18783e.getString(R.string.neterror));
            } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                HotForumModel.this.f18784f.onHotForumDataFailed(HotForumModel.this.f18783e.getString(R.string.neterror));
            } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof HotForumHttpResponseMessage) {
                    HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                    HotForumModel.this.f18785g = hotForumHttpResponseMessage.getForumInfoList();
                    HotForumModel.this.i = hotForumHttpResponseMessage.getTopicInfoList();
                    HotForumModel.this.f18786h = hotForumHttpResponseMessage.getHotSearchInfo();
                    HotForumModel.this.j = hotForumHttpResponseMessage.getTopicInfoTitle();
                    HotForumModel.this.f18784f.onHotForumDataSuccess(HotForumModel.this.f18785g, HotForumModel.this.i, HotForumModel.this.f18786h, HotForumModel.this.j);
                }
                if (z) {
                    HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                    HotForumModel.this.f18785g = hotForumSocketResponseMessage.getForumInfoList();
                    HotForumModel.this.i = hotForumSocketResponseMessage.getTopicInfoList();
                    HotForumModel.this.f18786h = hotForumSocketResponseMessage.getSearchInfo();
                    HotForumModel.this.j = hotForumSocketResponseMessage.getTopicInfoTitle();
                    HotForumModel.this.f18784f.onHotForumDataSuccess(HotForumModel.this.f18785g, HotForumModel.this.i, HotForumModel.this.f18786h, HotForumModel.this.j);
                }
            } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                HotForumModel.this.f18784f.onHotForumDataFailed(responsedMessage.getErrorString());
            } else {
                HotForumModel.this.f18784f.onHotForumDataFailed(HotForumModel.this.f18783e.getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onHotForumDataFailed(String str);

        void onHotForumDataSuccess(List<d.b.i0.n1.b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    public HotForumModel(f fVar, b bVar) {
        super(fVar);
        this.f18783e = fVar;
        this.f18784f = bVar;
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
