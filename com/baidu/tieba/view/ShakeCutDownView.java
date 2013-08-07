package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.Timer;
/* loaded from: classes.dex */
public class ShakeCutDownView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Handler f1804a;
    private be b;
    private Animation c;
    private Timer d;
    private int e;
    private long f;
    private long g;

    public ShakeCutDownView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0L;
        this.g = 0L;
        this.f1804a = new Handler(new bc(this));
        c();
    }

    public ShakeCutDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0L;
        this.g = 0L;
        this.f1804a = new Handler(new bc(this));
        c();
    }

    public ShakeCutDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0L;
        this.g = 0L;
        this.f1804a = new Handler(new bc(this));
        c();
    }

    public void setOnTimeOutListener(be beVar) {
        this.b = beVar;
    }

    private void c() {
        this.c = AnimationUtils.loadAnimation(getContext(), R.anim.cut_down_time_anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        setText(String.valueOf(this.e));
        startAnimation(this.c);
    }

    public void a(long j) {
        this.g = System.currentTimeMillis();
        this.e = (int) (j / 1000);
        long j2 = j % 1000;
        if (j2 == 0) {
            j2 = 1000;
        } else {
            this.e++;
        }
        if (this.d != null) {
            this.d.cancel();
        }
        this.d = new Timer();
        this.d.schedule(new bd(this), j2, 1000L);
        a(this.e);
        this.f = j;
        this.f1804a.removeMessages(1);
        this.f1804a.sendEmptyMessageDelayed(1, j);
    }

    public void a() {
        this.f -= System.currentTimeMillis() - this.g;
        this.f1804a.removeMessages(1);
        this.f1804a.removeMessages(0);
        if (this.d != null) {
            this.d.cancel();
        }
        this.d = null;
    }

    public long getLeftTime() {
        return this.f;
    }

    public void b() {
        a(this.f);
    }
}
