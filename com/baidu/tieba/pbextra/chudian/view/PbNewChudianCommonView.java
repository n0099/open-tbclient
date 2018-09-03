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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> fQi;
    private TextView fQj;
    private TextView fQk;
    private ImageView fQl;
    private TextView fQm;
    private TextView fQn;
    private TextView fQo;
    private h fQp;
    private a.InterfaceC0203a fQq;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fQi = null;
        this.mRootView = null;
        this.fQj = null;
        this.fQk = null;
        this.fQl = null;
        this.fQm = null;
        this.fQn = null;
        this.fQo = null;
        this.fQp = null;
        this.fQq = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fQi = null;
        this.mRootView = null;
        this.fQj = null;
        this.fQk = null;
        this.fQl = null;
        this.fQm = null;
        this.fQn = null;
        this.fQo = null;
        this.fQp = null;
        this.fQq = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.pb_newchudian_common, (ViewGroup) this, true);
            this.fQj = (TextView) this.mRootView.findViewById(f.g.service_first);
            this.fQj.setOnClickListener(this);
            this.fQk = (TextView) this.mRootView.findViewById(f.g.service_second);
            this.fQk.setOnClickListener(this);
            this.fQm = (TextView) this.mRootView.findViewById(f.g.land_mark_text);
            this.fQl = (ImageView) this.mRootView.findViewById(f.g.land_mark_icon);
            this.fQn = (TextView) this.mRootView.findViewById(f.g.check_detail_up);
            this.fQn.setOnClickListener(this);
            this.fQo = (TextView) this.mRootView.findViewById(f.g.check_detail_down);
            this.fQo.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0203a interfaceC0203a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fQp = hVar;
            this.fQi = bdBaseActivity;
            this.fQq = interfaceC0203a;
            ArrayList<g> bvK = this.fQp.bvK();
            if (bvK != null && bvK.size() > 0 && (gVar = bvK.get(0)) != null && !ap.isEmpty(gVar.getText())) {
                am.c(this.fQj, f.d.cp_other_c, 1);
                am.d(this.fQj, f.C0146f.label_bg_green, 1);
                this.fQj.setText(gVar.getText());
                this.fQj.setVisibility(0);
                if (bvK.size() > 1 && (gVar2 = bvK.get(1)) != null && !ap.isEmpty(gVar2.getText())) {
                    am.c(this.fQk, f.d.cp_other_c, 1);
                    am.d(this.fQk, f.C0146f.label_bg_green, 1);
                    this.fQk.setText(gVar2.getText());
                    this.fQk.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.fQp.getPosition())) {
                this.fQm.setText(this.fQp.getPosition());
                am.c(this.fQm, f.d.cp_cont_c, 1);
                this.fQm.setVisibility(0);
                am.c(this.fQl, f.C0146f.icon_pic_place);
                this.fQl.setVisibility(0);
            }
            i bvM = this.fQp.bvM();
            if (bvM != null && !ap.isEmpty(bvM.getText())) {
                if (this.fQj.getVisibility() != 0 && this.fQk.getVisibility() != 0) {
                    am.c(this.fQo, f.d.cp_link_tip_a, 1);
                    am.d(this.fQo, f.C0146f.label_bg_blue, 1);
                    this.fQo.setText(bvM.getText());
                    this.fQo.setVisibility(0);
                } else {
                    am.c(this.fQn, f.d.cp_link_tip_a, 1);
                    am.d(this.fQn, f.C0146f.label_bg_blue, 1);
                    this.fQn.setText(bvM.getText());
                    this.fQn.setVisibility(0);
                }
            }
            if (this.fQj.getVisibility() != 0 && this.fQk.getVisibility() != 0 && this.fQm.getVisibility() != 0 && this.fQo.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fQp != null) {
            if (view == this.fQj) {
                if (this.fQp.bvK() != null) {
                    a(this.fQp.bvK().get(0));
                }
            } else if (view == this.fQk) {
                if (this.fQp.bvK() != null) {
                    a(this.fQp.bvK().get(1));
                }
            } else if (view == this.fQn || view == this.fQo) {
                i bvM = this.fQp.bvM();
                if (!ap.isEmpty(bvM.getUrl())) {
                    com.baidu.tbadk.browser.a.Q(this.mContext, bvM.getUrl());
                    if (this.fQq != null) {
                        this.fQq.d(bvM.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fQq != null) {
                this.fQq.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.Q(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fQi.getActivity());
                    aVar.dB(trim);
                    aVar.a(this.fQi.getResources().getString(f.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fQq != null) {
                                PbNewChudianCommonView.this.fQq.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fQi.getResources().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fQq != null) {
                                PbNewChudianCommonView.this.fQq.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.aw(false);
                    aVar.b(this.fQi.getPageContext());
                    aVar.xe();
                }
            }
        }
    }
}
