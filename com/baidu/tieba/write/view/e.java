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
import com.baidu.adp.base.h;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private DialogInterface.OnCancelListener WD;
    private AlertDialog WE;
    private String Ww;
    private String Wx;
    private String Wy;
    private b dbA;
    private b dbB;
    private b dbC;
    private DialogInterface.OnKeyListener dbD;
    private String dbz;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Wv = -1;
    private int Xj = -1;
    private int dbx = i.e.btn_blue_bg;
    private int dby = i.c.cp_cont_g;
    private boolean WG = false;
    private boolean WH = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e lc(int i) {
        this.Xj = i;
        return this;
    }

    public e ld(int i) {
        this.dbx = i;
        return this;
    }

    public e le(int i) {
        this.dby = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.dbD = onKeyListener;
        return this;
    }

    public e lf(int i) {
        if (this.mActivity != null) {
            this.Ww = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wx = this.mActivity.getResources().getString(i);
            this.dbA = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wy = this.mActivity.getResources().getString(i);
            this.dbB = bVar;
        }
        return this;
    }

    public e gG(boolean z) {
        this.WH = z;
        return this;
    }

    public e(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(i.g.dialog_icon_bdalert, (ViewGroup) null);
    }

    public e f(h<?> hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.WG) {
            this.WG = true;
            c(hVar);
            TextView textView = (TextView) this.mRootView.findViewById(i.f.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(i.f.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(i.f.message);
            Button button = (Button) this.mRootView.findViewById(i.f.yes);
            al.h((View) button, this.dbx);
            al.b(button, this.dby, 3);
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
            if (this.Xj != -1) {
                al.c(imageView, this.Xj);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.Ww)) {
                textView2.setText(this.Ww);
            }
            if (TextUtils.isEmpty(this.Wx)) {
                z = false;
            } else {
                button.setText(this.Wx);
                if (this.dbA != null) {
                    button.setOnClickListener(new a(this, this.dbA));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Wy)) {
                z2 = false;
            } else {
                button2.setText(this.Wy);
                if (this.dbB != null) {
                    button2.setOnClickListener(new a(this, this.dbB));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.dbz)) {
                z3 = false;
            } else {
                button3.setText(this.dbz);
                if (this.dbC != null) {
                    button3.setOnClickListener(new a(this, this.dbC));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(h<?> hVar) {
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

    private e gH(boolean z) {
        if (!this.WG) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.WE != null) {
            if (z) {
                j.a(this.WE, this.mActivity);
            } else {
                this.WE.show();
            }
        } else {
            this.WE = new AlertDialog.Builder(this.mActivity).create();
            this.WE.setCanceledOnTouchOutside(this.WH);
            if (this.WD != null) {
                this.WE.setOnCancelListener(this.WD);
            }
            if (this.dbD != null) {
                this.WE.setOnKeyListener(this.dbD);
            }
            if (z) {
                j.a(this.WE, this.mActivity);
            } else {
                this.WE.show();
            }
            Window window = this.WE.getWindow();
            if (this.Wv == -1) {
                this.Wv = 17;
            }
            window.setGravity(this.Wv);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bb.a(this.mRootView, false, (bb.a) new f(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public e aza() {
        return gH(true);
    }

    public void dismiss() {
        if (this.WE != null) {
            j.b(this.WE, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e dbF;
        private final b dbG;

        public a(e eVar, b bVar) {
            this.dbF = eVar;
            this.dbG = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dbG != null) {
                this.dbG.a(this.dbF);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
