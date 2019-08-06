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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private String bMX;
    private String bMY;
    private DialogInterface.OnCancelListener bNf;
    private String iVZ;
    private b iWa;
    private b iWb;
    private b iWc;
    private DialogInterface.OnKeyListener iWd;
    protected final Activity mActivity;
    private View mContentView;
    private AlertDialog mDialog;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bMT = -1;
    private int mIconResId = -1;
    private int iVX = R.drawable.btn_blue_bg;
    private int iVY = R.color.cp_cont_g;
    private boolean bNi = false;
    private boolean bNj = true;

    /* loaded from: classes6.dex */
    public interface b {
        void a(a aVar);
    }

    public a AF(int i) {
        this.mIconResId = i;
        return this;
    }

    public a AG(int i) {
        this.iVX = i;
        return this;
    }

    public a AH(int i) {
        this.iVY = i;
        return this;
    }

    public a b(DialogInterface.OnKeyListener onKeyListener) {
        this.iWd = onKeyListener;
        return this;
    }

    public a AI(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bMX = this.mActivity.getResources().getString(i);
            this.iWa = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bMY = this.mActivity.getResources().getString(i);
            this.iWb = bVar;
        }
        return this;
    }

    public a qM(boolean z) {
        this.bNj = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a f(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.bNi) {
            this.bNi = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(R.id.message);
            Button button = (Button) this.mRootView.findViewById(R.id.yes);
            am.k(button, this.iVX);
            am.f(button, this.iVY, 3);
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
                am.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.bMX)) {
                z = false;
            } else {
                button.setText(this.bMX);
                if (this.iWa != null) {
                    button.setOnClickListener(new View$OnClickListenerC0408a(this, this.iWa));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bMY)) {
                z2 = false;
            } else {
                button2.setText(this.bMY);
                if (this.iWb != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0408a(this, this.iWb));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.iVZ)) {
                z3 = false;
            } else {
                button3.setText(this.iVZ);
                if (this.iWc != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0408a(this, this.iWc));
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
        layoutParams.width = dipToPx(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private a qN(boolean z) {
        if (!this.bNi) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.mDialog != null) {
            if (z) {
                g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog.setCanceledOnTouchOutside(this.bNj);
            if (this.bNf != null) {
                this.mDialog.setOnCancelListener(this.bNf);
            }
            if (this.iWd != null) {
                this.mDialog.setOnKeyListener(this.iWd);
            }
            if (z) {
                g.a(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            Window window = this.mDialog.getWindow();
            if (this.bMT == -1) {
                this.bMT = 17;
            }
            window.setGravity(this.bMT);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bd.a(this.mRootView, false, new bd.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.bd.a
                public boolean aI(View view) {
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

    public a cmr() {
        return qN(true);
    }

    public void dismiss() {
        if (this.mDialog != null) {
            g.b(this.mDialog, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class View$OnClickListenerC0408a implements View.OnClickListener {
        private final a iWf;
        private final b iWg;

        public View$OnClickListenerC0408a(a aVar, b bVar) {
            this.iWf = aVar;
            this.iWg = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iWg != null) {
                this.iWg.a(this.iWf);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
