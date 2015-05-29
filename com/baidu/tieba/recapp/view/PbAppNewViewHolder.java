package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public class PbAppNewViewHolder extends BaseAppViewHolder {
    protected TbImageView cbq;
    protected TextView cbr;
    protected ViewGroup cbs;

    public PbAppNewViewHolder(View view) {
        super(view);
        this.cbm = (TextView) view.findViewById(q.recommend_title);
        this.cbo = (HeadImageView) view.findViewById(q.recommend_icon);
        this.cbl = (TextView) view.findViewById(q.recommend_btn);
        this.cbn = (TextView) view.findViewById(q.recommend_content);
        this.cbq = (TbImageView) view.findViewById(q.recommend_img);
        this.cbr = (TextView) view.findViewById(q.recommend_time);
        this.cbp = view.findViewById(q.divider_line);
        this.cbs = (ViewGroup) view.findViewById(q.layout);
        this.cbo.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(i iVar, int i, boolean z) {
        super.update(iVar, i, z);
        if (iVar != null) {
            this.cbm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ay.getDrawable(p.icon_extend), (Drawable) null);
            this.cbm.setText(iVar.aom());
            if (!n.qc().qe()) {
                ViewGroup.LayoutParams layoutParams = this.cbo.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(o.ds30);
                this.cbo.setLayoutParams(layoutParams);
                this.cbo.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cbs.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(o.ds50);
                this.cbs.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.cbo.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(o.ds60);
                this.cbo.setLayoutParams(layoutParams2);
                this.cbo.setVisibility(0);
                if (!TextUtils.isEmpty(iVar.aon())) {
                    this.cbo.c(iVar.aon(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cbs.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(o.ds80);
                this.cbs.setLayoutParams(marginLayoutParams2);
            }
            String o = bb.o(iVar.aoq());
            if (o == null) {
                o = "";
            }
            this.cbr.setText(o);
            if (StringUtils.isNull(iVar.aoo())) {
                this.cbn.setVisibility(8);
            } else {
                this.cbn.setVisibility(0);
                this.cbn.setText(getFixedChineseString(iVar.aoo()));
            }
            ViewGroup.LayoutParams layoutParams3 = this.cbq.getLayoutParams();
            layoutParams3.width = (int) (this.rootView.getResources().getDimension(o.ds594) - this.rootView.getResources().getDimension(o.ds20));
            layoutParams3.height = (int) (this.rootView.getResources().getDimension(o.ds260) - this.rootView.getResources().getDimension(o.ds10));
            this.cbq.setLayoutParams(layoutParams3);
            if (!StringUtils.isNull(iVar.aop()) && n.qc().qg()) {
                this.cbq.setVisibility(0);
                this.cbq.c(iVar.aop(), z ? 17 : 18, false);
            } else {
                this.cbq.setVisibility(8);
            }
            this.cbl.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            ahm();
            if (iVar.aov()) {
                this.cbl.setVisibility(8);
            } else {
                this.cbl.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void ahn() {
        if (this.cbl != null && this.rootView != null) {
            ay.i((View) this.cbl, p.btn_appdownload);
            ay.b(this.cbl, com.baidu.tieba.n.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void aho() {
        if (this.cbl != null && this.rootView != null) {
            ay.i((View) this.cbl, p.btn_content_download_d);
            ay.b(this.cbl, com.baidu.tieba.n.faceshop_downloaded_text, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int ahp() {
        return t.pb_app_download;
    }
}
