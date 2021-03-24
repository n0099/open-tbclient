package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.MsgReplyCardViewItemAdapter;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.imMessageCenter.mention.AtMessageActivity;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationActivity;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationActivityConfig;
import com.baidu.tieba.imMessageCenter.mention.reply.ReplyMeActivity;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import d.b.h0.z0.n0;
import d.b.i0.d1.h.m;
import d.b.i0.e1.b.j;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class PersonalChatActivityStatic {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.i0.e1.a.b.b.e f18189a;

    /* renamed from: b  reason: collision with root package name */
    public static CustomMessageListener f18190b = new a(2005016);

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            d.b.i0.e1.a.b.b.e unused = PersonalChatActivityStatic.f18189a = null;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<PersonalChatActivityConfig> {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LinkedList f18191a;

            public a(b bVar, LinkedList linkedList) {
                this.f18191a = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                return m.t().a(this.f18191a);
            }
        }

        /* renamed from: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0199b implements n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CustomMessage f18192a;

            public C0199b(b bVar, CustomMessage customMessage) {
                this.f18192a = customMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r5) {
                ((PersonalChatActivityConfig) this.f18192a.getData()).getIntent();
                if (((PersonalChatActivityConfig) this.f18192a.getData()).getUserData().getUserIdLong() == 0) {
                    return;
                }
                ((PersonalChatActivityConfig) this.f18192a.getData()).startActivity(PersonalChatActivity.class);
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<PersonalChatActivityConfig> run(CustomMessage<PersonalChatActivityConfig> customMessage) {
            UserData userData;
            if (customMessage == null || customMessage.getData() == null || (userData = customMessage.getData().getUserData()) == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(userData.getUserId()));
            h0.c(new a(this, linkedList), new C0199b(this, customMessage));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst().getContext())) {
                        String c2 = n0.c(str, "userid=");
                        String c3 = n0.c(str, "username=");
                        String c4 = n0.c(str, "portrait=");
                        if (c2 != null && c2.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(c2), c3, c3, c4, 0)));
                                return 1;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return 1;
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getPageActivity(), 2)));
                        return 1;
                    }
                    return 0;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<IMBlackListActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<IMBlackListActivityConfig> run(CustomMessage<IMBlackListActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(IMBlackListActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbPageContext<MsglistActivity<?>> tbPageContext;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f17762b == null || (tbPageContext = aVar.f17761a) == null) {
                return;
            }
            MsgReplyCardViewItemAdapter msgReplyCardViewItemAdapter = new MsgReplyCardViewItemAdapter(tbPageContext, ChatMessage.TYPE_MSG_REPLY_CARD);
            msgReplyCardViewItemAdapter.m0(true);
            aVar.f17762b.add(msgReplyCardViewItemAdapter);
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                j.e().i();
            } else {
                j.e().d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.isLogin()) {
                j.e().f();
            } else {
                j.e().d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return 3;
            }
            String str = strArr[0];
            if (str.contains(UrlSchemaHelper.JUMP_TO_CHAT) || str.contains(UrlSchemaHelper.HTTPS_JUMP_TO_CHAT)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getContext(), 1)));
                return 0;
            }
            return 3;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonalMsgImageActivityConfig.class, PersonalMsgImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MessageCenterActivityConfig.class, MessageCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtMessageActivityConfig.class, AtMessageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ReplyMeActivityConfig.class, ReplyMeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AgreeMeActivityConfig.class, AgreeMeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectFriendActivityConfig.class, SelectFriendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(OfficialNotificationActivityConfig.class, OfficialNotificationActivity.class);
        d.b.i0.d1.c.b(205101, ResponsePersonalLbsInfoMessage.class, false);
        d.b.i0.d1.c.b(205001, ResponseCommitPersonalMessage.class, false);
        d.b.i0.d1.c.b(205003, ResponseQueryUserInfoMessage.class, false);
        d.b.i0.d1.c.b(205006, ResponsedPersonalMsgReadMessage.class, false);
        d.b.i0.d1.c.a(2001143, d.b.i0.e1.a.b.b.b.class);
        d.b.i0.d1.c.a(2001146, d.b.i0.e1.a.b.b.d.class);
        d.b.i0.d1.c.a(2001149, d.b.i0.e1.a.b.b.c.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_LIST, TbConfig.SERVER_ADDRESS + "c/u/follow/list");
        tbHttpMessageTask.setResponsedClass(ResponseFriendListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        c();
        MessageManager.getInstance().registerListener(f18190b);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().addListener(new c());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2008001, new d());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerListener(new e(2001275));
        MessageManager.getInstance().registerListener(new f(2001011));
        MessageManager.getInstance().registerListener(new g(2005016));
    }

    public static d.b.i0.e1.a.b.b.e b() {
        return f18189a;
    }

    public static void c() {
        UrlManager.getInstance().addListener(new h());
    }

    public static void d(d.b.i0.e1.a.b.b.e eVar) {
        f18189a = eVar;
    }
}
