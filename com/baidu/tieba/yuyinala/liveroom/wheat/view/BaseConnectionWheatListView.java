package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.SafeFrameLayout;
/* loaded from: classes4.dex */
public abstract class BaseConnectionWheatListView extends SafeFrameLayout implements View.OnClickListener {
    public CommonEmptyView btg;
    public TbPageContext otA;
    public AlaConnectionWheatListView ovG;
    public TextView ovK;
    public LinearLayout ovL;
    public int ovN;
    public TextView oyb;
    public RelativeLayout oyc;

    protected abstract void dCQ();

    public abstract int getCount();

    protected abstract void initListener();

    public abstract void zU(boolean z);

    public BaseConnectionWheatListView(@NonNull Context context) {
        this(context, null);
    }

    public BaseConnectionWheatListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseConnectionWheatListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
        initListener();
        dCQ();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connnection_wheat_item, this);
        this.ovG = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.btg = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oyb = (TextView) findViewById(a.f.tv_online_user_num);
        this.oyc = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.ovL = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ovK = (TextView) findViewById(a.f.tv_apply_btn);
    }

    public String getNoDataStr() {
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void efv() {
        if (getCount() != 0) {
            this.ovG.setVisibility(0);
            this.btg.setVisibility(8);
            return;
        }
        this.ovG.setVisibility(8);
        this.btg.setVisibility(0);
        this.btg.reset();
        this.btg.setTitle(getNoDataStr());
        this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efw() {
        this.oyb.setVisibility(8);
        this.ovG.setVisibility(8);
        this.btg.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.ovL.setVisibility(8);
        }
        this.btg.reset();
        this.btg.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.zU(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.btg.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.btg.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.btg.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.otA = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.ovN = i;
    }

    public void showLoading() {
        if (this.oyc != null) {
            this.oyc.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oyc != null) {
            this.oyc.setVisibility(8);
        }
    }
}
