package com.baidu.tieba.yuyinala.liveroom.l;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aGk;
    private TextView bTh;
    private boolean bns;
    private TextView hBd;
    private TextView hBe;
    private TextView hBf;
    private View hBg;
    private View hBh;
    private PersonUserData hBi;
    private TbPageContext mPageContext;
    private b ooY;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0929a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void IG(String str);

        void IH(String str);

        void II(String str);

        void IJ(String str);

        void IK(String str);

        void IL(String str);

        void onCancel();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.i.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hBd = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hBg = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBe = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hBh = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBf = (TextView) findViewById(a.f.ala_person_admin);
        this.bTh = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hBd.setOnClickListener(this);
        this.hBe.setOnClickListener(this);
        this.hBf.setOnClickListener(this);
        this.bTh.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.ooY != null) {
            if (view == this.hBd) {
                if (this.hBi != null && this.hBi.user_info != null) {
                    if (ckg()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    if (a.this.hBi.mYuyinBanMangerData != null) {
                                        a.this.hBi.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.ooY.II(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hBi.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    if (a.this.hBi.mYuyinBanMangerData != null) {
                                        a.this.hBi.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.ooY.IG(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hBi.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hBe) {
                if (this.hBi != null && this.hBi.user_info != null) {
                    if (ckf()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    if (a.this.hBi.mYuyinBanMangerData != null) {
                                        a.this.hBi.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.ooY.IJ(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hBi.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    if (a.this.hBi.mYuyinBanMangerData != null) {
                                        a.this.hBi.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.ooY.IH(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hBi.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hBf) {
                if (this.hBi != null && this.hBi.mYuyinBanMangerData != null) {
                    if (ckh()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    if (a.this.hBi.mYuyinBanMangerData != null) {
                                        a.this.hBi.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.ooY.IK(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hBi.user_info.getNameShow()));
                    } else if (cki()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBi != null && a.this.hBi.user_info != null) {
                                    if (a.this.hBi.mYuyinBanMangerData != null) {
                                        a.this.hBi.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.ooY.IL(a.this.hBi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hBi.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bTh) {
                this.ooY.onCancel();
            }
        }
    }

    private void a(final InterfaceC0929a interfaceC0929a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0929a != null) {
                    interfaceC0929a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.hBi = personUserData;
        this.bns = z;
        this.aGk = str;
        if (ckk() || ckl()) {
            xm(8);
            xn(8);
        } else if (ckf()) {
            xm(8);
            this.hBe.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckg()) {
            xm(0);
            this.hBd.setText(a.h.ala_person_relieve_forbidden_this);
            this.hBe.setText(a.h.ala_person_forbid_forever);
        } else {
            xm(0);
            this.hBd.setText(a.h.ala_person_forbid_this);
            this.hBe.setText(a.h.ala_person_forbid_forever);
        }
        if (cke()) {
            this.hBf.setVisibility(8);
            this.hBh.setVisibility(8);
        } else if (cki()) {
            this.hBf.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (ckh()) {
            this.hBf.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hBf.setVisibility(8);
            this.hBh.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.ooY = bVar;
    }

    private boolean cke() {
        return (this.hBi == null || this.hBi.mYuyinBanMangerData == null || this.hBi.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean ckf() {
        return (this.hBi == null || this.hBi.mYuyinBanMangerData == null || this.hBi.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean ckg() {
        return (this.hBi == null || this.hBi.mYuyinBanMangerData == null || this.hBi.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean ckh() {
        return this.hBi != null && this.hBi.mYuyinBanMangerData != null && this.hBi.mYuyinBanMangerData.userIndentity == 1 && this.hBi.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean cki() {
        return this.hBi != null && this.hBi.mYuyinBanMangerData != null && this.hBi.mYuyinBanMangerData.userIndentity == 1 && this.hBi.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean ckk() {
        return (this.hBi == null || this.hBi.mYuyinBanMangerData == null || this.hBi.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean ckl() {
        return (this.hBi == null || this.hBi.mYuyinBanMangerData == null || this.hBi.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void xm(int i) {
        this.hBd.setVisibility(i);
        this.hBg.setVisibility(i);
    }

    private void xn(int i) {
        this.hBe.setVisibility(i);
        this.hBh.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
