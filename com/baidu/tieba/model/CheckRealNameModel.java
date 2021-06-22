package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
/* loaded from: classes4.dex */
public class CheckRealNameModel extends BdBaseModel {
    public static final String TYPE_APP_FIRST_START = "app_first_start";
    public static final String TYPE_LIVE_SHARE = "live_share";
    public static final String TYPE_PB_SHARE = "pb_share";

    /* renamed from: e  reason: collision with root package name */
    public b f18501e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f18502f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof CheckRealNameHttpResponseMessage) || (responsedMessage instanceof CheckRealNameSocketResponseMessage)) && (responsedMessage.getOrginalMessage().getExtra() instanceof CheckRealNameRequestNetMessage)) {
                CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = (CheckRealNameRequestNetMessage) responsedMessage.getOrginalMessage().getExtra();
                if (CheckRealNameModel.this.f18501e != null) {
                    CheckRealNameModel.this.f18501e.a(responsedMessage.getError(), responsedMessage.getErrorString(), checkRealNameRequestNetMessage.getObjSource(), checkRealNameRequestNetMessage.getObjTag());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, String str2, Object obj);
    }

    public CheckRealNameModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f18502f = new a(CmdConfigHttp.CMD_CHECK_REAL_NAME, 309456);
        z();
        registerListener(this.f18502f);
    }

    public void A(b bVar) {
        this.f18501e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void x(String str) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public void y(String str, Object obj) {
        CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
        checkRealNameRequestNetMessage.setObjSource(str);
        checkRealNameRequestNetMessage.setObjTag(obj);
        sendMessage(checkRealNameRequestNetMessage);
    }

    public final void z() {
        d.a.o0.e3.d0.a.h(309456, CheckRealNameSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(309456, CmdConfigHttp.CMD_CHECK_REAL_NAME, TbConfig.URL_CHECK_REAL_NAME, CheckRealNameHttpResponseMessage.class, false, false, false, false);
    }
}
