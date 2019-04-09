package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> hHh;
    private TextView hHi;
    private TextView hHj;
    private ImageView hHk;
    private TextView hHl;
    private TextView hHm;
    private TextView hHn;
    private i hHo;
    private a.InterfaceC0348a hHp;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.hHh = null;
        this.mRootView = null;
        this.hHi = null;
        this.hHj = null;
        this.hHk = null;
        this.hHl = null;
        this.hHm = null;
        this.hHn = null;
        this.hHo = null;
        this.hHp = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.hHh = null;
        this.mRootView = null;
        this.hHi = null;
        this.hHj = null;
        this.hHk = null;
        this.hHl = null;
        this.hHm = null;
        this.hHn = null;
        this.hHo = null;
        this.hHp = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pb_newchudian_common, (ViewGroup) this, true);
            this.hHi = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.hHi.setOnClickListener(this);
            this.hHj = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.hHj.setOnClickListener(this);
            this.hHl = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.hHk = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.hHm = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.hHm.setOnClickListener(this);
            this.hHn = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.hHn.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0348a interfaceC0348a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.hHo = iVar;
            this.hHh = bdBaseActivity;
            this.hHp = interfaceC0348a;
            ArrayList<h> cdT = this.hHo.cdT();
            if (cdT != null && cdT.size() > 0 && (hVar = cdT.get(0)) != null && !ap.isEmpty(hVar.getText())) {
                al.d(this.hHi, d.C0277d.cp_other_c, 1);
                al.e(this.hHi, d.f.label_bg_green, 1);
                this.hHi.setText(hVar.getText());
                this.hHi.setVisibility(0);
                if (cdT.size() > 1 && (hVar2 = cdT.get(1)) != null && !ap.isEmpty(hVar2.getText())) {
                    al.d(this.hHj, d.C0277d.cp_other_c, 1);
                    al.e(this.hHj, d.f.label_bg_green, 1);
                    this.hHj.setText(hVar2.getText());
                    this.hHj.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.hHo.getPosition())) {
                this.hHl.setText(this.hHo.getPosition());
                al.d(this.hHl, d.C0277d.cp_cont_c, 1);
                this.hHl.setVisibility(0);
                al.c(this.hHk, d.f.icon_pic_place);
                this.hHk.setVisibility(0);
            }
            j cdV = this.hHo.cdV();
            if (cdV != null && !ap.isEmpty(cdV.getText())) {
                if (this.hHi.getVisibility() != 0 && this.hHj.getVisibility() != 0) {
                    al.d(this.hHn, d.C0277d.cp_link_tip_a, 1);
                    al.e(this.hHn, d.f.label_bg_blue, 1);
                    this.hHn.setText(cdV.getText());
                    this.hHn.setVisibility(0);
                } else {
                    al.d(this.hHm, d.C0277d.cp_link_tip_a, 1);
                    al.e(this.hHm, d.f.label_bg_blue, 1);
                    this.hHm.setText(cdV.getText());
                    this.hHm.setVisibility(0);
                }
            }
            if (this.hHi.getVisibility() != 0 && this.hHj.getVisibility() != 0 && this.hHl.getVisibility() != 0 && this.hHn.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hHo != null) {
            if (view == this.hHi) {
                if (this.hHo.cdT() != null) {
                    a(this.hHo.cdT().get(0));
                }
            } else if (view == this.hHj) {
                if (this.hHo.cdT() != null) {
                    a(this.hHo.cdT().get(1));
                }
            } else if (view == this.hHm || view == this.hHn) {
                j cdV = this.hHo.cdV();
                if (!ap.isEmpty(cdV.getUrl())) {
                    com.baidu.tbadk.browser.a.ar(this.mContext, cdV.getUrl());
                    if (this.hHp != null) {
                        this.hHp.d(cdV.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.hHp != null) {
                this.hHp.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ar(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hHh.getActivity());
                    aVar.lz(trim);
                    aVar.a(this.hHh.getResources().getString(d.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.hHp != null) {
                                PbNewChudianCommonView.this.hHp.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.hHh.getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.hHp != null) {
                                PbNewChudianCommonView.this.hHp.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dr(false);
                    aVar.b(this.hHh.getPageContext());
                    aVar.aaW();
                }
            }
        }
    }
}
