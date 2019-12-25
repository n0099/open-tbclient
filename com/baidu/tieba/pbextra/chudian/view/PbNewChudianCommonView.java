package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private TextView iYA;
    private TextView iYB;
    private i iYC;
    private b.a iYD;
    private TextView iYw;
    private TextView iYx;
    private ImageView iYy;
    private TextView iYz;
    private Context mContext;
    private TbPageContext mPageContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.mPageContext = null;
        this.mRootView = null;
        this.iYw = null;
        this.iYx = null;
        this.iYy = null;
        this.iYz = null;
        this.iYA = null;
        this.iYB = null;
        this.iYC = null;
        this.iYD = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPageContext = null;
        this.mRootView = null;
        this.iYw = null;
        this.iYx = null;
        this.iYy = null;
        this.iYz = null;
        this.iYA = null;
        this.iYB = null;
        this.iYC = null;
        this.iYD = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.iYw = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.iYw.setOnClickListener(this);
            this.iYx = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.iYx.setOnClickListener(this);
            this.iYz = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.iYy = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.iYA = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.iYA.setOnClickListener(this);
            this.iYB = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.iYB.setOnClickListener(this);
        }
    }

    public void setData(i iVar, TbPageContext tbPageContext, b.a aVar) {
        h hVar;
        h hVar2;
        if (iVar != null && tbPageContext != null) {
            this.iYC = iVar;
            this.mPageContext = tbPageContext;
            this.iYD = aVar;
            ArrayList<h> cHX = this.iYC.cHX();
            if (cHX != null && cHX.size() > 0 && (hVar = cHX.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.setViewTextColor(this.iYw, R.color.cp_other_c, 1);
                am.setBackgroundResource(this.iYw, R.drawable.label_bg_green, 1);
                this.iYw.setText(hVar.getText());
                this.iYw.setVisibility(0);
                if (cHX.size() > 1 && (hVar2 = cHX.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.setViewTextColor(this.iYx, R.color.cp_other_c, 1);
                    am.setBackgroundResource(this.iYx, R.drawable.label_bg_green, 1);
                    this.iYx.setText(hVar2.getText());
                    this.iYx.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.iYC.getPosition())) {
                this.iYz.setText(this.iYC.getPosition());
                am.setViewTextColor(this.iYz, R.color.cp_cont_c, 1);
                this.iYz.setVisibility(0);
                am.setImageResource(this.iYy, R.drawable.icon_pic_place);
                this.iYy.setVisibility(0);
            }
            j cHZ = this.iYC.cHZ();
            if (cHZ != null && !aq.isEmpty(cHZ.getText())) {
                if (this.iYw.getVisibility() != 0 && this.iYx.getVisibility() != 0) {
                    am.setViewTextColor(this.iYB, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.iYB, R.drawable.label_bg_blue, 1);
                    this.iYB.setText(cHZ.getText());
                    this.iYB.setVisibility(0);
                } else {
                    am.setViewTextColor(this.iYA, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.iYA, R.drawable.label_bg_blue, 1);
                    this.iYA.setText(cHZ.getText());
                    this.iYA.setVisibility(0);
                }
            }
            if (this.iYw.getVisibility() != 0 && this.iYx.getVisibility() != 0 && this.iYz.getVisibility() != 0 && this.iYB.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iYC != null) {
            if (view == this.iYw) {
                if (this.iYC.cHX() != null) {
                    a(this.iYC.cHX().get(0));
                }
            } else if (view == this.iYx) {
                if (this.iYC.cHX() != null) {
                    a(this.iYC.cHX().get(1));
                }
            } else if (view == this.iYA || view == this.iYB) {
                j cHZ = this.iYC.cHZ();
                if (!aq.isEmpty(cHZ.getUrl())) {
                    a.startWebActivity(this.mContext, cHZ.getUrl());
                    if (this.iYD != null) {
                        this.iYD.k(cHZ.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.iYD != null) {
                this.iYD.k(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    a.startWebActivity(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.sz(trim);
                    aVar.a(this.mPageContext.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.iYD != null) {
                                PbNewChudianCommonView.this.iYD.k(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.mPageContext.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.iYD != null) {
                                PbNewChudianCommonView.this.iYD.k(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.fv(false);
                    aVar.b(this.mPageContext);
                    aVar.aBW();
                }
            }
        }
    }
}
