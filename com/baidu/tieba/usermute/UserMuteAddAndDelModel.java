package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
public class UserMuteAddAndDelModel extends com.baidu.adp.base.e {
    private com.baidu.tbadk.core.view.b bbk;
    private b dCX;
    private final HttpMessageListener eEA = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener eEB = new c(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String eEC = "";
    private com.baidu.adp.base.h eEv;
    private From eEw;
    private a eEx;
    private com.baidu.tbadk.core.view.h eEy;
    private com.baidu.tbadk.core.view.h eEz;
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (eEF) with 'values()' method */
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
        this.eEv = tbPageContext;
        aYn();
        aYo();
        this.eEA.setSelfListener(true);
        this.eEB.setSelfListener(true);
        this.eEv.registerListener(this.eEA);
        this.eEv.registerListener(this.eEB);
        this.eEy = new com.baidu.tbadk.core.view.h();
        this.eEz = new com.baidu.tbadk.core.view.h();
        this.eEz.afp = 1000L;
        this.eEy.afp = 1000L;
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.eEA);
        MessageManager.getInstance().unRegisterListener(this.eEB);
        this.eEy = null;
        this.eEz = null;
    }

    public void a(a aVar) {
        this.eEx = aVar;
    }

    public void a(b bVar) {
        this.dCX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, String str2, String str3) {
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
        this.eEv.sendMessage(httpMessage);
    }

    private void oH(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", 0);
        this.eEv.sendMessage(httpMessage);
    }

    private void aYn() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void aYo() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void k(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eEv.getPageActivity());
        aVar.cC(str4);
        aVar.a(t.j.confirm, new d(this, str2, str3));
        aVar.b(t.j.cancel, new e(this));
        aVar.b(this.eEv).up();
    }

    private void D(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eEv.getPageActivity());
        aVar.cC(this.eEv.getResources().getString(t.j.block_mute_message_alert, str));
        aVar.a(t.j.confirm, new f(this, str2, str3));
        aVar.b(t.j.cancel, new g(this));
        aVar.b(this.eEv).up();
    }

    public void fE(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eEv.getPageActivity());
        aVar.cC(str);
        aVar.b(t.j.know, new h(this));
        aVar.b(this.eEv).up();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.eEC = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.eEw = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                akp();
                oH(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            D(str2, str3, str4);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from, String str5) {
        this.eEC = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.eEw = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                akp();
                oH(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            k(str2, str3, str4, str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eEv.getPageActivity());
        aVar.cC(this.eEv.getResources().getString(t.j.mute_is_super_member_function));
        aVar.a(t.j.open_now, new i(this));
        aVar.b(t.j.cancel, new j(this));
        aVar.b(this.eEv).up();
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
    public void akp() {
        if (this.bbk == null) {
            this.bbk = new com.baidu.tbadk.core.view.b((TbPageContext) this.eEv);
            this.bbk.c(new com.baidu.tieba.usermute.b(this));
        }
        this.bbk.ay(true);
    }
}
