package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.person.data.c;
/* loaded from: classes7.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n Xw;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public ImageView mjC;
    public TextView mjD;
    public View rootView;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.mjC = (ImageView) view.findViewById(R.id.add_image_view);
        this.mjD = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(n nVar) {
        if (nVar instanceof c) {
            this.Xw = nVar;
            c cVar = (c) nVar;
            ao.setImageResource(this.mjC, R.drawable.icon_mine_pic_add);
            if (cVar.dug() > 0) {
                this.mjD.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.dug())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.mjD, R.color.CAM_X0110, 1);
            ao.setBackgroundColor(getView(), R.color.CAM_X0205);
            this.mSkinType = i;
        }
    }

    public n qx() {
        return this.Xw;
    }

    public void H(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
