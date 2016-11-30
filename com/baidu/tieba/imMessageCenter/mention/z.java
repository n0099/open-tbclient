package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<bf> implements ViewPager.OnPageChangeListener {
    private NoNetworkView Hk;
    private View aBq;
    private View ajQ;
    private PluginErrorTipView bJD;
    private ObservedChangeLinearLayout bJF;
    private final CustomMessageListener bSW;
    private int cJr;
    private com.baidu.adp.framework.listener.e duz;
    private FragmentTabWidget dzA;
    private CustomViewPager dzB;
    private af dzC;
    private bf dzh;
    private int dzz;

    public z(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.ajQ = null;
        this.dzz = 16;
        this.cJr = -1;
        this.duz = new aa(this, 104106);
        this.bSW = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dzh = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dzz = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dzz = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dzz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dzz = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dzz != -1) {
                int i = 0;
                if (this.dzz == 24) {
                    i = 1;
                } else if (this.dzz == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    mB(i);
                    if (i == 0) {
                        this.dzh.aBI().gR(true);
                        this.dzh.aBI().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.dzh.aBE().gR(true);
                        this.dzh.aBE().onPrimary();
                        return;
                    } else {
                        this.dzh.aBF().gR(true);
                        this.dzh.aBF().onPrimary();
                        return;
                    }
                }
                mB(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeN() {
        int i = 1;
        if (getView() != null) {
            if (this.dzz != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.dzz != 24) {
                    if (this.dzz == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                mB(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View me() {
        this.aBq = this.dzh.getActivity().getLayoutInflater().inflate(r.h.mention_activity, (ViewGroup) null);
        return this.aBq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lT() {
        this.bJF = (ObservedChangeLinearLayout) getView().findViewById(r.g.tab_layout);
        this.bJD = (PluginErrorTipView) this.bJF.findViewById(r.g.view_plugin_error_tip);
        this.Hk = (NoNetworkView) this.bJF.findViewById(r.g.view_no_network);
        this.Hk.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Hk.a(new ac(this));
        this.bJF.setOnSizeChangeListener(new ad(this));
        if (this.bJF.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bJF.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        YQ();
        this.dzh.registerListener(this.bSW);
        this.dzh.registerListener(this.duz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBq() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.dzh.getResources().getColor(r.d.common_color_10163));
        }
        if (this.Hk != null) {
            this.Hk.onChangeSkinType(tbPageContext, i);
        }
        YO().onChangeSkinType(i);
        if (this.bJD != null) {
            this.bJD.onChangeSkinType(tbPageContext, i);
        }
        return true;
    }

    public void mB(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a mE = mE(i2);
            if (mE != null && (mE instanceof com.baidu.tbadk.mvc.f.a.a) && mE.Fr().Fx() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.dzh.aBC();
                this.dzB.setCurrentItem(i2);
                this.dzA.g(i2, true);
                return;
            }
            this.cJr = i2;
        }
    }

    private void aBr() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().yX();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().yZ();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().za();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.dzh.getActivity(), str, "click", 1, new Object[0]);
        }
        J(getCurrentTabType(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zC()) {
                i -= msgOfficialMerge;
            }
            h(new int[]{i, msgReplyme, msgAtme});
        }
    }

    private void h(int[] iArr) {
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
                com.baidu.tbadk.mvc.f.a.a mE = mE(i2);
                if (mE instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b Fr = mE.Fr();
                    if (Fr.Fx() == i) {
                        wVar = (w) mE;
                        textView = (TextView) Fr.Fv().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.mn(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.gR(true);
                    } else {
                        wVar.gR(false);
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
                com.baidu.tbadk.core.util.at.c(textView, r.d.common_color_10225, 1);
                if (i <= 0) {
                    textView.setVisibility(8);
                } else if (i < 10) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_one);
                } else if (i < 100) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_two);
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_more);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void J(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgReplyme();
        int yR = com.baidu.tbadk.coreExtra.messageCenter.a.yK().yR();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgAtme();
        int zd = com.baidu.tbadk.coreExtra.messageCenter.a.yK().zd();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = zd - yR;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        h(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.yK().c(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.aBq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager aBs() {
        if (this.dzB != null) {
            return this.dzB;
        }
        if (getView() != null) {
            this.dzB = (CustomViewPager) getView().findViewById(r.g.fragment_pager);
            return this.dzB;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget YO() {
        if (this.dzA != null) {
            return this.dzA;
        }
        if (getView() != null) {
            this.dzA = (FragmentTabWidget) getView().findViewById(r.g.tab_widget_im);
            return this.dzA;
        }
        return null;
    }

    protected void YQ() {
        initViewPager();
        YP();
        this.dzC.notifyDataSetChanged();
        if (this.cJr == -1) {
            this.cJr = 0;
        }
        this.dzh.aBC();
        this.dzA.g(this.cJr, true);
        this.dzB.setCurrentItem(this.cJr);
        mD(this.cJr);
    }

    private void initViewPager() {
        this.dzB = aBs();
        this.dzC = new af(this.dzh);
        this.dzB.setAdapter(this.dzC);
        if (!TbadkCoreApplication.isLogin()) {
            this.dzB.setScrollable(false);
        } else {
            this.dzB.setScrollable(true);
        }
        this.dzB.setOnPageChangeListener(this);
    }

    private void YP() {
        this.dzA = YO();
        for (int i = 0; i < 3; i++) {
            mC(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.dzA.getChildAt(1).setEnabled(false);
            this.dzA.getChildAt(2).setEnabled(false);
        } else {
            this.dzA.getChildAt(1).setEnabled(true);
            this.dzA.getChildAt(2).setEnabled(true);
        }
        this.dzA.setTabSelectionListener(new ae(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a mE = mE(i);
        if (mE instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Fr = mE.Fr();
            fragmentTabIndicator.setText(Fr.getTitle());
            FragmentTabIndicator.a Fv = Fr.Fv();
            if (Fv != null) {
                if (fragmentTabIndicator.gh(Fr.Fw()) == null) {
                    Fv.dm(TbadkCoreApplication.m9getInst().getSkinType());
                    fragmentTabIndicator.a(Fr.Fw(), Fv);
                }
                Fv.aAc = fragmentTabIndicator;
                if (Fr.Fu() > 0) {
                    if (Fv.view instanceof TextView) {
                        ((TextView) Fv.view).setText(new StringBuilder(String.valueOf(Fr.Fu())).toString());
                    }
                    Fv.view.setVisibility(0);
                    return;
                }
                Fv.view.setVisibility(8);
            }
        }
    }

    private void mC(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.azS = r.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.dzh.getResources().getDimension(r.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.dzA.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        YO().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        mD(i);
        aBr();
    }

    private void mD(int i) {
        com.baidu.tbadk.mvc.f.a.a mE = mE(this.cJr);
        if (mE != null) {
            mE.Fs();
        }
        this.dzh.aBC();
        YO().g(i, true);
        this.cJr = i;
        com.baidu.tbadk.mvc.f.a.a mE2 = mE(this.cJr);
        if (mE2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            mE2.onPrimary();
            mE2.Ft();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a mE = mE(this.cJr);
        if (mE != null) {
            return mE.Fr().Fx();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a mE(int i) {
        switch (i) {
            case 0:
                return this.dzh.aBI();
            case 1:
                return this.dzh.aBE();
            case 2:
                return this.dzh.aBF();
            default:
                return this.dzh.aBI();
        }
    }
}
