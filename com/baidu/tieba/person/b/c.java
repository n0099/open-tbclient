package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class c extends v.a {
    public TbImageView UB;
    public View eMg;
    private m hKD;
    public TextView hKE;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.UB = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.UB.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.eMg = view.findViewById(d.g.normal_pic_click_bg);
        this.hKE = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.hKD = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.isPortrait()) {
                String mt = o.mt(mVar2.getSmallUrl());
                this.hKE.setVisibility(0);
                if (StringUtils.isNull(mt)) {
                    this.UB.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.UB.startLoad(mt, 25, false);
                }
            } else {
                this.UB.setDefaultResource(d.f.img_default_100);
                this.hKE.setVisibility(8);
                this.UB.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.hKE, d.C0277d.cp_cont_g, 1);
            al.l(this.hKE, d.C0277d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m afg() {
        return this.hKD;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
