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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalPanelView extends LinearLayout implements View.OnClickListener {
    private Context a;
    private List<UserData> b;
    private LinearLayout c;
    private Animation d;
    private Animation e;
    private final List<HeadImageView> f;
    private boolean g;

    public HorizontalPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new ArrayList();
        this.g = false;
        a(context);
    }

    public HorizontalPanelView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new ArrayList();
        this.g = false;
        a(context);
    }

    public boolean a() {
        return this.g;
    }

    public void b() {
        if (this.d == null) {
            this.d = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.panel_fold_up);
            this.d.setAnimationListener(new i(this));
        }
        startAnimation(this.d);
        this.g = true;
    }

    public void c() {
        if (this.e == null) {
            this.e = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.panel_fold_down);
        }
        this.c.setVisibility(0);
        startAnimation(this.e);
        this.g = false;
    }

    public void a(UserData userData) {
        bo.a((ViewGroup) this.c, false, (bq) new j(this, userData));
    }

    public void setData(List<UserData> list) {
        if (this.b != list) {
            this.b = list;
            if (this.b != null) {
                this.c.removeAllViews();
                this.f.clear();
                for (UserData userData : this.b) {
                    HeadImageView headImageView = new HeadImageView(this.a);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(userData.getUserId()));
                    headImageView.setUserId(String.valueOf(userData.getUserId()));
                    headImageView.setUserName(userData.getUserName());
                    headImageView.setUrl(userData.getPortrait());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.horizontal_panel_view_item);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.default_gap_6);
                    layoutParams.gravity = 16;
                    headImageView.setOnClickListener(this);
                    this.c.addView(headImageView, layoutParams);
                    headImageView.a(userData.getPortrait(), 12, false);
                    this.f.add(headImageView);
                }
            }
        }
    }

    public void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.horizontal_panel_view, (ViewGroup) this, true);
        setOrientation(1);
        this.c = (LinearLayout) findViewById(com.baidu.tieba.u.user_layout);
        setHorizontalScrollBarEnabled(false);
    }

    public void d() {
        if (this.f != null) {
            this.f.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.g && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (!TextUtils.isEmpty(headImageView.getUserId())) {
                com.baidu.tbadk.core.f.a(getContext(), "snap_chat_member_head_click");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bg(this.a, headImageView.getUserId(), headImageView.getUserName())));
            }
        }
    }
}
