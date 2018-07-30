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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> fQq;
    private TextView fQr;
    private TextView fQs;
    private ImageView fQt;
    private TextView fQu;
    private TextView fQv;
    private TextView fQw;
    private h fQx;
    private a.InterfaceC0203a fQy;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fQq = null;
        this.mRootView = null;
        this.fQr = null;
        this.fQs = null;
        this.fQt = null;
        this.fQu = null;
        this.fQv = null;
        this.fQw = null;
        this.fQx = null;
        this.fQy = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fQq = null;
        this.mRootView = null;
        this.fQr = null;
        this.fQs = null;
        this.fQt = null;
        this.fQu = null;
        this.fQv = null;
        this.fQw = null;
        this.fQx = null;
        this.fQy = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pb_newchudian_common, (ViewGroup) this, true);
            this.fQr = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.fQr.setOnClickListener(this);
            this.fQs = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.fQs.setOnClickListener(this);
            this.fQu = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.fQt = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.fQv = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.fQv.setOnClickListener(this);
            this.fQw = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.fQw.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0203a interfaceC0203a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fQx = hVar;
            this.fQq = bdBaseActivity;
            this.fQy = interfaceC0203a;
            ArrayList<g> bvJ = this.fQx.bvJ();
            if (bvJ != null && bvJ.size() > 0 && (gVar = bvJ.get(0)) != null && !ap.isEmpty(gVar.getText())) {
                am.c(this.fQr, d.C0140d.cp_other_c, 1);
                am.d(this.fQr, d.f.label_bg_green, 1);
                this.fQr.setText(gVar.getText());
                this.fQr.setVisibility(0);
                if (bvJ.size() > 1 && (gVar2 = bvJ.get(1)) != null && !ap.isEmpty(gVar2.getText())) {
                    am.c(this.fQs, d.C0140d.cp_other_c, 1);
                    am.d(this.fQs, d.f.label_bg_green, 1);
                    this.fQs.setText(gVar2.getText());
                    this.fQs.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.fQx.getPosition())) {
                this.fQu.setText(this.fQx.getPosition());
                am.c(this.fQu, d.C0140d.cp_cont_c, 1);
                this.fQu.setVisibility(0);
                am.c(this.fQt, d.f.icon_pic_place);
                this.fQt.setVisibility(0);
            }
            i bvL = this.fQx.bvL();
            if (bvL != null && !ap.isEmpty(bvL.getText())) {
                if (this.fQr.getVisibility() != 0 && this.fQs.getVisibility() != 0) {
                    am.c(this.fQw, d.C0140d.cp_link_tip_a, 1);
                    am.d(this.fQw, d.f.label_bg_blue, 1);
                    this.fQw.setText(bvL.getText());
                    this.fQw.setVisibility(0);
                } else {
                    am.c(this.fQv, d.C0140d.cp_link_tip_a, 1);
                    am.d(this.fQv, d.f.label_bg_blue, 1);
                    this.fQv.setText(bvL.getText());
                    this.fQv.setVisibility(0);
                }
            }
            if (this.fQr.getVisibility() != 0 && this.fQs.getVisibility() != 0 && this.fQu.getVisibility() != 0 && this.fQw.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fQx != null) {
            if (view == this.fQr) {
                if (this.fQx.bvJ() != null) {
                    a(this.fQx.bvJ().get(0));
                }
            } else if (view == this.fQs) {
                if (this.fQx.bvJ() != null) {
                    a(this.fQx.bvJ().get(1));
                }
            } else if (view == this.fQv || view == this.fQw) {
                i bvL = this.fQx.bvL();
                if (!ap.isEmpty(bvL.getUrl())) {
                    com.baidu.tbadk.browser.a.Q(this.mContext, bvL.getUrl());
                    if (this.fQy != null) {
                        this.fQy.d(bvL.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fQy != null) {
                this.fQy.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.Q(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fQq.getActivity());
                    aVar.dB(trim);
                    aVar.a(this.fQq.getResources().getString(d.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fQy != null) {
                                PbNewChudianCommonView.this.fQy.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fQq.getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fQy != null) {
                                PbNewChudianCommonView.this.fQy.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.av(false);
                    aVar.b(this.fQq.getPageContext());
                    aVar.xf();
                }
            }
        }
    }
}
