package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends y.a {
    public TbImageView aOL;
    private View.OnClickListener aRW;
    private v eAe;
    public TextView eAf;
    public View eAg;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aOL = (TbImageView) view.findViewById(w.h.photo_image_view);
        this.aOL.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eAg = view.findViewById(w.h.normal_pic_click_bg);
        this.eAf = (TextView) view.findViewById(w.h.tip_default_view);
    }

    public void e(v vVar) {
        if (vVar instanceof k) {
            this.eAe = vVar;
            k kVar = (k) vVar;
            if (kVar.CQ()) {
                String dn = q.dn(kVar.getSmallUrl());
                this.eAf.setVisibility(0);
                if (StringUtils.isNull(dn)) {
                    this.aOL.setDefaultResource(w.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aOL.c(dn, 25, false);
                }
            } else {
                this.aOL.setDefaultResource(w.g.img_default_100);
                this.eAf.setVisibility(8);
                this.aOL.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aRW);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eAf, w.e.cp_cont_g, 1);
            aq.k(this.eAf, w.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v xx() {
        return this.eAe;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }
}
