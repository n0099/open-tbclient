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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private b.a ddo;
    private BdBaseActivity<?> dss;
    private TextView dst;
    private TextView dsu;
    private ImageView dsv;
    private TextView dsw;
    private TextView dsx;
    private TextView dsy;
    private com.baidu.tieba.tbadkCore.data.i dsz;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.dss = null;
        this.mRootView = null;
        this.dst = null;
        this.dsu = null;
        this.dsv = null;
        this.dsw = null;
        this.dsx = null;
        this.dsy = null;
        this.dsz = null;
        this.ddo = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.dss = null;
        this.mRootView = null;
        this.dst = null;
        this.dsu = null;
        this.dsv = null;
        this.dsw = null;
        this.dsx = null;
        this.dsy = null;
        this.dsz = null;
        this.ddo = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_common, (ViewGroup) this, true);
            this.dst = (TextView) this.mRootView.findViewById(t.g.service_first);
            this.dst.setOnClickListener(this);
            this.dsu = (TextView) this.mRootView.findViewById(t.g.service_second);
            this.dsu.setOnClickListener(this);
            this.dsw = (TextView) this.mRootView.findViewById(t.g.land_mark_text);
            this.dsv = (ImageView) this.mRootView.findViewById(t.g.land_mark_icon);
            this.dsx = (TextView) this.mRootView.findViewById(t.g.check_detail_up);
            this.dsx.setOnClickListener(this);
            this.dsy = (TextView) this.mRootView.findViewById(t.g.check_detail_down);
            this.dsy.setOnClickListener(this);
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.i iVar, BdBaseActivity<?> bdBaseActivity, b.a aVar) {
        com.baidu.tieba.tbadkCore.data.h hVar;
        com.baidu.tieba.tbadkCore.data.h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.dsz = iVar;
            this.dss = bdBaseActivity;
            this.ddo = aVar;
            ArrayList<com.baidu.tieba.tbadkCore.data.h> aTy = this.dsz.aTy();
            if (aTy != null && aTy.size() > 0 && (hVar = aTy.get(0)) != null && !ay.isEmpty(hVar.getText())) {
                at.c(this.dst, t.d.cp_cont_i, 1);
                at.d(this.dst, t.f.btn_all_green_n, 1);
                this.dst.setText(hVar.getText());
                this.dst.setVisibility(0);
                if (aTy.size() > 1 && (hVar2 = aTy.get(1)) != null && !ay.isEmpty(hVar2.getText())) {
                    at.c(this.dsu, t.d.cp_cont_i, 1);
                    at.d(this.dsu, t.f.btn_all_green_n, 1);
                    this.dsu.setText(hVar2.getText());
                    this.dsu.setVisibility(0);
                }
            }
            if (!ay.isEmpty(this.dsz.getPosition())) {
                this.dsw.setText(this.dsz.getPosition());
                at.c(this.dsw, t.d.cp_cont_c, 1);
                this.dsw.setVisibility(0);
                at.c(this.dsv, t.f.icon_pic_place);
                this.dsv.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.data.j aTA = this.dsz.aTA();
            if (aTA != null && !ay.isEmpty(aTA.getText())) {
                if (this.dst.getVisibility() != 0 && this.dsu.getVisibility() != 0) {
                    at.c(this.dsy, t.d.cp_cont_i, 1);
                    at.d(this.dsy, t.f.btn_all_blue_n, 1);
                    this.dsy.setText(aTA.getText());
                    this.dsy.setVisibility(0);
                } else {
                    at.c(this.dsx, t.d.cp_cont_i, 1);
                    at.d(this.dsx, t.f.btn_all_blue_n, 1);
                    this.dsx.setText(aTA.getText());
                    this.dsx.setVisibility(0);
                }
            }
            if (this.dst.getVisibility() != 0 && this.dsu.getVisibility() != 0 && this.dsw.getVisibility() != 0 && this.dsy.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dsz != null) {
            if (view == this.dst) {
                if (this.dsz.aTy() != null) {
                    a(this.dsz.aTy().get(0));
                }
            } else if (view == this.dsu) {
                if (this.dsz.aTy() != null) {
                    a(this.dsz.aTy().get(1));
                }
            } else if (view == this.dsx || view == this.dsy) {
                com.baidu.tieba.tbadkCore.data.j aTA = this.dsz.aTA();
                if (!ay.isEmpty(aTA.getUrl())) {
                    com.baidu.tbadk.browser.f.t(this.mContext, aTA.getUrl());
                    if (this.ddo != null) {
                        this.ddo.z(aTA.getUrl(), "BUTTON", "CLICK");
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.h hVar) {
        if (hVar != null) {
            String trim = hVar.getUrl().trim();
            if (this.ddo != null) {
                this.ddo.z(trim, "BTN_PHONE", "CLICK");
            }
            if (!ay.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.f.t(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dss.getActivity());
                    aVar.cA(trim);
                    aVar.a(this.dss.getResources().getString(t.j.phone_call), new k(this, trim));
                    aVar.b(this.dss.getResources().getString(t.j.cancel), new l(this, trim));
                    aVar.aq(false);
                    aVar.b(this.dss.getPageContext());
                    aVar.rV();
                }
            }
        }
    }
}
