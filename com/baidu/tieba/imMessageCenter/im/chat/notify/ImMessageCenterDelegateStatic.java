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
    private TextView boM;
    private CustomMessageListener ePE;
    private com.baidu.adp.framework.listener.c ePF = new com.baidu.adp.framework.listener.c(104106) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            int i = 0;
            if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
                RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
                boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgChat();
                int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgReplyme();
                int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().getMsgAtme();
                int GQ = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GQ();
                e Hf = com.baidu.tbadk.coreExtra.messageCenter.a.GJ().Hf();
                if (Hf != null && flag) {
                    i = Hf.Iz();
                }
                ImMessageCenterDelegateStatic.m(ImMessageCenterDelegateStatic.this.boM, (((msgChat - i) + msgReplyme) + msgAtme) - GQ);
            }
        }
    };

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c MU() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        g gVar = new g();
        gVar.ij(true);
        cVar.bxZ = gVar;
        cVar.type = 3;
        cVar.bya = d.j.my_message;
        cVar.byb = d.f.s_tabbar_icon_three_bg;
        cVar.byh = com.baidu.tbadk.mainTab.c.bye;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.e bi(Context context) {
        this.bxQ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.h.fragmenttabindicator, (ViewGroup) null);
        this.boM = (TextView) LayoutInflater.from(context).inflate(d.h.message_tip_item, (ViewGroup) null);
        e.a aVar = new e.a();
        aVar.byu = this.bxQ;
        aVar.aiE = l.dip2px(context, 3.0f);
        aVar.view = this.boM;
        aVar.bys = d.f.icon_dot_orange;
        aVar.byt = d.C0140d.common_color_10225;
        this.boM.setVisibility(8);
        this.bxQ.a("msg", aVar);
        return this.bxQ;
    }

    static {
        new CustomMessageListener(2007002) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.1
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
    public void MT() {
        this.ePE = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                    NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
                    int a = c.a(newsNotifyMessage);
                    if (ImMessageCenterDelegateStatic.this.boM != null) {
                        if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HJ()) {
                            a -= newsNotifyMessage.getMsgOfficialMerge();
                        }
                        ImMessageCenterDelegateStatic.m(ImMessageCenterDelegateStatic.this.boM, a);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ePE);
        MessageManager.getInstance().registerListener(this.ePF);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void kg() {
        super.kg();
        MessageManager.getInstance().unRegisterListener(this.ePE);
        MessageManager.getInstance().unRegisterListener(this.ePF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public static void m(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            aj.e(textView, d.C0140d.common_color_10225, 1);
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
