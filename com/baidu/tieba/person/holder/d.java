package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView aKI;
    private View.OnClickListener aif;
    private v eCI;
    public TextView eCJ;
    public View eCK;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.aKI = (TbImageView) view.findViewById(t.g.photo_image_view);
        this.aKI.setDefaultBgResource(t.d.cp_bg_line_e);
        this.eCK = view.findViewById(t.g.normal_pic_click_bg);
        this.eCJ = (TextView) view.findViewById(t.g.tip_default_view);
    }

    public void c(v vVar) {
        if (vVar instanceof k) {
            this.eCI = vVar;
            k kVar = (k) vVar;
            if (kVar.Cf()) {
                String dk = q.dk(kVar.getSmallUrl());
                this.eCJ.setVisibility(0);
                if (StringUtils.isNull(dk)) {
                    this.aKI.setDefaultResource(t.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aKI.c(dk, 25, false);
                }
            } else {
                this.aKI.setDefaultResource(t.f.img_default_100);
                this.eCJ.setVisibility(8);
                this.aKI.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aif);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.c(this.eCJ, t.d.cp_cont_g, 1);
            av.l(this.eCJ, t.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wT() {
        return this.eCI;
    }

    public void H(View.OnClickListener onClickListener) {
        this.aif = onClickListener;
    }
}
