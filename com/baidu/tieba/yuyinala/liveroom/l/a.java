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
    private TextView hBb;
    private TextView hBc;
    private TextView hBd;
    private View hBe;
    private View hBf;
    private PersonUserData hBg;
    private TbPageContext mPageContext;
    private b ooW;

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
        this.hBb = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hBe = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBc = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hBf = findViewById(a.f.ala_person_forbid_this_divider);
        this.hBd = (TextView) findViewById(a.f.ala_person_admin);
        this.bTh = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hBb.setOnClickListener(this);
        this.hBc.setOnClickListener(this);
        this.hBd.setOnClickListener(this);
        this.bTh.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.ooW != null) {
            if (view == this.hBb) {
                if (this.hBg != null && this.hBg.user_info != null) {
                    if (ckf()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    if (a.this.hBg.mYuyinBanMangerData != null) {
                                        a.this.hBg.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.ooW.II(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hBg.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    if (a.this.hBg.mYuyinBanMangerData != null) {
                                        a.this.hBg.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.ooW.IG(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hBg.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hBc) {
                if (this.hBg != null && this.hBg.user_info != null) {
                    if (cke()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    if (a.this.hBg.mYuyinBanMangerData != null) {
                                        a.this.hBg.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.ooW.IJ(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hBg.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    if (a.this.hBg.mYuyinBanMangerData != null) {
                                        a.this.hBg.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.ooW.IH(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hBg.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hBd) {
                if (this.hBg != null && this.hBg.mYuyinBanMangerData != null) {
                    if (ckg()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    if (a.this.hBg.mYuyinBanMangerData != null) {
                                        a.this.hBg.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.ooW.IK(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hBg.user_info.getNameShow()));
                    } else if (ckh()) {
                        a(new InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0929a
                            public void onConfirm() {
                                if (a.this.hBg != null && a.this.hBg.user_info != null) {
                                    if (a.this.hBg.mYuyinBanMangerData != null) {
                                        a.this.hBg.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.ooW.IL(a.this.hBg.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hBg.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bTh) {
                this.ooW.onCancel();
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
        this.hBg = personUserData;
        this.bns = z;
        this.aGk = str;
        if (ckj() || ckk()) {
            xm(8);
            xn(8);
        } else if (cke()) {
            xm(8);
            this.hBc.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckf()) {
            xm(0);
            this.hBb.setText(a.h.ala_person_relieve_forbidden_this);
            this.hBc.setText(a.h.ala_person_forbid_forever);
        } else {
            xm(0);
            this.hBb.setText(a.h.ala_person_forbid_this);
            this.hBc.setText(a.h.ala_person_forbid_forever);
        }
        if (ckd()) {
            this.hBd.setVisibility(8);
            this.hBf.setVisibility(8);
        } else if (ckh()) {
            this.hBd.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (ckg()) {
            this.hBd.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hBd.setVisibility(8);
            this.hBf.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.ooW = bVar;
    }

    private boolean ckd() {
        return (this.hBg == null || this.hBg.mYuyinBanMangerData == null || this.hBg.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean cke() {
        return (this.hBg == null || this.hBg.mYuyinBanMangerData == null || this.hBg.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean ckf() {
        return (this.hBg == null || this.hBg.mYuyinBanMangerData == null || this.hBg.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean ckg() {
        return this.hBg != null && this.hBg.mYuyinBanMangerData != null && this.hBg.mYuyinBanMangerData.userIndentity == 1 && this.hBg.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean ckh() {
        return this.hBg != null && this.hBg.mYuyinBanMangerData != null && this.hBg.mYuyinBanMangerData.userIndentity == 1 && this.hBg.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean ckj() {
        return (this.hBg == null || this.hBg.mYuyinBanMangerData == null || this.hBg.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean ckk() {
        return (this.hBg == null || this.hBg.mYuyinBanMangerData == null || this.hBg.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void xm(int i) {
        this.hBb.setVisibility(i);
        this.hBe.setVisibility(i);
    }

    private void xn(int i) {
        this.hBc.setVisibility(i);
        this.hBf.setVisibility(i);
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
