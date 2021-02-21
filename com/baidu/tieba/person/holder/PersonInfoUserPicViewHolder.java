package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.data.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n Xs;
    public TbImageView abB;
    public View iXk;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public TextView msV;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.abB = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.abB.setDefaultBgResource(R.color.CAM_X0205);
        this.iXk = view.findViewById(R.id.normal_pic_click_bg);
        this.msV = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(n nVar) {
        if (nVar instanceof o) {
            this.Xs = nVar;
            o oVar = (o) nVar;
            if (oVar.bAI()) {
                String AV = r.AV(oVar.getSmallUrl());
                this.msV.setVisibility(0);
                if (StringUtils.isNull(AV)) {
                    this.abB.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.abB.startLoad(AV, 25, false);
                }
            } else {
                this.abB.setDefaultResource(R.drawable.img_default_100);
                this.msV.setVisibility(8);
                this.abB.startLoad(oVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.msV, R.color.CAM_X0111, 1);
            ap.setBackgroundColor(this.msV, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public n qv() {
        return this.Xs;
    }

    public void H(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
