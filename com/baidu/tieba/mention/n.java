package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.g.b.e {
    private final CustomMessageListener aDM;
    private int btz;
    private View mBack;

    public n(MvcActivity<?, ?, ?> mvcActivity) {
        super(mvcActivity);
        this.mBack = null;
        this.btz = 16;
        this.aDM = new o(this, 2001124);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        if (MentionActivityConfig.jumpInTab != -1) {
            this.btz = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.btz = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.btz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void wO() {
        int i = 1;
        super.wO();
        if (wW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (this.btz != 24) {
                    if (this.btz == 25) {
                        i = 2;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgAtme() > 0) {
                        i = 2;
                    }
                }
                dN(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.e, com.baidu.tbadk.mvc.core.c
    public void kC() {
        super.kC();
        yz();
        getPageContext().registerListener(this.aDM);
    }

    @Override // com.baidu.tbadk.mvc.g.b.e
    protected com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar) {
        com.baidu.tbadk.mvc.g.a.d dVar = new com.baidu.tbadk.mvc.g.a.d(getPageContext(), this.aeS, wH());
        this.aeS.setTitleText(com.baidu.tieba.z.my_mention);
        this.mBack = this.aeS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(new p(this));
        com.baidu.tbadk.mvc.core.c dH = dH(1);
        if (dH instanceof af) {
            ((af) dH).b(this.aeS);
        }
        return dVar;
    }

    @Override // com.baidu.tbadk.mvc.g.b.e, com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, getView());
        if (i == 1) {
            getView().setBackgroundColor(-14538444);
        } else {
            getView().setBackgroundColor(getResources().getColor(com.baidu.tieba.t.backgroundcolor));
        }
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    public void dN(int i) {
        super.dN(i);
        Ui();
    }

    @Override // com.baidu.tbadk.mvc.i.a.a, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        super.onPageSelected(i);
        Ui();
    }

    private void Ui() {
        String str = null;
        if (getCurrentTabType() == 0) {
            str = "msg_chat_tab_click";
        } else if (getCurrentTabType() == 1) {
            str = "msg_reply_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.rS().sh();
        } else if (getCurrentTabType() == 2) {
            str = "msg_atme_tab_click";
            com.baidu.tbadk.coreExtra.messageCenter.a.rS().sh();
        }
        if (str != null) {
            TiebaStatic.eventStat(getActivity(), str, "click", 1, new Object[0]);
        }
        r(getCurrentTabType(), true);
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
                com.baidu.tbadk.mvc.core.c dH = dH(i2);
                if (dH instanceof com.baidu.tbadk.mvc.i.b.b) {
                    com.baidu.tbadk.mvc.i.b.c yB = ((com.baidu.tbadk.mvc.i.b.b) dH).yB();
                    if (yB.yF() == i) {
                        TextView textView2 = (TextView) yB.yD().view;
                        lVar = dH;
                        textView = textView2;
                        break;
                    }
                }
                i2++;
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!gP(i)) {
                    textView.setVisibility(8);
                } else {
                    if (lVar instanceof l) {
                        if (i3 > 0) {
                            lVar.dr(true);
                        } else {
                            lVar.dr(false);
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
            bc.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_more);
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
    private boolean gP(int i) {
        switch (i) {
            case 0:
                if (getChildCount() >= 3) {
                    return TbadkCoreApplication.m255getInst().isMsgChatOn() || TbadkCoreApplication.m255getInst().isGroupMsgOn();
                }
                return false;
            case 1:
                if (!TbadkCoreApplication.m255getInst().isMsgReplymeOn()) {
                    return false;
                }
                if (TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
                    return false;
                }
                break;
            case 2:
                if (TbadkCoreApplication.m255getInst().isMsgAtmeOn()) {
                }
                break;
        }
    }

    public void r(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgAtme();
        int sk = com.baidu.tbadk.coreExtra.messageCenter.a.rS().sk();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = sk;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && getCurrentTabType() != 0) {
            iArr[i] = 0;
        }
        c(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.rS().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }
}
