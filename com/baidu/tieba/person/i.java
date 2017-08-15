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
public class i extends Dialog {
    private LinearLayout aMd;
    private Context context;
    private View mContentView;

    public i(Context context, View view) {
        super(context, 16973835);
        this.context = context;
        this.mContentView = view;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(d.j.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(d.e.transparent);
        getWindow().setDimAmount(0.3f);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(d.m.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.aMd = (LinearLayout) findViewById(d.h.root_view);
        if (this.mContentView != null) {
            this.aMd.addView(this.mContentView);
        }
        this.aMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.dismiss();
            }
        });
    }
}
