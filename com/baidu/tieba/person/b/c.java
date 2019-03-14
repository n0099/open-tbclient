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
    public View eMt;
    private m hKQ;
    public TextView hKR;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Uz = (TbImageView) view.findViewById(d.g.photo_image_view);
        this.Uz.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.eMt = view.findViewById(d.g.normal_pic_click_bg);
        this.hKR = (TextView) view.findViewById(d.g.tip_default_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.hKQ = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.isPortrait()) {
                String ms = o.ms(mVar2.getSmallUrl());
                this.hKR.setVisibility(0);
                if (StringUtils.isNull(ms)) {
                    this.Uz.setDefaultResource(d.f.pic_mycenter_avatar_def_i);
                } else {
                    this.Uz.startLoad(ms, 25, false);
                }
            } else {
                this.Uz.setDefaultResource(d.f.img_default_100);
                this.hKR.setVisibility(8);
                this.Uz.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.hKR, d.C0277d.cp_cont_g, 1);
            al.l(this.hKR, d.C0277d.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m afj() {
        return this.hKQ;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
