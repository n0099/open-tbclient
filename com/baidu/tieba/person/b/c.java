package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class c extends ad.a {
    private q Vt;
    public TbImageView YP;
    public View hqA;
    public TextView kEX;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.YP = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.YP.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hqA = view.findViewById(R.id.normal_pic_click_bg);
        this.kEX = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof m) {
            this.Vt = qVar;
            m mVar = (m) qVar;
            if (mVar.beG()) {
                String wz = p.wz(mVar.getSmallUrl());
                this.kEX.setVisibility(0);
                if (StringUtils.isNull(wz)) {
                    this.YP.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.YP.startLoad(wz, 25, false);
                }
            } else {
                this.YP.setDefaultResource(R.drawable.img_default_100);
                this.kEX.setVisibility(8);
                this.YP.startLoad(mVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.kEX, R.color.cp_cont_g, 1);
            an.setBackgroundColor(this.kEX, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q po() {
        return this.Vt;
    }

    public void E(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
