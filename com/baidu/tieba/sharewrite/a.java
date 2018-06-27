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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private String akX;
    private String akY;
    private DialogInterface.OnCancelListener ald;
    private AlertDialog alf;
    private String gBA;
    private b gBB;
    private b gBC;
    private b gBD;
    private DialogInterface.OnKeyListener gBE;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private final ViewGroup mRootView;
    private String mTitle;
    private int akT = -1;
    private int mIconResId = -1;
    private int gBy = d.f.btn_blue_bg;
    private int gBz = d.C0142d.cp_cont_g;
    private boolean alh = false;
    private boolean ali = true;

    /* loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    public a td(int i) {
        this.mIconResId = i;
        return this;
    }

    public a te(int i) {
        this.gBy = i;
        return this;
    }

    public a tf(int i) {
        this.gBz = i;
        return this;
    }

    public a a(DialogInterface.OnKeyListener onKeyListener) {
        this.gBE = onKeyListener;
        return this;
    }

    public a tg(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.akX = this.mActivity.getResources().getString(i);
            this.gBB = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.akY = this.mActivity.getResources().getString(i);
            this.gBC = bVar;
        }
        return this;
    }

    public a mp(boolean z) {
        this.ali = z;
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
        if (!this.alh) {
            this.alh = true;
            c(eVar);
            TextView textView = (TextView) this.mRootView.findViewById(d.g.title);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(d.g.content);
            ImageView imageView = (ImageView) this.mRootView.findViewById(d.g.bdalert_icon);
            TextView textView2 = (TextView) this.mRootView.findViewById(d.g.message);
            Button button = (Button) this.mRootView.findViewById(d.g.yes);
            am.i(button, this.gBy);
            am.c(button, this.gBz, 3);
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
                am.c(imageView, this.mIconResId);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mMessage)) {
                textView2.setText(this.mMessage);
            }
            if (TextUtils.isEmpty(this.akX)) {
                z = false;
            } else {
                button.setText(this.akX);
                if (this.gBB != null) {
                    button.setOnClickListener(new View$OnClickListenerC0233a(this, this.gBB));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.akY)) {
                z2 = false;
            } else {
                button2.setText(this.akY);
                if (this.gBC != null) {
                    button2.setOnClickListener(new View$OnClickListenerC0233a(this, this.gBC));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.gBA)) {
                z3 = false;
            } else {
                button3.setText(this.gBA);
                if (this.gBD != null) {
                    button3.setOnClickListener(new View$OnClickListenerC0233a(this, this.gBD));
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

    private a mq(boolean z) {
        if (!this.alh) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.alf != null) {
            if (z) {
                g.a(this.alf, this.mActivity);
            } else {
                this.alf.show();
            }
        } else {
            this.alf = new AlertDialog.Builder(this.mActivity).create();
            this.alf.setCanceledOnTouchOutside(this.ali);
            if (this.ald != null) {
                this.alf.setOnCancelListener(this.ald);
            }
            if (this.gBE != null) {
                this.alf.setOnKeyListener(this.gBE);
            }
            if (z) {
                g.a(this.alf, this.mActivity);
            } else {
                this.alf.show();
            }
            Window window = this.alf.getWindow();
            if (this.akT == -1) {
                this.akT = 17;
            }
            window.setGravity(this.akT);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.mRootView);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bb.a(this.mRootView, false, new bb.a() { // from class: com.baidu.tieba.sharewrite.a.1
                @Override // com.baidu.tbadk.core.util.bb.a
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

    public a btb() {
        return mq(true);
    }

    public void dismiss() {
        if (this.alf != null) {
            g.b(this.alf, this.mActivity);
        }
    }

    /* renamed from: com.baidu.tieba.sharewrite.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class View$OnClickListenerC0233a implements View.OnClickListener {
        private final a gBG;
        private final b gBH;

        public View$OnClickListenerC0233a(a aVar, b bVar) {
            this.gBG = aVar;
            this.gBH = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gBH != null) {
                this.gBH.a(this.gBG);
            }
        }
    }

    private int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
