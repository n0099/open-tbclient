package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends Dialog {
    private LinearLayout axG;
    private Context context;
    private float dfN;
    private View mContentView;

    public e(Context context) {
        super(context, 16973835);
        this.dfN = 0.3f;
        this.context = context;
    }

    public e(Context context, View view) {
        super(context, 16973835);
        this.dfN = 0.3f;
        this.context = context;
        this.mContentView = view;
    }

    public void aB(float f) {
        this.dfN = f;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(d.h.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(d.C0140d.transparent);
        getWindow().setDimAmount(this.dfN);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(d.k.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.axG = (LinearLayout) findViewById(d.g.root_view);
        this.axG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        if (this.mContentView != null) {
            this.axG.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.axG.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.axG.addView(this.mContentView);
        }
    }
}
