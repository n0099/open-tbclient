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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<bf> implements ViewPager.OnPageChangeListener {
    private NoNetworkView Ev;
    private View afN;
    private View axa;
    private final CustomMessageListener bDv;
    private PluginErrorTipView bsW;
    private ObservedChangeLinearLayout bsY;
    private com.baidu.adp.framework.listener.e cYO;
    private int cpM;
    private bf ddD;
    private int ddV;
    private FragmentTabWidget ddW;
    private CustomViewPager ddX;
    private af ddY;

    public z(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.afN = null;
        this.ddV = 16;
        this.cpM = -1;
        this.cYO = new aa(this, 104106);
        this.bDv = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.ddD = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.ddV = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.ddV = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.ddV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.ddV = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.ddV != -1) {
                int i = 0;
                if (this.ddV == 24) {
                    i = 1;
                } else if (this.ddV == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    lC(i);
                    if (i == 0) {
                        this.ddD.atP().fV(true);
                        this.ddD.atP().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.ddD.atL().fV(true);
                        this.ddD.atL().onPrimary();
                        return;
                    } else {
                        this.ddD.atM().fV(true);
                        this.ddD.atM().onPrimary();
                        return;
                    }
                }
                lC(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atv() {
        int i = 1;
        if (getView() != null) {
            if (this.ddV != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.ddV != 24) {
                    if (this.ddV == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                lC(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View lk() {
        this.axa = this.ddD.getActivity().getLayoutInflater().inflate(u.h.mention_activity, (ViewGroup) null);
        return this.axa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kZ() {
        this.bsY = (ObservedChangeLinearLayout) getView().findViewById(u.g.tab_layout);
        this.bsW = (PluginErrorTipView) this.bsY.findViewById(u.g.view_plugin_error_tip);
        this.Ev = (NoNetworkView) this.bsY.findViewById(u.g.view_no_network);
        this.Ev.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Ev.a(new ac(this));
        this.bsY.setOnSizeChangeListener(new ad(this));
        if (this.bsY.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bsY.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        Sa();
        this.ddD.registerListener(this.bDv);
        this.ddD.registerListener(this.cYO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atw() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.ddD.getResources().getColor(u.d.common_color_10163));
        }
        if (this.Ev != null) {
            this.Ev.onChangeSkinType(tbPageContext, i);
        }
        RY().onChangeSkinType(i);
        if (this.bsW != null) {
            this.bsW.onChangeSkinType(tbPageContext, i);
        }
        return true;
    }

    public void lC(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a lF = lF(i2);
            if (lF != null && (lF instanceof com.baidu.tbadk.mvc.f.a.a) && lF.DU().Ea() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.ddD.atJ();
                this.ddX.setCurrentItem(i2);
                this.ddW.f(i2, true);
                return;
            }
            this.cpM = i2;
        }
    }

    private void atx() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().xA();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().xC();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().xD();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.ddD.getActivity(), str, "click", 1, new Object[0]);
        }
        G(getCurrentTabType(), true);
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
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
                com.baidu.tbadk.mvc.f.a.a lF = lF(i2);
                if (lF instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b DU = lF.DU();
                    if (DU.Ea() == i) {
                        wVar = (w) lF;
                        textView = (TextView) DU.DY().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.lo(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.fV(true);
                    } else {
                        wVar.fV(false);
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
                com.baidu.tbadk.core.util.av.c(textView, u.d.common_color_10225, 1);
                if (i <= 0) {
                    textView.setVisibility(8);
                } else if (i < 10) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.av.k(textView, u.f.icon_news_head_prompt_one);
                } else if (i < 100) {
                    textView.setText(String.valueOf(i));
                    com.baidu.tbadk.core.util.av.k(textView, u.f.icon_news_head_prompt_two);
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.av.k(textView, u.f.icon_news_head_prompt_more);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void G(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme();
        int xu = com.baidu.tbadk.coreExtra.messageCenter.a.xn().xu();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme();
        int xG = com.baidu.tbadk.coreExtra.messageCenter.a.xn().xG();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xG - xu;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        h(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.axa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager aty() {
        if (this.ddX != null) {
            return this.ddX;
        }
        if (getView() != null) {
            this.ddX = (CustomViewPager) getView().findViewById(u.g.fragment_pager);
            return this.ddX;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget RY() {
        if (this.ddW != null) {
            return this.ddW;
        }
        if (getView() != null) {
            this.ddW = (FragmentTabWidget) getView().findViewById(u.g.tab_widget_im);
            return this.ddW;
        }
        return null;
    }

    protected void Sa() {
        initViewPager();
        RZ();
        this.ddY.notifyDataSetChanged();
        if (this.cpM == -1) {
            this.cpM = 0;
        }
        this.ddD.atJ();
        this.ddW.f(this.cpM, true);
        this.ddX.setCurrentItem(this.cpM);
        lE(this.cpM);
    }

    private void initViewPager() {
        this.ddX = aty();
        this.ddY = new af(this.ddD);
        this.ddX.setAdapter(this.ddY);
        if (!TbadkCoreApplication.isLogin()) {
            this.ddX.setScrollable(false);
        } else {
            this.ddX.setScrollable(true);
        }
        this.ddX.setOnPageChangeListener(this);
    }

    private void RZ() {
        this.ddW = RY();
        for (int i = 0; i < 3; i++) {
            lD(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.ddW.getChildAt(1).setEnabled(false);
            this.ddW.getChildAt(2).setEnabled(false);
        } else {
            this.ddW.getChildAt(1).setEnabled(true);
            this.ddW.getChildAt(2).setEnabled(true);
        }
        this.ddW.setTabSelectionListener(new ae(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a lF = lF(i);
        if (lF instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b DU = lF.DU();
            fragmentTabIndicator.setText(DU.getTitle());
            FragmentTabIndicator.a DY = DU.DY();
            if (DY != null) {
                if (fragmentTabIndicator.fZ(DU.DZ()) == null) {
                    DY.cX(TbadkCoreApplication.m9getInst().getSkinType());
                    fragmentTabIndicator.a(DU.DZ(), DY);
                }
                DY.avL = fragmentTabIndicator;
                if (DU.DX() > 0) {
                    if (DY.view instanceof TextView) {
                        ((TextView) DY.view).setText(new StringBuilder(String.valueOf(DU.DX())).toString());
                    }
                    DY.view.setVisibility(0);
                    return;
                }
                DY.view.setVisibility(8);
            }
        }
    }

    private void lD(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.avB = u.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.ddD.getResources().getDimension(u.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.ddW.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        RY().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        lE(i);
        atx();
    }

    private void lE(int i) {
        com.baidu.tbadk.mvc.f.a.a lF = lF(this.cpM);
        if (lF != null) {
            lF.DV();
        }
        this.ddD.atJ();
        RY().f(i, true);
        this.cpM = i;
        com.baidu.tbadk.mvc.f.a.a lF2 = lF(this.cpM);
        if (lF2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            lF2.onPrimary();
            lF2.DW();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a lF = lF(this.cpM);
        if (lF != null) {
            return lF.DU().Ea();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a lF(int i) {
        switch (i) {
            case 0:
                return this.ddD.atP();
            case 1:
                return this.ddD.atL();
            case 2:
                return this.ddD.atM();
            default:
                return this.ddD.atP();
        }
    }
}
