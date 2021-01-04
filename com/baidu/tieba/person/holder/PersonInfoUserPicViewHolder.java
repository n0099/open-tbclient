package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.data.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n Xy;
    public TbImageView abI;
    public View iVW;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public TextView moj;

    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.abI = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.abI.setDefaultBgResource(R.color.CAM_X0205);
        this.iVW = view.findViewById(R.id.normal_pic_click_bg);
        this.moj = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void h(n nVar) {
        if (nVar instanceof o) {
            this.Xy = nVar;
            o oVar = (o) nVar;
            if (oVar.bEj()) {
                String BQ = q.BQ(oVar.getSmallUrl());
                this.moj.setVisibility(0);
                if (StringUtils.isNull(BQ)) {
                    this.abI.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.abI.startLoad(BQ, 25, false);
                }
            } else {
                this.abI.setDefaultResource(R.drawable.img_default_100);
                this.moj.setVisibility(8);
                this.abI.startLoad(oVar.getSmallUrl(), 10, false);
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.moj, R.color.CAM_X0111, 1);
            ao.setBackgroundColor(this.moj, R.color.black_alpha50);
            this.mSkinType = i;
        }
    }

    public n qx() {
        return this.Xy;
    }

    public void H(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
