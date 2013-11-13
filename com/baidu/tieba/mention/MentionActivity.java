package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class MentionActivity extends BaseFragment implements bq {
    public static boolean b;
    private android.support.v4.app.t ac;
    private MentionPagerAdapter ad;
    private boolean af;
    private BaseFragmentActivity ag;
    private TextView[] c;
    private TextView[] d;
    private int g;
    private NavigationBar i;
    private int e = -1;
    private int f = -1;
    private View.OnClickListener h = null;
    private ImageView Y = null;
    private ImageView Z = null;
    private View aa = null;
    private ViewPager ab = null;

    /* renamed from: a  reason: collision with root package name */
    protected int f1845a = -1;
    private boolean ae = false;
    private e ah = null;

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, SingleMentionActivity.class);
        intent.putExtra("showBack", true);
        b = true;
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, SingleMentionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("showBack", true);
        b = true;
        context.startActivity(intent);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.ag = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mention_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (h() != null) {
            this.af = h().getBoolean("showBack", false);
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
        this.f1845a = TiebaApplication.g().ap();
        super.r();
        if (F()) {
            if (this.ae) {
                this.ae = false;
                d(0);
            } else if (b) {
                b = false;
                if (t.a().p() > 0) {
                    d(0);
                } else if (t.a().l() > 0) {
                    d(1);
                } else if (t.a().m() > 0) {
                    d(2);
                }
            }
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
                    String string = extras.getString(LocaleUtil.INDONESIAN);
                    String string2 = extras.getString(SocialConstants.PARAM_MEDIA_UNAME);
                    String string3 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        this.ae = true;
                        ChatActivity.a(this.ag, string, string2, string3, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void c(Bundle bundle) {
        int i = 0;
        this.h = new b(this);
        View q = q();
        this.i = (NavigationBar) q.findViewById(R.id.view_navigation_bar);
        this.Z = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.ADD_CHAT, this.h);
        this.aa = this.i.a(R.layout.nb_item_msg_titleview, (View.OnClickListener) null);
        this.Y = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, (View.OnClickListener) null);
        if (this.af) {
            this.Y.setOnClickListener(new c(this));
            this.Y.setVisibility(0);
        } else {
            this.Y.setVisibility(8);
        }
        this.ac = l();
        this.ad = new MentionPagerAdapter(this.ac);
        this.ab = (ViewPager) q.findViewById(R.id.content);
        this.ab.setOnPageChangeListener(this);
        this.ab.setAdapter(this.ad);
        this.c = new TextView[]{(TextView) this.aa.findViewById(R.id.chatme_tab), (TextView) this.aa.findViewById(R.id.replyme_tab), (TextView) this.aa.findViewById(R.id.atme_tab)};
        this.g = this.c.length;
        this.d = new TextView[]{(TextView) this.aa.findViewById(R.id.chatme_msg_num), (TextView) this.aa.findViewById(R.id.replyme_msg_num), (TextView) this.aa.findViewById(R.id.atme_msg_num)};
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
        d(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        for (int i = 0; i < this.c.length; i++) {
            if (this.c[i] == view) {
                d(i);
                return;
            }
        }
    }

    protected void d(int i) {
        if (i >= 0 && i < this.g && this.e != i) {
            this.f = this.e;
            this.e = i;
            this.ab.setCurrentItem(i);
            String str = null;
            if (i == 0) {
                str = "msg_chat_tab_click";
            } else if (i == 1) {
                str = "msg_reply_tab_click";
            } else if (i == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null && TiebaApplication.g().s()) {
                StatService.onEvent(this.ag, str, "click", 1);
            }
            a();
            a(i, false);
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        int i2 = 0;
        if (i == 1) {
            this.ab.setBackgroundColor(-14538444);
        } else {
            this.ab.setBackgroundColor(this.ag.getResources().getColor(R.color.backgroundcolor));
        }
        bd.a(this.Y, i);
        this.i.c(i);
        if (i == 1) {
            for (TextView textView : this.d) {
                textView.setTextColor(j().getColor(R.color.top_msg_num_night));
            }
        } else {
            for (TextView textView2 : this.d) {
                textView2.setTextColor(j().getColor(R.color.top_msg_num_day));
            }
        }
        boolean z = this.f1845a == 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.c.length) {
                TextView textView3 = this.c[i3];
                if (i3 == 0) {
                    bd.e((View) textView3, z ? R.drawable.multiview_left_drawable_1 : R.drawable.multiview_left_drawable);
                } else if (i3 == this.c.length - 1) {
                    bd.e((View) textView3, z ? R.drawable.multiview_right_drawable_1 : R.drawable.multiview_right_drawable);
                } else {
                    bd.e((View) textView3, z ? R.drawable.multiview_center_drawable_1 : R.drawable.multiview_center_drawable);
                }
                i2 = i3 + 1;
            } else {
                a();
                return;
            }
        }
    }

    private void a() {
        boolean z = TiebaApplication.g().ap() == 1;
        for (int i = 0; i < this.c.length; i++) {
            TextView textView = this.c[i];
            if (i == this.e) {
                textView.setTextColor(j().getColor(z ? R.color.navi_multiview_text_s_1 : R.color.navi_multiview_text_s));
                textView.setSelected(true);
            } else if (i == this.f || this.f == -1) {
                textView.setTextColor(j().getColor(z ? R.color.navi_multiview_text_n_1 : R.color.navi_multiview_text_n));
                textView.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long[] jArr) {
        boolean z = this.f1845a == 1;
        for (int i = 0; i < jArr.length; i++) {
            TextView textView = this.d[i];
            long j = jArr[i];
            if (!e(i)) {
                textView.setVisibility(8);
            } else if (j <= 0) {
                textView.setVisibility(8);
            } else if (j < 10) {
                textView.setText(String.valueOf(j));
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                textView.setVisibility(0);
            } else if (j < 100) {
                textView.setText(String.valueOf(j));
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                textView.setVisibility(0);
            } else {
                textView.setText("   ");
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                textView.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0004 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(int i) {
        switch (i) {
            case 0:
                return TiebaApplication.g().ab();
            case 1:
                if (!TiebaApplication.g().aa()) {
                    return false;
                }
                if (TiebaApplication.g().Z()) {
                    return false;
                }
                break;
            case 2:
                if (TiebaApplication.g().Z()) {
                }
                break;
        }
    }

    public void a(int i, boolean z) {
        long l = t.a().l();
        long m = t.a().m();
        long[] jArr = new long[3];
        jArr[0] = t.a().p();
        jArr[1] = l;
        jArr[2] = m;
        if (z && i < jArr.length && i > -1 && i != 0) {
            jArr[i] = 0;
        }
        a(jArr);
        if (i != 0 && z) {
            t.a().a(jArr[1], jArr[2], t.a().n(), jArr[0] - t.a().s());
        }
    }

    private void G() {
        this.ah = new e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        this.ag.registerReceiver(this.ah, intentFilter);
    }

    private void H() {
        if (this.ah != null) {
            this.ag.unregisterReceiver(this.ah);
            this.ah = null;
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        if (i >= 0 && i < this.g && i != this.e) {
            this.f = this.e;
            this.e = i;
            String str = null;
            if (i == 0) {
                str = "msg_chat_tab_click";
            } else if (i == 1) {
                str = "msg_reply_tab_click";
            } else if (i == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null && TiebaApplication.g().s()) {
                StatService.onEvent(this.ag, str, "click", 1);
            }
            a();
            a(i, false);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }
}
