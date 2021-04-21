package com.baidu.tieba.userconsume.usermute;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckRequestMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes5.dex */
public class UserMuteAddAndDelStatic {

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Object> {

        /* renamed from: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0228a extends HttpMessageListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ UserMuteAddAndDelCustomMessage f21384a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0228a(a aVar, int i, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
                super(i);
                this.f21384a = userMuteAddAndDelCustomMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016304));
                        int i = this.f21384a.from;
                        if (i == 1) {
                            TiebaStatic.log("c10034");
                        } else if (i == 0) {
                            TiebaStatic.log("c10043");
                        }
                    }
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001427, userMuteAddResponseMessage);
                    customResponsedMessage.setOrginalMessage(this.f21384a);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b extends HttpMessageListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ UserMuteAddAndDelCustomMessage f21385a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(a aVar, int i, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
                super(i);
                this.f21385a = userMuteAddAndDelCustomMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016303));
                    }
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001428, userMuteDelResponseMessage);
                    customResponsedMessage.setOrginalMessage(this.f21385a);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (customMessage == null || !(customMessage instanceof UserMuteAddAndDelCustomMessage)) {
                return null;
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = (UserMuteAddAndDelCustomMessage) customMessage;
            C0228a c0228a = new C0228a(this, CmdConfigHttp.CMD_USER_MUTE_ADD, userMuteAddAndDelCustomMessage);
            b bVar = new b(this, CmdConfigHttp.CMD_USER_MUTE_DEL, userMuteAddAndDelCustomMessage);
            c0228a.setSelfListener(true);
            c0228a.setTag(userMuteAddAndDelCustomMessage.mId);
            bVar.setSelfListener(true);
            bVar.setTag(userMuteAddAndDelCustomMessage.mId);
            MessageManager.getInstance().registerListener(c0228a);
            MessageManager.getInstance().registerListener(bVar);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage;
            int i;
            if (customMessage == null || !(customMessage instanceof UserMuteAddAndDelCustomMessage) || (i = (userMuteAddAndDelCustomMessage = (UserMuteAddAndDelCustomMessage) customMessage).from) == -1) {
                return null;
            }
            if (userMuteAddAndDelCustomMessage.isMute) {
                if (i == 1) {
                    TiebaStatic.log("c10024");
                } else if (i == 0) {
                    TiebaStatic.log("c10037");
                } else if (i == 2) {
                    TiebaStatic.log("c10047");
                }
                UserMuteAddAndDelStatic.k(userMuteAddAndDelCustomMessage.muteUserId, userMuteAddAndDelCustomMessage.mId);
            } else {
                if (i == 1) {
                    TiebaStatic.log("c10012");
                } else if (i == 0) {
                    TiebaStatic.log("c10036");
                }
                UserMuteAddAndDelStatic.j(userMuteAddAndDelCustomMessage.muteUserId, userMuteAddAndDelCustomMessage.threadId, userMuteAddAndDelCustomMessage.postId, userMuteAddAndDelCustomMessage.mId);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (customMessage == null || !(customMessage instanceof UserMuteCheckCustomMessage)) {
                return null;
            }
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = (UserMuteCheckCustomMessage) customMessage;
            UserMuteCheckRequestMessage userMuteCheckRequestMessage = new UserMuteCheckRequestMessage();
            userMuteCheckRequestMessage.setUserIdF(userMuteCheckCustomMessage.userIdF);
            userMuteCheckRequestMessage.setUserIdT(userMuteCheckCustomMessage.userIdT);
            userMuteCheckRequestMessage.setTag(userMuteCheckCustomMessage.mId);
            userMuteCheckRequestMessage.mTagId = userMuteCheckCustomMessage.mId;
            MessageManager.getInstance().sendMessage(userMuteCheckRequestMessage);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Object> {

        /* loaded from: classes5.dex */
        public class a extends d.b.c.c.g.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ UserMuteCheckCustomMessage f21386a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i, int i2, UserMuteCheckCustomMessage userMuteCheckCustomMessage) {
                super(i, i2);
                this.f21386a = userMuteCheckCustomMessage;
            }

            @Override // d.b.c.c.g.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                d.b.j0.o3.a aVar = new d.b.j0.o3.a();
                if (responsedMessage instanceof UserMuteCheckSocketResponsedMessage) {
                    UserMuteCheckSocketResponsedMessage userMuteCheckSocketResponsedMessage = (UserMuteCheckSocketResponsedMessage) responsedMessage;
                    aVar.f59277a = userMuteCheckSocketResponsedMessage.getResult();
                    aVar.f59279c = userMuteCheckSocketResponsedMessage.getError();
                    aVar.f59278b = userMuteCheckSocketResponsedMessage.getErrorString();
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001426, aVar);
                    customResponsedMessage.setOrginalMessage(this.f21386a);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (responsedMessage instanceof UserMuteCheckHttpResponsedMessage) {
                    UserMuteCheckHttpResponsedMessage userMuteCheckHttpResponsedMessage = (UserMuteCheckHttpResponsedMessage) responsedMessage;
                    aVar.f59277a = userMuteCheckHttpResponsedMessage.getResult();
                    aVar.f59279c = userMuteCheckHttpResponsedMessage.getError();
                    aVar.f59278b = userMuteCheckHttpResponsedMessage.getErrorString();
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001426, aVar);
                    customResponsedMessage2.setOrginalMessage(this.f21386a);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (customMessage == null || !(customMessage instanceof UserMuteCheckCustomMessage)) {
                return null;
            }
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = (UserMuteCheckCustomMessage) customMessage;
            a aVar = new a(this, CmdConfigHttp.CMD_USER_MUTE_CHECK, 303040, userMuteCheckCustomMessage);
            aVar.getHttpMessageListener().setSelfListener(true);
            aVar.getSocketMessageListener().setSelfListener(true);
            aVar.setTag(userMuteCheckCustomMessage.mId);
            MessageManager.getInstance().registerListener(aVar);
            return null;
        }
    }

    static {
        d();
        h();
        e();
        c();
        g();
        i();
        f();
    }

    public static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001431, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void d() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, TbConfig.SERVER_ADDRESS + TbConfig.USER_MUTE_ADD);
        tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001430, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001432, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void g() {
        d.b.j0.d3.d0.a.f(303040, UserMuteCheckSocketResponsedMessage.class, false);
        d.b.j0.d3.d0.a.c(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    public static void h() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, TbConfig.SERVER_ADDRESS + TbConfig.USER_MUTE_DEL);
        tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void i() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001429, new c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void j(String str, String str2, String str3, BdUniqueId bdUniqueId) {
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
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public static void k(String str, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
        httpMessage.addParam("mute_user", str);
        httpMessage.addParam("mute_type", 0);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
