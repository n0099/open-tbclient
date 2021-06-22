package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class CHFinanceEntryItem extends BaseItemView {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24462a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f24463b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f24464c;

    /* loaded from: classes5.dex */
    public enum EntryType {
        ENTRY_TYPE_NORMAL,
        ENTRY_TYPE_LARGE
    }

    public CHFinanceEntryItem(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        return false;
    }

    public void initView(EntryType entryType) {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), EntryType.ENTRY_TYPE_NORMAL.equals(entryType) ? "wallet_home_ch_finance_entry_normal_item" : "wallet_home_ch_finance_entry_large_item"), this);
        setGravity(13);
        this.f24462a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_fe_logo"));
        this.f24463b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fe_title"));
        this.f24464c = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_fe_desc"));
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        setNetImageViewUrl(this.f24462a, getData().logo);
        this.f24463b.setMaskText(getData().name);
        this.f24464c.setMaskText(getData().value1);
        handlePoint();
    }

    public void setData(HomeCfgResponse.DataItem dataItem, b bVar, EntryType entryType) {
        super.setData(dataItem, bVar);
        initView(entryType);
        refresh();
    }

    public CHFinanceEntryItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
