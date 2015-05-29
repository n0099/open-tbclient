package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public class PbAppViewHolder extends BaseAppViewHolder {
    public PbAppViewHolder(View view) {
        super(view);
        this.cbm = (TextView) view.findViewById(q.recommend_title);
        this.cbn = (TextView) view.findViewById(q.recommend_content);
        this.cbo = (HeadImageView) view.findViewById(q.recommend_icon);
        this.cbl = (TextView) view.findViewById(q.recommend_btn);
        this.cbp = view.findViewById(q.divider_line);
        this.cbo.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(i iVar, int i, boolean z) {
        super.update(iVar, i, z);
        if (iVar != null) {
            this.cbm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ay.getDrawable(p.icon_extend), (Drawable) null);
            this.cbm.setText(iVar.aom());
            if (StringUtils.isNull(iVar.aoo())) {
                this.cbn.setVisibility(8);
            } else {
                this.cbn.setVisibility(0);
                this.cbn.setText(getFixedChineseString(iVar.aoo()));
            }
            if (!n.qc().qe()) {
                ViewGroup.LayoutParams layoutParams = this.cbo.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(o.ds30);
                this.cbo.setLayoutParams(layoutParams);
                this.cbo.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cbn.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(o.ds50);
                this.cbn.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.cbo.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(o.ds60);
                this.cbo.setLayoutParams(layoutParams2);
                this.cbo.setVisibility(0);
                if (!TextUtils.isEmpty(iVar.aon())) {
                    this.cbo.c(iVar.aon(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cbn.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(o.ds80);
                this.cbn.setLayoutParams(marginLayoutParams2);
            }
            this.cbl.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            ahm();
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void ahn() {
        if (this.cbl != null && this.rootView != null) {
            ay.i((View) this.cbl, p.frs_praise_btn_bg);
            ay.b(this.cbl, com.baidu.tieba.n.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aho() {
        if (this.cbl != null && this.rootView != null) {
            ay.i((View) this.cbl, p.frs_praise_btn_bg);
            ay.b(this.cbl, com.baidu.tieba.n.cp_cont_b, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int ahp() {
        return t.download;
    }
}
