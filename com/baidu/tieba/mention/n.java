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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.g.b.e {
    private final CustomMessageListener aJy;
    private int bCV;
    private View mBack;

    public n(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.mBack = null;
        this.bCV = 16;
        this.aJy = new o(this, 2001124);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (MentionActivityConfig.jumpInTab != -1) {
            this.bCV = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.bCV = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bCV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        if (intent != null) {
            this.bCV = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bCV);
            if (this.bCV == 24) {
                i = 1;
            } else {
                i = this.bCV == 25 ? 2 : 1;
            }
            if (getCurrentTabType() == i) {
                dQ(i);
                com.baidu.tbadk.mvc.core.c dK = dK(getCurrentTabIndex());
                if (dK instanceof l) {
                    ((l) dK).dv(true);
                    ((l) dK).onPrimary();
                    return;
                }
                return;
            }
            dQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void Aa() {
        int i = 1;
        super.Aa();
        if (Ai()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.bCV != 24) {
                    if (this.bCV == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                dQ(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.e, com.baidu.tbadk.mvc.core.c
    public void ov() {
        super.ov();
        BN();
        getPageContext().registerListener(this.aJy);
    }

    @Override // com.baidu.tbadk.mvc.g.b.e
    protected com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar) {
        com.baidu.tbadk.mvc.g.a.d dVar = new com.baidu.tbadk.mvc.g.a.d(getPageContext(), this.anm, zT());
        this.anm.setTitleText(com.baidu.tieba.y.my_mention);
        this.mBack = this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        com.baidu.tbadk.mvc.core.c dK = dK(1);
        if (dK instanceof ai) {
            ((ai) dK).c(this.anm);
        }
        return dVar;
    }

    @Override // com.baidu.tbadk.mvc.g.b.e, com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(getResources().getColor(com.baidu.tieba.s.backgroundcolor));
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    public void dQ(int i) {
        super.dQ(i);
        Xz();
    }

    @Override // com.baidu.tbadk.mvc.i.a.a, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        Xz();
    }

    private void Xz() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.uT().vi();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.uT().vj();
        }
        if (str != null) {
            TiebaStatic.eventStat(getActivity(), str, "click", 1, new Object[0]);
        }
        p(getCurrentTabType(), true);
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
                com.baidu.tbadk.mvc.core.c dK = dK(i2);
                if (dK instanceof com.baidu.tbadk.mvc.i.b.b) {
                    com.baidu.tbadk.mvc.i.b.c BP = ((com.baidu.tbadk.mvc.i.b.b) dK).BP();
                    if (BP.BT() == i) {
                        TextView textView2 = (TextView) BP.BR().view;
                        lVar = dK;
                        textView = textView2;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!gT(i)) {
                    textView.setVisibility(8);
                } else {
                    if (lVar instanceof l) {
                        if (i3 > 0) {
                            lVar.dv(true);
                        } else {
                            lVar.dv(false);
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
            ba.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_more);
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
    private boolean gT(int i) {
        switch (i) {
            case 0:
                if (getChildCount() >= 3) {
                    return com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy() || com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF();
                }
                return false;
            case 1:
                if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx()) {
                    return false;
                }
                if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv()) {
                    return false;
                }
                break;
            case 2:
                if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv()) {
                }
                break;
        }
    }

    public void p(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgAtme();
        int vm = com.baidu.tbadk.coreExtra.messageCenter.a.uT().vm();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = vm;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        c(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.uT().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }
}
