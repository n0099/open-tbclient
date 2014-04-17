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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class c extends com.baidu.tbadk.core.d implements ViewPager.OnPageChangeListener {
    private int[] c;
    private int e;
    private NavigationBar g;
    private FragmentTabHost j;
    private FragmentManager k;
    private k l;
    private com.baidu.tbadk.core.e m;
    private int d = -1;
    private View.OnClickListener f = null;
    private View h = null;
    private ImageView i = null;
    protected int b = -1;
    private int n = 16;
    private List<FragmentTabIndicator> o = new ArrayList(3);
    private final com.baidu.adp.framework.c.a p = new d(this, 2001124);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.m = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.adp.framework.c.a().a(this.p);
        this.f = new e(this);
        View view = getView();
        this.g = (NavigationBar) view.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.i = (ImageView) this.g.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_item_addchat, this.f);
        this.g.a(com.baidu.tieba.a.k.mention_title);
        this.h = this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h.setOnClickListener(new f(this));
        this.k = getChildFragmentManager();
        this.l = new k(this.k);
        this.j = (FragmentTabHost) view.findViewById(com.baidu.tieba.a.h.tab_host);
        this.j.setup(getChildFragmentManager());
        this.j.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.maintab_bg));
        this.j.setOnPageChangeListener(this);
        if (this.l != null) {
            int count = this.l.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.l.getItem(i);
                int a = this.l.a(i);
                if (item != null) {
                    if (a == 0) {
                        a(item, 0, com.baidu.tieba.a.k.mention_chatme);
                    } else if (a == 1) {
                        a(item, 1, com.baidu.tieba.a.k.mention_replyme);
                    } else if (a == 2) {
                        a(item, 2, com.baidu.tieba.a.k.mention_atme);
                    }
                }
            }
            this.j.a();
        }
        if (this.l.getCount() == 3) {
            this.c = new int[]{0, 1, 2};
        } else {
            this.c = new int[]{1, 2};
        }
        this.e = this.c.length;
        int i2 = this.c[0];
        if (bundle != null) {
            i2 = bundle.getInt("type", this.c[0]);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i2 = arguments.getInt("type", this.c[0]);
            }
        }
        e(i2);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        int i = 1;
        if (com.baidu.tbadk.core.b.ab.b != -1) {
            this.n = com.baidu.tbadk.core.b.ab.b;
            com.baidu.tbadk.core.b.ab.b = -1;
        } else if (getArguments() != null) {
            this.n = getArguments().getInt("NotifiIdKey", this.n);
        }
        this.b = TbadkApplication.j().l();
        super.onResume();
        if (c_()) {
            a(this.c[this.d], true);
            com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2012112));
            if (this.e == 3 && this.d != -1 && this.c[this.d] == 0) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008003, new com.baidu.tbadk.core.b.v(this.m, this.l.getItem(this.d))));
            }
            if (com.baidu.tbadk.core.b.ab.a) {
                com.baidu.tbadk.core.b.ab.a = false;
                if (this.n == 11) {
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().i() <= 0) {
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().j() > 0) {
                            i = 2;
                        }
                        i = 0;
                    }
                    e(i);
                } else {
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().l() > 0) {
                        i = 0;
                    } else if (com.baidu.tbadk.coreExtra.messageCenter.a.a().i() <= 0) {
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().j() > 0) {
                            i = 2;
                        }
                        i = 0;
                    }
                    e(i);
                }
            }
            d(this.d);
        }
    }

    private void d(int i) {
        if (i >= 0 && i < this.e) {
            Fragment item = this.l.getItem(this.d);
            if (this.c[i] == 1) {
                if (item instanceof af) {
                    ((af) item).a();
                } else {
                    com.baidu.adp.lib.util.f.b("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.c[i] == 2) {
                if (item instanceof a) {
                    ((a) item).a();
                } else {
                    com.baidu.adp.lib.util.f.b("AtMeFragment selected error, can not update data.");
                }
            }
            if (this.l != null) {
                Fragment item2 = this.l.getItem(i);
                if (item != null) {
                    be.a(item2.getClass().getName());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().b(this.p);
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        if (this.d != -1) {
            bundle.putInt("type", this.c[this.d]);
        } else {
            bundle.putInt("type", 0);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        try {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new com.baidu.tbadk.core.b.ah(this.m, Long.parseLong(string), string2, string3, 0)));
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
            fragmentTabIndicator.b = com.baidu.tieba.a.e.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.a.e.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.a.f.fontsize32));
            bVar.b = fragmentTabIndicator;
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.a = ((LayoutInflater) this.m.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.message_tip_item, (ViewGroup) null);
            cVar.h = fragmentTabIndicator;
            fragmentTabIndicator.a("msg_tip_key", cVar);
            this.o.add(fragmentTabIndicator);
            this.j.a(bVar);
        }
    }

    private void e(int i) {
        for (int i2 = 0; i2 < this.c.length; i2++) {
            if (i == this.c[i2]) {
                if (i2 < 0 || i2 >= this.e || this.d == i2) {
                    return;
                } else {
                    this.d = i2;
                    d(i2);
                    this.j.setCurrentTab(i2);
                    a(this.c[i2], true);
                    String str = this.c[i2] == 0 ? "msg_chat_tab_click" : this.c[i2] == 1 ? "msg_reply_tab_click" : this.c[i2] == 2 ? "msg_atme_tab_click" : null;
                    if (str != null) {
                        TiebaStatic.a(this.m, str, "click", 1, new Object[0]);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        if (i == 1) {
            if (TbadkApplication.F()) {
                this.j.setBackgroundColor(-14538444);
            } else {
                this.j.setBackgroundColor(this.m.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting_1));
            }
        } else if (TbadkApplication.F()) {
            this.j.setBackgroundColor(this.m.getResources().getColor(com.baidu.tieba.a.e.backgroundcolor));
        } else {
            this.j.setBackgroundColor(this.m.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting));
        }
        this.g.b(i);
        this.j.c(i);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int[] iArr) {
        TextView textView;
        FragmentTabIndicator fragmentTabIndicator;
        boolean z;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.e) {
                    textView = null;
                    fragmentTabIndicator = null;
                } else if (i != this.c[i2]) {
                    i2++;
                } else {
                    FragmentTabIndicator fragmentTabIndicator2 = this.o.get(i2);
                    textView = (TextView) fragmentTabIndicator2.a("msg_tip_key").a;
                    fragmentTabIndicator = fragmentTabIndicator2;
                }
            }
            if (textView != null) {
                int i3 = iArr[i];
                switch (i) {
                    case 0:
                        if (this.e < 3) {
                            z = false;
                            break;
                        } else {
                            if (!TbadkApplication.j().ag()) {
                                TbadkApplication.j();
                                if (!TbadkApplication.af()) {
                                    z = false;
                                    break;
                                }
                            }
                            z = true;
                            break;
                        }
                    case 1:
                        if (!TbadkApplication.j().ak()) {
                            z = false;
                            break;
                        }
                        if (!TbadkApplication.j().aj()) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                        if (!TbadkApplication.j().aj()) {
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                if (!z) {
                    textView.setVisibility(8);
                } else {
                    try {
                        textView.setVisibility(0);
                        boolean z2 = TbadkApplication.j().l() == 1;
                        com.baidu.tieba.p.c();
                        textView.setTextColor(com.baidu.tieba.p.d().getResources().getColor(z2 ? com.baidu.tieba.a.e.top_msg_num_night : com.baidu.tieba.a.e.top_msg_num_day));
                        if (i3 == 0) {
                            textView.setVisibility(8);
                        } else if (i3 < 10) {
                            textView.setText(String.valueOf(i3));
                            textView.setBackgroundResource(z2 ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
                        } else if (i3 < 100) {
                            textView.setText(String.valueOf(i3));
                            textView.setBackgroundResource(z2 ? com.baidu.tieba.a.g.icon_news_head_prompt_two_1 : com.baidu.tieba.a.g.icon_news_head_prompt_two);
                        } else {
                            textView.setText("   ");
                            textView.setBackgroundResource(z2 ? com.baidu.tieba.a.g.icon_news_head_prompt_more_1 : com.baidu.tieba.a.g.icon_news_head_prompt_more);
                        }
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.f.a(getClass(), "setTipMessage", e);
                    }
                }
                fragmentTabIndicator.requestLayout();
            }
        }
    }

    public final void a(int i, boolean z) {
        int i2 = com.baidu.tbadk.coreExtra.messageCenter.a.a().i();
        int j = com.baidu.tbadk.coreExtra.messageCenter.a.a().j();
        int[] iArr = new int[3];
        iArr[0] = com.baidu.tbadk.coreExtra.messageCenter.a.a().m();
        iArr[1] = i2;
        iArr[2] = j;
        if (z && i < iArr.length && i >= 0 && i != 0 && this.c[this.d] != 0) {
            iArr[i] = 0;
        }
        a(iArr);
        if (i != 0 && z) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().a(iArr[1], iArr[2], com.baidu.tbadk.coreExtra.messageCenter.a.a().k(), iArr[0] - com.baidu.tbadk.coreExtra.messageCenter.a.a().o());
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        if (i >= 0 && i < this.e && i != this.d) {
            this.d = i;
            d(this.d);
            String str = null;
            if (this.c[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.c[i] == 1) {
                str = "msg_reply_tab_click";
            } else if (this.c[i] == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                TiebaStatic.a(this.m, str, "click", 1, new Object[0]);
            }
            a(this.c[i], true);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, com.baidu.adp.framework.message.f fVar) {
        if (fVar != null) {
            if (!(fVar instanceof NewsNotifyMessage)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) fVar;
            cVar.a(new int[]{newsNotifyMessage.i(), newsNotifyMessage.b(), newsNotifyMessage.c()});
        }
    }
}
