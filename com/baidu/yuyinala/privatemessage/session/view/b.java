package com.baidu.yuyinala.privatemessage.session.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat;
/* loaded from: classes4.dex */
public class b extends Dialog implements View.OnClickListener {
    private TextView bKf;
    private long mPaid;
    private long mUid;
    private boolean ooP;
    private TextView oxZ;
    private TextView oya;
    private InterfaceC0939b oyb;
    private ActivityChat oyc;
    private int oyd;
    private int oye;
    private ChatUser oyf;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void onConfirm();
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.session.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0939b {
        void NH(int i);

        void eeG();

        void onCancel();
    }

    public b(ActivityChat activityChat, long j, boolean z, long j2) {
        super(activityChat, a.j.theme_manage_dialog);
        this.oyd = -1;
        this.oye = 0;
        this.oyc = activityChat;
        this.mUid = j;
        this.mPaid = j2;
        this.ooP = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.yuyin_ala_dialog_privatemessage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.bKf = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.oxZ = (TextView) findViewById(a.g.ala_clean_message);
        this.oya = (TextView) findViewById(a.g.ala_shield_user);
        this.oya.setOnClickListener(this);
        this.oxZ.setOnClickListener(this);
        this.bKf.setOnClickListener(this);
        ChatUserManager.getUserByBuid(this.oyc.getActivity(), ChatInfo.mUid, new IGetUserListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1
            @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
            public void onGetUserResult(int i, long j, ChatUser chatUser) {
                b.this.oyf = chatUser;
                if (b.this.oyf != null) {
                    b.this.oyf = IMBoxManager.getChatUserSync(b.this.oyc.getActivity(), b.this.oyf.getUk());
                    if (b.this.oyf.getBlack() == 1) {
                        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.oya.setText("接受此人消息");
                                b.this.oya.setVisibility(0);
                            }
                        });
                        b.this.oye = 0;
                        return;
                    }
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.oya.setText("不接受此人消息");
                            b.this.oya.setVisibility(0);
                        }
                    });
                    b.this.oye = 1;
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oyb != null) {
            if (view == this.oxZ) {
                a(new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.2
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oyb != null) {
                            b.this.oyb.eeG();
                        }
                    }
                }, "确定要清空聊天记录吗？");
            } else if (view == this.oya) {
                a aVar = new a() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.3
                    @Override // com.baidu.yuyinala.privatemessage.session.view.b.a
                    public void onConfirm() {
                        if (b.this.oyb != null) {
                            b.this.oyb.NH(b.this.oye);
                        }
                    }
                };
                if (this.oyf.getBlack() == 1) {
                    a(aVar, "确定接受此人消息吗？");
                } else {
                    a(aVar, "确定不接受此人消息吗？");
                }
            } else if (view == this.bKf) {
                this.oyb.onCancel();
            }
        }
    }

    private void a(final a aVar, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.oyc.getActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (aVar != null) {
                    aVar.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.oyc.getPageContext()).show();
    }

    public void a(InterfaceC0939b interfaceC0939b) {
        this.oyb = interfaceC0939b;
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.oyc);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.oyc) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
