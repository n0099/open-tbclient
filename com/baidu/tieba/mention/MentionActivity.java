package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.ae;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.chat.ChatListFragment;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.as;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class MentionActivity extends BaseFragmentActivity {
    public static boolean e;
    private BaseFragment[] f;
    private TextView[] g;
    private TextView[] h;
    private boolean n;
    private ae o;
    private android.support.v4.app.t p;
    private int i = -1;
    private ImageView j = null;
    private View.OnClickListener k = null;

    /* renamed from: a */
    LinearLayout f1353a = null;
    ViewGroup b = null;
    TextView c = null;
    private ImageView l = null;
    protected int d = -1;
    private boolean m = false;
    private e q = null;

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, MentionActivity.class);
        intent.putExtra("showBack", true);
        e = true;
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, MentionActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("showBack", true);
        e = true;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        if (getIntent() != null) {
            this.n = getIntent().getBooleanExtra("showBack", false);
        }
        setContentView(R.layout.mention_activity);
        c();
        a(bundle);
    }

    public boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        this.d = TiebaApplication.g().ap();
        super.onResume();
        if (this.m) {
            this.m = false;
            b(0);
        } else if (e) {
            e = false;
            if (s.a().l() > 0) {
                b(0);
            } else if (s.a().i() > 0) {
                b(1);
            } else if (s.a().j() > 0) {
                b(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.i != -1) {
            bundle.putInt("type", this.i);
        } else {
            bundle.putInt("type", 0);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString(LocaleUtil.INDONESIAN);
                    String string2 = extras.getString("name");
                    String string3 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        this.m = true;
                        ChatActivity.a(this, string, string2, string3, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.k = new b(this);
        this.j = (ImageView) findViewById(R.id.add_chat);
        this.j.setOnClickListener(this.k);
        this.f1353a = (LinearLayout) findViewById(R.id.container);
        this.b = (ViewGroup) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.l = (ImageView) findViewById(R.id.back);
        if (this.n) {
            this.l.setOnClickListener(new c(this));
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(4);
        }
        this.p = getSupportFragmentManager();
        this.f = new BaseFragment[]{new ChatListFragment(), new ReplyMeFragment(), new AtMeFragment()};
        this.g = new TextView[]{(TextView) findViewById(R.id.chatme_tab), (TextView) findViewById(R.id.replyme_tab), (TextView) findViewById(R.id.atme_tab)};
        this.h = new TextView[]{(TextView) findViewById(R.id.chatme_msg_num), (TextView) findViewById(R.id.replyme_msg_num), (TextView) findViewById(R.id.atme_msg_num)};
        d dVar = new d(this);
        for (TextView textView : this.g) {
            textView.setOnClickListener(dVar);
        }
        if (bundle != null) {
            intExtra = bundle.getInt("type", 0);
        } else {
            Intent intent = getIntent();
            intExtra = intent != null ? intent.getIntExtra("type", 0) : 0;
        }
        b(intExtra);
    }

    public void a(View view) {
        for (int i = 0; i < this.g.length; i++) {
            if (this.g[i] == view) {
                b(i);
                return;
            }
        }
    }

    protected void b(int i) {
        if (i >= 0 && i <= this.f.length) {
            if (this.i != i) {
                this.i = i;
                a("view" + i, this.f[i]);
                String str = null;
                if (i == 0) {
                    str = "msg_chat_tab_click";
                } else if (i == 1) {
                    str = "msg_reply_tab_click";
                } else if (i == 2) {
                    str = "msg_atme_tab_click";
                }
                if (str != null && TiebaApplication.g().s()) {
                    StatService.onEvent(this, str, "click", 1);
                }
            }
            b();
            a(i, false);
        }
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        int i2 = 0;
        as.a(this.l, i);
        as.a(this.f1353a, i);
        as.d(this.b, i);
        as.f(this.c, i);
        if (i == 1) {
            this.j.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.j.setImageResource(R.drawable.icon_write_news_1);
            TextView[] textViewArr = this.h;
            int length = textViewArr.length;
            while (i2 < length) {
                textViewArr[i2].setTextColor(getResources().getColor(R.color.top_msg_num_night));
                i2++;
            }
        } else {
            this.j.setBackgroundResource(R.drawable.title_icon_bg);
            this.j.setImageResource(R.drawable.icon_write_news);
            TextView[] textViewArr2 = this.h;
            int length2 = textViewArr2.length;
            while (i2 < length2) {
                textViewArr2[i2].setTextColor(getResources().getColor(R.color.top_msg_num_day));
                i2++;
            }
        }
        b();
    }

    private void b() {
        boolean z = this.d == 1;
        for (int i = 0; i < this.g.length; i++) {
            TextView textView = this.g[i];
            if (i == this.i) {
                textView.setTextColor(getResources().getColor(R.color.white));
                if (i == 0) {
                    as.e((View) textView, z ? R.drawable.btn_jin_ba_s_1 : R.drawable.btn_jin_ba_s);
                } else if (i == this.g.length - 1) {
                    as.e((View) textView, z ? R.drawable.btn_baidu_s_1 : R.drawable.btn_baidu_s);
                } else {
                    as.e((View) textView, z ? R.drawable.btn_search_ba_s_1 : R.drawable.btn_search_ba_s);
                }
            } else {
                textView.setTextColor(getResources().getColor(z ? R.color.gray_night_4 : R.color.white));
                if (i == 0) {
                    as.e((View) textView, z ? R.drawable.btn_jin_ba_n_1 : R.drawable.btn_jin_ba_n);
                } else if (i == this.g.length - 1) {
                    as.e((View) textView, z ? R.drawable.btn_baidu_n_1 : R.drawable.btn_baidu_n);
                } else {
                    as.e((View) textView, z ? R.drawable.btn_search_ba_n_1 : R.drawable.btn_search_ba_n);
                }
            }
        }
    }

    public void a(long[] jArr) {
        boolean z = this.d == 1;
        for (int i = 0; i < jArr.length; i++) {
            TextView textView = this.h[i];
            long j = jArr[i];
            if (j <= 0) {
                textView.setVisibility(8);
            } else if (j < 10) {
                textView.setText(String.valueOf(j));
                textView.setBackgroundResource(z ? R.drawable.icon_news_prompt_1 : R.drawable.icon_news_prompt);
                textView.setVisibility(0);
            } else if (j < 100) {
                textView.setText(String.valueOf(j));
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_1 : R.drawable.icon_news_head_prompt);
                textView.setVisibility(0);
            } else {
                textView.setText("   ");
                textView.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                textView.setVisibility(0);
            }
        }
    }

    public void a(String str, BaseFragment baseFragment) {
        if (baseFragment != null) {
            this.o = this.p.a();
            this.o.b(R.id.content, baseFragment, str);
            this.o.b();
        }
    }

    public void a(int i, boolean z) {
        long i2 = s.a().i();
        long j = s.a().j();
        long[] jArr = new long[3];
        jArr[0] = s.a().l();
        jArr[1] = i2;
        jArr[2] = j;
        if (z && i < jArr.length && i > -1 && i != 0) {
            jArr[i] = 0;
        }
        a(jArr);
        if (i != 0 && z) {
            s.a().a(jArr[1], jArr[2], s.a().k(), jArr[0]);
        }
    }

    private void c() {
        this.q = new e(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        registerReceiver(this.q, intentFilter);
    }

    private void d() {
        if (this.q != null) {
            unregisterReceiver(this.q);
        }
    }
}
