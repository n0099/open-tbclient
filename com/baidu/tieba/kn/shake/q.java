package com.baidu.tieba.kn.shake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.view.ImageViewDrawer;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.d {
    public ScrollView b;
    private VoteResultActivity c;
    private ImageView d;
    private ImageViewDrawer e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ProgressBar n;
    private ViewGroup o;
    private LinearLayout p;
    private LinearLayout q;

    public q(Context context) {
        super(context);
        if (context instanceof VoteResultActivity) {
            this.c = (VoteResultActivity) context;
            this.o = (ViewGroup) LayoutInflater.from(this.c).inflate(R.layout.kn_voteresult_activity, (ViewGroup) null);
            this.c.addContentView(this.o, new FrameLayout.LayoutParams(-1, -1));
            this.d = (ImageView) this.o.findViewById(R.id.back);
            this.e = (ImageViewDrawer) this.o.findViewById(R.id.result_image);
            this.f = (TextView) this.o.findViewById(R.id.title);
            this.g = (TextView) this.o.findViewById(R.id.result_tip_shake_num);
            this.h = (TextView) this.o.findViewById(R.id.result_tip_name);
            this.i = (TextView) this.o.findViewById(R.id.result_tip_vote_num);
            this.j = (ImageView) this.o.findViewById(R.id.share_weixin);
            this.k = (ImageView) this.o.findViewById(R.id.share_qqfriend);
            this.l = (ImageView) this.o.findViewById(R.id.share_qqzone);
            this.m = (ImageView) this.o.findViewById(R.id.share_sina);
            this.n = (ProgressBar) this.o.findViewById(R.id.progress);
            this.p = (LinearLayout) this.o.findViewById(R.id.result_vote_loading);
            this.q = (LinearLayout) this.o.findViewById(R.id.result_vote_show);
            this.b = (ScrollView) this.o.findViewById(R.id.bodyContainer);
            this.d.setOnClickListener(this.c);
            this.j.setOnClickListener(this.c);
            this.k.setOnClickListener(this.c);
            this.l.setOnClickListener(this.c);
            this.m.setOnClickListener(this.c);
            this.j.setEnabled(false);
            this.k.setEnabled(false);
            this.l.setEnabled(false);
            this.m.setEnabled(false);
            ah.a(this.d, 0);
            ah.d((ViewGroup) this.o.findViewById(R.id.top), 0);
            ah.f(this.f, 0);
        }
    }

    public void b() {
        this.n.setVisibility(0);
    }

    public void c() {
        this.n.setVisibility(8);
    }

    public void d() {
        this.p.setVisibility(8);
        this.q.setVisibility(0);
    }

    public void e() {
        this.p.setVisibility(0);
        this.q.setVisibility(8);
    }

    public void f() {
        this.j.setEnabled(true);
        this.k.setEnabled(true);
        this.l.setEnabled(true);
        this.m.setEnabled(true);
    }

    public void g() {
        this.j.setEnabled(false);
        this.k.setEnabled(false);
        this.l.setEnabled(false);
        this.m.setEnabled(false);
    }

    public ImageViewDrawer h() {
        return this.e;
    }

    public TextView i() {
        return this.g;
    }

    public TextView j() {
        return this.h;
    }

    public TextView k() {
        return this.i;
    }
}
