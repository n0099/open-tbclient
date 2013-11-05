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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    public ScrollView f1822a;
    private VoteResultActivity c;
    private ImageView d;
    private TbImageView e;
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
            this.e = (TbImageView) this.o.findViewById(R.id.result_image);
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
            this.f1822a = (ScrollView) this.o.findViewById(R.id.bodyContainer);
            this.d.setOnClickListener(this.c);
            this.j.setOnClickListener(this.c);
            this.k.setOnClickListener(this.c);
            this.l.setOnClickListener(this.c);
            this.m.setOnClickListener(this.c);
            this.j.setEnabled(false);
            this.k.setEnabled(false);
            this.l.setEnabled(false);
            this.m.setEnabled(false);
            bb.a(this.d, 0);
            bb.d((ViewGroup) this.o.findViewById(R.id.top), 0);
            bb.f(this.f, 0);
        }
    }

    public void a() {
        this.n.setVisibility(0);
    }

    public void e() {
        this.n.setVisibility(8);
    }

    public void f() {
        this.p.setVisibility(8);
        this.q.setVisibility(0);
    }

    public void g() {
        this.p.setVisibility(0);
        this.q.setVisibility(8);
    }

    public void h() {
        this.j.setEnabled(true);
        this.k.setEnabled(true);
        this.l.setEnabled(true);
        this.m.setEnabled(true);
    }

    public void i() {
        this.j.setEnabled(false);
        this.k.setEnabled(false);
        this.l.setEnabled(false);
        this.m.setEnabled(false);
    }

    public TbImageView j() {
        return this.e;
    }

    public TextView k() {
        return this.g;
    }

    public TextView l() {
        return this.h;
    }

    public TextView m() {
        return this.i;
    }
}
