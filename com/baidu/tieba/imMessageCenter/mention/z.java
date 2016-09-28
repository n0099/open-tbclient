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
    private NoNetworkView Hi;
    private View aAy;
    private View aiY;
    private PluginErrorTipView bGJ;
    private ObservedChangeLinearLayout bGL;
    private final CustomMessageListener bQc;
    private int cEd;
    private com.baidu.adp.framework.listener.e doR;
    private bf dtC;
    private int dtU;
    private FragmentTabWidget dtV;
    private CustomViewPager dtW;
    private af dtX;

    public z(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.aiY = null;
        this.dtU = 16;
        this.cEd = -1;
        this.doR = new aa(this, 104106);
        this.bQc = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dtC = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dtU = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dtU = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dtU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dtU = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dtU != -1) {
                int i = 0;
                if (this.dtU == 24) {
                    i = 1;
                } else if (this.dtU == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    mt(i);
                    if (i == 0) {
                        this.dtC.azM().gx(true);
                        this.dtC.azM().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.dtC.azI().gx(true);
                        this.dtC.azI().onPrimary();
                        return;
                    } else {
                        this.dtC.azJ().gx(true);
                        this.dtC.azJ().onPrimary();
                        return;
                    }
                }
                mt(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azt() {
        int i = 1;
        if (getView() != null) {
            if (this.dtU != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.dtU != 24) {
                    if (this.dtU == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                mt(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View mb() {
        this.aAy = this.dtC.getActivity().getLayoutInflater().inflate(r.h.mention_activity, (ViewGroup) null);
        return this.aAy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lQ() {
        this.bGL = (ObservedChangeLinearLayout) getView().findViewById(r.g.tab_layout);
        this.bGJ = (PluginErrorTipView) this.bGL.findViewById(r.g.view_plugin_error_tip);
        this.Hi = (NoNetworkView) this.bGL.findViewById(r.g.view_no_network);
        this.Hi.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Hi.a(new ac(this));
        this.bGL.setOnSizeChangeListener(new ad(this));
        if (this.bGL.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bGL.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        XO();
        this.dtC.registerListener(this.bQc);
        this.dtC.registerListener(this.doR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azu() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.dtC.getResources().getColor(r.d.common_color_10163));
        }
        if (this.Hi != null) {
            this.Hi.onChangeSkinType(tbPageContext, i);
        }
        XM().onChangeSkinType(i);
        if (this.bGJ != null) {
            this.bGJ.onChangeSkinType(tbPageContext, i);
        }
        return true;
    }

    public void mt(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a mw = mw(i2);
            if (mw != null && (mw instanceof com.baidu.tbadk.mvc.f.a.a) && mw.Fm().Fs() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.dtC.azG();
                this.dtW.setCurrentItem(i2);
                this.dtV.g(i2, true);
                return;
            }
            this.cEd = i2;
        }
    }

    private void azv() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().yQ();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().yS();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().yT();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.dtC.getActivity(), str, "click", 1, new Object[0]);
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zv()) {
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
                com.baidu.tbadk.mvc.f.a.a mw = mw(i2);
                if (mw instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b Fm = mw.Fm();
                    if (Fm.Fs() == i) {
                        wVar = (w) mw;
                        textView = (TextView) Fm.Fq().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.mf(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.gx(true);
                    } else {
                        wVar.gx(false);
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
                com.baidu.tbadk.core.util.av.c(textView, r.d.common_color_10225, 1);
                if (i <= 0) {
                    textView.setVisibility(8);
                } else if (i < 10) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.av.k(textView, r.f.icon_news_head_prompt_one);
                } else if (i < 100) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.av.k(textView, r.f.icon_news_head_prompt_two);
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.av.k(textView, r.f.icon_news_head_prompt_more);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void H(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgReplyme();
        int yK = com.baidu.tbadk.coreExtra.messageCenter.a.yD().yK();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgAtme();
        int yW = com.baidu.tbadk.coreExtra.messageCenter.a.yD().yW();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = yW - yK;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        h(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.yD().c(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.aAy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager azw() {
        if (this.dtW != null) {
            return this.dtW;
        }
        if (getView() != null) {
            this.dtW = (CustomViewPager) getView().findViewById(r.g.fragment_pager);
            return this.dtW;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget XM() {
        if (this.dtV != null) {
            return this.dtV;
        }
        if (getView() != null) {
            this.dtV = (FragmentTabWidget) getView().findViewById(r.g.tab_widget_im);
            return this.dtV;
        }
        return null;
    }

    protected void XO() {
        initViewPager();
        XN();
        this.dtX.notifyDataSetChanged();
        if (this.cEd == -1) {
            this.cEd = 0;
        }
        this.dtC.azG();
        this.dtV.g(this.cEd, true);
        this.dtW.setCurrentItem(this.cEd);
        mv(this.cEd);
    }

    private void initViewPager() {
        this.dtW = azw();
        this.dtX = new af(this.dtC);
        this.dtW.setAdapter(this.dtX);
        if (!TbadkCoreApplication.isLogin()) {
            this.dtW.setScrollable(false);
        } else {
            this.dtW.setScrollable(true);
        }
        this.dtW.setOnPageChangeListener(this);
    }

    private void XN() {
        this.dtV = XM();
        for (int i = 0; i < 3; i++) {
            mu(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.dtV.getChildAt(1).setEnabled(false);
            this.dtV.getChildAt(2).setEnabled(false);
        } else {
            this.dtV.getChildAt(1).setEnabled(true);
            this.dtV.getChildAt(2).setEnabled(true);
        }
        this.dtV.setTabSelectionListener(new ae(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a mw = mw(i);
        if (mw instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Fm = mw.Fm();
            fragmentTabIndicator.setText(Fm.getTitle());
            FragmentTabIndicator.a Fq = Fm.Fq();
            if (Fq != null) {
                if (fragmentTabIndicator.ge(Fm.Fr()) == null) {
                    Fq.dl(TbadkCoreApplication.m9getInst().getSkinType());
                    fragmentTabIndicator.a(Fm.Fr(), Fq);
                }
                Fq.azk = fragmentTabIndicator;
                if (Fm.Fp() > 0) {
                    if (Fq.view instanceof TextView) {
                        ((TextView) Fq.view).setText(new StringBuilder(String.valueOf(Fm.Fp())).toString());
                    }
                    Fq.view.setVisibility(0);
                    return;
                }
                Fq.view.setVisibility(8);
            }
        }
    }

    private void mu(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.aza = r.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.dtC.getResources().getDimension(r.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.dtV.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        XM().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        mv(i);
        azv();
    }

    private void mv(int i) {
        com.baidu.tbadk.mvc.f.a.a mw = mw(this.cEd);
        if (mw != null) {
            mw.Fn();
        }
        this.dtC.azG();
        XM().g(i, true);
        this.cEd = i;
        com.baidu.tbadk.mvc.f.a.a mw2 = mw(this.cEd);
        if (mw2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            mw2.onPrimary();
            mw2.Fo();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a mw = mw(this.cEd);
        if (mw != null) {
            return mw.Fm().Fs();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a mw(int i) {
        switch (i) {
            case 0:
                return this.dtC.azM();
            case 1:
                return this.dtC.azI();
            case 2:
                return this.dtC.azJ();
            default:
                return this.dtC.azM();
        }
    }
}
