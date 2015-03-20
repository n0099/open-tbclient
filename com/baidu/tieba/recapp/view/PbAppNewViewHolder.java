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
    protected TbImageView bXx;
    protected TextView bXy;
    protected ViewGroup bXz;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.bXt = (TextView) view.findViewById(v.recommend_title);
        this.bXv = (HeadImageView) view.findViewById(v.recommend_icon);
        this.bXs = (TextView) view.findViewById(v.recommend_btn);
        this.bXu = (TextView) view.findViewById(v.recommend_content);
        this.bXx = (TbImageView) view.findViewById(v.recommend_img);
        this.bXy = (TextView) view.findViewById(v.recommend_time);
        this.bXw = view.findViewById(v.divider_line);
        this.bXz = (ViewGroup) view.findViewById(v.layout);
        this.bXv.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(i iVar, int i, boolean z) {
        super.update(iVar, i, z);
        if (iVar != null) {
            this.bXt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ba.getDrawable(u.icon_extend), (Drawable) null);
            this.bXt.setText(iVar.aml());
            if (!n.px().pz()) {
                ViewGroup.LayoutParams layoutParams = this.bXv.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(t.ds30);
                this.bXv.setLayoutParams(layoutParams);
                this.bXv.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bXz.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(t.ds50);
                this.bXz.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bXv.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(t.ds60);
                this.bXv.setLayoutParams(layoutParams2);
                this.bXv.setVisibility(0);
                if (!TextUtils.isEmpty(iVar.amm())) {
                    this.bXv.c(iVar.amm(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bXz.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(t.ds80);
                this.bXz.setLayoutParams(marginLayoutParams2);
            }
            String n = bd.n(iVar.amp());
            if (n == null) {
                n = "";
            }
            this.bXy.setText(n);
            if (StringUtils.isNull(iVar.amn())) {
                this.bXu.setVisibility(8);
            } else {
                this.bXu.setVisibility(0);
                this.bXu.setText(getFixedChineseString(iVar.amn()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.bXx.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(t.ds594) - this.rootView.getResources().getDimension(t.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(t.ds260) - this.rootView.getResources().getDimension(t.ds10));
            this.bXx.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(iVar.amo()) && n.px().pB()) {
                this.bXx.setVisibility(0);
                this.bXx.c(iVar.amo(), z ? 17 : 18, false);
            } else {
                this.bXx.setVisibility(8);
            }
            this.bXs.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            aft();
            if (iVar.amu()) {
                this.bXs.setVisibility(8);
            } else {
                this.bXs.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void afu() {
        if (this.bXs != null && this.rootView != null) {
            ba.i((View) this.bXs, u.btn_appdownload);
            ba.b(this.bXs, s.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void afv() {
        if (this.bXs != null && this.rootView != null) {
            ba.i((View) this.bXs, u.btn_content_download_d);
            ba.b(this.bXs, s.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int afw() {
        return y.pb_app_download;
    }
}
