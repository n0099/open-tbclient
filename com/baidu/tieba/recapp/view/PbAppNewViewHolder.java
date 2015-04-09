package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.i;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends BaseAppViewHolder {
    protected TbImageView bXN;
    protected TextView bXO;
    protected ViewGroup bXP;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.bXJ = (TextView) view.findViewById(v.recommend_title);
        this.bXL = (HeadImageView) view.findViewById(v.recommend_icon);
        this.bXI = (TextView) view.findViewById(v.recommend_btn);
        this.bXK = (TextView) view.findViewById(v.recommend_content);
        this.bXN = (TbImageView) view.findViewById(v.recommend_img);
        this.bXO = (TextView) view.findViewById(v.recommend_time);
        this.bXM = view.findViewById(v.divider_line);
        this.bXP = (ViewGroup) view.findViewById(v.layout);
        this.bXL.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(i iVar, int i, boolean z) {
        super.update(iVar, i, z);
        if (iVar != null) {
            this.bXJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ba.getDrawable(u.icon_extend), (Drawable) null);
            this.bXJ.setText(iVar.amA());
            if (!n.px().pz()) {
                ViewGroup.LayoutParams layoutParams = this.bXL.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(t.ds30);
                this.bXL.setLayoutParams(layoutParams);
                this.bXL.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bXP.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(t.ds50);
                this.bXP.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bXL.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(t.ds60);
                this.bXL.setLayoutParams(layoutParams2);
                this.bXL.setVisibility(0);
                if (!TextUtils.isEmpty(iVar.amB())) {
                    this.bXL.c(iVar.amB(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bXP.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(t.ds80);
                this.bXP.setLayoutParams(marginLayoutParams2);
            }
            String n = bd.n(iVar.amE());
            if (n == null) {
                n = "";
            }
            this.bXO.setText(n);
            if (StringUtils.isNull(iVar.amC())) {
                this.bXK.setVisibility(8);
            } else {
                this.bXK.setVisibility(0);
                this.bXK.setText(getFixedChineseString(iVar.amC()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.bXN.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(t.ds594) - this.rootView.getResources().getDimension(t.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(t.ds260) - this.rootView.getResources().getDimension(t.ds10));
            this.bXN.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(iVar.amD()) && n.px().pB()) {
                this.bXN.setVisibility(0);
                this.bXN.c(iVar.amD(), z ? 17 : 18, false);
            } else {
                this.bXN.setVisibility(8);
            }
            this.bXI.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            afI();
            if (iVar.amJ()) {
                this.bXI.setVisibility(8);
            } else {
                this.bXI.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void afJ() {
        if (this.bXI != null && this.rootView != null) {
            ba.i((View) this.bXI, u.btn_appdownload);
            ba.b(this.bXI, s.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void afK() {
        if (this.bXI != null && this.rootView != null) {
            ba.i((View) this.bXI, u.btn_content_download_d);
            ba.b(this.bXI, s.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int afL() {
        return y.pb_app_download;
    }
}
