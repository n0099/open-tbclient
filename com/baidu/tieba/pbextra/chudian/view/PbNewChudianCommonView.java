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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> fAH;
    private TextView fAI;
    private TextView fAJ;
    private ImageView fAK;
    private TextView fAL;
    private TextView fAM;
    private TextView fAN;
    private h fAO;
    private a.InterfaceC0186a fAP;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fAH = null;
        this.mRootView = null;
        this.fAI = null;
        this.fAJ = null;
        this.fAK = null;
        this.fAL = null;
        this.fAM = null;
        this.fAN = null;
        this.fAO = null;
        this.fAP = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fAH = null;
        this.mRootView = null;
        this.fAI = null;
        this.fAJ = null;
        this.fAK = null;
        this.fAL = null;
        this.fAM = null;
        this.fAN = null;
        this.fAO = null;
        this.fAP = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pb_newchudian_common, (ViewGroup) this, true);
            this.fAI = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.fAI.setOnClickListener(this);
            this.fAJ = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.fAJ.setOnClickListener(this);
            this.fAL = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.fAK = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.fAM = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.fAM.setOnClickListener(this);
            this.fAN = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.fAN.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0186a interfaceC0186a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fAO = hVar;
            this.fAH = bdBaseActivity;
            this.fAP = interfaceC0186a;
            ArrayList<g> brD = this.fAO.brD();
            if (brD != null && brD.size() > 0 && (gVar = brD.get(0)) != null && !an.isEmpty(gVar.getText())) {
                ak.c(this.fAI, d.C0126d.cp_other_c, 1);
                ak.d(this.fAI, d.f.label_bg_green, 1);
                this.fAI.setText(gVar.getText());
                this.fAI.setVisibility(0);
                if (brD.size() > 1 && (gVar2 = brD.get(1)) != null && !an.isEmpty(gVar2.getText())) {
                    ak.c(this.fAJ, d.C0126d.cp_other_c, 1);
                    ak.d(this.fAJ, d.f.label_bg_green, 1);
                    this.fAJ.setText(gVar2.getText());
                    this.fAJ.setVisibility(0);
                }
            }
            if (!an.isEmpty(this.fAO.getPosition())) {
                this.fAL.setText(this.fAO.getPosition());
                ak.c(this.fAL, d.C0126d.cp_cont_c, 1);
                this.fAL.setVisibility(0);
                ak.c(this.fAK, d.f.icon_pic_place);
                this.fAK.setVisibility(0);
            }
            i brF = this.fAO.brF();
            if (brF != null && !an.isEmpty(brF.getText())) {
                if (this.fAI.getVisibility() != 0 && this.fAJ.getVisibility() != 0) {
                    ak.c(this.fAN, d.C0126d.cp_link_tip_a, 1);
                    ak.d(this.fAN, d.f.label_bg_blue, 1);
                    this.fAN.setText(brF.getText());
                    this.fAN.setVisibility(0);
                } else {
                    ak.c(this.fAM, d.C0126d.cp_link_tip_a, 1);
                    ak.d(this.fAM, d.f.label_bg_blue, 1);
                    this.fAM.setText(brF.getText());
                    this.fAM.setVisibility(0);
                }
            }
            if (this.fAI.getVisibility() != 0 && this.fAJ.getVisibility() != 0 && this.fAL.getVisibility() != 0 && this.fAN.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fAO != null) {
            if (view2 == this.fAI) {
                if (this.fAO.brD() != null) {
                    a(this.fAO.brD().get(0));
                }
            } else if (view2 == this.fAJ) {
                if (this.fAO.brD() != null) {
                    a(this.fAO.brD().get(1));
                }
            } else if (view2 == this.fAM || view2 == this.fAN) {
                i brF = this.fAO.brF();
                if (!an.isEmpty(brF.getUrl())) {
                    com.baidu.tbadk.browser.a.M(this.mContext, brF.getUrl());
                    if (this.fAP != null) {
                        this.fAP.d(brF.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fAP != null) {
                this.fAP.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!an.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.M(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fAH.getActivity());
                    aVar.dc(trim);
                    aVar.a(this.fAH.getResources().getString(d.k.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fAP != null) {
                                PbNewChudianCommonView.this.fAP.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fAH.getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fAP != null) {
                                PbNewChudianCommonView.this.fAP.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.as(false);
                    aVar.b(this.fAH.getPageContext());
                    aVar.tC();
                }
            }
        }
    }
}
