package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends y.a {
    private View.OnClickListener Fn;
    public TbImageView aFZ;
    private v dBl;
    public TextView dDM;
    public View dDN;
    private int mSkinType;

    public q(View view) {
        super(view);
        this.mSkinType = 3;
        this.aFZ = (TbImageView) view.findViewById(t.g.photo_image_view);
        this.aFZ.setDefaultBgResource(t.d.cp_bg_line_e);
        this.dDN = view.findViewById(t.g.normal_pic_click_bg);
        this.dDM = (TextView) view.findViewById(t.g.tip_default_view);
    }

    public void c(v vVar) {
        if (vVar instanceof com.baidu.tbadk.data.i) {
            this.dBl = vVar;
            com.baidu.tbadk.data.i iVar = (com.baidu.tbadk.data.i) vVar;
            if (iVar.AG()) {
                String dk = com.baidu.tbadk.core.util.q.dk(iVar.getSmallUrl());
                this.dDM.setVisibility(0);
                at.c(this.dDM, t.d.cp_cont_i, 1);
                if (StringUtils.isNull(dk)) {
                    this.aFZ.setDefaultResource(t.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aFZ.c(dk, 25, false);
                }
            } else {
                this.aFZ.setDefaultResource(t.f.img_default_100);
                this.dDM.setVisibility(8);
                this.aFZ.c(iVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.Fn);
        }
    }

    public v vL() {
        return this.dBl;
    }

    public void I(View.OnClickListener onClickListener) {
        this.Fn = onClickListener;
    }
}
