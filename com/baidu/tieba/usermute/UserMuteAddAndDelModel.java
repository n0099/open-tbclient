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
    private com.baidu.tbadk.core.view.b aUt;
    private b cWL;
    private com.baidu.adp.base.h dQl;
    private From dQm;
    private a dQn;
    private com.baidu.tbadk.core.view.h dQo;
    private com.baidu.tbadk.core.view.h dQp;
    private final HttpMessageListener dQq = new com.baidu.tieba.usermute.a(this, CmdConfigHttp.CMD_USER_MUTE_ADD);
    private final HttpMessageListener dQr = new com.baidu.tieba.usermute.b(this, CmdConfigHttp.CMD_USER_MUTE_DEL);
    private String dQs = "";
    private String mUserId;

    /* loaded from: classes.dex */
    public enum From {
        PB,
        PersonInfo,
        Setting;

        /* JADX DEBUG: Replace access to removed values field (dQu) with 'values()' method */
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
        this.dQl = tbPageContext;
        aIX();
        aIY();
        this.dQq.setSelfListener(true);
        this.dQr.setSelfListener(true);
        this.dQl.registerListener(this.dQq);
        this.dQl.registerListener(this.dQr);
        this.dQo = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.dQp = new com.baidu.tbadk.core.view.h(tbPageContext);
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.dQq);
        MessageManager.getInstance().unRegisterListener(this.dQr);
        this.dQo = null;
        this.dQp = null;
    }

    public void a(a aVar) {
        this.dQn = aVar;
    }

    public void a(b bVar) {
        this.cWL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, String str2, String str3) {
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
        this.dQl.sendMessage(httpMessage);
    }

    private void nb(String str) {
        this.mUserId = str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", (Object) 0);
        this.dQl.sendMessage(httpMessage);
    }

    private void aIX() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void aIY() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void z(String str, String str2, String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dQl.getPageActivity());
        aVar.cF(this.dQl.getResources().getString(n.j.block_mute_message_alert, str));
        aVar.a(n.j.confirm, new c(this, str2, str3));
        aVar.b(n.j.cancel, new d(this));
        aVar.b(this.dQl).tf();
    }

    public void fy(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dQl.getPageActivity());
        aVar.cF(str);
        aVar.b(n.j.know, new e(this));
        aVar.b(this.dQl).tf();
    }

    public void a(boolean z, String str, String str2, String str3, String str4, From from) {
        this.dQs = str;
        if (str2 == null) {
            str2 = "";
        }
        if (from != null) {
            this.dQm = from;
            if (z) {
                if (from == From.PB) {
                    TiebaStatic.log("c10024");
                } else if (from == From.PersonInfo) {
                    TiebaStatic.log("c10037");
                } else if (from == From.Setting) {
                    TiebaStatic.log("c10047");
                }
                adL();
                nb(str);
                return;
            }
            if (from == From.PB) {
                TiebaStatic.log("c10012");
            } else if (from == From.PersonInfo) {
                TiebaStatic.log("c10036");
            }
            z(str2, str3, str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dQl.getPageActivity());
        aVar.cF(this.dQl.getResources().getString(n.j.mute_is_super_member_function));
        aVar.a(n.j.open_now, new f(this));
        aVar.b(n.j.cancel, new g(this));
        aVar.b(this.dQl).tf();
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
    public void adL() {
        if (this.aUt == null) {
            this.aUt = new com.baidu.tbadk.core.view.b((TbPageContext) this.dQl);
            this.aUt.b(new h(this));
            return;
        }
        this.aUt.av(true);
    }
}
