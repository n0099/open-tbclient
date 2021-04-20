package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.paysdk.ui.widget.BankCardErrorMsgView;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f25989a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f25990b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f25991c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25992d;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f25993e;

    /* renamed from: f  reason: collision with root package name */
    public BankCardErrorMsgView f25994f;

    /* renamed from: g  reason: collision with root package name */
    public View f25995g;

    public void a(Context context, int i) {
        if (context != null) {
            this.f25989a = context;
            this.f25990b = (ViewGroup) LayoutInflater.from(context).inflate(ResUtils.layout(this.f25989a, "wallet_cashdesk_bind_card_item"), (ViewGroup) null);
            this.f25992d = (TextView) this.f25990b.findViewById(ResUtils.id(this.f25989a, "wallet_base_bindcard_item_title"));
            CharSequence d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                this.f25992d.setText(d2);
            }
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f25990b.findViewById(ResUtils.id(this.f25989a, "wallet_base_bindcard_item_value"));
            this.f25993e = safeKeyBoardEditText;
            a(safeKeyBoardEditText);
            this.f25993e.setCheckFunc(f());
            View findViewWithTag = this.f25990b.findViewWithTag(ResUtils.getString(this.f25989a, "wallet_base_string_bindcard_item_line_tag"));
            this.f25995g = findViewWithTag;
            this.f25993e.setTag(findViewWithTag);
            this.f25994f = (BankCardErrorMsgView) this.f25990b.findViewById(ResUtils.id(this.f25989a, "wallet_bindcard_item_error"));
            ImageView imageView = (ImageView) this.f25990b.findViewById(ResUtils.id(this.f25989a, "wallet_base_bindcard_item_image"));
            this.f25991c = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.f25993e.getEditableText().length() == 0) {
                        a.this.e();
                        return;
                    }
                    ((ImageView) view).setImageResource(ResUtils.drawable(a.this.f25989a, "wallet_base_info_btn_selector"));
                    a.this.f25993e.getEditableText().clear();
                    a.this.f25993e.requestFocus();
                }
            });
            this.f25993e.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.a.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String str = TextUtils.isEmpty(editable.toString().trim()) ? "wallet_base_info_btn_selector" : "wallet_base_delete";
                    a aVar = a.this;
                    aVar.f25991c.setImageResource(ResUtils.drawable(aVar.f25989a, str));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    a.this.a(true);
                }
            });
            this.f25993e.setOnMyFocusChangeListener(new SafeKeyBoardEditText.OnMyFocusChangeListener() { // from class: com.baidu.wallet.paysdk.ui.a.3
                @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
                public void onMyFocusChange(View view, boolean z) {
                    if (z) {
                        com.baidu.wallet.paysdk.ui.widget.a.a(a.this.f25993e, false, true);
                    }
                }
            });
            return;
        }
        throw new NullPointerException("context null");
    }

    public abstract void a(SafeKeyBoardEditText safeKeyBoardEditText);

    public abstract CharSequence d();

    public abstract void e();

    public abstract SafeKeyBoardEditText.CheckFunc f();

    public void a(CharSequence charSequence) {
        this.f25994f.showErrorLayout(null, charSequence);
        com.baidu.wallet.paysdk.ui.widget.a.a(this.f25990b, true, false);
    }

    public void a(boolean z) {
        this.f25994f.showErrorLayout(null, null);
        com.baidu.wallet.paysdk.ui.widget.a.a(this.f25990b, false, z);
    }
}
