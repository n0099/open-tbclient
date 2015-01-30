package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PbAppViewHolder extends BaseAppViewHolder {
    public PbAppViewHolder(View view) {
        super(view);
        this.bMM = (TextView) view.findViewById(w.recommend_title);
        this.bMN = (TextView) view.findViewById(w.recommend_content);
        this.bMO = (HeadImageView) view.findViewById(w.recommend_icon);
        this.bML = (TextView) view.findViewById(w.recommend_btn);
        this.bMP = view.findViewById(w.divider_line);
        view.setTag(this);
        this.bMO.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(j jVar, int i, boolean z) {
        super.update(jVar, i, z);
        if (jVar != null) {
            this.bMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bc.getDrawable(v.icon_extend), (Drawable) null);
            this.bMM.setText(jVar.ahd());
            if (StringUtils.isNull(jVar.ahf())) {
                this.bMN.setVisibility(8);
            } else {
                this.bMN.setVisibility(0);
                this.bMN.setText(getFixedChineseString(jVar.ahf()));
            }
            if (!l.mc().me()) {
                ViewGroup.LayoutParams layoutParams = this.bMO.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(u.ds30);
                this.bMO.setLayoutParams(layoutParams);
                this.bMO.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bMN.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(u.ds50);
                this.bMN.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bMO.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(u.ds60);
                this.bMO.setLayoutParams(layoutParams2);
                this.bMO.setVisibility(0);
                if (!TextUtils.isEmpty(jVar.ahe())) {
                    this.bMO.d(jVar.ahe(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bMN.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(u.ds80);
                this.bMN.setLayoutParams(marginLayoutParams2);
            }
            this.bML.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            acr();
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void acs() {
        if (this.bML != null && this.rootView != null) {
            bc.i((View) this.bML, v.frs_praise_btn_bg);
            bc.b(this.bML, t.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void act() {
        if (this.bML != null && this.rootView != null) {
            bc.i((View) this.bML, v.frs_praise_btn_bg);
            bc.b(this.bML, t.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int acu() {
        return z.download;
    }
}
