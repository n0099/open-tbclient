package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class NewVoteCountDownView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21856e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21857f;

    /* renamed from: g  reason: collision with root package name */
    public View f21858g;

    /* renamed from: h  reason: collision with root package name */
    public View f21859h;

    /* renamed from: i  reason: collision with root package name */
    public View f21860i;
    public TextView j;
    public TextView k;
    public TextView l;
    public CountDownTimer m;
    public b n;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            NewVoteCountDownView.this.setContent(0L, 0L, 0L);
            NewVoteCountDownView.this.b();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            long j2 = j + 60000;
            long j3 = j2 / 86400000;
            long j4 = j2 % 86400000;
            NewVoteCountDownView.this.setContent(j3, j4 / 3600000, (j4 % 3600000) / 60000);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public NewVoteCountDownView(Context context) {
        this(context, null);
    }

    public final void b() {
        b bVar = this.n;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void c() {
        this.f21857f = (TextView) findViewById(R.id.prefix_count_down_view);
        this.f21858g = findViewById(R.id.day_num_container);
        this.f21859h = findViewById(R.id.hour_num_container);
        this.f21860i = findViewById(R.id.minute_num_container);
        this.j = (TextView) findViewById(R.id.day_num_count_down_view);
        this.k = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.l = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public final void d() {
        this.f21856e = getContext();
        setOrientation(0);
        setClipToPadding(false);
        setClipChildren(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        layoutParams.gravity = 1;
        setLayoutParams(layoutParams);
        LayoutInflater.from(getContext()).inflate(R.layout.new_vote_count_down_view, (ViewGroup) this, true);
        c();
    }

    public void e() {
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.m = null;
        }
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f21857f, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i2);
        SkinManager.setBackgroundResource(this.f21858g, R.drawable.bg_gradient_round, i2);
        SkinManager.setBackgroundResource(this.f21859h, R.drawable.bg_gradient_round, i2);
        SkinManager.setBackgroundResource(this.f21860i, R.drawable.bg_gradient_round, i2);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1, i2);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i2);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1, i2);
    }

    public final void g(long j) {
        if (this.m == null) {
            a aVar = new a(j, 1000L);
            this.m = aVar;
            aVar.start();
        }
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.j.setText(String.format(string, Long.valueOf(j)));
        this.k.setText(String.format(string, Long.valueOf(j2)));
        this.l.setText(String.format(string, Long.valueOf(j3)));
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / 3600000, (j4 % 3600000) / 60000);
        g(j);
    }

    public void setOnCountDownFinished(b bVar) {
        this.n = bVar;
    }

    public NewVoteCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }
}
