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
    public Context f25964a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f25965b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f25966c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25967d;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f25968e;

    /* renamed from: f  reason: collision with root package name */
    public BankCardErrorMsgView f25969f;

    /* renamed from: g  reason: collision with root package name */
    public View f25970g;

    public void a(Context context, int i2) {
        if (context != null) {
            this.f25964a = context;
            this.f25965b = (ViewGroup) LayoutInflater.from(context).inflate(ResUtils.layout(this.f25964a, "wallet_cashdesk_bind_card_item"), (ViewGroup) null);
            this.f25967d = (TextView) this.f25965b.findViewById(ResUtils.id(this.f25964a, "wallet_base_bindcard_item_title"));
            CharSequence d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                this.f25967d.setText(d2);
            }
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f25965b.findViewById(ResUtils.id(this.f25964a, "wallet_base_bindcard_item_value"));
            this.f25968e = safeKeyBoardEditText;
            a(safeKeyBoardEditText);
            this.f25968e.setCheckFunc(f());
            View findViewWithTag = this.f25965b.findViewWithTag(ResUtils.getString(this.f25964a, "wallet_base_string_bindcard_item_line_tag"));
            this.f25970g = findViewWithTag;
            this.f25968e.setTag(findViewWithTag);
            this.f25969f = (BankCardErrorMsgView) this.f25965b.findViewById(ResUtils.id(this.f25964a, "wallet_bindcard_item_error"));
            ImageView imageView = (ImageView) this.f25965b.findViewById(ResUtils.id(this.f25964a, "wallet_base_bindcard_item_image"));
            this.f25966c = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.f25968e.getEditableText().length() == 0) {
                        a.this.e();
                        return;
                    }
                    ((ImageView) view).setImageResource(ResUtils.drawable(a.this.f25964a, "wallet_base_info_btn_selector"));
                    a.this.f25968e.getEditableText().clear();
                    a.this.f25968e.requestFocus();
                }
            });
            this.f25968e.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.a.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String str = TextUtils.isEmpty(editable.toString().trim()) ? "wallet_base_info_btn_selector" : "wallet_base_delete";
                    a aVar = a.this;
                    aVar.f25966c.setImageResource(ResUtils.drawable(aVar.f25964a, str));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                    a.this.a(true);
                }
            });
            this.f25968e.setOnMyFocusChangeListener(new SafeKeyBoardEditText.OnMyFocusChangeListener() { // from class: com.baidu.wallet.paysdk.ui.a.3
                @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
                public void onMyFocusChange(View view, boolean z) {
                    if (z) {
                        com.baidu.wallet.paysdk.ui.widget.a.a(a.this.f25968e, false, true);
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
        this.f25969f.showErrorLayout(null, charSequence);
        com.baidu.wallet.paysdk.ui.widget.a.a(this.f25965b, true, false);
    }

    public void a(boolean z) {
        this.f25969f.showErrorLayout(null, null);
        com.baidu.wallet.paysdk.ui.widget.a.a(this.f25965b, false, z);
    }
}
