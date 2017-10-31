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
    private f aFh;
    public ImageView fhI;
    public TextView fhJ;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.g.add_pic_root);
        this.fhI = (ImageView) view.findViewById(d.g.add_image_view);
        this.fhJ = (TextView) view.findViewById(d.g.tip_left_count_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tieba.person.data.c) {
            this.aFh = fVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) fVar;
            aj.c(this.fhI, d.f.icon_mine_pic_add);
            if (cVar.aYh() > 0) {
                this.fhJ.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.have_left_some_picture_upload), Integer.valueOf(cVar.aYh())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.fhJ, d.C0080d.cp_cont_e, 1);
            aj.k(getView(), d.C0080d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public f wT() {
        return this.aFh;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
