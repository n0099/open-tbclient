package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import java.util.List;
/* loaded from: classes5.dex */
public class BdContextMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23400a = "BdContextMenuView";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f23401b = true;
    public boolean mMenuLoaded;

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mMenuLoaded = false;
        a();
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public View createSeparator(Context context) {
        View view = new View(context);
        view.setBackgroundResource(ResUtils.color(context, getSeparatorResId()));
        return view;
    }

    public String getBackgroundResId() {
        return "wallet_base_menu_bg_white_corner";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return null;
    }

    public String getMenuItemViewLayoutId() {
        return "wallet_base_menu_item_view";
    }

    public String getSeparatorResId() {
        return "wallet_base_menu_item_separateColor";
    }

    public void layoutMenu(List<BdMenuItem> list) {
        Log.d(f23400a, "layout menu view");
        if (this.mMenuLoaded) {
            return;
        }
        removeAllViews();
        int size = list.size();
        if (size <= 0) {
            return;
        }
        Context context = getContext();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(ResUtils.dimen(getContext(), "bd_wallet_menu_item_width")), 2);
        for (int i2 = 0; i2 < size; i2++) {
            addView(a(list.get(i2), getMenuItemBackgroudResId(i2, size)));
            if (i2 < size - 1) {
                addView(createSeparator(context), layoutParams);
            }
        }
        this.mMenuLoaded = true;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.mMenuLoaded = false;
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuLoaded = false;
        a();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.mMenuLoaded = false;
        a();
    }

    private View a(final BdMenuItem bdMenuItem, String str) {
        Context context = getContext();
        TextView textView = (TextView) LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), getMenuItemViewLayoutId()), (ViewGroup) this, false);
        textView.setText(bdMenuItem.getTitle());
        textView.setTextColor(getResources().getColor(ResUtils.color(getContext(), "wallet_base_font_text1Color")));
        textView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_menu_item_bg_selector"));
        Drawable icon = bdMenuItem.getIcon();
        if (icon != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.BdContextMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
                if (onClickListener != null) {
                    onClickListener.onClick(bdMenuItem);
                }
            }
        });
        if (!TextUtils.isEmpty(str)) {
            int paddingBottom = textView.getPaddingBottom();
            int paddingTop = textView.getPaddingTop();
            int paddingRight = textView.getPaddingRight();
            int paddingLeft = textView.getPaddingLeft();
            textView.setBackgroundResource(ResUtils.drawable(context, str));
            textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return textView;
    }
}
