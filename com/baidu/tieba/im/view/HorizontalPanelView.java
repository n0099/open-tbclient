package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalPanelView extends LinearLayout implements View.OnClickListener {
    private Context a;
    private com.baidu.tbadk.core.util.b b;
    private List<UserData> c;
    private LinearLayout d;
    private Animation e;
    private Animation f;
    private final List<HeadImageView> g;
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

    public final boolean a() {
        return this.h;
    }

    public final void b() {
        if (this.e == null) {
            this.e = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.im.c.panel_fold_up);
            this.e.setAnimationListener(new i(this));
        }
        startAnimation(this.e);
        this.h = true;
    }

    public final void c() {
        if (this.f == null) {
            this.f = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.im.c.panel_fold_down);
        }
        this.d.setVisibility(0);
        startAnimation(this.f);
        this.h = false;
    }

    public final void a(UserData userData) {
        bn.a((ViewGroup) this.d, false, (bp) new j(this, userData));
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
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.horizontal_panel_view_item);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.default_gap_6);
                    layoutParams.gravity = 16;
                    headImageView.setOnClickListener(this);
                    this.d.addView(headImageView, layoutParams);
                    this.g.add(headImageView);
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        if (this.b == null) {
                            this.b = new com.baidu.tbadk.core.util.b(this.a);
                        }
                        this.b.c(userData.getPortrait(), new k(this));
                    } else {
                        com.baidu.adp.lib.util.f.b("HorizontalPanelView not Portrait");
                    }
                }
            }
        }
    }

    private void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.im.i.horizontal_panel_view, (ViewGroup) this, true);
        setOrientation(1);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.im.h.user_layout);
        this.b = new com.baidu.tbadk.core.util.b(this.a);
        setHorizontalScrollBarEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
        if (this.g != null) {
            this.g.clear();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.h) {
            if (view instanceof HeadImageView) {
                HeadImageView headImageView = (HeadImageView) view;
                if (!TextUtils.isEmpty(headImageView.getUserId())) {
                    com.baidu.tbadk.core.g.a(getContext(), "snap_chat_member_head_click");
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(this.a, headImageView.getUserId(), headImageView.getUserName())));
                    return;
                }
                com.baidu.adp.lib.util.f.e("no user id");
                return;
            }
            com.baidu.adp.lib.util.f.e("not image view");
        }
    }
}
