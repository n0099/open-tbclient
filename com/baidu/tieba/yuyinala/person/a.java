package com.baidu.tieba.yuyinala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View hzQ;
    private View hzR;
    private boolean hzT;
    private InterfaceC0926a oiO;

    /* renamed from: com.baidu.tieba.yuyinala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0926a {
        void cji();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hzT) {
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
        this.hzQ = findViewById(a.f.report);
        this.hzR = findViewById(a.f.report_cancel);
        this.hzQ.setOnClickListener(this);
        this.hzR.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.oiO != null) {
            this.oiO.cji();
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
