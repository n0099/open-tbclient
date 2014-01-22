package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.person.PersonInfoActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalPanelView extends LinearLayout implements View.OnClickListener {
    private Context a;
    private com.baidu.tieba.util.i b;
    private List<UserData> c;
    private LinearLayout d;
    private Animation e;
    private Animation f;
    private List<HeadImageView> g;
    private boolean h;

    public HorizontalPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.h = false;
        a(context);
    }

    public HorizontalPanelView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.h = false;
        a(context);
    }

    public boolean a() {
        return this.h;
    }

    public void b() {
        if (this.e == null) {
            this.e = AnimationUtils.loadAnimation(this.a, R.anim.panel_fold_up);
            this.e.setAnimationListener(new ay(this));
        }
        startAnimation(this.e);
        this.h = true;
    }

    public void c() {
        if (this.f == null) {
            this.f = AnimationUtils.loadAnimation(this.a, R.anim.panel_fold_down);
        }
        this.d.setVisibility(0);
        startAnimation(this.f);
        this.h = false;
    }

    public void a(UserData userData) {
        com.baidu.tieba.util.ce.a((ViewGroup) this.d, false, (com.baidu.tieba.util.cg) new az(this, userData));
    }

    public void setData(List<UserData> list) {
        if (this.c != list) {
            this.c = list;
            if (this.c != null) {
                this.d.removeAllViews();
                this.g.clear();
                for (UserData userData : this.c) {
                    HeadImageView headImageView = new HeadImageView(this.a);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(userData.getUserId()));
                    headImageView.setUserId(String.valueOf(userData.getUserId()));
                    headImageView.setUserName(userData.getUserName());
                    headImageView.setUrl(userData.getPortrait());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.horizontal_panel_view_item);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.default_gap_6);
                    layoutParams.gravity = 16;
                    headImageView.setOnClickListener(this);
                    this.d.addView(headImageView, layoutParams);
                    this.g.add(headImageView);
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        if (this.b == null) {
                            this.b = new com.baidu.tieba.util.i(this.a);
                        }
                        this.b.c(userData.getPortrait(), new ba(this));
                    } else {
                        com.baidu.adp.lib.g.e.a("HorizontalPanelView not Portrait");
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.horizontal_panel_view, (ViewGroup) this, true);
        setOrientation(1);
        this.d = (LinearLayout) findViewById(R.id.user_layout);
        this.b = new com.baidu.tieba.util.i(this.a);
        setHorizontalScrollBarEnabled(false);
    }

    public void d() {
        if (this.b != null) {
            this.b.d();
            this.b = null;
        }
        if (this.g != null) {
            this.g.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.h) {
            if (view instanceof HeadImageView) {
                HeadImageView headImageView = (HeadImageView) view;
                if (!TextUtils.isEmpty(headImageView.getUserId())) {
                    com.baidu.tieba.as.a(getContext(), "snap_chat_member_head_click");
                    PersonInfoActivity.a(this.a, headImageView.getUserId(), headImageView.getUserName());
                    return;
                }
                com.baidu.adp.lib.g.e.d("no user id");
                return;
            }
            com.baidu.adp.lib.g.e.d("not image view");
        }
    }
}
