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
    public CommonEmptyView bwJ;
    public TbPageContext oGE;
    public AlaConnectionWheatListView oHW;
    public int oIa;
    public ConnectionWheatButtonView oIb;
    public TextView oKE;
    public RelativeLayout oKF;

    public abstract void Ak(boolean z);

    protected abstract void dBf();

    public abstract int getCount();

    protected abstract void initListener();

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
        dBf();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_item, this);
        this.oHW = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oKE = (TextView) findViewById(a.f.tv_online_user_num);
        this.oKF = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.oIb = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oIb.init();
            this.oIb.setListener(getConnectionWheatButtonClickListener());
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

    public void eed() {
        if (getCount() != 0) {
            this.oHW.setVisibility(0);
            this.bwJ.setVisibility(8);
            return;
        }
        this.oHW.setVisibility(8);
        this.bwJ.setVisibility(0);
        this.bwJ.reset();
        this.bwJ.setTitle(getNoDataStr());
        this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bwJ.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void eee() {
        this.oKE.setVisibility(8);
        this.oHW.setVisibility(8);
        this.bwJ.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oIb.setVisibility(8);
        }
        this.bwJ.reset();
        this.bwJ.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.Ak(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bwJ.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bwJ.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bwJ.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.oGE = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.oIa = i;
    }

    public void showLoading() {
        if (this.oKF != null) {
            this.oKF.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oKF != null) {
            this.oKF.setVisibility(8);
        }
    }
}
