package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends j.a {
    private f aEL;
    private View.OnClickListener aPe;
    public TbImageView aTA;
    public View cjJ;
    public TextView eZJ;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aTA = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aTA.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cjJ = view.findViewById(d.h.normal_pic_click_bg);
        this.eZJ = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tbadk.data.j) {
            this.aEL = fVar;
            com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) fVar;
            if (jVar.Cc()) {
                String dz = o.dz(jVar.getSmallUrl());
                this.eZJ.setVisibility(0);
                if (StringUtils.isNull(dz)) {
                    this.aTA.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aTA.c(dz, 25, false);
                }
            } else {
                this.aTA.setDefaultResource(d.g.img_default_100);
                this.eZJ.setVisibility(8);
                this.aTA.c(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aPe);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.eZJ, d.e.cp_cont_g, 1);
            aj.k(this.eZJ, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f wT() {
        return this.aEL;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
    }
}
