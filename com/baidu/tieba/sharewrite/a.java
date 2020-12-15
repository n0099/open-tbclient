package com.baidu.tieba.sharewrite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes24.dex */
public class a {
    private DialogInterface.OnKeyListener gWT;
    protected final Activity mActivity;
    private DialogInterface.OnCancelListener mCancelListenr;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private String mNegativeButtonTip;
    private String mPositiveButtonTip;
    private final ViewGroup mRootView;
    private String mTitle;
    private String naR;
    private b naS;
    private b naT;
    private b naU;
    private int mDialogGravity = -1;
    private int mIconResId = -1;
    private int naP = R.drawable.btn_blue_bg;
    private int naQ = R.color.CAM_X0111;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;

    /* loaded from: classes24.dex */
    public interface b {
        void a(a aVar);
    }

    public a Ku(int i) {
        this.mIconResId = i;
        return this;
    }

    public a Kv(int i) {
        this.naP = i;
        return this;
    }

    public a Kw(int i) {
        this.naQ = i;
        return this;
    }

    public a b(DialogInterface.OnKeyListener onKeyListener) {
        this.gWT = onKeyListener;
        return this;
    }

    public a Kx(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.mPositiveButtonTip = this.mActivity.getResources().getString(i);
            this.naS = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.mNegativeButtonTip = this.mActivity.getResources().getString(i);
            this.naT = bVar;
        }
        return this;
    }

    public a xI(boolean z) {
        this.cancelableFlag = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a g(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(R.id.message);
            Button button = (Button) this.mRootView.findViewById(R.id.yes);
            ap.setBackgroundResource(button, this.naP);
            ap.setViewTextColor(button, this.naQ, 3);
            Button button2 = (Button) this.mRootView.findViewById(R.id.no);
            Button button3 = (Button) this.mRootView.findViewById(R.id.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.mIconResId != -1) {
                ap.setImageResource(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.mPositiveButtonTip)) {
                z = false;
            } else {
                button.setText(this.mPositiveButtonTip);
                if (this.naS != null) {
                    button.setOnClickListener(new View$OnClickListenerC0863a(this, this.naS));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip)) {
                z2 = false;
            } else {
                button2.setText(this.mNegativeButtonTip);
                if (this.naT != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0863a(this, this.naT));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.naR)) {
                z3 = false;
            } else {
                button3.setText(this.naR);
                if (this.naU != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0863a(this, this.naU));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(e<?> eVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (eVar instanceof TbPageContext) {
            ((TbPageContext) eVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    private void a(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        boolean[] zArr = {z2, z, z3};
        Button[] buttonArr = {button2, button, button3};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (zArr[i]) {
                arrayList.add(buttonArr[i]);
                buttonArr[i].setVisibility(0);
            } else {
                buttonArr[i].setVisibility(8);
            }
        }
        if (arrayList.size() == 3) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                a((Button) arrayList.get(i3), 0, i3 == 2 ? 0 : 20);
                i2 = i3 + 1;
            }
        }
        if (arrayList.size() == 2) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 2) {
                    break;
                }
                a((Button) arrayList.get(i5), 0, i5 == 1 ? 0 : 20);
                i4 = i5 + 1;
            }
        }
        if (arrayList.size() == 1) {
            a((Button) arrayList.get(0), 0, 0);
        }
    }

    private void a(Button button, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = i(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private a xJ(boolean z) {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                g.showDialog(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
            if (this.mCancelListenr != null) {
                this.mDialog.setOnCancelListener(this.mCancelListenr);
            }
            if (this.gWT != null) {
                this.mDialog.setOnKeyListener(this.gWT);
            }
            if (z) {
                g.showDialog(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.mDialogGravity == -1) {
                this.mDialogGravity = 17;
            }
            window.setGravity(this.mDialogGravity);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bh.a(this.mRootView, false, new bh.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.bh.a
                public boolean bj(View view) {
                    if (view instanceof EditText) {
                        atomicBoolean.set(true);
                        return true;
                    }
                    return false;
                }
            });
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public a dLr() {
        return xJ(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            g.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class View$OnClickListenerC0863a implements View.OnClickListener {
        private final a naW;
        private final b naX;

        public View$OnClickListenerC0863a(a aVar, b bVar) {
            this.naW = aVar;
            this.naX = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.naX != null) {
                this.naX.a(this.naW);
            }
        }
    }

    private int i(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
