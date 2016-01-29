package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class PbAppNewBaseViewHolder extends BaseAppViewHolder {
    protected TextView dCV;
    protected ViewGroup dCW;

    public PbAppNewBaseViewHolder(View view) {
        super(view);
        this.dCQ = (TextView) view.findViewById(t.g.recommend_title);
        this.dCS = (HeadImageView) view.findViewById(t.g.recommend_icon);
        this.dCO = (TextView) view.findViewById(t.g.recommend_btn);
        this.dCP = (TextView) view.findViewById(t.g.pb_app_push);
        this.dCR = (TextView) view.findViewById(t.g.recommend_content);
        this.dCV = (TextView) view.findViewById(t.g.recommend_time);
        this.dCT = (AppDownloadView) view.findViewById(t.g.recommend_app_download_view);
        this.dCU = view.findViewById(t.g.divider_line);
        this.dCW = (ViewGroup) view.findViewById(t.g.layout);
        this.dCS.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(q qVar, int i, boolean z) {
        super.update(qVar, i, z);
        if (qVar != null) {
            this.dCQ.setText(aw.d(qVar.aMh().trim(), 7, "..."));
            if (!l.rn().rp()) {
                ViewGroup.LayoutParams layoutParams = this.dCS.getLayoutParams();
                layoutParams.width = (int) this.azA.getResources().getDimension(t.e.ds30);
                this.dCS.setLayoutParams(layoutParams);
                this.dCS.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dCW.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.azA.getResources().getDimension(t.e.ds50);
                this.dCW.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.dCS.getLayoutParams();
                layoutParams2.width = (int) this.azA.getResources().getDimension(t.e.ds60);
                this.dCS.setLayoutParams(layoutParams2);
                this.dCS.setVisibility(0);
                if (!TextUtils.isEmpty(qVar.aMi())) {
                    this.dCS.d(qVar.aMi(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dCW.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.azA.getResources().getDimension(t.e.ds80);
                this.dCW.setLayoutParams(marginLayoutParams2);
            }
            String t = aw.t(qVar.aMk());
            if (t == null) {
                t = "";
            }
            this.dCV.setText(t);
            if (StringUtils.isNull(qVar.aMj())) {
                this.dCR.setVisibility(8);
            } else {
                this.dCR.setVisibility(0);
                this.dCR.setText(getFixedChineseString(qVar.aMj()));
            }
            this.dCO.setTag(this);
            this.azA.setBackgroundDrawable(null);
            if (qVar.aMn()) {
                this.dCO.setVisibility(8);
                this.dCP.setVisibility(0);
                this.dCQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.dCO.setVisibility(0);
                this.dCP.setVisibility(8);
                this.dCQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(t.f.icon_extend), (Drawable) null);
            }
            a(qVar, i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aEP() {
        if (this.dCO != null && this.azA != null) {
            ar.k(this.dCO, t.f.btn_appdownload);
            ar.b(this.dCO, t.d.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int aEQ() {
        return t.j.pb_app_download;
    }
}
