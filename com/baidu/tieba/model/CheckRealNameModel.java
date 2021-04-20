package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
/* loaded from: classes3.dex */
public class CheckRealNameModel extends BdBaseModel {
    public static final String TYPE_APP_FIRST_START = "app_first_start";
    public static final String TYPE_LIVE_SHARE = "live_share";
    public static final String TYPE_PB_SHARE = "pb_share";

    /* renamed from: e  reason: collision with root package name */
    public b f18710e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f18711f;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof CheckRealNameHttpResponseMessage) || (responsedMessage instanceof CheckRealNameSocketResponseMessage)) && (responsedMessage.getOrginalMessage().getExtra() instanceof CheckRealNameRequestNetMessage)) {
                CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = (CheckRealNameRequestNetMessage) responsedMessage.getOrginalMessage().getExtra();
                if (CheckRealNameModel.this.f18710e != null) {
                    CheckRealNameModel.this.f18710e.a(responsedMessage.getError(), responsedMessage.getErrorString(), checkRealNameRequestNetMessage.getObjSource(), checkRealNameRequestNetMessage.getObjTag());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str, String str2, Object obj);
    }

    public CheckRealNameModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f18711f = new a(CmdConfigHttp.CMD_CHECK_REAL_NAME, 309456);
        v();
        registerListener(this.f18711f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void t(String str) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public void u(String str, Object obj) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        checkRealNameRequestNetMessage.setObjTag(obj);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public final void v() {
        d.b.i0.d3.d0.a.h(309456, CheckRealNameSocketResponseMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309456, CmdConfigHttp.CMD_CHECK_REAL_NAME, TbConfig.URL_CHECK_REAL_NAME, CheckRealNameHttpResponseMessage.class, false, false, false, false);
    }

    public void w(b bVar) {
        this.f18710e = bVar;
    }
}
