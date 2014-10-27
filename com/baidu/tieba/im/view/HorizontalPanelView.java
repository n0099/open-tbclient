package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalPanelView extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private List<UserData> mData;
    private Animation mHideAnimation;
    private final List<HeadImageView> mImageList;
    private boolean mIsHidden;
    private Animation mShowAnimation;
    private LinearLayout mUserLayout;

    public HorizontalPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mData = null;
        this.mUserLayout = null;
        this.mHideAnimation = null;
        this.mShowAnimation = null;
        this.mImageList = new ArrayList();
        this.mIsHidden = false;
        init(context);
    }

    public HorizontalPanelView(Context context) {
        super(context);
        this.mData = null;
        this.mUserLayout = null;
        this.mHideAnimation = null;
        this.mShowAnimation = null;
        this.mImageList = new ArrayList();
        this.mIsHidden = false;
        init(context);
    }

    public boolean isHidden() {
        return this.mIsHidden;
    }

    public void hide() {
        if (this.mHideAnimation == null) {
            this.mHideAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.panel_fold_up);
            this.mHideAnimation.setAnimationListener(new f(this));
        }
        startAnimation(this.mHideAnimation);
        this.mIsHidden = true;
    }

    public void show() {
        if (this.mShowAnimation == null) {
            this.mShowAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.panel_fold_down);
        }
        this.mUserLayout.setVisibility(0);
        startAnimation(this.mShowAnimation);
        this.mIsHidden = false;
    }

    public void removeUser(UserData userData) {
        bn.a(this.mUserLayout, false, new g(this, userData));
    }

    public void setData(List<UserData> list) {
        if (this.mData != list) {
            this.mData = list;
            if (this.mData != null) {
                this.mUserLayout.removeAllViews();
                this.mImageList.clear();
                for (UserData userData : this.mData) {
                    HeadImageView headImageView = new HeadImageView(this.mContext);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(userData.getUserId()));
                    headImageView.setUserId(String.valueOf(userData.getUserId()));
                    headImageView.setUserName(userData.getUserName());
                    headImageView.setUrl(userData.getPortrait());
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(t.horizontal_panel_view_item);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(t.default_gap_6);
                    layoutParams.gravity = 16;
                    headImageView.setOnClickListener(this);
                    this.mUserLayout.addView(headImageView, layoutParams);
                    headImageView.c(userData.getPortrait(), 12, false);
                    this.mImageList.add(headImageView);
                }
            }
        }
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.horizontal_panel_view, this, true);
        setOrientation(1);
        this.mUserLayout = (LinearLayout) findViewById(v.user_layout);
        setHorizontalScrollBarEnabled(false);
    }

    public void onDestroy() {
        if (this.mImageList != null) {
            this.mImageList.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.mIsHidden && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (!TextUtils.isEmpty(headImageView.getUserId())) {
                com.baidu.tbadk.core.i.l(getContext(), "snap_chat_member_head_click");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext, headImageView.getUserId(), headImageView.getUserName())));
            }
        }
    }
}
