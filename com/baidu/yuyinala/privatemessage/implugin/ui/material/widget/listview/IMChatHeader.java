package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.sdk.a;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes10.dex */
public class IMChatHeader extends LinearLayout {
    private long dxF;
    private TextView dzu;
    private AnimationDrawable mAnimationDrawable;
    private LinearLayout mContainer;
    public Context mContext;
    private int mState;
    private ImageView phx;
    private LinearLayout phy;
    private TextView phz;

    public IMChatHeader(Context context) {
        super(context);
        this.mState = 0;
        this.dxF = -1L;
        this.mContext = context;
        initView(context);
    }

    public IMChatHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.dxF = -1L;
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.mContainer = (LinearLayout) LayoutInflater.from(context).inflate(a.g.bd_im_listview_header, (ViewGroup) null);
        addView(this.mContainer, layoutParams);
        this.dzu = (TextView) findViewById(a.f.bd_im_listview_header_hint_textview);
        this.phx = (ImageView) findViewById(a.f.bd_im_listview_header_progressbar);
        this.phy = (LinearLayout) findViewById(a.f.bd_im_listview_header_content);
        this.phz = (TextView) findViewById(a.f.bd_im_listview_header_time);
        this.mAnimationDrawable = (AnimationDrawable) this.phx.getDrawable();
        this.mAnimationDrawable.start();
    }

    public void setState(int i) {
        if (i != this.mState) {
            switch (i) {
                case 0:
                    this.dzu.setText(a.h.bd_im_listview_header_hint_loading);
                    break;
                case 1:
                    this.dzu.setText(a.h.bd_im_listview_header_hint_loading);
                    break;
                case 2:
                    this.dzu.setText(a.h.bd_im_listview_header_hint_loading);
                    break;
            }
            this.mState = i;
        }
    }

    public void setVisiableHeight(int i) {
        int i2;
        if (i <= 0) {
            i2 = 0;
        } else {
            i2 = -2;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i2;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public int getVisiableHeight() {
        return this.mContainer.getHeight();
    }

    public void setVisiableContent(int i) {
        this.phy.setVisibility(i);
        if (i != 0 && this.mAnimationDrawable != null) {
            this.mAnimationDrawable.stop();
        }
    }

    public void setRefreshTime() {
        elN();
    }

    public long getRefreshTime() {
        return this.dxF;
    }

    private void elN() {
        String format;
        long currentTimeMillis = System.currentTimeMillis() - this.dxF;
        if (this.dxF == -1) {
            format = getResources().getString(a.h.bd_im_listview_not_updated_yet);
        } else if (currentTimeMillis < 0) {
            format = getResources().getString(a.h.bd_im_listview_time_error);
        } else if (currentTimeMillis < AppStatusRules.DEFAULT_GRANULARITY) {
            format = getResources().getString(a.h.bd_im_listview_updated_just_now);
        } else if (currentTimeMillis < BdKVCache.MILLS_1Hour) {
            format = String.format(getResources().getString(a.h.bd_im_listview_updated_at), (currentTimeMillis / AppStatusRules.DEFAULT_GRANULARITY) + getResources().getString(a.h.bd_im_listview_minute));
        } else if (currentTimeMillis < 86400000) {
            format = String.format(getResources().getString(a.h.bd_im_listview_updated_at), (currentTimeMillis / BdKVCache.MILLS_1Hour) + getResources().getString(a.h.bd_im_listview_hour));
        } else if (currentTimeMillis < BdKVCache.MILLS_30Days) {
            format = String.format(getResources().getString(a.h.bd_im_listview_updated_at), (currentTimeMillis / 86400000) + getResources().getString(a.h.bd_im_listview_day));
        } else if (currentTimeMillis < 31104000000L) {
            format = String.format(getResources().getString(a.h.bd_im_listview_updated_at), (currentTimeMillis / BdKVCache.MILLS_30Days) + getResources().getString(a.h.bd_im_listview_month));
        } else {
            format = String.format(getResources().getString(a.h.bd_im_listview_updated_at), (currentTimeMillis / 31104000000L) + getResources().getString(a.h.bd_im_listview_year));
        }
        this.phz.setText(format);
    }
}
