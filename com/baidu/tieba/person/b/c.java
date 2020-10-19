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
    private q Wy;
    public TbImageView ZV;
    public View ifH;
    public TextView lCh;
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.ZV = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.ZV.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ifH = view.findViewById(R.id.normal_pic_click_bg);
        this.lCh = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(q qVar) {
        if (qVar instanceof n) {
            this.Wy = qVar;
            n nVar = (n) qVar;
            if (nVar.buG()) {
                String Be = com.baidu.tbadk.core.util.q.Be(nVar.getSmallUrl());
                this.lCh.setVisibility(0);
                if (StringUtils.isNull(Be)) {
                    this.ZV.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.ZV.startLoad(Be, 25, false);
                }
            } else {
                this.ZV.setDefaultResource(R.drawable.img_default_100);
                this.lCh.setVisibility(8);
                this.ZV.startLoad(nVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.lCh, R.color.cp_cont_g, 1);
            ap.setBackgroundColor(this.lCh, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public q qT() {
        return this.Wy;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
