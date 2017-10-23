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
    private f aEy;
    private View.OnClickListener aOR;
    public TbImageView aTn;
    public View cjx;
    public TextView eZv;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aTn = (TbImageView) view.findViewById(d.h.photo_image_view);
        this.aTn.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cjx = view.findViewById(d.h.normal_pic_click_bg);
        this.eZv = (TextView) view.findViewById(d.h.tip_default_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tbadk.data.j) {
            this.aEy = fVar;
            com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) fVar;
            if (jVar.BW()) {
                String dy = o.dy(jVar.getSmallUrl());
                this.eZv.setVisibility(0);
                if (StringUtils.isNull(dy)) {
                    this.aTn.setDefaultResource(d.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aTn.c(dy, 25, false);
                }
            } else {
                this.aTn.setDefaultResource(d.g.img_default_100);
                this.eZv.setVisibility(8);
                this.aTn.c(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aOR);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.eZv, d.e.cp_cont_g, 1);
            aj.k(this.eZv, d.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public f wM() {
        return this.aEy;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aOR = onClickListener;
    }
}
