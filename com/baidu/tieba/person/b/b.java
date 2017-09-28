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
public class b extends j.a {
    private f aEL;
    private View.OnClickListener aPe;
    public ImageView eZH;
    public TextView eZI;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.h.add_pic_root);
        this.eZH = (ImageView) view.findViewById(d.h.add_image_view);
        this.eZI = (TextView) view.findViewById(d.h.tip_left_count_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tieba.person.data.c) {
            this.aEL = fVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) fVar;
            aj.c(this.eZH, d.g.icon_mine_pic_add);
            if (cVar.aVj() > 0) {
                this.eZI.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.have_left_some_picture_upload), Integer.valueOf(cVar.aVj())));
            }
            getView().setOnClickListener(this.aPe);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.eZI, d.e.cp_cont_e, 1);
            aj.k(getView(), d.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public f wT() {
        return this.aEL;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
    }
}
