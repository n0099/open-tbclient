package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends j.a {
    private f aFr;
    private View.OnClickListener aYH;
    public ImageView ffC;
    public TextView ffD;
    private int mSkinType;
    public View rootView;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.h.add_pic_root);
        this.ffC = (ImageView) view.findViewById(d.h.add_image_view);
        this.ffD = (TextView) view.findViewById(d.h.tip_left_count_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tieba.person.data.a) {
            this.aFr = fVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) fVar;
            aj.c(this.ffC, d.g.icon_mine_pic_add);
            if (aVar.aXc() > 0) {
                this.ffD.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.have_left_some_picture_upload), Integer.valueOf(aVar.aXc())));
            }
            getView().setOnClickListener(this.aYH);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.ffD, d.e.cp_cont_e, 1);
            aj.k(getView(), d.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public f xu() {
        return this.aFr;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aYH = onClickListener;
    }
}
