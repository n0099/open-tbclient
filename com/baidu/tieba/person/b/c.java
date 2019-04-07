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
    public TbImageView Uz;
    public View eMf;
    private m hKC;
    public TextView hKD;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Uz = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.Uz.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.eMf = view.findViewById(d.g.normal_pic_click_bg);
        this.hKD = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.hKC = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.isPortrait()) {
                String mt = o.mt(mVar2.getSmallUrl());
                this.hKD.setVisibility(0);
                if (StringUtils.isNull(mt)) {
                    this.Uz.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.Uz.startLoad(mt, 25, false);
                }
            } else {
                this.Uz.setDefaultResource(d.f.img_default_100);
                this.hKD.setVisibility(8);
                this.Uz.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.hKD, d.C0277d.cp_cont_g, 1);
            al.l(this.hKD, d.C0277d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m afg() {
        return this.hKC;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
