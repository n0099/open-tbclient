package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.g;
/* loaded from: classes2.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView awO;
    private com.baidu.adp.framework.listener.c dGA = new com.baidu.adp.framework.listener.c(104106) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            int i = 0;
            if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
                RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
                boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.yv().getMsgChat();
                int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yv().getMsgReplyme();
                int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yv().getMsgAtme();
                int yC = com.baidu.tbadk.coreExtra.messageCenter.a.yv().yC();
                e yQ = com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ();
                if (yQ != null && flag) {
                    i = yQ.Ac();
                }
                ImMessageCenterDelegateStatic.n(ImMessageCenterDelegateStatic.this.awO, (((msgChat - i) + msgReplyme) + msgAtme) - yC);
            }
        }
    };
    private CustomMessageListener dGz;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Et() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        g gVar = new g();
        gVar.gY(true);
        cVar.aGi = gVar;
        cVar.type = 3;
        cVar.aGj = d.l.my_message;
        cVar.aGk = d.g.s_tabbar_icon_three_bg;
        cVar.aGq = com.baidu.tbadk.mainTab.c.aGn;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e aY(Context context) {
        this.aFZ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.awO = (TextView) LayoutInflater.from(context).inflate(d.j.message_tip_item, (ViewGroup) null);
        e.a aVar = new e.a();
        aVar.aGD = this.aFZ;
        aVar.ur = l.dip2px(context, 3.0f);
        aVar.view = this.awO;
        aVar.aGB = d.g.icon_dot_orange;
        aVar.aGC = d.e.common_color_10225;
        this.awO.setVisibility(8);
        this.aFZ.a(AddFriendActivityConfig.MSG, aVar);
        return this.aFZ;
    }

    static {
        new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(new ImMessageCenterDelegateStatic());
                }
            }
        }.setPriority(6);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Es() {
        this.dGz = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
                    int a = c.a(newsNotifyMessage);
                    if (ImMessageCenterDelegateStatic.this.awO != null) {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().zm()) {
                            a -= newsNotifyMessage.getMsgOfficialMerge();
                        }
                        ImMessageCenterDelegateStatic.n(ImMessageCenterDelegateStatic.this.awO, a);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dGz);
        MessageManager.getInstance().registerListener(this.dGA);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.dGz);
        MessageManager.getInstance().unRegisterListener(this.dGA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public static void n(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            aj.c(textView, d.e.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                aj.j(textView, d.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                aj.j(textView, d.g.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                aj.j(textView, d.g.icon_news_head_prompt_more);
            }
        }
    }
}
