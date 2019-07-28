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
    private BdBaseActivity<?> ifA;
    private TextView ifB;
    private TextView ifC;
    private ImageView ifD;
    private TextView ifE;
    private TextView ifF;
    private TextView ifG;
    private i ifH;
    private a.InterfaceC0371a ifI;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.ifA = null;
        this.mRootView = null;
        this.ifB = null;
        this.ifC = null;
        this.ifD = null;
        this.ifE = null;
        this.ifF = null;
        this.ifG = null;
        this.ifH = null;
        this.ifI = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.ifA = null;
        this.mRootView = null;
        this.ifB = null;
        this.ifC = null;
        this.ifD = null;
        this.ifE = null;
        this.ifF = null;
        this.ifG = null;
        this.ifH = null;
        this.ifI = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.ifB = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.ifB.setOnClickListener(this);
            this.ifC = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.ifC.setOnClickListener(this);
            this.ifE = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.ifD = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.ifF = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.ifF.setOnClickListener(this);
            this.ifG = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.ifG.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0371a interfaceC0371a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.ifH = iVar;
            this.ifA = bdBaseActivity;
            this.ifI = interfaceC0371a;
            ArrayList<h> coT = this.ifH.coT();
            if (coT != null && coT.size() > 0 && (hVar = coT.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.f(this.ifB, R.color.cp_other_c, 1);
                am.g(this.ifB, R.drawable.label_bg_green, 1);
                this.ifB.setText(hVar.getText());
                this.ifB.setVisibility(0);
                if (coT.size() > 1 && (hVar2 = coT.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.f(this.ifC, R.color.cp_other_c, 1);
                    am.g(this.ifC, R.drawable.label_bg_green, 1);
                    this.ifC.setText(hVar2.getText());
                    this.ifC.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.ifH.getPosition())) {
                this.ifE.setText(this.ifH.getPosition());
                am.f(this.ifE, R.color.cp_cont_c, 1);
                this.ifE.setVisibility(0);
                am.c(this.ifD, (int) R.drawable.icon_pic_place);
                this.ifD.setVisibility(0);
            }
            j coV = this.ifH.coV();
            if (coV != null && !aq.isEmpty(coV.getText())) {
                if (this.ifB.getVisibility() != 0 && this.ifC.getVisibility() != 0) {
                    am.f(this.ifG, R.color.cp_link_tip_a, 1);
                    am.g(this.ifG, R.drawable.label_bg_blue, 1);
                    this.ifG.setText(coV.getText());
                    this.ifG.setVisibility(0);
                } else {
                    am.f(this.ifF, R.color.cp_link_tip_a, 1);
                    am.g(this.ifF, R.drawable.label_bg_blue, 1);
                    this.ifF.setText(coV.getText());
                    this.ifF.setVisibility(0);
                }
            }
            if (this.ifB.getVisibility() != 0 && this.ifC.getVisibility() != 0 && this.ifE.getVisibility() != 0 && this.ifG.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ifH != null) {
            if (view == this.ifB) {
                if (this.ifH.coT() != null) {
                    a(this.ifH.coT().get(0));
                }
            } else if (view == this.ifC) {
                if (this.ifH.coT() != null) {
                    a(this.ifH.coT().get(1));
                }
            } else if (view == this.ifF || view == this.ifG) {
                j coV = this.ifH.coV();
                if (!aq.isEmpty(coV.getUrl())) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, coV.getUrl());
                    if (this.ifI != null) {
                        this.ifI.h(coV.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.ifI != null) {
                this.ifI.h(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ifA.getActivity());
                    aVar.mO(trim);
                    aVar.a(this.ifA.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.ifI != null) {
                                PbNewChudianCommonView.this.ifI.h(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.ifA.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.ifI != null) {
                                PbNewChudianCommonView.this.ifI.h(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dR(false);
                    aVar.b(this.ifA.getPageContext());
                    aVar.agI();
                }
            }
        }
    }
}
