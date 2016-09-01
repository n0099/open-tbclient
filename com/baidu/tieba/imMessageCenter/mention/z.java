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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<bf> implements ViewPager.OnPageChangeListener {
    private NoNetworkView Hi;
    private View aAV;
    private View ajw;
    private ObservedChangeLinearLayout bGA;
    private PluginErrorTipView bGy;
    private final CustomMessageListener bQj;
    private int cDz;
    private com.baidu.adp.framework.listener.e dnt;
    private af dsA;
    private bf dsf;
    private int dsx;
    private FragmentTabWidget dsy;
    private CustomViewPager dsz;

    public z(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.ajw = null;
        this.dsx = 16;
        this.cDz = -1;
        this.dnt = new aa(this, 104106);
        this.bQj = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dsf = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dsx = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dsx = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dsx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dsx = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dsx != -1) {
                int i = 0;
                if (this.dsx == 24) {
                    i = 1;
                } else if (this.dsx == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    ml(i);
                    if (i == 0) {
                        this.dsf.azo().gu(true);
                        this.dsf.azo().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.dsf.azk().gu(true);
                        this.dsf.azk().onPrimary();
                        return;
                    } else {
                        this.dsf.azl().gu(true);
                        this.dsf.azl().onPrimary();
                        return;
                    }
                }
                ml(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayV() {
        int i = 1;
        if (getView() != null) {
            if (this.dsx != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.dsx != 24) {
                    if (this.dsx == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                ml(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View mb() {
        this.aAV = this.dsf.getActivity().getLayoutInflater().inflate(t.h.mention_activity, (ViewGroup) null);
        return this.aAV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lQ() {
        this.bGA = (ObservedChangeLinearLayout) getView().findViewById(t.g.tab_layout);
        this.bGy = (PluginErrorTipView) this.bGA.findViewById(t.g.view_plugin_error_tip);
        this.Hi = (NoNetworkView) this.bGA.findViewById(t.g.view_no_network);
        this.Hi.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Hi.a(new ac(this));
        this.bGA.setOnSizeChangeListener(new ad(this));
        if (this.bGA.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bGA.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        Xu();
        this.dsf.registerListener(this.bQj);
        this.dsf.registerListener(this.dnt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayW() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.dsf.getResources().getColor(t.d.common_color_10163));
        }
        if (this.Hi != null) {
            this.Hi.onChangeSkinType(tbPageContext, i);
        }
        Xs().onChangeSkinType(i);
        if (this.bGy != null) {
            this.bGy.onChangeSkinType(tbPageContext, i);
        }
        return true;
    }

    public void ml(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a mo = mo(i2);
            if (mo != null && (mo instanceof com.baidu.tbadk.mvc.f.a.a) && mo.Fn().Ft() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.dsf.azi();
                this.dsz.setCurrentItem(i2);
                this.dsy.g(i2, true);
                return;
            }
            this.cDz = i2;
        }
    }

    private void ayX() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().yN();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().yP();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().yQ();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.dsf.getActivity(), str, "click", 1, new Object[0]);
        }
        H(getCurrentTabType(), true);
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zs()) {
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
                com.baidu.tbadk.mvc.f.a.a mo = mo(i2);
                if (mo instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b Fn = mo.Fn();
                    if (Fn.Ft() == i) {
                        wVar = (w) mo;
                        textView = (TextView) Fn.Fr().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.lX(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.gu(true);
                    } else {
                        wVar.gu(false);
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
                com.baidu.tbadk.core.util.av.c(textView, t.d.common_color_10225, 1);
                if (i <= 0) {
                    textView.setVisibility(8);
                } else if (i < 10) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.av.k(textView, t.f.icon_news_head_prompt_one);
                } else if (i < 100) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.av.k(textView, t.f.icon_news_head_prompt_two);
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.av.k(textView, t.f.icon_news_head_prompt_more);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void H(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgReplyme();
        int yH = com.baidu.tbadk.coreExtra.messageCenter.a.yA().yH();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgAtme();
        int yT = com.baidu.tbadk.coreExtra.messageCenter.a.yA().yT();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = yT - yH;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        h(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.yA().c(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.aAV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager ayY() {
        if (this.dsz != null) {
            return this.dsz;
        }
        if (getView() != null) {
            this.dsz = (CustomViewPager) getView().findViewById(t.g.fragment_pager);
            return this.dsz;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget Xs() {
        if (this.dsy != null) {
            return this.dsy;
        }
        if (getView() != null) {
            this.dsy = (FragmentTabWidget) getView().findViewById(t.g.tab_widget_im);
            return this.dsy;
        }
        return null;
    }

    protected void Xu() {
        initViewPager();
        Xt();
        this.dsA.notifyDataSetChanged();
        if (this.cDz == -1) {
            this.cDz = 0;
        }
        this.dsf.azi();
        this.dsy.g(this.cDz, true);
        this.dsz.setCurrentItem(this.cDz);
        mn(this.cDz);
    }

    private void initViewPager() {
        this.dsz = ayY();
        this.dsA = new af(this.dsf);
        this.dsz.setAdapter(this.dsA);
        if (!TbadkCoreApplication.isLogin()) {
            this.dsz.setScrollable(false);
        } else {
            this.dsz.setScrollable(true);
        }
        this.dsz.setOnPageChangeListener(this);
    }

    private void Xt() {
        this.dsy = Xs();
        for (int i = 0; i < 3; i++) {
            mm(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.dsy.getChildAt(1).setEnabled(false);
            this.dsy.getChildAt(2).setEnabled(false);
        } else {
            this.dsy.getChildAt(1).setEnabled(true);
            this.dsy.getChildAt(2).setEnabled(true);
        }
        this.dsy.setTabSelectionListener(new ae(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a mo = mo(i);
        if (mo instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Fn = mo.Fn();
            fragmentTabIndicator.setText(Fn.getTitle());
            FragmentTabIndicator.a Fr = Fn.Fr();
            if (Fr != null) {
                if (fragmentTabIndicator.ga(Fn.Fs()) == null) {
                    Fr.dl(TbadkCoreApplication.m9getInst().getSkinType());
                    fragmentTabIndicator.a(Fn.Fs(), Fr);
                }
                Fr.azH = fragmentTabIndicator;
                if (Fn.Fq() > 0) {
                    if (Fr.view instanceof TextView) {
                        ((TextView) Fr.view).setText(new StringBuilder(String.valueOf(Fn.Fq())).toString());
                    }
                    Fr.view.setVisibility(0);
                    return;
                }
                Fr.view.setVisibility(8);
            }
        }
    }

    private void mm(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.azx = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.dsf.getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.dsy.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Xs().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        mn(i);
        ayX();
    }

    private void mn(int i) {
        com.baidu.tbadk.mvc.f.a.a mo = mo(this.cDz);
        if (mo != null) {
            mo.Fo();
        }
        this.dsf.azi();
        Xs().g(i, true);
        this.cDz = i;
        com.baidu.tbadk.mvc.f.a.a mo2 = mo(this.cDz);
        if (mo2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            mo2.onPrimary();
            mo2.Fp();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a mo = mo(this.cDz);
        if (mo != null) {
            return mo.Fn().Ft();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a mo(int i) {
        switch (i) {
            case 0:
                return this.dsf.azo();
            case 1:
                return this.dsf.azk();
            case 2:
                return this.dsf.azl();
            default:
                return this.dsf.azo();
        }
    }
}
