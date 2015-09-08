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
    public static int cXs = 0;
    private com.baidu.tbadk.core.view.a aMI;
    private BaseActivity<?> aSX;
    private From cXt;
    private a cXu;
    private n cXv;
    private n cXw;
    private final HttpMessageListener cXx = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener cXy = new com.baidu.tieba.usermute.b(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String cXz = "";
    private b cmQ;
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (cXC) with 'values()' method */
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
        this.aSX = baseActivity;
        axB();
        axC();
        this.cXx.setSelfListener(true);
        this.cXy.setSelfListener(true);
        this.aSX.registerListener(this.cXx);
        this.aSX.registerListener(this.cXy);
        this.cXv = new n(baseActivity.getPageContext());
        this.cXw = new n(baseActivity.getPageContext());
    }

    public void a(a aVar) {
        this.cXu = aVar;
    }

    public void a(b bVar) {
        this.cmQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, String str2, String str3) {
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
        this.aSX.sendMessage(httpMessage);
    }

    private void lx(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", (Object) 0);
        this.aSX.sendMessage(httpMessage);
    }

    private void axB() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void axC() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void u(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSX.getPageContext().getPageActivity());
        aVar.ct(this.aSX.getResources().getString(i.h.block_mute_message_alert, str));
        aVar.a(i.h.confirm, new c(this, str2, str3));
        aVar.b(i.h.cancel, new d(this));
        aVar.b(this.aSX.getPageContext()).sU();
    }

    public void eY(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSX.getPageContext().getPageActivity());
        aVar.ct(str);
        aVar.b(i.h.know, new e(this));
        aVar.b(this.aSX.getPageContext()).sU();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.cXz = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.cXt = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log(m.cXI);
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log(m.cXO);
                } else if (from == From.Setting) {
                    TiebaStatic.log(m.cXU);
                }
                Yx();
                lx(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log(m.cXJ);
            } else if (from == From.PersonInfo) {
                TiebaStatic.log(m.cXN);
            }
            u(str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aSX.getPageContext().getPageActivity());
        aVar.ct(this.aSX.getResources().getString(i.h.mute_is_super_member_function));
        aVar.a(i.h.open_now, new f(this));
        aVar.b(i.h.cancel, new g(this));
        aVar.b(this.aSX.getPageContext()).sU();
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
    public void Yx() {
        if (this.aMI == null) {
            this.aMI = new com.baidu.tbadk.core.view.a(this.aSX.getPageContext());
            this.aMI.b(new h(this));
            return;
        }
        this.aMI.av(true);
    }
}
