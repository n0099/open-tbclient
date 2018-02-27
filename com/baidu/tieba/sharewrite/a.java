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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private String aQV;
    private String aQW;
    private DialogInterface.OnCancelListener aRb;
    private AlertDialog aRc;
    private String gPK;
    private b gPL;
    private b gPM;
    private b gPN;
    private DialogInterface.OnKeyListener gPO;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aQR = -1;
    private int Ht = -1;
    private int gPI = d.f.btn_blue_bg;
    private int gPJ = d.C0141d.cp_cont_g;
    private boolean aRe = false;
    private boolean aRf = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a vg(int i) {
        this.Ht = i;
        return this;
    }

    public a vh(int i) {
        this.gPI = i;
        return this;
    }

    public a vi(int i) {
        this.gPJ = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gPO = onKeyListener;
        return this;
    }

    public a vj(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aQV = this.mActivity.getResources().getString(i);
            this.gPL = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aQW = this.mActivity.getResources().getString(i);
            this.gPM = bVar;
        }
        return this;
    }

    public a mr(boolean z) {
        this.aRf = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a g(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.aRe) {
            this.aRe = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            aj.s(button, this.gPI);
            aj.e(button, this.gPJ, 3);
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
            if (this.Ht != -1) {
                aj.c(imageView, this.Ht);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.aQV)) {
                z = false;
            } else {
                button.setText(this.aQV);
                if (this.gPL != null) {
                    button.setOnClickListener(new View$OnClickListenerC0233a(this, this.gPL));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aQW)) {
                z2 = false;
            } else {
                button2.setText(this.aQW);
                if (this.gPM != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0233a(this, this.gPM));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gPK)) {
                z3 = false;
            } else {
                button3.setText(this.gPK);
                if (this.gPN != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0233a(this, this.gPN));
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
            ((TbPageContext) eVar).getLayoutMode().aQ(skinType == 1);
            ((TbPageContext) eVar).getLayoutMode().aM(this.mRootView);
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
        layoutParams.width = g(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private a ms(boolean z) {
        if (!this.aRe) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRc != null) {
            if (z) {
                g.a(this.aRc, this.mActivity);
            } else {
                this.aRc.show();
            }
        } else {
            this.aRc = new AlertDialog.Builder(this.mActivity).create();
            this.aRc.setCanceledOnTouchOutside(this.aRf);
            if (this.aRb != null) {
                this.aRc.setOnCancelListener(this.aRb);
            }
            if (this.gPO != null) {
                this.aRc.setOnKeyListener(this.gPO);
            }
            if (z) {
                g.a(this.aRc, this.mActivity);
            } else {
                this.aRc.show();
            }
            Window window = this.aRc.getWindow();
            if (this.aQR == -1) {
                this.aQR = 17;
            }
            window.setGravity(this.aQR);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ay.a(this.mRootView, false, new ay.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.ay.a
                public boolean aP(View view) {
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

    public a bst() {
        return ms(true);
    }

    public void dismiss() {
        if (this.aRc != null) {
            g.b(this.aRc, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0233a implements View.OnClickListener {
        private final a gPQ;
        private final b gPR;

        public View$OnClickListenerC0233a(a aVar, b bVar) {
            this.gPQ = aVar;
            this.gPR = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gPR != null) {
                this.gPR.a(this.gPQ);
            }
        }
    }

    private int g(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
