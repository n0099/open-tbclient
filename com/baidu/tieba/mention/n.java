package com.baidu.tieba.mention;

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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<SingleMentionActivity> implements ViewPager.OnPageChangeListener {
    protected NavigationBar aHt;
    private final CustomMessageListener aUC;
    private SingleMentionActivity caj;
    private int cau;
    private FragmentTabWidget cav;
    private ViewPager caw;
    private s cax;
    private int cay;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public n(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.mBack = null;
        this.cau = 16;
        this.cay = -1;
        this.aUC = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.caj = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.cau = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.cau = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cau);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.cau = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cau);
            if (this.cau == 24) {
                i = 1;
            } else {
                i = this.cau == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                iq(i);
                if (i == 1) {
                    this.caj.ada().dV(true);
                    this.caj.ada().onPrimary();
                    return;
                }
                this.caj.adb().dV(true);
                this.caj.adb().onPrimary();
                return;
            }
            iq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acM() {
        int i = 1;
        if (getView() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.cau != 24) {
                    if (this.cau == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                iq(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oZ() {
        this.rootView = this.caj.getLayoutInflater().inflate(i.g.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.aHt = (NavigationBar) getView().findViewById(i.f.view_navigation_bar);
        this.aHt.setTitleText(i.h.my_mention);
        this.mBack = this.aHt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        this.caj.ada().a(this.aHt);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new q(this));
        acQ();
        getPageContext().registerListener(this.aUC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acN() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.caj.getResources().getColor(i.c.backgroundcolor));
        }
        if (this.aHt != null) {
            this.aHt.onChangeSkinType(tbPageContext, i);
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        acP().onChangeSkinType(i);
        return true;
    }

    public void iq(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a iu = iu(i2);
            if (iu != null && (iu instanceof com.baidu.tbadk.mvc.f.a.a) && iu.Dc().Di() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.caw.setCurrentItem(i2);
                this.cav.d(i2, true);
            } else {
                this.cay = i2;
            }
        }
        acO();
    }

    private void acO() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wH().wW();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wH().wX();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.caj.getActivity(), str, "click", 1, new Object[0]);
        }
        o(getCurrentTabType(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            f(new int[]{newsNotifyMessage.getMsgChat(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme()});
        }
    }

    private void f(int[] iArr) {
        TextView textView;
        k kVar;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    textView = null;
                    kVar = null;
                    break;
                }
                com.baidu.tbadk.mvc.f.a.a iu = iu(i2);
                if (iu instanceof k) {
                    com.baidu.tbadk.mvc.f.a.b Dc = iu.Dc();
                    if (Dc.Di() == i) {
                        kVar = (k) iu;
                        textView = (TextView) Dc.Dg().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!ir(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        kVar.dV(true);
                    } else {
                        kVar.dV(false);
                    }
                    m(textView, i3);
                }
            }
        }
    }

    private void m(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.an.b(textView, i.c.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.an.i((View) textView, i.e.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.an.i((View) textView, i.e.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.an.i((View) textView, i.e.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ir(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xe().xm() || com.baidu.tbadk.coreExtra.messageCenter.c.xe().xt();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xe().xl()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xe().xj()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xe().xj()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void o(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgAtme();
        int xa = com.baidu.tbadk.coreExtra.messageCenter.a.wH().xa();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wH().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xa;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        f(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.wH().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    protected ViewPager getViewPager() {
        if (this.caw != null) {
            return this.caw;
        }
        if (getView() != null) {
            this.caw = (ViewPager) getView().findViewById(i.f.fragment_pager);
            return this.caw;
        }
        return null;
    }

    protected FragmentTabWidget acP() {
        if (this.cav != null) {
            return this.cav;
        }
        if (getView() != null) {
            this.cav = (FragmentTabWidget) getView().findViewById(i.f.tab_widget);
            return this.cav;
        }
        return null;
    }

    protected void acQ() {
        initViewPager();
        Oh();
        this.cax.notifyDataSetChanged();
        if (this.cay == -1) {
            this.cay = 0;
        }
        this.cav.d(this.cay, true);
        this.caw.setCurrentItem(this.cay);
        it(this.cay);
    }

    private void initViewPager() {
        this.caw = getViewPager();
        this.cax = new s(this.caj);
        this.caw.setAdapter(this.cax);
        this.caw.setOnPageChangeListener(this);
    }

    private void Oh() {
        this.cav = acP();
        for (int i = 0; i < 2; i++) {
            is(i);
        }
        this.cav.setTabSelectionListener(new r(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a iu = iu(i);
        if (iu instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Dc = iu.Dc();
            fragmentTabIndicator.setText(Dc.getTitle());
            FragmentTabIndicator.a Dg = Dc.Dg();
            if (Dg != null) {
                if (fragmentTabIndicator.fw(Dc.Dh()) == null) {
                    Dg.cP(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(Dc.Dh(), Dg);
                }
                Dg.auY = fragmentTabIndicator;
                if (Dc.Df() > 0) {
                    if (Dg.view instanceof TextView) {
                        ((TextView) Dg.view).setText(new StringBuilder(String.valueOf(Dc.Df())).toString());
                    }
                    Dg.view.setVisibility(0);
                    return;
                }
                Dg.view.setVisibility(8);
            }
        }
    }

    private void is(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.auO = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.caj.getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.cav.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        acP().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        it(i);
        acO();
    }

    private void it(int i) {
        com.baidu.tbadk.mvc.f.a.a iu = iu(this.cay);
        if (iu != null) {
            iu.Dd();
        }
        acP().d(i, true);
        this.cay = i;
        com.baidu.tbadk.mvc.f.a.a iu2 = iu(this.cay);
        if (iu2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            iu2.onPrimary();
            iu2.De();
        }
    }

    public int getCurrentTabIndex() {
        return this.cay;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a iu = iu(this.cay);
        if (iu != null) {
            return iu.Dc().Di();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a iu(int i) {
        return i == 0 ? this.caj.ada() : this.caj.adb();
    }
}
