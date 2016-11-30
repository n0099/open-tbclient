package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView aLa;
    private View.OnClickListener aNB;
    private v eLk;
    public TextView eLl;
    public View eLm;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.aLa = (TbImageView) view.findViewById(r.g.photo_image_view);
        this.aLa.setDefaultBgResource(r.d.cp_bg_line_e);
        this.eLm = view.findViewById(r.g.normal_pic_click_bg);
        this.eLl = (TextView) view.findViewById(r.g.tip_default_view);
    }

    public void d(v vVar) {
        if (vVar instanceof l) {
            this.eLk = vVar;
            l lVar = (l) vVar;
            if (lVar.Cq()) {
                String m11do = q.m11do(lVar.getSmallUrl());
                this.eLl.setVisibility(0);
                if (StringUtils.isNull(m11do)) {
                    this.aLa.setDefaultResource(r.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aLa.c(m11do, 25, false);
                }
            } else {
                this.aLa.setDefaultResource(r.f.img_default_100);
                this.eLl.setVisibility(8);
                this.aLa.c(lVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aNB);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            at.c(this.eLl, r.d.cp_cont_g, 1);
            at.l(this.eLl, r.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wX() {
        return this.eLk;
    }

    public void x(View.OnClickListener onClickListener) {
        this.aNB = onClickListener;
    }
}
