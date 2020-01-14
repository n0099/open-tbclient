package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends v.a {
    public ImageView jfp;
    public TextView jfq;
    private m jfr;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.jfp = (ImageView) view.findViewById(R.id.add_image_view);
        this.jfq = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.jfr = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            am.setImageResource(this.jfp, R.drawable.icon_mine_pic_add);
            if (cVar.ctE() > 0) {
                this.jfq.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.ctE())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jfq, R.color.cp_cont_e, 1);
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m aGg() {
        return this.jfr;
    }

    public void C(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
