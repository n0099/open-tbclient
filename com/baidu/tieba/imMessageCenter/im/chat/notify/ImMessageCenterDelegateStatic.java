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
    private TextView bmh;
    private CustomMessageListener eJu;
    private com.baidu.adp.framework.listener.c eJv = new com.baidu.adp.framework.listener.c(104106) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            int i = 0;
            if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
                RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
                boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.Gm().getMsgChat();
                int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.Gm().getMsgReplyme();
                int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.Gm().getMsgAtme();
                int Gt = com.baidu.tbadk.coreExtra.messageCenter.a.Gm().Gt();
                e GH = com.baidu.tbadk.coreExtra.messageCenter.a.Gm().GH();
                if (GH != null && flag) {
                    i = GH.HV();
                }
                ImMessageCenterDelegateStatic.o(ImMessageCenterDelegateStatic.this.bmh, (((msgChat - i) + msgReplyme) + msgAtme) - Gt);
            }
        }
    };

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c My() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        g gVar = new g();
        gVar.hU(true);
        cVar.bvx = gVar;
        cVar.type = 3;
        cVar.bvy = d.j.my_message;
        cVar.bvz = d.f.s_tabbar_icon_three_bg;
        cVar.bvF = com.baidu.tbadk.mainTab.c.bvC;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e bm(Context context) {
        this.bvo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.bmh = (TextView) LayoutInflater.from(context).inflate(d.h.message_tip_item, (ViewGroup) null);
        e.a aVar = new e.a();
        aVar.bvS = this.bvo;
        aVar.aiC = l.dip2px(context, 3.0f);
        aVar.view = this.bmh;
        aVar.bvQ = d.f.icon_dot_orange;
        aVar.bvR = d.C0108d.common_color_10225;
        this.bmh.setVisibility(8);
        this.bvo.a("msg", aVar);
        return this.bvo;
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
    public void Mx() {
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
                    int a = c.a(newsNotifyMessage);
                    if (ImMessageCenterDelegateStatic.this.bmh != null) {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GJ().Hd()) {
                            a -= newsNotifyMessage.getMsgOfficialMerge();
                        }
                        ImMessageCenterDelegateStatic.o(ImMessageCenterDelegateStatic.this.bmh, a);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eJu);
        MessageManager.getInstance().registerListener(this.eJv);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void kg() {
        super.kg();
        MessageManager.getInstance().unRegisterListener(this.eJu);
        MessageManager.getInstance().unRegisterListener(this.eJv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public static void o(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            aj.e(textView, d.C0108d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                aj.s(textView, d.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                aj.s(textView, d.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                aj.s(textView, d.f.icon_news_head_prompt_more);
            }
        }
    }
}
