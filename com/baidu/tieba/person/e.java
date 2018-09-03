package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class e extends Dialog {
    private LinearLayout axD;
    private Context context;
    private float dfL;
    private View mContentView;

    public e(Context context) {
        super(context, 16973835);
        this.dfL = 0.3f;
        this.context = context;
    }

    public e(Context context, View view) {
        super(context, 16973835);
        this.dfL = 0.3f;
        this.context = context;
        this.mContentView = view;
    }

    public void aA(float f) {
        this.dfL = f;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(f.h.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(f.d.transparent);
        getWindow().setDimAmount(this.dfL);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(f.k.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.axD = (LinearLayout) findViewById(f.g.root_view);
        this.axD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        if (this.mContentView != null) {
            this.axD.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.axD.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.axD.addView(this.mContentView);
        }
    }
}
