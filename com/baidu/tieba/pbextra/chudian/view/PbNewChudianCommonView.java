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
    private BdBaseActivity<?> gri;
    private TextView grj;
    private TextView grk;
    private ImageView grl;
    private TextView grm;
    private TextView grn;
    private TextView gro;
    private h grp;
    private a.InterfaceC0278a grq;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.gri = null;
        this.mRootView = null;
        this.grj = null;
        this.grk = null;
        this.grl = null;
        this.grm = null;
        this.grn = null;
        this.gro = null;
        this.grp = null;
        this.grq = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gri = null;
        this.mRootView = null;
        this.grj = null;
        this.grk = null;
        this.grl = null;
        this.grm = null;
        this.grn = null;
        this.gro = null;
        this.grp = null;
        this.grq = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.grj = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.grj.setOnClickListener(this);
            this.grk = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.grk.setOnClickListener(this);
            this.grm = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.grl = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.grn = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.grn.setOnClickListener(this);
            this.gro = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.gro.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0278a interfaceC0278a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.grp = hVar;
            this.gri = bdBaseActivity;
            this.grq = interfaceC0278a;
            ArrayList<g> bEw = this.grp.bEw();
            if (bEw != null && bEw.size() > 0 && (gVar = bEw.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.grj, e.d.cp_other_c, 1);
                al.d(this.grj, e.f.label_bg_green, 1);
                this.grj.setText(gVar.getText());
                this.grj.setVisibility(0);
                if (bEw.size() > 1 && (gVar2 = bEw.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.grk, e.d.cp_other_c, 1);
                    al.d(this.grk, e.f.label_bg_green, 1);
                    this.grk.setText(gVar2.getText());
                    this.grk.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.grp.getPosition())) {
                this.grm.setText(this.grp.getPosition());
                al.c(this.grm, e.d.cp_cont_c, 1);
                this.grm.setVisibility(0);
                al.c(this.grl, e.f.icon_pic_place);
                this.grl.setVisibility(0);
            }
            i bEy = this.grp.bEy();
            if (bEy != null && !ao.isEmpty(bEy.getText())) {
                if (this.grj.getVisibility() != 0 && this.grk.getVisibility() != 0) {
                    al.c(this.gro, e.d.cp_link_tip_a, 1);
                    al.d(this.gro, e.f.label_bg_blue, 1);
                    this.gro.setText(bEy.getText());
                    this.gro.setVisibility(0);
                } else {
                    al.c(this.grn, e.d.cp_link_tip_a, 1);
                    al.d(this.grn, e.f.label_bg_blue, 1);
                    this.grn.setText(bEy.getText());
                    this.grn.setVisibility(0);
                }
            }
            if (this.grj.getVisibility() != 0 && this.grk.getVisibility() != 0 && this.grm.getVisibility() != 0 && this.gro.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.grp != null) {
            if (view == this.grj) {
                if (this.grp.bEw() != null) {
                    a(this.grp.bEw().get(0));
                }
            } else if (view == this.grk) {
                if (this.grp.bEw() != null) {
                    a(this.grp.bEw().get(1));
                }
            } else if (view == this.grn || view == this.gro) {
                i bEy = this.grp.bEy();
                if (!ao.isEmpty(bEy.getUrl())) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, bEy.getUrl());
                    if (this.grq != null) {
                        this.grq.d(bEy.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.grq != null) {
                this.grq.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gri.getActivity());
                    aVar.eK(trim);
                    aVar.a(this.gri.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.grq != null) {
                                PbNewChudianCommonView.this.grq.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.gri.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.grq != null) {
                                PbNewChudianCommonView.this.grq.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.bh(false);
                    aVar.b(this.gri.getPageContext());
                    aVar.BS();
                }
            }
        }
    }
}
