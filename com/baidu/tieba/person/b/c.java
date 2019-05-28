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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends v.a {
    public TbImageView Sm;
    public View fcp;
    private m icF;
    public TextView icG;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Sm = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.Sm.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fcp = view.findViewById(R.id.normal_pic_click_bg);
        this.icG = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.icF = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.isPortrait()) {
                String nB = o.nB(mVar2.getSmallUrl());
                this.icG.setVisibility(0);
                if (StringUtils.isNull(nB)) {
                    this.Sm.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.Sm.startLoad(nB, 25, false);
                }
            } else {
                this.Sm.setDefaultResource(R.drawable.img_default_100);
                this.icG.setVisibility(8);
                this.Sm.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.f(this.icG, R.color.cp_cont_g, 1);
            al.l(this.icG, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m akf() {
        return this.icF;
    }

    public void z(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
