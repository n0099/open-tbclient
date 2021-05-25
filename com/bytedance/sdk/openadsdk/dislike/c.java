package com.bytedance.sdk.openadsdk.dislike;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f28898a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28899b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f28900c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28901d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28902e;

    /* renamed from: f  reason: collision with root package name */
    public l f28903f;

    /* renamed from: g  reason: collision with root package name */
    public a f28904g;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i2, FilterWord filterWord);

        void b();
    }

    public c(@NonNull Context context, l lVar) {
        super(context, ad.g(context, "quick_option_dialog"));
        this.f28903f = lVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f28900c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f28898a.getWindowToken(), 0);
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(ad.f(getContext(), "tt_dislike_comment_layout"), (ViewGroup) null);
        this.f28898a = inflate;
        setContentView(inflate);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        a(getContext());
        c();
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f28900c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f28898a.getWindowToken(), 0);
        }
        this.f28900c.clearFocus();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    private void a(Context context) {
        EditText editText = (EditText) findViewById(ad.e(getContext(), "tt_comment_content"));
        this.f28900c = editText;
        a(editText);
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_comment_commit"));
        this.f28901d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = c.this.f28900c.getText().toString();
                if (obj.length() <= 0 || obj.isEmpty()) {
                    return;
                }
                FilterWord filterWord = new FilterWord("0:00", obj);
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                com.bytedance.sdk.openadsdk.c.d.a(c.this.f28903f, arrayList);
                if (c.this.f28904g != null) {
                    try {
                        c.this.f28904g.a(0, filterWord);
                    } catch (Throwable unused) {
                    }
                }
                c.this.dismiss();
            }
        });
        ImageView imageView = (ImageView) findViewById(ad.e(getContext(), "tt_comment_close"));
        this.f28899b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.f28902e = (TextView) findViewById(ad.e(getContext(), "tt_comment_number"));
        this.f28900c.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.dislike.c.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                int round = Math.round(charSequence.length());
                c.this.f28902e.setText(round + "");
                if (round > 0) {
                    c.this.f28901d.setTextColor(-16777216);
                    c.this.f28901d.setClickable(true);
                    return;
                }
                c.this.f28901d.setTextColor(-7829368);
                c.this.f28901d.setClickable(false);
            }
        });
    }

    private void b() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    private void c() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (c.this.f28904g != null) {
                    c.this.f28904g.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.f28904g != null) {
                    c.this.f28904g.b();
                }
            }
        });
    }

    public void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28903f = lVar;
    }

    public void a() {
        EditText editText = this.f28900c;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    public void a(a aVar) {
        this.f28904g = aVar;
    }

    public static void a(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.c.6
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                while (i2 < i3) {
                    int type = Character.getType(charSequence.charAt(i2));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i2++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }
}
