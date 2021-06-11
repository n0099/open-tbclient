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
    public static final String f23406a = "BaseDialog";

    /* renamed from: b  reason: collision with root package name */
    public TextView f23407b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23408c;

    /* renamed from: d  reason: collision with root package name */
    public Button f23409d;

    /* renamed from: e  reason: collision with root package name */
    public Button f23410e;

    /* renamed from: f  reason: collision with root package name */
    public ImageButton f23411f;

    /* renamed from: g  reason: collision with root package name */
    public View f23412g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f23413h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f23414i;
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
        this.f23408c.removeAllViews();
        this.f23408c.addView(view, this.f23413h);
    }

    public Button getNegativeBtn() {
        return this.f23410e;
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.f23410e;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f23412g;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f23409d.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.f23409d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f23412g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.f23407b.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.f23407b = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.f23409d = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.f23410e = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.f23411f = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.f23412g = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.f23409d.setOnClickListener(this.j);
        this.f23410e.setOnClickListener(this.j);
        this.f23411f.setOnClickListener(this.j);
        this.f23408c = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f23413h = layoutParams;
        layoutParams.gravity = 17;
        this.f23414i = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.f23410e;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.f23409d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveButtonEnable(boolean z) {
        Button button = this.f23409d;
        if (button != null) {
            button.setTextColor(ResUtils.getColor(this.mContext, z ? "wallet_base_mainColor" : "bd_wallet_pwdpay_light_gray"));
            this.f23409d.setEnabled(z);
        }
    }

    public void setTitleText(int i2) {
        TextView textView = this.f23407b;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setTitleTextBackgroud(int i2) {
        TextView textView = this.f23407b;
        if (textView == null) {
            return;
        }
        textView.setBackgroundColor(i2);
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.f23411f;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.f23408c.removeAllViews();
        this.f23408c.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.f23410e;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.f23410e;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.f23409d;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.f23409d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.f23407b;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public BaseDialog(Context context, int i2) {
        super(context, i2);
        this.j = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseDialog.this.dismiss();
            }
        };
        this.mContext = context;
    }

    public void addContentView(int i2) {
        this.f23408c.removeAllViews();
        this.f23408c.addView(this.f23414i.inflate(i2, (ViewGroup) null), this.f23413h);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.f23410e != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f23410e.setText(str);
            }
            Button button = this.f23410e;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.f23409d;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.f23409d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i2, LinearLayout.LayoutParams layoutParams) {
        this.f23408c.removeAllViews();
        this.f23408c.addView(this.f23414i.inflate(i2, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.f23409d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f23409d.setText(str);
            }
            Button button = this.f23409d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
