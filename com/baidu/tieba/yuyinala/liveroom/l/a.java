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
    private String aFp;
    private TextView bPL;
    private boolean bkL;
    private TextView hrQ;
    private TextView hrR;
    private TextView hrS;
    private View hrT;
    private View hrU;
    private PersonUserData hrV;
    private TbPageContext mPageContext;
    private b nYt;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0909a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void Iq(String str);

        void Ir(String str);

        void Is(String str);

        void It(String str);

        void Iu(String str);

        void Iv(String str);

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
        this.hrQ = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hrT = findViewById(a.f.ala_person_forbid_this_divider);
        this.hrR = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hrU = findViewById(a.f.ala_person_forbid_this_divider);
        this.hrS = (TextView) findViewById(a.f.ala_person_admin);
        this.bPL = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hrQ.setOnClickListener(this);
        this.hrR.setOnClickListener(this);
        this.hrS.setOnClickListener(this);
        this.bPL.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.nYt != null) {
            if (view == this.hrQ) {
                if (this.hrV != null && this.hrV.user_info != null) {
                    if (cgS()) {
                        a(new InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0909a
                            public void onConfirm() {
                                if (a.this.hrV != null && a.this.hrV.user_info != null) {
                                    if (a.this.hrV.mYuyinBanMangerData != null) {
                                        a.this.hrV.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.nYt.Is(a.this.hrV.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hrV.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0909a
                            public void onConfirm() {
                                if (a.this.hrV != null && a.this.hrV.user_info != null) {
                                    if (a.this.hrV.mYuyinBanMangerData != null) {
                                        a.this.hrV.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.nYt.Iq(a.this.hrV.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hrV.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hrR) {
                if (this.hrV != null && this.hrV.user_info != null) {
                    if (cgR()) {
                        a(new InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0909a
                            public void onConfirm() {
                                if (a.this.hrV != null && a.this.hrV.user_info != null) {
                                    if (a.this.hrV.mYuyinBanMangerData != null) {
                                        a.this.hrV.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.nYt.It(a.this.hrV.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hrV.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0909a
                            public void onConfirm() {
                                if (a.this.hrV != null && a.this.hrV.user_info != null) {
                                    if (a.this.hrV.mYuyinBanMangerData != null) {
                                        a.this.hrV.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.nYt.Ir(a.this.hrV.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hrV.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hrS) {
                if (this.hrV != null && this.hrV.mYuyinBanMangerData != null) {
                    if (cgT()) {
                        a(new InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0909a
                            public void onConfirm() {
                                if (a.this.hrV != null && a.this.hrV.user_info != null) {
                                    if (a.this.hrV.mYuyinBanMangerData != null) {
                                        a.this.hrV.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.nYt.Iu(a.this.hrV.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hrV.user_info.getNameShow()));
                    } else if (cgU()) {
                        a(new InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.l.a.InterfaceC0909a
                            public void onConfirm() {
                                if (a.this.hrV != null && a.this.hrV.user_info != null) {
                                    if (a.this.hrV.mYuyinBanMangerData != null) {
                                        a.this.hrV.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.nYt.Iv(a.this.hrV.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hrV.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bPL) {
                this.nYt.onCancel();
            }
        }
    }

    private void a(final InterfaceC0909a interfaceC0909a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.l.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0909a != null) {
                    interfaceC0909a.onConfirm();
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
        this.hrV = personUserData;
        this.bkL = z;
        this.aFp = str;
        if (cgW() || cgX()) {
            wj(8);
            wk(8);
        } else if (cgR()) {
            wj(8);
            this.hrR.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cgS()) {
            wj(0);
            this.hrQ.setText(a.h.ala_person_relieve_forbidden_this);
            this.hrR.setText(a.h.ala_person_forbid_forever);
        } else {
            wj(0);
            this.hrQ.setText(a.h.ala_person_forbid_this);
            this.hrR.setText(a.h.ala_person_forbid_forever);
        }
        if (cgQ()) {
            this.hrS.setVisibility(8);
            this.hrU.setVisibility(8);
        } else if (cgU()) {
            this.hrS.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (cgT()) {
            this.hrS.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hrS.setVisibility(8);
            this.hrU.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.nYt = bVar;
    }

    private boolean cgQ() {
        return (this.hrV == null || this.hrV.mYuyinBanMangerData == null || this.hrV.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean cgR() {
        return (this.hrV == null || this.hrV.mYuyinBanMangerData == null || this.hrV.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean cgS() {
        return (this.hrV == null || this.hrV.mYuyinBanMangerData == null || this.hrV.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean cgT() {
        return this.hrV != null && this.hrV.mYuyinBanMangerData != null && this.hrV.mYuyinBanMangerData.userIndentity == 1 && this.hrV.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean cgU() {
        return this.hrV != null && this.hrV.mYuyinBanMangerData != null && this.hrV.mYuyinBanMangerData.userIndentity == 1 && this.hrV.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean cgW() {
        return (this.hrV == null || this.hrV.mYuyinBanMangerData == null || this.hrV.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean cgX() {
        return (this.hrV == null || this.hrV.mYuyinBanMangerData == null || this.hrV.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void wj(int i) {
        this.hrQ.setVisibility(i);
        this.hrT.setVisibility(i);
    }

    private void wk(int i) {
        this.hrR.setVisibility(i);
        this.hrU.setVisibility(i);
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
