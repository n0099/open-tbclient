package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.person.data.c;
/* loaded from: classes7.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n YL;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public ImageView muV;
    public TextView muW;
    public View rootView;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.muV = (ImageView) view.findViewById(R.id.add_image_view);
        this.muW = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(n nVar) {
        if (nVar instanceof c) {
            this.YL = nVar;
            c cVar = (c) nVar;
            ap.setImageResource(this.muV, R.drawable.icon_mine_pic_add);
            if (cVar.dwF() > 0) {
                this.muW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.dwF())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.muW, R.color.CAM_X0110, 1);
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
            this.mSkinType = i;
        }
    }

    public n qv() {
        return this.YL;
    }

    public void I(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
