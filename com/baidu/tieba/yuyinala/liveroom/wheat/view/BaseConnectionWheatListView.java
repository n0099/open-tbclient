package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView;
/* loaded from: classes11.dex */
public abstract class BaseConnectionWheatListView extends SafeFrameLayout implements View.OnClickListener {
    public CommonEmptyView bxT;
    public TbPageContext oAe;
    public AlaConnectionWheatListView oCt;
    public int oCx;
    public ConnectionWheatButtonView oCy;
    public TextView oEZ;
    public RelativeLayout oFa;

    protected abstract void dCG();

    public abstract int getCount();

    protected abstract void initListener();

    public abstract void zV(boolean z);

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
        dCG();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_item, this);
        this.oCt = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.bxT = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oEZ = (TextView) findViewById(a.f.tv_online_user_num);
        this.oFa = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.oCy = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oCy.init();
            this.oCy.setListener(getConnectionWheatButtonClickListener());
        }
    }

    protected ConnectionWheatButtonView.a getConnectionWheatButtonClickListener() {
        return null;
    }

    public String getNoDataStr() {
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void efz() {
        if (getCount() != 0) {
            this.oCt.setVisibility(0);
            this.bxT.setVisibility(8);
            return;
        }
        this.oCt.setVisibility(8);
        this.bxT.setVisibility(0);
        this.bxT.reset();
        this.bxT.setTitle(getNoDataStr());
        this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bxT.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efA() {
        this.oEZ.setVisibility(8);
        this.oCt.setVisibility(8);
        this.bxT.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oCy.setVisibility(8);
        }
        this.bxT.reset();
        this.bxT.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.zV(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bxT.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bxT.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bxT.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.oAe = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.oCx = i;
    }

    public void showLoading() {
        if (this.oFa != null) {
            this.oFa.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oFa != null) {
            this.oFa.setVisibility(8);
        }
    }
}
