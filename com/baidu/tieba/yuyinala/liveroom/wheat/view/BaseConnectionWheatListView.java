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
    public CommonEmptyView bnY;
    public TbPageContext oey;
    public AlaConnectionWheatListView ogE;
    public TextView ogI;
    public LinearLayout ogJ;
    public int ogL;
    public TextView oiY;
    public RelativeLayout oiZ;

    protected abstract void dxy();

    public abstract int getCount();

    protected abstract void initListener();

    public abstract void zq(boolean z);

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
        dxy();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connnection_wheat_item, this);
        this.ogE = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.bnY = (CommonEmptyView) findViewById(a.f.empty_view);
        this.oiY = (TextView) findViewById(a.f.tv_online_user_num);
        this.oiZ = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.ogJ = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ogI = (TextView) findViewById(a.f.tv_apply_btn);
    }

    public String getNoDataStr() {
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void dZP() {
        if (getCount() != 0) {
            this.ogE.setVisibility(0);
            this.bnY.setVisibility(8);
            return;
        }
        this.ogE.setVisibility(8);
        this.bnY.setVisibility(0);
        this.bnY.reset();
        this.bnY.setTitle(getNoDataStr());
        this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bnY.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void dZQ() {
        this.oiY.setVisibility(8);
        this.ogE.setVisibility(8);
        this.bnY.setVisibility(0);
        if (this instanceof ConnectionWheatApplyListView) {
            this.ogJ.setVisibility(8);
        }
        this.bnY.reset();
        this.bnY.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseConnectionWheatListView.this.zq(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bnY.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bnY.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bnY.setTextColor(getContext().getResources().getColor(a.c.sdk_color_525252));
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.oey = tbPageContext;
    }

    public void setApplyPosition(int i) {
        this.ogL = i;
    }

    public void showLoading() {
        if (this.oiZ != null) {
            this.oiZ.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.oiZ != null) {
            this.oiZ.setVisibility(8);
        }
    }
}
