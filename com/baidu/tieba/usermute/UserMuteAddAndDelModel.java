package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.n;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
public class UserMuteAddAndDelModel<T> extends com.baidu.adp.base.e<T> {
    public static int cOL = 0;
    private com.baidu.tbadk.core.view.a aMv;
    private BaseActivity<?> aSJ;
    private From cOM;
    private a cON;
    private n cOO;
    private n cOP;
    private final HttpMessageListener cOQ = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener cOR = new com.baidu.tieba.usermute.b(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String cOS = "";
    private b clN;
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (cOV) with 'values()' method */
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tbadk.BaseActivity<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public UserMuteAddAndDelModel(BaseActivity<T> baseActivity) {
        this.aSJ = baseActivity;
        ati();
        atj();
        this.cOQ.setSelfListener(true);
        this.cOR.setSelfListener(true);
        this.aSJ.registerListener(this.cOQ);
        this.aSJ.registerListener(this.cOR);
        this.cOO = new n(baseActivity.getPageContext());
        this.cOP = new n(baseActivity.getPageContext());
    }

    public void a(a aVar) {
        this.cON = aVar;
    }

    public void a(b bVar) {
        this.clN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, String str3) {
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
        this.aSJ.sendMessage(httpMessage);
    }

    private void kQ(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", (Object) 0);
        this.aSJ.sendMessage(httpMessage);
    }

    private void ati() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void atj() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void t(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSJ.getPageContext().getPageActivity());
        aVar.cn(this.aSJ.getResources().getString(i.C0057i.block_mute_message_alert, str));
        aVar.a(i.C0057i.confirm, new c(this, str2, str3));
        aVar.b(i.C0057i.cancel, new d(this));
        aVar.b(this.aSJ.getPageContext()).sP();
    }

    public void eQ(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSJ.getPageContext().getPageActivity());
        aVar.cn(str);
        aVar.b(i.C0057i.know, new e(this));
        aVar.b(this.aSJ.getPageContext()).sP();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.cOS = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.cOM = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log(m.cPb);
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log(m.cPg);
                }
                Yv();
                kQ(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log(m.cPc);
            } else if (from == From.PersonInfo) {
                TiebaStatic.log(m.cPf);
            } else if (from == From.Setting) {
                TiebaStatic.log(m.cPk);
            }
            t(str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSJ.getPageContext().getPageActivity());
        aVar.cn(this.aSJ.getResources().getString(i.C0057i.mute_is_super_member_function));
        aVar.a(i.C0057i.open_now, new f(this));
        aVar.b(i.C0057i.cancel, new g(this));
        aVar.b(this.aSJ.getPageContext()).sP();
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
    public void Yv() {
        if (this.aMv == null) {
            this.aMv = new com.baidu.tbadk.core.view.a(this.aSJ.getPageContext());
            this.aMv.b(new h(this));
            return;
        }
        this.aMv.av(true);
    }
}
