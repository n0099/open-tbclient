package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.bind;
import com.baidu.wallet.base.widget.listview.internal.BindLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.HomeLayoutOneTipView;
import com.baidu.wallet.home.ui.widget.inner.HorizontalListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class NHHorListLayout extends BaseItemLayout {
    public static boolean TYPE_TWO_ITEM = false;

    /* renamed from: a  reason: collision with root package name */
    public HorizontalListView f24555a;

    /* renamed from: b  reason: collision with root package name */
    public HomeLayoutOneTipView f24556b;

    /* renamed from: c  reason: collision with root package name */
    public a f24557c;

    /* loaded from: classes5.dex */
    public static class a extends BaseListAdapter<HomeCfgResponse.DataItem> {
        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter, android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            return getItem(i2).empty_view ? 1 : 0;
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter
        public void onBindViewHolder(List<Class<?>> list) {
            list.add(b.class);
            list.add(c.class);
        }
    }

    @BindLayout("wallet_home_nh_horlistview_item")
    /* loaded from: classes5.dex */
    public static class b extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.DataItem> {
        @bind("tv_name")

        /* renamed from: a  reason: collision with root package name */
        public TextView f24559a;
        @bind("tv_value1")

        /* renamed from: b  reason: collision with root package name */
        public TextView f24560b;
        @bind("tv_value2")

        /* renamed from: c  reason: collision with root package name */
        public TextView f24561c;
        @bind("tv_value3")

        /* renamed from: d  reason: collision with root package name */
        public TextView f24562d;
        @bind("framelayout_content")

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f24563e;
        @bind("divider_view")

        /* renamed from: f  reason: collision with root package name */
        public View f24564f;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.DataItem dataItem, int i2, Context context, BaseListAdapter<HomeCfgResponse.DataItem> baseListAdapter) {
            if (!NHHorListLayout.TYPE_TWO_ITEM) {
                this.f24563e.setLayoutParams(new ViewGroup.LayoutParams(DisplayUtils.dip2px(context, 145.0f), DisplayUtils.dip2px(context, 89.0f)));
                ((LinearLayout.LayoutParams) this.f24559a.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 16.0f), 0, 0, 0);
                ((LinearLayout.LayoutParams) this.f24564f.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 6.0f), 0, 0, 0);
            } else {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
                layoutParams.width = (DisplayUtils.getDisplayWidth(context) - (DisplayUtils.dip2px(context, 16.0f) * 3)) / 2;
                this.f24563e.setLayoutParams(layoutParams);
                ((LinearLayout.LayoutParams) this.f24559a.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 20.0f), 0, 0, 0);
                ((LinearLayout.LayoutParams) this.f24564f.getLayoutParams()).setMargins(DisplayUtils.dip2px(context, 10.0f), 0, 0, 0);
            }
            this.f24559a.setText(dataItem.name);
            if (!TextUtils.isEmpty(dataItem.value2)) {
                this.f24561c.setText(dataItem.value2);
                this.f24561c.setVisibility(0);
            } else {
                this.f24561c.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataItem.value3)) {
                this.f24562d.setText(dataItem.value3);
                this.f24562d.setVisibility(0);
            } else {
                this.f24562d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataItem.value1)) {
                this.f24560b.setText(dataItem.value1);
                this.f24560b.setVisibility(0);
                return;
            }
            this.f24560b.setVisibility(8);
        }
    }

    @BindLayout("NOT_USE_XML")
    /* loaded from: classes5.dex */
    public static class c extends BaseListAdapter.BaseViewHolder<HomeCfgResponse.DataItem> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        /* renamed from: a */
        public void setView(HomeCfgResponse.DataItem dataItem, int i2, Context context, BaseListAdapter<HomeCfgResponse.DataItem> baseListAdapter) {
        }

        @Override // com.baidu.wallet.base.widget.listview.BaseListAdapter.BaseViewHolder
        public View createView(Context context) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, DisplayUtils.dip2px(context, 89.0f)));
            return view;
        }
    }

    public NHHorListLayout(Context context) {
        super(context);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return null;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_horview_layout"), this);
        this.f24556b = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
        HorizontalListView horizontalListView = (HorizontalListView) findViewById(ResUtils.id(getContext(), "hor_listview"));
        this.f24555a = horizontalListView;
        horizontalListView.setDividerWidth(DisplayUtils.dip2px(getContext(), 16.0f));
        a aVar = new a(getContext());
        this.f24557c = aVar;
        this.f24555a.setAdapter((ListAdapter) aVar);
        this.f24555a.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.home.ui.widget.newhome.NHHorListLayout.1
            /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                HomeCfgResponse.DataItem dataItem = (HomeCfgResponse.DataItem) adapterView.getAdapter().getItem(i2);
                NHHorListLayout.this.getWalletInterface().jump(dataItem.getName(), dataItem.getType(), dataItem.getLinkAddr(), dataItem.getPrevlogin());
            }
        });
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        if (!TextUtils.isEmpty(this.mConfigData.getGroup_name())) {
            this.f24556b.setData(this.mConfigData, getWalletInterface());
        } else {
            this.f24556b.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        if (this.mConfigData.list.length <= 2) {
            TYPE_TWO_ITEM = true;
            ((LinearLayout.LayoutParams) this.f24555a.getLayoutParams()).setMargins(DisplayUtils.dip2px(getContext(), 16.0f), 0, DisplayUtils.dip2px(getContext(), 16.0f), 0);
            arrayList.addAll(Arrays.asList(this.mConfigData.list));
        } else {
            ((LinearLayout.LayoutParams) this.f24555a.getLayoutParams()).setMargins(0, 0, 0, 0);
            TYPE_TWO_ITEM = false;
            HomeCfgResponse.DataItem dataItem = new HomeCfgResponse.DataItem();
            dataItem.empty_view = true;
            arrayList.add(dataItem);
            arrayList.addAll(Arrays.asList(this.mConfigData.list));
            HomeCfgResponse.DataItem dataItem2 = new HomeCfgResponse.DataItem();
            dataItem2.empty_view = true;
            arrayList.add(dataItem2);
        }
        this.f24557c.initList(arrayList);
    }

    public NHHorListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
