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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f<bc> implements ViewPager.OnPageChangeListener {
    private final CustomMessageListener aZY;
    private bc ceg;
    private int cev;
    private FragmentTabWidget cew;
    private CustomViewPager cex;
    private ac cey;
    private int cez;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public y(bc bcVar) {
        super(com.baidu.adp.base.l.C(bcVar.getPageContext().getPageActivity()));
        this.mBack = null;
        this.cev = 16;
        this.cez = -1;
        this.aZY = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.ceg = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.cev = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.cev = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cev);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.cev = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.cev != -1) {
                int i = 0;
                if (this.cev == 24) {
                    i = 1;
                } else if (this.cev == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    iS(i);
                    if (i == 0) {
                        this.ceg.adH().ec(true);
                        this.ceg.adH().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.ceg.adD().ec(true);
                        this.ceg.adD().onPrimary();
                        return;
                    } else {
                        this.ceg.adE().ec(true);
                        this.ceg.adE().onPrimary();
                        return;
                    }
                }
                iS(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adm() {
        int i = 1;
        if (getView() != null) {
            if (this.cev != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.cev != 24) {
                    if (this.cev == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                iS(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pg() {
        this.rootView = this.ceg.getActivity().getLayoutInflater().inflate(n.g.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oX() {
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(n.f.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new aa(this));
        adr();
        getPageContext().registerListener(this.aZY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adn() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.ceg.getResources().getColor(n.c.backgroundcolor));
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        adq().onChangeSkinType(i);
        return true;
    }

    public void iS(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a iW = iW(i2);
            if (iW != null && (iW instanceof com.baidu.tbadk.mvc.f.a.a) && iW.DW().Ec() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.ceg.adC();
                this.cex.setCurrentItem(i2);
                this.cew.d(i2, true);
            } else {
                this.cez = i2;
            }
        }
        ado();
    }

    private void ado() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xW();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xY();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xZ();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.ceg.getActivity(), str, "click", 1, new Object[0]);
        }
        n(getCurrentTabType(), true);
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
            g(new int[]{msgChat - msgStrangerChat > 0 ? msgChat - msgStrangerChat : 0, newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme()});
        }
    }

    private void g(int[] iArr) {
        TextView textView;
        v vVar;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    textView = null;
                    vVar = null;
                    break;
                }
                com.baidu.tbadk.mvc.f.a.a iW = iW(i2);
                if (iW instanceof v) {
                    com.baidu.tbadk.mvc.f.a.b DW = iW.DW();
                    if (DW.Ec() == i) {
                        vVar = (v) iW;
                        textView = (TextView) DW.Ea().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!iT(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        vVar.ec(true);
                    } else {
                        vVar.ec(false);
                    }
                    o(textView, i3);
                }
            }
        }
    }

    private void o(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(textView, n.c.frs_slidebar_message_text, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.as.i((View) textView, n.e.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.as.i((View) textView, n.e.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.as.i((View) textView, n.e.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean iT(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo() || com.baidu.tbadk.coreExtra.messageCenter.c.yg().yv();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yn()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void n(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgReplyme();
        int xQ = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xQ();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgAtme();
        int yc = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().yc();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = yc - xQ;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        g(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xJ().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager adp() {
        if (this.cex != null) {
            return this.cex;
        }
        if (getView() != null) {
            this.cex = (CustomViewPager) getView().findViewById(n.f.fragment_pager);
            return this.cex;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget adq() {
        if (this.cew != null) {
            return this.cew;
        }
        if (getView() != null) {
            this.cew = (FragmentTabWidget) getView().findViewById(n.f.tab_widget);
            return this.cew;
        }
        return null;
    }

    protected void adr() {
        initViewPager();
        Qi();
        this.cey.notifyDataSetChanged();
        if (this.cez == -1) {
            this.cez = 0;
        }
        this.ceg.adC();
        this.cew.d(this.cez, true);
        this.cex.setCurrentItem(this.cez);
        iV(this.cez);
    }

    private void initViewPager() {
        this.cex = adp();
        this.cey = new ac(this.ceg);
        this.cex.setAdapter(this.cey);
        if (!TbadkCoreApplication.isLogin()) {
            this.cex.setScrollable(false);
        } else {
            this.cex.setScrollable(true);
        }
        this.cex.setOnPageChangeListener(this);
    }

    private void Qi() {
        this.cew = adq();
        for (int i = 0; i < 3; i++) {
            iU(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.cew.getChildAt(1).setEnabled(false);
            this.cew.getChildAt(2).setEnabled(false);
        } else {
            this.cew.getChildAt(1).setEnabled(true);
            this.cew.getChildAt(2).setEnabled(true);
        }
        this.cew.setTabSelectionListener(new ab(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a iW = iW(i);
        if (iW instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b DW = iW.DW();
            fragmentTabIndicator.setText(DW.getTitle());
            FragmentTabIndicator.a Ea = DW.Ea();
            if (Ea != null) {
                if (fragmentTabIndicator.fM(DW.Eb()) == null) {
                    Ea.cX(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(DW.Eb(), Ea);
                }
                Ea.avQ = fragmentTabIndicator;
                if (DW.DZ() > 0) {
                    if (Ea.view instanceof TextView) {
                        ((TextView) Ea.view).setText(new StringBuilder(String.valueOf(DW.DZ())).toString());
                    }
                    Ea.view.setVisibility(0);
                    return;
                }
                Ea.view.setVisibility(8);
            }
        }
    }

    private void iU(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.avG = n.c.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.ceg.getResources().getDimension(n.d.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.cew.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        adq().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        iV(i);
        ado();
    }

    private void iV(int i) {
        com.baidu.tbadk.mvc.f.a.a iW = iW(this.cez);
        if (iW != null) {
            iW.DX();
        }
        this.ceg.adC();
        adq().d(i, true);
        this.cez = i;
        com.baidu.tbadk.mvc.f.a.a iW2 = iW(this.cez);
        if (iW2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            iW2.onPrimary();
            iW2.DY();
        }
    }

    public int getCurrentTabIndex() {
        return this.cez;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a iW = iW(this.cez);
        if (iW != null) {
            return iW.DW().Ec();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a iW(int i) {
        switch (i) {
            case 0:
                return this.ceg.adH();
            case 1:
                return this.ceg.adD();
            case 2:
                return this.ceg.adE();
            default:
                return this.ceg.adH();
        }
    }
}
