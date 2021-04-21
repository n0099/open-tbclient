package com.baidu.wallet.lightapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.GridLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LangBridgeMenuDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public BdMenuItem.OnItemClickListener f24987a;

    /* renamed from: b  reason: collision with root package name */
    public GridLayout f24988b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24989c;

    /* renamed from: d  reason: collision with root package name */
    public List<BdMenuItem> f24990d;
    public boolean mMenuLoaded;

    public LangBridgeMenuDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.mMenuLoaded = false;
        a();
    }

    public void add(int i, CharSequence charSequence, Drawable drawable) {
        BdMenuItem bdMenuItem = new BdMenuItem(getContext(), i, charSequence, drawable);
        bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.2
            @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
            public void onClick(BdMenuItem bdMenuItem2) {
                LangBridgeMenuDialog.this.dismiss();
                if (LangBridgeMenuDialog.this.f24987a != null) {
                    LangBridgeMenuDialog.this.f24987a.onClick(bdMenuItem2);
                }
            }
        });
        this.f24990d.add(bdMenuItem);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public void layoutMenu() {
        if (this.mMenuLoaded) {
            return;
        }
        this.f24988b.removeAllViews();
        if (this.f24990d.size() <= 0) {
            return;
        }
        for (BdMenuItem bdMenuItem : this.f24990d) {
            this.f24988b.addView(a(bdMenuItem));
        }
        this.mMenuLoaded = true;
    }

    public void setMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        this.f24987a = onItemClickListener;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
        }
    }

    private void a() {
        this.f24990d = new ArrayList();
        requestWindowFeature(1);
        setContentView(ResUtils.layout(getContext(), "wallet_langbridge_menu"));
        Window window = getWindow();
        window.setWindowAnimations(ResUtils.style(getContext(), "wallet_base_bottom_dialog_anim"));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = window.getWindowManager().getDefaultDisplay().getHeight();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f24988b = (GridLayout) findViewById(ResUtils.id(getContext(), "menu_grid_layout"));
        this.f24989c = (TextView) findViewById(ResUtils.id(getContext(), "menu_cancel"));
        this.f24988b.setColumnCount(5);
        this.f24988b.setHorizontalSpacing(0);
        this.f24988b.setVerticalSpacing(DisplayUtils.dip2px(getContext(), 0.5f));
        this.f24988b.setSeparateLine(ResUtils.getColor(getContext(), "wallet_base_color_D8D8D8"), DisplayUtils.dip2px(getContext(), 18.0f));
        this.f24989c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LangBridgeMenuDialog.this.dismiss();
            }
        });
        layoutMenu();
    }

    public void add(int i, CharSequence charSequence, String str) {
        BdMenuItem bdMenuItem = new BdMenuItem(getContext(), i, charSequence, str);
        bdMenuItem.setOnClickListener(new BdMenuItem.OnItemClickListener() { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.3
            @Override // com.baidu.wallet.base.widget.BdMenuItem.OnItemClickListener
            public void onClick(BdMenuItem bdMenuItem2) {
                LangBridgeMenuDialog.this.dismiss();
                if (LangBridgeMenuDialog.this.f24987a != null) {
                    LangBridgeMenuDialog.this.f24987a.onClick(bdMenuItem2);
                }
            }
        });
        this.f24990d.add(bdMenuItem);
    }

    private View a(final BdMenuItem bdMenuItem) {
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_langbridge_menu_item"), (ViewGroup) null);
        NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(context, "menu_item_img"));
        ((TextView) inflate.findViewById(ResUtils.id(context, "menu_item_txt"))).setText(bdMenuItem.getTitle());
        if (!TextUtils.isEmpty(bdMenuItem.getIconUrl())) {
            netImageView.setImageUrl(bdMenuItem.getIconUrl());
        } else {
            Drawable icon = bdMenuItem.getIcon();
            if (icon != null) {
                netImageView.setImageDrawable(icon);
            }
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdMenuItem.OnItemClickListener onClickListener = bdMenuItem.getOnClickListener();
                if (onClickListener != null) {
                    onClickListener.onClick(bdMenuItem);
                }
            }
        });
        return inflate;
    }
}
