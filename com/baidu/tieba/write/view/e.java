package com.baidu.tieba.write.view;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private DialogInterface.OnCancelListener WA;
    private AlertDialog WB;
    private String Wt;
    private String Wu;
    private String Wv;
    private String doI;
    private b doJ;
    private b doK;
    private b doL;
    private DialogInterface.OnKeyListener doM;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Ws = -1;
    private int Xg = -1;
    private int doG = i.e.btn_blue_bg;
    private int doH = i.c.cp_cont_g;
    private boolean WD = false;
    private boolean WE = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e mh(int i) {
        this.Xg = i;
        return this;
    }

    public e mi(int i) {
        this.doG = i;
        return this;
    }

    public e mj(int i) {
        this.doH = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.doM = onKeyListener;
        return this;
    }

    public e mk(int i) {
        if (this.mActivity != null) {
            this.Wt = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wu = this.mActivity.getResources().getString(i);
            this.doJ = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wv = this.mActivity.getResources().getString(i);
            this.doK = bVar;
        }
        return this;
    }

    public e gY(boolean z) {
        this.WE = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e f(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.WD) {
            this.WD = true;
            c(hVar);
            TextView textView = (TextView) this.mRootView.findViewById(i.f.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(i.f.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(i.f.message);
            Button button = (Button) this.mRootView.findViewById(i.f.yes);
            an.i((View) button, this.doG);
            an.b(button, this.doH, 3);
            Button button2 = (Button) this.mRootView.findViewById(i.f.no);
            Button button3 = (Button) this.mRootView.findViewById(i.f.cancel);
            if (!TextUtils.isEmpty(this.mTitle)) {
                textView.setText(this.mTitle);
            } else {
                textView.setVisibility(8);
            }
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            }
            if (this.Xg != -1) {
                an.c(imageView, this.Xg);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.Wt)) {
                textView2.setText(this.Wt);
            }
            if (TextUtils.isEmpty(this.Wu)) {
                z = false;
            } else {
                button.setText(this.Wu);
                if (this.doJ != null) {
                    button.setOnClickListener(new a(this, this.doJ));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wv)) {
                z2 = false;
            } else {
                button2.setText(this.Wv);
                if (this.doK != null) {
                    button2.setOnClickListener(new a(this, this.doK));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.doI)) {
                z3 = false;
            } else {
                button3.setText(this.doI);
                if (this.doL != null) {
                    button3.setOnClickListener(new a(this, this.doL));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ad(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().k(this.mRootView);
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
        layoutParams.width = c(this.mActivity, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    private e gZ(boolean z) {
        if (!this.WD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WB != null) {
            if (z) {
                com.baidu.adp.lib.g.j.a(this.WB, this.mActivity);
            } else {
                this.WB.show();
            }
        } else {
            this.WB = new AlertDialog.Builder(this.mActivity).create();
            this.WB.setCanceledOnTouchOutside(this.WE);
            if (this.WA != null) {
                this.WB.setOnCancelListener(this.WA);
            }
            if (this.doM != null) {
                this.WB.setOnKeyListener(this.doM);
            }
            if (z) {
                com.baidu.adp.lib.g.j.a(this.WB, this.mActivity);
            } else {
                this.WB.show();
            }
            Window window = this.WB.getWindow();
            if (this.Ws == -1) {
                this.Ws = 17;
            }
            window.setGravity(this.Ws);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bd.a(this.mRootView, false, (bd.a) new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e aDf() {
        return gZ(true);
    }

    public void dismiss() {
        if (this.WB != null) {
            com.baidu.adp.lib.g.j.b(this.WB, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e doO;
        private final b doP;

        public a(e eVar, b bVar) {
            this.doO = eVar;
            this.doP = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.doP != null) {
                this.doP.a(this.doO);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
