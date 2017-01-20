package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView aIY;
    private View.OnClickListener aLT;
    private v eyK;
    public TextView eyL;
    public View eyM;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.aIY = (TbImageView) view.findViewById(r.h.photo_image_view);
        this.aIY.setDefaultBgResource(r.e.cp_bg_line_e);
        this.eyM = view.findViewById(r.h.normal_pic_click_bg);
        this.eyL = (TextView) view.findViewById(r.h.tip_default_view);
    }

    public void e(v vVar) {
        if (vVar instanceof k) {
            this.eyK = vVar;
            k kVar = (k) vVar;
            if (kVar.BZ()) {
                String dn = p.dn(kVar.getSmallUrl());
                this.eyL.setVisibility(0);
                if (StringUtils.isNull(dn)) {
                    this.aIY.setDefaultResource(r.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aIY.c(dn, 25, false);
                }
            } else {
                this.aIY.setDefaultResource(r.g.img_default_100);
                this.eyL.setVisibility(8);
                this.aIY.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aLT);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.c(this.eyL, r.e.cp_cont_g, 1);
            ap.k(this.eyL, r.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wE() {
        return this.eyK;
    }

    public void w(View.OnClickListener onClickListener) {
        this.aLT = onClickListener;
    }
}
