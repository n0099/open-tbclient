package com.baidu.tieba.yuyinala.liveroom.n;

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
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aDB;
    private TextView bYe;
    private boolean bnF;
    private TextView hNj;
    private TextView hNk;
    private TextView hNl;
    private View hNm;
    private View hNn;
    private PersonUserData hNo;
    private TbPageContext mPageContext;
    private b oya;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0932a {
        void onConfirm();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void VV(String str);

        void VW(String str);

        void VX(String str);

        void VY(String str);

        void VZ(String str);

        void Wa(String str);

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
        this.hNj = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hNm = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNk = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hNn = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNl = (TextView) findViewById(a.f.ala_person_admin);
        this.bYe = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hNj.setOnClickListener(this);
        this.hNk.setOnClickListener(this);
        this.hNl.setOnClickListener(this);
        this.bYe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oya != null) {
            if (view == this.hNj) {
                if (this.hNo != null && this.hNo.user_info != null) {
                    if (ckk()) {
                        a(new InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0932a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    if (a.this.hNo.mYuyinBanMangerData != null) {
                                        a.this.hNo.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.oya.VX(a.this.hNo.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hNo.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0932a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    if (a.this.hNo.mYuyinBanMangerData != null) {
                                        a.this.hNo.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.oya.VV(a.this.hNo.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hNo.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hNk) {
                if (this.hNo != null && this.hNo.user_info != null) {
                    if (ckj()) {
                        a(new InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0932a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    if (a.this.hNo.mYuyinBanMangerData != null) {
                                        a.this.hNo.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.oya.VY(a.this.hNo.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hNo.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0932a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    if (a.this.hNo.mYuyinBanMangerData != null) {
                                        a.this.hNo.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.oya.VW(a.this.hNo.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hNo.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hNl) {
                if (this.hNo != null && this.hNo.mYuyinBanMangerData != null) {
                    if (ckl()) {
                        a(new InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0932a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    if (a.this.hNo.mYuyinBanMangerData != null) {
                                        a.this.hNo.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.oya.VZ(a.this.hNo.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hNo.user_info.getNameShow()));
                    } else if (ckm()) {
                        a(new InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0932a
                            public void onConfirm() {
                                if (a.this.hNo != null && a.this.hNo.user_info != null) {
                                    if (a.this.hNo.mYuyinBanMangerData != null) {
                                        a.this.hNo.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.oya.Wa(a.this.hNo.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hNo.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bYe) {
                this.oya.onCancel();
            }
        }
    }

    private void a(final InterfaceC0932a interfaceC0932a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0932a != null) {
                    interfaceC0932a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.8
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
        this.hNo = personUserData;
        this.bnF = z;
        this.aDB = str;
        if (cko() || ckp()) {
            wc(8);
            wd(8);
        } else if (ckj()) {
            wc(8);
            this.hNk.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckk()) {
            wc(0);
            this.hNj.setText(a.h.ala_person_relieve_forbidden_this);
            this.hNk.setText(a.h.ala_person_forbid_forever);
        } else {
            wc(0);
            this.hNj.setText(a.h.ala_person_forbid_this);
            this.hNk.setText(a.h.ala_person_forbid_forever);
        }
        if (cki()) {
            this.hNl.setVisibility(8);
            this.hNn.setVisibility(8);
        } else if (ckm()) {
            this.hNl.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (ckl()) {
            this.hNl.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hNl.setVisibility(8);
            this.hNn.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.oya = bVar;
    }

    private boolean cki() {
        return (this.hNo == null || this.hNo.mYuyinBanMangerData == null || this.hNo.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean ckj() {
        return (this.hNo == null || this.hNo.mYuyinBanMangerData == null || this.hNo.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean ckk() {
        return (this.hNo == null || this.hNo.mYuyinBanMangerData == null || this.hNo.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean ckl() {
        return this.hNo != null && this.hNo.mYuyinBanMangerData != null && this.hNo.mYuyinBanMangerData.userIndentity == 1 && this.hNo.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean ckm() {
        return this.hNo != null && this.hNo.mYuyinBanMangerData != null && this.hNo.mYuyinBanMangerData.userIndentity == 1 && this.hNo.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean cko() {
        return (this.hNo == null || this.hNo.mYuyinBanMangerData == null || this.hNo.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean ckp() {
        return (this.hNo == null || this.hNo.mYuyinBanMangerData == null || this.hNo.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void wc(int i) {
        this.hNj.setVisibility(i);
        this.hNm.setVisibility(i);
    }

    private void wd(int i) {
        this.hNk.setVisibility(i);
        this.hNn.setVisibility(i);
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
