package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
public class UserMuteAddAndDelModel<T> extends com.baidu.adp.base.e<T> {
    private com.baidu.tbadk.core.view.a aLW;
    private BaseActivity<?> aSm;
    private b cud;
    private From dkA;
    private a dkB;
    private com.baidu.tbadk.core.view.f dkC;
    private com.baidu.tbadk.core.view.f dkD;
    private final HttpMessageListener dkE = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener dkF = new com.baidu.tieba.usermute.b(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String dkG = "";
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (dkI) with 'values()' method */
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
        this.aSm = baseActivity;
        aBs();
        aBt();
        this.dkE.setSelfListener(true);
        this.dkF.setSelfListener(true);
        this.aSm.registerListener(this.dkE);
        this.aSm.registerListener(this.dkF);
        this.dkC = new com.baidu.tbadk.core.view.f(baseActivity.getPageContext());
        this.dkD = new com.baidu.tbadk.core.view.f(baseActivity.getPageContext());
    }

    public void a(a aVar) {
        this.dkB = aVar;
    }

    public void a(b bVar) {
        this.cud = bVar;
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
        this.aSm.sendMessage(httpMessage);
    }

    private void mi(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", (Object) 0);
        this.aSm.sendMessage(httpMessage);
    }

    private void aBs() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void aBt() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void t(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSm.getPageContext().getPageActivity());
        aVar.cu(this.aSm.getResources().getString(i.h.block_mute_message_alert, str));
        aVar.a(i.h.confirm, new c(this, str2, str3));
        aVar.b(i.h.cancel, new d(this));
        aVar.b(this.aSm.getPageContext()).sR();
    }

    public void ff(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSm.getPageContext().getPageActivity());
        aVar.cu(str);
        aVar.b(i.h.know, new e(this));
        aVar.b(this.aSm.getPageContext()).sR();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.dkG = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.dkA = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                Zw();
                mi(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            t(str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSm.getPageContext().getPageActivity());
        aVar.cu(this.aSm.getResources().getString(i.h.mute_is_super_member_function));
        aVar.a(i.h.open_now, new f(this));
        aVar.b(i.h.cancel, new g(this));
        aVar.b(this.aSm.getPageContext()).sR();
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
    public void Zw() {
        if (this.aLW == null) {
            this.aLW = new com.baidu.tbadk.core.view.a(this.aSm.getPageContext());
            this.aLW.b(new h(this));
            return;
        }
        this.aLW.av(true);
    }
}
