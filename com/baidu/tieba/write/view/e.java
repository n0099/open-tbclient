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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private String Wq;
    private String Wr;
    private String Ws;
    private DialogInterface.OnCancelListener Wx;
    private AlertDialog Wy;
    private String dna;
    private b dnb;
    private b dnc;
    private b dnd;
    private DialogInterface.OnKeyListener dne;
    protected final Activity mActivity;
    private View mContentView;
    private final ViewGroup mRootView;
    private String mTitle;
    private int Wp = -1;
    private int Xd = -1;
    private int dmY = i.e.btn_blue_bg;
    private int dmZ = i.c.cp_cont_g;
    private boolean WA = false;
    private boolean WB = true;

    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar);
    }

    public e lT(int i) {
        this.Xd = i;
        return this;
    }

    public e lU(int i) {
        this.dmY = i;
        return this;
    }

    public e lV(int i) {
        this.dmZ = i;
        return this;
    }

    public e a(DialogInterface.OnKeyListener onKeyListener) {
        this.dne = onKeyListener;
        return this;
    }

    public e lW(int i) {
        if (this.mActivity != null) {
            this.Wq = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public e a(int i, b bVar) {
        if (this.mActivity != null) {
            this.Wr = this.mActivity.getResources().getString(i);
            this.dnb = bVar;
        }
        return this;
    }

    public e b(int i, b bVar) {
        if (this.mActivity != null) {
            this.Ws = this.mActivity.getResources().getString(i);
            this.dnc = bVar;
        }
        return this;
    }

    public e gV(boolean z) {
        this.WB = z;
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
        if (!this.WA) {
            this.WA = true;
            c(hVar);
            TextView textView = (TextView) this.mRootView.findViewById(i.f.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(i.f.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(i.f.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(i.f.message);
            Button button = (Button) this.mRootView.findViewById(i.f.yes);
            an.i((View) button, this.dmY);
            an.b(button, this.dmZ, 3);
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
            if (this.Xd != -1) {
                an.c(imageView, this.Xd);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.Wq)) {
                textView2.setText(this.Wq);
            }
            if (TextUtils.isEmpty(this.Wr)) {
                z = false;
            } else {
                button.setText(this.Wr);
                if (this.dnb != null) {
                    button.setOnClickListener(new a(this, this.dnb));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.Ws)) {
                z2 = false;
            } else {
                button2.setText(this.Ws);
                if (this.dnc != null) {
                    button2.setOnClickListener(new a(this, this.dnc));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.dna)) {
                z3 = false;
            } else {
                button3.setText(this.dna);
                if (this.dnd != null) {
                    button3.setOnClickListener(new a(this, this.dnd));
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

    private e gW(boolean z) {
        if (!this.WA) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.Wy != null) {
            if (z) {
                j.a(this.Wy, this.mActivity);
            } else {
                this.Wy.show();
            }
        } else {
            this.Wy = new AlertDialog.Builder(this.mActivity).create();
            this.Wy.setCanceledOnTouchOutside(this.WB);
            if (this.Wx != null) {
                this.Wy.setOnCancelListener(this.Wx);
            }
            if (this.dne != null) {
                this.Wy.setOnKeyListener(this.dne);
            }
            if (z) {
                j.a(this.Wy, this.mActivity);
            } else {
                this.Wy.show();
            }
            Window window = this.Wy.getWindow();
            if (this.Wp == -1) {
                this.Wp = 17;
            }
            window.setGravity(this.Wp);
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

    public e aCp() {
        return gW(true);
    }

    public void dismiss() {
        if (this.Wy != null) {
            j.b(this.Wy, this.mActivity);
        }
    }

    /* loaded from: classes.dex */
    private class a implements View.OnClickListener {
        private final e dng;
        private final b dnh;

        public a(e eVar, b bVar) {
            this.dng = eVar;
            this.dnh = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dnh != null) {
                this.dnh.a(this.dng);
            }
        }
    }

    private int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
