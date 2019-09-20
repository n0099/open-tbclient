package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends v.a {
    public TbImageView SC;
    public View fjE;
    private m ilZ;
    public TextView ima;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.SC = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.SC.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fjE = view.findViewById(R.id.normal_pic_click_bg);
        this.ima = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.ilZ = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.arS()) {
                String nO = o.nO(mVar2.getSmallUrl());
                this.ima.setVisibility(0);
                if (StringUtils.isNull(nO)) {
                    this.SC.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.SC.startLoad(nO, 25, false);
                }
            } else {
                this.SC.setDefaultResource(R.drawable.img_default_100);
                this.ima.setVisibility(8);
                this.SC.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.f(this.ima, R.color.cp_cont_g, 1);
            am.l(this.ima, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m aly() {
        return this.ilZ;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
