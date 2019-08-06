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
    public TbImageView SD;
    public View fhP;
    private m ika;
    public TextView ikb;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.SD = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.SD.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fhP = view.findViewById(R.id.normal_pic_click_bg);
        this.ikb = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tbadk.data.m) {
            this.ika = mVar;
            com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
            if (mVar2.arG()) {
                String nM = o.nM(mVar2.getSmallUrl());
                this.ikb.setVisibility(0);
                if (StringUtils.isNull(nM)) {
                    this.SD.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.SD.startLoad(nM, 25, false);
                }
            } else {
                this.SD.setDefaultResource(R.drawable.img_default_100);
                this.ikb.setVisibility(8);
                this.SD.startLoad(mVar2.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.f(this.ikb, R.color.cp_cont_g, 1);
            am.l(this.ikb, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m alm() {
        return this.ika;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
