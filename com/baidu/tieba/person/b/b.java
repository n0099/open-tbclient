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
    private f aEy;
    private View.OnClickListener aOR;
    public ImageView eZt;
    public TextView eZu;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.h.add_pic_root);
        this.eZt = (ImageView) view.findViewById(d.h.add_image_view);
        this.eZu = (TextView) view.findViewById(d.h.tip_left_count_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tieba.person.data.c) {
            this.aEy = fVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) fVar;
            aj.c(this.eZt, d.g.icon_mine_pic_add);
            if (cVar.aVe() > 0) {
                this.eZu.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.have_left_some_picture_upload), Integer.valueOf(cVar.aVe())));
            }
            getView().setOnClickListener(this.aOR);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.eZu, d.e.cp_cont_e, 1);
            aj.k(getView(), d.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public f wM() {
        return this.aEy;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aOR = onClickListener;
    }
}
