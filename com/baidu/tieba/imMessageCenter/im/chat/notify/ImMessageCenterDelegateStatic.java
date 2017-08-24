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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.g;
/* loaded from: classes2.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView ayI;
    private CustomMessageListener dCZ;
    private com.baidu.adp.framework.listener.c dDa = new com.baidu.adp.framework.listener.c(104106) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            int i = 0;
            if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
                RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
                boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.yZ().getMsgChat();
                int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yZ().getMsgReplyme();
                int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yZ().getMsgAtme();
                int zg = com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zg();
                e zu = com.baidu.tbadk.coreExtra.messageCenter.a.yZ().zu();
                if (zu != null && flag) {
                    i = zu.AG();
                }
                ImMessageCenterDelegateStatic.n(ImMessageCenterDelegateStatic.this.ayI, (((msgChat - i) + msgReplyme) + msgAtme) - zg);
            }
        }
    };

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EW() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        g gVar = new g();
        gVar.hd(true);
        cVar.aHI = gVar;
        cVar.type = 3;
        cVar.aHJ = d.l.my_message;
        cVar.aHK = d.g.s_tabbar_icon_three_bg;
        cVar.aHO = com.baidu.tbadk.mainTab.c.aHL;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.ayI = (TextView) LayoutInflater.from(context).inflate(d.j.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aHH = this.aHv;
        aVar.wy = k.dip2px(context, 3.0f);
        aVar.view = this.ayI;
        aVar.aHF = d.g.icon_dot_orange;
        aVar.aHG = d.e.common_color_10225;
        this.ayI.setVisibility(8);
        this.aHv.a(AddFriendActivityConfig.MSG, aVar);
        return this.aHv;
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
    public void EV() {
        this.dCZ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
                    int a = c.a(newsNotifyMessage);
                    if (ImMessageCenterDelegateStatic.this.ayI != null) {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zQ()) {
                            a -= newsNotifyMessage.getMsgOfficialMerge();
                        }
                        ImMessageCenterDelegateStatic.n(ImMessageCenterDelegateStatic.this.ayI, a);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dCZ);
        MessageManager.getInstance().registerListener(this.dDa);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cM() {
        super.cM();
        MessageManager.getInstance().unRegisterListener(this.dCZ);
        MessageManager.getInstance().unRegisterListener(this.dDa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public static void n(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            ai.c(textView, d.e.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                ai.j(textView, d.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                ai.j(textView, d.g.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                ai.j(textView, d.g.icon_news_head_prompt_more);
            }
        }
    }
}
