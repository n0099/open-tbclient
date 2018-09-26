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
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private String anc;
    private String and;
    private DialogInterface.OnCancelListener ani;
    private AlertDialog ank;
    private String gKo;
    private b gKp;
    private b gKq;
    private b gKr;
    private DialogInterface.OnKeyListener gKs;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int amY = -1;
    private int mIconResId = -1;
    private int gKm = e.f.btn_blue_bg;
    private int gKn = e.d.cp_cont_g;
    private boolean anm = false;
    private boolean ann = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a tB(int i) {
        this.mIconResId = i;
        return this;
    }

    public a tC(int i) {
        this.gKm = i;
        return this;
    }

    public a tD(int i) {
        this.gKn = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gKs = onKeyListener;
        return this;
    }

    public a tE(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.anc = this.mActivity.getResources().getString(i);
            this.gKp = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.and = this.mActivity.getResources().getString(i);
            this.gKq = bVar;
        }
        return this;
    }

    public a mx(boolean z) {
        this.ann = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) LayoutInflater.from(activity).inflate(e.h.dialog_icon_bdalert, (ViewGroup) null);
    }

    public a f(com.baidu.adp.base.e<?> eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.anm) {
            this.anm = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(e.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(e.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(e.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(e.g.message);
            Button button = (Button) this.mRootView.findViewById(e.g.yes);
            al.i(button, this.gKm);
            al.c(button, this.gKn, 3);
            Button button2 = (Button) this.mRootView.findViewById(e.g.no);
            Button button3 = (Button) this.mRootView.findViewById(e.g.cancel);
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
            if (TextUtils.isEmpty(this.anc)) {
                z = false;
            } else {
                button.setText(this.anc);
                if (this.gKp != null) {
                    button.setOnClickListener(new View$OnClickListenerC0239a(this, this.gKp));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.and)) {
                z2 = false;
            } else {
                button2.setText(this.and);
                if (this.gKq != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0239a(this, this.gKq));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gKo)) {
                z3 = false;
            } else {
                button3.setText(this.gKo);
                if (this.gKr != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0239a(this, this.gKr));
                }
                z3 = true;
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void c(com.baidu.adp.base.e<?> eVar) {
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

    private a my(boolean z) {
        if (!this.anm) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.ank != null) {
            if (z) {
                g.a(this.ank, this.mActivity);
            } else {
                this.ank.show();
            }
        } else {
            this.ank = new AlertDialog.Builder(this.mActivity).create();
            this.ank.setCanceledOnTouchOutside(this.ann);
            if (this.ani != null) {
                this.ank.setOnCancelListener(this.ani);
            }
            if (this.gKs != null) {
                this.ank.setOnKeyListener(this.gKs);
            }
            if (z) {
                g.a(this.ank, this.mActivity);
            } else {
                this.ank.show();
            }
            Window window = this.ank.getWindow();
            if (this.amY == -1) {
                this.amY = 17;
            }
            window.setGravity(this.amY);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ba.a(this.mRootView, false, new ba.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.ba.a
                public boolean H(View view) {
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

    public a buk() {
        return my(true);
    }

    public void dismiss() {
        if (this.ank != null) {
            g.b(this.ank, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0239a implements View.OnClickListener {
        private final a gKu;
        private final b gKv;

        public View$OnClickListenerC0239a(a aVar, b bVar) {
            this.gKu = aVar;
            this.gKv = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gKv != null) {
                this.gKv.a(this.gKu);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
