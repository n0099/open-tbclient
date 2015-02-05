package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends BaseAppViewHolder {
    protected TbImageView bMP;
    protected TextView bMQ;
    protected ViewGroup bMR;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.bML = (TextView) view.findViewById(w.recommend_title);
        this.bMN = (HeadImageView) view.findViewById(w.recommend_icon);
        this.bMK = (TextView) view.findViewById(w.recommend_btn);
        this.bMM = (TextView) view.findViewById(w.recommend_content);
        this.bMP = (TbImageView) view.findViewById(w.recommend_img);
        this.bMQ = (TextView) view.findViewById(w.recommend_time);
        this.bMO = view.findViewById(w.divider_line);
        this.bMR = (ViewGroup) view.findViewById(w.layout);
        this.bMN.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(j jVar, int i, boolean z) {
        super.update(jVar, i, z);
        if (jVar != null) {
            this.bML.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bc.getDrawable(v.icon_extend), (Drawable) null);
            this.bML.setText(jVar.agY());
            if (!l.lV().lX()) {
                ViewGroup.LayoutParams layoutParams = this.bMN.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(u.ds30);
                this.bMN.setLayoutParams(layoutParams);
                this.bMN.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bMR.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(u.ds50);
                this.bMR.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bMN.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(u.ds60);
                this.bMN.setLayoutParams(layoutParams2);
                this.bMN.setVisibility(0);
                if (!TextUtils.isEmpty(jVar.agZ())) {
                    this.bMN.d(jVar.agZ(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bMR.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(u.ds80);
                this.bMR.setLayoutParams(marginLayoutParams2);
            }
            String n = bf.n(jVar.ahc());
            if (n == null) {
                n = "";
            }
            this.bMQ.setText(n);
            if (StringUtils.isNull(jVar.aha())) {
                this.bMM.setVisibility(8);
            } else {
                this.bMM.setVisibility(0);
                this.bMM.setText(getFixedChineseString(jVar.aha()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.bMP.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(u.ds594) - this.rootView.getResources().getDimension(u.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(u.ds260) - this.rootView.getResources().getDimension(u.ds10));
            this.bMP.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(jVar.ahb()) && l.lV().lZ()) {
                this.bMP.setVisibility(0);
                this.bMP.d(jVar.ahb(), z ? 17 : 18, false);
            } else {
                this.bMP.setVisibility(8);
            }
            this.bMK.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            acm();
            if (jVar.ahn()) {
                this.bMK.setVisibility(8);
            } else {
                this.bMK.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void acn() {
        if (this.bMK != null && this.rootView != null) {
            bc.i((View) this.bMK, v.btn_appdownload);
            bc.b(this.bMK, t.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aco() {
        if (this.bMK != null && this.rootView != null) {
            bc.i((View) this.bMK, v.btn_content_download_d);
            bc.b(this.bMK, t.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int acp() {
        return z.pb_app_download;
    }
}
