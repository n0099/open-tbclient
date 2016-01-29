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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private a.InterfaceC0074a cHL;
    private com.baidu.tieba.tbadkCore.data.h cVA;
    private BdBaseActivity<?> cVt;
    private TextView cVu;
    private TextView cVv;
    private ImageView cVw;
    private TextView cVx;
    private TextView cVy;
    private TextView cVz;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.cVt = null;
        this.mRootView = null;
        this.cVu = null;
        this.cVv = null;
        this.cVw = null;
        this.cVx = null;
        this.cVy = null;
        this.cVz = null;
        this.cVA = null;
        this.cHL = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.cVt = null;
        this.mRootView = null;
        this.cVu = null;
        this.cVv = null;
        this.cVw = null;
        this.cVx = null;
        this.cVy = null;
        this.cVz = null;
        this.cVA = null;
        this.cHL = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_common, (ViewGroup) this, true);
            this.cVu = (TextView) this.mRootView.findViewById(t.g.service_first);
            this.cVu.setOnClickListener(this);
            this.cVv = (TextView) this.mRootView.findViewById(t.g.service_second);
            this.cVv.setOnClickListener(this);
            this.cVx = (TextView) this.mRootView.findViewById(t.g.land_mark_text);
            this.cVw = (ImageView) this.mRootView.findViewById(t.g.land_mark_icon);
            this.cVy = (TextView) this.mRootView.findViewById(t.g.check_detail_up);
            this.cVy.setOnClickListener(this);
            this.cVz = (TextView) this.mRootView.findViewById(t.g.check_detail_down);
            this.cVz.setOnClickListener(this);
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.h hVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0074a interfaceC0074a) {
        com.baidu.tieba.tbadkCore.data.g gVar;
        com.baidu.tieba.tbadkCore.data.g gVar2;
        if (hVar != null && bdBaseActivity != null) {
            this.cVA = hVar;
            this.cVt = bdBaseActivity;
            this.cHL = interfaceC0074a;
            ArrayList<com.baidu.tieba.tbadkCore.data.g> aLW = this.cVA.aLW();
            if (aLW != null && aLW.size() > 0 && (gVar = aLW.get(0)) != null && !aw.isEmpty(gVar.getText())) {
                ar.b(this.cVu, t.d.cp_cont_i, 1);
                ar.c(this.cVu, t.f.btn_all_green_n, 1);
                this.cVu.setText(gVar.getText());
                this.cVu.setVisibility(0);
                if (aLW.size() > 1 && (gVar2 = aLW.get(1)) != null && !aw.isEmpty(gVar2.getText())) {
                    ar.b(this.cVv, t.d.cp_cont_i, 1);
                    ar.c(this.cVv, t.f.btn_all_green_n, 1);
                    this.cVv.setText(gVar2.getText());
                    this.cVv.setVisibility(0);
                }
            }
            if (!aw.isEmpty(this.cVA.getPosition())) {
                this.cVx.setText(this.cVA.getPosition());
                ar.b(this.cVx, t.d.cp_cont_c, 1);
                this.cVx.setVisibility(0);
                ar.c(this.cVw, t.f.icon_pic_place);
                this.cVw.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.data.i aLY = this.cVA.aLY();
            if (aLY != null && !aw.isEmpty(aLY.getText())) {
                if (this.cVu.getVisibility() != 0 && this.cVv.getVisibility() != 0) {
                    ar.b(this.cVz, t.d.cp_cont_i, 1);
                    ar.c(this.cVz, t.f.btn_all_blue_n, 1);
                    this.cVz.setText(aLY.getText());
                    this.cVz.setVisibility(0);
                } else {
                    ar.b(this.cVy, t.d.cp_cont_i, 1);
                    ar.c(this.cVy, t.f.btn_all_blue_n, 1);
                    this.cVy.setText(aLY.getText());
                    this.cVy.setVisibility(0);
                }
            }
            if (this.cVu.getVisibility() != 0 && this.cVv.getVisibility() != 0 && this.cVx.getVisibility() != 0 && this.cVz.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVA != null) {
            if (view == this.cVu) {
                if (this.cVA.aLW() != null) {
                    a(this.cVA.aLW().get(0));
                }
            } else if (view == this.cVv) {
                if (this.cVA.aLW() != null) {
                    a(this.cVA.aLW().get(1));
                }
            } else if (view == this.cVy || view == this.cVz) {
                com.baidu.tieba.tbadkCore.data.i aLY = this.cVA.aLY();
                if (!aw.isEmpty(aLY.getUrl())) {
                    com.baidu.tbadk.browser.f.B(this.mContext, aLY.getUrl());
                    if (this.cHL != null) {
                        this.cHL.u(aLY.getUrl(), "BUTTON", "CLICK");
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.g gVar) {
        if (gVar != null) {
            String trim = gVar.getUrl().trim();
            if (this.cHL != null) {
                this.cHL.u(trim, "BTN_PHONE", "CLICK");
            }
            if (!aw.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.f.B(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVt.getActivity());
                    aVar.cE(trim);
                    aVar.a(this.cVt.getResources().getString(t.j.phone_call), new e(this, trim));
                    aVar.b(this.cVt.getResources().getString(t.j.cancel), new f(this, trim));
                    aVar.ak(false);
                    aVar.b(this.cVt.getPageContext());
                    aVar.uj();
                }
            }
        }
    }
}
