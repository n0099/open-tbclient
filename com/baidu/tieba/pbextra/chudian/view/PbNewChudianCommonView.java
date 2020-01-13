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
/* loaded from: classes7.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private TextView jbZ;
    private TextView jca;
    private ImageView jcb;
    private TextView jcc;
    private TextView jcd;
    private TextView jce;
    private i jcf;
    private b.a jcg;
    private Context mContext;
    private TbPageContext mPageContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.mPageContext = null;
        this.mRootView = null;
        this.jbZ = null;
        this.jca = null;
        this.jcb = null;
        this.jcc = null;
        this.jcd = null;
        this.jce = null;
        this.jcf = null;
        this.jcg = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPageContext = null;
        this.mRootView = null;
        this.jbZ = null;
        this.jca = null;
        this.jcb = null;
        this.jcc = null;
        this.jcd = null;
        this.jce = null;
        this.jcf = null;
        this.jcg = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.jbZ = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.jbZ.setOnClickListener(this);
            this.jca = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.jca.setOnClickListener(this);
            this.jcc = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.jcb = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.jcd = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.jcd.setOnClickListener(this);
            this.jce = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.jce.setOnClickListener(this);
        }
    }

    public void setData(i iVar, TbPageContext tbPageContext, b.a aVar) {
        h hVar;
        h hVar2;
        if (iVar != null && tbPageContext != null) {
            this.jcf = iVar;
            this.mPageContext = tbPageContext;
            this.jcg = aVar;
            ArrayList<h> cJb = this.jcf.cJb();
            if (cJb != null && cJb.size() > 0 && (hVar = cJb.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.setViewTextColor(this.jbZ, R.color.cp_other_c, 1);
                am.setBackgroundResource(this.jbZ, R.drawable.label_bg_green, 1);
                this.jbZ.setText(hVar.getText());
                this.jbZ.setVisibility(0);
                if (cJb.size() > 1 && (hVar2 = cJb.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.setViewTextColor(this.jca, R.color.cp_other_c, 1);
                    am.setBackgroundResource(this.jca, R.drawable.label_bg_green, 1);
                    this.jca.setText(hVar2.getText());
                    this.jca.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.jcf.getPosition())) {
                this.jcc.setText(this.jcf.getPosition());
                am.setViewTextColor(this.jcc, R.color.cp_cont_c, 1);
                this.jcc.setVisibility(0);
                am.setImageResource(this.jcb, R.drawable.icon_pic_place);
                this.jcb.setVisibility(0);
            }
            j cJd = this.jcf.cJd();
            if (cJd != null && !aq.isEmpty(cJd.getText())) {
                if (this.jbZ.getVisibility() != 0 && this.jca.getVisibility() != 0) {
                    am.setViewTextColor(this.jce, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jce, R.drawable.label_bg_blue, 1);
                    this.jce.setText(cJd.getText());
                    this.jce.setVisibility(0);
                } else {
                    am.setViewTextColor(this.jcd, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jcd, R.drawable.label_bg_blue, 1);
                    this.jcd.setText(cJd.getText());
                    this.jcd.setVisibility(0);
                }
            }
            if (this.jbZ.getVisibility() != 0 && this.jca.getVisibility() != 0 && this.jcc.getVisibility() != 0 && this.jce.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jcf != null) {
            if (view == this.jbZ) {
                if (this.jcf.cJb() != null) {
                    a(this.jcf.cJb().get(0));
                }
            } else if (view == this.jca) {
                if (this.jcf.cJb() != null) {
                    a(this.jcf.cJb().get(1));
                }
            } else if (view == this.jcd || view == this.jce) {
                j cJd = this.jcf.cJd();
                if (!aq.isEmpty(cJd.getUrl())) {
                    a.startWebActivity(this.mContext, cJd.getUrl());
                    if (this.jcg != null) {
                        this.jcg.k(cJd.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.jcg != null) {
                this.jcg.k(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!aq.isEmpty(trim)) {
                int type = hVar.getType();
                if (type == 1) {
                    a.startWebActivity(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.sC(trim);
                    aVar.a(this.mPageContext.getResources().getString(R.string.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.jcg != null) {
                                PbNewChudianCommonView.this.jcg.k(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.mPageContext.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.jcg != null) {
                                PbNewChudianCommonView.this.jcg.k(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.fA(false);
                    aVar.b(this.mPageContext);
                    aVar.aCp();
                }
            }
        }
    }
}
