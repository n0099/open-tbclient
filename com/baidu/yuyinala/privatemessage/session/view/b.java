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
/* loaded from: classes10.dex */
public class b extends Dialog implements View.OnClickListener {
    private TextView bUf;
    private long mPaid;
    private long mUid;
    private boolean oQF;
    private TextView oZJ;
    private TextView oZK;
    private InterfaceC0976b oZL;
    private ActivityChat oZM;
    private int oZN;
    private int oZO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a {
        void onConfirm();
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.session.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0976b {
        void NK(int i);

        void ekx();

        void onCancel();
    }

    public b(ActivityChat activityChat, long j, boolean z, long j2) {
        super(activityChat, a.i.theme_manage_dialog);
        this.oZN = -1;
        this.oZO = 0;
        this.oZM = activityChat;
        this.mUid = j;
        this.mPaid = j2;
        this.oQF = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_ala_dialog_privatemessage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bUf = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.oZJ = (TextView) findViewById(a.f.ala_clean_message);
        this.oZK = (TextView) findViewById(a.f.ala_shield_user);
        this.oZK.setOnClickListener(this);
        this.oZJ.setOnClickListener(this);
        this.bUf.setOnClickListener(this);
        IMBoxManager.getShield(this.oZM.getActivity(), ChatInfo.mContacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1
            @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
            public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                if (getShieldAndTopResult.getShield() == 1) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oZK.setText("接受此人消息");
                            b.this.oZK.setVisibility(0);
                        }
                    });
                    b.this.oZO = 0;
                    return;
                }
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oZK.setText("不接受此人消息");
                        b.this.oZK.setVisibility(0);
                    }
                });
                b.this.oZO = 1;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oZL != null) {
            if (view == this.oZJ) {
                a(new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.2
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oZL != null) {
                            b.this.oZL.ekx();
                        }
                    }
                }, "确定要清空聊天记录吗？");
            } else if (view == this.oZK) {
                a aVar = new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.3
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oZL != null) {
                            b.this.oZL.NK(b.this.oZO);
                        }
                    }
                };
                if (this.oZO == 0) {
                    a(aVar, "确定接受此人消息吗？");
                } else {
                    a(aVar, "确定不接受此人消息吗？");
                }
            } else if (view == this.bUf) {
                this.oZL.onCancel();
            }
        }
    }

    private void a(final a aVar, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.oZM.getActivity());
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
        bdAlertDialog.create(this.oZM.getPageContext()).show();
    }

    public void a(InterfaceC0976b interfaceC0976b) {
        this.oZL = interfaceC0976b;
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.oZM);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.oZM) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
