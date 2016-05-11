package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
public class UserMuteAddAndDelModel extends com.baidu.adp.base.e {
    private com.baidu.tbadk.core.view.b aXt;
    private b dGf;
    private com.baidu.adp.base.h eVc;
    private From eVd;
    private a eVe;
    private com.baidu.tbadk.core.view.h eVf;
    private com.baidu.tbadk.core.view.h eVg;
    private final HttpMessageListener eVh = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener eVi = new c(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String eVj = "";
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (eVm) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static From[] valuesCustom() {
            From[] valuesCustom = values();
            int length = valuesCustom.length;
            From[] fromArr = new From[length];
            System.arraycopy(valuesCustom, 0, fromArr, 0, length);
            return fromArr;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(UserMuteAddResponseMessage userMuteAddResponseMessage);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(UserMuteDelResponseMessage userMuteDelResponseMessage);
    }

    public UserMuteAddAndDelModel(TbPageContext tbPageContext) {
        this.eVc = tbPageContext;
        baE();
        baF();
        this.eVh.setSelfListener(true);
        this.eVi.setSelfListener(true);
        this.eVc.registerListener(this.eVh);
        this.eVc.registerListener(this.eVi);
        this.eVf = new com.baidu.tbadk.core.view.h();
        this.eVg = new com.baidu.tbadk.core.view.h();
        this.eVg.aaO = 1000L;
        this.eVf.aaO = 1000L;
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.eVh);
        MessageManager.getInstance().unRegisterListener(this.eVi);
        this.eVf = null;
        this.eVg = null;
    }

    public void a(a aVar) {
        this.eVe = aVar;
    }

    public void a(b bVar) {
        this.dGf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_ADD);
        httpMessage.addParam("mute_user", str);
        if (str2 != null) {
            httpMessage.addParam("thread_id", str2);
        }
        if (str3 != null) {
            httpMessage.addParam("post_id", str3);
        }
        httpMessage.addParam("mute_type", 0);
        httpMessage.setExtra(str);
        this.eVc.sendMessage(httpMessage);
    }

    private void oW(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", 0);
        this.eVc.sendMessage(httpMessage);
    }

    private void baE() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void baF() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void l(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVc.getPageActivity());
        if (ay.isEmpty(str4)) {
            aVar.cA(this.eVc.getResources().getString(t.j.block_mute_message_alert, str));
        } else {
            aVar.cA(str4);
        }
        aVar.a(t.j.confirm, new d(this, str2, str3));
        aVar.b(t.j.cancel, new e(this));
        aVar.b(this.eVc).rU();
    }

    private void E(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVc.getPageActivity());
        aVar.cA(this.eVc.getResources().getString(t.j.block_mute_message_alert, str));
        aVar.a(t.j.confirm, new f(this, str2, str3));
        aVar.b(t.j.cancel, new g(this));
        aVar.b(this.eVc).rU();
    }

    public void fB(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVc.getPageActivity());
        aVar.cA(str);
        aVar.b(t.j.know, new h(this));
        aVar.b(this.eVc).rU();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.eVj = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.eVd = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                akv();
                oW(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            E(str2, str3, str4);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from, String str5) {
        this.eVj = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.eVd = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                akv();
                oW(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            l(str2, str3, str4, str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eVc.getPageActivity());
        aVar.cA(this.eVc.getResources().getString(t.j.mute_is_super_member_function));
        aVar.a(t.j.open_now, new i(this));
        aVar.b(t.j.cancel, new j(this));
        aVar.b(this.eVc).rU();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.aXt == null) {
            this.aXt = new com.baidu.tbadk.core.view.b((TbPageContext) this.eVc);
            this.aXt.c(new com.baidu.tieba.usermute.b(this));
        }
        this.aXt.aD(true);
    }
}
