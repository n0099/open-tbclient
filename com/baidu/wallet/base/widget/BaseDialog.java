package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public abstract class BaseDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23398a = "BaseDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f23399b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23400c;

    /* renamed from: d  reason: collision with root package name */
    public Button f23401d;

    /* renamed from: e  reason: collision with root package name */
    public Button f23402e;

    /* renamed from: f  reason: collision with root package name */
    public ImageButton f23403f;

    /* renamed from: g  reason: collision with root package name */
    public View f23404g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f23405h;
    public LayoutInflater i;
    public View.OnClickListener j;
    public Context mContext;

    public BaseDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.j = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.f23400c.removeAllViews();
        this.f23400c.addView(view, this.f23405h);
    }

    public Button getNegativeBtn() {
        return this.f23402e;
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.f23402e;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f23404g;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f23401d.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.f23401d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f23404g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.f23399b.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.f23399b = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.f23401d = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.f23402e = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.f23403f = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.f23404g = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.f23401d.setOnClickListener(this.j);
        this.f23402e.setOnClickListener(this.j);
        this.f23403f.setOnClickListener(this.j);
        this.f23400c = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f23405h = layoutParams;
        layoutParams.gravity = 17;
        this.i = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.f23402e;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.f23401d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveButtonEnable(boolean z) {
        Button button = this.f23401d;
        if (button != null) {
            button.setTextColor(ResUtils.getColor(this.mContext, z ? "wallet_base_mainColor" : "bd_wallet_pwdpay_light_gray"));
            this.f23401d.setEnabled(z);
        }
    }

    public void setTitleText(int i) {
        TextView textView = this.f23399b;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public void setTitleTextBackgroud(int i) {
        TextView textView = this.f23399b;
        if (textView == null) {
            return;
        }
        textView.setBackgroundColor(i);
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.f23403f;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.f23400c.removeAllViews();
        this.f23400c.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i, View.OnClickListener onClickListener) {
        Button button = this.f23402e;
        if (button != null) {
            button.setText(i);
            Button button2 = this.f23402e;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i, View.OnClickListener onClickListener) {
        Button button = this.f23401d;
        if (button != null) {
            button.setText(i);
            Button button2 = this.f23401d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.f23399b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public BaseDialog(Context context, int i) {
        super(context, i);
        this.j = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(int i) {
        this.f23400c.removeAllViews();
        this.f23400c.addView(this.i.inflate(i, (ViewGroup) null), this.f23405h);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.f23402e != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f23402e.setText(str);
            }
            Button button = this.f23402e;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.f23401d;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.f23401d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i, LinearLayout.LayoutParams layoutParams) {
        this.f23400c.removeAllViews();
        this.f23400c.addView(this.i.inflate(i, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.f23401d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f23401d.setText(str);
            }
            Button button = this.f23401d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
