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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> igC;
    private TextView igD;
    private TextView igE;
    private ImageView igF;
    private TextView igG;
    private TextView igH;
    private TextView igI;
    private i igJ;
    private a.InterfaceC0371a igK;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.igC = null;
        this.mRootView = null;
        this.igD = null;
        this.igE = null;
        this.igF = null;
        this.igG = null;
        this.igH = null;
        this.igI = null;
        this.igJ = null;
        this.igK = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.igC = null;
        this.mRootView = null;
        this.igD = null;
        this.igE = null;
        this.igF = null;
        this.igG = null;
        this.igH = null;
        this.igI = null;
        this.igJ = null;
        this.igK = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.igD = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.igD.setOnClickListener(this);
            this.igE = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.igE.setOnClickListener(this);
            this.igG = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.igF = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.igH = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.igH.setOnClickListener(this);
            this.igI = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.igI.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0371a interfaceC0371a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.igJ = iVar;
            this.igC = bdBaseActivity;
            this.igK = interfaceC0371a;
            ArrayList<h> cpp = this.igJ.cpp();
            if (cpp != null && cpp.size() > 0 && (hVar = cpp.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.f(this.igD, R.color.cp_other_c, 1);
                am.g(this.igD, R.drawable.label_bg_green, 1);
                this.igD.setText(hVar.getText());
                this.igD.setVisibility(0);
                if (cpp.size() > 1 && (hVar2 = cpp.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.f(this.igE, R.color.cp_other_c, 1);
                    am.g(this.igE, R.drawable.label_bg_green, 1);
                    this.igE.setText(hVar2.getText());
                    this.igE.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.igJ.getPosition())) {
                this.igG.setText(this.igJ.getPosition());
                am.f(this.igG, R.color.cp_cont_c, 1);
                this.igG.setVisibility(0);
                am.c(this.igF, (int) R.drawable.icon_pic_place);
                this.igF.setVisibility(0);
            }
            j cpr = this.igJ.cpr();
            if (cpr != null && !aq.isEmpty(cpr.getText())) {
                if (this.igD.getVisibility() != 0 && this.igE.getVisibility() != 0) {
                    am.f(this.igI, R.color.cp_link_tip_a, 1);
                    am.g(this.igI, R.drawable.label_bg_blue, 1);
                    this.igI.setText(cpr.getText());
                    this.igI.setVisibility(0);
                } else {
                    am.f(this.igH, R.color.cp_link_tip_a, 1);
                    am.g(this.igH, R.drawable.label_bg_blue, 1);
                    this.igH.setText(cpr.getText());
                    this.igH.setVisibility(0);
                }
            }
            if (this.igD.getVisibility() != 0 && this.igE.getVisibility() != 0 && this.igG.getVisibility() != 0 && this.igI.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.igJ != null) {
            if (view == this.igD) {
                if (this.igJ.cpp() != null) {
                    a(this.igJ.cpp().get(0));
                }
            } else if (view == this.igE) {
                if (this.igJ.cpp() != null) {
                    a(this.igJ.cpp().get(1));
                }
            } else if (view == this.igH || view == this.igI) {
                j cpr = this.igJ.cpr();
                if (!aq.isEmpty(cpr.getUrl())) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, cpr.getUrl());
                    if (this.igK != null) {
                        this.igK.h(cpr.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.igK != null) {
                this.igK.h(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.igC.getActivity());
                    aVar.mO(trim);
                    aVar.a(this.igC.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.igK != null) {
                                PbNewChudianCommonView.this.igK.h(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.igC.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.igK != null) {
                                PbNewChudianCommonView.this.igK.h(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dR(false);
                    aVar.b(this.igC.getPageContext());
                    aVar.agK();
                }
            }
        }
    }
}
