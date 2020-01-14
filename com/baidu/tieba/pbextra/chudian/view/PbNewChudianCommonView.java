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
    private TextView jce;
    private TextView jcf;
    private ImageView jcg;
    private TextView jch;
    private TextView jci;
    private TextView jcj;
    private i jck;
    private b.a jcl;
    private Context mContext;
    private TbPageContext mPageContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.mPageContext = null;
        this.mRootView = null;
        this.jce = null;
        this.jcf = null;
        this.jcg = null;
        this.jch = null;
        this.jci = null;
        this.jcj = null;
        this.jck = null;
        this.jcl = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mPageContext = null;
        this.mRootView = null;
        this.jce = null;
        this.jcf = null;
        this.jcg = null;
        this.jch = null;
        this.jci = null;
        this.jcj = null;
        this.jck = null;
        this.jcl = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pb_newchudian_common, (ViewGroup) this, true);
            this.jce = (TextView) this.mRootView.findViewById(R.id.service_first);
            this.jce.setOnClickListener(this);
            this.jcf = (TextView) this.mRootView.findViewById(R.id.service_second);
            this.jcf.setOnClickListener(this);
            this.jch = (TextView) this.mRootView.findViewById(R.id.land_mark_text);
            this.jcg = (ImageView) this.mRootView.findViewById(R.id.land_mark_icon);
            this.jci = (TextView) this.mRootView.findViewById(R.id.check_detail_up);
            this.jci.setOnClickListener(this);
            this.jcj = (TextView) this.mRootView.findViewById(R.id.check_detail_down);
            this.jcj.setOnClickListener(this);
        }
    }

    public void setData(i iVar, TbPageContext tbPageContext, b.a aVar) {
        h hVar;
        h hVar2;
        if (iVar != null && tbPageContext != null) {
            this.jck = iVar;
            this.mPageContext = tbPageContext;
            this.jcl = aVar;
            ArrayList<h> cJd = this.jck.cJd();
            if (cJd != null && cJd.size() > 0 && (hVar = cJd.get(0)) != null && !aq.isEmpty(hVar.getText())) {
                am.setViewTextColor(this.jce, R.color.cp_other_c, 1);
                am.setBackgroundResource(this.jce, R.drawable.label_bg_green, 1);
                this.jce.setText(hVar.getText());
                this.jce.setVisibility(0);
                if (cJd.size() > 1 && (hVar2 = cJd.get(1)) != null && !aq.isEmpty(hVar2.getText())) {
                    am.setViewTextColor(this.jcf, R.color.cp_other_c, 1);
                    am.setBackgroundResource(this.jcf, R.drawable.label_bg_green, 1);
                    this.jcf.setText(hVar2.getText());
                    this.jcf.setVisibility(0);
                }
            }
            if (!aq.isEmpty(this.jck.getPosition())) {
                this.jch.setText(this.jck.getPosition());
                am.setViewTextColor(this.jch, R.color.cp_cont_c, 1);
                this.jch.setVisibility(0);
                am.setImageResource(this.jcg, R.drawable.icon_pic_place);
                this.jcg.setVisibility(0);
            }
            j cJf = this.jck.cJf();
            if (cJf != null && !aq.isEmpty(cJf.getText())) {
                if (this.jce.getVisibility() != 0 && this.jcf.getVisibility() != 0) {
                    am.setViewTextColor(this.jcj, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jcj, R.drawable.label_bg_blue, 1);
                    this.jcj.setText(cJf.getText());
                    this.jcj.setVisibility(0);
                } else {
                    am.setViewTextColor(this.jci, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jci, R.drawable.label_bg_blue, 1);
                    this.jci.setText(cJf.getText());
                    this.jci.setVisibility(0);
                }
            }
            if (this.jce.getVisibility() != 0 && this.jcf.getVisibility() != 0 && this.jch.getVisibility() != 0 && this.jcj.getVisibility() != 0) {
                this.mRootView.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jck != null) {
            if (view == this.jce) {
                if (this.jck.cJd() != null) {
                    a(this.jck.cJd().get(0));
                }
            } else if (view == this.jcf) {
                if (this.jck.cJd() != null) {
                    a(this.jck.cJd().get(1));
                }
            } else if (view == this.jci || view == this.jcj) {
                j cJf = this.jck.cJf();
                if (!aq.isEmpty(cJf.getUrl())) {
                    a.startWebActivity(this.mContext, cJf.getUrl());
                    if (this.jcl != null) {
                        this.jcl.k(cJf.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(h hVar) {
        if (hVar != null) {
            final String trim = hVar.getUrl().trim();
            if (this.jcl != null) {
                this.jcl.k(trim, "BTN_PHONE", "CLICK", null, null);
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
                            if (PbNewChudianCommonView.this.jcl != null) {
                                PbNewChudianCommonView.this.jcl.k(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.mPageContext.getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.jcl != null) {
                                PbNewChudianCommonView.this.jcl.k(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
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
