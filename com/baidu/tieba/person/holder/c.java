package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends y.a {
    private View.OnClickListener aLT;
    public ImageView eyI;
    public TextView eyJ;
    private v eyK;
    private int mSkinType;
    public View rootView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(r.h.add_pic_root);
        this.eyI = (ImageView) view.findViewById(r.h.add_image_view);
        this.eyJ = (TextView) view.findViewById(r.h.tip_left_count_view);
    }

    public void e(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eyK = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            ap.c(this.eyI, r.g.icon_mine_pic_add);
            if (aVar.aQz() > 0) {
                this.eyJ.setText(String.format(TbadkCoreApplication.m9getInst().getString(r.l.have_left_some_picture_upload), Integer.valueOf(aVar.aQz())));
            }
            getView().setOnClickListener(this.aLT);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.c(this.eyJ, r.e.cp_cont_e, 1);
            ap.k(getView(), r.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v wE() {
        return this.eyK;
    }

    public void w(View.OnClickListener onClickListener) {
        this.aLT = onClickListener;
    }
}
