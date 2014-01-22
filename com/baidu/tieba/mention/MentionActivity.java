package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatListFragment;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.by;
import com.baidu.tieba.util.bz;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MentionActivity extends BaseFragment implements bq {
    public static boolean b;
    private android.support.v4.app.t ab;
    private MentionPagerAdapter ac;
    private boolean ae;
    private BaseFragmentActivity af;
    private e ag;
    private TextView[] c;
    private TextView[] d;
    private int f;
    private NavigationBar h;
    private int e = -1;
    private View.OnClickListener g = null;
    private ImageView i = null;
    private ImageView Y = null;
    private View Z = null;
    private ViewPager aa = null;
    protected int a = -1;
    private boolean ad = false;
    private int ah = 16;

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, SingleMentionActivity.class);
        intent.putExtra("showBack", true);
        b = true;
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, SingleMentionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("showBack", true);
        intent.putExtra("NotifiIdKey", i);
        b = true;
        context.startActivity(intent);
    }

    public void e(int i) {
        this.ah = i;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.af = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (h() != null) {
            this.ae = h().getBoolean("showBack", false);
            this.ah = h().getInt("NotifiIdKey", this.ah);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        G();
        c(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        this.a = TiebaApplication.h().al();
        super.r();
        if (F()) {
            if (this.e == 0) {
                Fragment a = this.ac.a(this.e);
                if (a instanceof ChatListFragment) {
                    ((ChatListFragment) a).a();
                }
            }
            if (this.ad) {
                this.ad = false;
                f(0);
            } else if (b) {
                b = false;
                if (this.ah != 11) {
                    f(0);
                } else if (s.a().m() > 0) {
                    f(1);
                } else if (s.a().n() > 0) {
                    f(2);
                }
            } else {
                g(this.e);
            }
        }
    }

    private void g(int i) {
        Fragment a;
        if (i == 1) {
            Fragment a2 = this.ac.a(this.e);
            if (a2 instanceof ReplyMeFragment) {
                ((ReplyMeFragment) a2).a();
            } else {
                com.baidu.adp.lib.g.e.a("ReplyMeFragment selected error, can not update data.");
            }
        } else if (i == 2) {
            Fragment a3 = this.ac.a(this.e);
            if (a3 instanceof AtMeFragment) {
                ((AtMeFragment) a3).a();
            } else {
                com.baidu.adp.lib.g.e.a("AtMeFragment selected error, can not update data.");
            }
        }
        if (this.ac != null && (a = this.ac.a(i)) != null) {
            bz.a(a.getClass().getName());
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        H();
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        if (this.e != -1) {
            bundle.putInt("type", this.e);
        } else {
            bundle.putInt("type", 0);
        }
        super.e(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("id");
                    String string2 = extras.getString(SocialConstants.PARAM_MEDIA_UNAME);
                    String string3 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        try {
                            PersonalChatActivity.a(this.af, Long.parseLong(string), string2, string3, 0, null);
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

    private void c(Bundle bundle) {
        int i = 0;
        this.g = new b(this);
        View q = q();
        this.h = (NavigationBar) q.findViewById(R.id.view_navigation_bar);
        this.Y = this.h.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.ADD_CHAT, this.g);
        this.Z = this.h.a(R.layout.nb_item_msg_titleview, (View.OnClickListener) null);
        this.i = this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, (View.OnClickListener) null);
        if (this.ae) {
            this.i.setOnClickListener(new c(this));
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.ab = l();
        this.ac = new MentionPagerAdapter(this.ab);
        this.aa = (ViewPager) q.findViewById(R.id.content);
        this.aa.setOnPageChangeListener(this);
        this.aa.setAdapter(this.ac);
        this.c = new TextView[]{(TextView) this.Z.findViewById(R.id.chatme_tab), (TextView) this.Z.findViewById(R.id.replyme_tab), (TextView) this.Z.findViewById(R.id.atme_tab)};
        this.f = this.c.length;
        this.aa.setOffscreenPageLimit(this.f - 1);
        this.d = new TextView[]{(TextView) this.Z.findViewById(R.id.chatme_msg_num), (TextView) this.Z.findViewById(R.id.replyme_msg_num), (TextView) this.Z.findViewById(R.id.atme_msg_num)};
        d dVar = new d(this);
        for (int i2 = 0; i2 < this.c.length; i2++) {
            this.c[i2].setOnClickListener(dVar);
        }
        if (bundle != null) {
            i = bundle.getInt("type", 0);
        } else {
            Bundle h = h();
            if (h != null) {
                i = h.getInt("type", 0);
            }
        }
        f(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        for (int i = 0; i < this.c.length; i++) {
            if (this.c[i] == view) {
                f(i);
                return;
            }
        }
    }

    protected void f(int i) {
        if (i >= 0 && i < this.f && this.e != i) {
            this.e = i;
            g(i);
            this.aa.setCurrentItem(i);
            String str = null;
            if (i == 0) {
                str = "msg_chat_tab_click";
            } else if (i == 1) {
                str = "msg_reply_tab_click";
            } else if (i == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                by.a(this.af, str, "click", 1, new Object[0]);
            }
            a();
            a(i, true);
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void d(int i) {
        int i2 = 0;
        if (i == 1) {
            if (TiebaApplication.B()) {
                this.aa.setBackgroundColor(-14538444);
            } else {
                this.aa.setBackgroundColor(this.af.getResources().getColor(R.color.bg_page_setting_1));
            }
        } else if (TiebaApplication.B()) {
            this.aa.setBackgroundColor(this.af.getResources().getColor(R.color.backgroundcolor));
        } else {
            this.aa.setBackgroundColor(this.af.getResources().getColor(R.color.bg_page_setting));
        }
        bs.a(this.i, i);
        this.h.c(i);
        if (i == 1) {
            for (TextView textView : this.d) {
                textView.setTextColor(j().getColor(R.color.top_msg_num_night));
            }
        } else {
            for (TextView textView2 : this.d) {
                textView2.setTextColor(j().getColor(R.color.top_msg_num_day));
            }
        }
        boolean z = this.a == 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.c.length) {
                TextView textView3 = this.c[i3];
                if (i3 == 0) {
                    textView3.setBackgroundResource(z ? R.drawable.multiview_left_drawable_1 : R.drawable.multiview_left_drawable);
                } else if (i3 == this.c.length - 1) {
                    textView3.setBackgroundResource(z ? R.drawable.multiview_right_drawable_1 : R.drawable.multiview_right_drawable);
                } else {
                    textView3.setBackgroundResource(z ? R.drawable.multiview_center_drawable_1 : R.drawable.multiview_center_drawable);
                }
                i2 = i3 + 1;
            } else {
                a();
                return;
            }
        }
    }

    private void a() {
        boolean z = TiebaApplication.h().al() == 1;
        for (int i = 0; i < this.c.length; i++) {
            TextView textView = this.c[i];
            if (i == this.e) {
                textView.setTextColor(j().getColor(z ? R.color.navi_multiview_text_s_1 : R.color.navi_multiview_text_s));
                textView.setSelected(true);
            } else {
                textView.setTextColor(j().getColor(z ? R.color.navi_multiview_text_n_1 : R.color.navi_multiview_text_n));
                textView.setSelected(false);
            }
        }
    }

    private void a(int[] iArr) {
        boolean z = this.a == 1;
        for (int i = 0; i < iArr.length; i++) {
            TextView textView = this.d[i];
            int i2 = iArr[i];
            if (!h(i)) {
                textView.setVisibility(8);
            } else if (i2 <= 0) {
                textView.setVisibility(8);
            } else if (i2 < 10) {
                textView.setText(String.valueOf(i2));
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                textView.setVisibility(0);
            } else if (i2 < 100) {
                textView.setText(String.valueOf(i2));
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                textView.setVisibility(0);
            } else {
                textView.setText("   ");
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                textView.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0004 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean h(int i) {
        switch (i) {
            case 0:
                return TiebaApplication.h().Y() || TiebaApplication.h().Z();
            case 1:
                if (!TiebaApplication.h().X()) {
                    return false;
                }
                if (TiebaApplication.h().W()) {
                    return false;
                }
                break;
            case 2:
                if (TiebaApplication.h().W()) {
                }
                break;
        }
    }

    public void a(int i, boolean z) {
        int m = s.a().m();
        int n = s.a().n();
        int[] iArr = new int[3];
        iArr[0] = s.a().q();
        iArr[1] = m;
        iArr[2] = n;
        if (z && i < iArr.length && i > -1 && i != 0 && this.e != 0) {
            iArr[i] = 0;
        }
        a(iArr);
        if (i != 0 && z) {
            s.a().a(iArr[1], iArr[2], s.a().o(), iArr[0] - s.a().t());
        }
    }

    private void G() {
        this.ag = new e(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.ag);
    }

    private void H() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.ag);
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        if (i >= 0 && i < this.f && i != this.e) {
            this.e = i;
            g(this.e);
            String str = null;
            if (i == 0) {
                str = "msg_chat_tab_click";
            } else if (i == 1) {
                str = "msg_reply_tab_click";
            } else if (i == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null) {
                by.a(this.af, str, "click", 1, new Object[0]);
            }
            a();
            a(i, true);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null) {
            if (!(qVar instanceof com.baidu.tieba.im.message.t)) {
                com.baidu.adp.lib.g.e.a("transform error");
                return;
            }
            com.baidu.tieba.im.message.t tVar = (com.baidu.tieba.im.message.t) qVar;
            a(new int[]{tVar.d(), tVar.a(), tVar.b()});
        }
    }
}
