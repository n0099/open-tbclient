package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c extends aa.a {
    private o UO;
    public TbImageView Yl;
    public View hep;
    public TextView kll;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.Yl = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.Yl.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hep = view.findViewById(R.id.normal_pic_click_bg);
        this.kll = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(o oVar) {
        if (oVar instanceof m) {
            this.UO = oVar;
            m mVar = (m) oVar;
            if (mVar.bcE()) {
                String wj = com.baidu.tbadk.core.util.o.wj(mVar.getSmallUrl());
                this.kll.setVisibility(0);
                if (StringUtils.isNull(wj)) {
                    this.Yl.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.Yl.startLoad(wj, 25, false);
                }
            } else {
                this.Yl.setDefaultResource(R.drawable.img_default_100);
                this.kll.setVisibility(8);
                this.Yl.startLoad(mVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.kll, R.color.cp_cont_g, 1);
            am.setBackgroundColor(this.kll, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public o oX() {
        return this.UO;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
