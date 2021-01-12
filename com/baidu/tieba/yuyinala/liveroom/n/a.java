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
    private String aBO;
    private TextView bUf;
    private boolean bkm;
    private View hIA;
    private View hIB;
    private PersonUserData hIC;
    private TextView hIx;
    private TextView hIy;
    private TextView hIz;
    private TbPageContext mPageContext;
    private b onJ;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0926a {
        void onConfirm();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void UK(String str);

        void UL(String str);

        void UM(String str);

        void UN(String str);

        void UO(String str);

        void UP(String str);

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
        this.hIx = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hIA = findViewById(a.f.ala_person_forbid_this_divider);
        this.hIy = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hIB = findViewById(a.f.ala_person_forbid_this_divider);
        this.hIz = (TextView) findViewById(a.f.ala_person_admin);
        this.bUf = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hIx.setOnClickListener(this);
        this.hIy.setOnClickListener(this);
        this.hIz.setOnClickListener(this);
        this.bUf.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.onJ != null) {
            if (view == this.hIx) {
                if (this.hIC != null && this.hIC.user_info != null) {
                    if (cje()) {
                        a(new InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0926a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    if (a.this.hIC.mYuyinBanMangerData != null) {
                                        a.this.hIC.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.onJ.UM(a.this.hIC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_this_confirm_tip), this.hIC.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.2
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0926a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    if (a.this.hIC.mYuyinBanMangerData != null) {
                                        a.this.hIC.mYuyinBanMangerData.userBanManger = 1;
                                    }
                                    a.this.onJ.UK(a.this.hIC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_this_confirm_tip), this.hIC.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hIy) {
                if (this.hIC != null && this.hIC.user_info != null) {
                    if (cjd()) {
                        a(new InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0926a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    if (a.this.hIC.mYuyinBanMangerData != null) {
                                        a.this.hIC.mYuyinBanMangerData.userBanManger = 0;
                                    }
                                    a.this.onJ.UN(a.this.hIC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_relieve_forbidden_forever_confirm_tip), this.hIC.user_info.getNameShow()));
                    } else {
                        a(new InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0926a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    if (a.this.hIC.mYuyinBanMangerData != null) {
                                        a.this.hIC.mYuyinBanMangerData.userBanManger = 3;
                                    }
                                    a.this.onJ.UL(a.this.hIC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_forbid_forever_confirm_tip), this.hIC.user_info.getNameShow()));
                    }
                }
            } else if (view == this.hIz) {
                if (this.hIC != null && this.hIC.mYuyinBanMangerData != null) {
                    if (cjf()) {
                        a(new InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.5
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0926a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    if (a.this.hIC.mYuyinBanMangerData != null) {
                                        a.this.hIC.mYuyinBanMangerData.userCardIndentity = 2;
                                    }
                                    a.this.onJ.UO(a.this.hIC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_appoint_admin_confirm_tip), this.hIC.user_info.getNameShow()));
                    } else if (cjg()) {
                        a(new InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.6
                            @Override // com.baidu.tieba.yuyinala.liveroom.n.a.InterfaceC0926a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    if (a.this.hIC.mYuyinBanMangerData != null) {
                                        a.this.hIC.mYuyinBanMangerData.userCardIndentity = 3;
                                    }
                                    a.this.onJ.UP(a.this.hIC.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.yuyin_ala_person_fire_admin_confirm_tip), this.hIC.user_info.getNameShow()));
                    }
                }
            } else if (view == this.bUf) {
                this.onJ.onCancel();
            }
        }
    }

    private void a(final InterfaceC0926a interfaceC0926a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0926a != null) {
                    interfaceC0926a.onConfirm();
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
        this.hIC = personUserData;
        this.bkm = z;
        this.aBO = str;
        if (cji() || cjj()) {
            vR(8);
            vS(8);
        } else if (cjd()) {
            vR(8);
            this.hIy.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cje()) {
            vR(0);
            this.hIx.setText(a.h.ala_person_relieve_forbidden_this);
            this.hIy.setText(a.h.ala_person_forbid_forever);
        } else {
            vR(0);
            this.hIx.setText(a.h.ala_person_forbid_this);
            this.hIy.setText(a.h.ala_person_forbid_forever);
        }
        if (cjc()) {
            this.hIz.setVisibility(8);
            this.hIB.setVisibility(8);
        } else if (cjg()) {
            this.hIz.setText(a.h.yuyin_ala_person_fire_admin);
        } else if (cjf()) {
            this.hIz.setText(a.h.yuyin_ala_person_appoint_admin);
        } else {
            this.hIz.setVisibility(8);
            this.hIB.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.onJ = bVar;
    }

    private boolean cjc() {
        return (this.hIC == null || this.hIC.mYuyinBanMangerData == null || this.hIC.mYuyinBanMangerData.userBanManger <= 0) ? false : true;
    }

    private boolean cjd() {
        return (this.hIC == null || this.hIC.mYuyinBanMangerData == null || this.hIC.mYuyinBanMangerData.userBanManger != 3) ? false : true;
    }

    private boolean cje() {
        return (this.hIC == null || this.hIC.mYuyinBanMangerData == null || this.hIC.mYuyinBanMangerData.userBanManger != 1) ? false : true;
    }

    private boolean cjf() {
        return this.hIC != null && this.hIC.mYuyinBanMangerData != null && this.hIC.mYuyinBanMangerData.userIndentity == 1 && this.hIC.mYuyinBanMangerData.userCardIndentity == 3;
    }

    private boolean cjg() {
        return this.hIC != null && this.hIC.mYuyinBanMangerData != null && this.hIC.mYuyinBanMangerData.userIndentity == 1 && this.hIC.mYuyinBanMangerData.userCardIndentity == 2;
    }

    private boolean cji() {
        return (this.hIC == null || this.hIC.mYuyinBanMangerData == null || this.hIC.mYuyinBanMangerData.userCardIndentity != 1) ? false : true;
    }

    private boolean cjj() {
        return (this.hIC == null || this.hIC.mYuyinBanMangerData == null || this.hIC.mYuyinBanMangerData.userCardIndentity != 2) ? false : true;
    }

    private void vR(int i) {
        this.hIx.setVisibility(i);
        this.hIA.setVisibility(i);
    }

    private void vS(int i) {
        this.hIy.setVisibility(i);
        this.hIB.setVisibility(i);
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
