package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.List;
/* loaded from: classes5.dex */
public class FeedBackLayout extends BaseItemLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24176a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24177b;

    /* renamed from: c  reason: collision with root package name */
    public View f24178c;

    /* renamed from: e  reason: collision with root package name */
    public HomeCfgResponse.TitleItem f24179e;

    public FeedBackLayout(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_feedback_layout"), this);
        this.f24176a = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_logo"));
        this.f24177b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_home_feedback"));
        View findViewById = findViewById(ResUtils.id(getContext(), "feedback_layout"));
        this.f24178c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.FeedBackLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FeedBackLayout.this.getWalletInterface() != null) {
                    FeedBackLayout.this.getWalletInterface().jump(FeedBackLayout.this.f24179e.fd_desc, FeedBackLayout.this.f24179e.fd_type, FeedBackLayout.this.f24179e.fd_link_addr, false);
                }
            }
        });
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        return this.f24179e != null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        HomeCfgResponse.TitleItem titleItem = this.f24179e;
        if (titleItem != null) {
            if (!TextUtils.isEmpty(titleItem.fd_logo)) {
                NetImageView netImageView = this.f24176a;
                netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + this.f24179e.fd_logo);
            }
            if (!this.f24179e.isFeedBackVisible()) {
                this.f24178c.setVisibility(8);
                return;
            }
            this.f24178c.setVisibility(0);
            this.f24177b.setVisibility(0);
            this.f24177b.setText(this.f24179e.fd_desc);
        }
    }

    public void setData(HomeCfgResponse.TitleItem titleItem, b bVar) {
        this.f24179e = titleItem;
        this.mWalletHomeInterface = bVar;
        if (isDataValid()) {
            initView();
            refreshData();
        }
    }
}
