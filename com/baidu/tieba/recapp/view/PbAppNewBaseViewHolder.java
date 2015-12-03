package com.baidu.tieba.recapp.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PbAppNewBaseViewHolder extends BaseAppViewHolder {
    protected TextView dik;
    protected ViewGroup dil;

    public PbAppNewBaseViewHolder(View view) {
        super(view);
        this.dif = (TextView) view.findViewById(n.f.recommend_title);
        this.dih = (HeadImageView) view.findViewById(n.f.recommend_icon);
        this.did = (TextView) view.findViewById(n.f.recommend_btn);
        this.die = (TextView) view.findViewById(n.f.pb_app_push);
        this.dig = (TextView) view.findViewById(n.f.recommend_content);
        this.dik = (TextView) view.findViewById(n.f.recommend_time);
        this.dii = (AppDownloadView) view.findViewById(n.f.recommend_app_download_view);
        this.dij = view.findViewById(n.f.divider_line);
        this.dil = (ViewGroup) view.findViewById(n.f.layout);
        this.dih.setClickable(false);
    }

    @Override // com.baidu.tieba.recapp.PbRecBaseViewHolder
    public void update(com.baidu.tieba.tbadkCore.data.n nVar, int i, boolean z) {
        super.update(nVar, i, z);
        if (nVar != null) {
            this.dif.setText(ax.d(nVar.getAppName().trim(), 7, "..."));
            if (!m.rh().rj()) {
                ViewGroup.LayoutParams layoutParams = this.dih.getLayoutParams();
                layoutParams.width = (int) this.rootView.getResources().getDimension(n.d.ds30);
                this.dih.setLayoutParams(layoutParams);
                this.dih.setVisibility(4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dil.getLayoutParams();
                marginLayoutParams.leftMargin = (int) this.rootView.getResources().getDimension(n.d.ds50);
                this.dil.setLayoutParams(marginLayoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.dih.getLayoutParams();
                layoutParams2.width = (int) this.rootView.getResources().getDimension(n.d.ds60);
                this.dih.setLayoutParams(layoutParams2);
                this.dih.setVisibility(0);
                if (!TextUtils.isEmpty(nVar.aCP())) {
                    this.dih.d(nVar.aCP(), z ? 17 : 18, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dil.getLayoutParams();
                marginLayoutParams2.leftMargin = (int) this.rootView.getResources().getDimension(n.d.ds80);
                this.dil.setLayoutParams(marginLayoutParams2);
            }
            String s = ax.s(nVar.aCR());
            if (s == null) {
                s = "";
            }
            this.dik.setText(s);
            if (StringUtils.isNull(nVar.aCQ())) {
                this.dig.setVisibility(8);
            } else {
                this.dig.setVisibility(0);
                this.dig.setText(getFixedChineseString(nVar.aCQ()));
            }
            this.did.setTag(this);
            this.rootView.setBackgroundDrawable(null);
            if (nVar.aCU()) {
                this.did.setVisibility(8);
                this.die.setVisibility(0);
                this.dif.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.did.setVisibility(0);
                this.die.setVisibility(8);
                this.dif.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(n.e.icon_extend), (Drawable) null);
            }
            a(nVar, i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected void avZ() {
        if (this.did != null && this.rootView != null) {
            as.i((View) this.did, n.e.btn_appdownload);
            as.b(this.did, n.c.cp_cont_i, 1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.BaseAppViewHolder
    protected int awa() {
        return n.i.pb_app_download;
    }
}
