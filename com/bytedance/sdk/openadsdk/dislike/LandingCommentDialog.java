package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class LandingCommentDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f28766a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28767b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f28768c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28769d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28770e;

    /* renamed from: f  reason: collision with root package name */
    public l f28771f;

    /* renamed from: g  reason: collision with root package name */
    public a f28772g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view);

        void a(String str, boolean z);

        void b(View view);
    }

    public LandingCommentDialog(@NonNull Context context, @NonNull l lVar) {
        super(context, null, ad.g(context, "quick_option_dialog"));
        this.f28771f = lVar;
        a(context);
    }

    public static void setEditTextInputSpace(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.5
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

    public void setCallback(a aVar) {
        this.f28772g = aVar;
    }

    private void a(Context context) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingCommentDialog.this.a();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f28766a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_comment_layout"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f28766a.setLayoutParams(layoutParams);
        this.f28766a.setClickable(true);
        c();
    }

    private void c() {
        EditText editText = (EditText) this.f28766a.findViewById(ad.e(getContext(), "tt_comment_content"));
        this.f28768c = editText;
        setEditTextInputSpace(editText);
        TextView textView = (TextView) this.f28766a.findViewById(ad.e(getContext(), "tt_comment_commit"));
        this.f28769d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = LandingCommentDialog.this.f28768c.getText().toString();
                if (obj.length() <= 0 || obj.isEmpty()) {
                    return;
                }
                FilterWord filterWord = new FilterWord("0:00", obj);
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                com.bytedance.sdk.openadsdk.c.d.a(LandingCommentDialog.this.f28771f, arrayList);
                if (LandingCommentDialog.this.f28772g != null) {
                    try {
                        LandingCommentDialog.this.f28772g.a(obj, true);
                    } catch (Throwable unused) {
                    }
                }
                LandingCommentDialog.this.a();
            }
        });
        ImageView imageView = (ImageView) this.f28766a.findViewById(ad.e(getContext(), "tt_comment_close"));
        this.f28767b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingCommentDialog.this.a();
            }
        });
        this.f28770e = (TextView) this.f28766a.findViewById(ad.e(getContext(), "tt_comment_number"));
        this.f28768c.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round(charSequence.length());
                LandingCommentDialog.this.f28770e.setText(round + "");
                if (round > 0) {
                    LandingCommentDialog.this.f28769d.setTextColor(-16777216);
                    LandingCommentDialog.this.f28769d.setClickable(true);
                    return;
                }
                LandingCommentDialog.this.f28769d.setTextColor(-7829368);
                LandingCommentDialog.this.f28769d.setClickable(false);
            }
        });
    }

    public void b() {
        if (this.f28766a.getParent() == null) {
            addView(this.f28766a);
        }
        setVisibility(0);
        a aVar = this.f28772g;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a() {
        setVisibility(8);
        InputMethodManager inputMethodManager = (InputMethodManager) this.f28768c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f28766a.getWindowToken(), 0);
        }
        a aVar = this.f28772g;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
