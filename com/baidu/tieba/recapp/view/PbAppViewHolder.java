package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.i;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PbAppViewHolder extends BaseAppViewHolder {
    public PbAppViewHolder(View view) {
        super(view);
        this.bXt = (TextView) view.findViewById(v.recommend_title);
        this.bXu = (TextView) view.findViewById(v.recommend_content);
        this.bXv = (HeadImageView) view.findViewById(v.recommend_icon);
        this.bXs = (TextView) view.findViewById(v.recommend_btn);
        this.bXw = view.findViewById(v.divider_line);
        this.bXv.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(i iVar, int i, boolean z) {
        super.update(iVar, i, z);
        if (iVar != null) {
            this.bXt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ba.getDrawable(u.icon_extend), (Drawable) null);
            this.bXt.setText(iVar.aml());
            if (StringUtils.isNull(iVar.amn())) {
                this.bXu.setVisibility(8);
            } else {
                this.bXu.setVisibility(0);
                this.bXu.setText(getFixedChineseString(iVar.amn()));
            }
            if (!n.px().pz()) {
                ViewGroup.LayoutParams layoutParams = this.bXv.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(t.ds30);
                this.bXv.setLayoutParams(layoutParams);
                this.bXv.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bXu.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(t.ds50);
                this.bXu.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.bXv.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(t.ds60);
                this.bXv.setLayoutParams(layoutParams2);
                this.bXv.setVisibility(0);
                if (!TextUtils.isEmpty(iVar.amm())) {
                    this.bXv.c(iVar.amm(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bXu.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(t.ds80);
                this.bXu.setLayoutParams(marginLayoutParams2);
            }
            this.bXs.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            aft();
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void afu() {
        if (this.bXs != null && this.rootView != null) {
            ba.i((View) this.bXs, u.frs_praise_btn_bg);
            ba.b(this.bXs, s.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void afv() {
        if (this.bXs != null && this.rootView != null) {
            ba.i((View) this.bXs, u.frs_praise_btn_bg);
            ba.b(this.bXs, s.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int afw() {
        return y.download;
    }
}
