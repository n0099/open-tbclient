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
    protected NavigationBar aHi;
    private final CustomMessageListener aUr;
    private SingleMentionActivity bZY;
    private int caj;
    private FragmentTabWidget cak;
    private ViewPager cal;
    private s cam;
    private int can;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public n(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.mBack = null;
        this.caj = 16;
        this.can = -1;
        this.aUr = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.bZY = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.caj = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.caj = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.caj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.caj = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.caj);
            if (this.caj == 24) {
                i = 1;
            } else {
                i = this.caj == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                iq(i);
                if (i == 1) {
                    this.bZY.ade().dV(true);
                    this.bZY.ade().onPrimary();
                    return;
                }
                this.bZY.adf().dV(true);
                this.bZY.adf().onPrimary();
                return;
            }
            iq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acQ() {
        int i = 1;
        if (getView() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.caj != 24) {
                    if (this.caj == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                iq(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oZ() {
        this.rootView = this.bZY.getLayoutInflater().inflate(i.g.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.aHi = (NavigationBar) getView().findViewById(i.f.view_navigation_bar);
        this.aHi.setTitleText(i.h.my_mention);
        this.mBack = this.aHi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        this.bZY.ade().a(this.aHi);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new q(this));
        acU();
        getPageContext().registerListener(this.aUr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acR() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.bZY.getResources().getColor(i.c.backgroundcolor));
        }
        if (this.aHi != null) {
            this.aHi.onChangeSkinType(tbPageContext, i);
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        acT().onChangeSkinType(i);
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
            if (iu != null && (iu instanceof com.baidu.tbadk.mvc.f.a.a) && iu.Df().Dl() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.cal.setCurrentItem(i2);
                this.cak.d(i2, true);
            } else {
                this.can = i2;
            }
        }
        acS();
    }

    private void acS() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().wZ();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().xa();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.bZY.getActivity(), str, "click", 1, new Object[0]);
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
                    com.baidu.tbadk.mvc.f.a.b Df = iu.Df();
                    if (Df.Dl() == i) {
                        kVar = (k) iu;
                        textView = (TextView) Df.Dj().view;
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
            com.baidu.tbadk.core.util.am.b(textView, i.c.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.am.i((View) textView, i.e.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.am.i((View) textView, i.e.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.am.i((View) textView, i.e.icon_news_head_prompt_more);
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
                return com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp() || com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void o(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgAtme();
        int xd = com.baidu.tbadk.coreExtra.messageCenter.a.wK().xd();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xd;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        f(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.wK().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    protected ViewPager getViewPager() {
        if (this.cal != null) {
            return this.cal;
        }
        if (getView() != null) {
            this.cal = (ViewPager) getView().findViewById(i.f.fragment_pager);
            return this.cal;
        }
        return null;
    }

    protected FragmentTabWidget acT() {
        if (this.cak != null) {
            return this.cak;
        }
        if (getView() != null) {
            this.cak = (FragmentTabWidget) getView().findViewById(i.f.tab_widget);
            return this.cak;
        }
        return null;
    }

    protected void acU() {
        initViewPager();
        Ol();
        this.cam.notifyDataSetChanged();
        if (this.can == -1) {
            this.can = 0;
        }
        this.cak.d(this.can, true);
        this.cal.setCurrentItem(this.can);
        it(this.can);
    }

    private void initViewPager() {
        this.cal = getViewPager();
        this.cam = new s(this.bZY);
        this.cal.setAdapter(this.cam);
        this.cal.setOnPageChangeListener(this);
    }

    private void Ol() {
        this.cak = acT();
        for (int i = 0; i < 2; i++) {
            is(i);
        }
        this.cak.setTabSelectionListener(new r(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a iu = iu(i);
        if (iu instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Df = iu.Df();
            fragmentTabIndicator.setText(Df.getTitle());
            FragmentTabIndicator.a Dj = Df.Dj();
            if (Dj != null) {
                if (fragmentTabIndicator.fw(Df.Dk()) == null) {
                    Dj.cP(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(Df.Dk(), Dj);
                }
                Dj.auX = fragmentTabIndicator;
                if (Df.Di() > 0) {
                    if (Dj.view instanceof TextView) {
                        ((TextView) Dj.view).setText(new StringBuilder(String.valueOf(Df.Di())).toString());
                    }
                    Dj.view.setVisibility(0);
                    return;
                }
                Dj.view.setVisibility(8);
            }
        }
    }

    private void is(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.auN = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.bZY.getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.cak.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        acT().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        it(i);
        acS();
    }

    private void it(int i) {
        com.baidu.tbadk.mvc.f.a.a iu = iu(this.can);
        if (iu != null) {
            iu.Dg();
        }
        acT().d(i, true);
        this.can = i;
        com.baidu.tbadk.mvc.f.a.a iu2 = iu(this.can);
        if (iu2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            iu2.onPrimary();
            iu2.Dh();
        }
    }

    public int getCurrentTabIndex() {
        return this.can;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a iu = iu(this.can);
        if (iu != null) {
            return iu.Df().Dl();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a iu(int i) {
        return i == 0 ? this.bZY.ade() : this.bZY.adf();
    }
}
