package com.baidu.tieba.nearby;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.view.BaseViewPagerAdapter;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NewNearbyActivity extends com.baidu.tieba.e {
    private RelativeLayout e = null;
    private AbsoluteLayout f = null;
    private TextView g = null;
    private int h = 0;
    private bg i = null;
    private ViewPager j = null;
    private BaseViewPagerAdapter k = null;
    LocalActivityManager c = null;
    private com.baidu.tieba.an l = null;
    private Address m = null;
    private ProgressBar n = null;
    private TextView o = null;
    private RadioGroup p = null;
    private CompoundButton.OnCheckedChangeListener q = null;
    private RadioButton r = null;
    private RadioButton s = null;
    private ImageView t = null;
    private ImageView u = null;
    private View.OnTouchListener v = null;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private ImageView z = null;
    private ImageView A = null;
    private ImageView B = null;
    private View.OnClickListener C = null;
    private Animation.AnimationListener D = null;
    private boolean E = true;
    private AlertDialog F = null;
    private com.baidu.tieba.c.a G = null;
    private com.baidu.tieba.c.d H = new av(this);
    public GestureDetector.OnGestureListener d = new ay(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_nearby_activity);
        this.c = new LocalActivityManager(this, false);
        this.c.dispatchCreate(bundle != null ? bundle.getBundle("android:states") : null);
        i();
        o();
        p();
        this.G = new com.baidu.tieba.c.a(this);
        if (q()) {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.dispatchResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle saveInstanceState = this.c.saveInstanceState();
        if (saveInstanceState != null) {
            bundle.putBundle("android:states", saveInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.dispatchPause(isFinishing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        this.c.dispatchStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        this.c.dispatchDestroy(isFinishing());
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        TiebaApplication.b().b(this.l);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        if (i == 1) {
            this.z.setImageResource(R.drawable.lbs_send_normal_1);
            this.A.setImageResource(R.drawable.lbs_send_pic_1);
            this.B.setImageResource(R.drawable.lbs_send_text_1);
            com.baidu.tieba.c.ae.h(this.r, R.drawable.lbs_title_bg_1);
            com.baidu.tieba.c.ae.h(this.s, R.drawable.lbs_title_bg_1);
            this.r.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            this.s.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            com.baidu.tieba.c.ae.h(this.t, R.drawable.lbs_title_bg_normal_1);
            com.baidu.tieba.c.ae.h(this.u, R.drawable.lbs_title_bg_normal_1);
            this.u.setImageDrawable(new ColorDrawable(-13421773));
            this.j.setBackgroundColor(-13158601);
            return;
        }
        this.z.setImageResource(R.drawable.lbs_send_normal);
        this.A.setImageResource(R.drawable.lbs_send_pic);
        this.B.setImageResource(R.drawable.lbs_send_text);
        com.baidu.tieba.c.ae.h(this.r, R.drawable.lbs_title_bg);
        com.baidu.tieba.c.ae.h(this.s, R.drawable.lbs_title_bg);
        this.r.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        this.s.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        com.baidu.tieba.c.ae.h(this.t, R.drawable.lbs_title_bg_normal);
        com.baidu.tieba.c.ae.h(this.u, R.drawable.lbs_title_bg_normal);
        this.u.setImageDrawable(new ColorDrawable(-2763307));
        this.j.setBackgroundColor(-1380623);
    }

    void i() {
        this.e = (RelativeLayout) findViewById(R.id.static_map_layout);
        this.e.setOnTouchListener(new az(this));
        this.e.setOnClickListener(new ba(this));
        this.f = (AbsoluteLayout) findViewById(R.id.static_map);
        this.g = (TextView) findViewById(R.id.static_map_text);
        this.D = new bb(this);
        this.C = new bc(this);
        this.q = new bd(this);
        this.v = new be(this);
        this.z = (ImageView) findViewById(R.id.main_key);
        this.A = (ImageView) findViewById(R.id.send_pic);
        this.B = (ImageView) findViewById(R.id.send_text);
        this.z.setOnClickListener(this.C);
        this.A.setOnClickListener(this.C);
        this.B.setOnClickListener(this.C);
        this.p = (RadioGroup) findViewById(R.id.title_lbs);
        this.r = (RadioButton) findViewById(R.id.title_lbs_threads);
        this.s = (RadioButton) findViewById(R.id.title_lbs_bars);
        this.t = (ImageView) findViewById(R.id.refresh);
        this.u = (ImageView) findViewById(R.id.divider);
        this.r.setOnCheckedChangeListener(this.q);
        this.s.setOnCheckedChangeListener(this.q);
        this.A.setOnTouchListener(this.v);
        this.B.setOnTouchListener(this.v);
        this.z.setOnTouchListener(this.v);
        this.t.setOnClickListener(this.C);
        this.o = (TextView) findViewById(R.id.no_location_info_view);
        this.n = (ProgressBar) findViewById(R.id.location_progress);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new bf(this));
        if (this.F == null) {
            this.F = builder.create();
            this.F.setCanceledOnTouchOutside(true);
        }
        this.h = com.baidu.tieba.c.ai.a(this, 29.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent(this, NearbyPostActivity.class);
        Intent intent2 = new Intent(this, NearbyForumActivity.class);
        View decorView = this.c.startActivity("nearby_post", intent).getDecorView();
        View decorView2 = this.c.startActivity("nearby_forum", intent2).getDecorView();
        arrayList.add(decorView);
        arrayList.add(decorView2);
        this.k.a(arrayList);
        this.k.notifyDataSetChanged();
    }

    private void o() {
        this.j = (ViewPager) findViewById(R.id.view_pager);
        this.k = new BaseViewPagerAdapter();
        this.j.setAdapter(this.k);
        this.j.setOnPageChangeListener(new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (i == 0) {
            WriteActivity.a(this);
        } else {
            this.F.show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100001:
                    c(0);
                    break;
                case 1100016:
                    this.F.show();
                    break;
                case 1200001:
                    WriteImageActivity.a(this, 1200001, 12000010, null);
                    break;
                case 1200002:
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200008, intent.getData());
                        break;
                    } else {
                        com.baidu.tieba.write.bb.b(this);
                        break;
                    }
                    break;
                case 1200008:
                case 12000010:
                    if (intent == null || intent.getStringExtra("filename") == null) {
                        WriteActivity.a((Activity) this, true, (String) null);
                        break;
                    } else {
                        WriteActivity.a((Activity) this, true, intent.getStringExtra("filename"));
                        break;
                    }
                case 1300005:
                    s();
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200008:
                    com.baidu.tieba.write.bb.b(this);
                    break;
                case 12000010:
                    com.baidu.tieba.write.bb.a(this);
                    break;
            }
        }
        Activity activity = this.c.getActivity("nearby_post");
        if (activity instanceof NearbyPostActivity) {
            if (i == 1300006 || i == 1100024) {
                ((NearbyPostActivity) activity).onActivityResult(i, i2, intent);
            }
        }
    }

    private void p() {
        this.l = new ax(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        this.n.setVisibility(0);
        this.m = TiebaApplication.b().a(this.l);
        if (this.m != null) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        int currentItem = this.j.getCurrentItem();
        if (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) {
            ((NearbyPostActivity) this.c.getActivity("nearby_post")).a(0, this.m, currentItem == 0);
        }
        if (this.c.getActivity("nearby_forum") instanceof NearbyForumActivity) {
            ((NearbyForumActivity) this.c.getActivity("nearby_forum")).a(this.m, currentItem == 1);
        }
    }

    private void s() {
        if (this.j.getCurrentItem() != 0) {
            this.j.a(0, true);
        }
        if (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) {
            ((NearbyPostActivity) this.c.getActivity("nearby_post")).a(0, this.m, true);
        }
    }

    public void j() {
        if (this.m != null) {
            String str = null;
            if (this.m.getMaxAddressLineIndex() >= 0) {
                str = this.m.getAddressLine(0);
            }
            this.g.setText(str);
            if (this.i != null) {
                this.i.a();
            }
            if (this.j.getChildCount() >= 2 && (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) && ((NearbyPostActivity) this.c.getActivity("nearby_post")).m() != null) {
                this.i = new bg(this, this.m, ((NearbyPostActivity) this.c.getActivity("nearby_post")).m());
                this.i.execute(new String[0]);
            }
        }
    }

    public Address k() {
        return this.m;
    }

    public int l() {
        return this.j.getCurrentItem();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.w = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && !this.w) {
            m();
        }
        return dispatchTouchEvent;
    }

    public void m() {
        if (!this.E) {
            this.C.onClick(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.j.getChildCount() >= 2 && (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) && ((NearbyPostActivity) this.c.getActivity("nearby_post")).m() != null) {
            com.baidu.tieba.b.p m = ((NearbyPostActivity) this.c.getActivity("nearby_post")).m();
            if (m.d().size() >= 1) {
                if (TiebaApplication.b().l()) {
                    StatService.onEvent(this, "lbs_open_map", "lbsclick", 1);
                }
                com.baidu.tieba.b.i iVar = new com.baidu.tieba.b.i();
                iVar.a(m.b());
                iVar.a(m.d());
                NearbyMapActivity.a(this, this.m, iVar);
                MainTabActivity.a();
            }
        }
    }
}
