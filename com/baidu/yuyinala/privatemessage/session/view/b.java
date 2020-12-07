package com.baidu.yuyinala.privatemessage.session.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat;
/* loaded from: classes4.dex */
public class b extends Dialog implements View.OnClickListener {
    private TextView bTh;
    private long mPaid;
    private long mUid;
    private boolean oOU;
    private TextView oYc;
    private TextView oYd;
    private InterfaceC0978b oYe;
    private ActivityChat oYf;
    private int oYg;
    private int oYh;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void onConfirm();
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.session.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0978b {
        void PD(int i);

        void eoj();

        void onCancel();
    }

    public b(ActivityChat activityChat, long j, boolean z, long j2) {
        super(activityChat, a.i.theme_manage_dialog);
        this.oYg = -1;
        this.oYh = 0;
        this.oYf = activityChat;
        this.mUid = j;
        this.mPaid = j2;
        this.oOU = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_ala_dialog_privatemessage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bTh = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.oYc = (TextView) findViewById(a.f.ala_clean_message);
        this.oYd = (TextView) findViewById(a.f.ala_shield_user);
        this.oYd.setOnClickListener(this);
        this.oYc.setOnClickListener(this);
        this.bTh.setOnClickListener(this);
        IMBoxManager.getShield(this.oYf.getActivity(), ChatInfo.mContacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1
            @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
            public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                if (getShieldAndTopResult.getShield() == 1) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oYd.setText("接受此人消息");
                            b.this.oYd.setVisibility(0);
                        }
                    });
                    b.this.oYh = 0;
                    return;
                }
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oYd.setText("不接受此人消息");
                        b.this.oYd.setVisibility(0);
                    }
                });
                b.this.oYh = 1;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oYe != null) {
            if (view == this.oYc) {
                a(new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.2
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oYe != null) {
                            b.this.oYe.eoj();
                        }
                    }
                }, "确定要清空聊天记录吗？");
            } else if (view == this.oYd) {
                a aVar = new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.3
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oYe != null) {
                            b.this.oYe.PD(b.this.oYh);
                        }
                    }
                };
                if (this.oYh == 0) {
                    a(aVar, "确定接受此人消息吗？");
                } else {
                    a(aVar, "确定不接受此人消息吗？");
                }
            } else if (view == this.bTh) {
                this.oYe.onCancel();
            }
        }
    }

    private void a(final a aVar, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.oYf.getActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (aVar != null) {
                    aVar.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.oYf.getPageContext()).show();
    }

    public void a(InterfaceC0978b interfaceC0978b) {
        this.oYe = interfaceC0978b;
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.oYf);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.oYf) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
