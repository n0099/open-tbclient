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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<bd> implements ViewPager.OnPageChangeListener {
    private NoNetworkView NR;
    private View ajk;
    private View azA;
    private final CustomMessageListener bgq;
    private bd cmH;
    private int cmX;
    private FragmentTabWidget cmY;
    private CustomViewPager cmZ;
    private ad cna;
    private int cnb;

    public z(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.ajk = null;
        this.cmX = 16;
        this.cnb = -1;
        this.bgq = new aa(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.cmH = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.cmX = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.cmX = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.cmX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.cmX = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.cmX != -1) {
                int i = 0;
                if (this.cmX == 24) {
                    i = 1;
                } else if (this.cmX == 25) {
                    i = 2;
                }
                if (getCurrentTabType() == i) {
                    jP(i);
                    if (i == 0) {
                        this.cmH.ahY().ej(true);
                        this.cmH.ahY().onPrimary();
                        return;
                    } else if (i == 1) {
                        this.cmH.ahU().ej(true);
                        this.cmH.ahU().onPrimary();
                        return;
                    } else {
                        this.cmH.ahV().ej(true);
                        this.cmH.ahV().onPrimary();
                        return;
                    }
                }
                jP(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahF() {
        int i = 1;
        if (getView() != null) {
            if (this.cmX != 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 0));
            }
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.cmX != 24) {
                    if (this.cmX == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgChat() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgReplyme() <= 0) {
                        i = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgAtme() > 0 ? 2 : 0;
                    }
                }
                jP(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pa() {
        this.azA = this.cmH.getActivity().getLayoutInflater().inflate(t.h.mention_activity, (ViewGroup) null);
        return this.azA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.NR = (NoNetworkView) getView().findViewById(t.g.view_no_network);
        this.NR.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.NR.a(new ab(this));
        LW();
        this.cmH.registerListener(this.bgq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahG() {
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(this.cmH.getResources().getColor(t.d.backgroundcolor));
        }
        if (this.NR != null) {
            this.NR.onChangeSkinType(getPageContext(), i);
        }
        ahJ().onChangeSkinType(i);
        return true;
    }

    public void jP(int i) {
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.f.a.a jS = jS(i2);
            if (jS != null && (jS instanceof com.baidu.tbadk.mvc.f.a.a) && jS.Ff().Fl() == i) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.cmH.ahT();
                this.cmZ.setCurrentItem(i2);
                this.cmY.d(i2, true);
                return;
            }
            this.cnb = i2;
        }
    }

    private void ahH() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().za();
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().zc();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().zd();
        }
        if (str != null) {
            TiebaStatic.eventStat(this.cmH.getActivity(), str, "click", 1, new Object[0]);
        }
        p(getCurrentTabType(), true);
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
                com.baidu.tbadk.mvc.f.a.a jS = jS(i2);
                if (jS instanceof w) {
                    com.baidu.tbadk.mvc.f.a.b Ff = jS.Ff();
                    if (Ff.Fl() == i) {
                        wVar = (w) jS;
                        textView = (TextView) Ff.Fj().view;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!com.baidu.tieba.imMessageCenter.im.chat.notify.r.jC(i)) {
                    textView.setVisibility(8);
                } else {
                    if (i3 > 0) {
                        wVar.ej(true);
                    } else {
                        wVar.ej(false);
                    }
                    r(textView, i3);
                }
            }
        }
    }

    private void r(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.frs_slidebar_message_text, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.ar.k(textView, t.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.ar.k(textView, t.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.ar.k(textView, t.f.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void p(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgReplyme();
        int yU = com.baidu.tbadk.coreExtra.messageCenter.a.yN().yU();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgAtme();
        int zg = com.baidu.tbadk.coreExtra.messageCenter.a.yN().zg();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = zg - yU;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        g(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.yN().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    public View getView() {
        return this.azA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomViewPager ahI() {
        if (this.cmZ != null) {
            return this.cmZ;
        }
        if (getView() != null) {
            this.cmZ = (CustomViewPager) getView().findViewById(t.g.fragment_pager);
            return this.cmZ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTabWidget ahJ() {
        if (this.cmY != null) {
            return this.cmY;
        }
        if (getView() != null) {
            this.cmY = (FragmentTabWidget) getView().findViewById(t.g.tab_widget);
            return this.cmY;
        }
        return null;
    }

    protected void LW() {
        initViewPager();
        LV();
        this.cna.notifyDataSetChanged();
        if (this.cnb == -1) {
            this.cnb = 0;
        }
        this.cmH.ahT();
        this.cmY.d(this.cnb, true);
        this.cmZ.setCurrentItem(this.cnb);
        jR(this.cnb);
    }

    private void initViewPager() {
        this.cmZ = ahI();
        this.cna = new ad(this.cmH);
        this.cmZ.setAdapter(this.cna);
        if (!TbadkCoreApplication.isLogin()) {
            this.cmZ.setScrollable(false);
        } else {
            this.cmZ.setScrollable(true);
        }
        this.cmZ.setOnPageChangeListener(this);
    }

    private void LV() {
        this.cmY = ahJ();
        for (int i = 0; i < 3; i++) {
            jQ(i);
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.cmY.getChildAt(1).setEnabled(false);
            this.cmY.getChildAt(2).setEnabled(false);
        } else {
            this.cmY.getChildAt(1).setEnabled(true);
            this.cmY.getChildAt(2).setEnabled(true);
        }
        this.cmY.setTabSelectionListener(new ac(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.f.a.a jS = jS(i);
        if (jS instanceof com.baidu.tbadk.mvc.f.a.a) {
            com.baidu.tbadk.mvc.f.a.b Ff = jS.Ff();
            fragmentTabIndicator.setText(Ff.getTitle());
            FragmentTabIndicator.a Fj = Ff.Fj();
            if (Fj != null) {
                if (fragmentTabIndicator.fO(Ff.Fk()) == null) {
                    Fj.dk(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(Ff.Fk(), Fj);
                }
                Fj.ayn = fragmentTabIndicator;
                if (Ff.Fi() > 0) {
                    if (Fj.view instanceof TextView) {
                        ((TextView) Fj.view).setText(new StringBuilder(String.valueOf(Ff.Fi())).toString());
                    }
                    Fj.view.setVisibility(0);
                    return;
                }
                Fj.view.setVisibility(8);
            }
        }
    }

    private void jQ(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.ayd = t.d.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, this.cmH.getResources().getDimension(t.e.ds28));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.cmY.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ahJ().b(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        jR(i);
        ahH();
    }

    private void jR(int i) {
        com.baidu.tbadk.mvc.f.a.a jS = jS(this.cnb);
        if (jS != null) {
            jS.Fg();
        }
        this.cmH.ahT();
        ahJ().d(i, true);
        this.cnb = i;
        com.baidu.tbadk.mvc.f.a.a jS2 = jS(this.cnb);
        if (jS2 instanceof com.baidu.tbadk.mvc.f.a.a) {
            jS2.onPrimary();
            jS2.Fh();
        }
    }

    public int getCurrentTabIndex() {
        return this.cnb;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.f.a.a jS = jS(this.cnb);
        if (jS != null) {
            return jS.Ff().Fl();
        }
        return -1;
    }

    public com.baidu.tbadk.mvc.f.a.a jS(int i) {
        switch (i) {
            case 0:
                return this.cmH.ahY();
            case 1:
                return this.cmH.ahU();
            case 2:
                return this.cmH.ahV();
            default:
                return this.cmH.ahY();
        }
    }
}
