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
    public ImageView jgl;
    public TextView jgm;
    private m jgn;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.jgl = (ImageView) view.findViewById(R.id.add_image_view);
        this.jgm = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.jgn = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            am.setImageResource(this.jgl, R.drawable.icon_mine_pic_add);
            if (cVar.cuX() > 0) {
                this.jgm.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.cuX())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jgm, R.color.cp_cont_e, 1);
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m aIv() {
        return this.jgn;
    }

    public void D(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
