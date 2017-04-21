package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends y.a {
    public TbImageView aON;
    private View.OnClickListener aRY;
    private v eCu;
    public TextView eCv;
    public View eCw;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aON = (TbImageView) view.findViewById(w.h.photo_image_view);
        this.aON.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eCw = view.findViewById(w.h.normal_pic_click_bg);
        this.eCv = (TextView) view.findViewById(w.h.tip_default_view);
    }

    public void e(v vVar) {
        if (vVar instanceof k) {
            this.eCu = vVar;
            k kVar = (k) vVar;
            if (kVar.CQ()) {
                String dn = q.dn(kVar.getSmallUrl());
                this.eCv.setVisibility(0);
                if (StringUtils.isNull(dn)) {
                    this.aON.setDefaultResource(w.g.pic_mycenter_avatar_def_i);
                } else {
                    this.aON.c(dn, 25, false);
                }
            } else {
                this.aON.setDefaultResource(w.g.img_default_100);
                this.eCv.setVisibility(8);
                this.aON.c(kVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.aRY);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eCv, w.e.cp_cont_g, 1);
            aq.k(this.eCv, w.e.black_alpha50);
            this.mSkinType = i;
        }
    }

    public v xx() {
        return this.eCu;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aRY = onClickListener;
    }
}
