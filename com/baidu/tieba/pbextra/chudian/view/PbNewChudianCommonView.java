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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private TextView igA;
    private i igB;
    private a.InterfaceC0471a igC;
    private BdBaseActivity<?> igu;
    private TextView igv;
    private TextView igw;
    private ImageView igx;
    private TextView igy;
    private TextView igz;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.igu = null;
        this.mRootView = null;
        this.igv = null;
        this.igw = null;
        this.igx = null;
        this.igy = null;
        this.igz = null;
        this.igA = null;
        this.igB = null;
        this.igC = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.igu = null;
        this.mRootView = null;
        this.igv = null;
        this.igw = null;
        this.igx = null;
        this.igy = null;
        this.igz = null;
        this.igA = null;
        this.igB = null;
        this.igC = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.igv = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.igv.setOnClickListener(this);
            this.igw = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.igw.setOnClickListener(this);
            this.igy = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.igx = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.igz = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.igz.setOnClickListener(this);
            this.igA = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.igA.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0471a interfaceC0471a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.igB = iVar;
            this.igu = bdBaseActivity;
            this.igC = interfaceC0471a;
            ArrayList<h> cnR = this.igB.cnR();
            if (cnR != null && cnR.size() > 0 && (hVar = cnR.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.setViewTextColor(this.igv, R.color.cp_other_c, 1);
                am.setBackgroundResource(this.igv, R.drawable.label_bg_green, 1);
                this.igv.setText(hVar.getText());
                this.igv.setVisibility(0);
                if (cnR.size() > 1 && (hVar2 = cnR.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.setViewTextColor(this.igw, R.color.cp_other_c, 1);
                    am.setBackgroundResource(this.igw, R.drawable.label_bg_green, 1);
                    this.igw.setText(hVar2.getText());
                    this.igw.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.igB.getPosition())) {
                this.igy.setText(this.igB.getPosition());
                am.setViewTextColor(this.igy, R.color.cp_cont_c, 1);
                this.igy.setVisibility(0);
                am.setImageResource(this.igx, R.drawable.icon_pic_place);
                this.igx.setVisibility(0);
            }
            j cnT = this.igB.cnT();
            if (cnT != null && !aq.isEmpty(cnT.getText())) {
                if (this.igv.getVisibility() != 0 && this.igw.getVisibility() != 0) {
                    am.setViewTextColor(this.igA, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.igA, R.drawable.label_bg_blue, 1);
                    this.igA.setText(cnT.getText());
                    this.igA.setVisibility(0);
                } else {
                    am.setViewTextColor(this.igz, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.igz, R.drawable.label_bg_blue, 1);
                    this.igz.setText(cnT.getText());
                    this.igz.setVisibility(0);
                }
            }
            if (this.igv.getVisibility() != 0 && this.igw.getVisibility() != 0 && this.igy.getVisibility() != 0 && this.igA.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.igB != null) {
            if (view == this.igv) {
                if (this.igB.cnR() != null) {
                    a(this.igB.cnR().get(0));
                }
            } else if (view == this.igw) {
                if (this.igB.cnR() != null) {
                    a(this.igB.cnR().get(1));
                }
            } else if (view == this.igz || view == this.igA) {
                j cnT = this.igB.cnT();
                if (!aq.isEmpty(cnT.getUrl())) {
                    com.baidu.tbadk.browser.a.startWebActivity(this.mContext, cnT.getUrl());
                    if (this.igC != null) {
                        this.igC.k(cnT.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.igC != null) {
                this.igC.k(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.startWebActivity(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.igu.getActivity());
                    aVar.nn(trim);
                    aVar.a(this.igu.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.igC != null) {
                                PbNewChudianCommonView.this.igC.k(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.igu.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.igC != null) {
                                PbNewChudianCommonView.this.igC.k(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.eh(false);
                    aVar.b(this.igu.getPageContext());
                    aVar.akM();
                }
            }
        }
    }
}
