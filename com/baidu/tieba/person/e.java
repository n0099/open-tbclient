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
    private LinearLayout aMU;
    private Context context;
    private float fCn;
    private View mContentView;

    public e(Context context) {
        super(context, 16973835);
        this.fCn = 0.3f;
        this.context = context;
    }

    public e(Context context, View view2) {
        super(context, 16973835);
        this.fCn = 0.3f;
        this.context = context;
        this.mContentView = view2;
    }

    public void aq(float f) {
        this.fCn = f;
    }

    @Override // android.app.Dialog
    public void setContentView(View view2) {
        this.mContentView = view2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(d.i.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(d.C0126d.transparent);
        getWindow().setDimAmount(this.fCn);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(d.l.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.aMU = (LinearLayout) findViewById(d.g.root_view);
        this.aMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.this.dismiss();
            }
        });
        if (this.mContentView != null) {
            this.aMU.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.aMU.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.aMU.addView(this.mContentView);
        }
    }
}
