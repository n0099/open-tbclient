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
    private b.a daU;
    private BdBaseActivity<?> dqo;
    private TextView dqp;
    private TextView dqq;
    private ImageView dqr;
    private TextView dqs;
    private TextView dqt;
    private TextView dqu;
    private com.baidu.tieba.tbadkCore.data.i dqv;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.dqo = null;
        this.mRootView = null;
        this.dqp = null;
        this.dqq = null;
        this.dqr = null;
        this.dqs = null;
        this.dqt = null;
        this.dqu = null;
        this.dqv = null;
        this.daU = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.dqo = null;
        this.mRootView = null;
        this.dqp = null;
        this.dqq = null;
        this.dqr = null;
        this.dqs = null;
        this.dqt = null;
        this.dqu = null;
        this.dqv = null;
        this.daU = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_common, (ViewGroup) this, true);
            this.dqp = (TextView) this.mRootView.findViewById(t.g.service_first);
            this.dqp.setOnClickListener(this);
            this.dqq = (TextView) this.mRootView.findViewById(t.g.service_second);
            this.dqq.setOnClickListener(this);
            this.dqs = (TextView) this.mRootView.findViewById(t.g.land_mark_text);
            this.dqr = (ImageView) this.mRootView.findViewById(t.g.land_mark_icon);
            this.dqt = (TextView) this.mRootView.findViewById(t.g.check_detail_up);
            this.dqt.setOnClickListener(this);
            this.dqu = (TextView) this.mRootView.findViewById(t.g.check_detail_down);
            this.dqu.setOnClickListener(this);
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.i iVar, BdBaseActivity<?> bdBaseActivity, b.a aVar) {
        com.baidu.tieba.tbadkCore.data.h hVar;
        com.baidu.tieba.tbadkCore.data.h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.dqv = iVar;
            this.dqo = bdBaseActivity;
            this.daU = aVar;
            ArrayList<com.baidu.tieba.tbadkCore.data.h> aSR = this.dqv.aSR();
            if (aSR != null && aSR.size() > 0 && (hVar = aSR.get(0)) != null && !ay.isEmpty(hVar.getText())) {
                at.b(this.dqp, t.d.cp_cont_i, 1);
                at.c(this.dqp, t.f.btn_all_green_n, 1);
                this.dqp.setText(hVar.getText());
                this.dqp.setVisibility(0);
                if (aSR.size() > 1 && (hVar2 = aSR.get(1)) != null && !ay.isEmpty(hVar2.getText())) {
                    at.b(this.dqq, t.d.cp_cont_i, 1);
                    at.c(this.dqq, t.f.btn_all_green_n, 1);
                    this.dqq.setText(hVar2.getText());
                    this.dqq.setVisibility(0);
                }
            }
            if (!ay.isEmpty(this.dqv.getPosition())) {
                this.dqs.setText(this.dqv.getPosition());
                at.b(this.dqs, t.d.cp_cont_c, 1);
                this.dqs.setVisibility(0);
                at.c(this.dqr, t.f.icon_pic_place);
                this.dqr.setVisibility(0);
            }
            com.baidu.tieba.tbadkCore.data.j aST = this.dqv.aST();
            if (aST != null && !ay.isEmpty(aST.getText())) {
                if (this.dqp.getVisibility() != 0 && this.dqq.getVisibility() != 0) {
                    at.b(this.dqu, t.d.cp_cont_i, 1);
                    at.c(this.dqu, t.f.btn_all_blue_n, 1);
                    this.dqu.setText(aST.getText());
                    this.dqu.setVisibility(0);
                } else {
                    at.b(this.dqt, t.d.cp_cont_i, 1);
                    at.c(this.dqt, t.f.btn_all_blue_n, 1);
                    this.dqt.setText(aST.getText());
                    this.dqt.setVisibility(0);
                }
            }
            if (this.dqp.getVisibility() != 0 && this.dqq.getVisibility() != 0 && this.dqs.getVisibility() != 0 && this.dqu.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dqv != null) {
            if (view == this.dqp) {
                if (this.dqv.aSR() != null) {
                    a(this.dqv.aSR().get(0));
                }
            } else if (view == this.dqq) {
                if (this.dqv.aSR() != null) {
                    a(this.dqv.aSR().get(1));
                }
            } else if (view == this.dqt || view == this.dqu) {
                com.baidu.tieba.tbadkCore.data.j aST = this.dqv.aST();
                if (!ay.isEmpty(aST.getUrl())) {
                    com.baidu.tbadk.browser.f.s(this.mContext, aST.getUrl());
                    if (this.daU != null) {
                        this.daU.y(aST.getUrl(), "BUTTON", "CLICK");
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.h hVar) {
        if (hVar != null) {
            String trim = hVar.getUrl().trim();
            if (this.daU != null) {
                this.daU.y(trim, "BTN_PHONE", "CLICK");
            }
            if (!ay.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.f.s(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dqo.getActivity());
                    aVar.cC(trim);
                    aVar.a(this.dqo.getResources().getString(t.j.phone_call), new e(this, trim));
                    aVar.b(this.dqo.getResources().getString(t.j.cancel), new f(this, trim));
                    aVar.an(false);
                    aVar.b(this.dqo.getPageContext());
                    aVar.up();
                }
            }
        }
    }
}
