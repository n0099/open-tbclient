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
    public ImageView f21562e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21563f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21564g;

    /* renamed from: h  reason: collision with root package name */
    public int f21565h;
    public Handler i;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            GoOnAnimView.this.f21565h %= 4;
            int i = GoOnAnimView.this.f21565h;
            if (i == 0) {
                GoOnAnimView.this.f21562e.setImageResource(R.drawable.pic_startpage1_next_3);
                GoOnAnimView.this.f21563f.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21564g.setImageResource(R.drawable.pic_startpage1_next_1);
            } else if (i == 1) {
                GoOnAnimView.this.f21562e.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21563f.setImageResource(R.drawable.pic_startpage1_next_1);
                GoOnAnimView.this.f21564g.setImageResource(R.drawable.pic_startpage1_next_3);
            } else if (i == 2) {
                GoOnAnimView.this.f21562e.setImageResource(R.drawable.pic_startpage1_next_1);
                GoOnAnimView.this.f21563f.setImageResource(R.drawable.pic_startpage1_next_3);
                GoOnAnimView.this.f21564g.setImageResource(R.drawable.pic_startpage1_next_2);
            } else if (i == 3) {
                GoOnAnimView.this.f21562e.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21563f.setImageResource(R.drawable.pic_startpage1_next_2);
                GoOnAnimView.this.f21564g.setImageResource(R.drawable.pic_startpage1_next_2);
            }
            GoOnAnimView.c(GoOnAnimView.this);
            GoOnAnimView.this.i.removeMessages(0);
            GoOnAnimView.this.i.sendEmptyMessageDelayed(0, 300L);
        }
    }

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new a();
        h(context);
    }

    public static /* synthetic */ int c(GoOnAnimView goOnAnimView) {
        int i = goOnAnimView.f21565h;
        goOnAnimView.f21565h = i + 1;
        return i;
    }

    public final void h(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.go_on_anim, (ViewGroup) null, false);
        this.f21562e = (ImageView) linearLayout.findViewById(R.id.tip_go_on_1);
        this.f21563f = (ImageView) linearLayout.findViewById(R.id.tip_go_on_2);
        this.f21564g = (ImageView) linearLayout.findViewById(R.id.tip_go_on_3);
        this.f21562e.setImageResource(R.drawable.pic_startpage1_next_3);
        this.f21563f.setImageResource(R.drawable.pic_startpage1_next_2);
        this.f21564g.setImageResource(R.drawable.pic_startpage1_next_1);
        addView(linearLayout);
    }

    public void i() {
        this.i.removeMessages(0);
        ImageView imageView = this.f21562e;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.f21563f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
        ImageView imageView3 = this.f21564g;
        if (imageView3 != null) {
            imageView3.setImageDrawable(null);
        }
    }

    public void j() {
        this.i.removeMessages(0);
        this.i.sendEmptyMessage(0);
    }

    public void k() {
        this.i.removeMessages(0);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.i = new a();
        h(context);
    }
}
