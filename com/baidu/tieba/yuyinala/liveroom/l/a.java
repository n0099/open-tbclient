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
    private String aDE;
    private TextView bOb;
    private boolean bja;
    private View hrA;
    private View hrB;
    private PersonUserData hrC;
    private TextView hrx;
    private TextView hry;
    private TextView hrz;
    private TbPageContext mPageContext;
    private b nZW;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0912a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void HR(String str);

        void HS(String str);

        void HT(String str);

        void HU(String str);

        void HV(String str);

        void HW(String str);

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
        this.hrx = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hrA = findViewById(a.f.ala_person_forbid_this_divider);
        this.hry = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hrB = findViewById(a.f.ala_person_forbid_this_divider);
        this.hrz = (TextView) findViewById(a.f.ala_person_admin);
        this.bOb = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hrx.setOnClickListener(this);
        this.hry.setOnClickListener(this);
        this.hrz.setOnClickListener(this);
        this.bOb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.nZW != null) {
            if (view == this.hrx) {
                if (this.hrC != null && this.hrC.user_info != null) {
                    if (cgl()) {
                        a(new InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0912a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    if (a.this.hrC.mYuyinBanMangerData != null) {
                                        a.this.hrC.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.nZW.HT(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hrC.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0912a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    if (a.this.hrC.mYuyinBanMangerData != null) {
                                        a.this.hrC.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.nZW.HR(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hrC.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hry) {
                if (this.hrC != null && this.hrC.user_info != null) {
                    if (cgk()) {
                        a(new InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0912a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    if (a.this.hrC.mYuyinBanMangerData != null) {
                                        a.this.hrC.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.nZW.HU(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hrC.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0912a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    if (a.this.hrC.mYuyinBanMangerData != null) {
                                        a.this.hrC.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.nZW.HS(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hrC.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hrz) {
                if (this.hrC != null && this.hrC.mYuyinBanMangerData != null) {
                    if (cgm()) {
                        a(new InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0912a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    if (a.this.hrC.mYuyinBanMangerData != null) {
                                        a.this.hrC.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.nZW.HV(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hrC.user_info.getNameShow()));
                    } else if (cgn()) {
                        a(new InterfaceC0912a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0912a
                            public void onConfirm() {
                                if (a.this.hrC != null && a.this.hrC.user_info != null) {
                                    if (a.this.hrC.mYuyinBanMangerData != null) {
                                        a.this.hrC.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.nZW.HW(a.this.hrC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hrC.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bOb) {
                this.nZW.onCancel();
            }
        }
    }

    private void a(final InterfaceC0912a interfaceC0912a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0912a != null) {
                    interfaceC0912a.onConfirm();
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
        this.hrC = personUserData;
        this.bja = z;
        this.aDE = str;
        if (cgp() || cgq()) {
            wH(8);
            wI(8);
        } else if (cgk()) {
            wH(8);
            this.hry.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cgl()) {
            wH(0);
            this.hrx.setText(a.h.ala_person_relieve_forbidden_this);
            this.hry.setText(a.h.ala_person_forbid_forever);
        } else {
            wH(0);
            this.hrx.setText(a.h.ala_person_forbid_this);
            this.hry.setText(a.h.ala_person_forbid_forever);
        }
        if (cgj()) {
            this.hrz.setVisibility(8);
            this.hrB.setVisibility(8);
        } else if (cgn()) {
            this.hrz.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (cgm()) {
            this.hrz.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hrz.setVisibility(8);
            this.hrB.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.nZW = bVar;
    }

    private boolean cgj() {
        return (this.hrC == null || this.hrC.mYuyinBanMangerData == null || this.hrC.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean cgk() {
        return (this.hrC == null || this.hrC.mYuyinBanMangerData == null || this.hrC.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean cgl() {
        return (this.hrC == null || this.hrC.mYuyinBanMangerData == null || this.hrC.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean cgm() {
        return this.hrC != null && this.hrC.mYuyinBanMangerData != null && this.hrC.mYuyinBanMangerData.userIndentity == 1 && this.hrC.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean cgn() {
        return this.hrC != null && this.hrC.mYuyinBanMangerData != null && this.hrC.mYuyinBanMangerData.userIndentity == 1 && this.hrC.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean cgp() {
        return (this.hrC == null || this.hrC.mYuyinBanMangerData == null || this.hrC.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean cgq() {
        return (this.hrC == null || this.hrC.mYuyinBanMangerData == null || this.hrC.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void wH(int i) {
        this.hrx.setVisibility(i);
        this.hrA.setVisibility(i);
    }

    private void wI(int i) {
        this.hry.setVisibility(i);
        this.hrB.setVisibility(i);
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
