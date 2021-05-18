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
/* loaded from: classes6.dex */
public class LandingCommentDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f28905a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28906b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f28907c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28908d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28909e;

    /* renamed from: f  reason: collision with root package name */
    public l f28910f;

    /* renamed from: g  reason: collision with root package name */
    public a f28911g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view);

        void a(String str, boolean z);

        void b(View view);
    }

    public LandingCommentDialog(@NonNull Context context, @NonNull l lVar) {
        super(context, null, ad.g(context, "quick_option_dialog"));
        this.f28910f = lVar;
        a(context);
    }

    public static void setEditTextInputSpace(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.5
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

    public void setCallback(a aVar) {
        this.f28911g = aVar;
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
        this.f28905a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_comment_layout"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f28905a.setLayoutParams(layoutParams);
        this.f28905a.setClickable(true);
        c();
    }

    private void c() {
        EditText editText = (EditText) this.f28905a.findViewById(ad.e(getContext(), "tt_comment_content"));
        this.f28907c = editText;
        setEditTextInputSpace(editText);
        TextView textView = (TextView) this.f28905a.findViewById(ad.e(getContext(), "tt_comment_commit"));
        this.f28908d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = LandingCommentDialog.this.f28907c.getText().toString();
                if (obj.length() <= 0 || obj.isEmpty()) {
                    return;
                }
                FilterWord filterWord = new FilterWord("0:00", obj);
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                com.bytedance.sdk.openadsdk.c.d.a(LandingCommentDialog.this.f28910f, arrayList);
                if (LandingCommentDialog.this.f28911g != null) {
                    try {
                        LandingCommentDialog.this.f28911g.a(obj, true);
                    } catch (Throwable unused) {
                    }
                }
                LandingCommentDialog.this.a();
            }
        });
        ImageView imageView = (ImageView) this.f28905a.findViewById(ad.e(getContext(), "tt_comment_close"));
        this.f28906b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingCommentDialog.this.a();
            }
        });
        this.f28909e = (TextView) this.f28905a.findViewById(ad.e(getContext(), "tt_comment_number"));
        this.f28907c.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                int round = Math.round(charSequence.length());
                LandingCommentDialog.this.f28909e.setText(round + "");
                if (round > 0) {
                    LandingCommentDialog.this.f28908d.setTextColor(-16777216);
                    LandingCommentDialog.this.f28908d.setClickable(true);
                    return;
                }
                LandingCommentDialog.this.f28908d.setTextColor(-7829368);
                LandingCommentDialog.this.f28908d.setClickable(false);
            }
        });
    }

    public void b() {
        if (this.f28905a.getParent() == null) {
            addView(this.f28905a);
        }
        setVisibility(0);
        a aVar = this.f28911g;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a() {
        setVisibility(8);
        InputMethodManager inputMethodManager = (InputMethodManager) this.f28907c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f28905a.getWindowToken(), 0);
        }
        a aVar = this.f28911g;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
