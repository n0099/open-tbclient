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
/* loaded from: classes10.dex */
public abstract class BaseConnectionWheatListView extends SafeFrameLayout implements View.OnClickListener {
    public CommonEmptyView byj;
    public TbPageContext oIJ;
    public AlaConnectionWheatListView oKb;
    public int oKf;
    public ConnectionWheatButtonView oKg;
    public TextView oMJ;
    public RelativeLayout oMK;

    public abstract void Aj(boolean z);

    protected abstract void dBn();

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
        dBn();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_item, this);
        this.oKb = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.byj = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oMJ = (TextView) findViewById(a.f.tv_online_user_num);
        this.oMK = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.oKg = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oKg.init();
            this.oKg.setListener(getConnectionWheatButtonClickListener());
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

    public void eel() {
        if (getCount() != 0) {
            this.oKb.setVisibility(0);
            this.byj.setVisibility(8);
            return;
        }
        this.oKb.setVisibility(8);
        this.byj.setVisibility(0);
        this.byj.reset();
        this.byj.setTitle(getNoDataStr());
        this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.byj.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void eem() {
        this.oMJ.setVisibility(8);
        this.oKb.setVisibility(8);
        this.byj.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oKg.setVisibility(8);
        }
        this.byj.reset();
        this.byj.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.Aj(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.byj.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.byj.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.byj.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.oIJ = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.oKf = i;
    }

    public void showLoading() {
        if (this.oMK != null) {
            this.oMK.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oMK != null) {
            this.oMK.setVisibility(8);
        }
    }
}
