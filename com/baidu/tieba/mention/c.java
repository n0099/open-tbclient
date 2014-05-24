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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.am;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.ai;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.d implements ViewPager.OnPageChangeListener {
    private int[] c;
    private int e;
    private NavigationBar g;
    private FragmentTabHost j;
    private FragmentManager k;
    private k l;
    private BaseFragmentActivity m;
    private int d = -1;
    private View.OnClickListener f = null;
    private View h = null;
    private ImageView i = null;
    protected int b = -1;
    private int n = 16;
    private List<FragmentTabIndicator> o = new ArrayList(3);
    private final CustomMessageListener p = new d(this, MessageTypes.CMD_MESSAGE_NOTIFY_LOCAL);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.m = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.w.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f();
        a(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        int i = 1;
        if (am.b != -1) {
            this.n = am.b;
            am.b = -1;
        } else if (getArguments() != null) {
            this.n = getArguments().getInt("NotifiIdKey", this.n);
        }
        this.b = TbadkApplication.m252getInst().getSkinType();
        super.onResume();
        if (d_()) {
            a(this.c[this.d], true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfig.MSG_READ));
            if (this.e == 3 && this.d != -1 && this.c[this.d] == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2010003, new com.baidu.tbadk.core.atomData.y(this.m, this.l.getItem(this.d))));
            }
            if (am.a) {
                am.a = false;
                if (this.n == 11) {
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() <= 0) {
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().l() > 0) {
                            i = 2;
                        }
                        i = 0;
                    }
                    e(i);
                } else {
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().n() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() <= 0) {
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().l() > 0) {
                            i = 2;
                        }
                        i = 0;
                    }
                    e(i);
                }
            }
            f(this.d);
        }
    }

    private void f(int i) {
        if (i >= 0 && i < this.e) {
            Fragment item = this.l.getItem(this.d);
            if (this.c[i] == 1) {
                if (item instanceof af) {
                    ((af) item).a();
                } else {
                    BdLog.e("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.c[i] == 2) {
                if (item instanceof a) {
                    ((a) item).a();
                } else {
                    BdLog.e("AtMeFragment selected error, can not update data.");
                }
            }
            if (this.l != null) {
                Fragment item2 = this.l.getItem(i);
                if (item != null) {
                    bg.a(item2.getClass().getName());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        g();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.d != -1) {
            bundle.putInt("type", this.c[this.d]);
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
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003005, new au(this.m, Long.parseLong(string), string2, string3, 0)));
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
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.m);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.s.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.s.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.t.fontsize32));
            bVar.b = fragmentTabIndicator;
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.a = ((LayoutInflater) this.m.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.message_tip_item, (ViewGroup) null);
            cVar.h = fragmentTabIndicator;
            fragmentTabIndicator.a("msg_tip_key", cVar);
            this.o.add(fragmentTabIndicator);
            this.j.a(bVar);
        }
    }

    private void a() {
        if (this.l != null) {
            int count = this.l.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.l.getItem(i);
                int a = this.l.a(i);
                if (item != null) {
                    if (a == 0) {
                        a(item, 0, com.baidu.tieba.y.mention_chatme);
                    } else if (a == 1) {
                        a(item, 1, com.baidu.tieba.y.mention_replyme);
                    } else if (a == 2) {
                        a(item, 2, com.baidu.tieba.y.mention_atme);
                    }
                }
            }
            this.j.a();
        }
    }

    private void a(Bundle bundle) {
        this.f = new e(this);
        View view = getView();
        this.g = (NavigationBar) view.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.i = (ImageView) this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_addchat, this.f);
        this.g.a(com.baidu.tieba.y.mention_title);
        this.h = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h.setOnClickListener(new f(this));
        this.k = getChildFragmentManager();
        this.l = new k(this.k);
        this.j = (FragmentTabHost) view.findViewById(com.baidu.tieba.v.tab_host);
        this.j.setup(getChildFragmentManager());
        this.j.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.s.maintab_bg));
        this.j.setOnPageChangeListener(this);
        a();
        if (this.l.getCount() == 3) {
            this.c = new int[]{0, 1, 2};
        } else {
            this.c = new int[]{1, 2};
        }
        this.e = this.c.length;
        int i = this.c[0];
        if (bundle != null) {
            i = bundle.getInt("type", this.c[0]);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i = arguments.getInt("type", this.c[0]);
            }
        }
        e(i);
    }

    protected void d(int i) {
        if (i >= 0 && i < this.e && this.d != i) {
            this.d = i;
            f(i);
            this.j.setCurrentTab(i);
            a(this.c[i], true);
            String str = null;
            if (this.c[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.c[i] == 1) {
                str = "msg_reply_tab_click";
            } else if (this.c[i] == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                TiebaStatic.eventStat(this.m, str, "click", 1, new Object[0]);
            }
        }
    }

    void e(int i) {
        for (int i2 = 0; i2 < this.c.length; i2++) {
            if (i == this.c[i2]) {
                d(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        if (i == 1) {
            if (TbadkApplication.isLogin()) {
                this.j.setBackgroundColor(-14538444);
            } else {
                this.j.setBackgroundColor(this.m.getResources().getColor(com.baidu.tieba.s.bg_page_setting_1));
            }
        } else if (TbadkApplication.isLogin()) {
            this.j.setBackgroundColor(this.m.getResources().getColor(com.baidu.tieba.s.backgroundcolor));
        } else {
            this.j.setBackgroundColor(this.m.getResources().getColor(com.baidu.tieba.s.bg_page_setting));
        }
        this.g.c(i);
        this.j.a(i);
        if (this.l != null) {
            int count = this.l.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.l.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }

    private void a(int[] iArr) {
        TextView textView;
        FragmentTabIndicator fragmentTabIndicator;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 < this.e) {
                    if (i != this.c[i2]) {
                        i2++;
                    } else {
                        fragmentTabIndicator = this.o.get(i2);
                        textView = (TextView) fragmentTabIndicator.a("msg_tip_key").a;
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
                if (!g(i)) {
                    textView.setVisibility(8);
                } else {
                    a(textView, i3);
                }
                fragmentTabIndicator.requestLayout();
            }
        }
    }

    private void a(TextView textView, int i) {
        try {
            textView.setVisibility(0);
            boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
            textView.setTextColor(ai.c().d().getResources().getColor(z ? com.baidu.tieba.s.top_msg_num_night : com.baidu.tieba.s.top_msg_num_day));
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                textView.setBackgroundResource(z ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                textView.setBackgroundResource(z ? com.baidu.tieba.u.icon_news_head_prompt_two_1 : com.baidu.tieba.u.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                textView.setBackgroundResource(z ? com.baidu.tieba.u.icon_news_head_prompt_more_1 : com.baidu.tieba.u.icon_news_head_prompt_more);
            }
        } catch (Exception e) {
            BdLog.e(getClass(), "setTipMessage", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0004 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(int i) {
        switch (i) {
            case 0:
                if (this.e >= 3) {
                    return TbadkApplication.m252getInst().isMsgChatOn() || TbadkApplication.m252getInst().isGroupMsgOn();
                }
                return false;
            case 1:
                if (!TbadkApplication.m252getInst().isMsgReplymeOn()) {
                    return false;
                }
                if (TbadkApplication.m252getInst().isMsgAtmeOn()) {
                    return false;
                }
                break;
            case 2:
                if (TbadkApplication.m252getInst().isMsgAtmeOn()) {
                }
                break;
        }
    }

    public void a(int i, boolean z) {
        int k = com.baidu.tbadk.coreExtra.messageCenter.a.a().k();
        int l = com.baidu.tbadk.coreExtra.messageCenter.a.a().l();
        int[] iArr = new int[3];
        iArr[0] = com.baidu.tbadk.coreExtra.messageCenter.a.a().o();
        iArr[1] = k;
        iArr[2] = l;
        if (z && i < iArr.length && i > -1 && i != 0 && this.c[this.d] != 0) {
            iArr[i] = 0;
        }
        a(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().a(iArr[1], iArr[2], com.baidu.tbadk.coreExtra.messageCenter.a.a().m(), iArr[0] - com.baidu.tbadk.coreExtra.messageCenter.a.a().r());
        }
    }

    private void f() {
        MessageManager.getInstance().registerListener(this.p);
    }

    private void g() {
        MessageManager.getInstance().unRegisterListener(this.p);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < this.e && i != this.d) {
            this.d = i;
            f(this.d);
            String str = null;
            if (this.c[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.c[i] == 1) {
                str = "msg_reply_tab_click";
            } else if (this.c[i] == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                TiebaStatic.eventStat(this.m, str, "click", 1, new Object[0]);
            }
            a(this.c[i], true);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            a(new int[]{newsNotifyMessage.getMsgChat(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme()});
        }
    }
}
