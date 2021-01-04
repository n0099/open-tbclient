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
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class LandingCommentDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f7305a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f7306b;
    private EditText c;
    private TextView d;
    private TextView e;
    private l f;
    private a g;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view);

        void a(String str, boolean z);

        void b(View view);
    }

    public LandingCommentDialog(@NonNull Context context, @NonNull l lVar) {
        super(context, null, ac.g(context, "quick_option_dialog"));
        this.f = lVar;
        a(context);
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
        this.f7305a = LayoutInflater.from(context).inflate(ac.f(context, "tt_dislike_comment_layout"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f7305a.setLayoutParams(layoutParams);
        this.f7305a.setClickable(true);
        c();
    }

    public void a() {
        setVisibility(8);
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f7305a.getWindowToken(), 0);
        }
        if (this.g != null) {
            this.g.b(this);
        }
    }

    public void b() {
        if (this.f7305a.getParent() == null) {
            addView(this.f7305a);
        }
        setVisibility(0);
        if (this.g != null) {
            this.g.a(this);
        }
    }

    private void c() {
        this.c = (EditText) this.f7305a.findViewById(ac.e(getContext(), "tt_comment_content"));
        setEditTextInputSpace(this.c);
        this.d = (TextView) this.f7305a.findViewById(ac.e(getContext(), "tt_comment_commit"));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = LandingCommentDialog.this.c.getText().toString();
                if (obj.length() > 0 && !obj.isEmpty()) {
                    FilterWord filterWord = new FilterWord("0:00", obj);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    com.bytedance.sdk.openadsdk.c.d.a(LandingCommentDialog.this.f, arrayList);
                    if (LandingCommentDialog.this.g != null) {
                        try {
                            LandingCommentDialog.this.g.a(obj, true);
                        } catch (Throwable th) {
                        }
                    }
                    LandingCommentDialog.this.a();
                }
            }
        });
        this.f7306b = (ImageView) this.f7305a.findViewById(ac.e(getContext(), "tt_comment_close"));
        this.f7306b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingCommentDialog.this.a();
            }
        });
        this.e = (TextView) this.f7305a.findViewById(ac.e(getContext(), "tt_comment_number"));
        this.c.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round(charSequence.length());
                LandingCommentDialog.this.e.setText(round + "");
                if (round > 0) {
                    LandingCommentDialog.this.d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    LandingCommentDialog.this.d.setClickable(true);
                    return;
                }
                LandingCommentDialog.this.d.setTextColor(-7829368);
                LandingCommentDialog.this.d.setClickable(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void setCallback(a aVar) {
        this.g = aVar;
    }

    public static void setEditTextInputSpace(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.5
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
