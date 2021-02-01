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
/* loaded from: classes8.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    private n Xs;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public ImageView msE;
    public TextView msF;
    public View rootView;

    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.msE = (ImageView) view.findViewById(R.id.add_image_view);
        this.msF = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(n nVar) {
        if (nVar instanceof c) {
            this.Xs = nVar;
            c cVar = (c) nVar;
            ap.setImageResource(this.msE, R.drawable.icon_mine_pic_add);
            if (cVar.dwp() > 0) {
                this.msF.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.dwp())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.msF, R.color.CAM_X0110, 1);
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
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
