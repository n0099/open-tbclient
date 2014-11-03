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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseFragment implements ViewPager.OnPageChangeListener {
    private BaseFragmentActivity aye;
    private int[] bfC;
    private FragmentTabHost bfN;
    private int bnP;
    private v bnQ;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private int bfB = -1;
    private View.OnClickListener mOnClickListener = null;
    private View Jt = null;
    private ImageView ajv = null;
    private int bnR = 16;
    private List<FragmentTabIndicator> bnS = new ArrayList(3);
    private final CustomMessageListener aBn = new s(this, 2001124);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aye = (BaseFragmentActivity) activity;
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

    public ae ST() {
        Fragment fragment = this.bfN.bk(1).Cz;
        if (!(fragment instanceof ae)) {
            return null;
        }
        return (ae) fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        int i = 1;
        if (MentionActivityConfig.jumpInTab != -1) {
            this.bnR = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (getArguments() != null) {
            this.bnR = getArguments().getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.bnR);
        }
        super.onResume();
        if (isShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 0));
            if (MentionActivityConfig.newJumpIn) {
                MentionActivityConfig.newJumpIn = false;
                if (com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgReplyme() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgAtme() > 0) {
                    i = 2;
                }
                setCurrentTabByType(i);
            }
            gw(this.bfB);
        }
    }

    private void gw(int i) {
        if (i >= 0 && i < this.bnP) {
            Fragment item = this.bnQ.getItem(this.bfB);
            if (this.bfC[i] == 1) {
                if (item instanceof ae) {
                    ae aeVar = (ae) item;
                    aeVar.SK();
                    if (this.mNavigationBar != null) {
                        aeVar.a(this.mNavigationBar);
                    }
                } else {
                    BdLog.e("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.bfC[i] == 2) {
                if (item instanceof a) {
                    ((a) item).SK();
                } else {
                    BdLog.e("AtMeFragment selected error, can not update data.");
                }
            }
            if (this.bnQ != null) {
                Fragment item2 = this.bnQ.getItem(i);
                if (item != null) {
                    be.bR(item2.getClass().getName());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Jx();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.bfB != -1) {
            bundle.putInt("type", this.bfC[this.bfB]);
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
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.aye, Long.parseLong(string), string2, string3, 0)));
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
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.aye);
            bVar.Cz = fragment;
            bVar.mType = i;
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.VR = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.Cy = fragmentTabIndicator;
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.view = com.baidu.adp.lib.g.b.ek().inflate(this.aye, com.baidu.tieba.w.message_tip_item, null);
            cVar.VX = fragmentTabIndicator;
            fragmentTabIndicator.a("msg_tip_key", cVar);
            this.bnS.add(fragmentTabIndicator);
            this.bfN.a(bVar);
        }
    }

    private void QT() {
        if (this.bnQ != null) {
            int count = this.bnQ.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.bnQ.getItem(i);
                int gf = this.bnQ.gf(i);
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
            this.bfN.initViewPager();
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
            this.ajv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_addchat, this.mOnClickListener);
        }
        this.mNavigationBar.setTitleText(com.baidu.tieba.y.my_mention);
        this.Jt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.Jt.setOnClickListener(new u(this));
        this.mFragmentManager = getChildFragmentManager();
        this.bnQ = new v(this.mFragmentManager, z);
        this.bfN = (FragmentTabHost) view.findViewById(com.baidu.tieba.v.tab_host);
        this.bfN.setup(getChildFragmentManager());
        this.bfN.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.bfN.setOnPageChangeListener(this);
        QT();
        if (this.bnQ.getCount() == 3) {
            this.bfC = new int[]{0, 1, 2};
        } else {
            this.bfC = new int[]{1, 2};
        }
        this.bnP = this.bfC.length;
    }

    protected void setCurrentTab(int i) {
        if (i >= 0 && i < this.bnP && this.bfB != i) {
            this.bfB = i;
            gw(i);
            this.bfN.setCurrentTab(i);
            s(this.bfC[i], true);
            String str = null;
            if (this.bfC[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.bfC[i] == 1) {
                str = "msg_reply_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().oR();
            } else if (this.bfC[i] == 2) {
                str = "msg_atme_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().oR();
            }
            if (str != null) {
                TiebaStatic.eventStat(this.aye, str, "click", 1, new Object[0]);
            }
        }
    }

    void setCurrentTabByType(int i) {
        for (int i2 = 0; i2 < this.bfC.length; i2++) {
            if (i == this.bfC[i2]) {
                setCurrentTab(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (TbadkApplication.isLogin()) {
            if (i == 1) {
                this.bfN.setBackgroundColor(-14538444);
            } else {
                this.bfN.setBackgroundColor(this.aye.getResources().getColor(com.baidu.tieba.s.backgroundcolor));
            }
        } else {
            aw.i(this.bfN, com.baidu.tieba.s.bg_page_setting);
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.bfN.onChangeSkinType(i);
        if (this.bnQ != null) {
            int count = this.bnQ.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bnQ.getItem(i2);
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
                if (i2 < this.bnP) {
                    if (i != this.bfC[i2]) {
                        i2++;
                    } else {
                        fragmentTabIndicator = this.bnS.get(i2);
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
                if (this.bnP >= 3) {
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
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgAtme();
        int oU = com.baidu.tbadk.coreExtra.messageCenter.a.oD().oU();
        int msgFans = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgFans();
        int msgGiftNum = com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgGiftNum();
        int[] iArr = new int[5];
        iArr[0] = oU;
        iArr[1] = msgReplyme;
        iArr[2] = msgAtme;
        iArr[3] = msgFans;
        iArr[4] = msgGiftNum;
        if (z && i < iArr.length && i > -1 && i != 0 && this.bfC[this.bfB] != 0) {
            iArr[i] = 0;
        }
        d(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.oD().a(iArr[1], iArr[2], iArr[0], iArr[3], iArr[4]);
        }
    }

    private void nY() {
        MessageManager.getInstance().registerListener(this.aBn);
    }

    private void Jx() {
        MessageManager.getInstance().unRegisterListener(this.aBn);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < this.bnP && i != this.bfB) {
            this.bfB = i;
            gw(this.bfB);
            String str = null;
            if (this.bfC[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.bfC[i] == 1) {
                str = "msg_reply_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().oR();
            } else if (this.bfC[i] == 2) {
                str = "msg_atme_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().oR();
            }
            if (str != null) {
                TiebaStatic.eventStat(this.aye, str, "click", 1, new Object[0]);
            }
            s(this.bfC[i], true);
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
