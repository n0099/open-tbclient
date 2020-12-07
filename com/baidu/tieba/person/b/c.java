package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class c extends af.a {
    private q XA;
    public TbImageView aaX;
    public View iJJ;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public TextView miZ;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aaX = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.aaX.setDefaultBgResource(R.color.CAM_X0205);
        this.iJJ = view.findViewById(R.id.normal_pic_click_bg);
        this.miZ = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof o) {
            this.XA = qVar;
            o oVar = (o) qVar;
            if (oVar.bBO()) {
                String BR = com.baidu.tbadk.core.util.q.BR(oVar.getSmallUrl());
                this.miZ.setVisibility(0);
                if (StringUtils.isNull(BR)) {
                    this.aaX.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.aaX.startLoad(BR, 25, false);
                }
            } else {
                this.aaX.setDefaultResource(R.drawable.img_default_100);
                this.miZ.setVisibility(8);
                this.aaX.startLoad(oVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.miZ, R.color.CAM_X0111, 1);
            ap.setBackgroundColor(this.miZ, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q qV() {
        return this.XA;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
