package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private a.InterfaceC0072a cBf;
    private BdBaseActivity<?> cMF;
    private TextView cMG;
    private TextView cMH;
    private ImageView cMI;
    private TextView cMJ;
    private TextView cMK;
    private TextView cML;
    private com.baidu.tieba.tbadkCore.data.h cMM;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.cMF = null;
        this.mRootView = null;
        this.cMG = null;
        this.cMH = null;
        this.cMI = null;
        this.cMJ = null;
        this.cMK = null;
        this.cML = null;
        this.cMM = null;
        this.cBf = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.cMF = null;
        this.mRootView = null;
        this.cMG = null;
        this.cMH = null;
        this.cMI = null;
        this.cMJ = null;
        this.cMK = null;
        this.cML = null;
        this.cMM = null;
        this.cBf = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.pb_newchudian_common, (ViewGroup) this, true);
            this.cMG = (TextView) this.mRootView.findViewById(n.g.service_first);
            this.cMG.setOnClickListener(this);
            this.cMH = (TextView) this.mRootView.findViewById(n.g.service_second);
            this.cMH.setOnClickListener(this);
            this.cMJ = (TextView) this.mRootView.findViewById(n.g.land_mark_text);
            this.cMI = (ImageView) this.mRootView.findViewById(n.g.land_mark_icon);
            this.cMK = (TextView) this.mRootView.findViewById(n.g.check_detail_up);
            this.cMK.setOnClickListener(this);
            this.cML = (TextView) this.mRootView.findViewById(n.g.check_detail_down);
            this.cML.setOnClickListener(this);
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0072a interfaceC0072a) {
        com.baidu.tieba.tbadkCore.data.g gVar;
        com.baidu.tieba.tbadkCore.data.g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.cMM = hVar;
            this.cMF = bdBaseActivity;
            this.cBf = interfaceC0072a;
            ArrayList<com.baidu.tieba.tbadkCore.data.g> aEQ = this.cMM.aEQ();
            if (aEQ != null && aEQ.size() > 0 && (gVar = aEQ.get(0)) != null && !ax.isEmpty(gVar.getText())) {
                as.b(this.cMG, n.d.cp_cont_i, 1);
                as.c(this.cMG, n.f.btn_all_green_n, 1);
                this.cMG.setText(gVar.getText());
                this.cMG.setVisibility(0);
                if (aEQ.size() > 1 && (gVar2 = aEQ.get(1)) != null && !ax.isEmpty(gVar2.getText())) {
                    as.b(this.cMH, n.d.cp_cont_i, 1);
                    as.c(this.cMH, n.f.btn_all_green_n, 1);
                    this.cMH.setText(gVar2.getText());
                    this.cMH.setVisibility(0);
                }
            }
            if (!ax.isEmpty(this.cMM.getPosition())) {
                this.cMJ.setText(this.cMM.getPosition());
                as.b(this.cMJ, n.d.cp_cont_c, 1);
                this.cMJ.setVisibility(0);
                as.c(this.cMI, n.f.icon_pic_place);
                this.cMI.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.data.i aES = this.cMM.aES();
            if (aES != null && !ax.isEmpty(aES.getText())) {
                if (this.cMG.getVisibility() != 0 && this.cMH.getVisibility() != 0) {
                    as.b(this.cML, n.d.cp_cont_i, 1);
                    as.c(this.cML, n.f.btn_all_blue_n, 1);
                    this.cML.setText(aES.getText());
                    this.cML.setVisibility(0);
                } else {
                    as.b(this.cMK, n.d.cp_cont_i, 1);
                    as.c(this.cMK, n.f.btn_all_blue_n, 1);
                    this.cMK.setText(aES.getText());
                    this.cMK.setVisibility(0);
                }
            }
            if (this.cMG.getVisibility() != 0 && this.cMH.getVisibility() != 0 && this.cMJ.getVisibility() != 0 && this.cML.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cMM != null) {
            if (view == this.cMG) {
                if (this.cMM.aEQ() != null) {
                    a(this.cMM.aEQ().get(0));
                }
            } else if (view == this.cMH) {
                if (this.cMM.aEQ() != null) {
                    a(this.cMM.aEQ().get(1));
                }
            } else if (view == this.cMK || view == this.cML) {
                com.baidu.tieba.tbadkCore.data.i aES = this.cMM.aES();
                if (!ax.isEmpty(aES.getUrl())) {
                    com.baidu.tbadk.browser.f.B(this.mContext, aES.getUrl());
                    if (this.cBf != null) {
                        this.cBf.t(aES.getUrl(), "BUTTON", "CLICK");
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.g gVar) {
        if (gVar != null) {
            String trim = gVar.getUrl().trim();
            if (this.cBf != null) {
                this.cBf.t(trim, "BTN_PHONE", "CLICK");
            }
            if (!ax.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.f.B(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cMF.getActivity());
                    aVar.cF(trim);
                    aVar.a(this.cMF.getResources().getString(n.j.phone_call), new e(this, trim));
                    aVar.b(this.cMF.getResources().getString(n.j.cancel), new f(this, trim));
                    aVar.aj(false);
                    aVar.b(this.cMF.getPageContext());
                    aVar.tf();
                }
            }
        }
    }
}
