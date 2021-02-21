package com.baidu.tieba.yuyinala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View hVs;
    private View hVt;
    private boolean hVv;
    private InterfaceC0949a oNc;

    /* renamed from: com.baidu.tieba.yuyinala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0949a {
        void cmB();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hVv) {
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
        this.hVs = findViewById(a.f.report);
        this.hVt = findViewById(a.f.report_cancel);
        this.hVs.setOnClickListener(this);
        this.hVt.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.oNc != null) {
            this.oNc.cmB();
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
