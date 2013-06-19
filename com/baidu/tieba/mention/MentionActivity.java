package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d.ac;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MentionActivity extends ActivityGroup {
    private FrameLayout k;
    private RadioButton e = null;
    private RadioButton f = null;
    private ImageView g = null;
    private ImageView h = null;
    private View.OnClickListener i = null;
    private CompoundButton.OnCheckedChangeListener j = null;
    RelativeLayout a = null;
    RelativeLayout b = null;
    TextView c = null;
    protected int d = -1;
    private d l = null;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, MentionActivity.class), i);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            CompatibleUtile.getInstance().openGpu(this);
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
        if (TiebaApplication.e().as() != this.d) {
            this.d = TiebaApplication.e().as();
            a(this.d);
        }
        if (TiebaApplication.e().ac() > 0 && this.f != null) {
            this.f.setChecked(true);
        } else if (TiebaApplication.e().ad() > 0 && this.e != null) {
            this.e.setChecked(true);
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
        if (getLocalActivityManager().getCurrentActivity() instanceof AtMeActivity) {
            bundle.putInt("type", 1);
        } else {
            bundle.putInt("type", 0);
        }
    }

    private void a(Bundle bundle) {
        int intExtra;
        this.i = new b(this);
        this.h = (ImageView) findViewById(R.id.back);
        this.g = (ImageView) findViewById(R.id.refresh);
        this.h.setOnClickListener(this.i);
        this.g.setOnClickListener(this.i);
        this.k = (FrameLayout) findViewById(R.id.content);
        this.a = (RelativeLayout) findViewById(R.id.container);
        this.b = (RelativeLayout) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.f = (RadioButton) findViewById(R.id.replyme_tab);
        this.e = (RadioButton) findViewById(R.id.atme_tab);
        this.j = new c(this);
        this.f.setOnCheckedChangeListener(this.j);
        this.e.setOnCheckedChangeListener(this.j);
        if (bundle != null) {
            intExtra = bundle.getInt("type", 0);
        } else {
            intExtra = getIntent().getIntExtra("type", 0);
        }
        if (intExtra == 1) {
            this.e.setChecked(true);
        } else {
            this.f.setChecked(true);
        }
    }

    private void a(int i) {
        ac.a(this.h, i);
        ac.b(this.g, i);
        ac.a(this.a, i);
        ac.d(this.b, i);
        ac.f(this.c, i);
        ac.g((View) this.f, i);
        ac.g((View) this.e, i);
        b();
    }

    public void b() {
        if (this.f.isChecked()) {
            if (this.d == 1) {
                this.f.setTextColor(getResources().getColor(R.color.skin_1_common_color));
                this.e.setTextColor(getResources().getColor(R.color.skin_1_tab_unsel_color));
            } else {
                this.f.setTextColor(getResources().getColor(R.color.tab_hightlight_text_color));
                this.e.setTextColor(getResources().getColor(R.color.tab_text_color));
            }
        }
        if (this.e.isChecked()) {
            if (this.d == 1) {
                this.e.setTextColor(getResources().getColor(R.color.skin_1_common_color));
                this.f.setTextColor(getResources().getColor(R.color.skin_1_tab_unsel_color));
                return;
            }
            this.e.setTextColor(getResources().getColor(R.color.tab_hightlight_text_color));
            this.f.setTextColor(getResources().getColor(R.color.tab_text_color));
        }
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.k.removeAllViews();
        this.k.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    public void a(int i, boolean z) {
        long ac = TiebaApplication.e().ac();
        long ad = TiebaApplication.e().ad();
        if (z) {
            switch (i) {
                case 0:
                    a(0L, ad);
                    TiebaApplication.e().d(0L);
                    return;
                case 1:
                    a(ac, 0L);
                    TiebaApplication.e().e(0L);
                    return;
                default:
                    return;
            }
        }
        a(ac, ad);
    }

    public void a(long j, long j2) {
        if (j > 0) {
            this.f.setText(String.format("%s(%s)", getString(R.string.mention_replyme), String.valueOf(j)));
        } else {
            this.f.setText(R.string.mention_replyme);
        }
        if (j2 > 0) {
            this.e.setText(String.format("%s(%s)", getString(R.string.mention_atme), String.valueOf(j2)));
        } else {
            this.e.setText(R.string.mention_atme);
        }
    }

    private void c() {
        this.l = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        registerReceiver(this.l, intentFilter);
    }

    private void d() {
        if (this.l != null) {
            unregisterReceiver(this.l);
        }
    }
}
