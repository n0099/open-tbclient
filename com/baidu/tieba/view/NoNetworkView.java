package com.baidu.tieba.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.NoNetworkMoreActivity;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NoNetworkView extends RelativeLayout implements View.OnClickListener {
    private static ArrayList<NoNetworkView> a = new ArrayList<>();
    private static boolean f;
    private TextView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private Context g;
    private boolean h;
    private int i;
    private ArrayList<bf> j;

    public NoNetworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 0;
        this.j = new ArrayList<>();
        a(context, attributeSet);
    }

    public NoNetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        this.j = new ArrayList<>();
        a(context, attributeSet);
    }

    public NoNetworkView(Context context) {
        super(context);
        this.i = 0;
        this.j = new ArrayList<>();
        a(context, null);
    }

    public void a(Context context, AttributeSet attributeSet) {
        this.g = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.no_network_view, this);
        this.c = (ImageView) findViewById(R.id.no_network_icon);
        this.d = (TextView) findViewById(R.id.no_network_guide1);
        this.e = (TextView) findViewById(R.id.no_network_guide2);
        this.b = (TextView) findViewById(R.id.no_network_showmore);
        this.b.setOnClickListener(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.au.noNetworkView);
            this.h = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                setVisible(false);
                setIsHasNetwork(true);
                return;
            }
            setVisible(true);
            setIsHasNetwork(false);
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(NoNetworkView.class.getName(), "init", e.getMessage());
        }
    }

    public void a(bf bfVar) {
        if (bfVar != null && !this.j.contains(bfVar)) {
            this.j.add(bfVar);
        }
    }

    public void b(bf bfVar) {
        if (bfVar != null && this.j.contains(bfVar)) {
            this.j.remove(bfVar);
        }
    }

    public static void setIsHasNetwork(boolean z) {
        f = z;
        if (f) {
            Iterator<NoNetworkView> it = a.iterator();
            while (it.hasNext()) {
                it.next().setVisible(false);
            }
            return;
        }
        Iterator<NoNetworkView> it2 = a.iterator();
        while (it2.hasNext()) {
            it2.next().setVisible(true);
        }
    }

    public void setVisible(boolean z) {
        if (z) {
            if (1 != this.i) {
                this.i = 1;
                this.d.setText(R.string.no_network_guide1);
                this.e.setText(R.string.no_network_guide2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation);
                for (int i = 0; i < this.j.size(); i++) {
                    this.j.get(i).a(false);
                }
            }
        } else if (this.h && com.baidu.tieba.im.b.a.b().a()) {
            if (2 != this.i) {
                this.i = 2;
                this.d.setText(R.string.offline_guide1);
                this.e.setText(R.string.offline_guide2);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setDuration(500L);
                setVisibility(0);
                startAnimation(alphaAnimation2);
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    this.j.get(i2).a(false);
                }
            }
        } else if (this.i != 0) {
            this.i = 0;
            if (getVisibility() != 8) {
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation3.setFillAfter(true);
                alphaAnimation3.setDuration(500L);
                alphaAnimation3.setAnimationListener(new be(this));
                startAnimation(alphaAnimation3);
                for (int i3 = 0; i3 < this.j.size(); i3++) {
                    this.j.get(i3).a(true);
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
        a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.remove(this);
        this.j.clear();
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setImageResource(R.drawable.icon_error_1);
            setBackgroundResource(R.drawable.bg_no_network_1);
            this.b.setBackgroundResource(R.drawable.network_more_1);
            this.d.setTextColor(-10523526);
            this.e.setTextColor(-8682095);
            this.b.setTextColor(-10523526);
            return;
        }
        this.c.setImageResource(R.drawable.icon_error);
        setBackgroundResource(R.drawable.bg_no_network);
        this.b.setBackgroundResource(R.drawable.network_more);
        this.d.setTextColor(-14277082);
        this.e.setTextColor(-5065030);
        this.b.setTextColor(-14277082);
    }

    public static void a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) TiebaApplication.g().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            setIsHasNetwork(true);
        } else {
            setIsHasNetwork(false);
        }
    }
}
