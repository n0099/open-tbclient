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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private DialogInterface.OnCancelListener akE;
    private AlertDialog akG;
    private String aky;
    private String akz;
    private String gxH;
    private b gxI;
    private b gxJ;
    private b gxK;
    private DialogInterface.OnKeyListener gxL;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aku = -1;
    private int mIconResId = -1;
    private int gxF = d.f.btn_blue_bg;
    private int gxG = d.C0141d.cp_cont_g;
    private boolean akI = false;
    private boolean akJ = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a sT(int i) {
        this.mIconResId = i;
        return this;
    }

    public a sU(int i) {
        this.gxF = i;
        return this;
    }

    public a sV(int i) {
        this.gxG = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gxL = onKeyListener;
        return this;
    }

    public a sW(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aky = this.mActivity.getResources().getString(i);
            this.gxI = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.akz = this.mActivity.getResources().getString(i);
            this.gxJ = bVar;
        }
        return this;
    }

    public a me(boolean z) {
        this.akJ = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(d.i.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a g(e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.akI) {
            this.akI = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            al.i(button, this.gxF);
            al.c(button, this.gxG, 3);
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
            if (TextUtils.isEmpty(this.aky)) {
                z = false;
            } else {
                button.setText(this.aky);
                if (this.gxI != null) {
                    button.setOnClickListener(new View$OnClickListenerC0231a(this, this.gxI));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.akz)) {
                z2 = false;
            } else {
                button2.setText(this.akz);
                if (this.gxJ != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0231a(this, this.gxJ));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gxH)) {
                z3 = false;
            } else {
                button3.setText(this.gxH);
                if (this.gxK != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0231a(this, this.gxK));
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

    private a mf(boolean z) {
        if (!this.akI) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.akG != null) {
            if (z) {
                g.a(this.akG, this.mActivity);
            } else {
                this.akG.show();
            }
        } else {
            this.akG = new AlertDialog.Builder(this.mActivity).create();
            this.akG.setCanceledOnTouchOutside(this.akJ);
            if (this.akE != null) {
                this.akG.setOnCancelListener(this.akE);
            }
            if (this.gxL != null) {
                this.akG.setOnKeyListener(this.gxL);
            }
            if (z) {
                g.a(this.akG, this.mActivity);
            } else {
                this.akG.show();
            }
            Window window = this.akG.getWindow();
            if (this.aku == -1) {
                this.aku = 17;
            }
            window.setGravity(this.aku);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
                public boolean x(View view) {
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

    public a bsB() {
        return mf(true);
    }

    public void dismiss() {
        if (this.akG != null) {
            g.b(this.akG, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0231a implements View.OnClickListener {
        private final a gxN;
        private final b gxO;

        public View$OnClickListenerC0231a(a aVar, b bVar) {
            this.gxN = aVar;
            this.gxO = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gxO != null) {
                this.gxO.a(this.gxN);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
