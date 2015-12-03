package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
public class UserMuteAddAndDelModel extends com.baidu.adp.base.e {
    private com.baidu.tbadk.core.view.b aQC;
    private b cSg;
    private com.baidu.adp.base.h dIK;
    private From dIL;
    private a dIM;
    private com.baidu.tbadk.core.view.g dIN;
    private com.baidu.tbadk.core.view.g dIO;
    private final HttpMessageListener dIP = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener dIQ = new com.baidu.tieba.usermute.b(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String dIR = "";
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (dIT) with 'values()' method */
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
        this.dIK = tbPageContext;
        aGD();
        aGE();
        this.dIP.setSelfListener(true);
        this.dIQ.setSelfListener(true);
        this.dIK.registerListener(this.dIP);
        this.dIK.registerListener(this.dIQ);
        this.dIN = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.dIO = new com.baidu.tbadk.core.view.g(tbPageContext);
    }

    public void a(a aVar) {
        this.dIM = aVar;
    }

    public void a(b bVar) {
        this.cSg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_ADD);
        httpMessage.addParam("mute_user", str);
        if (str2 != null) {
            httpMessage.addParam("thread_id", str2);
        }
        if (str3 != null) {
            httpMessage.addParam("post_id", str3);
        }
        httpMessage.addParam("mute_type", (Object) 0);
        httpMessage.setExtra(str);
        this.dIK.sendMessage(httpMessage);
    }

    private void nc(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", (Object) 0);
        this.dIK.sendMessage(httpMessage);
    }

    private void aGD() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void aGE() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void y(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIK.getPageActivity());
        aVar.cC(this.dIK.getResources().getString(n.i.block_mute_message_alert, str));
        aVar.a(n.i.confirm, new c(this, str2, str3));
        aVar.b(n.i.cancel, new d(this));
        aVar.b(this.dIK).tv();
    }

    public void fu(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIK.getPageActivity());
        aVar.cC(str);
        aVar.b(n.i.know, new e(this));
        aVar.b(this.dIK).tv();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.dIR = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.dIL = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                acC();
                nc(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            y(str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIK.getPageActivity());
        aVar.cC(this.dIK.getResources().getString(n.i.mute_is_super_member_function));
        aVar.a(n.i.open_now, new f(this));
        aVar.b(n.i.cancel, new g(this));
        aVar.b(this.dIK).tv();
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
    public void acC() {
        if (this.aQC == null) {
            this.aQC = new com.baidu.tbadk.core.view.b((TbPageContext) this.dIK);
            this.aQC.b(new h(this));
            return;
        }
        this.aQC.ay(true);
    }
}
