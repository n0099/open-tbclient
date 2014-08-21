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
import com.baidu.tbadk.core.atomData.bk;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.core.d implements ViewPager.OnPageChangeListener {
    private int[] b;
    private int d;
    private NavigationBar f;
    private FragmentTabHost i;
    private FragmentManager j;
    private t k;
    private BaseFragmentActivity l;
    private int c = -1;
    private View.OnClickListener e = null;
    private View g = null;
    private ImageView h = null;
    private int m = 16;
    private List<FragmentTabIndicator> n = new ArrayList(3);
    private final CustomMessageListener o = new q(this, 2001124);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.l = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.v.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        g();
        a(bundle);
    }

    public al a() {
        Fragment fragment = this.i.a(1).c;
        if (!(fragment instanceof al)) {
            return null;
        }
        return (al) fragment;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        int i = 1;
        if (com.baidu.tbadk.core.atomData.aw.b != -1) {
            this.m = com.baidu.tbadk.core.atomData.aw.b;
            com.baidu.tbadk.core.atomData.aw.b = -1;
        } else if (getArguments() != null) {
            this.m = getArguments().getInt("NotifiIdKey", this.m);
        }
        super.onResume();
        if (d_()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, Integer.valueOf(FrsActivity.c)));
            if (com.baidu.tbadk.core.atomData.aw.a) {
                com.baidu.tbadk.core.atomData.aw.a = false;
                if (com.baidu.tbadk.coreExtra.messageCenter.a.a().m() <= 0 && com.baidu.tbadk.coreExtra.messageCenter.a.a().n() > 0) {
                    i = 2;
                }
                e(i);
            }
            f(this.c);
        }
    }

    private void f(int i) {
        if (i >= 0 && i < this.d) {
            Fragment item = this.k.getItem(this.c);
            if (this.b[i] == 1) {
                if (item instanceof al) {
                    al alVar = (al) item;
                    alVar.f();
                    if (this.f != null) {
                        alVar.a(this.f);
                    }
                } else {
                    BdLog.e("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.b[i] == 2) {
                if (item instanceof a) {
                    ((a) item).a();
                } else {
                    BdLog.e("AtMeFragment selected error, can not update data.");
                }
            }
            if (this.k != null) {
                Fragment item2 = this.k.getItem(i);
                if (item != null) {
                    be.a(item2.getClass().getName());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.c != -1) {
            bundle.putInt("type", this.b[this.c]);
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
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new bk(this.l, Long.parseLong(string), string2, string3, 0)));
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
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.l);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.r.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.r.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.s.fontsize32));
            bVar.b = fragmentTabIndicator;
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.a = com.baidu.adp.lib.e.b.a().a(this.l, com.baidu.tieba.v.message_tip_item, null);
            cVar.h = fragmentTabIndicator;
            fragmentTabIndicator.a("msg_tip_key", cVar);
            this.n.add(fragmentTabIndicator);
            this.i.a(bVar);
        }
    }

    private void f() {
        if (this.k != null) {
            int count = this.k.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.k.getItem(i);
                int a = this.k.a(i);
                if (item != null) {
                    if (a == 0) {
                        a(item, 0, com.baidu.tieba.x.mention_chatme);
                    } else if (a == 1) {
                        a(item, 1, com.baidu.tieba.x.mention_replyme);
                    } else if (a == 2) {
                        a(item, 2, com.baidu.tieba.x.mention_atme);
                    }
                }
            }
            this.i.a();
        }
    }

    private void a(Bundle bundle) {
        boolean z;
        this.e = new r(this);
        View view = getView();
        if (getArguments() == null) {
            z = false;
        } else {
            z = getArguments().getBoolean("is_show_chat");
        }
        this.f = (NavigationBar) view.findViewById(com.baidu.tieba.u.view_navigation_bar);
        if (z) {
            this.h = (ImageView) this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_addchat, this.e);
        }
        this.f.a(com.baidu.tieba.x.my_mention);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g.setOnClickListener(new s(this));
        this.j = getChildFragmentManager();
        this.k = new t(this.j, z);
        this.i = (FragmentTabHost) view.findViewById(com.baidu.tieba.u.tab_host);
        this.i.setup(getChildFragmentManager());
        this.i.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.r.maintab_bg));
        this.i.setOnPageChangeListener(this);
        f();
        if (this.k.getCount() == 3) {
            this.b = new int[]{0, 1, 2};
        } else {
            this.b = new int[]{1, 2};
        }
        this.d = this.b.length;
    }

    protected void d(int i) {
        if (i >= 0 && i < this.d && this.c != i) {
            this.c = i;
            f(i);
            this.i.setCurrentTab(i);
            a(this.b[i], true);
            String str = null;
            if (this.b[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.b[i] == 1) {
                str = "msg_reply_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.a().k();
            } else if (this.b[i] == 2) {
                str = "msg_atme_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.a().k();
            }
            if (str != null) {
                TiebaStatic.eventStat(this.l, str, "click", 1, new Object[0]);
            }
        }
    }

    void e(int i) {
        for (int i2 = 0; i2 < this.b.length; i2++) {
            if (i == this.b[i2]) {
                d(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        if (i == 1) {
            if (TbadkApplication.isLogin()) {
                this.i.setBackgroundColor(-14538444);
            } else {
                this.i.setBackgroundColor(this.l.getResources().getColor(com.baidu.tieba.r.bg_page_setting_1));
            }
        } else if (TbadkApplication.isLogin()) {
            this.i.setBackgroundColor(this.l.getResources().getColor(com.baidu.tieba.r.backgroundcolor));
        } else {
            this.i.setBackgroundColor(this.l.getResources().getColor(com.baidu.tieba.r.bg_page_setting));
        }
        this.f.c(i);
        this.i.b(i);
        if (this.k != null) {
            int count = this.k.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.k.getItem(i2);
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
                if (i2 < this.d) {
                    if (i != this.b[i2]) {
                        i2++;
                    } else {
                        fragmentTabIndicator = this.n.get(i2);
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
            textView.setTextColor(com.baidu.tieba.ai.c().d().getResources().getColor(z ? com.baidu.tieba.r.top_msg_num_night : com.baidu.tieba.r.top_msg_num_day));
            if (i == 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_two_1 : com.baidu.tieba.t.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_more_1 : com.baidu.tieba.t.icon_news_head_prompt_more);
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
    private boolean g(int i) {
        switch (i) {
            case 0:
                if (this.d >= 3) {
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
        int m = com.baidu.tbadk.coreExtra.messageCenter.a.a().m();
        int n = com.baidu.tbadk.coreExtra.messageCenter.a.a().n();
        int p = com.baidu.tbadk.coreExtra.messageCenter.a.a().p();
        int q = com.baidu.tbadk.coreExtra.messageCenter.a.a().q();
        int[] iArr = new int[4];
        iArr[0] = p;
        iArr[1] = m;
        iArr[2] = n;
        iArr[3] = q;
        if (z && i < iArr.length && i > -1 && i != 0 && this.b[this.c] != 0) {
            iArr[i] = 0;
        }
        a(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().a(iArr[1], iArr[2], iArr[0] - com.baidu.tbadk.coreExtra.messageCenter.a.a().t(), iArr[3]);
        }
    }

    private void g() {
        MessageManager.getInstance().registerListener(this.o);
    }

    private void h() {
        MessageManager.getInstance().unRegisterListener(this.o);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < this.d && i != this.c) {
            this.c = i;
            f(this.c);
            String str = null;
            if (this.b[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.b[i] == 1) {
                str = "msg_reply_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.a().k();
            } else if (this.b[i] == 2) {
                str = "msg_atme_tab_click";
                com.baidu.tbadk.coreExtra.messageCenter.a.a().k();
            }
            if (str != null) {
                TiebaStatic.eventStat(this.l, str, "click", 1, new Object[0]);
            }
            a(this.b[i], true);
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
