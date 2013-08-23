package com.baidu.tieba.kn.shake;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ShakeCutDownView;
import com.baidu.tieba.view.bd;
import com.slidingmenu.lib.R;
import java.util.Random;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1287a = {0, R.drawable.vote_bear_face};
    private static final int[] b = {0, R.drawable.vote_clothes_shirt};
    private static final int[] c = {R.drawable.vote_bear_mosaic, R.drawable.vote_clothes_trousers};
    private static final int[] d = {0, R.drawable.vote_clothes_shoes};
    private static int[][] e = {f1287a, b, c, d};
    private static int f = 0;
    private com.baidu.tieba.g g;
    private TextView h;
    private ShakeCutDownView i;
    private View j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private View o;
    private ImageView[] p;
    private Button r;
    private View s;
    private Button t;
    private Animation y;
    private Random z;
    private int[] q = {R.drawable.vote_bear_face, R.drawable.vote_clothes_shirt, R.drawable.vote_clothes_trousers, R.drawable.vote_clothes_shoes};
    private AlertDialog u = null;
    private DialogInterface.OnClickListener v = null;
    private DialogInterface.OnDismissListener w = null;
    private int x = 0;

    public k(Context context) {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.y = null;
        this.z = null;
        if (context instanceof com.baidu.tieba.g) {
            this.g = (com.baidu.tieba.g) context;
            this.g.setContentView(R.layout.shake_activity);
            this.h = (TextView) this.g.findViewById(R.id.shake_time);
            this.j = this.g.findViewById(R.id.vote_bear_layout);
            this.k = (ImageView) this.g.findViewById(R.id.vote_bear_face_layer);
            this.m = (ImageView) this.g.findViewById(R.id.vote_bear_trousers_layer);
            this.l = (ImageView) this.g.findViewById(R.id.vote_bear_cloth_layer);
            this.n = (ImageView) this.g.findViewById(R.id.vote_bear_shoes_layer);
            this.o = this.g.findViewById(R.id.guide_layer);
            this.o.setOnClickListener(this.g);
            this.t = (Button) this.g.findViewById(R.id.start_shake);
            this.t.setOnClickListener(this.g);
            this.i = (ShakeCutDownView) this.g.findViewById(R.id.shake_cutdown);
            this.r = (Button) this.g.findViewById(R.id.finish_button);
            this.r.setOnClickListener(this.g);
            this.s = this.g.findViewById(R.id.shake_light);
            this.z = new Random(System.currentTimeMillis());
            this.p = new ImageView[]{this.k, this.l, this.m, this.n};
            this.y = AnimationUtils.loadAnimation(context, R.anim.shake_light);
            j();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void j() {
        int a2 = UtilHelper.a((Context) this.g);
        int b2 = UtilHelper.b((Context) this.g);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.j.getBackground();
        if (bitmapDrawable != null) {
            int height = ((b2 * 7) / 10) - bitmapDrawable.getBitmap().getHeight();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = ((a2 - bitmapDrawable.getBitmap().getWidth()) * 3) / 5;
            layoutParams.topMargin = height;
            this.j.setLayoutParams(layoutParams);
        }
    }

    public void a(long j) {
        this.o.setVisibility(8);
        this.i.a(j);
        this.s.startAnimation(this.y);
    }

    public void a(bd bdVar) {
        this.i.setOnTimeOutListener(bdVar);
    }

    public void a() {
        if (f == 0) {
            this.x++;
            this.k.setBackgroundResource(f1287a[this.x % f1287a.length]);
            if (this.x == 10) {
                this.l.setBackgroundResource(0);
            }
            if (this.x == 20) {
                this.m.setBackgroundResource(R.drawable.vote_bear_mosaic);
            }
            if (this.x == 30) {
                this.n.setBackgroundResource(0);
            }
        } else if (f == 1) {
            int nextInt = this.z.nextInt(100000);
            int i = nextInt / 4;
            int i2 = nextInt % 4;
            int[] iArr = e[i2];
            ImageView imageView = this.p[i2];
            int length = iArr.length % iArr.length;
            if (length == this.q[i2]) {
                length = (i + 1) % iArr.length;
            }
            this.q[i2] = length;
            imageView.setBackgroundResource(iArr[length]);
        }
    }

    public View b() {
        return this.r;
    }

    public View c() {
        return this.o;
    }

    public View d() {
        return this.t;
    }

    public void e() {
        this.i.a();
        this.s.setAnimation(null);
    }

    public void f() {
        i();
        this.s.setAnimation(null);
    }

    public void g() {
        this.i.b();
        this.s.startAnimation(this.y);
    }

    public long h() {
        return this.i.getLeftTime();
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.w = onDismissListener;
    }

    public void i() {
        if (this.u != null) {
            this.u.dismiss();
        }
    }
}
