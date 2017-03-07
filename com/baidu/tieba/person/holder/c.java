package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends y.a {
    private View.OnClickListener aRG;
    public ImageView eCh;
    public TextView eCi;
    private v eCj;
    private int mSkinType;
    public View rootView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(w.h.add_pic_root);
        this.eCh = (ImageView) view.findViewById(w.h.add_image_view);
        this.eCi = (TextView) view.findViewById(w.h.tip_left_count_view);
    }

    public void e(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eCj = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            aq.c(this.eCh, w.g.icon_mine_pic_add);
            if (aVar.aQc() > 0) {
                this.eCi.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.have_left_some_picture_upload), Integer.valueOf(aVar.aQc())));
            }
            getView().setOnClickListener(this.aRG);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eCi, w.e.cp_cont_e, 1);
            aq.k(getView(), w.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v xb() {
        return this.eCj;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aRG = onClickListener;
    }
}
