package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class c extends af.a {
    private q WD;
    public TbImageView aab;
    public View iyR;
    public TextView lUS;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.aab = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.aab.setDefaultBgResource(R.color.CAM_X0205);
        this.iyR = view.findViewById(R.id.normal_pic_click_bg);
        this.lUS = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof n) {
            this.WD = qVar;
            n nVar = (n) qVar;
            if (nVar.byo()) {
                String Bk = com.baidu.tbadk.core.util.q.Bk(nVar.getSmallUrl());
                this.lUS.setVisibility(0);
                if (StringUtils.isNull(Bk)) {
                    this.aab.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.aab.startLoad(Bk, 25, false);
                }
            } else {
                this.aab.setDefaultResource(R.drawable.img_default_100);
                this.lUS.setVisibility(8);
                this.aab.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.lUS, R.color.CAM_X0111, 1);
            ap.setBackgroundColor(this.lUS, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q qT() {
        return this.WD;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
