package com.baidu.tieba.yuyinala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View hQJ;
    private View hQK;
    private boolean hQM;
    private InterfaceC0943a oCt;

    /* renamed from: com.baidu.tieba.yuyinala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0943a {
        void clw();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hQM) {
            resize();
        } else {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.context);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
            getWindow().setGravity(81);
            getWindow().setAttributes(attributes);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hQJ = findViewById(a.f.report);
        this.hQK = findViewById(a.f.report_cancel);
        this.hQJ.setOnClickListener(this);
        this.hQK.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.oCt != null) {
            this.oCt.clw();
        }
        dismiss();
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
