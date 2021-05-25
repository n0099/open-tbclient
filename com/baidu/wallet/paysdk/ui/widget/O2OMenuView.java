package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
/* loaded from: classes5.dex */
public class O2OMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26063a = O2OMenuView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public boolean f26064b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f26065c;

    /* renamed from: d  reason: collision with root package name */
    public a f26066d;

    /* renamed from: e  reason: collision with root package name */
    public OnO2OMenuItemSelectListener f26067e;

    /* loaded from: classes5.dex */
    public interface OnO2OMenuItemSelectListener {
        void onMenuItemClick(String str);
    }

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public String[] f26070b;

        public a() {
        }

        public void a(String[] strArr) {
            this.f26070b = strArr;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = this.f26070b;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            O2OMenuItemView o2OMenuItemView;
            if (view == null) {
                o2OMenuItemView = new O2OMenuItemView(O2OMenuView.this.getContext());
            } else {
                o2OMenuItemView = (O2OMenuItemView) view;
            }
            o2OMenuItemView.updateItem(this.f26070b[i2]);
            return o2OMenuItemView;
        }
    }

    @SuppressLint({"NewApi"})
    public O2OMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26064b = false;
        a();
    }

    public String getBackgroundResId() {
        return "wallet_base_o2o_bg_pay_more";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return null;
    }

    public String getMenuItemViewLayoutId() {
        return "wallet_base_menu_item_view";
    }

    public int getSeparatorColor() {
        return -1710619;
    }

    public void layoutMenu(String[] strArr) {
        Log.d(f26063a, "layout menu view");
        a aVar = this.f26066d;
        if (aVar != null) {
            aVar.a(strArr);
            this.f26066d.notifyDataSetChanged();
            return;
        }
        a aVar2 = new a();
        this.f26066d = aVar2;
        aVar2.a(strArr);
        this.f26065c.setAdapter((ListAdapter) this.f26066d);
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.f26064b = false;
    }

    public void setMenuSelectListener(OnO2OMenuItemSelectListener onO2OMenuItemSelectListener) {
        this.f26067e = onO2OMenuItemSelectListener;
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        this.f26065c = new ListView(getContext());
        int dip2px = DisplayUtils.dip2px(getContext(), 115.0f);
        this.f26065c.setDivider(new ColorDrawable(getSeparatorColor()));
        this.f26065c.setDividerHeight(1);
        this.f26065c.setSelector(new ColorDrawable(0));
        this.f26065c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.O2OMenuView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (view != null && (view instanceof O2OMenuItemView)) {
                    String string = ((O2OMenuItemView) view).getString();
                    if (O2OMenuView.this.f26067e != null) {
                        O2OMenuView.this.f26067e.onMenuItemClick(string);
                    }
                }
            }
        });
        addView(this.f26065c, new LinearLayout.LayoutParams(dip2px, -2));
        setFocusableInTouchMode(true);
    }

    public O2OMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26064b = false;
        a();
    }

    public O2OMenuView(Context context) {
        super(context);
        this.f26064b = false;
        a();
    }
}
