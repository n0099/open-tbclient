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
    private BdBaseActivity<?> fQf;
    private TextView fQg;
    private TextView fQh;
    private ImageView fQi;
    private TextView fQj;
    private TextView fQk;
    private TextView fQl;
    private h fQm;
    private a.InterfaceC0204a fQn;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fQf = null;
        this.mRootView = null;
        this.fQg = null;
        this.fQh = null;
        this.fQi = null;
        this.fQj = null;
        this.fQk = null;
        this.fQl = null;
        this.fQm = null;
        this.fQn = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fQf = null;
        this.mRootView = null;
        this.fQg = null;
        this.fQh = null;
        this.fQi = null;
        this.fQj = null;
        this.fQk = null;
        this.fQl = null;
        this.fQm = null;
        this.fQn = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pb_newchudian_common, (ViewGroup) this, true);
            this.fQg = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.fQg.setOnClickListener(this);
            this.fQh = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.fQh.setOnClickListener(this);
            this.fQj = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.fQi = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.fQk = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.fQk.setOnClickListener(this);
            this.fQl = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.fQl.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0204a interfaceC0204a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fQm = hVar;
            this.fQf = bdBaseActivity;
            this.fQn = interfaceC0204a;
            ArrayList<g> bxg = this.fQm.bxg();
            if (bxg != null && bxg.size() > 0 && (gVar = bxg.get(0)) != null && !ap.isEmpty(gVar.getText())) {
                am.c(this.fQg, d.C0142d.cp_other_c, 1);
                am.d(this.fQg, d.f.label_bg_green, 1);
                this.fQg.setText(gVar.getText());
                this.fQg.setVisibility(0);
                if (bxg.size() > 1 && (gVar2 = bxg.get(1)) != null && !ap.isEmpty(gVar2.getText())) {
                    am.c(this.fQh, d.C0142d.cp_other_c, 1);
                    am.d(this.fQh, d.f.label_bg_green, 1);
                    this.fQh.setText(gVar2.getText());
                    this.fQh.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.fQm.getPosition())) {
                this.fQj.setText(this.fQm.getPosition());
                am.c(this.fQj, d.C0142d.cp_cont_c, 1);
                this.fQj.setVisibility(0);
                am.c(this.fQi, d.f.icon_pic_place);
                this.fQi.setVisibility(0);
            }
            i bxi = this.fQm.bxi();
            if (bxi != null && !ap.isEmpty(bxi.getText())) {
                if (this.fQg.getVisibility() != 0 && this.fQh.getVisibility() != 0) {
                    am.c(this.fQl, d.C0142d.cp_link_tip_a, 1);
                    am.d(this.fQl, d.f.label_bg_blue, 1);
                    this.fQl.setText(bxi.getText());
                    this.fQl.setVisibility(0);
                } else {
                    am.c(this.fQk, d.C0142d.cp_link_tip_a, 1);
                    am.d(this.fQk, d.f.label_bg_blue, 1);
                    this.fQk.setText(bxi.getText());
                    this.fQk.setVisibility(0);
                }
            }
            if (this.fQg.getVisibility() != 0 && this.fQh.getVisibility() != 0 && this.fQj.getVisibility() != 0 && this.fQl.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fQm != null) {
            if (view == this.fQg) {
                if (this.fQm.bxg() != null) {
                    a(this.fQm.bxg().get(0));
                }
            } else if (view == this.fQh) {
                if (this.fQm.bxg() != null) {
                    a(this.fQm.bxg().get(1));
                }
            } else if (view == this.fQk || view == this.fQl) {
                i bxi = this.fQm.bxi();
                if (!ap.isEmpty(bxi.getUrl())) {
                    com.baidu.tbadk.browser.a.O(this.mContext, bxi.getUrl());
                    if (this.fQn != null) {
                        this.fQn.d(bxi.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fQn != null) {
                this.fQn.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.O(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fQf.getActivity());
                    aVar.dE(trim);
                    aVar.a(this.fQf.getResources().getString(d.k.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fQn != null) {
                                PbNewChudianCommonView.this.fQn.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fQf.getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fQn != null) {
                                PbNewChudianCommonView.this.fQn.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.ax(false);
                    aVar.b(this.fQf.getPageContext());
                    aVar.xn();
                }
            }
        }
    }
}
