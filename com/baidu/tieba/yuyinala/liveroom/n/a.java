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
    private TextView hMV;
    private TextView hMW;
    private TextView hMX;
    private View hMY;
    private View hMZ;
    private PersonUserData hNa;
    private TbPageContext mPageContext;
    private b oxA;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0930a {
        void onConfirm();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void VJ(String str);

        void VK(String str);

        void VL(String str);

        void VM(String str);

        void VN(String str);

        void VO(String str);

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
        this.hMV = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hMY = findViewById(a.f.ala_person_forbid_this_divider);
        this.hMW = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hMZ = findViewById(a.f.ala_person_forbid_this_divider);
        this.hMX = (TextView) findViewById(a.f.ala_person_admin);
        this.bYe = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hMV.setOnClickListener(this);
        this.hMW.setOnClickListener(this);
        this.hMX.setOnClickListener(this);
        this.bYe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oxA != null) {
            if (view == this.hMV) {
                if (this.hNa != null && this.hNa.user_info != null) {
                    if (ckd()) {
                        a(new InterfaceC0930a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0930a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    if (a.this.hNa.mYuyinBanMangerData != null) {
                                        a.this.hNa.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.oxA.VL(a.this.hNa.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hNa.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0930a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0930a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    if (a.this.hNa.mYuyinBanMangerData != null) {
                                        a.this.hNa.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.oxA.VJ(a.this.hNa.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hNa.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hMW) {
                if (this.hNa != null && this.hNa.user_info != null) {
                    if (ckc()) {
                        a(new InterfaceC0930a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0930a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    if (a.this.hNa.mYuyinBanMangerData != null) {
                                        a.this.hNa.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.oxA.VM(a.this.hNa.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hNa.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0930a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0930a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    if (a.this.hNa.mYuyinBanMangerData != null) {
                                        a.this.hNa.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.oxA.VK(a.this.hNa.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hNa.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hMX) {
                if (this.hNa != null && this.hNa.mYuyinBanMangerData != null) {
                    if (cke()) {
                        a(new InterfaceC0930a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0930a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    if (a.this.hNa.mYuyinBanMangerData != null) {
                                        a.this.hNa.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.oxA.VN(a.this.hNa.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hNa.user_info.getNameShow()));
                    } else if (ckf()) {
                        a(new InterfaceC0930a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0930a
                            public void onConfirm() {
                                if (a.this.hNa != null && a.this.hNa.user_info != null) {
                                    if (a.this.hNa.mYuyinBanMangerData != null) {
                                        a.this.hNa.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.oxA.VO(a.this.hNa.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hNa.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bYe) {
                this.oxA.onCancel();
            }
        }
    }

    private void a(final InterfaceC0930a interfaceC0930a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0930a != null) {
                    interfaceC0930a.onConfirm();
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
        this.hNa = personUserData;
        this.bnF = z;
        this.aDB = str;
        if (ckh() || cki()) {
            wc(8);
            wd(8);
        } else if (ckc()) {
            wc(8);
            this.hMW.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckd()) {
            wc(0);
            this.hMV.setText(a.h.ala_person_relieve_forbidden_this);
            this.hMW.setText(a.h.ala_person_forbid_forever);
        } else {
            wc(0);
            this.hMV.setText(a.h.ala_person_forbid_this);
            this.hMW.setText(a.h.ala_person_forbid_forever);
        }
        if (ckb()) {
            this.hMX.setVisibility(8);
            this.hMZ.setVisibility(8);
        } else if (ckf()) {
            this.hMX.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (cke()) {
            this.hMX.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hMX.setVisibility(8);
            this.hMZ.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.oxA = bVar;
    }

    private boolean ckb() {
        return (this.hNa == null || this.hNa.mYuyinBanMangerData == null || this.hNa.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean ckc() {
        return (this.hNa == null || this.hNa.mYuyinBanMangerData == null || this.hNa.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean ckd() {
        return (this.hNa == null || this.hNa.mYuyinBanMangerData == null || this.hNa.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean cke() {
        return this.hNa != null && this.hNa.mYuyinBanMangerData != null && this.hNa.mYuyinBanMangerData.userIndentity == 1 && this.hNa.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean ckf() {
        return this.hNa != null && this.hNa.mYuyinBanMangerData != null && this.hNa.mYuyinBanMangerData.userIndentity == 1 && this.hNa.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean ckh() {
        return (this.hNa == null || this.hNa.mYuyinBanMangerData == null || this.hNa.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean cki() {
        return (this.hNa == null || this.hNa.mYuyinBanMangerData == null || this.hNa.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void wc(int i) {
        this.hMV.setVisibility(i);
        this.hMY.setVisibility(i);
    }

    private void wd(int i) {
        this.hMW.setVisibility(i);
        this.hMZ.setVisibility(i);
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
