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
    protected NavigationBar aIp;
    private final CustomMessageListener aVr;
    private s bWA;
    private int bWB;
    private SingleMentionActivity bWm;
    private int bWx;
    private FragmentTabWidget bWy;
    private ViewPager bWz;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public n(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.mBack = null;
        this.bWx = 16;
        this.bWB = -1;
        this.aVr = new o(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.bWm = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.bWx = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.bWx = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bWx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.bWx = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bWx);
            if (this.bWx == 24) {
                i = 1;
            } else {
                i = this.bWx == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                ii(i);
                if (i == 1) {
                    this.bWm.abM().dU(true);
                    this.bWm.abM().onPrimary();
                    return;
                }
                this.bWm.abN().dU(true);
                this.bWm.abN().onPrimary();
                return;
            }
            ii(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abC() {
        int i = 1;
        if (getView() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.bWx != 24) {
                    if (this.bWx == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                ii(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oY() {
        this.rootView = this.bWm.getLayoutInflater().inflate(i.g.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oP() {
        this.aIp = (NavigationBar) getView().findViewById(i.f.view_navigation_bar);
        this.aIp.setTitleText(i.h.my_mention);
        this.mBack = this.aIp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        this.bWm.abM().a(this.aIp);
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new q(this));
        abG();
        getPageContext().registerListener(this.aVr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abD() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.bWm.getResources().getColor(i.c.backgroundcolor));
        }
        if (this.aIp != null) {
            this.aIp.onChangeSkinType(tbPageContext, i);
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        abF().onChangeSkinType(i);
        return true;
    }

    public void ii(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a im = im(i2);
            if (im != null && (im instanceof com.baidu.tbadk.mvc.f.a.a) && im.Ds().Dy() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.bWz.setCurrentItem(i2);
                this.bWy.d(i2, true);
            } else {
                this.bWB = i2;
            }
        }
        abE();
    }

    private void abE() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xo();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xp();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.bWm.getActivity(), str, "click", 1, new Object[0]);
        }
        n(getCurrentTabType(), true);
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
                com.baidu.tbadk.mvc.f.a.a im = im(i2);
                if (im instanceof k) {
                    com.baidu.tbadk.mvc.f.a.b Ds = im.Ds();
                    if (Ds.Dy() == i) {
                        kVar = (k) im;
                        textView = (TextView) Ds.Dw().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!ij(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        kVar.dU(true);
                    } else {
                        kVar.dU(false);
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
                com.baidu.tbadk.core.util.al.h((View) textView, i.e.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.al.h((View) textView, i.e.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.al.h((View) textView, i.e.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ij(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE() || com.baidu.tbadk.coreExtra.messageCenter.c.xw().xL();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xD()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void n(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgAtme();
        int xs = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xs();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xs;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        e(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.wZ().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    protected ViewPager getViewPager() {
        if (this.bWz != null) {
            return this.bWz;
        }
        if (getView() != null) {
            this.bWz = (ViewPager) getView().findViewById(i.f.fragment_pager);
            return this.bWz;
        }
        return null;
    }

    protected FragmentTabWidget abF() {
        if (this.bWy != null) {
            return this.bWy;
        }
        if (getView() != null) {
            this.bWy = (FragmentTabWidget) getView().findViewById(i.f.tab_widget);
            return this.bWy;
        }
        return null;
    }

    protected void abG() {
        initViewPager();
        Ok();
        this.bWA.notifyDataSetChanged();
        if (this.bWB == -1) {
            this.bWB = 0;
        }
        this.bWy.d(this.bWB, true);
        this.bWz.setCurrentItem(this.bWB);
        il(this.bWB);
    }

    private void initViewPager() {
        this.bWz = getViewPager();
        this.bWA = new s(this.bWm);
        this.bWz.setAdapter(this.bWA);
        this.bWz.setOnPageChangeListener(this);
    }

    private void Ok() {
        this.bWy = abF();
        for (int i = 0; i < 2; i++) {
            ik(i);
        }
        this.bWy.setTabSelectionListener(new r(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a im = im(i);
        if (im instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Ds = im.Ds();
            fragmentTabIndicator.setText(Ds.getTitle());
            FragmentTabIndicator.a Dw = Ds.Dw();
            if (Dw != null) {
                if (fragmentTabIndicator.fr(Ds.Dx()) == null) {
                    Dw.cO(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(Ds.Dx(), Dw);
                }
                Dw.awy = fragmentTabIndicator;
                if (Ds.Dv() > 0) {
                    if (Dw.view instanceof TextView) {
                        ((TextView) Dw.view).setText(new StringBuilder(String.valueOf(Ds.Dv())).toString());
                    }
                    Dw.view.setVisibility(0);
                    return;
                }
                Dw.view.setVisibility(8);
            }
        }
    }

    private void ik(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.awo = i.c.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, this.bWm.getResources().getDimension(i.d.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.bWy.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        abF().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        il(i);
        abE();
    }

    private void il(int i) {
        com.baidu.tbadk.mvc.f.a.a im = im(this.bWB);
        if (im != null) {
            im.Dt();
        }
        abF().d(i, true);
        this.bWB = i;
        com.baidu.tbadk.mvc.f.a.a im2 = im(this.bWB);
        if (im2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            im2.onPrimary();
            im2.Du();
        }
    }

    public int getCurrentTabIndex() {
        return this.bWB;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a im = im(this.bWB);
        if (im != null) {
            return im.Ds().Dy();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a im(int i) {
        return i == 0 ? this.bWm.abM() : this.bWm.abN();
    }
}
