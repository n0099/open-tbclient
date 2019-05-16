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
    private BdBaseActivity<?> hZg;
    private TextView hZh;
    private TextView hZi;
    private ImageView hZj;
    private TextView hZk;
    private TextView hZl;
    private TextView hZm;
    private i hZn;
    private a.InterfaceC0366a hZo;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.hZg = null;
        this.mRootView = null;
        this.hZh = null;
        this.hZi = null;
        this.hZj = null;
        this.hZk = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.hZg = null;
        this.mRootView = null;
        this.hZh = null;
        this.hZi = null;
        this.hZj = null;
        this.hZk = null;
        this.hZl = null;
        this.hZm = null;
        this.hZn = null;
        this.hZo = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.hZh = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.hZh.setOnClickListener(this);
            this.hZi = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.hZi.setOnClickListener(this);
            this.hZk = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.hZj = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.hZl = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.hZl.setOnClickListener(this);
            this.hZm = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.hZm.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0366a interfaceC0366a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.hZn = iVar;
            this.hZg = bdBaseActivity;
            this.hZo = interfaceC0366a;
            ArrayList<h> clY = this.hZn.clY();
            if (clY != null && clY.size() > 0 && (hVar = clY.get(0)) != null && !ap.isEmpty(hVar.getText())) {
                al.f(this.hZh, R.color.cp_other_c, 1);
                al.g(this.hZh, R.drawable.label_bg_green, 1);
                this.hZh.setText(hVar.getText());
                this.hZh.setVisibility(0);
                if (clY.size() > 1 && (hVar2 = clY.get(1)) != null && !ap.isEmpty(hVar2.getText())) {
                    al.f(this.hZi, R.color.cp_other_c, 1);
                    al.g(this.hZi, R.drawable.label_bg_green, 1);
                    this.hZi.setText(hVar2.getText());
                    this.hZi.setVisibility(0);
                }
            }
            if (!ap.isEmpty(this.hZn.getPosition())) {
                this.hZk.setText(this.hZn.getPosition());
                al.f(this.hZk, R.color.cp_cont_c, 1);
                this.hZk.setVisibility(0);
                al.c(this.hZj, (int) R.drawable.icon_pic_place);
                this.hZj.setVisibility(0);
            }
            j cma = this.hZn.cma();
            if (cma != null && !ap.isEmpty(cma.getText())) {
                if (this.hZh.getVisibility() != 0 && this.hZi.getVisibility() != 0) {
                    al.f(this.hZm, R.color.cp_link_tip_a, 1);
                    al.g(this.hZm, R.drawable.label_bg_blue, 1);
                    this.hZm.setText(cma.getText());
                    this.hZm.setVisibility(0);
                } else {
                    al.f(this.hZl, R.color.cp_link_tip_a, 1);
                    al.g(this.hZl, R.drawable.label_bg_blue, 1);
                    this.hZl.setText(cma.getText());
                    this.hZl.setVisibility(0);
                }
            }
            if (this.hZh.getVisibility() != 0 && this.hZi.getVisibility() != 0 && this.hZk.getVisibility() != 0 && this.hZm.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hZn != null) {
            if (view == this.hZh) {
                if (this.hZn.clY() != null) {
                    a(this.hZn.clY().get(0));
                }
            } else if (view == this.hZi) {
                if (this.hZn.clY() != null) {
                    a(this.hZn.clY().get(1));
                }
            } else if (view == this.hZl || view == this.hZm) {
                j cma = this.hZn.cma();
                if (!ap.isEmpty(cma.getUrl())) {
                    com.baidu.tbadk.browser.a.af(this.mContext, cma.getUrl());
                    if (this.hZo != null) {
                        this.hZo.g(cma.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.hZo != null) {
                this.hZo.g(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!ap.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.af(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hZg.getActivity());
                    aVar.mE(trim);
                    aVar.a(this.hZg.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.hZo != null) {
                                PbNewChudianCommonView.this.hZo.g(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.hZg.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.hZo != null) {
                                PbNewChudianCommonView.this.hZo.g(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.dN(false);
                    aVar.b(this.hZg.getPageContext());
                    aVar.afG();
                }
            }
        }
    }
}
