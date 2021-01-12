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
    public CommonEmptyView btf;
    public TextView oAu;
    public RelativeLayout oAv;
    public TbPageContext ovz;
    public AlaConnectionWheatListView oxO;
    public int oxS;
    public ConnectionWheatButtonView oxT;

    protected abstract void dyO();

    public abstract int getCount();

    protected abstract void initListener();

    public abstract void zR(boolean z);

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
        dyO();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_item, this);
        this.oxO = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.btf = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oAu = (TextView) findViewById(a.f.tv_online_user_num);
        this.oAv = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.oxT = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oxT.init();
            this.oxT.setListener(getConnectionWheatButtonClickListener());
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

    public void ebH() {
        if (getCount() != 0) {
            this.oxO.setVisibility(0);
            this.btf.setVisibility(8);
            return;
        }
        this.oxO.setVisibility(8);
        this.btf.setVisibility(0);
        this.btf.reset();
        this.btf.setTitle(getNoDataStr());
        this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.btf.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void ebI() {
        this.oAu.setVisibility(8);
        this.oxO.setVisibility(8);
        this.btf.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.oxT.setVisibility(8);
        }
        this.btf.reset();
        this.btf.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.zR(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.btf.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.btf.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.btf.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.ovz = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.oxS = i;
    }

    public void showLoading() {
        if (this.oAv != null) {
            this.oAv.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oAv != null) {
            this.oAv.setVisibility(8);
        }
    }
}
