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
    private BdBaseActivity<?> hZj;
    private TextView hZk;
    private TextView hZl;
    private ImageView hZm;
    private TextView hZn;
    private TextView hZo;
    private TextView hZp;
    private i hZq;
    private a.InterfaceC0366a hZr;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.hZj = null;
        this.mRootView = null;
        this.hZk = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = null;
        this.hZp = null;
        this.hZq = null;
        this.hZr = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.hZj = null;
        this.mRootView = null;
        this.hZk = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = null;
        this.hZp = null;
        this.hZq = null;
        this.hZr = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.hZk = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.hZk.setOnClickListener(this);
            this.hZl = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.hZl.setOnClickListener(this);
            this.hZn = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.hZm = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.hZo = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.hZo.setOnClickListener(this);
            this.hZp = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.hZp.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0366a interfaceC0366a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.hZq = iVar;
            this.hZj = bdBaseActivity;
            this.hZr = interfaceC0366a;
            ArrayList<h> cma = this.hZq.cma();
            if (cma != null && cma.size() > 0 && (hVar = cma.get(0)) != null && !ap.isEmpty(hVar.getText())) {
                al.f(this.hZk, R.color.cp_other_c, 1);
                al.g(this.hZk, R.drawable.label_bg_green, 1);
                this.hZk.setText(hVar.getText());
                this.hZk.setVisibility(0);
                if (cma.size() > 1 && (hVar2 = cma.get(1)) != null && !ap.isEmpty(hVar2.getText())) {
                    al.f(this.hZl, R.color.cp_other_c, 1);
                    al.g(this.hZl, R.drawable.label_bg_green, 1);
                    this.hZl.setText(hVar2.getText());
                    this.hZl.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.hZq.getPosition())) {
                this.hZn.setText(this.hZq.getPosition());
                al.f(this.hZn, R.color.cp_cont_c, 1);
                this.hZn.setVisibility(0);
                al.c(this.hZm, (int) R.drawable.icon_pic_place);
                this.hZm.setVisibility(0);
            }
            j cmc = this.hZq.cmc();
            if (cmc != null && !ap.isEmpty(cmc.getText())) {
                if (this.hZk.getVisibility() != 0 && this.hZl.getVisibility() != 0) {
                    al.f(this.hZp, R.color.cp_link_tip_a, 1);
                    al.g(this.hZp, R.drawable.label_bg_blue, 1);
                    this.hZp.setText(cmc.getText());
                    this.hZp.setVisibility(0);
                } else {
                    al.f(this.hZo, R.color.cp_link_tip_a, 1);
                    al.g(this.hZo, R.drawable.label_bg_blue, 1);
                    this.hZo.setText(cmc.getText());
                    this.hZo.setVisibility(0);
                }
            }
            if (this.hZk.getVisibility() != 0 && this.hZl.getVisibility() != 0 && this.hZn.getVisibility() != 0 && this.hZp.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hZq != null) {
            if (view == this.hZk) {
                if (this.hZq.cma() != null) {
                    a(this.hZq.cma().get(0));
                }
            } else if (view == this.hZl) {
                if (this.hZq.cma() != null) {
                    a(this.hZq.cma().get(1));
                }
            } else if (view == this.hZo || view == this.hZp) {
                j cmc = this.hZq.cmc();
                if (!ap.isEmpty(cmc.getUrl())) {
                    com.baidu.tbadk.browser.a.af(this.mContext, cmc.getUrl());
                    if (this.hZr != null) {
                        this.hZr.g(cmc.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.hZr != null) {
                this.hZr.g(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.af(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hZj.getActivity());
                    aVar.mE(trim);
                    aVar.a(this.hZj.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.hZr != null) {
                                PbNewChudianCommonView.this.hZr.g(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.hZj.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.hZr != null) {
                                PbNewChudianCommonView.this.hZr.g(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dN(false);
                    aVar.b(this.hZj.getPageContext());
                    aVar.afG();
                }
            }
        }
    }
}
