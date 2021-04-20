package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class HomeInformationItemView extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24259a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24260b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24261c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24262d;
    public View mLine;

    public HomeInformationItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_information_item_view"), this);
        this.f24259a = (NetImageView) findViewById(ResUtils.id(getContext(), "home_info_item_logo"));
        this.f24260b = (TextView) findViewById(ResUtils.id(getContext(), "home_info_item_title"));
        this.f24261c = (TextView) findViewById(ResUtils.id(getContext(), "home_info_item_date"));
        this.f24262d = (TextView) findViewById(ResUtils.id(getContext(), "home_info_item_source"));
        this.mLine = findViewById(ResUtils.id(getContext(), "home_info_item_line"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        a();
        if (this.f24259a != null) {
            String str = getData().value3;
            if (!TextUtils.isEmpty(str)) {
                this.f24259a.setImageUrl(str);
            }
        }
        if (this.f24260b != null) {
            String str2 = getData().name;
            if (!TextUtils.isEmpty(str2)) {
                this.f24260b.setText(str2);
            }
        }
        if (this.f24261c != null) {
            String str3 = getData().value2;
            if (!TextUtils.isEmpty(str3)) {
                this.f24261c.setText(str3);
            }
        }
        if (this.f24262d != null) {
            String str4 = getData().value1;
            if (!TextUtils.isEmpty(str4)) {
                this.f24262d.setText(str4);
            }
        }
        if (TextUtils.isEmpty(getData().link_addr)) {
            setOnClickListener(null);
            setEnabled(false);
        } else {
            setOnClickListener(this);
            setEnabled(true);
        }
        handlePoint();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        super.setData(dataItem, bVar);
        a();
        refresh();
    }

    public void setLineVisibility(boolean z) {
        View view = this.mLine;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
    }

    public HomeInformationItemView(Context context) {
        super(context);
    }
}
