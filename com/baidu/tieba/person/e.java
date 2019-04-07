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
    private LinearLayout bFy;
    private float bFz;
    private Context context;
    private View mContentView;

    public e(Context context, View view) {
        super(context, 16973835);
        this.bFz = 0.3f;
        this.context = context;
        this.mContentView = view;
    }

    public void al(float f) {
        this.bFz = f;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.mContentView = view;
        if (this.bFy != null) {
            this.bFy.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.bFy.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.bFy.addView(this.mContentView);
        }
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
        getWindow().setBackgroundDrawableResource(d.C0277d.transparent);
        getWindow().setDimAmount(this.bFz);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(d.k.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bFy = (LinearLayout) findViewById(d.g.root_view);
        this.bFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        if (this.mContentView != null) {
            this.bFy.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.bFy.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.bFy.addView(this.mContentView);
        }
    }
}
