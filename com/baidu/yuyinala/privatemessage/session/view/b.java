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
    private TextView bPL;
    private long mPaid;
    private long mUid;
    private TextView oHs;
    private TextView oHt;
    private InterfaceC0958b oHu;
    private ActivityChat oHv;
    private int oHw;
    private int oHx;
    private boolean oyk;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void onConfirm();
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.session.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0958b {
        void Oc(int i);

        void eiv();

        void onCancel();
    }

    public b(ActivityChat activityChat, long j, boolean z, long j2) {
        super(activityChat, a.i.theme_manage_dialog);
        this.oHw = -1;
        this.oHx = 0;
        this.oHv = activityChat;
        this.mUid = j;
        this.mPaid = j2;
        this.oyk = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_ala_dialog_privatemessage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bPL = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.oHs = (TextView) findViewById(a.f.ala_clean_message);
        this.oHt = (TextView) findViewById(a.f.ala_shield_user);
        this.oHt.setOnClickListener(this);
        this.oHs.setOnClickListener(this);
        this.bPL.setOnClickListener(this);
        IMBoxManager.getShield(this.oHv.getActivity(), ChatInfo.mContacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1
            @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
            public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                if (getShieldAndTopResult.getShield() == 1) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oHt.setText("接受此人消息");
                            b.this.oHt.setVisibility(0);
                        }
                    });
                    b.this.oHx = 0;
                    return;
                }
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oHt.setText("不接受此人消息");
                        b.this.oHt.setVisibility(0);
                    }
                });
                b.this.oHx = 1;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oHu != null) {
            if (view == this.oHs) {
                a(new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.2
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oHu != null) {
                            b.this.oHu.eiv();
                        }
                    }
                }, "确定要清空聊天记录吗？");
            } else if (view == this.oHt) {
                a aVar = new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.3
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oHu != null) {
                            b.this.oHu.Oc(b.this.oHx);
                        }
                    }
                };
                if (this.oHx == 0) {
                    a(aVar, "确定接受此人消息吗？");
                } else {
                    a(aVar, "确定不接受此人消息吗？");
                }
            } else if (view == this.bPL) {
                this.oHu.onCancel();
            }
        }
    }

    private void a(final a aVar, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.oHv.getActivity());
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
        bdAlertDialog.create(this.oHv.getPageContext()).show();
    }

    public void a(InterfaceC0958b interfaceC0958b) {
        this.oHu = interfaceC0958b;
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.oHv);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.oHv) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
