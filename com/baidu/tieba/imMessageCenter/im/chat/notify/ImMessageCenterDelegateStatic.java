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
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.g;
/* loaded from: classes2.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView axZ;
    private CustomMessageListener dXm;
    private com.baidu.adp.framework.listener.c dXn = new com.baidu.adp.framework.listener.c(104106) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            int i = 0;
            if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
                RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
                boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgChat();
                int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgReplyme();
                int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgAtme();
                int yU = com.baidu.tbadk.coreExtra.messageCenter.a.yN().yU();
                e zi = com.baidu.tbadk.coreExtra.messageCenter.a.yN().zi();
                if (zi != null && flag) {
                    i = zi.Aw();
                }
                ImMessageCenterDelegateStatic.n(ImMessageCenterDelegateStatic.this.axZ, (((msgChat - i) + msgReplyme) + msgAtme) - yU);
            }
        }
    };

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EZ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        g gVar = new g();
        gVar.hv(true);
        cVar.aHG = gVar;
        cVar.type = 3;
        cVar.aHH = d.j.my_message;
        cVar.aHI = d.f.s_tabbar_icon_three_bg;
        cVar.aHO = com.baidu.tbadk.mainTab.c.aHL;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e ba(Context context) {
        this.aHx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.axZ = (TextView) LayoutInflater.from(context).inflate(d.h.message_tip_item, (ViewGroup) null);
        e.a aVar = new e.a();
        aVar.aIb = this.aHx;
        aVar.uo = l.dip2px(context, 3.0f);
        aVar.view = this.axZ;
        aVar.aHZ = d.f.icon_dot_orange;
        aVar.aIa = d.C0096d.common_color_10225;
        this.axZ.setVisibility(8);
        this.aHx.a(AddFriendActivityConfig.MSG, aVar);
        return this.aHx;
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
    public void EY() {
        this.dXm = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
                    int a = c.a(newsNotifyMessage);
                    if (ImMessageCenterDelegateStatic.this.axZ != null) {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.b.zk().zE()) {
                            a -= newsNotifyMessage.getMsgOfficialMerge();
                        }
                        ImMessageCenterDelegateStatic.n(ImMessageCenterDelegateStatic.this.axZ, a);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dXm);
        MessageManager.getInstance().registerListener(this.dXn);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.dXm);
        MessageManager.getInstance().unRegisterListener(this.dXn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public static void n(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            aj.c(textView, d.C0096d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                aj.j(textView, d.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                aj.j(textView, d.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                aj.j(textView, d.f.icon_news_head_prompt_more);
            }
        }
    }
}
