package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class b extends v.a {
    public ImageView jhY;
    public TextView jhZ;
    private m jia;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.jhY = (ImageView) view.findViewById(R.id.add_image_view);
        this.jhZ = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.jia = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            am.setImageResource(this.jhY, R.drawable.icon_mine_pic_add);
            if (cVar.cvt() > 0) {
                this.jhZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.cvt())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jhZ, R.color.cp_cont_e, 1);
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m aIC() {
        return this.jia;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
