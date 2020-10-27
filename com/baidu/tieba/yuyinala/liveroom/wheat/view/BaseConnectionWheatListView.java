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
    public CommonEmptyView boq;
    public TbPageContext nVE;
    public AlaConnectionWheatListView nXJ;
    public TextView nXN;
    public LinearLayout nXO;
    public TextView nZg;
    public RelativeLayout nZh;

    protected abstract void dvw();

    public abstract int getCount();

    protected abstract void initListener();

    public abstract void zb(boolean z);

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
        dvw();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.yuyin_layout_dialog_connnection_wheat_item, this);
        this.nXJ = (AlaConnectionWheatListView) findViewById(a.g.listView);
        this.boq = (CommonEmptyView) findViewById(a.g.empty_view);
        this.nZg = (TextView) findViewById(a.g.tv_online_user_num);
        this.nZh = (RelativeLayout) findViewById(a.g.loading_view_container);
        this.nXO = (LinearLayout) findViewById(a.g.ll_apply_btn);
        this.nXN = (TextView) findViewById(a.g.tv_apply_btn);
    }

    public String getNoDataStr() {
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void dWR() {
        if (getCount() != 0) {
            this.nXJ.setVisibility(0);
            this.boq.setVisibility(8);
            return;
        }
        this.nXJ.setVisibility(8);
        this.boq.setVisibility(0);
        this.boq.reset();
        this.boq.setTitle(getNoDataStr());
        this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.boq.setTextColor(getContext().getResources().getColor(a.d.sdk_color_525252));
    }

    public void dWS() {
        this.nZg.setVisibility(8);
        this.nXJ.setVisibility(8);
        this.boq.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.nXO.setVisibility(8);
        }
        this.boq.reset();
        this.boq.setRefreshButton(a.i.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.zb(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.boq.setTitle(a.i.yuyin_ala_connection_wheat_data_load_fail_text);
            this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.boq.setTitle(a.i.yuyin_ala_connection_wheat_net_load_fail_text);
            this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.boq.setTextColor(getContext().getResources().getColor(a.d.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.nVE = tbPageContext;
    }

    public void showLoading() {
        if (this.nZh != null) {
            this.nZh.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.nZh != null) {
            this.nZh.setVisibility(8);
        }
    }
}
