package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class q extends y.a {
    public TbImageView aGB;
    private View.OnClickListener aew;
    private v ejO;
    public TextView emy;
    public View emz;
    private int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.aGB = (TbImageView) view.findViewById(u.g.photo_image_view);
        this.aGB.setDefaultBgResource(u.d.cp_bg_line_e);
        this.emz = view.findViewById(u.g.normal_pic_click_bg);
        this.emy = (TextView) view.findViewById(u.g.tip_default_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tbadk.data.k) {
            this.ejO = vVar;
            com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
            if (kVar.AQ()) {
                String di = com.baidu.tbadk.core.util.q.di(kVar.getSmallUrl());
                this.emy.setVisibility(0);
                av.c(this.emy, u.d.cp_cont_i, 1);
                if (StringUtils.isNull(di)) {
                    this.aGB.setDefaultResource(u.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aGB.c(di, 25, false);
                }
            } else {
                this.aGB.setDefaultResource(u.f.img_default_100);
                this.emy.setVisibility(8);
                this.aGB.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aew);
        }
    }

    public v vP() {
        return this.ejO;
    }

    public void I(View.OnClickListener onClickListener) {
        this.aew = onClickListener;
    }
}
