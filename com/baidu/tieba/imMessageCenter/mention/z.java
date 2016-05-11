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
    private NoNetworkView Ep;
    private PluginErrorTipView aXa;
    private ObservedChangeLinearLayout aXc;
    private View afm;
    private View awk;
    private final CustomMessageListener bhg;
    private com.baidu.adp.framework.listener.e cty;
    private CustomViewPager cyA;
    private af cyB;
    private int cyC;
    private bf cyh;
    private int cyy;
    private FragmentTabWidget cyz;

    public z(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.afm = null;
        this.cyy = 16;
        this.cyC = -1;
        this.cty = new aa(this, 104106);
        this.bhg = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.cyh = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.cyy = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.cyy = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cyy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.cyy = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.cyy != -1) {
                int i = 0;
                if (this.cyy == 24) {
                    i = 1;
                } else if (this.cyy == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    kb(i);
                    if (i == 0) {
                        this.cyh.alA().fh(true);
                        this.cyh.alA().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.cyh.alw().fh(true);
                        this.cyh.alw().onPrimary();
                        return;
                    } else {
                        this.cyh.alx().fh(true);
                        this.cyh.alx().onPrimary();
                        return;
                    }
                }
                kb(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alg() {
        int i = 1;
        if (getView() != null) {
            if (this.cyy != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.cyy != 24) {
                    if (this.cyy == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                kb(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View lg() {
        this.awk = this.cyh.getActivity().getLayoutInflater().inflate(t.h.mention_activity, (ViewGroup) null);
        return this.awk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kW() {
        this.aXc = (ObservedChangeLinearLayout) getView().findViewById(t.g.tab_layout);
        this.aXa = (PluginErrorTipView) this.aXc.findViewById(t.g.view_plugin_error_tip);
        this.Ep = (NoNetworkView) this.aXc.findViewById(t.g.view_no_network);
        this.Ep.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        this.Ep.a(new ac(this));
        this.aXc.setOnSizeChangeListener(new ad(this));
        if (this.aXc.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.aXc.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        Mu();
        this.cyh.registerListener(this.bhg);
        this.cyh.registerListener(this.cty);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alh() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.cyh.getResources().getColor(t.d.backgroundcolor));
        }
        if (this.Ep != null) {
            this.Ep.onChangeSkinType(tbPageContext, i);
        }
        Ms().onChangeSkinType(i);
        if (this.aXa != null) {
            this.aXa.onChangeSkinType(tbPageContext, i);
        }
        return true;
    }

    public void kb(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a ke = ke(i2);
            if (ke != null && (ke instanceof com.baidu.tbadk.mvc.f.a.a) && ke.DK().DQ() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.cyh.alu();
                this.cyA.setCurrentItem(i2);
                this.cyz.f(i2, true);
                return;
            }
            this.cyC = i2;
        }
    }

    private void ali() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().xv();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().xx();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().xy();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.cyh.getActivity(), str, "click", 1, new Object[0]);
        }
        s(getCurrentTabType(), true);
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xF().ya()) {
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
                com.baidu.tbadk.mvc.f.a.a ke = ke(i2);
                if (ke instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b DK = ke.DK();
                    if (DK.DQ() == i) {
                        wVar = (w) ke;
                        textView = (TextView) DK.DO().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.jN(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.fh(true);
                    } else {
                        wVar.fh(false);
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
                com.baidu.tbadk.core.util.at.c(textView, t.d.frs_slidebar_message_text, 1);
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

    public void s(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgReplyme();
        int xp = com.baidu.tbadk.coreExtra.messageCenter.a.xi().xp();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgAtme();
        int xB = com.baidu.tbadk.coreExtra.messageCenter.a.xi().xB();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xB - xp;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        g(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xi().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.awk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager alj() {
        if (this.cyA != null) {
            return this.cyA;
        }
        if (getView() != null) {
            this.cyA = (CustomViewPager) getView().findViewById(t.g.fragment_pager);
            return this.cyA;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget Ms() {
        if (this.cyz != null) {
            return this.cyz;
        }
        if (getView() != null) {
            this.cyz = (FragmentTabWidget) getView().findViewById(t.g.tab_widget_im);
            return this.cyz;
        }
        return null;
    }

    protected void Mu() {
        initViewPager();
        Mt();
        this.cyB.notifyDataSetChanged();
        if (this.cyC == -1) {
            this.cyC = 0;
        }
        this.cyh.alu();
        this.cyz.f(this.cyC, true);
        this.cyA.setCurrentItem(this.cyC);
        kd(this.cyC);
    }

    private void initViewPager() {
        this.cyA = alj();
        this.cyB = new af(this.cyh);
        this.cyA.setAdapter(this.cyB);
        if (!TbadkCoreApplication.isLogin()) {
            this.cyA.setScrollable(false);
        } else {
            this.cyA.setScrollable(true);
        }
        this.cyA.setOnPageChangeListener(this);
    }

    private void Mt() {
        this.cyz = Ms();
        for (int i = 0; i < 3; i++) {
            kc(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.cyz.getChildAt(1).setEnabled(false);
            this.cyz.getChildAt(2).setEnabled(false);
        } else {
            this.cyz.getChildAt(1).setEnabled(true);
            this.cyz.getChildAt(2).setEnabled(true);
        }
        this.cyz.setTabSelectionListener(new ae(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a ke = ke(i);
        if (ke instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b DK = ke.DK();
            fragmentTabIndicator.setText(DK.getTitle());
            FragmentTabIndicator.a DO = DK.DO();
            if (DO != null) {
                if (fragmentTabIndicator.fT(DK.DP()) == null) {
                    DO.cW(TbadkCoreApplication.m11getInst().getSkinType());
                    fragmentTabIndicator.a(DK.DP(), DO);
                }
                DO.auV = fragmentTabIndicator;
                if (DK.DN() > 0) {
                    if (DO.view instanceof TextView) {
                        ((TextView) DO.view).setText(new StringBuilder(String.valueOf(DK.DN())).toString());
                    }
                    DO.view.setVisibility(0);
                    return;
                }
                DO.view.setVisibility(8);
            }
        }
    }

    private void kc(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.auL = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.cyh.getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.cyz.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Ms().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        kd(i);
        ali();
    }

    private void kd(int i) {
        com.baidu.tbadk.mvc.f.a.a ke = ke(this.cyC);
        if (ke != null) {
            ke.DL();
        }
        this.cyh.alu();
        Ms().f(i, true);
        this.cyC = i;
        com.baidu.tbadk.mvc.f.a.a ke2 = ke(this.cyC);
        if (ke2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            ke2.onPrimary();
            ke2.DM();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a ke = ke(this.cyC);
        if (ke != null) {
            return ke.DK().DQ();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a ke(int i) {
        switch (i) {
            case 0:
                return this.cyh.alA();
            case 1:
                return this.cyh.alw();
            case 2:
                return this.cyh.alx();
            default:
                return this.cyh.alA();
        }
    }
}
