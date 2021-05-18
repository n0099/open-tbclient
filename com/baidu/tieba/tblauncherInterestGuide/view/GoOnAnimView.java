package com.baidu.tieba.tblauncherInterestGuide.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class GoOnAnimView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21101e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21102f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21103g;

    /* renamed from: h  reason: collision with root package name */
    public int f21104h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f21105i;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            GoOnAnimView.this.f21104h %= 4;
            int i2 = GoOnAnimView.this.f21104h;
            if (i2 == 0) {
                GoOnAnimView.this.f21101e.setImageResource(R.drawable.pic_startpage1_next_3);
                GoOnAnimView.this.f21102f.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21103g.setImageResource(R.drawable.pic_startpage1_next_1);
            } else if (i2 == 1) {
                GoOnAnimView.this.f21101e.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21102f.setImageResource(R.drawable.pic_startpage1_next_1);
                GoOnAnimView.this.f21103g.setImageResource(R.drawable.pic_startpage1_next_3);
            } else if (i2 == 2) {
                GoOnAnimView.this.f21101e.setImageResource(R.drawable.pic_startpage1_next_1);
                GoOnAnimView.this.f21102f.setImageResource(R.drawable.pic_startpage1_next_3);
                GoOnAnimView.this.f21103g.setImageResource(R.drawable.pic_startpage1_next_2);
            } else if (i2 == 3) {
                GoOnAnimView.this.f21101e.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21102f.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21103g.setImageResource(R.drawable.pic_startpage1_next_2);
            }
            GoOnAnimView.c(GoOnAnimView.this);
            GoOnAnimView.this.f21105i.removeMessages(0);
            GoOnAnimView.this.f21105i.sendEmptyMessageDelayed(0, 300L);
        }
    }

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21105i = new a();
        h(context);
    }

    public static /* synthetic */ int c(GoOnAnimView goOnAnimView) {
        int i2 = goOnAnimView.f21104h;
        goOnAnimView.f21104h = i2 + 1;
        return i2;
    }

    public final void h(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.go_on_anim, (ViewGroup) null, false);
        this.f21101e = (ImageView) linearLayout.findViewById(R.id.tip_go_on_1);
        this.f21102f = (ImageView) linearLayout.findViewById(R.id.tip_go_on_2);
        this.f21103g = (ImageView) linearLayout.findViewById(R.id.tip_go_on_3);
        this.f21101e.setImageResource(R.drawable.pic_startpage1_next_3);
        this.f21102f.setImageResource(R.drawable.pic_startpage1_next_2);
        this.f21103g.setImageResource(R.drawable.pic_startpage1_next_1);
        addView(linearLayout);
    }

    public void i() {
        this.f21105i.removeMessages(0);
        ImageView imageView = this.f21101e;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.f21102f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
        ImageView imageView3 = this.f21103g;
        if (imageView3 != null) {
            imageView3.setImageDrawable(null);
        }
    }

    public void j() {
        this.f21105i.removeMessages(0);
        this.f21105i.sendEmptyMessage(0);
    }

    public void k() {
        this.f21105i.removeMessages(0);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.f21105i = new a();
        h(context);
    }
}
