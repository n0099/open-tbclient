package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends Dialog {
    private LinearLayout aMt;
    private Context context;
    private float frq;
    private View mContentView;

    public e(Context context) {
        super(context, 16973835);
        this.frq = 0.3f;
        this.context = context;
    }

    public e(Context context, View view) {
        super(context, 16973835);
        this.frq = 0.3f;
        this.context = context;
        this.mContentView = view;
    }

    public void ah(float f) {
        this.frq = f;
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
        getWindow().setBackgroundDrawableResource(d.C0096d.transparent);
        getWindow().setDimAmount(this.frq);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(d.k.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.aMt = (LinearLayout) findViewById(d.g.root_view);
        if (this.mContentView != null) {
            this.aMt.removeAllViews();
            this.aMt.addView(this.mContentView);
        }
        this.aMt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
    }
}
