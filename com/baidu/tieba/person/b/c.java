package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c extends y.a {
    public TbImageView XS;
    public View gPm;
    private m jSi;
    public TextView jSj;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.XS = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.XS.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPm = view.findViewById(R.id.normal_pic_click_bg);
        this.jSj = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(m mVar) {
        if (mVar instanceof l) {
            this.jSi = mVar;
            l lVar = (l) mVar;
            if (lVar.aWw()) {
                String uA = o.uA(lVar.getSmallUrl());
                this.jSj.setVisibility(0);
                if (StringUtils.isNull(uA)) {
                    this.XS.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.XS.startLoad(uA, 25, false);
                }
            } else {
                this.XS.setDefaultResource(R.drawable.img_default_100);
                this.jSj.setVisibility(8);
                this.XS.startLoad(lVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jSj, R.color.cp_cont_g, 1);
            am.setBackgroundColor(this.jSj, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public m aQY() {
        return this.jSi;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
