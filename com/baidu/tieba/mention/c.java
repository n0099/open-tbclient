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
    private int[] b;
    private int d;
    private NavigationBar f;
    private FragmentTabHost i;
    private FragmentManager j;
    private k k;
    private boolean m;
    private com.baidu.tbadk.core.e n;
    private int c = -1;
    private View.OnClickListener e = null;
    private View g = null;
    private ImageView h = null;
    protected int a = -1;
    private boolean l = false;
    private int o = 16;
    private List<FragmentTabIndicator> p = new ArrayList(3);
    private final com.baidu.adp.framework.c.a q = new d(this, 2001124);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.n = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.m = getArguments().getBoolean("showBack", false);
            this.o = getArguments().getInt("NotifiIdKey", this.o);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.adp.framework.c.a().a(this.q);
        this.e = new e(this);
        View view = getView();
        this.f = (NavigationBar) view.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.h = (ImageView) this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_item_addchat, this.e);
        this.f.a(com.baidu.tieba.a.k.mention_title);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.m) {
            this.g.setOnClickListener(new f(this));
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
        this.j = getChildFragmentManager();
        this.k = new k(this.j);
        this.i = (FragmentTabHost) view.findViewById(com.baidu.tieba.a.h.tab_host);
        this.i.setup(getChildFragmentManager());
        this.i.setTabWidgetBackgroundColor(getResources().getColor(com.baidu.tieba.a.e.maintab_bg));
        this.i.setOnPageChangeListener(this);
        if (this.k != null) {
            int count = this.k.getCount();
            for (int i = 0; i < count; i++) {
                Fragment item = this.k.getItem(i);
                int a = this.k.a(i);
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
            this.i.a();
        }
        if (this.k.getCount() == 3) {
            this.b = new int[]{0, 1, 2};
        } else {
            this.b = new int[]{1, 2};
        }
        this.d = this.b.length;
        int i2 = this.b[0];
        if (bundle != null) {
            i2 = bundle.getInt("type", this.b[0]);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i2 = arguments.getInt("type", this.b[0]);
            }
        }
        b(i2);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        this.a = TbadkApplication.j().l();
        super.onResume();
        if (isShow()) {
            if (this.d == 3 && this.c != -1 && this.b[this.c] == 0) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008003, new com.baidu.tbadk.core.b.v(this.n, this.k.getItem(this.c))));
            }
            if (this.l) {
                this.l = false;
                b(0);
                return;
            }
            if (com.baidu.tbadk.core.b.ab.a) {
                com.baidu.tbadk.core.b.ab.a = false;
                if (this.o != 11) {
                    b(0);
                    return;
                } else if (com.baidu.tbadk.coreExtra.messageCenter.a.a().l() > 0) {
                    b(0);
                    return;
                } else if (com.baidu.tbadk.coreExtra.messageCenter.a.a().i() > 0) {
                    b(1);
                    return;
                } else if (com.baidu.tbadk.coreExtra.messageCenter.a.a().j() > 0) {
                    b(2);
                    return;
                }
            }
            a(this.c);
        }
    }

    private void a(int i) {
        if (i >= 0 && i < this.d) {
            Fragment item = this.k.getItem(this.c);
            if (this.b[i] == 1) {
                if (item instanceof af) {
                    ((af) item).a();
                } else {
                    com.baidu.adp.lib.util.f.b("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.b[i] == 2) {
                if (item instanceof a) {
                    ((a) item).a();
                } else {
                    com.baidu.adp.lib.util.f.b("AtMeFragment selected error, can not update data.");
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
    public final void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().b(this.q);
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        if (this.c != -1) {
            bundle.putInt("type", this.b[this.c]);
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
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new com.baidu.tbadk.core.b.ah(this.n, Long.parseLong(string), string2, string3, 0)));
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
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.n);
            bVar.c = fragment;
            bVar.a = i;
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setGravity(17);
            fragmentTabIndicator.b = com.baidu.tieba.a.e.main_bottom_button_color_1;
            fragmentTabIndicator.a = com.baidu.tieba.a.e.main_bottom_button_color;
            fragmentTabIndicator.a(0, getResources().getDimension(com.baidu.tieba.a.f.fontsize32));
            bVar.b = fragmentTabIndicator;
            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
            cVar.a = ((LayoutInflater) this.n.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.message_tip_item, (ViewGroup) null);
            cVar.h = fragmentTabIndicator;
            fragmentTabIndicator.a("msg_tip_key", cVar);
            this.p.add(fragmentTabIndicator);
            this.i.a(bVar);
        }
    }

    private void b(int i) {
        for (int i2 = 0; i2 < this.b.length; i2++) {
            if (i == this.b[i2]) {
                if (i2 < 0 || i2 >= this.d || this.c == i2) {
                    return;
                } else {
                    this.c = i2;
                    a(i2);
                    this.i.setCurrentTab(i2);
                    a(this.b[i2], true);
                    String str = this.b[i2] == 0 ? "msg_chat_tab_click" : this.b[i2] == 1 ? "msg_reply_tab_click" : this.b[i2] == 2 ? "msg_atme_tab_click" : null;
                    if (str != null) {
                        TiebaStatic.a(this.n, str, "click", 1, new Object[0]);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        if (i == 1) {
            if (TbadkApplication.F()) {
                this.i.setBackgroundColor(-14538444);
            } else {
                this.i.setBackgroundColor(this.n.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting_1));
            }
        } else if (TbadkApplication.F()) {
            this.i.setBackgroundColor(this.n.getResources().getColor(com.baidu.tieba.a.e.backgroundcolor));
        } else {
            this.i.setBackgroundColor(this.n.getResources().getColor(com.baidu.tieba.a.e.bg_page_setting));
        }
        this.f.b(i);
        this.i.c(i);
        if (this.k != null) {
            int count = this.k.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.k.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).changeSkinType(i);
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
                if (i2 >= this.d) {
                    textView = null;
                    fragmentTabIndicator = null;
                } else if (i != this.b[i2]) {
                    i2++;
                } else {
                    FragmentTabIndicator fragmentTabIndicator2 = this.p.get(i2);
                    textView = (TextView) fragmentTabIndicator2.a("msg_tip_key").a;
                    fragmentTabIndicator = fragmentTabIndicator2;
                }
            }
            if (textView != null) {
                int i3 = iArr[i];
                switch (i) {
                    case 0:
                        if (this.d < 3) {
                            z = false;
                            break;
                        } else {
                            if (!TbadkApplication.j().ae()) {
                                TbadkApplication.j();
                                if (!TbadkApplication.ad()) {
                                    z = false;
                                    break;
                                }
                            }
                            z = true;
                            break;
                        }
                    case 1:
                        if (!TbadkApplication.j().ai()) {
                            z = false;
                            break;
                        }
                        if (!TbadkApplication.j().ah()) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                        if (!TbadkApplication.j().ah()) {
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
                        com.baidu.tieba.r.c();
                        textView.setTextColor(com.baidu.tieba.r.d().getResources().getColor(z2 ? com.baidu.tieba.a.e.top_msg_num_night : com.baidu.tieba.a.e.top_msg_num_day));
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
        if (z && i < iArr.length && i >= 0 && i != 0 && this.b[this.c] != 0) {
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
        if (i >= 0 && i < this.d && i != this.c) {
            this.c = i;
            a(this.c);
            String str = null;
            if (this.b[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.b[i] == 1) {
                str = "msg_reply_tab_click";
            } else if (this.b[i] == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                TiebaStatic.a(this.n, str, "click", 1, new Object[0]);
            }
            a(this.b[i], true);
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
