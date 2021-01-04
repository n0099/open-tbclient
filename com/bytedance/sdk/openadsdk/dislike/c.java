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
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f7336a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f7337b;
    private EditText c;
    private TextView d;
    private TextView e;
    private l f;
    private a g;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void b();
    }

    public c(@NonNull Context context, l lVar) {
        super(context, ac.g(context, "quick_option_dialog"));
        this.f = lVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7336a = LayoutInflater.from(getContext()).inflate(ac.f(getContext(), "tt_dislike_comment_layout"), (ViewGroup) null);
        setContentView(this.f7336a);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        a(getContext());
        c();
        b();
    }

    private void b() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    private void a(Context context) {
        this.c = (EditText) findViewById(ac.e(getContext(), "tt_comment_content"));
        a(this.c);
        this.d = (TextView) findViewById(ac.e(getContext(), "tt_comment_commit"));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = c.this.c.getText().toString();
                if (obj.length() > 0 && !obj.isEmpty()) {
                    FilterWord filterWord = new FilterWord("0:00", obj);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    com.bytedance.sdk.openadsdk.c.d.a(c.this.f, arrayList);
                    if (c.this.g != null) {
                        try {
                            c.this.g.a(0, filterWord);
                        } catch (Throwable th) {
                        }
                    }
                    c.this.dismiss();
                }
            }
        });
        this.f7337b = (ImageView) findViewById(ac.e(getContext(), "tt_comment_close"));
        this.f7337b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.e = (TextView) findViewById(ac.e(getContext(), "tt_comment_number"));
        this.c.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.dislike.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round(charSequence.length());
                c.this.e.setText(round + "");
                if (round > 0) {
                    c.this.d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    c.this.d.setClickable(true);
                    return;
                }
                c.this.d.setTextColor(-7829368);
                c.this.d.setClickable(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f7336a.getWindowToken(), 0);
        }
        this.c.clearFocus();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f7336a.getWindowToken(), 0);
        }
        super.dismiss();
    }

    private void c() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (c.this.g != null) {
                    c.this.g.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.g != null) {
                    c.this.g.b();
                }
            }
        });
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.f = lVar;
        }
    }

    public void a() {
        if (this.c != null) {
            this.c.setText((CharSequence) null);
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public static void a(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.c.6
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type != 19 && type != 28) {
                        i++;
                    } else {
                        return "";
                    }
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }
}
