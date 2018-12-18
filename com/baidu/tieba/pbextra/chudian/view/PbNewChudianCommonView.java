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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> gnn;
    private TextView gno;
    private TextView gnp;
    private ImageView gnq;
    private TextView gnr;
    private TextView gns;
    private TextView gnt;
    private h gnu;
    private a.InterfaceC0278a gnv;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.gnn = null;
        this.mRootView = null;
        this.gno = null;
        this.gnp = null;
        this.gnq = null;
        this.gnr = null;
        this.gns = null;
        this.gnt = null;
        this.gnu = null;
        this.gnv = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gnn = null;
        this.mRootView = null;
        this.gno = null;
        this.gnp = null;
        this.gnq = null;
        this.gnr = null;
        this.gns = null;
        this.gnt = null;
        this.gnu = null;
        this.gnv = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pb_newchudian_common, (ViewGroup) this, true);
            this.gno = (TextView) this.mRootView.findViewById(e.g.service_first);
            this.gno.setOnClickListener(this);
            this.gnp = (TextView) this.mRootView.findViewById(e.g.service_second);
            this.gnp.setOnClickListener(this);
            this.gnr = (TextView) this.mRootView.findViewById(e.g.land_mark_text);
            this.gnq = (ImageView) this.mRootView.findViewById(e.g.land_mark_icon);
            this.gns = (TextView) this.mRootView.findViewById(e.g.check_detail_up);
            this.gns.setOnClickListener(this);
            this.gnt = (TextView) this.mRootView.findViewById(e.g.check_detail_down);
            this.gnt.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0278a interfaceC0278a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.gnu = hVar;
            this.gnn = bdBaseActivity;
            this.gnv = interfaceC0278a;
            ArrayList<g> bCV = this.gnu.bCV();
            if (bCV != null && bCV.size() > 0 && (gVar = bCV.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.gno, e.d.cp_other_c, 1);
                al.d(this.gno, e.f.label_bg_green, 1);
                this.gno.setText(gVar.getText());
                this.gno.setVisibility(0);
                if (bCV.size() > 1 && (gVar2 = bCV.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.gnp, e.d.cp_other_c, 1);
                    al.d(this.gnp, e.f.label_bg_green, 1);
                    this.gnp.setText(gVar2.getText());
                    this.gnp.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.gnu.getPosition())) {
                this.gnr.setText(this.gnu.getPosition());
                al.c(this.gnr, e.d.cp_cont_c, 1);
                this.gnr.setVisibility(0);
                al.c(this.gnq, e.f.icon_pic_place);
                this.gnq.setVisibility(0);
            }
            i bCX = this.gnu.bCX();
            if (bCX != null && !ao.isEmpty(bCX.getText())) {
                if (this.gno.getVisibility() != 0 && this.gnp.getVisibility() != 0) {
                    al.c(this.gnt, e.d.cp_link_tip_a, 1);
                    al.d(this.gnt, e.f.label_bg_blue, 1);
                    this.gnt.setText(bCX.getText());
                    this.gnt.setVisibility(0);
                } else {
                    al.c(this.gns, e.d.cp_link_tip_a, 1);
                    al.d(this.gns, e.f.label_bg_blue, 1);
                    this.gns.setText(bCX.getText());
                    this.gns.setVisibility(0);
                }
            }
            if (this.gno.getVisibility() != 0 && this.gnp.getVisibility() != 0 && this.gnr.getVisibility() != 0 && this.gnt.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gnu != null) {
            if (view == this.gno) {
                if (this.gnu.bCV() != null) {
                    a(this.gnu.bCV().get(0));
                }
            } else if (view == this.gnp) {
                if (this.gnu.bCV() != null) {
                    a(this.gnu.bCV().get(1));
                }
            } else if (view == this.gns || view == this.gnt) {
                i bCX = this.gnu.bCX();
                if (!ao.isEmpty(bCX.getUrl())) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, bCX.getUrl());
                    if (this.gnv != null) {
                        this.gnv.d(bCX.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.gnv != null) {
                this.gnv.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ad(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gnn.getActivity());
                    aVar.eB(trim);
                    aVar.a(this.gnn.getResources().getString(e.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.gnv != null) {
                                PbNewChudianCommonView.this.gnv.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.gnn.getResources().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.gnv != null) {
                                PbNewChudianCommonView.this.gnv.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.bg(false);
                    aVar.b(this.gnn.getPageContext());
                    aVar.BF();
                }
            }
        }
    }
}
