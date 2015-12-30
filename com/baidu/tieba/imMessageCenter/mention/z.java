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
public class z extends com.baidu.adp.base.f<bd> implements ViewPager.OnPageChangeListener {
    private final CustomMessageListener bdV;
    private ad ciA;
    private int ciB;
    private bd cih;
    private int cix;
    private FragmentTabWidget ciy;
    private CustomViewPager ciz;
    private View mBack;
    private NoNetworkView mNoNetworkView;
    private View rootView;

    public z(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.mBack = null;
        this.cix = 16;
        this.ciB = -1;
        this.bdV = new aa(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.cih = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.cix = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.cix = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cix);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.cix = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.cix != -1) {
                int i = 0;
                if (this.cix == 24) {
                    i = 1;
                } else if (this.cix == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    jr(i);
                    if (i == 0) {
                        this.cih.aeP().ec(true);
                        this.cih.aeP().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.cih.aeL().ec(true);
                        this.cih.aeL().onPrimary();
                        return;
                    } else {
                        this.cih.aeM().ec(true);
                        this.cih.aeM().onPrimary();
                        return;
                    }
                }
                jr(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aev() {
        int i = 1;
        if (getView() != null) {
            if (this.cix != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.cix != 24) {
                    if (this.cix == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                jr(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oE() {
        this.rootView = this.cih.getActivity().getLayoutInflater().inflate(n.h.mention_activity, (ViewGroup) null);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ov() {
        this.mNoNetworkView = (NoNetworkView) getView().findViewById(n.g.view_no_network);
        this.mNoNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoNetworkView.a(new ab(this));
        Ke();
        this.cih.registerListener(this.bdV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aew() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.cih.getResources().getColor(n.d.backgroundcolor));
        }
        if (this.mNoNetworkView != null) {
            this.mNoNetworkView.onChangeSkinType(getPageContext(), i);
        }
        aez().onChangeSkinType(i);
        return true;
    }

    public void jr(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a jv = jv(i2);
            if (jv != null && (jv instanceof com.baidu.tbadk.mvc.f.a.a) && jv.DL().DR() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.cih.aeK();
                this.ciz.setCurrentItem(i2);
                this.ciy.d(i2, true);
                return;
            }
            this.ciB = i2;
        }
    }

    private void aex() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().xI();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().xK();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().xL();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.cih.getActivity(), str, "click", 1, new Object[0]);
        }
        o(getCurrentTabType(), true);
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
        w wVar;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    textView = null;
                    wVar = null;
                    break;
                }
                com.baidu.tbadk.mvc.f.a.a jv = jv(i2);
                if (jv instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b DL = jv.DL();
                    if (DL.DR() == i) {
                        wVar = (w) jv;
                        textView = (TextView) DL.DP().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!js(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.ec(true);
                    } else {
                        wVar.ec(false);
                    }
                    p(textView, i3);
                }
            }
        }
    }

    private void p(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(textView, n.d.frs_slidebar_message_text, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.as.i((View) textView, n.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.as.i((View) textView, n.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.as.i((View) textView, n.f.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean js(int i) {
        switch (i) {
            case 0:
                return com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya() || com.baidu.tbadk.coreExtra.messageCenter.c.xS().yh();
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ()) {
                    return false;
                }
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX()) {
                    return false;
                }
                return true;
            case 2:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX()) {
                }
                return true;
            default:
                return true;
        }
    }

    public void o(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgReplyme();
        int xC = com.baidu.tbadk.coreExtra.messageCenter.a.xv().xC();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgAtme();
        int xO = com.baidu.tbadk.coreExtra.messageCenter.a.xv().xO();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = xO - xC;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        g(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.xv().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager aey() {
        if (this.ciz != null) {
            return this.ciz;
        }
        if (getView() != null) {
            this.ciz = (CustomViewPager) getView().findViewById(n.g.fragment_pager);
            return this.ciz;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget aez() {
        if (this.ciy != null) {
            return this.ciy;
        }
        if (getView() != null) {
            this.ciy = (FragmentTabWidget) getView().findViewById(n.g.tab_widget);
            return this.ciy;
        }
        return null;
    }

    protected void Ke() {
        initViewPager();
        Kd();
        this.ciA.notifyDataSetChanged();
        if (this.ciB == -1) {
            this.ciB = 0;
        }
        this.cih.aeK();
        this.ciy.d(this.ciB, true);
        this.ciz.setCurrentItem(this.ciB);
        ju(this.ciB);
    }

    private void initViewPager() {
        this.ciz = aey();
        this.ciA = new ad(this.cih);
        this.ciz.setAdapter(this.ciA);
        if (!TbadkCoreApplication.isLogin()) {
            this.ciz.setScrollable(false);
        } else {
            this.ciz.setScrollable(true);
        }
        this.ciz.setOnPageChangeListener(this);
    }

    private void Kd() {
        this.ciy = aez();
        for (int i = 0; i < 3; i++) {
            jt(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.ciy.getChildAt(1).setEnabled(false);
            this.ciy.getChildAt(2).setEnabled(false);
        } else {
            this.ciy.getChildAt(1).setEnabled(true);
            this.ciy.getChildAt(2).setEnabled(true);
        }
        this.ciy.setTabSelectionListener(new ac(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a jv = jv(i);
        if (jv instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b DL = jv.DL();
            fragmentTabIndicator.setText(DL.getTitle());
            FragmentTabIndicator.a DP = DL.DP();
            if (DP != null) {
                if (fragmentTabIndicator.fQ(DL.DQ()) == null) {
                    DP.cR(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(DL.DQ(), DP);
                }
                DP.axu = fragmentTabIndicator;
                if (DL.DO() > 0) {
                    if (DP.view instanceof TextView) {
                        ((TextView) DP.view).setText(new StringBuilder(String.valueOf(DL.DO())).toString());
                    }
                    DP.view.setVisibility(0);
                    return;
                }
                DP.view.setVisibility(8);
            }
        }
    }

    private void jt(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.axk = n.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.cih.getResources().getDimension(n.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.ciy.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        aez().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ju(i);
        aex();
    }

    private void ju(int i) {
        com.baidu.tbadk.mvc.f.a.a jv = jv(this.ciB);
        if (jv != null) {
            jv.DM();
        }
        this.cih.aeK();
        aez().d(i, true);
        this.ciB = i;
        com.baidu.tbadk.mvc.f.a.a jv2 = jv(this.ciB);
        if (jv2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            jv2.onPrimary();
            jv2.DN();
        }
    }

    public int getCurrentTabIndex() {
        return this.ciB;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a jv = jv(this.ciB);
        if (jv != null) {
            return jv.DL().DR();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a jv(int i) {
        switch (i) {
            case 0:
                return this.cih.aeP();
            case 1:
                return this.cih.aeL();
            case 2:
                return this.cih.aeM();
            default:
                return this.cih.aeP();
        }
    }
}
