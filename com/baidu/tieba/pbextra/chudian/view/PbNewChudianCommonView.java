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
    private BdBaseActivity<?> gqe;
    private TextView gqf;
    private TextView gqg;
    private ImageView gqh;
    private TextView gqi;
    private TextView gqj;
    private TextView gqk;
    private h gql;
    private a.InterfaceC0278a gqm;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.gqe = null;
        this.mRootView = null;
        this.gqf = null;
        this.gqg = null;
        this.gqh = null;
        this.gqi = null;
        this.gqj = null;
        this.gqk = null;
        this.gql = null;
        this.gqm = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gqe = null;
        this.mRootView = null;
        this.gqf = null;
        this.gqg = null;
        this.gqh = null;
        this.gqi = null;
        this.gqj = null;
        this.gqk = null;
        this.gql = null;
        this.gqm = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.gqf = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.gqf.setOnClickListener(this);
            this.gqg = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.gqg.setOnClickListener(this);
            this.gqi = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.gqh = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.gqj = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.gqj.setOnClickListener(this);
            this.gqk = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.gqk.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0278a interfaceC0278a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.gql = hVar;
            this.gqe = bdBaseActivity;
            this.gqm = interfaceC0278a;
            ArrayList<g> bDN = this.gql.bDN();
            if (bDN != null && bDN.size() > 0 && (gVar = bDN.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.gqf, e.d.cp_other_c, 1);
                al.d(this.gqf, e.f.label_bg_green, 1);
                this.gqf.setText(gVar.getText());
                this.gqf.setVisibility(0);
                if (bDN.size() > 1 && (gVar2 = bDN.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.gqg, e.d.cp_other_c, 1);
                    al.d(this.gqg, e.f.label_bg_green, 1);
                    this.gqg.setText(gVar2.getText());
                    this.gqg.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.gql.getPosition())) {
                this.gqi.setText(this.gql.getPosition());
                al.c(this.gqi, e.d.cp_cont_c, 1);
                this.gqi.setVisibility(0);
                al.c(this.gqh, e.f.icon_pic_place);
                this.gqh.setVisibility(0);
            }
            i bDP = this.gql.bDP();
            if (bDP != null && !ao.isEmpty(bDP.getText())) {
                if (this.gqf.getVisibility() != 0 && this.gqg.getVisibility() != 0) {
                    al.c(this.gqk, e.d.cp_link_tip_a, 1);
                    al.d(this.gqk, e.f.label_bg_blue, 1);
                    this.gqk.setText(bDP.getText());
                    this.gqk.setVisibility(0);
                } else {
                    al.c(this.gqj, e.d.cp_link_tip_a, 1);
                    al.d(this.gqj, e.f.label_bg_blue, 1);
                    this.gqj.setText(bDP.getText());
                    this.gqj.setVisibility(0);
                }
            }
            if (this.gqf.getVisibility() != 0 && this.gqg.getVisibility() != 0 && this.gqi.getVisibility() != 0 && this.gqk.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gql != null) {
            if (view == this.gqf) {
                if (this.gql.bDN() != null) {
                    a(this.gql.bDN().get(0));
                }
            } else if (view == this.gqg) {
                if (this.gql.bDN() != null) {
                    a(this.gql.bDN().get(1));
                }
            } else if (view == this.gqj || view == this.gqk) {
                i bDP = this.gql.bDP();
                if (!ao.isEmpty(bDP.getUrl())) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, bDP.getUrl());
                    if (this.gqm != null) {
                        this.gqm.d(bDP.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.gqm != null) {
                this.gqm.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gqe.getActivity());
                    aVar.eB(trim);
                    aVar.a(this.gqe.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.gqm != null) {
                                PbNewChudianCommonView.this.gqm.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.gqe.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.gqm != null) {
                                PbNewChudianCommonView.this.gqm.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.bg(false);
                    aVar.b(this.gqe.getPageContext());
                    aVar.BF();
                }
            }
        }
    }
}
