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
    public CommonEmptyView bpJ;
    public TbPageContext ocV;
    public AlaConnectionWheatListView ofa;
    public TextView ofe;
    public LinearLayout ofg;
    public int ofi;
    public TextView ohv;
    public RelativeLayout ohw;

    protected abstract void dxY();

    public abstract int getCount();

    protected abstract void initListener();

    public abstract void zj(boolean z);

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
        dxY();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connnection_wheat_item, this);
        this.ofa = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.bpJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.ohv = (TextView) findViewById(a.f.tv_online_user_num);
        this.ohw = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.ofg = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ofe = (TextView) findViewById(a.f.tv_apply_btn);
    }

    public String getNoDataStr() {
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void dZQ() {
        if (getCount() != 0) {
            this.ofa.setVisibility(0);
            this.bpJ.setVisibility(8);
            return;
        }
        this.ofa.setVisibility(8);
        this.bpJ.setVisibility(0);
        this.bpJ.reset();
        this.bpJ.setTitle(getNoDataStr());
        this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bpJ.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void dZR() {
        this.ohv.setVisibility(8);
        this.ofa.setVisibility(8);
        this.bpJ.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.ofg.setVisibility(8);
        }
        this.bpJ.reset();
        this.bpJ.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.zj(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bpJ.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bpJ.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bpJ.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.ocV = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.ofi = i;
    }

    public void showLoading() {
        if (this.ohw != null) {
            this.ohw.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.ohw != null) {
            this.ohw.setVisibility(8);
        }
    }
}
