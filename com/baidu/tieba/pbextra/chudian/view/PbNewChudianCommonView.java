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
    private BdBaseActivity<?> ihl;
    private TextView ihm;
    private TextView ihn;
    private ImageView iho;
    private TextView ihp;
    private TextView ihq;
    private TextView ihr;
    private i ihs;
    private a.InterfaceC0476a iht;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.ihl = null;
        this.mRootView = null;
        this.ihm = null;
        this.ihn = null;
        this.iho = null;
        this.ihp = null;
        this.ihq = null;
        this.ihr = null;
        this.ihs = null;
        this.iht = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.ihl = null;
        this.mRootView = null;
        this.ihm = null;
        this.ihn = null;
        this.iho = null;
        this.ihp = null;
        this.ihq = null;
        this.ihr = null;
        this.ihs = null;
        this.iht = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.ihm = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.ihm.setOnClickListener(this);
            this.ihn = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.ihn.setOnClickListener(this);
            this.ihp = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.iho = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.ihq = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.ihq.setOnClickListener(this);
            this.ihr = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.ihr.setOnClickListener(this);
        }
    }

    public void setData(i iVar, BdBaseActivity<?> bdBaseActivity, a.InterfaceC0476a interfaceC0476a) {
        h hVar;
        h hVar2;
        if (iVar != null && bdBaseActivity != null) {
            this.ihs = iVar;
            this.ihl = bdBaseActivity;
            this.iht = interfaceC0476a;
            ArrayList<h> cnT = this.ihs.cnT();
            if (cnT != null && cnT.size() > 0 && (hVar = cnT.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.setViewTextColor(this.ihm, R.color.cp_other_c, 1);
                am.setBackgroundResource(this.ihm, R.drawable.label_bg_green, 1);
                this.ihm.setText(hVar.getText());
                this.ihm.setVisibility(0);
                if (cnT.size() > 1 && (hVar2 = cnT.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.setViewTextColor(this.ihn, R.color.cp_other_c, 1);
                    am.setBackgroundResource(this.ihn, R.drawable.label_bg_green, 1);
                    this.ihn.setText(hVar2.getText());
                    this.ihn.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.ihs.getPosition())) {
                this.ihp.setText(this.ihs.getPosition());
                am.setViewTextColor(this.ihp, R.color.cp_cont_c, 1);
                this.ihp.setVisibility(0);
                am.setImageResource(this.iho, R.drawable.icon_pic_place);
                this.iho.setVisibility(0);
            }
            j cnV = this.ihs.cnV();
            if (cnV != null && !aq.isEmpty(cnV.getText())) {
                if (this.ihm.getVisibility() != 0 && this.ihn.getVisibility() != 0) {
                    am.setViewTextColor(this.ihr, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.ihr, R.drawable.label_bg_blue, 1);
                    this.ihr.setText(cnV.getText());
                    this.ihr.setVisibility(0);
                } else {
                    am.setViewTextColor(this.ihq, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.ihq, R.drawable.label_bg_blue, 1);
                    this.ihq.setText(cnV.getText());
                    this.ihq.setVisibility(0);
                }
            }
            if (this.ihm.getVisibility() != 0 && this.ihn.getVisibility() != 0 && this.ihp.getVisibility() != 0 && this.ihr.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ihs != null) {
            if (view == this.ihm) {
                if (this.ihs.cnT() != null) {
                    a(this.ihs.cnT().get(0));
                }
            } else if (view == this.ihn) {
                if (this.ihs.cnT() != null) {
                    a(this.ihs.cnT().get(1));
                }
            } else if (view == this.ihq || view == this.ihr) {
                j cnV = this.ihs.cnV();
                if (!aq.isEmpty(cnV.getUrl())) {
                    com.baidu.tbadk.browser.a.startWebActivity(this.mContext, cnV.getUrl());
                    if (this.iht != null) {
                        this.iht.k(cnV.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.iht != null) {
                this.iht.k(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    com.baidu.tbadk.browser.a.startWebActivity(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ihl.getActivity());
                    aVar.nn(trim);
                    aVar.a(this.ihl.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.iht != null) {
                                PbNewChudianCommonView.this.iht.k(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.ihl.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.iht != null) {
                                PbNewChudianCommonView.this.iht.k(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.eh(false);
                    aVar.b(this.ihl.getPageContext());
                    aVar.akO();
                }
            }
        }
    }
}
