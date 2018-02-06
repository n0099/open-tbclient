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
    private String aRg;
    private String aRh;
    private DialogInterface.OnCancelListener aRm;
    private AlertDialog aRn;
    private String gPZ;
    private b gQa;
    private b gQb;
    private b gQc;
    private DialogInterface.OnKeyListener gQd;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int aRc = -1;
    private int Hy = -1;
    private int gPX = d.f.btn_blue_bg;
    private int gPY = d.C0140d.cp_cont_g;
    private boolean aRp = false;
    private boolean aRq = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a vf(int i) {
        this.Hy = i;
        return this;
    }

    public a vg(int i) {
        this.gPX = i;
        return this;
    }

    public a vh(int i) {
        this.gPY = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gQd = onKeyListener;
        return this;
    }

    public a vi(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.aRg = this.mActivity.getResources().getString(i);
            this.gQa = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.aRh = this.mActivity.getResources().getString(i);
            this.gQb = bVar;
        }
        return this;
    }

    public a mr(boolean z) {
        this.aRq = z;
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
        if (!this.aRp) {
            this.aRp = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            aj.s(button, this.gPX);
            aj.e(button, this.gPY, 3);
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
            if (this.Hy != -1) {
                aj.c(imageView, this.Hy);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.aRg)) {
                z = false;
            } else {
                button.setText(this.aRg);
                if (this.gQa != null) {
                    button.setOnClickListener(new View$OnClickListenerC0232a(this, this.gQa));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.aRh)) {
                z2 = false;
            } else {
                button2.setText(this.aRh);
                if (this.gQb != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0232a(this, this.gQb));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gPZ)) {
                z3 = false;
            } else {
                button3.setText(this.gPZ);
                if (this.gQc != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0232a(this, this.gQc));
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
        if (!this.aRp) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.aRn != null) {
            if (z) {
                g.a(this.aRn, this.mActivity);
            } else {
                this.aRn.show();
            }
        } else {
            this.aRn = new AlertDialog.Builder(this.mActivity).create();
            this.aRn.setCanceledOnTouchOutside(this.aRq);
            if (this.aRm != null) {
                this.aRn.setOnCancelListener(this.aRm);
            }
            if (this.gQd != null) {
                this.aRn.setOnKeyListener(this.gQd);
            }
            if (z) {
                g.a(this.aRn, this.mActivity);
            } else {
                this.aRn.show();
            }
            Window window = this.aRn.getWindow();
            if (this.aRc == -1) {
                this.aRc = 17;
            }
            window.setGravity(this.aRc);
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

    public a bsu() {
        return ms(true);
    }

    public void dismiss() {
        if (this.aRn != null) {
            g.b(this.aRn, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0232a implements View.OnClickListener {
        private final a gQf;
        private final b gQg;

        public View$OnClickListenerC0232a(a aVar, b bVar) {
            this.gQf = aVar;
            this.gQg = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gQg != null) {
                this.gQg.a(this.gQf);
            }
        }
    }

    private int g(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
