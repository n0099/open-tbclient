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
import com.baidu.adp.base.f;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class a {
    private DialogInterface.OnKeyListener hiH;
    protected final Activity mActivity;
    private DialogInterface.OnCancelListener mCancelListenr;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private String mNegativeButtonTip;
    private String mPositiveButtonTip;
    private final ViewGroup mRootView;
    private String mTitle;
    private String ngu;
    private b ngv;
    private b ngw;
    private b ngx;
    private int mDialogGravity = -1;
    private int mIconResId = -1;
    private int ngs = R.drawable.btn_blue_bg;
    private int ngt = R.color.CAM_X0111;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;

    /* loaded from: classes8.dex */
    public interface b {
        void a(a aVar);
    }

    public a Kp(int i) {
        this.mIconResId = i;
        return this;
    }

    public a Kq(int i) {
        this.ngs = i;
        return this;
    }

    public a Kr(int i) {
        this.ngt = i;
        return this;
    }

    public a b(DialogInterface.OnKeyListener onKeyListener) {
        this.hiH = onKeyListener;
        return this;
    }

    public a Ks(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.mPositiveButtonTip = this.mActivity.getResources().getString(i);
            this.ngv = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.mNegativeButtonTip = this.mActivity.getResources().getString(i);
            this.ngw = bVar;
        }
        return this;
    }

    public a xK(boolean z) {
        this.cancelableFlag = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a g(f<?> fVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            c(fVar);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(R.id.message);
            Button button = (Button) this.mRootView.findViewById(R.id.yes);
            ao.setBackgroundResource(button, this.ngs);
            ao.setViewTextColor(button, this.ngt, 3);
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
                ao.setImageResource(imageView, this.mIconResId);
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
                if (this.ngv != null) {
                    button.setOnClickListener(new View$OnClickListenerC0879a(this, this.ngv));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip)) {
                z2 = false;
            } else {
                button2.setText(this.mNegativeButtonTip);
                if (this.ngw != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0879a(this, this.ngw));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.ngu)) {
                z3 = false;
            } else {
                button3.setText(this.ngu);
                if (this.ngx != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0879a(this, this.ngx));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            ((TbPageContext) fVar).getLayoutMode().setNightMode(skinType == 1);
            ((TbPageContext) fVar).getLayoutMode().onModeChanged(this.mRootView);
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

    private a xL(boolean z) {
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
            if (this.hiH != null) {
                this.mDialog.setOnKeyListener(this.hiH);
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
            bg.a(this.mRootView, false, new bg.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.bg.a
                public boolean bs(View view) {
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

    public a dLj() {
        return xL(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            g.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class View$OnClickListenerC0879a implements View.OnClickListener {
        private final b ngA;
        private final a ngz;

        public View$OnClickListenerC0879a(a aVar, b bVar) {
            this.ngz = aVar;
            this.ngA = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.ngA != null) {
                this.ngA.a(this.ngz);
            }
        }
    }

    private int i(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
