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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private TextView fXA;
    private ImageView fXB;
    private TextView fXC;
    private TextView fXD;
    private TextView fXE;
    private h fXF;
    private a.InterfaceC0206a fXG;
    private BdBaseActivity<?> fXy;
    private TextView fXz;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fXy = null;
        this.mRootView = null;
        this.fXz = null;
        this.fXA = null;
        this.fXB = null;
        this.fXC = null;
        this.fXD = null;
        this.fXE = null;
        this.fXF = null;
        this.fXG = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fXy = null;
        this.mRootView = null;
        this.fXz = null;
        this.fXA = null;
        this.fXB = null;
        this.fXC = null;
        this.fXD = null;
        this.fXE = null;
        this.fXF = null;
        this.fXG = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.fXz = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.fXz.setOnClickListener(this);
            this.fXA = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.fXA.setOnClickListener(this);
            this.fXC = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.fXB = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.fXD = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.fXD.setOnClickListener(this);
            this.fXE = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.fXE.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0206a interfaceC0206a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fXF = hVar;
            this.fXy = bdBaseActivity;
            this.fXG = interfaceC0206a;
            ArrayList<g> byq = this.fXF.byq();
            if (byq != null && byq.size() > 0 && (gVar = byq.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.fXz, e.d.cp_other_c, 1);
                al.d(this.fXz, e.f.label_bg_green, 1);
                this.fXz.setText(gVar.getText());
                this.fXz.setVisibility(0);
                if (byq.size() > 1 && (gVar2 = byq.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.fXA, e.d.cp_other_c, 1);
                    al.d(this.fXA, e.f.label_bg_green, 1);
                    this.fXA.setText(gVar2.getText());
                    this.fXA.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.fXF.getPosition())) {
                this.fXC.setText(this.fXF.getPosition());
                al.c(this.fXC, e.d.cp_cont_c, 1);
                this.fXC.setVisibility(0);
                al.c(this.fXB, e.f.icon_pic_place);
                this.fXB.setVisibility(0);
            }
            i bys = this.fXF.bys();
            if (bys != null && !ao.isEmpty(bys.getText())) {
                if (this.fXz.getVisibility() != 0 && this.fXA.getVisibility() != 0) {
                    al.c(this.fXE, e.d.cp_link_tip_a, 1);
                    al.d(this.fXE, e.f.label_bg_blue, 1);
                    this.fXE.setText(bys.getText());
                    this.fXE.setVisibility(0);
                } else {
                    al.c(this.fXD, e.d.cp_link_tip_a, 1);
                    al.d(this.fXD, e.f.label_bg_blue, 1);
                    this.fXD.setText(bys.getText());
                    this.fXD.setVisibility(0);
                }
            }
            if (this.fXz.getVisibility() != 0 && this.fXA.getVisibility() != 0 && this.fXC.getVisibility() != 0 && this.fXE.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fXF != null) {
            if (view == this.fXz) {
                if (this.fXF.byq() != null) {
                    a(this.fXF.byq().get(0));
                }
            } else if (view == this.fXA) {
                if (this.fXF.byq() != null) {
                    a(this.fXF.byq().get(1));
                }
            } else if (view == this.fXD || view == this.fXE) {
                i bys = this.fXF.bys();
                if (!ao.isEmpty(bys.getUrl())) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, bys.getUrl());
                    if (this.fXG != null) {
                        this.fXG.d(bys.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fXG != null) {
                this.fXG.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fXy.getActivity());
                    aVar.dT(trim);
                    aVar.a(this.fXy.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fXG != null) {
                                PbNewChudianCommonView.this.fXG.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fXy.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fXG != null) {
                                PbNewChudianCommonView.this.fXG.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.aF(false);
                    aVar.b(this.fXy.getPageContext());
                    aVar.yl();
                }
            }
        }
    }
}
