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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPagerAdapter;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NewNearbyActivity extends com.baidu.tieba.e {
    private RelativeLayout e = null;
    private RelativeLayout f = null;
    private AbsoluteLayout g = null;
    private TextView h = null;
    private int i = 0;
    private bf j = null;
    private ViewPager k = null;
    private BaseViewPagerAdapter l = null;
    LocalActivityManager c = null;
    private com.baidu.tieba.am m = null;
    private Address n = null;
    private ProgressBar o = null;
    private TextView p = null;
    private RadioGroup q = null;
    private CompoundButton.OnCheckedChangeListener r = null;
    private RadioButton s = null;
    private RadioButton t = null;
    private ImageView u = null;
    private ImageView v = null;
    private View.OnTouchListener w = null;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private ImageView A = null;
    private ImageView B = null;
    private ImageView C = null;
    private View.OnClickListener D = null;
    private Animation.AnimationListener E = null;
    private boolean F = true;
    private AlertDialog G = null;
    private com.baidu.tieba.d.a H = null;
    private com.baidu.tieba.d.d I = new au(this);
    public GestureDetector.OnGestureListener d = new ax(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_nearby_activity);
        this.c = new LocalActivityManager(this, false);
        this.c.dispatchCreate(bundle != null ? bundle.getBundle("android:states") : null);
        b();
        p();
        q();
        this.H = new com.baidu.tieba.d.a(this);
        if (r()) {
            o();
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
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        TiebaApplication.d().b(this.m);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        if (i == 1) {
            this.A.setImageResource(R.drawable.lbs_send_normal_1);
            this.B.setImageResource(R.drawable.lbs_send_pic_1);
            this.C.setImageResource(R.drawable.lbs_send_text_1);
            com.baidu.tieba.d.ac.h((View) this.s, (int) R.drawable.lbs_title_bg_1);
            com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.lbs_title_bg_1);
            this.s.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            this.t.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            com.baidu.tieba.d.ac.h(this.u, (int) R.drawable.lbs_title_bg_normal_1);
            com.baidu.tieba.d.ac.h(this.v, (int) R.drawable.lbs_title_bg_normal_1);
            this.v.setImageDrawable(new ColorDrawable(-13421773));
            this.k.setBackgroundColor(-13618114);
            return;
        }
        this.A.setImageResource(R.drawable.lbs_send_normal);
        this.B.setImageResource(R.drawable.lbs_send_pic);
        this.C.setImageResource(R.drawable.lbs_send_text);
        com.baidu.tieba.d.ac.h((View) this.s, (int) R.drawable.lbs_title_bg);
        com.baidu.tieba.d.ac.h((View) this.t, (int) R.drawable.lbs_title_bg);
        this.s.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        this.t.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        com.baidu.tieba.d.ac.h(this.u, (int) R.drawable.lbs_title_bg_normal);
        com.baidu.tieba.d.ac.h(this.v, (int) R.drawable.lbs_title_bg_normal);
        this.v.setImageDrawable(new ColorDrawable(-2763307));
        this.k.setBackgroundColor(-1380623);
    }

    void b() {
        this.e = (RelativeLayout) findViewById(R.id.new_nearby_activity_layout);
        CompatibleUtile.getInstance().closeViewGpu(this.e);
        this.f = (RelativeLayout) findViewById(R.id.static_map_layout);
        this.f.setOnTouchListener(new ay(this));
        this.f.setOnClickListener(new az(this));
        this.g = (AbsoluteLayout) findViewById(R.id.static_map);
        this.h = (TextView) findViewById(R.id.static_map_text);
        this.E = new ba(this);
        this.D = new bb(this);
        this.r = new bc(this);
        this.w = new bd(this);
        this.A = (ImageView) findViewById(R.id.main_key);
        this.B = (ImageView) findViewById(R.id.send_pic);
        this.C = (ImageView) findViewById(R.id.send_text);
        this.A.setOnClickListener(this.D);
        this.B.setOnClickListener(this.D);
        this.C.setOnClickListener(this.D);
        this.q = (RadioGroup) findViewById(R.id.title_lbs);
        this.s = (RadioButton) findViewById(R.id.title_lbs_threads);
        this.t = (RadioButton) findViewById(R.id.title_lbs_bars);
        this.u = (ImageView) findViewById(R.id.refresh);
        this.v = (ImageView) findViewById(R.id.divider);
        this.s.setOnCheckedChangeListener(this.r);
        this.t.setOnCheckedChangeListener(this.r);
        this.B.setOnTouchListener(this.w);
        this.C.setOnTouchListener(this.w);
        this.A.setOnTouchListener(this.w);
        this.u.setOnClickListener(this.D);
        this.p = (TextView) findViewById(R.id.no_location_info_view);
        this.o = (ProgressBar) findViewById(R.id.location_progress);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new be(this));
        if (this.G == null) {
            this.G = builder.create();
            this.G.setCanceledOnTouchOutside(true);
        }
        this.i = com.baidu.tieba.d.ag.a(this, 29.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent(this, NearbyPostActivity.class);
        Intent intent2 = new Intent(this, NearbyForumActivity.class);
        View decorView = this.c.startActivity("nearby_post", intent).getDecorView();
        View decorView2 = this.c.startActivity("nearby_forum", intent2).getDecorView();
        arrayList.add(decorView);
        arrayList.add(decorView2);
        this.l.a(arrayList);
        this.l.notifyDataSetChanged();
    }

    private void p() {
        this.k = (ViewPager) findViewById(R.id.view_pager);
        this.l = new BaseViewPagerAdapter();
        this.k.setAdapter(this.l);
        this.k.setOnPageChangeListener(new av(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String z = TiebaApplication.z();
        if (z == null || z.length() <= 0) {
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (i == 0) {
            WriteActivity.a(this);
        } else {
            this.G.show();
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
                    this.G.show();
                    break;
                case 1200001:
                    WriteImageActivity.b(this, 1200001, 12000010, null);
                    break;
                case 1200002:
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.b(this, 1200002, 1200009, intent.getData());
                        break;
                    } else {
                        com.baidu.tieba.write.bb.b(this);
                        break;
                    }
                    break;
                case 1200009:
                case 12000010:
                    if (intent == null || intent.getStringExtra("filename") == null) {
                        WriteActivity.a((Activity) this, true, (String) null);
                        break;
                    } else {
                        WriteActivity.a((Activity) this, true, intent.getStringExtra("filename"));
                        break;
                    }
                case 1300005:
                    t();
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200009:
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

    private void q() {
        this.m = new aw(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        this.o.setVisibility(0);
        this.n = TiebaApplication.d().a(this.m);
        if (this.n != null) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        int currentItem = this.k.getCurrentItem();
        if (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) {
            ((NearbyPostActivity) this.c.getActivity("nearby_post")).a(0, this.n, currentItem == 0);
        }
        if (this.c.getActivity("nearby_forum") instanceof NearbyForumActivity) {
            ((NearbyForumActivity) this.c.getActivity("nearby_forum")).a(this.n, currentItem == 1);
        }
    }

    private void t() {
        if (this.k.getCurrentItem() != 0) {
            this.k.a(0, true);
        }
        if (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) {
            ((NearbyPostActivity) this.c.getActivity("nearby_post")).a(0, this.n, true);
        }
    }

    public void c() {
        if (this.n != null) {
            String str = null;
            if (this.n.getMaxAddressLineIndex() >= 0) {
                str = this.n.getAddressLine(0);
            }
            if (str != null) {
                this.h.setText(str);
            }
            if (this.j != null) {
                this.j.cancel();
            }
            if (this.k.getChildCount() >= 2 && (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) && ((NearbyPostActivity) this.c.getActivity("nearby_post")).n() != null) {
                this.j = new bf(this, this.n, ((NearbyPostActivity) this.c.getActivity("nearby_post")).n());
                this.j.setPriority(3);
                this.j.execute(new String[0]);
            }
        }
    }

    public Address d() {
        return this.n;
    }

    public int m() {
        return this.k.getCurrentItem();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.x = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && !this.x) {
            n();
        }
        return dispatchTouchEvent;
    }

    public void n() {
        if (!this.F) {
            this.D.onClick(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.k.getChildCount() >= 2 && (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) && ((NearbyPostActivity) this.c.getActivity("nearby_post")).n() != null) {
            com.baidu.tieba.c.as n = ((NearbyPostActivity) this.c.getActivity("nearby_post")).n();
            if (n.d().size() >= 1) {
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this, "lbs_open_map", "lbsclick", 1);
                }
                com.baidu.tieba.c.ag agVar = new com.baidu.tieba.c.ag();
                agVar.a(n.b());
                agVar.a(n.d());
                NearbyMapActivity.a(this, this.n, agVar);
                MainTabActivity.a();
            }
        }
    }
}
