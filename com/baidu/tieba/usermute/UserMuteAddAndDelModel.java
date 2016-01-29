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
    private com.baidu.tbadk.core.view.b aWB;
    private b diw;
    private com.baidu.adp.base.h ekV;
    private From ekW;
    private a ekX;
    private com.baidu.tbadk.core.view.h ekY;
    private com.baidu.tbadk.core.view.h ekZ;
    private final HttpMessageListener ela = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener elb = new com.baidu.tieba.usermute.b(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String elc = "";
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (elf) with 'values()' method */
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
        this.ekV = tbPageContext;
        aRN();
        aRO();
        this.ela.setSelfListener(true);
        this.elb.setSelfListener(true);
        this.ekV.registerListener(this.ela);
        this.ekV.registerListener(this.elb);
        this.ekY = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.ekZ = new com.baidu.tbadk.core.view.h(tbPageContext);
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.ela);
        MessageManager.getInstance().unRegisterListener(this.elb);
        this.ekY = null;
        this.ekZ = null;
    }

    public void a(a aVar) {
        this.ekX = aVar;
    }

    public void a(b bVar) {
        this.diw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, String str3) {
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
        this.ekV.sendMessage(httpMessage);
    }

    private void nv(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", (Object) 0);
        this.ekV.sendMessage(httpMessage);
    }

    private void aRN() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void aRO() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void B(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ekV.getPageActivity());
        aVar.cE(this.ekV.getResources().getString(t.j.block_mute_message_alert, str));
        aVar.a(t.j.confirm, new c(this, str2, str3));
        aVar.b(t.j.cancel, new d(this));
        aVar.b(this.ekV).uj();
    }

    public void fw(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ekV.getPageActivity());
        aVar.cE(str);
        aVar.b(t.j.know, new e(this));
        aVar.b(this.ekV).uj();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.elc = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.ekW = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                agV();
                nv(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            B(str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ekV.getPageActivity());
        aVar.cE(this.ekV.getResources().getString(t.j.mute_is_super_member_function));
        aVar.a(t.j.open_now, new f(this));
        aVar.b(t.j.cancel, new g(this));
        aVar.b(this.ekV).uj();
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
    public void agV() {
        if (this.aWB == null) {
            this.aWB = new com.baidu.tbadk.core.view.b((TbPageContext) this.ekV);
            this.aWB.b(new h(this));
            return;
        }
        this.aWB.aw(true);
    }
}
