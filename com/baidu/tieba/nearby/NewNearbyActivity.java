package com.baidu.tieba.nearby;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
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
    private bj j = null;
    private ViewPager k = null;
    private BaseViewPagerAdapter l = null;
    private Dialog m = null;
    private Bitmap n = null;
    private RelativeLayout o = null;
    LocalActivityManager c = null;
    private com.baidu.tieba.am p = null;
    private Address q = null;
    private ProgressBar r = null;
    private TextView s = null;
    private RadioGroup t = null;
    private CompoundButton.OnCheckedChangeListener u = null;
    private RadioButton v = null;
    private RadioButton w = null;
    private ImageView x = null;
    private ImageView y = null;
    private View.OnTouchListener z = null;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private ImageView D = null;
    private ImageView E = null;
    private ImageView F = null;
    private View.OnClickListener G = null;
    private Animation.AnimationListener H = null;
    private boolean I = true;
    private AlertDialog J = null;
    private com.baidu.tieba.d.a K = null;
    private com.baidu.tbadk.a.d L = new av(this);
    public GestureDetector.OnGestureListener d = new bb(this);

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
        this.K = new com.baidu.tieba.d.a(this);
        if (r()) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.dispatchResume();
        if (TiebaApplication.d().aq() && !TiebaApplication.d().A()) {
            w();
            TiebaApplication.d().h(true);
        }
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
        v();
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
        if (this.r != null) {
            this.r.setVisibility(8);
        }
        v();
        TiebaApplication.d().b(this.p);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        if (i == 1) {
            this.D.setImageResource(R.drawable.lbs_send_normal_1);
            this.E.setImageResource(R.drawable.lbs_send_pic_1);
            this.F.setImageResource(R.drawable.lbs_send_text_1);
            com.baidu.tieba.d.ac.h((View) this.v, (int) R.drawable.lbs_title_bg_1);
            com.baidu.tieba.d.ac.h((View) this.w, (int) R.drawable.lbs_title_bg_1);
            this.v.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            this.w.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            com.baidu.tieba.d.ac.h(this.x, (int) R.drawable.lbs_title_bg_normal_1);
            com.baidu.tieba.d.ac.h(this.y, (int) R.drawable.lbs_title_bg_normal_1);
            this.y.setImageDrawable(new ColorDrawable(-13421773));
            this.k.setBackgroundColor(-13618114);
            return;
        }
        this.D.setImageResource(R.drawable.lbs_send_normal);
        this.E.setImageResource(R.drawable.lbs_send_pic);
        this.F.setImageResource(R.drawable.lbs_send_text);
        com.baidu.tieba.d.ac.h((View) this.v, (int) R.drawable.lbs_title_bg);
        com.baidu.tieba.d.ac.h((View) this.w, (int) R.drawable.lbs_title_bg);
        this.v.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        this.w.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        com.baidu.tieba.d.ac.h(this.x, (int) R.drawable.lbs_title_bg_normal);
        com.baidu.tieba.d.ac.h(this.y, (int) R.drawable.lbs_title_bg_normal);
        this.y.setImageDrawable(new ColorDrawable(-2763307));
        this.k.setBackgroundColor(-1380623);
    }

    void b() {
        this.e = (RelativeLayout) findViewById(R.id.new_nearby_activity_layout);
        CompatibleUtile.getInstance().closeViewGpu(this.e);
        this.f = (RelativeLayout) findViewById(R.id.static_map_layout);
        this.f.setOnTouchListener(new bc(this));
        this.f.setOnClickListener(new bd(this));
        this.g = (AbsoluteLayout) findViewById(R.id.static_map);
        this.h = (TextView) findViewById(R.id.static_map_text);
        this.H = new be(this);
        this.G = new bf(this);
        this.u = new bg(this);
        this.z = new bh(this);
        this.D = (ImageView) findViewById(R.id.main_key);
        this.E = (ImageView) findViewById(R.id.send_pic);
        this.F = (ImageView) findViewById(R.id.send_text);
        this.D.setOnClickListener(this.G);
        this.E.setOnClickListener(this.G);
        this.F.setOnClickListener(this.G);
        this.t = (RadioGroup) findViewById(R.id.title_lbs);
        this.v = (RadioButton) findViewById(R.id.title_lbs_threads);
        this.w = (RadioButton) findViewById(R.id.title_lbs_bars);
        this.x = (ImageView) findViewById(R.id.refresh);
        this.y = (ImageView) findViewById(R.id.divider);
        this.v.setOnCheckedChangeListener(this.u);
        this.w.setOnCheckedChangeListener(this.u);
        this.E.setOnTouchListener(this.z);
        this.F.setOnTouchListener(this.z);
        this.D.setOnTouchListener(this.z);
        this.x.setOnClickListener(this.G);
        this.s = (TextView) findViewById(R.id.no_location_info_view);
        this.r = (ProgressBar) findViewById(R.id.location_progress);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new bi(this));
        if (this.J == null) {
            this.J = builder.create();
            this.J.setCanceledOnTouchOutside(true);
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
        this.k.setOnPageChangeListener(new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String B = TiebaApplication.B();
        if (B == null || B.length() <= 0) {
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (i == 0) {
            WriteActivity.a(this);
        } else {
            this.J.show();
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
                    this.J.show();
                    break;
                case 1200001:
                    WriteImageActivity.b(this, 1200001, 1200010, null);
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
                case 1200010:
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
                case 1200010:
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
        this.p = new ax(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        this.r.setVisibility(0);
        this.q = TiebaApplication.d().a(this.p);
        if (this.q != null) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        int currentItem = this.k.getCurrentItem();
        if (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) {
            ((NearbyPostActivity) this.c.getActivity("nearby_post")).a(0, this.q, currentItem == 0);
        }
        if (this.c.getActivity("nearby_forum") instanceof NearbyForumActivity) {
            ((NearbyForumActivity) this.c.getActivity("nearby_forum")).a(this.q, currentItem == 1);
        }
    }

    private void t() {
        if (this.k.getCurrentItem() != 0) {
            this.k.a(0, true);
        }
        if (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) {
            ((NearbyPostActivity) this.c.getActivity("nearby_post")).a(0, this.q, true);
        }
    }

    public void c() {
        if (this.q != null) {
            String str = null;
            if (this.q.getMaxAddressLineIndex() >= 0) {
                str = this.q.getAddressLine(0);
            }
            if (str != null) {
                this.h.setText(str);
            }
            if (this.j != null) {
                this.j.cancel();
            }
            if (this.k.getChildCount() >= 2 && (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) && ((NearbyPostActivity) this.c.getActivity("nearby_post")).n() != null) {
                this.j = new bj(this, this.q, ((NearbyPostActivity) this.c.getActivity("nearby_post")).n());
                this.j.setPriority(3);
                this.j.execute(new String[0]);
            }
        }
    }

    public Address d() {
        return this.q;
    }

    public int m() {
        return this.k.getCurrentItem();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.A = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && !this.A) {
            n();
        }
        return dispatchTouchEvent;
    }

    public void n() {
        if (!this.I) {
            this.G.onClick(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.k.getChildCount() >= 2 && (this.c.getActivity("nearby_post") instanceof NearbyPostActivity) && ((NearbyPostActivity) this.c.getActivity("nearby_post")).n() != null) {
            com.baidu.tieba.c.av n = ((NearbyPostActivity) this.c.getActivity("nearby_post")).n();
            if (n.d().size() >= 1) {
                if (TiebaApplication.d().o()) {
                    StatService.onEvent(this, "lbs_open_map", "lbsclick", 1);
                }
                com.baidu.tieba.c.aj ajVar = new com.baidu.tieba.c.aj();
                ajVar.a(n.b());
                ajVar.a(n.d());
                NearbyMapActivity.a(this, this.q, ajVar);
                MainTabActivity.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.m != null) {
            this.m.dismiss();
            this.m = null;
        }
        if (this.o != null) {
            this.o.setBackgroundDrawable(null);
            this.o = null;
        }
        if (this.n != null && !this.n.isRecycled()) {
            this.n.recycle();
            this.n = null;
        }
    }

    private void w() {
        if (this.m == null) {
            this.m = new Dialog(this, R.style.common_alert_dialog);
            this.m.setCanceledOnTouchOutside(true);
            this.m.setCancelable(true);
            View inflate = getLayoutInflater().inflate(R.layout.dialog_local_popularize, (ViewGroup) null);
            this.m.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.m.getWindow().getAttributes();
            attributes.gravity = 17;
            attributes.height = com.baidu.tieba.d.ag.a(this, 391.0f);
            this.m.getWindow().setAttributes(attributes);
            this.o = (RelativeLayout) inflate.findViewById(R.id.dialog_bg);
            ((Button) inflate.findViewById(R.id.dialog_button_ok)).setOnClickListener(new ay(this));
            ((Button) inflate.findViewById(R.id.dialog_button_cancel)).setOnClickListener(new az(this));
            ((Button) inflate.findViewById(R.id.dialog_button_close)).setOnClickListener(new ba(this));
        }
        this.n = com.baidu.tieba.d.d.a(this, (int) R.drawable.local_popularize_bg);
        if (this.o != null) {
            this.o.setBackgroundDrawable(new BitmapDrawable(this.n));
        }
        if (this.m != null) {
            this.m.show();
        }
    }
}
