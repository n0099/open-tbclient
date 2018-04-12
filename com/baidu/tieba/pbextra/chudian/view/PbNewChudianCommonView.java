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
    private BdBaseActivity<?> fzE;
    private TextView fzF;
    private TextView fzG;
    private ImageView fzH;
    private TextView fzI;
    private TextView fzJ;
    private TextView fzK;
    private h fzL;
    private a.InterfaceC0186a fzM;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fzE = null;
        this.mRootView = null;
        this.fzF = null;
        this.fzG = null;
        this.fzH = null;
        this.fzI = null;
        this.fzJ = null;
        this.fzK = null;
        this.fzL = null;
        this.fzM = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fzE = null;
        this.mRootView = null;
        this.fzF = null;
        this.fzG = null;
        this.fzH = null;
        this.fzI = null;
        this.fzJ = null;
        this.fzK = null;
        this.fzL = null;
        this.fzM = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pb_newchudian_common, (ViewGroup) this, true);
            this.fzF = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.fzF.setOnClickListener(this);
            this.fzG = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.fzG.setOnClickListener(this);
            this.fzI = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.fzH = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.fzJ = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.fzJ.setOnClickListener(this);
            this.fzK = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.fzK.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0186a interfaceC0186a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fzL = hVar;
            this.fzE = bdBaseActivity;
            this.fzM = interfaceC0186a;
            ArrayList<g> brF = this.fzL.brF();
            if (brF != null && brF.size() > 0 && (gVar = brF.get(0)) != null && !an.isEmpty(gVar.getText())) {
                ak.c(this.fzF, d.C0126d.cp_other_c, 1);
                ak.d(this.fzF, d.f.label_bg_green, 1);
                this.fzF.setText(gVar.getText());
                this.fzF.setVisibility(0);
                if (brF.size() > 1 && (gVar2 = brF.get(1)) != null && !an.isEmpty(gVar2.getText())) {
                    ak.c(this.fzG, d.C0126d.cp_other_c, 1);
                    ak.d(this.fzG, d.f.label_bg_green, 1);
                    this.fzG.setText(gVar2.getText());
                    this.fzG.setVisibility(0);
                }
            }
            if (!an.isEmpty(this.fzL.getPosition())) {
                this.fzI.setText(this.fzL.getPosition());
                ak.c(this.fzI, d.C0126d.cp_cont_c, 1);
                this.fzI.setVisibility(0);
                ak.c(this.fzH, d.f.icon_pic_place);
                this.fzH.setVisibility(0);
            }
            i brH = this.fzL.brH();
            if (brH != null && !an.isEmpty(brH.getText())) {
                if (this.fzF.getVisibility() != 0 && this.fzG.getVisibility() != 0) {
                    ak.c(this.fzK, d.C0126d.cp_link_tip_a, 1);
                    ak.d(this.fzK, d.f.label_bg_blue, 1);
                    this.fzK.setText(brH.getText());
                    this.fzK.setVisibility(0);
                } else {
                    ak.c(this.fzJ, d.C0126d.cp_link_tip_a, 1);
                    ak.d(this.fzJ, d.f.label_bg_blue, 1);
                    this.fzJ.setText(brH.getText());
                    this.fzJ.setVisibility(0);
                }
            }
            if (this.fzF.getVisibility() != 0 && this.fzG.getVisibility() != 0 && this.fzI.getVisibility() != 0 && this.fzK.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fzL != null) {
            if (view2 == this.fzF) {
                if (this.fzL.brF() != null) {
                    a(this.fzL.brF().get(0));
                }
            } else if (view2 == this.fzG) {
                if (this.fzL.brF() != null) {
                    a(this.fzL.brF().get(1));
                }
            } else if (view2 == this.fzJ || view2 == this.fzK) {
                i brH = this.fzL.brH();
                if (!an.isEmpty(brH.getUrl())) {
                    com.baidu.tbadk.browser.a.M(this.mContext, brH.getUrl());
                    if (this.fzM != null) {
                        this.fzM.d(brH.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fzM != null) {
                this.fzM.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!an.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.M(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fzE.getActivity());
                    aVar.dc(trim);
                    aVar.a(this.fzE.getResources().getString(d.k.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fzM != null) {
                                PbNewChudianCommonView.this.fzM.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fzE.getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fzM != null) {
                                PbNewChudianCommonView.this.fzM.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.as(false);
                    aVar.b(this.fzE.getPageContext());
                    aVar.tD();
                }
            }
        }
    }
}
