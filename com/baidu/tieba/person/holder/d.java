package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView aKr;
    private View.OnClickListener aMS;
    private v eoP;
    public TextView eoQ;
    public View eoR;
    private int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.aKr = (TbImageView) view.findViewById(r.g.photo_image_view);
        this.aKr.setDefaultBgResource(r.d.cp_bg_line_e);
        this.eoR = view.findViewById(r.g.normal_pic_click_bg);
        this.eoQ = (TextView) view.findViewById(r.g.tip_default_view);
    }

    public void e(v vVar) {
        if (vVar instanceof l) {
            this.eoP = vVar;
            l lVar = (l) vVar;
            if (lVar.Cd()) {
                String dp = q.dp(lVar.getSmallUrl());
                this.eoQ.setVisibility(0);
                if (StringUtils.isNull(dp)) {
                    this.aKr.setDefaultResource(r.f.pic_mycenter_avatar_def_i);
                } else {
                    this.aKr.c(dp, 25, false);
                }
            } else {
                this.aKr.setDefaultResource(r.f.img_default_100);
                this.eoQ.setVisibility(8);
                this.aKr.c(lVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aMS);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ar.c(this.eoQ, r.d.cp_cont_g, 1);
            ar.l(this.eoQ, r.d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v wK() {
        return this.eoP;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aMS = onClickListener;
    }
}
