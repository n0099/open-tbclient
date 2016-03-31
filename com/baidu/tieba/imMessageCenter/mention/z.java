package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<be> implements ViewPager.OnPageChangeListener {
    private NoNetworkView NZ;
    private View aAh;
    private View ajA;
    private final CustomMessageListener blc;
    private com.baidu.adp.framework.listener.e csA;
    private FragmentTabWidget cxA;
    private CustomViewPager cxB;
    private ae cxC;
    private int cxD;
    private be cxj;
    private int cxz;

    public z(be beVar) {
        super(com.baidu.adp.base.l.s(beVar.getPageContext().getPageActivity()));
        this.ajA = null;
        this.cxz = 16;
        this.cxD = -1;
        this.csA = new aa(this, 104106);
        this.blc = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.cxj = beVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.cxz = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.cxz = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cxz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.cxz = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.cxz != -1) {
                int i = 0;
                if (this.cxz == 24) {
                    i = 1;
                } else if (this.cxz == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    kv(i);
                    if (i == 0) {
                        this.cxj.als().eF(true);
                        this.cxj.als().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.cxj.alo().eF(true);
                        this.cxj.alo().onPrimary();
                        return;
                    } else {
                        this.cxj.alp().eF(true);
                        this.cxj.alp().onPrimary();
                        return;
                    }
                }
                kv(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akZ() {
        int i = 1;
        if (getView() != null) {
            if (this.cxz != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.cxz != 24) {
                    if (this.cxz == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                kv(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oT() {
        this.aAh = this.cxj.getActivity().getLayoutInflater().inflate(t.h.mention_activity, (ViewGroup) null);
        return this.aAh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oJ() {
        this.NZ = (NoNetworkView) getView().findViewById(t.g.view_no_network);
        this.NZ.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.NZ.a(new ac(this));
        NK();
        this.cxj.registerListener(this.blc);
        this.cxj.registerListener(this.csA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ala() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.cxj.getResources().getColor(t.d.backgroundcolor));
        }
        if (this.NZ != null) {
            this.NZ.onChangeSkinType(getPageContext(), i);
        }
        ald().onChangeSkinType(i);
        return true;
    }

    public void kv(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a ky = ky(i2);
            if (ky != null && (ky instanceof com.baidu.tbadk.mvc.f.a.a) && ky.FS().FY() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.cxj.aln();
                this.cxB.setCurrentItem(i2);
                this.cxA.d(i2, true);
                return;
            }
            this.cxD = i2;
        }
    }

    private void alb() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().zC();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().zE();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().zF();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.cxj.getActivity(), str, "click", 1, new Object[0]);
        }
        p(getCurrentTabType(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgOfficialMerge = newsNotifyMessage.getMsgOfficialMerge();
            int i = msgChat - msgStrangerChat > 0 ? msgChat - msgStrangerChat : 0;
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ah()) {
                i -= msgOfficialMerge;
            }
            g(new int[]{i, msgReplyme, msgAtme});
        }
    }

    private void g(int[] iArr) {
        TextView textView;
        w wVar;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    textView = null;
                    wVar = null;
                    break;
                }
                com.baidu.tbadk.mvc.f.a.a ky = ky(i2);
                if (ky instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b FS = ky.FS();
                    if (FS.FY() == i) {
                        wVar = (w) ky;
                        textView = (TextView) FS.FW().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.ki(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.eF(true);
                    } else {
                        wVar.eF(false);
                    }
                    r(textView, i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(TextView textView, int i) {
        if (textView != null) {
            try {
                textView.setVisibility(0);
                com.baidu.tbadk.core.util.at.b(textView, t.d.frs_slidebar_message_text, 1);
                if (i <= 0) {
                    textView.setVisibility(8);
                } else if (i < 10) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_one);
                } else if (i < 100) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_two);
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_more);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void p(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgReplyme();
        int zw = com.baidu.tbadk.coreExtra.messageCenter.a.zp().zw();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgAtme();
        int zI = com.baidu.tbadk.coreExtra.messageCenter.a.zp().zI();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = zI - zw;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        g(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.zp().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.aAh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager alc() {
        if (this.cxB != null) {
            return this.cxB;
        }
        if (getView() != null) {
            this.cxB = (CustomViewPager) getView().findViewById(t.g.fragment_pager);
            return this.cxB;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget ald() {
        if (this.cxA != null) {
            return this.cxA;
        }
        if (getView() != null) {
            this.cxA = (FragmentTabWidget) getView().findViewById(t.g.tab_widget);
            return this.cxA;
        }
        return null;
    }

    protected void NK() {
        initViewPager();
        NJ();
        this.cxC.notifyDataSetChanged();
        if (this.cxD == -1) {
            this.cxD = 0;
        }
        this.cxj.aln();
        this.cxA.d(this.cxD, true);
        this.cxB.setCurrentItem(this.cxD);
        kx(this.cxD);
    }

    private void initViewPager() {
        this.cxB = alc();
        this.cxC = new ae(this.cxj);
        this.cxB.setAdapter(this.cxC);
        if (!TbadkCoreApplication.isLogin()) {
            this.cxB.setScrollable(false);
        } else {
            this.cxB.setScrollable(true);
        }
        this.cxB.setOnPageChangeListener(this);
    }

    private void NJ() {
        this.cxA = ald();
        for (int i = 0; i < 3; i++) {
            kw(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.cxA.getChildAt(1).setEnabled(false);
            this.cxA.getChildAt(2).setEnabled(false);
        } else {
            this.cxA.getChildAt(1).setEnabled(true);
            this.cxA.getChildAt(2).setEnabled(true);
        }
        this.cxA.setTabSelectionListener(new ad(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a ky = ky(i);
        if (ky instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b FS = ky.FS();
            fragmentTabIndicator.setText(FS.getTitle());
            FragmentTabIndicator.a FW = FS.FW();
            if (FW != null) {
                if (fragmentTabIndicator.fW(FS.FX()) == null) {
                    FW.dn(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(FS.FX(), FW);
                }
                FW.ayU = fragmentTabIndicator;
                if (FS.FV() > 0) {
                    if (FW.view instanceof TextView) {
                        ((TextView) FW.view).setText(new StringBuilder(String.valueOf(FS.FV())).toString());
                    }
                    FW.view.setVisibility(0);
                    return;
                }
                FW.view.setVisibility(8);
            }
        }
    }

    private void kw(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.ayK = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.cxj.getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.cxA.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ald().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        kx(i);
        alb();
    }

    private void kx(int i) {
        com.baidu.tbadk.mvc.f.a.a ky = ky(this.cxD);
        if (ky != null) {
            ky.FT();
        }
        this.cxj.aln();
        ald().d(i, true);
        this.cxD = i;
        com.baidu.tbadk.mvc.f.a.a ky2 = ky(this.cxD);
        if (ky2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            ky2.onPrimary();
            ky2.FU();
        }
    }

    public int getCurrentTabIndex() {
        return this.cxD;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a ky = ky(this.cxD);
        if (ky != null) {
            return ky.FS().FY();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a ky(int i) {
        switch (i) {
            case 0:
                return this.cxj.als();
            case 1:
                return this.cxj.alo();
            case 2:
                return this.cxj.alp();
            default:
                return this.cxj.als();
        }
    }
}
