package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseFragment implements ViewPager.OnPageChangeListener {
    private BaseFragmentActivity axV;
    private int[] bfo;
    private FragmentTabHost bfz;
    private int bnB;
    private v bnC;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private int bfn = -1;
    private View.OnClickListener mOnClickListener = null;
    private View Js = null;
    private ImageView ajm = null;
    private int bnD = 16;
    private List<FragmentTabIndicator> bnE = new ArrayList(3);
    private final CustomMessageListener aBd = new s(this, 2001124);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.axV = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.w.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        nY();
        e(bundle);
    }

    public ae SQ() {
        Fragment fragment = this.bfz.bk(1).Cy;
        if (!(fragment instanceof ae)) {
            return null;
        }
        return (ae) fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        int i = 1;
        if (MentionActivityConfig.jumpInTab != -1) {
            this.bnD = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (getArguments() != null) {
            this.bnD = getArguments().getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bnD);
        }
        super.onResume();
        if (isShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgAtme() > 0) {
                    i = 2;
                }
                setCurrentTabByType(i);
            }
            gw(this.bfn);
        }
    }

    private void gw(int i) {
        if (i >= 0 && i < this.bnB) {
            Fragment item = this.bnC.getItem(this.bfn);
            if (this.bfo[i] == 1) {
                if (item instanceof ae) {
                    ae aeVar = (ae) item;
                    aeVar.SH();
                    if (this.mNavigationBar != null) {
                        aeVar.a(this.mNavigationBar);
                    }
                } else {
                    BdLog.e("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.bfo[i] == 2) {
                if (item instanceof a) {
                    ((a) item).SH();
                } else {
                    BdLog.e("AtMeFragment selected error, can not update data.");
                }
            }
            if (this.bnC != null) {
                Fragment item2 = this.bnC.getItem(i);
                if (item != null) {
                    bd.bR(item2.getClass().getName());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Jt();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.bfn != -1) {
            bundle.putInt("type", this.bfo[this.bfn]);
        } else {
            bundle.putInt("type", 0);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString(com.baidu.tbadk.core.frameworkData.a.USER_ID);
                    String string2 = extras.getString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
                    String string3 = extras.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.axV, Long.parseLong(string), string2, string3, 0)));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(Fragment fragment, int i, int i2) {
        if (fragment != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.axV);
            bVar.Cy = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.VN = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.Cx = fragmentTabIndicator;
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ek().inflate(this.axV, com.baidu.tieba.w.message_tip_item, null);
            cVar.VT = fragmentTabIndicator;
            fragmentTabIndicator.a("msg_tip_key", cVar);
            this.bnE.add(fragmentTabIndicator);
            this.bfz.a(bVar);
        }
    }

    private void QQ() {
        if (this.bnC != null) {
            int count = this.bnC.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bnC.getItem(i);
                int gf = this.bnC.gf(i);
                if (item != null) {
                    if (gf == 0) {
                        a(item, 0, com.baidu.tieba.y.mention_chatme);
                    } else if (gf == 1) {
                        a(item, 1, com.baidu.tieba.y.mention_replyme);
                    } else if (gf == 2) {
                        a(item, 2, com.baidu.tieba.y.mention_atme);
                    }
                }
            }
            this.bfz.initViewPager();
        }
    }

    private void e(Bundle bundle) {
        boolean z;
        this.mOnClickListener = new t(this);
        View view = getView();
        if (getArguments() == null) {
            z = false;
        } else {
            z = getArguments().getBoolean(SingleMentionActivityConfig.KEY_IS_SHOW_CHAT);
        }
        this.mNavigationBar = (NavigationBar) view.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (z) {
            this.ajm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_addchat, this.mOnClickListener);
        }
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.my_mention);
        this.Js = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.Js.setOnClickListener(new u(this));
        this.mFragmentManager = getChildFragmentManager();
        this.bnC = new v(this.mFragmentManager, z);
        this.bfz = (FragmentTabHost) view.findViewById(com.baidu.tieba.v.tab_host);
        this.bfz.setup(getChildFragmentManager());
        this.bfz.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfz.setOnPageChangeListener(this);
        QQ();
        if (this.bnC.getCount() == 3) {
            this.bfo = new int[]{0, 1, 2};
        } else {
            this.bfo = new int[]{1, 2};
        }
        this.bnB = this.bfo.length;
    }

    protected void setCurrentTab(int i) {
        if (i >= 0 && i < this.bnB && this.bfn != i) {
            this.bfn = i;
            gw(i);
            this.bfz.setCurrentTab(i);
            s(this.bfo[i], true);
            String str = null;
            if (this.bfo[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.bfo[i] == 1) {
                str = "msg_reply_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().oP();
            } else if (this.bfo[i] == 2) {
                str = "msg_atme_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().oP();
            }
            if (str != null) {
                TiebaStatic.eventStat(this.axV, str, "click", 1, new Object[0]);
            }
        }
    }

    void setCurrentTabByType(int i) {
        for (int i2 = 0; i2 < this.bfo.length; i2++) {
            if (i == this.bfo[i2]) {
                setCurrentTab(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (TbadkApplication.isLogin()) {
            if (i == 1) {
                this.bfz.setBackgroundColor(-14538444);
            } else {
                this.bfz.setBackgroundColor(this.axV.getResources().getColor(com.baidu.tieba.s.backgroundcolor));
            }
        } else {
            aw.i(this.bfz, com.baidu.tieba.s.bg_page_setting);
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.bfz.onChangeSkinType(i);
        if (this.bnC != null) {
            int count = this.bnC.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bnC.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    private void d(int[] iArr) {
        TextView textView;
        FragmentTabIndicator fragmentTabIndicator;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 < this.bnB) {
                    if (i != this.bfo[i2]) {
                        i2++;
                    } else {
                        fragmentTabIndicator = this.bnE.get(i2);
                        textView = (TextView) fragmentTabIndicator.dG("msg_tip_key").view;
                        break;
                    }
                } else {
                    textView = null;
                    fragmentTabIndicator = null;
                    break;
                }
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!gx(i)) {
                    textView.setVisibility(8);
                } else {
                    p(textView, i3);
                }
                fragmentTabIndicator.requestLayout();
            }
        }
    }

    private void p(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            TbadkApplication.m251getInst().getSkinType();
            aw.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                aw.h((View) textView, com.baidu.tieba.u.icon_news_head_prompt_more);
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
    private boolean gx(int i) {
        switch (i) {
            case 0:
                if (this.bnB >= 3) {
                    return TbadkApplication.m251getInst().isMsgChatOn() || TbadkApplication.m251getInst().isGroupMsgOn();
                }
                return false;
            case 1:
                if (!TbadkApplication.m251getInst().isMsgReplymeOn()) {
                    return false;
                }
                if (TbadkApplication.m251getInst().isMsgAtmeOn()) {
                    return false;
                }
                break;
            case 2:
                if (TbadkApplication.m251getInst().isMsgAtmeOn()) {
                }
                break;
        }
    }

    public void s(int i, boolean z) {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgAtme();
        int oS = com.baidu.tbadk.coreExtra.messageCenter.a.oB().oS();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = oS;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && this.bfo[this.bfn] != 0) {
            iArr[i] = 0;
        }
        d(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.oB().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    private void nY() {
        MessageManager.getInstance().registerListener(this.aBd);
    }

    private void Jt() {
        MessageManager.getInstance().unRegisterListener(this.aBd);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < this.bnB && i != this.bfn) {
            this.bfn = i;
            gw(this.bfn);
            String str = null;
            if (this.bfo[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.bfo[i] == 1) {
                str = "msg_reply_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().oP();
            } else if (this.bfo[i] == 2) {
                str = "msg_atme_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().oP();
            }
            if (str != null) {
                TiebaStatic.eventStat(this.axV, str, "click", 1, new Object[0]);
            }
            s(this.bfo[i], true);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            d(new int[]{newsNotifyMessage.getMsgChat(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme()});
        }
    }
}
