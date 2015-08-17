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
    protected NavigationBar aIc;
    private final CustomMessageListener aVd;
    private SingleMentionActivity bVG;
    private int bVR;
    private FragmentTabWidget bVS;
    private ViewPager bVT;
    private s bVU;
    private int bVV;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public n(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.mBack = null;
        this.bVR = 16;
        this.bVV = -1;
        this.aVd = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.bVG = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.bVR = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.bVR = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.bVR = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bVR);
            if (this.bVR == 24) {
                i = 1;
            } else {
                i = this.bVR == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                hX(i);
                if (i == 1) {
                    this.bVG.abH().dP(true);
                    this.bVG.abH().onPrimary();
                    return;
                }
                this.bVG.abI().dP(true);
                this.bVG.abI().onPrimary();
                return;
            }
            hX(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abx() {
        int i = 1;
        if (getView() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.bVR != 24) {
                    if (this.bVR == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                hX(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pb() {
        this.rootView = this.bVG.getLayoutInflater().inflate(i.g.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oS() {
        this.aIc = (NavigationBar) getView().findViewById(i.f.view_navigation_bar);
        this.aIc.setTitleText(i.C0057i.my_mention);
        this.mBack = this.aIc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        this.bVG.abH().a(this.aIc);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new q(this));
        abB();
        getPageContext().registerListener(this.aVd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.bVG.getResources().getColor(i.c.backgroundcolor));
        }
        if (this.aIc != null) {
            this.aIc.onChangeSkinType(tbPageContext, i);
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        abA().onChangeSkinType(i);
        return true;
    }

    public void hX(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a ib = ib(i2);
            if (ib != null && (ib instanceof com.baidu.tbadk.mvc.f.a.a) && ib.Di().Do() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.bVT.setCurrentItem(i2);
                this.bVS.d(i2, true);
            } else {
                this.bVV = i2;
            }
        }
        abz();
    }

    private void abz() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().xi();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().xj();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.bVG.getActivity(), str, "click", 1, new Object[0]);
        }
        m(getCurrentTabType(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            e(new int[]{newsNotifyMessage.getMsgChat(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme()});
        }
    }

    private void e(int[] iArr) {
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
                com.baidu.tbadk.mvc.f.a.a ib = ib(i2);
                if (ib instanceof k) {
                    com.baidu.tbadk.mvc.f.a.b Di = ib.Di();
                    if (Di.Do() == i) {
                        kVar = (k) ib;
                        textView = (TextView) Di.Dm().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!hY(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        kVar.dP(true);
                    } else {
                        kVar.dP(false);
                    }
                    m(textView, i3);
                }
            }
        }
    }

    private void m(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.al.b(textView, i.c.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.al.i((View) textView, i.e.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.al.i((View) textView, i.e.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.al.i((View) textView, i.e.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hY(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy() || com.baidu.tbadk.coreExtra.messageCenter.c.xq().xF();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xx()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void m(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgAtme();
        int xm = com.baidu.tbadk.coreExtra.messageCenter.a.wT().xm();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xm;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        e(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.wT().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    protected ViewPager getViewPager() {
        if (this.bVT != null) {
            return this.bVT;
        }
        if (getView() != null) {
            this.bVT = (ViewPager) getView().findViewById(i.f.fragment_pager);
            return this.bVT;
        }
        return null;
    }

    protected FragmentTabWidget abA() {
        if (this.bVS != null) {
            return this.bVS;
        }
        if (getView() != null) {
            this.bVS = (FragmentTabWidget) getView().findViewById(i.f.tab_widget);
            return this.bVS;
        }
        return null;
    }

    protected void abB() {
        initViewPager();
        Oj();
        this.bVU.notifyDataSetChanged();
        if (this.bVV == -1) {
            this.bVV = 0;
        }
        this.bVS.d(this.bVV, true);
        this.bVT.setCurrentItem(this.bVV);
        ia(this.bVV);
    }

    private void initViewPager() {
        this.bVT = getViewPager();
        this.bVU = new s(this.bVG);
        this.bVT.setAdapter(this.bVU);
        this.bVT.setOnPageChangeListener(this);
    }

    private void Oj() {
        this.bVS = abA();
        for (int i = 0; i < 2; i++) {
            hZ(i);
        }
        this.bVS.setTabSelectionListener(new r(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a ib = ib(i);
        if (ib instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Di = ib.Di();
            fragmentTabIndicator.setText(Di.getTitle());
            FragmentTabIndicator.a Dm = Di.Dm();
            if (Dm != null) {
                if (fragmentTabIndicator.fj(Di.Dn()) == null) {
                    Dm.cI(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(Di.Dn(), Dm);
                }
                Dm.auQ = fragmentTabIndicator;
                if (Di.Dl() > 0) {
                    if (Dm.view instanceof TextView) {
                        ((TextView) Dm.view).setText(new StringBuilder(String.valueOf(Di.Dl())).toString());
                    }
                    Dm.view.setVisibility(0);
                    return;
                }
                Dm.view.setVisibility(8);
            }
        }
    }

    private void hZ(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.auG = i.c.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, this.bVG.getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.bVS.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        abA().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ia(i);
        abz();
    }

    private void ia(int i) {
        com.baidu.tbadk.mvc.f.a.a ib = ib(this.bVV);
        if (ib != null) {
            ib.Dj();
        }
        abA().d(i, true);
        this.bVV = i;
        com.baidu.tbadk.mvc.f.a.a ib2 = ib(this.bVV);
        if (ib2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            ib2.onPrimary();
            ib2.Dk();
        }
    }

    public int getCurrentTabIndex() {
        return this.bVV;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a ib = ib(this.bVV);
        if (ib != null) {
            return ib.Di().Do();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a ib(int i) {
        return i == 0 ? this.bVG.abH() : this.bVG.abI();
    }
}
