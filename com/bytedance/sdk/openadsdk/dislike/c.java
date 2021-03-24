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
    public View f29142a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f29143b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f29144c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29145d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29146e;

    /* renamed from: f  reason: collision with root package name */
    public l f29147f;

    /* renamed from: g  reason: collision with root package name */
    public a f29148g;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void b();
    }

    public c(@NonNull Context context, l lVar) {
        super(context, ad.g(context, "quick_option_dialog"));
        this.f29147f = lVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f29144c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f29142a.getWindowToken(), 0);
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(ad.f(getContext(), "tt_dislike_comment_layout"), (ViewGroup) null);
        this.f29142a = inflate;
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
        InputMethodManager inputMethodManager = (InputMethodManager) this.f29144c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f29142a.getWindowToken(), 0);
        }
        this.f29144c.clearFocus();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    private void a(Context context) {
        EditText editText = (EditText) findViewById(ad.e(getContext(), "tt_comment_content"));
        this.f29144c = editText;
        a(editText);
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_comment_commit"));
        this.f29145d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = c.this.f29144c.getText().toString();
                if (obj.length() <= 0 || obj.isEmpty()) {
                    return;
                }
                FilterWord filterWord = new FilterWord("0:00", obj);
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                com.bytedance.sdk.openadsdk.c.d.a(c.this.f29147f, arrayList);
                if (c.this.f29148g != null) {
                    try {
                        c.this.f29148g.a(0, filterWord);
                    } catch (Throwable unused) {
                    }
                }
                c.this.dismiss();
            }
        });
        ImageView imageView = (ImageView) findViewById(ad.e(getContext(), "tt_comment_close"));
        this.f29143b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.f29146e = (TextView) findViewById(ad.e(getContext(), "tt_comment_number"));
        this.f29144c.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.dislike.c.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round(charSequence.length());
                c.this.f29146e.setText(round + "");
                if (round > 0) {
                    c.this.f29145d.setTextColor(-16777216);
                    c.this.f29145d.setClickable(true);
                    return;
                }
                c.this.f29145d.setTextColor(-7829368);
                c.this.f29145d.setClickable(false);
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
                if (c.this.f29148g != null) {
                    c.this.f29148g.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.f29148g != null) {
                    c.this.f29148g.b();
                }
            }
        });
    }

    public void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.f29147f = lVar;
    }

    public void a() {
        EditText editText = this.f29144c;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    public void a(a aVar) {
        this.f29148g = aVar;
    }

    public static void a(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.c.6
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }
}
