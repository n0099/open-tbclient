package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends y.a {
    public TbImageView aPg;
    private View.OnClickListener aSt;
    private v eyh;
    public TextView eyi;
    public View eyj;
    private int mSkinType;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.aPg = (TbImageView) view.findViewById(w.h.photo_image_view);
        this.aPg.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eyj = view.findViewById(w.h.normal_pic_click_bg);
        this.eyi = (TextView) view.findViewById(w.h.tip_default_view);
    }

    public void e(v vVar) {
        if (vVar instanceof j) {
            this.eyh = vVar;
            j jVar = (j) vVar;
            if (jVar.BV()) {
                String dl = q.dl(jVar.getSmallUrl());
                this.eyi.setVisibility(0);
                if (StringUtils.isNull(dl)) {
                    this.aPg.setDefaultResource(w.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aPg.c(dl, 25, false);
                }
            } else {
                this.aPg.setDefaultResource(w.g.img_default_100);
                this.eyi.setVisibility(8);
                this.aPg.c(jVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aSt);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eyi, w.e.cp_cont_g, 1);
            aq.k(this.eyi, w.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wL() {
        return this.eyh;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aSt = onClickListener;
    }
}
