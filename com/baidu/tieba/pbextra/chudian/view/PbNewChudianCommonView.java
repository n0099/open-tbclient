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
    private BdBaseActivity<?> grj;
    private TextView grk;
    private TextView grl;
    private ImageView grm;
    private TextView grn;
    private TextView gro;
    private TextView grp;
    private h grq;
    private a.InterfaceC0278a grr;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.grj = null;
        this.mRootView = null;
        this.grk = null;
        this.grl = null;
        this.grm = null;
        this.grn = null;
        this.gro = null;
        this.grp = null;
        this.grq = null;
        this.grr = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.grj = null;
        this.mRootView = null;
        this.grk = null;
        this.grl = null;
        this.grm = null;
        this.grn = null;
        this.gro = null;
        this.grp = null;
        this.grq = null;
        this.grr = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.grk = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.grk.setOnClickListener(this);
            this.grl = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.grl.setOnClickListener(this);
            this.grn = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.grm = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.gro = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.gro.setOnClickListener(this);
            this.grp = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.grp.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0278a interfaceC0278a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.grq = hVar;
            this.grj = bdBaseActivity;
            this.grr = interfaceC0278a;
            ArrayList<g> bEw = this.grq.bEw();
            if (bEw != null && bEw.size() > 0 && (gVar = bEw.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.grk, e.d.cp_other_c, 1);
                al.d(this.grk, e.f.label_bg_green, 1);
                this.grk.setText(gVar.getText());
                this.grk.setVisibility(0);
                if (bEw.size() > 1 && (gVar2 = bEw.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.grl, e.d.cp_other_c, 1);
                    al.d(this.grl, e.f.label_bg_green, 1);
                    this.grl.setText(gVar2.getText());
                    this.grl.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.grq.getPosition())) {
                this.grn.setText(this.grq.getPosition());
                al.c(this.grn, e.d.cp_cont_c, 1);
                this.grn.setVisibility(0);
                al.c(this.grm, e.f.icon_pic_place);
                this.grm.setVisibility(0);
            }
            i bEy = this.grq.bEy();
            if (bEy != null && !ao.isEmpty(bEy.getText())) {
                if (this.grk.getVisibility() != 0 && this.grl.getVisibility() != 0) {
                    al.c(this.grp, e.d.cp_link_tip_a, 1);
                    al.d(this.grp, e.f.label_bg_blue, 1);
                    this.grp.setText(bEy.getText());
                    this.grp.setVisibility(0);
                } else {
                    al.c(this.gro, e.d.cp_link_tip_a, 1);
                    al.d(this.gro, e.f.label_bg_blue, 1);
                    this.gro.setText(bEy.getText());
                    this.gro.setVisibility(0);
                }
            }
            if (this.grk.getVisibility() != 0 && this.grl.getVisibility() != 0 && this.grn.getVisibility() != 0 && this.grp.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.grq != null) {
            if (view == this.grk) {
                if (this.grq.bEw() != null) {
                    a(this.grq.bEw().get(0));
                }
            } else if (view == this.grl) {
                if (this.grq.bEw() != null) {
                    a(this.grq.bEw().get(1));
                }
            } else if (view == this.gro || view == this.grp) {
                i bEy = this.grq.bEy();
                if (!ao.isEmpty(bEy.getUrl())) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, bEy.getUrl());
                    if (this.grr != null) {
                        this.grr.d(bEy.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.grr != null) {
                this.grr.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.grj.getActivity());
                    aVar.eK(trim);
                    aVar.a(this.grj.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.grr != null) {
                                PbNewChudianCommonView.this.grr.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.grj.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.grr != null) {
                                PbNewChudianCommonView.this.grr.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.bh(false);
                    aVar.b(this.grj.getPageContext());
                    aVar.BS();
                }
            }
        }
    }
}
