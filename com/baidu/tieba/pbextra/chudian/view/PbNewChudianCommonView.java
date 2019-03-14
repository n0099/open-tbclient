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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private TextView hHA;
    private i hHB;
    private a.InterfaceC0348a hHC;
    private BdBaseActivity<?> hHu;
    private TextView hHv;
    private TextView hHw;
    private ImageView hHx;
    private TextView hHy;
    private TextView hHz;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.hHu = null;
        this.mRootView = null;
        this.hHv = null;
        this.hHw = null;
        this.hHx = null;
        this.hHy = null;
        this.hHz = null;
        this.hHA = null;
        this.hHB = null;
        this.hHC = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.hHu = null;
        this.mRootView = null;
        this.hHv = null;
        this.hHw = null;
        this.hHx = null;
        this.hHy = null;
        this.hHz = null;
        this.hHA = null;
        this.hHB = null;
        this.hHC = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pb_newchudian_common, (ViewGroup) this, true);
            this.hHv = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.hHv.setOnClickListener(this);
            this.hHw = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.hHw.setOnClickListener(this);
            this.hHy = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.hHx = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.hHz = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.hHz.setOnClickListener(this);
            this.hHA = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.hHA.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0348a interfaceC0348a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.hHB = iVar;
            this.hHu = bdBaseActivity;
            this.hHC = interfaceC0348a;
            ArrayList<h> cdX = this.hHB.cdX();
            if (cdX != null && cdX.size() > 0 && (hVar = cdX.get(0)) != null && !ap.isEmpty(hVar.getText())) {
                al.d(this.hHv, d.C0277d.cp_other_c, 1);
                al.e(this.hHv, d.f.label_bg_green, 1);
                this.hHv.setText(hVar.getText());
                this.hHv.setVisibility(0);
                if (cdX.size() > 1 && (hVar2 = cdX.get(1)) != null && !ap.isEmpty(hVar2.getText())) {
                    al.d(this.hHw, d.C0277d.cp_other_c, 1);
                    al.e(this.hHw, d.f.label_bg_green, 1);
                    this.hHw.setText(hVar2.getText());
                    this.hHw.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.hHB.getPosition())) {
                this.hHy.setText(this.hHB.getPosition());
                al.d(this.hHy, d.C0277d.cp_cont_c, 1);
                this.hHy.setVisibility(0);
                al.c(this.hHx, d.f.icon_pic_place);
                this.hHx.setVisibility(0);
            }
            j cdZ = this.hHB.cdZ();
            if (cdZ != null && !ap.isEmpty(cdZ.getText())) {
                if (this.hHv.getVisibility() != 0 && this.hHw.getVisibility() != 0) {
                    al.d(this.hHA, d.C0277d.cp_link_tip_a, 1);
                    al.e(this.hHA, d.f.label_bg_blue, 1);
                    this.hHA.setText(cdZ.getText());
                    this.hHA.setVisibility(0);
                } else {
                    al.d(this.hHz, d.C0277d.cp_link_tip_a, 1);
                    al.e(this.hHz, d.f.label_bg_blue, 1);
                    this.hHz.setText(cdZ.getText());
                    this.hHz.setVisibility(0);
                }
            }
            if (this.hHv.getVisibility() != 0 && this.hHw.getVisibility() != 0 && this.hHy.getVisibility() != 0 && this.hHA.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hHB != null) {
            if (view == this.hHv) {
                if (this.hHB.cdX() != null) {
                    a(this.hHB.cdX().get(0));
                }
            } else if (view == this.hHw) {
                if (this.hHB.cdX() != null) {
                    a(this.hHB.cdX().get(1));
                }
            } else if (view == this.hHz || view == this.hHA) {
                j cdZ = this.hHB.cdZ();
                if (!ap.isEmpty(cdZ.getUrl())) {
                    com.baidu.tbadk.browser.a.ar(this.mContext, cdZ.getUrl());
                    if (this.hHC != null) {
                        this.hHC.d(cdZ.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.hHC != null) {
                this.hHC.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.ar(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hHu.getActivity());
                    aVar.ly(trim);
                    aVar.a(this.hHu.getResources().getString(d.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.hHC != null) {
                                PbNewChudianCommonView.this.hHC.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.hHu.getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.hHC != null) {
                                PbNewChudianCommonView.this.hHC.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dr(false);
                    aVar.b(this.hHu.getPageContext());
                    aVar.aaZ();
                }
            }
        }
    }
}
