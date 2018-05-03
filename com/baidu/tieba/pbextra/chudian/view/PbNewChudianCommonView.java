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
    private BdBaseActivity<?> fzB;
    private TextView fzC;
    private TextView fzD;
    private ImageView fzE;
    private TextView fzF;
    private TextView fzG;
    private TextView fzH;
    private h fzI;
    private a.InterfaceC0186a fzJ;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fzB = null;
        this.mRootView = null;
        this.fzC = null;
        this.fzD = null;
        this.fzE = null;
        this.fzF = null;
        this.fzG = null;
        this.fzH = null;
        this.fzI = null;
        this.fzJ = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fzB = null;
        this.mRootView = null;
        this.fzC = null;
        this.fzD = null;
        this.fzE = null;
        this.fzF = null;
        this.fzG = null;
        this.fzH = null;
        this.fzI = null;
        this.fzJ = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pb_newchudian_common, (ViewGroup) this, true);
            this.fzC = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.fzC.setOnClickListener(this);
            this.fzD = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.fzD.setOnClickListener(this);
            this.fzF = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.fzE = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.fzG = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.fzG.setOnClickListener(this);
            this.fzH = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.fzH.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0186a interfaceC0186a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fzI = hVar;
            this.fzB = bdBaseActivity;
            this.fzJ = interfaceC0186a;
            ArrayList<g> brF = this.fzI.brF();
            if (brF != null && brF.size() > 0 && (gVar = brF.get(0)) != null && !an.isEmpty(gVar.getText())) {
                ak.c(this.fzC, d.C0126d.cp_other_c, 1);
                ak.d(this.fzC, d.f.label_bg_green, 1);
                this.fzC.setText(gVar.getText());
                this.fzC.setVisibility(0);
                if (brF.size() > 1 && (gVar2 = brF.get(1)) != null && !an.isEmpty(gVar2.getText())) {
                    ak.c(this.fzD, d.C0126d.cp_other_c, 1);
                    ak.d(this.fzD, d.f.label_bg_green, 1);
                    this.fzD.setText(gVar2.getText());
                    this.fzD.setVisibility(0);
                }
            }
            if (!an.isEmpty(this.fzI.getPosition())) {
                this.fzF.setText(this.fzI.getPosition());
                ak.c(this.fzF, d.C0126d.cp_cont_c, 1);
                this.fzF.setVisibility(0);
                ak.c(this.fzE, d.f.icon_pic_place);
                this.fzE.setVisibility(0);
            }
            i brH = this.fzI.brH();
            if (brH != null && !an.isEmpty(brH.getText())) {
                if (this.fzC.getVisibility() != 0 && this.fzD.getVisibility() != 0) {
                    ak.c(this.fzH, d.C0126d.cp_link_tip_a, 1);
                    ak.d(this.fzH, d.f.label_bg_blue, 1);
                    this.fzH.setText(brH.getText());
                    this.fzH.setVisibility(0);
                } else {
                    ak.c(this.fzG, d.C0126d.cp_link_tip_a, 1);
                    ak.d(this.fzG, d.f.label_bg_blue, 1);
                    this.fzG.setText(brH.getText());
                    this.fzG.setVisibility(0);
                }
            }
            if (this.fzC.getVisibility() != 0 && this.fzD.getVisibility() != 0 && this.fzF.getVisibility() != 0 && this.fzH.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fzI != null) {
            if (view2 == this.fzC) {
                if (this.fzI.brF() != null) {
                    a(this.fzI.brF().get(0));
                }
            } else if (view2 == this.fzD) {
                if (this.fzI.brF() != null) {
                    a(this.fzI.brF().get(1));
                }
            } else if (view2 == this.fzG || view2 == this.fzH) {
                i brH = this.fzI.brH();
                if (!an.isEmpty(brH.getUrl())) {
                    com.baidu.tbadk.browser.a.M(this.mContext, brH.getUrl());
                    if (this.fzJ != null) {
                        this.fzJ.d(brH.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fzJ != null) {
                this.fzJ.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!an.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.M(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fzB.getActivity());
                    aVar.dc(trim);
                    aVar.a(this.fzB.getResources().getString(d.k.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fzJ != null) {
                                PbNewChudianCommonView.this.fzJ.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fzB.getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fzJ != null) {
                                PbNewChudianCommonView.this.fzJ.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.as(false);
                    aVar.b(this.fzB.getPageContext());
                    aVar.tD();
                }
            }
        }
    }
}
