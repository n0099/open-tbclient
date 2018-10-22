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
    private BdBaseActivity<?> gfa;
    private TextView gfb;
    private TextView gfc;
    private ImageView gfd;
    private TextView gfe;
    private TextView gff;
    private TextView gfg;
    private h gfh;
    private a.InterfaceC0240a gfi;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.gfa = null;
        this.mRootView = null;
        this.gfb = null;
        this.gfc = null;
        this.gfd = null;
        this.gfe = null;
        this.gff = null;
        this.gfg = null;
        this.gfh = null;
        this.gfi = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gfa = null;
        this.mRootView = null;
        this.gfb = null;
        this.gfc = null;
        this.gfd = null;
        this.gfe = null;
        this.gff = null;
        this.gfg = null;
        this.gfh = null;
        this.gfi = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.gfb = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.gfb.setOnClickListener(this);
            this.gfc = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.gfc.setOnClickListener(this);
            this.gfe = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.gfd = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.gff = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.gff.setOnClickListener(this);
            this.gfg = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.gfg.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0240a interfaceC0240a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.gfh = hVar;
            this.gfa = bdBaseActivity;
            this.gfi = interfaceC0240a;
            ArrayList<g> bBF = this.gfh.bBF();
            if (bBF != null && bBF.size() > 0 && (gVar = bBF.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.gfb, e.d.cp_other_c, 1);
                al.d(this.gfb, e.f.label_bg_green, 1);
                this.gfb.setText(gVar.getText());
                this.gfb.setVisibility(0);
                if (bBF.size() > 1 && (gVar2 = bBF.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.gfc, e.d.cp_other_c, 1);
                    al.d(this.gfc, e.f.label_bg_green, 1);
                    this.gfc.setText(gVar2.getText());
                    this.gfc.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.gfh.getPosition())) {
                this.gfe.setText(this.gfh.getPosition());
                al.c(this.gfe, e.d.cp_cont_c, 1);
                this.gfe.setVisibility(0);
                al.c(this.gfd, e.f.icon_pic_place);
                this.gfd.setVisibility(0);
            }
            i bBH = this.gfh.bBH();
            if (bBH != null && !ao.isEmpty(bBH.getText())) {
                if (this.gfb.getVisibility() != 0 && this.gfc.getVisibility() != 0) {
                    al.c(this.gfg, e.d.cp_link_tip_a, 1);
                    al.d(this.gfg, e.f.label_bg_blue, 1);
                    this.gfg.setText(bBH.getText());
                    this.gfg.setVisibility(0);
                } else {
                    al.c(this.gff, e.d.cp_link_tip_a, 1);
                    al.d(this.gff, e.f.label_bg_blue, 1);
                    this.gff.setText(bBH.getText());
                    this.gff.setVisibility(0);
                }
            }
            if (this.gfb.getVisibility() != 0 && this.gfc.getVisibility() != 0 && this.gfe.getVisibility() != 0 && this.gfg.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gfh != null) {
            if (view == this.gfb) {
                if (this.gfh.bBF() != null) {
                    a(this.gfh.bBF().get(0));
                }
            } else if (view == this.gfc) {
                if (this.gfh.bBF() != null) {
                    a(this.gfh.bBF().get(1));
                }
            } else if (view == this.gff || view == this.gfg) {
                i bBH = this.gfh.bBH();
                if (!ao.isEmpty(bBH.getUrl())) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, bBH.getUrl());
                    if (this.gfi != null) {
                        this.gfi.d(bBH.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.gfi != null) {
                this.gfi.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gfa.getActivity());
                    aVar.ej(trim);
                    aVar.a(this.gfa.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.gfi != null) {
                                PbNewChudianCommonView.this.gfi.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.gfa.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.gfi != null) {
                                PbNewChudianCommonView.this.gfi.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.aP(false);
                    aVar.b(this.gfa.getPageContext());
                    aVar.Au();
                }
            }
        }
    }
}
