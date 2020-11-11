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
/* loaded from: classes24.dex */
public class c extends af.a {
    private q Wz;
    public TbImageView ZW;
    public View iyc;
    public TextView lUA;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.ZW = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.ZW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iyc = view.findViewById(R.id.normal_pic_click_bg);
        this.lUA = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof n) {
            this.Wz = qVar;
            n nVar = (n) qVar;
            if (nVar.byY()) {
                String BL = com.baidu.tbadk.core.util.q.BL(nVar.getSmallUrl());
                this.lUA.setVisibility(0);
                if (StringUtils.isNull(BL)) {
                    this.ZW.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.ZW.startLoad(BL, 25, false);
                }
            } else {
                this.ZW.setDefaultResource(R.drawable.img_default_100);
                this.lUA.setVisibility(8);
                this.ZW.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.lUA, R.color.cp_cont_g, 1);
            ap.setBackgroundColor(this.lUA, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q qT() {
        return this.Wz;
    }

    public void G(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
