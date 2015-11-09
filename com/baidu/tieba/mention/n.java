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
    protected NavigationBar aGn;
    private final CustomMessageListener aUK;
    private SingleMentionActivity caK;
    private int caV;
    private FragmentTabWidget caW;
    private ViewPager caX;
    private s caY;
    private int caZ;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public n(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.mBack = null;
        this.caV = 16;
        this.caZ = -1;
        this.aUK = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.caK = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.caV = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.caV = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.caV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.caV = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.caV);
            if (this.caV == 24) {
                i = 1;
            } else {
                i = this.caV == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                iD(i);
                if (i == 1) {
                    this.caK.adv().dX(true);
                    this.caK.adv().onPrimary();
                    return;
                }
                this.caK.adw().dX(true);
                this.caK.adw().onPrimary();
                return;
            }
            iD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adh() {
        int i = 1;
        if (getView() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.caV != 24) {
                    if (this.caV == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                iD(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pa() {
        this.rootView = this.caK.getLayoutInflater().inflate(i.g.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oR() {
        this.aGn = (NavigationBar) getView().findViewById(i.f.view_navigation_bar);
        this.aGn.setTitleText(i.h.my_mention);
        this.mBack = this.aGn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        this.caK.adv().a(this.aGn);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new q(this));
        adl();
        getPageContext().registerListener(this.aUK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adi() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.caK.getResources().getColor(i.c.backgroundcolor));
        }
        if (this.aGn != null) {
            this.aGn.onChangeSkinType(tbPageContext, i);
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        adk().onChangeSkinType(i);
        return true;
    }

    public void iD(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a iH = iH(i2);
            if (iH != null && (iH instanceof com.baidu.tbadk.mvc.f.a.a) && iH.CV().Db() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.caX.setCurrentItem(i2);
                this.caW.d(i2, true);
            } else {
                this.caZ = i2;
            }
        }
        adj();
    }

    private void adj() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().xb();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().xc();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.caK.getActivity(), str, "click", 1, new Object[0]);
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
                com.baidu.tbadk.mvc.f.a.a iH = iH(i2);
                if (iH instanceof k) {
                    com.baidu.tbadk.mvc.f.a.b CV = iH.CV();
                    if (CV.Db() == i) {
                        kVar = (k) iH;
                        textView = (TextView) CV.CZ().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!iE(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        kVar.dX(true);
                    } else {
                        kVar.dX(false);
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
    private boolean iE(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr() || com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xq()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void o(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgAtme();
        int xf = com.baidu.tbadk.coreExtra.messageCenter.a.wM().xf();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xf;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        f(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.wM().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    protected ViewPager getViewPager() {
        if (this.caX != null) {
            return this.caX;
        }
        if (getView() != null) {
            this.caX = (ViewPager) getView().findViewById(i.f.fragment_pager);
            return this.caX;
        }
        return null;
    }

    protected FragmentTabWidget adk() {
        if (this.caW != null) {
            return this.caW;
        }
        if (getView() != null) {
            this.caW = (FragmentTabWidget) getView().findViewById(i.f.tab_widget);
            return this.caW;
        }
        return null;
    }

    protected void adl() {
        initViewPager();
        OD();
        this.caY.notifyDataSetChanged();
        if (this.caZ == -1) {
            this.caZ = 0;
        }
        this.caW.d(this.caZ, true);
        this.caX.setCurrentItem(this.caZ);
        iG(this.caZ);
    }

    private void initViewPager() {
        this.caX = getViewPager();
        this.caY = new s(this.caK);
        this.caX.setAdapter(this.caY);
        this.caX.setOnPageChangeListener(this);
    }

    private void OD() {
        this.caW = adk();
        for (int i = 0; i < 2; i++) {
            iF(i);
        }
        this.caW.setTabSelectionListener(new r(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a iH = iH(i);
        if (iH instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b CV = iH.CV();
            fragmentTabIndicator.setText(CV.getTitle());
            FragmentTabIndicator.a CZ = CV.CZ();
            if (CZ != null) {
                if (fragmentTabIndicator.fy(CV.Da()) == null) {
                    CZ.cP(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(CV.Da(), CZ);
                }
                CZ.atM = fragmentTabIndicator;
                if (CV.CY() > 0) {
                    if (CZ.view instanceof TextView) {
                        ((TextView) CZ.view).setText(new StringBuilder(String.valueOf(CV.CY())).toString());
                    }
                    CZ.view.setVisibility(0);
                    return;
                }
                CZ.view.setVisibility(8);
            }
        }
    }

    private void iF(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.atC = i.c.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.caK.getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.caW.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        adk().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        iG(i);
        adj();
    }

    private void iG(int i) {
        com.baidu.tbadk.mvc.f.a.a iH = iH(this.caZ);
        if (iH != null) {
            iH.CW();
        }
        adk().d(i, true);
        this.caZ = i;
        com.baidu.tbadk.mvc.f.a.a iH2 = iH(this.caZ);
        if (iH2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            iH2.onPrimary();
            iH2.CX();
        }
    }

    public int getCurrentTabIndex() {
        return this.caZ;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a iH = iH(this.caZ);
        if (iH != null) {
            return iH.CV().Db();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a iH(int i) {
        return i == 0 ? this.caK.adv() : this.caK.adw();
    }
}
