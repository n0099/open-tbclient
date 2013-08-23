package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class MentionActivity extends ActivityGroup {
    public static boolean e;
    private Class[] g;
    private TextView[] h;
    private TextView[] i;
    private ViewGroup m;
    private boolean p;
    private int[] f = {0, 1, 2};
    private int j = -1;
    private ImageView k = null;
    private View.OnClickListener l = null;

    /* renamed from: a */
    RelativeLayout f1319a = null;
    ViewGroup b = null;
    TextView c = null;
    private ImageView n = null;
    protected int d = -1;
    private boolean o = false;
    private e q = null;

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, MentionActivity.class);
        intent.putExtra("showBack", true);
        e = true;
        activity.startActivityForResult(intent, i);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        if (getIntent() != null) {
            this.p = getIntent().getBooleanExtra("showBack", false);
        }
        setContentView(R.layout.mention_activity);
        c();
        a(bundle);
    }

    public boolean a() {
        return false;
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TiebaApplication.g().an() != this.d) {
            this.d = TiebaApplication.g().an();
            b(this.d);
        }
        if (this.o) {
            this.o = false;
            a(0);
        } else if (e) {
            e = false;
            if (r.a().j() > 0) {
                a(0);
            } else if (r.a().g() > 0) {
                a(1);
            } else if (r.a().h() > 0) {
                a(2);
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Activity currentActivity = getLocalActivityManager().getCurrentActivity();
        for (int i = 0; i < this.g.length; i++) {
            if (this.g[i].equals(currentActivity.getClass())) {
                bundle.putInt("type", i);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString(LocaleUtil.INDONESIAN);
                    String string2 = extras.getString("name");
                    String string3 = extras.getString("portrait");
                    if (string2 != null && string != null) {
                        this.o = true;
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
        this.l = new b(this);
        this.k = (ImageView) findViewById(R.id.add_chat);
        this.k.setOnClickListener(this.l);
        this.m = (ViewGroup) findViewById(R.id.content);
        this.f1319a = (RelativeLayout) findViewById(R.id.container);
        this.b = (ViewGroup) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.n = (ImageView) findViewById(R.id.back);
        if (this.p) {
            this.n.setOnClickListener(new c(this));
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(4);
        }
        this.g = new Class[]{ChatListActivity.class, ReplyMeActivity.class, AtMeActivity.class};
        this.h = new TextView[]{(TextView) findViewById(R.id.chatme_tab), (TextView) findViewById(R.id.replyme_tab), (TextView) findViewById(R.id.atme_tab)};
        this.i = new TextView[]{(TextView) findViewById(R.id.chatme_msg_num), (TextView) findViewById(R.id.replyme_msg_num), (TextView) findViewById(R.id.atme_msg_num)};
        d dVar = new d(this);
        for (TextView textView : this.h) {
            textView.setOnClickListener(dVar);
        }
        if (bundle != null) {
            intExtra = bundle.getInt("type", 0);
        } else {
            Intent intent = getIntent();
            intExtra = intent != null ? intent.getIntExtra("type", 0) : 0;
        }
        a(intExtra);
    }

    public void a(View view) {
        for (int i = 0; i < this.h.length; i++) {
            if (this.h[i] == view) {
                a(i);
                return;
            }
        }
    }

    protected void a(int i) {
        if (this.j != i) {
            this.j = i;
            if (i < this.g.length) {
                a("view" + i, this.g[i]);
            }
            String str = null;
            if (i == 0) {
                str = "msg_chat_tab_click";
            } else if (i == 1) {
                str = "msg_reply_tab_click";
            } else if (i == 2) {
                str = "msg_atme_tab_click";
            }
            if (str != null && TiebaApplication.g().u()) {
                StatService.onEvent(this, str, "click", 1);
            }
        }
        b();
        a(i, false);
    }

    private void b(int i) {
        int i2 = 0;
        ao.a(this.n, i);
        ao.a(this.f1319a, i);
        ao.d(this.b, i);
        ao.f(this.c, i);
        if (i == 1) {
            this.k.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.k.setImageResource(R.drawable.icon_write_news_1);
            TextView[] textViewArr = this.i;
            int length = textViewArr.length;
            while (i2 < length) {
                textViewArr[i2].setTextColor(getResources().getColor(R.color.top_msg_num_night));
                i2++;
            }
        } else {
            this.k.setBackgroundResource(R.drawable.title_icon_bg);
            this.k.setImageResource(R.drawable.icon_write_news);
            TextView[] textViewArr2 = this.i;
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
        for (int i = 0; i < this.h.length; i++) {
            TextView textView = this.h[i];
            if (i == this.j) {
                textView.setTextColor(getResources().getColor(R.color.white));
                if (i == 0) {
                    ao.g((View) textView, z ? R.drawable.btn_jin_ba_s_1 : R.drawable.btn_jin_ba_s);
                } else if (i == this.h.length - 1) {
                    ao.g((View) textView, z ? R.drawable.btn_baidu_s_1 : R.drawable.btn_baidu_s);
                } else {
                    ao.g((View) textView, z ? R.drawable.btn_search_ba_s_1 : R.drawable.btn_search_ba_s);
                }
            } else {
                textView.setTextColor(getResources().getColor(z ? R.color.gray_night_4 : R.color.white));
                if (i == 0) {
                    ao.g((View) textView, z ? R.drawable.btn_jin_ba_n_1 : R.drawable.btn_jin_ba_n);
                } else if (i == this.h.length - 1) {
                    ao.g((View) textView, z ? R.drawable.btn_baidu_n_1 : R.drawable.btn_baidu_n);
                } else {
                    ao.g((View) textView, z ? R.drawable.btn_search_ba_n_1 : R.drawable.btn_search_ba_n);
                }
            }
        }
    }

    public void a(long[] jArr) {
        boolean z = this.d == 1;
        for (int i = 0; i < jArr.length; i++) {
            TextView textView = this.i[i];
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

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.m.removeAllViews();
        this.m.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    public void a(int i, boolean z) {
        long g = r.a().g();
        long h = r.a().h();
        long[] jArr = new long[3];
        jArr[0] = r.a().j();
        jArr[1] = g;
        jArr[2] = h;
        if (z && i < jArr.length && i > -1 && i != 0) {
            jArr[i] = 0;
        }
        a(jArr);
        if (i != 0 && z) {
            r.a().a(jArr[1], jArr[2], r.a().i(), jArr[0]);
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
