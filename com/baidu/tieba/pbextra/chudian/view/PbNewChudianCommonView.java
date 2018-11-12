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
    private TextView ggA;
    private TextView ggB;
    private TextView ggC;
    private h ggD;
    private a.InterfaceC0267a ggE;
    private BdBaseActivity<?> ggw;
    private TextView ggx;
    private TextView ggy;
    private ImageView ggz;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.ggw = null;
        this.mRootView = null;
        this.ggx = null;
        this.ggy = null;
        this.ggz = null;
        this.ggA = null;
        this.ggB = null;
        this.ggC = null;
        this.ggD = null;
        this.ggE = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.ggw = null;
        this.mRootView = null;
        this.ggx = null;
        this.ggy = null;
        this.ggz = null;
        this.ggA = null;
        this.ggB = null;
        this.ggC = null;
        this.ggD = null;
        this.ggE = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.ggx = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.ggx.setOnClickListener(this);
            this.ggy = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.ggy.setOnClickListener(this);
            this.ggA = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.ggz = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.ggB = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.ggB.setOnClickListener(this);
            this.ggC = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.ggC.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0267a interfaceC0267a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.ggD = hVar;
            this.ggw = bdBaseActivity;
            this.ggE = interfaceC0267a;
            ArrayList<g> bBb = this.ggD.bBb();
            if (bBb != null && bBb.size() > 0 && (gVar = bBb.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.ggx, e.d.cp_other_c, 1);
                al.d(this.ggx, e.f.label_bg_green, 1);
                this.ggx.setText(gVar.getText());
                this.ggx.setVisibility(0);
                if (bBb.size() > 1 && (gVar2 = bBb.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.ggy, e.d.cp_other_c, 1);
                    al.d(this.ggy, e.f.label_bg_green, 1);
                    this.ggy.setText(gVar2.getText());
                    this.ggy.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.ggD.getPosition())) {
                this.ggA.setText(this.ggD.getPosition());
                al.c(this.ggA, e.d.cp_cont_c, 1);
                this.ggA.setVisibility(0);
                al.c(this.ggz, e.f.icon_pic_place);
                this.ggz.setVisibility(0);
            }
            i bBd = this.ggD.bBd();
            if (bBd != null && !ao.isEmpty(bBd.getText())) {
                if (this.ggx.getVisibility() != 0 && this.ggy.getVisibility() != 0) {
                    al.c(this.ggC, e.d.cp_link_tip_a, 1);
                    al.d(this.ggC, e.f.label_bg_blue, 1);
                    this.ggC.setText(bBd.getText());
                    this.ggC.setVisibility(0);
                } else {
                    al.c(this.ggB, e.d.cp_link_tip_a, 1);
                    al.d(this.ggB, e.f.label_bg_blue, 1);
                    this.ggB.setText(bBd.getText());
                    this.ggB.setVisibility(0);
                }
            }
            if (this.ggx.getVisibility() != 0 && this.ggy.getVisibility() != 0 && this.ggA.getVisibility() != 0 && this.ggC.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ggD != null) {
            if (view == this.ggx) {
                if (this.ggD.bBb() != null) {
                    a(this.ggD.bBb().get(0));
                }
            } else if (view == this.ggy) {
                if (this.ggD.bBb() != null) {
                    a(this.ggD.bBb().get(1));
                }
            } else if (view == this.ggB || view == this.ggC) {
                i bBd = this.ggD.bBd();
                if (!ao.isEmpty(bBd.getUrl())) {
                    com.baidu.tbadk.browser.a.ac(this.mContext, bBd.getUrl());
                    if (this.ggE != null) {
                        this.ggE.d(bBd.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.ggE != null) {
                this.ggE.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ac(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ggw.getActivity());
                    aVar.ej(trim);
                    aVar.a(this.ggw.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.ggE != null) {
                                PbNewChudianCommonView.this.ggE.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.ggw.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.ggE != null) {
                                PbNewChudianCommonView.this.ggE.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.bf(false);
                    aVar.b(this.ggw.getPageContext());
                    aVar.AB();
                }
            }
        }
    }
}
