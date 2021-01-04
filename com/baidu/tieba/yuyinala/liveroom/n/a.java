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
    private String aGB;
    private TextView bYR;
    private boolean boZ;
    private TextView hNd;
    private TextView hNe;
    private TextView hNf;
    private View hNg;
    private View hNh;
    private PersonUserData hNi;
    private TbPageContext mPageContext;
    private b osr;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0905a {
        void onConfirm();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void VT(String str);

        void VU(String str);

        void VV(String str);

        void VW(String str);

        void VX(String str);

        void VY(String str);

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
        this.hNd = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hNg = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNe = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hNh = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNf = (TextView) findViewById(a.f.ala_person_admin);
        this.bYR = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hNd.setOnClickListener(this);
        this.hNe.setOnClickListener(this);
        this.hNf.setOnClickListener(this);
        this.bYR.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.osr != null) {
            if (view == this.hNd) {
                if (this.hNi != null && this.hNi.user_info != null) {
                    if (cmV()) {
                        a(new InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0905a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    if (a.this.hNi.mYuyinBanMangerData != null) {
                                        a.this.hNi.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.osr.VV(a.this.hNi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hNi.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0905a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    if (a.this.hNi.mYuyinBanMangerData != null) {
                                        a.this.hNi.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.osr.VT(a.this.hNi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hNi.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hNe) {
                if (this.hNi != null && this.hNi.user_info != null) {
                    if (cmU()) {
                        a(new InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0905a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    if (a.this.hNi.mYuyinBanMangerData != null) {
                                        a.this.hNi.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.osr.VW(a.this.hNi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hNi.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0905a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    if (a.this.hNi.mYuyinBanMangerData != null) {
                                        a.this.hNi.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.osr.VU(a.this.hNi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hNi.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hNf) {
                if (this.hNi != null && this.hNi.mYuyinBanMangerData != null) {
                    if (cmW()) {
                        a(new InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0905a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    if (a.this.hNi.mYuyinBanMangerData != null) {
                                        a.this.hNi.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.osr.VX(a.this.hNi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hNi.user_info.getNameShow()));
                    } else if (cmX()) {
                        a(new InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0905a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    if (a.this.hNi.mYuyinBanMangerData != null) {
                                        a.this.hNi.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.osr.VY(a.this.hNi.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hNi.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bYR) {
                this.osr.onCancel();
            }
        }
    }

    private void a(final InterfaceC0905a interfaceC0905a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0905a != null) {
                    interfaceC0905a.onConfirm();
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
        this.hNi = personUserData;
        this.boZ = z;
        this.aGB = str;
        if (cmZ() || cna()) {
            xx(8);
            xy(8);
        } else if (cmU()) {
            xx(8);
            this.hNe.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cmV()) {
            xx(0);
            this.hNd.setText(a.h.ala_person_relieve_forbidden_this);
            this.hNe.setText(a.h.ala_person_forbid_forever);
        } else {
            xx(0);
            this.hNd.setText(a.h.ala_person_forbid_this);
            this.hNe.setText(a.h.ala_person_forbid_forever);
        }
        if (cmT()) {
            this.hNf.setVisibility(8);
            this.hNh.setVisibility(8);
        } else if (cmX()) {
            this.hNf.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (cmW()) {
            this.hNf.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hNf.setVisibility(8);
            this.hNh.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.osr = bVar;
    }

    private boolean cmT() {
        return (this.hNi == null || this.hNi.mYuyinBanMangerData == null || this.hNi.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean cmU() {
        return (this.hNi == null || this.hNi.mYuyinBanMangerData == null || this.hNi.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean cmV() {
        return (this.hNi == null || this.hNi.mYuyinBanMangerData == null || this.hNi.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean cmW() {
        return this.hNi != null && this.hNi.mYuyinBanMangerData != null && this.hNi.mYuyinBanMangerData.userIndentity == 1 && this.hNi.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean cmX() {
        return this.hNi != null && this.hNi.mYuyinBanMangerData != null && this.hNi.mYuyinBanMangerData.userIndentity == 1 && this.hNi.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean cmZ() {
        return (this.hNi == null || this.hNi.mYuyinBanMangerData == null || this.hNi.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean cna() {
        return (this.hNi == null || this.hNi.mYuyinBanMangerData == null || this.hNi.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void xx(int i) {
        this.hNd.setVisibility(i);
        this.hNg.setVisibility(i);
    }

    private void xy(int i) {
        this.hNe.setVisibility(i);
        this.hNh.setVisibility(i);
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
