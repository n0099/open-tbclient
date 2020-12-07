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
    public TbPageContext oty;
    public AlaConnectionWheatListView ovE;
    public TextView ovI;
    public LinearLayout ovJ;
    public int ovL;
    public TextView oxZ;
    public RelativeLayout oya;

    protected abstract void dCP();

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
        dCP();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connnection_wheat_item, this);
        this.ovE = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.btg = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oxZ = (TextView) findViewById(a.f.tv_online_user_num);
        this.oya = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.ovJ = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ovI = (TextView) findViewById(a.f.tv_apply_btn);
    }

    public String getNoDataStr() {
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void efu() {
        if (getCount() != 0) {
            this.ovE.setVisibility(0);
            this.btg.setVisibility(8);
            return;
        }
        this.ovE.setVisibility(8);
        this.btg.setVisibility(0);
        this.btg.reset();
        this.btg.setTitle(getNoDataStr());
        this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efv() {
        this.oxZ.setVisibility(8);
        this.ovE.setVisibility(8);
        this.btg.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.ovJ.setVisibility(8);
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
        this.oty = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.ovL = i;
    }

    public void showLoading() {
        if (this.oya != null) {
            this.oya.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oya != null) {
            this.oya.setVisibility(8);
        }
    }
}
