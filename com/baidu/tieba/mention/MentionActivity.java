package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ag;
/* loaded from: classes.dex */
public class MentionActivity extends ActivityGroup {
    private FrameLayout g;
    private RadioButton a = null;
    private RadioButton b = null;
    private Button c = null;
    private Button d = null;
    private View.OnClickListener e = null;
    private CompoundButton.OnCheckedChangeListener f = null;
    private d h = null;

    private void a() {
        this.h = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.notify");
        registerReceiver(this.h, intentFilter);
    }

    public void a(long j, long j2) {
        if (j > 0) {
            this.b.setText(String.format("%s(%s)", getString(R.string.mention_replyme), String.valueOf(j)));
        } else {
            this.b.setText(R.string.mention_replyme);
        }
        if (j2 > 0) {
            this.a.setText(String.format("%s(%s)", getString(R.string.mention_atme), String.valueOf(j2)));
        } else {
            this.a.setText(R.string.mention_atme);
        }
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, MentionActivity.class), i);
    }

    private void a(Bundle bundle) {
        this.e = new b(this);
        this.d = (Button) findViewById(R.id.back);
        this.c = (Button) findViewById(R.id.refresh);
        this.d.setOnClickListener(this.e);
        this.c.setOnClickListener(this.e);
        this.g = (FrameLayout) findViewById(R.id.content);
        this.b = (RadioButton) findViewById(R.id.replyme_tab);
        this.a = (RadioButton) findViewById(R.id.atme_tab);
        this.f = new c(this);
        this.b.setOnCheckedChangeListener(this.f);
        this.a.setOnCheckedChangeListener(this.f);
        if ((bundle != null ? bundle.getInt("type", 0) : getIntent().getIntExtra("type", 0)) == 1) {
            this.a.setChecked(true);
        } else {
            this.b.setChecked(true);
        }
    }

    private void b() {
        if (this.h != null) {
            unregisterReceiver(this.h);
        }
    }

    public void a(int i, boolean z) {
        long S = TiebaApplication.a().S();
        long T = TiebaApplication.a().T();
        if (!z) {
            a(S, T);
            return;
        }
        switch (i) {
            case 0:
                a(0L, T);
                TiebaApplication.a().d(0L);
                return;
            case 1:
                a(S, 0L);
                TiebaApplication.a().e(0L);
                return;
            default:
                return;
        }
    }

    public void a(String str, Class cls) {
        Intent intent = new Intent(this, cls);
        this.g.removeAllViews();
        this.g.addView(getLocalActivityManager().startActivity(str, intent).getDecorView());
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mention_activity);
        a();
        a(bundle);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        ag.e(this);
        if (TiebaApplication.a().S() > 0 && this.b != null) {
            this.b.setChecked(true);
        } else if (TiebaApplication.a().T() <= 0 || this.a == null) {
        } else {
            this.a.setChecked(true);
        }
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
}
