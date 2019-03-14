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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private DialogInterface.OnCancelListener bEB;
    private AlertDialog bED;
    private String bEu;
    private String bEv;
    private String ivZ;
    private b iwa;
    private b iwb;
    private b iwc;
    private DialogInterface.OnKeyListener iwd;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int bEq = -1;
    private int mIconResId = -1;
    private int ivX = d.f.btn_blue_bg;
    private int ivY = d.C0277d.cp_cont_g;
    private boolean bEF = false;
    private boolean bEG = true;

    /* loaded from: classes6.dex */
    public interface b {
        void a(a aVar);
    }

    public a yT(int i) {
        this.mIconResId = i;
        return this;
    }

    public a yU(int i) {
        this.ivX = i;
        return this;
    }

    public a yV(int i) {
        this.ivY = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.iwd = onKeyListener;
        return this;
    }

    public a yW(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEu = this.mActivity.getResources().getString(i);
            this.iwa = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.bEv = this.mActivity.getResources().getString(i);
            this.iwb = bVar;
        }
        return this;
    }

    public a pG(boolean z) {
        this.bEG = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a f(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.bEF) {
            this.bEF = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            al.k(button, this.ivX);
            al.d(button, this.ivY, 3);
            Button button2 = (Button) this.mRootView.findViewById(d.g.no);
            Button button3 = (Button) this.mRootView.findViewById(d.g.cancel);
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
                al.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.bEu)) {
                z = false;
            } else {
                button.setText(this.bEu);
                if (this.iwa != null) {
                    button.setOnClickListener(new View$OnClickListenerC0384a(this, this.iwa));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.bEv)) {
                z2 = false;
            } else {
                button2.setText(this.bEv);
                if (this.iwb != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0384a(this, this.iwb));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.ivZ)) {
                z3 = false;
            } else {
                button3.setText(this.ivZ);
                if (this.iwc != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0384a(this, this.iwc));
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

    private a pH(boolean z) {
        if (!this.bEF) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.bED != null) {
            if (z) {
                g.a(this.bED, this.mActivity);
            } else {
                this.bED.show();
            }
        } else {
            this.bED = new AlertDialog.Builder(this.mActivity).create();
            this.bED.setCanceledOnTouchOutside(this.bEG);
            if (this.bEB != null) {
                this.bED.setOnCancelListener(this.bEB);
            }
            if (this.iwd != null) {
                this.bED.setOnKeyListener(this.iwd);
            }
            if (z) {
                g.a(this.bED, this.mActivity);
            } else {
                this.bED.show();
            }
            Window window = this.bED.getWindow();
            if (this.bEq == -1) {
                this.bEq = 17;
            }
            window.setGravity(this.bEq);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bc.a(this.mRootView, false, new bc.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.bc.a
                public boolean aA(View view) {
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

    public a cbe() {
        return pH(true);
    }

    public void dismiss() {
        if (this.bED != null) {
            g.b(this.bED, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class View$OnClickListenerC0384a implements View.OnClickListener {
        private final a iwf;
        private final b iwg;

        public View$OnClickListenerC0384a(a aVar, b bVar) {
            this.iwf = aVar;
            this.iwg = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.iwg != null) {
                this.iwg.a(this.iwf);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
