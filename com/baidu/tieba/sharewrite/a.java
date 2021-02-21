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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class a {
    private DialogInterface.OnKeyListener hie;
    protected final Activity mActivity;
    private DialogInterface.OnCancelListener mCancelListenr;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private String mNegativeButtonTip;
    private String mPositiveButtonTip;
    private final ViewGroup mRootView;
    private String mTitle;
    private String nlX;
    private b nlY;
    private b nlZ;
    private b nma;
    private int mDialogGravity = -1;
    private int mIconResId = -1;
    private int nlV = R.drawable.btn_blue_bg;
    private int nlW = R.color.CAM_X0111;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;

    /* loaded from: classes8.dex */
    public interface b {
        void a(a aVar);
    }

    public a Jc(int i) {
        this.mIconResId = i;
        return this;
    }

    public a Jd(int i) {
        this.nlV = i;
        return this;
    }

    public a Je(int i) {
        this.nlW = i;
        return this;
    }

    public a b(DialogInterface.OnKeyListener onKeyListener) {
        this.hie = onKeyListener;
        return this;
    }

    public a Jf(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.mPositiveButtonTip = this.mActivity.getResources().getString(i);
            this.nlY = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.mNegativeButtonTip = this.mActivity.getResources().getString(i);
            this.nlZ = bVar;
        }
        return this;
    }

    public a xZ(boolean z) {
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
            ap.setBackgroundResource(button, this.nlV);
            ap.setViewTextColor(button, this.nlW, 3);
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
                if (this.nlY != null) {
                    button.setOnClickListener(new View$OnClickListenerC0867a(this, this.nlY));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip)) {
                z2 = false;
            } else {
                button2.setText(this.mNegativeButtonTip);
                if (this.nlZ != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0867a(this, this.nlZ));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.nlX)) {
                z3 = false;
            } else {
                button3.setText(this.nlX);
                if (this.nma != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0867a(this, this.nma));
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

    private a ya(boolean z) {
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
            if (this.hie != null) {
                this.mDialog.setOnKeyListener(this.hie);
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
                public boolean bo(View view) {
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

    public a dJK() {
        return ya(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            g.dismissDialog(this.mDialog, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class View$OnClickListenerC0867a implements View.OnClickListener {
        private final a nmc;
        private final b nmd;

        public View$OnClickListenerC0867a(a aVar, b bVar) {
            this.nmc = aVar;
            this.nmd = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.nmd != null) {
                this.nmd.a(this.nmc);
            }
        }
    }

    private int i(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
