package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.g.b.e {
    private final CustomMessageListener aLQ;
    private int bGe;
    private View mBack;

    public n(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.mBack = null;
        this.bGe = 16;
        this.aLQ = new o(this, 2001124);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (MentionActivityConfig.jumpInTab != -1) {
            this.bGe = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.bGe = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bGe);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.bGe = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bGe);
            if (this.bGe == 24) {
                i = 1;
            } else {
                i = this.bGe == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                ea(i);
                com.baidu.tbadk.mvc.core.c dU = dU(getCurrentTabIndex());
                if (dU instanceof l) {
                    ((l) dU).dE(true);
                    ((l) dU).onPrimary();
                    return;
                }
                return;
            }
            ea(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void AT() {
        int i = 1;
        super.AT();
        if (Bb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.bGe != 24) {
                    if (this.bGe == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                ea(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.e, com.baidu.tbadk.mvc.core.c
    public void oL() {
        super.oL();
        CG();
        getPageContext().registerListener(this.aLQ);
    }

    @Override // com.baidu.tbadk.mvc.g.b.e
    protected com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar) {
        com.baidu.tbadk.mvc.g.a.d dVar = new com.baidu.tbadk.mvc.g.a.d(getPageContext(), this.aox, AM());
        this.aox.setTitleText(com.baidu.tieba.t.my_mention);
        this.mBack = this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        com.baidu.tbadk.mvc.core.c dU = dU(1);
        if (dU instanceof ai) {
            ((ai) dU).c(this.aox);
        }
        return dVar;
    }

    @Override // com.baidu.tbadk.mvc.g.b.e, com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(getResources().getColor(com.baidu.tieba.n.backgroundcolor));
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    public void ea(int i) {
        super.ea(i);
        Zl();
    }

    @Override // com.baidu.tbadk.mvc.i.a.a, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        Zl();
    }

    private void Zl() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vY();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vZ();
        }
        if (str != null) {
            TiebaStatic.eventStat(getActivity(), str, "click", 1, new Object[0]);
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
            c(new int[]{newsNotifyMessage.getMsgChat(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme()});
        }
    }

    private void c(int[] iArr) {
        TextView textView;
        l lVar;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= getChildCount()) {
                    textView = null;
                    lVar = null;
                    break;
                }
                com.baidu.tbadk.mvc.core.c dU = dU(i2);
                if (dU instanceof com.baidu.tbadk.mvc.i.b.b) {
                    com.baidu.tbadk.mvc.i.b.c CI = ((com.baidu.tbadk.mvc.i.b.b) dU).CI();
                    if (CI.CM() == i) {
                        TextView textView2 = (TextView) CI.CK().view;
                        lVar = dU;
                        textView = textView2;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!hm(i)) {
                    textView.setVisibility(8);
                } else {
                    if (lVar instanceof l) {
                        if (i3 > 0) {
                            lVar.dE(true);
                        } else {
                            lVar.dE(false);
                        }
                    }
                    n(textView, i3);
                }
            }
        }
    }

    private void n(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            ay.b(textView, com.baidu.tieba.n.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0004 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hm(int i) {
        switch (i) {
            case 0:
                if (getChildCount() >= 3) {
                    return com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo() || com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv();
                }
                return false;
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn()) {
                    return false;
                }
                if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl()) {
                    return false;
                }
                break;
            case 2:
                if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl()) {
                }
                break;
        }
    }

    public void o(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgAtme();
        int wc = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().wc();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = wc;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        c(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.vJ().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }
}
