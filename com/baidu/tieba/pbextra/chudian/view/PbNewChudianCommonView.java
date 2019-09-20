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
    private BdBaseActivity<?> iiB;
    private TextView iiC;
    private TextView iiD;
    private ImageView iiE;
    private TextView iiF;
    private TextView iiG;
    private TextView iiH;
    private i iiI;
    private a.InterfaceC0382a iiJ;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.iiB = null;
        this.mRootView = null;
        this.iiC = null;
        this.iiD = null;
        this.iiE = null;
        this.iiF = null;
        this.iiG = null;
        this.iiH = null;
        this.iiI = null;
        this.iiJ = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.iiB = null;
        this.mRootView = null;
        this.iiC = null;
        this.iiD = null;
        this.iiE = null;
        this.iiF = null;
        this.iiG = null;
        this.iiH = null;
        this.iiI = null;
        this.iiJ = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.iiC = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.iiC.setOnClickListener(this);
            this.iiD = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.iiD.setOnClickListener(this);
            this.iiF = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.iiE = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.iiG = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.iiG.setOnClickListener(this);
            this.iiH = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.iiH.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0382a interfaceC0382a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.iiI = iVar;
            this.iiB = bdBaseActivity;
            this.iiJ = interfaceC0382a;
            ArrayList<h> cqd = this.iiI.cqd();
            if (cqd != null && cqd.size() > 0 && (hVar = cqd.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.f(this.iiC, R.color.cp_other_c, 1);
                am.g(this.iiC, R.drawable.label_bg_green, 1);
                this.iiC.setText(hVar.getText());
                this.iiC.setVisibility(0);
                if (cqd.size() > 1 && (hVar2 = cqd.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.f(this.iiD, R.color.cp_other_c, 1);
                    am.g(this.iiD, R.drawable.label_bg_green, 1);
                    this.iiD.setText(hVar2.getText());
                    this.iiD.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.iiI.getPosition())) {
                this.iiF.setText(this.iiI.getPosition());
                am.f(this.iiF, R.color.cp_cont_c, 1);
                this.iiF.setVisibility(0);
                am.c(this.iiE, (int) R.drawable.icon_pic_place);
                this.iiE.setVisibility(0);
            }
            j cqf = this.iiI.cqf();
            if (cqf != null && !aq.isEmpty(cqf.getText())) {
                if (this.iiC.getVisibility() != 0 && this.iiD.getVisibility() != 0) {
                    am.f(this.iiH, R.color.cp_link_tip_a, 1);
                    am.g(this.iiH, R.drawable.label_bg_blue, 1);
                    this.iiH.setText(cqf.getText());
                    this.iiH.setVisibility(0);
                } else {
                    am.f(this.iiG, R.color.cp_link_tip_a, 1);
                    am.g(this.iiG, R.drawable.label_bg_blue, 1);
                    this.iiG.setText(cqf.getText());
                    this.iiG.setVisibility(0);
                }
            }
            if (this.iiC.getVisibility() != 0 && this.iiD.getVisibility() != 0 && this.iiF.getVisibility() != 0 && this.iiH.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iiI != null) {
            if (view == this.iiC) {
                if (this.iiI.cqd() != null) {
                    a(this.iiI.cqd().get(0));
                }
            } else if (view == this.iiD) {
                if (this.iiI.cqd() != null) {
                    a(this.iiI.cqd().get(1));
                }
            } else if (view == this.iiG || view == this.iiH) {
                j cqf = this.iiI.cqf();
                if (!aq.isEmpty(cqf.getUrl())) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, cqf.getUrl());
                    if (this.iiJ != null) {
                        this.iiJ.h(cqf.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.iiJ != null) {
                this.iiJ.h(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ae(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iiB.getActivity());
                    aVar.mQ(trim);
                    aVar.a(this.iiB.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.iiJ != null) {
                                PbNewChudianCommonView.this.iiJ.h(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.iiB.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.iiJ != null) {
                                PbNewChudianCommonView.this.iiJ.h(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dR(false);
                    aVar.b(this.iiB.getPageContext());
                    aVar.agO();
                }
            }
        }
    }
}
