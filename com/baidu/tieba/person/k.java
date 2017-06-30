package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends Dialog {
    private LinearLayout aJF;
    private Context context;
    private View mContentView;

    public k(Context context, View view) {
        super(context, 16973835);
        this.context = context;
        this.mContentView = view;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(w.j.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(w.e.transparent);
        getWindow().setDimAmount(0.3f);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(w.m.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.aJF = (LinearLayout) findViewById(w.h.root_view);
        if (this.mContentView != null) {
            this.aJF.addView(this.mContentView);
        }
        this.aJF.setOnClickListener(new l(this));
    }
}
