package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.VideoCloudSetting;
/* loaded from: classes5.dex */
public class VoteCountDownView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22574e;

    /* renamed from: f  reason: collision with root package name */
    public View f22575f;

    /* renamed from: g  reason: collision with root package name */
    public View f22576g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22577h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f22578i;
    public CountDownTimer j;
    public b k;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            VoteCountDownView.this.setContent(0L, 0L);
            VoteCountDownView.this.b();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            long j2 = j + 60000;
            VoteCountDownView.this.setContent(j2 / VideoCloudSetting.HOUR_MILLISECOND, (j2 % VideoCloudSetting.HOUR_MILLISECOND) / 60000);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public VoteCountDownView(Context context) {
        this(context, null);
    }

    public final void b() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void c() {
        this.f22575f = findViewById(R.id.hour_num_container);
        this.f22576g = findViewById(R.id.minute_num_container);
        this.f22577h = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.f22578i = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public final void d() {
        this.f22574e = getContext();
        setOrientation(0);
        setClipToPadding(false);
        setClipChildren(false);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_count_down_view, (ViewGroup) this, true);
        c();
    }

    public void e(int i2) {
        SkinManager.setBackgroundResource(this.f22575f, R.drawable.bg_gradient_round, i2);
        SkinManager.setBackgroundResource(this.f22576g, R.drawable.bg_gradient_round, i2);
        SkinManager.setViewTextColor(this.f22577h, R.color.CAM_X0101, 1, i2);
        SkinManager.setViewTextColor(this.f22577h, R.color.CAM_X0101, 1, i2);
    }

    public final void f(long j) {
        if (this.j == null) {
            a aVar = new a(j, 1000L);
            this.j = aVar;
            aVar.start();
        }
    }

    public void setContent(long j, long j2) {
        this.f22578i.setText(String.valueOf(j2));
        this.f22577h.setText(String.valueOf(j));
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / VideoCloudSetting.HOUR_MILLISECOND, (j2 % VideoCloudSetting.HOUR_MILLISECOND) / 60000);
        f(j);
    }

    public void setOnCountDownFinished(b bVar) {
        this.k = bVar;
    }

    public VoteCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }
}
