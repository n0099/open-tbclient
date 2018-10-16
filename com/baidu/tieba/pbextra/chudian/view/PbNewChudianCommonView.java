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
    private BdBaseActivity<?> geZ;
    private TextView gfa;
    private TextView gfb;
    private ImageView gfc;
    private TextView gfd;
    private TextView gfe;
    private TextView gff;
    private h gfg;
    private a.InterfaceC0240a gfh;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.geZ = null;
        this.mRootView = null;
        this.gfa = null;
        this.gfb = null;
        this.gfc = null;
        this.gfd = null;
        this.gfe = null;
        this.gff = null;
        this.gfg = null;
        this.gfh = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.geZ = null;
        this.mRootView = null;
        this.gfa = null;
        this.gfb = null;
        this.gfc = null;
        this.gfd = null;
        this.gfe = null;
        this.gff = null;
        this.gfg = null;
        this.gfh = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.gfa = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.gfa.setOnClickListener(this);
            this.gfb = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.gfb.setOnClickListener(this);
            this.gfd = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.gfc = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.gfe = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.gfe.setOnClickListener(this);
            this.gff = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.gff.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0240a interfaceC0240a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.gfg = hVar;
            this.geZ = bdBaseActivity;
            this.gfh = interfaceC0240a;
            ArrayList<g> bBF = this.gfg.bBF();
            if (bBF != null && bBF.size() > 0 && (gVar = bBF.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.gfa, e.d.cp_other_c, 1);
                al.d(this.gfa, e.f.label_bg_green, 1);
                this.gfa.setText(gVar.getText());
                this.gfa.setVisibility(0);
                if (bBF.size() > 1 && (gVar2 = bBF.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.gfb, e.d.cp_other_c, 1);
                    al.d(this.gfb, e.f.label_bg_green, 1);
                    this.gfb.setText(gVar2.getText());
                    this.gfb.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.gfg.getPosition())) {
                this.gfd.setText(this.gfg.getPosition());
                al.c(this.gfd, e.d.cp_cont_c, 1);
                this.gfd.setVisibility(0);
                al.c(this.gfc, e.f.icon_pic_place);
                this.gfc.setVisibility(0);
            }
            i bBH = this.gfg.bBH();
            if (bBH != null && !ao.isEmpty(bBH.getText())) {
                if (this.gfa.getVisibility() != 0 && this.gfb.getVisibility() != 0) {
                    al.c(this.gff, e.d.cp_link_tip_a, 1);
                    al.d(this.gff, e.f.label_bg_blue, 1);
                    this.gff.setText(bBH.getText());
                    this.gff.setVisibility(0);
                } else {
                    al.c(this.gfe, e.d.cp_link_tip_a, 1);
                    al.d(this.gfe, e.f.label_bg_blue, 1);
                    this.gfe.setText(bBH.getText());
                    this.gfe.setVisibility(0);
                }
            }
            if (this.gfa.getVisibility() != 0 && this.gfb.getVisibility() != 0 && this.gfd.getVisibility() != 0 && this.gff.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gfg != null) {
            if (view == this.gfa) {
                if (this.gfg.bBF() != null) {
                    a(this.gfg.bBF().get(0));
                }
            } else if (view == this.gfb) {
                if (this.gfg.bBF() != null) {
                    a(this.gfg.bBF().get(1));
                }
            } else if (view == this.gfe || view == this.gff) {
                i bBH = this.gfg.bBH();
                if (!ao.isEmpty(bBH.getUrl())) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, bBH.getUrl());
                    if (this.gfh != null) {
                        this.gfh.d(bBH.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.gfh != null) {
                this.gfh.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.geZ.getActivity());
                    aVar.ej(trim);
                    aVar.a(this.geZ.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.gfh != null) {
                                PbNewChudianCommonView.this.gfh.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.geZ.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.gfh != null) {
                                PbNewChudianCommonView.this.gfh.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.aP(false);
                    aVar.b(this.geZ.getPageContext());
                    aVar.Au();
                }
            }
        }
    }
}
