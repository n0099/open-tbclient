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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> hZk;
    private TextView hZl;
    private TextView hZm;
    private ImageView hZn;
    private TextView hZo;
    private TextView hZp;
    private TextView hZq;
    private i hZr;
    private a.InterfaceC0366a hZs;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.hZk = null;
        this.mRootView = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = null;
        this.hZp = null;
        this.hZq = null;
        this.hZr = null;
        this.hZs = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.hZk = null;
        this.mRootView = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = null;
        this.hZp = null;
        this.hZq = null;
        this.hZr = null;
        this.hZs = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.hZl = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.hZl.setOnClickListener(this);
            this.hZm = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.hZm.setOnClickListener(this);
            this.hZo = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.hZn = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.hZp = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.hZp.setOnClickListener(this);
            this.hZq = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.hZq.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0366a interfaceC0366a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.hZr = iVar;
            this.hZk = bdBaseActivity;
            this.hZs = interfaceC0366a;
            ArrayList<h> cmb = this.hZr.cmb();
            if (cmb != null && cmb.size() > 0 && (hVar = cmb.get(0)) != null && !ap.isEmpty(hVar.getText())) {
                al.f(this.hZl, R.color.cp_other_c, 1);
                al.g(this.hZl, R.drawable.label_bg_green, 1);
                this.hZl.setText(hVar.getText());
                this.hZl.setVisibility(0);
                if (cmb.size() > 1 && (hVar2 = cmb.get(1)) != null && !ap.isEmpty(hVar2.getText())) {
                    al.f(this.hZm, R.color.cp_other_c, 1);
                    al.g(this.hZm, R.drawable.label_bg_green, 1);
                    this.hZm.setText(hVar2.getText());
                    this.hZm.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.hZr.getPosition())) {
                this.hZo.setText(this.hZr.getPosition());
                al.f(this.hZo, R.color.cp_cont_c, 1);
                this.hZo.setVisibility(0);
                al.c(this.hZn, (int) R.drawable.icon_pic_place);
                this.hZn.setVisibility(0);
            }
            j cmd = this.hZr.cmd();
            if (cmd != null && !ap.isEmpty(cmd.getText())) {
                if (this.hZl.getVisibility() != 0 && this.hZm.getVisibility() != 0) {
                    al.f(this.hZq, R.color.cp_link_tip_a, 1);
                    al.g(this.hZq, R.drawable.label_bg_blue, 1);
                    this.hZq.setText(cmd.getText());
                    this.hZq.setVisibility(0);
                } else {
                    al.f(this.hZp, R.color.cp_link_tip_a, 1);
                    al.g(this.hZp, R.drawable.label_bg_blue, 1);
                    this.hZp.setText(cmd.getText());
                    this.hZp.setVisibility(0);
                }
            }
            if (this.hZl.getVisibility() != 0 && this.hZm.getVisibility() != 0 && this.hZo.getVisibility() != 0 && this.hZq.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hZr != null) {
            if (view == this.hZl) {
                if (this.hZr.cmb() != null) {
                    a(this.hZr.cmb().get(0));
                }
            } else if (view == this.hZm) {
                if (this.hZr.cmb() != null) {
                    a(this.hZr.cmb().get(1));
                }
            } else if (view == this.hZp || view == this.hZq) {
                j cmd = this.hZr.cmd();
                if (!ap.isEmpty(cmd.getUrl())) {
                    com.baidu.tbadk.browser.a.af(this.mContext, cmd.getUrl());
                    if (this.hZs != null) {
                        this.hZs.g(cmd.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.hZs != null) {
                this.hZs.g(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.af(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hZk.getActivity());
                    aVar.mD(trim);
                    aVar.a(this.hZk.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.hZs != null) {
                                PbNewChudianCommonView.this.hZs.g(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.hZk.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.hZs != null) {
                                PbNewChudianCommonView.this.hZs.g(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dN(false);
                    aVar.b(this.hZk.getPageContext());
                    aVar.afG();
                }
            }
        }
    }
}
