package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.cc;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.j implements ViewPager.OnPageChangeListener {
    public static boolean c;
    private TextView[] d;
    private TextView[] e;
    private int[] f;
    private int h;
    private NavigationBar j;
    private FragmentManager o;
    private k p;
    private boolean r;
    private com.baidu.tieba.k s;
    private g t;
    private int g = -1;
    private View.OnClickListener i = null;
    private ImageView k = null;
    private ImageView l = null;
    private View m = null;
    private ViewPager n = null;
    protected int b = -1;
    private boolean q = false;
    private int u = 16;

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, SingleMentionActivity.class);
        intent.putExtra("showBack", true);
        c = true;
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, SingleMentionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("showBack", true);
        intent.putExtra("NotifiIdKey", i);
        c = true;
        context.startActivity(intent);
    }

    public void d(int i) {
        this.u = i;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.s = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.r = getArguments().getBoolean("showBack", false);
            this.u = getArguments().getInt("NotifiIdKey", this.u);
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c();
        a(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        this.b = TiebaApplication.g().al();
        super.onResume();
        if (b()) {
            if (this.h == 3 && this.g != -1 && this.f[this.g] == 0) {
                Fragment item = this.p.getItem(this.g);
                if (item instanceof com.baidu.tieba.chat.a) {
                    ((com.baidu.tieba.chat.a) item).a();
                }
            }
            if (this.q) {
                this.q = false;
                f(0);
                return;
            }
            if (c) {
                c = false;
                if (this.u != 11) {
                    f(0);
                    return;
                } else if (v.a().m() > 0) {
                    f(1);
                    return;
                } else if (v.a().n() > 0) {
                    f(2);
                    return;
                }
            }
            g(this.g);
        }
    }

    private void g(int i) {
        Fragment item;
        if (i >= 0 && i < this.h) {
            if (this.f[i] == 1) {
                Fragment item2 = this.p.getItem(this.g);
                if (item2 instanceof af) {
                    ((af) item2).a();
                } else {
                    com.baidu.adp.lib.util.f.b("ReplyMeFragment selected error, can not update data.");
                }
            } else if (this.f[i] == 2) {
                Fragment item3 = this.p.getItem(this.g);
                if (item3 instanceof a) {
                    ((a) item3).a();
                } else {
                    com.baidu.adp.lib.util.f.b("AtMeFragment selected error, can not update data.");
                }
            }
            if (this.p != null && (item = this.p.getItem(i)) != null) {
                cc.a(item.getClass().getName());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.g != -1) {
            bundle.putInt("type", this.f[this.g]);
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
                    String string = extras.getString("id");
                    String string2 = extras.getString(SocialConstants.PARAM_MEDIA_UNAME);
                    String string3 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        try {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new com.baidu.tieba.a.c(this.s, Long.parseLong(string), string2, string3, 0)));
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

    private void a(Bundle bundle) {
        this.i = new d(this);
        View view = getView();
        this.j = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.l = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.ADD_CHAT, this.i);
        this.m = this.j.a(R.layout.nb_item_msg_titleview, (View.OnClickListener) null);
        this.k = this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, (View.OnClickListener) null);
        if (this.r) {
            this.k.setOnClickListener(new e(this));
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        this.o = getChildFragmentManager();
        this.p = new k(this.o);
        this.n = (ViewPager) view.findViewById(R.id.content);
        this.n.setOnPageChangeListener(this);
        this.n.setAdapter(this.p);
        if (this.p.getCount() == 3) {
            this.d = new TextView[]{(TextView) this.m.findViewById(R.id.chatme_tab), (TextView) this.m.findViewById(R.id.replyme_tab), (TextView) this.m.findViewById(R.id.atme_tab)};
            this.e = new TextView[]{(TextView) this.m.findViewById(R.id.chatme_msg_num), (TextView) this.m.findViewById(R.id.replyme_msg_num), (TextView) this.m.findViewById(R.id.atme_msg_num)};
            this.f = new int[]{0, 1, 2};
        } else {
            this.m.findViewById(R.id.chatme_tab).setVisibility(8);
            this.d = new TextView[]{(TextView) this.m.findViewById(R.id.replyme_tab), (TextView) this.m.findViewById(R.id.atme_tab)};
            this.e = new TextView[]{(TextView) this.m.findViewById(R.id.replyme_msg_num), (TextView) this.m.findViewById(R.id.atme_msg_num)};
            this.f = new int[]{1, 2};
        }
        this.h = this.d.length;
        this.n.setOffscreenPageLimit(this.h - 1);
        f fVar = new f(this);
        for (int i = 0; i < this.d.length; i++) {
            this.d[i].setOnClickListener(fVar);
        }
        int i2 = this.f[0];
        if (bundle != null) {
            i2 = bundle.getInt("type", this.f[0]);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i2 = arguments.getInt("type", this.f[0]);
            }
        }
        f(i2);
    }

    public void a(View view) {
        for (int i = 0; i < this.d.length; i++) {
            if (this.d[i] == view) {
                e(i);
                return;
            }
        }
    }

    protected void e(int i) {
        if (i >= 0 && i < this.h && this.g != i) {
            this.g = i;
            g(i);
            this.n.setCurrentItem(i);
            String str = null;
            if (this.f[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.f[i] == 1) {
                str = "msg_reply_tab_click";
            } else if (this.f[i] == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                cb.a(this.s, str, "click", 1, new Object[0]);
            }
            a();
            a(this.f[i], true);
        }
    }

    void f(int i) {
        for (int i2 = 0; i2 < this.f.length; i2++) {
            if (i == this.f[i2]) {
                e(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        if (i == 1) {
            if (TiebaApplication.B()) {
                this.n.setBackgroundColor(-14538444);
            } else {
                this.n.setBackgroundColor(this.s.getResources().getColor(R.color.bg_page_setting_1));
            }
        } else if (TiebaApplication.B()) {
            this.n.setBackgroundColor(this.s.getResources().getColor(R.color.backgroundcolor));
        } else {
            this.n.setBackgroundColor(this.s.getResources().getColor(R.color.bg_page_setting));
        }
        bq.a(this.k, i);
        this.j.c(i);
        if (i == 1) {
            for (TextView textView : this.e) {
                textView.setTextColor(getResources().getColor(R.color.top_msg_num_night));
            }
        } else {
            for (TextView textView2 : this.e) {
                textView2.setTextColor(getResources().getColor(R.color.top_msg_num_day));
            }
        }
        boolean z = this.b == 1;
        for (int i2 = 0; i2 < this.d.length; i2++) {
            TextView textView3 = this.d[i2];
            if (i2 == 0) {
                textView3.setBackgroundResource(z ? R.drawable.multiview_left_drawable_1 : R.drawable.multiview_left_drawable);
            } else if (i2 == this.d.length - 1) {
                textView3.setBackgroundResource(z ? R.drawable.multiview_right_drawable_1 : R.drawable.multiview_right_drawable);
            } else {
                textView3.setBackgroundResource(z ? R.drawable.multiview_center_drawable_1 : R.drawable.multiview_center_drawable);
            }
        }
        a();
        if (this.p != null) {
            int count = this.p.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.p.getItem(i3);
                if (item != null && (item instanceof com.baidu.tieba.j)) {
                    ((com.baidu.tieba.j) item).b(i);
                }
            }
        }
    }

    private void a() {
        boolean z = TiebaApplication.g().al() == 1;
        for (int i = 0; i < this.d.length; i++) {
            TextView textView = this.d[i];
            if (i == this.g) {
                textView.setTextColor(getResources().getColor(z ? R.color.navi_multiview_text_s_1 : R.color.navi_multiview_text_s));
                textView.setSelected(true);
            } else {
                textView.setTextColor(getResources().getColor(z ? R.color.navi_multiview_text_n_1 : R.color.navi_multiview_text_n));
                textView.setSelected(false);
            }
        }
    }

    private void a(int[] iArr) {
        boolean z = this.b == 1;
        for (int i = 0; i < iArr.length; i++) {
            TextView textView = null;
            int i2 = 0;
            while (true) {
                if (i2 < this.h) {
                    if (i != this.f[i2]) {
                        i2++;
                    } else {
                        textView = this.e[i2];
                        break;
                    }
                } else {
                    break;
                }
            }
            if (textView != null) {
                int i3 = iArr[i];
                if (!h(i)) {
                    textView.setVisibility(8);
                } else if (i3 <= 0) {
                    textView.setVisibility(8);
                } else if (i3 < 10) {
                    textView.setText(String.valueOf(i3));
                    textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                    textView.setVisibility(0);
                } else if (i3 < 100) {
                    textView.setText(String.valueOf(i3));
                    textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                    textView.setVisibility(0);
                } else {
                    textView.setText("   ");
                    textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                    textView.setVisibility(0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0004 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean h(int i) {
        switch (i) {
            case 0:
                if (this.h >= 3) {
                    return TiebaApplication.g().X() || TiebaApplication.g().Y();
                }
                return false;
            case 1:
                if (!TiebaApplication.g().W()) {
                    return false;
                }
                if (TiebaApplication.g().V()) {
                    return false;
                }
                break;
            case 2:
                if (TiebaApplication.g().V()) {
                }
                break;
        }
    }

    public void a(int i, boolean z) {
        int m = v.a().m();
        int n = v.a().n();
        int[] iArr = new int[3];
        iArr[0] = v.a().q();
        iArr[1] = m;
        iArr[2] = n;
        if (z && i < iArr.length && i > -1 && i != 0 && this.f[this.g] != 0) {
            iArr[i] = 0;
        }
        a(iArr);
        if (i != 0 && z) {
            v.a().a(iArr[1], iArr[2], v.a().o(), iArr[0] - v.a().t());
        }
    }

    private void c() {
        this.t = new g(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.t);
    }

    private void d() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.t);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i >= 0 && i < this.h && i != this.g) {
            this.g = i;
            g(this.g);
            String str = null;
            if (this.f[i] == 0) {
                str = "msg_chat_tab_click";
            } else if (this.f[i] == 1) {
                str = "msg_reply_tab_click";
            } else if (this.f[i] == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                cb.a(this.s, str, "click", 1, new Object[0]);
            }
            a();
            a(this.f[i], true);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            a(new int[]{vVar.d(), vVar.a(), vVar.b()});
        }
    }
}
