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
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aFb;
    private TextView bZE;
    private boolean bpf;
    private TextView hOS;
    private TextView hOT;
    private TextView hOU;
    private View hOV;
    private View hOW;
    private PersonUserData hOX;
    private TbPageContext mPageContext;
    private b oAf;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0938a {
        void onConfirm();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Wc(String str);

        void Wd(String str);

        void We(String str);

        void Wf(String str);

        void Wg(String str);

        void Wh(String str);

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
        this.hOS = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hOV = findViewById(a.f.ala_person_forbid_this_divider);
        this.hOT = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hOW = findViewById(a.f.ala_person_forbid_this_divider);
        this.hOU = (TextView) findViewById(a.f.ala_person_admin);
        this.bZE = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hOS.setOnClickListener(this);
        this.hOT.setOnClickListener(this);
        this.hOU.setOnClickListener(this);
        this.bZE.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.oAf != null) {
            if (view == this.hOS) {
                if (this.hOX != null && this.hOX.user_info != null) {
                    if (ckq()) {
                        a(new InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0938a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    if (a.this.hOX.mYuyinBanMangerData != null) {
                                        a.this.hOX.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.oAf.We(a.this.hOX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hOX.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0938a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    if (a.this.hOX.mYuyinBanMangerData != null) {
                                        a.this.hOX.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.oAf.Wc(a.this.hOX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hOX.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hOT) {
                if (this.hOX != null && this.hOX.user_info != null) {
                    if (ckp()) {
                        a(new InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0938a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    if (a.this.hOX.mYuyinBanMangerData != null) {
                                        a.this.hOX.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.oAf.Wf(a.this.hOX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hOX.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0938a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    if (a.this.hOX.mYuyinBanMangerData != null) {
                                        a.this.hOX.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.oAf.Wd(a.this.hOX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hOX.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hOU) {
                if (this.hOX != null && this.hOX.mYuyinBanMangerData != null) {
                    if (ckr()) {
                        a(new InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0938a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    if (a.this.hOX.mYuyinBanMangerData != null) {
                                        a.this.hOX.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.oAf.Wg(a.this.hOX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hOX.user_info.getNameShow()));
                    } else if (cks()) {
                        a(new InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0938a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    if (a.this.hOX.mYuyinBanMangerData != null) {
                                        a.this.hOX.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.oAf.Wh(a.this.hOX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hOX.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bZE) {
                this.oAf.onCancel();
            }
        }
    }

    private void a(final InterfaceC0938a interfaceC0938a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0938a != null) {
                    interfaceC0938a.onConfirm();
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
        this.hOX = personUserData;
        this.bpf = z;
        this.aFb = str;
        if (cku() || ckv()) {
            we(8);
            wf(8);
        } else if (ckp()) {
            we(8);
            this.hOT.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckq()) {
            we(0);
            this.hOS.setText(a.h.ala_person_relieve_forbidden_this);
            this.hOT.setText(a.h.ala_person_forbid_forever);
        } else {
            we(0);
            this.hOS.setText(a.h.ala_person_forbid_this);
            this.hOT.setText(a.h.ala_person_forbid_forever);
        }
        if (cko()) {
            this.hOU.setVisibility(8);
            this.hOW.setVisibility(8);
        } else if (cks()) {
            this.hOU.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (ckr()) {
            this.hOU.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hOU.setVisibility(8);
            this.hOW.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.oAf = bVar;
    }

    private boolean cko() {
        return (this.hOX == null || this.hOX.mYuyinBanMangerData == null || this.hOX.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean ckp() {
        return (this.hOX == null || this.hOX.mYuyinBanMangerData == null || this.hOX.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean ckq() {
        return (this.hOX == null || this.hOX.mYuyinBanMangerData == null || this.hOX.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean ckr() {
        return this.hOX != null && this.hOX.mYuyinBanMangerData != null && this.hOX.mYuyinBanMangerData.userIndentity == 1 && this.hOX.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean cks() {
        return this.hOX != null && this.hOX.mYuyinBanMangerData != null && this.hOX.mYuyinBanMangerData.userIndentity == 1 && this.hOX.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean cku() {
        return (this.hOX == null || this.hOX.mYuyinBanMangerData == null || this.hOX.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean ckv() {
        return (this.hOX == null || this.hOX.mYuyinBanMangerData == null || this.hOX.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void we(int i) {
        this.hOS.setVisibility(i);
        this.hOV.setVisibility(i);
    }

    private void wf(int i) {
        this.hOT.setVisibility(i);
        this.hOW.setVisibility(i);
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
