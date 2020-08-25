package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class b extends af.a {
    private q VP;
    public ImageView ldP;
    public TextView ldQ;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.ldP = (ImageView) view.findViewById(R.id.add_image_view);
        this.ldQ = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(q qVar) {
        if (qVar instanceof com.baidu.tieba.person.data.c) {
            this.VP = qVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) qVar;
            ap.setImageResource(this.ldP, R.drawable.icon_mine_pic_add);
            if (cVar.dgs() > 0) {
                this.ldQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.dgs())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ldQ, R.color.cp_cont_e, 1);
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public q qO() {
        return this.VP;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
