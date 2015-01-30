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
    protected TbImageView bMQ;
    protected TextView bMR;
    protected ViewGroup bMS;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.bMM = (TextView) view.findViewById(w.recommend_title);
        this.bMO = (HeadImageView) view.findViewById(w.recommend_icon);
        this.bML = (TextView) view.findViewById(w.recommend_btn);
        this.bMN = (TextView) view.findViewById(w.recommend_content);
        this.bMQ = (TbImageView) view.findViewById(w.recommend_img);
        this.bMR = (TextView) view.findViewById(w.recommend_time);
        this.bMP = view.findViewById(w.divider_line);
        this.bMS = (ViewGroup) view.findViewById(w.layout);
        this.bMO.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(j jVar, int i, boolean z) {
        super.update(jVar, i, z);
        if (jVar != null) {
            this.bMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bc.getDrawable(v.icon_extend), (Drawable) null);
            this.bMM.setText(jVar.ahd());
            if (!l.mc().me()) {
                ViewGroup.LayoutParams layoutParams = this.bMO.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(u.ds30);
                this.bMO.setLayoutParams(layoutParams);
                this.bMO.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bMS.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(u.ds50);
                this.bMS.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bMO.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(u.ds60);
                this.bMO.setLayoutParams(layoutParams2);
                this.bMO.setVisibility(0);
                if (!TextUtils.isEmpty(jVar.ahe())) {
                    this.bMO.d(jVar.ahe(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bMS.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(u.ds80);
                this.bMS.setLayoutParams(marginLayoutParams2);
            }
            String n = bf.n(jVar.ahh());
            if (n == null) {
                n = "";
            }
            this.bMR.setText(n);
            if (StringUtils.isNull(jVar.ahf())) {
                this.bMN.setVisibility(8);
            } else {
                this.bMN.setVisibility(0);
                this.bMN.setText(getFixedChineseString(jVar.ahf()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.bMQ.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(u.ds594) - this.rootView.getResources().getDimension(u.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(u.ds260) - this.rootView.getResources().getDimension(u.ds10));
            this.bMQ.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(jVar.ahg()) && l.mc().mg()) {
                this.bMQ.setVisibility(0);
                this.bMQ.d(jVar.ahg(), z ? 17 : 18, false);
            } else {
                this.bMQ.setVisibility(8);
            }
            this.bML.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            acr();
            if (jVar.ahs()) {
                this.bML.setVisibility(8);
            } else {
                this.bML.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void acs() {
        if (this.bML != null && this.rootView != null) {
            bc.i((View) this.bML, v.btn_appdownload);
            bc.b(this.bML, t.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void act() {
        if (this.bML != null && this.rootView != null) {
            bc.i((View) this.bML, v.btn_content_download_d);
            bc.b(this.bML, t.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int acu() {
        return z.pb_app_download;
    }
}
