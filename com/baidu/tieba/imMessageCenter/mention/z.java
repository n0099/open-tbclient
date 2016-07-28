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
    private NoNetworkView EV;
    private View agC;
    private View axO;
    private final CustomMessageListener bEF;
    private PluginErrorTipView bvl;
    private ObservedChangeLinearLayout bvn;
    private int csr;
    private com.baidu.adp.framework.listener.e dbL;
    private int dgR;
    private FragmentTabWidget dgS;
    private CustomViewPager dgT;
    private af dgU;
    private bf dgz;

    public z(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.agC = null;
        this.dgR = 16;
        this.csr = -1;
        this.dbL = new aa(this, 104106);
        this.bEF = new ab(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dgz = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dgR = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dgR = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dgR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dgR = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dgR != -1) {
                int i = 0;
                if (this.dgR == 24) {
                    i = 1;
                } else if (this.dgR == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    lI(i);
                    if (i == 0) {
                        this.dgz.auB().fY(true);
                        this.dgz.auB().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.dgz.aux().fY(true);
                        this.dgz.aux().onPrimary();
                        return;
                    } else {
                        this.dgz.auy().fY(true);
                        this.dgz.auy().onPrimary();
                        return;
                    }
                }
                lI(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auh() {
        int i = 1;
        if (getView() != null) {
            if (this.dgR != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.dgR != 24) {
                    if (this.dgR == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                lI(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View lg() {
        this.axO = this.dgz.getActivity().getLayoutInflater().inflate(u.h.mention_activity, (ViewGroup) null);
        return this.axO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kV() {
        this.bvn = (ObservedChangeLinearLayout) getView().findViewById(u.g.tab_layout);
        this.bvl = (PluginErrorTipView) this.bvn.findViewById(u.g.view_plugin_error_tip);
        this.EV = (NoNetworkView) this.bvn.findViewById(u.g.view_no_network);
        this.EV.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
        this.EV.a(new ac(this));
        this.bvn.setOnSizeChangeListener(new ad(this));
        if (this.bvn.getLayoutParams() != null) {
            ((RelativeLayout.LayoutParams) this.bvn.getLayoutParams()).setMargins(0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds98) + UtilHelper.getLightStatusBarHeight(), 0, 0);
        }
        SI();
        this.dgz.registerListener(this.bEF);
        this.dgz.registerListener(this.dbL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aui() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.dgz.getResources().getColor(u.d.common_color_10163));
        }
        if (this.EV != null) {
            this.EV.onChangeSkinType(tbPageContext, i);
        }
        SG().onChangeSkinType(i);
        if (this.bvl != null) {
            this.bvl.onChangeSkinType(tbPageContext, i);
        }
        return true;
    }

    public void lI(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a lL = lL(i2);
            if (lL != null && (lL instanceof com.baidu.tbadk.mvc.f.a.a) && lL.DT().DZ() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.dgz.auv();
                this.dgT.setCurrentItem(i2);
                this.dgS.g(i2, true);
                return;
            }
            this.csr = i2;
        }
    }

    private void auj() {
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
            TiebaStatic.eventStat(this.dgz.getActivity(), str, "click", 1, new Object[0]);
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
                com.baidu.tbadk.mvc.f.a.a lL = lL(i2);
                if (lL instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b DT = lL.DT();
                    if (DT.DZ() == i) {
                        wVar = (w) lL;
                        textView = (TextView) DT.DX().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.s.lu(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.fY(true);
                    } else {
                        wVar.fY(false);
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

    public void H(int i, boolean z) {
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
            com.baidu.tbadk.coreExtra.messageCenter.a.xn().c(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.axO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager auk() {
        if (this.dgT != null) {
            return this.dgT;
        }
        if (getView() != null) {
            this.dgT = (CustomViewPager) getView().findViewById(u.g.fragment_pager);
            return this.dgT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget SG() {
        if (this.dgS != null) {
            return this.dgS;
        }
        if (getView() != null) {
            this.dgS = (FragmentTabWidget) getView().findViewById(u.g.tab_widget_im);
            return this.dgS;
        }
        return null;
    }

    protected void SI() {
        initViewPager();
        SH();
        this.dgU.notifyDataSetChanged();
        if (this.csr == -1) {
            this.csr = 0;
        }
        this.dgz.auv();
        this.dgS.g(this.csr, true);
        this.dgT.setCurrentItem(this.csr);
        lK(this.csr);
    }

    private void initViewPager() {
        this.dgT = auk();
        this.dgU = new af(this.dgz);
        this.dgT.setAdapter(this.dgU);
        if (!TbadkCoreApplication.isLogin()) {
            this.dgT.setScrollable(false);
        } else {
            this.dgT.setScrollable(true);
        }
        this.dgT.setOnPageChangeListener(this);
    }

    private void SH() {
        this.dgS = SG();
        for (int i = 0; i < 3; i++) {
            lJ(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.dgS.getChildAt(1).setEnabled(false);
            this.dgS.getChildAt(2).setEnabled(false);
        } else {
            this.dgS.getChildAt(1).setEnabled(true);
            this.dgS.getChildAt(2).setEnabled(true);
        }
        this.dgS.setTabSelectionListener(new ae(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a lL = lL(i);
        if (lL instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b DT = lL.DT();
            fragmentTabIndicator.setText(DT.getTitle());
            FragmentTabIndicator.a DX = DT.DX();
            if (DX != null) {
                if (fragmentTabIndicator.fX(DT.DY()) == null) {
                    DX.cX(TbadkCoreApplication.m10getInst().getSkinType());
                    fragmentTabIndicator.a(DT.DY(), DX);
                }
                DX.awA = fragmentTabIndicator;
                if (DT.DW() > 0) {
                    if (DX.view instanceof TextView) {
                        ((TextView) DX.view).setText(new StringBuilder(String.valueOf(DT.DW())).toString());
                    }
                    DX.view.setVisibility(0);
                    return;
                }
                DX.view.setVisibility(8);
            }
        }
    }

    private void lJ(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.awq = u.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.dgz.getResources().getDimension(u.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.dgS.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        SG().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        lK(i);
        auj();
    }

    private void lK(int i) {
        com.baidu.tbadk.mvc.f.a.a lL = lL(this.csr);
        if (lL != null) {
            lL.DU();
        }
        this.dgz.auv();
        SG().g(i, true);
        this.csr = i;
        com.baidu.tbadk.mvc.f.a.a lL2 = lL(this.csr);
        if (lL2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            lL2.onPrimary();
            lL2.DV();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a lL = lL(this.csr);
        if (lL != null) {
            return lL.DT().DZ();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a lL(int i) {
        switch (i) {
            case 0:
                return this.dgz.auB();
            case 1:
                return this.dgz.aux();
            case 2:
                return this.dgz.auy();
            default:
                return this.dgz.auB();
        }
    }
}
