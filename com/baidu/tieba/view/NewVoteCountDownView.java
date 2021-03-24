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
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class NewVoteCountDownView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22146e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22147f;

    /* renamed from: g  reason: collision with root package name */
    public View f22148g;

    /* renamed from: h  reason: collision with root package name */
    public View f22149h;
    public View i;
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
            NewVoteCountDownView.this.setContent(j3, j4 / VideoCloudSetting.HOUR_MILLISECOND, (j4 % VideoCloudSetting.HOUR_MILLISECOND) / 60000);
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
        this.f22147f = (TextView) findViewById(R.id.prefix_count_down_view);
        this.f22148g = findViewById(R.id.day_num_container);
        this.f22149h = findViewById(R.id.hour_num_container);
        this.i = findViewById(R.id.minute_num_container);
        this.j = (TextView) findViewById(R.id.day_num_count_down_view);
        this.k = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.l = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public final void d() {
        this.f22146e = getContext();
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

    public void f(int i) {
        SkinManager.setViewTextColor(this.f22147f, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i);
        SkinManager.setBackgroundResource(this.f22148g, R.drawable.bg_gradient_round, i);
        SkinManager.setBackgroundResource(this.f22149h, R.drawable.bg_gradient_round, i);
        SkinManager.setBackgroundResource(this.i, R.drawable.bg_gradient_round, i);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1, i);
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
        setContent(j3, j4 / VideoCloudSetting.HOUR_MILLISECOND, (j4 % VideoCloudSetting.HOUR_MILLISECOND) / 60000);
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
