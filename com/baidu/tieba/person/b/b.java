package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends y.a {
    private View.OnClickListener aRW;
    public ImageView eAc;
    public TextView eAd;
    private v eAe;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(w.h.add_pic_root);
        this.eAc = (ImageView) view.findViewById(w.h.add_image_view);
        this.eAd = (TextView) view.findViewById(w.h.tip_left_count_view);
    }

    public void e(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eAe = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            aq.c(this.eAc, w.g.icon_mine_pic_add);
            if (aVar.aQl() > 0) {
                this.eAd.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.have_left_some_picture_upload), Integer.valueOf(aVar.aQl())));
            }
            getView().setOnClickListener(this.aRW);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.c(this.eAd, w.e.cp_cont_e, 1);
            aq.k(getView(), w.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v xx() {
        return this.eAe;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }
}
