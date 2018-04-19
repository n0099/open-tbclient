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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private AlertDialog acB;
    private String act;
    private String acu;
    private DialogInterface.OnCancelListener acz;
    private String glg;
    private b glh;
    private b gli;
    private b glj;
    private DialogInterface.OnKeyListener glk;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int acp = -1;
    private int mIconResId = -1;
    private int gle = d.f.btn_blue_bg;
    private int glf = d.C0126d.cp_cont_g;
    private boolean acD = false;
    private boolean acE = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a sI(int i) {
        this.mIconResId = i;
        return this;
    }

    public a sJ(int i) {
        this.gle = i;
        return this;
    }

    public a sK(int i) {
        this.glf = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.glk = onKeyListener;
        return this;
    }

    public a sL(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.act = this.mActivity.getResources().getString(i);
            this.glh = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.acu = this.mActivity.getResources().getString(i);
            this.gli = bVar;
        }
        return this;
    }

    public a lX(boolean z) {
        this.acE = z;
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
        if (!this.acD) {
            this.acD = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            ak.i(button, this.gle);
            ak.c(button, this.glf, 3);
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
                ak.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.act)) {
                z = false;
            } else {
                button.setText(this.act);
                if (this.glh != null) {
                    button.setOnClickListener(new View$OnClickListenerC0214a(this, this.glh));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.acu)) {
                z2 = false;
            } else {
                button2.setText(this.acu);
                if (this.gli != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0214a(this, this.gli));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.glg)) {
                z3 = false;
            } else {
                button3.setText(this.glg);
                if (this.glj != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0214a(this, this.glj));
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
            ((TbPageContext) eVar).getLayoutMode().u(this.mRootView);
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

    private a lY(boolean z) {
        if (!this.acD) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.acB != null) {
            if (z) {
                g.a(this.acB, this.mActivity);
            } else {
                this.acB.show();
            }
        } else {
            this.acB = new AlertDialog.Builder(this.mActivity).create();
            this.acB.setCanceledOnTouchOutside(this.acE);
            if (this.acz != null) {
                this.acB.setOnCancelListener(this.acz);
            }
            if (this.glk != null) {
                this.acB.setOnKeyListener(this.glk);
            }
            if (z) {
                g.a(this.acB, this.mActivity);
            } else {
                this.acB.show();
            }
            Window window = this.acB.getWindow();
            if (this.acp == -1) {
                this.acp = 17;
            }
            window.setGravity(this.acp);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            az.a(this.mRootView, false, new az.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.az.a
                public boolean x(View view2) {
                    if (view2 instanceof EditText) {
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

    public a bnD() {
        return lY(true);
    }

    public void dismiss() {
        if (this.acB != null) {
            g.b(this.acB, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0214a implements View.OnClickListener {
        private final a glm;
        private final b gln;

        public View$OnClickListenerC0214a(a aVar, b bVar) {
            this.glm = aVar;
            this.gln = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.gln != null) {
                this.gln.a(this.glm);
            }
        }
    }

    private int g(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
