package com.baidu.tieba.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.NoNetworkMoreActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<NoNetworkView> f2492a = new ArrayList<>();
    private static boolean f;
    private TextView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private Context g;
    private boolean h;
    private ArrayList<az> i;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new ArrayList<>();
        a(context);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ArrayList<>();
        a(context);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.i = new ArrayList<>();
        a(context);
    }

    public void a(Context context) {
        this.g = context;
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.no_network_view, (ViewGroup) null));
        this.c = (ImageView) findViewById(R.id.no_network_icon);
        this.d = (TextView) findViewById(R.id.no_network_guide1);
        this.e = (TextView) findViewById(R.id.no_network_guide2);
        this.b = (TextView) findViewById(R.id.no_network_showmore);
        this.b.setOnClickListener(this);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setVisibility(8);
            this.h = false;
            setIsHasNetwork(true);
            return;
        }
        setVisibility(0);
        this.h = true;
        setIsHasNetwork(false);
    }

    public void a(az azVar) {
        if (azVar != null && !this.i.contains(azVar)) {
            this.i.add(azVar);
        }
    }

    public void b(az azVar) {
        if (azVar != null && this.i.contains(azVar)) {
            this.i.remove(azVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        if (z != f) {
            f = z;
            if (f) {
                Iterator<NoNetworkView> it = f2492a.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(false);
                }
                return;
            }
            Iterator<NoNetworkView> it2 = f2492a.iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }
    }

    public void setVisible(boolean z) {
        if (z != this.h) {
            this.h = z;
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new ax(this));
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.i.size(); i++) {
                    this.i.get(i).a(false);
                }
            } else if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new ay(this));
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    this.i.get(i2).a(true);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b) {
            Intent intent = new Intent(this.g, NoNetworkMoreActivity.class);
            intent.addFlags(268435456);
            this.g.startActivity(intent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f2492a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f2492a.remove(this);
        this.i.clear();
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setImageResource(R.drawable.icon_error_1);
            findViewById(R.id.no_network_parent).setBackgroundResource(R.drawable.bg_no_network_1);
            this.b.setBackgroundResource(R.drawable.network_more_1);
            this.d.setTextColor(-10523526);
            this.e.setTextColor(-8682095);
            this.b.setTextColor(-10523526);
            return;
        }
        this.c.setImageResource(R.drawable.icon_error);
        findViewById(R.id.no_network_parent).setBackgroundResource(R.drawable.bg_no_network);
        this.b.setBackgroundResource(R.drawable.network_more);
        this.d.setTextColor(-14277082);
        this.e.setTextColor(-5065030);
        this.b.setTextColor(-14277082);
    }
}
