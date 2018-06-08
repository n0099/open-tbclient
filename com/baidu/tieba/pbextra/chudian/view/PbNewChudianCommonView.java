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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> fMc;
    private TextView fMd;
    private TextView fMe;
    private ImageView fMf;
    private TextView fMg;
    private TextView fMh;
    private TextView fMi;
    private h fMj;
    private a.InterfaceC0202a fMk;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.fMc = null;
        this.mRootView = null;
        this.fMd = null;
        this.fMe = null;
        this.fMf = null;
        this.fMg = null;
        this.fMh = null;
        this.fMi = null;
        this.fMj = null;
        this.fMk = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.fMc = null;
        this.mRootView = null;
        this.fMd = null;
        this.fMe = null;
        this.fMf = null;
        this.fMg = null;
        this.fMh = null;
        this.fMi = null;
        this.fMj = null;
        this.fMk = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pb_newchudian_common, (ViewGroup) this, true);
            this.fMd = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.fMd.setOnClickListener(this);
            this.fMe = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.fMe.setOnClickListener(this);
            this.fMg = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.fMf = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.fMh = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.fMh.setOnClickListener(this);
            this.fMi = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.fMi.setOnClickListener(this);
        }
    }

    public void setData(h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0202a interfaceC0202a) {
        g gVar;
        g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.fMj = hVar;
            this.fMc = bdBaseActivity;
            this.fMk = interfaceC0202a;
            ArrayList<g> bwF = this.fMj.bwF();
            if (bwF != null && bwF.size() > 0 && (gVar = bwF.get(0)) != null && !ao.isEmpty(gVar.getText())) {
                al.c(this.fMd, d.C0141d.cp_other_c, 1);
                al.d(this.fMd, d.f.label_bg_green, 1);
                this.fMd.setText(gVar.getText());
                this.fMd.setVisibility(0);
                if (bwF.size() > 1 && (gVar2 = bwF.get(1)) != null && !ao.isEmpty(gVar2.getText())) {
                    al.c(this.fMe, d.C0141d.cp_other_c, 1);
                    al.d(this.fMe, d.f.label_bg_green, 1);
                    this.fMe.setText(gVar2.getText());
                    this.fMe.setVisibility(0);
                }
            }
            if (!ao.isEmpty(this.fMj.getPosition())) {
                this.fMg.setText(this.fMj.getPosition());
                al.c(this.fMg, d.C0141d.cp_cont_c, 1);
                this.fMg.setVisibility(0);
                al.c(this.fMf, d.f.icon_pic_place);
                this.fMf.setVisibility(0);
            }
            i bwH = this.fMj.bwH();
            if (bwH != null && !ao.isEmpty(bwH.getText())) {
                if (this.fMd.getVisibility() != 0 && this.fMe.getVisibility() != 0) {
                    al.c(this.fMi, d.C0141d.cp_link_tip_a, 1);
                    al.d(this.fMi, d.f.label_bg_blue, 1);
                    this.fMi.setText(bwH.getText());
                    this.fMi.setVisibility(0);
                } else {
                    al.c(this.fMh, d.C0141d.cp_link_tip_a, 1);
                    al.d(this.fMh, d.f.label_bg_blue, 1);
                    this.fMh.setText(bwH.getText());
                    this.fMh.setVisibility(0);
                }
            }
            if (this.fMd.getVisibility() != 0 && this.fMe.getVisibility() != 0 && this.fMg.getVisibility() != 0 && this.fMi.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fMj != null) {
            if (view == this.fMd) {
                if (this.fMj.bwF() != null) {
                    a(this.fMj.bwF().get(0));
                }
            } else if (view == this.fMe) {
                if (this.fMj.bwF() != null) {
                    a(this.fMj.bwF().get(1));
                }
            } else if (view == this.fMh || view == this.fMi) {
                i bwH = this.fMj.bwH();
                if (!ao.isEmpty(bwH.getUrl())) {
                    com.baidu.tbadk.browser.a.O(this.mContext, bwH.getUrl());
                    if (this.fMk != null) {
                        this.fMk.d(bwH.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.fMk != null) {
                this.fMk.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ao.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.O(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMc.getActivity());
                    aVar.dB(trim);
                    aVar.a(this.fMc.getResources().getString(d.k.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.fMk != null) {
                                PbNewChudianCommonView.this.fMk.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.fMc.getResources().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.fMk != null) {
                                PbNewChudianCommonView.this.fMk.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.av(false);
                    aVar.b(this.fMc.getPageContext());
                    aVar.xa();
                }
            }
        }
    }
}
