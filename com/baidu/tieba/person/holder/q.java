package com.baidu.tieba.person.holder;

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
    public TbImageView aHs;
    private View.OnClickListener afk;
    private v euo;
    public TextView ewX;
    public View ewY;
    private int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.aHs = (TbImageView) view.findViewById(u.g.photo_image_view);
        this.aHs.setDefaultBgResource(u.d.cp_bg_line_e);
        this.ewY = view.findViewById(u.g.normal_pic_click_bg);
        this.ewX = (TextView) view.findViewById(u.g.tip_default_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tbadk.data.k) {
            this.euo = vVar;
            com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
            if (kVar.AQ()) {
                String dh = com.baidu.tbadk.core.util.q.dh(kVar.getSmallUrl());
                this.ewX.setVisibility(0);
                av.c(this.ewX, u.d.cp_cont_i, 1);
                if (StringUtils.isNull(dh)) {
                    this.aHs.setDefaultResource(u.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aHs.c(dh, 25, false);
                }
            } else {
                this.aHs.setDefaultResource(u.f.img_default_100);
                this.ewX.setVisibility(8);
                this.aHs.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.afk);
        }
    }

    public v vP() {
        return this.euo;
    }

    public void J(View.OnClickListener onClickListener) {
        this.afk = onClickListener;
    }
}
