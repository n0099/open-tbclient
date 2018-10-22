package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends q.a {
    public ImageView giw;
    public TextView gix;
    private h giy;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(e.g.add_pic_root);
        this.giw = (ImageView) view.findViewById(e.g.add_image_view);
        this.gix = (TextView) view.findViewById(e.g.tip_left_count_view);
    }

    public void g(h hVar) {
        if (hVar instanceof com.baidu.tieba.person.data.c) {
            this.giy = hVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) hVar;
            al.c(this.giw, e.f.icon_mine_pic_add);
            if (cVar.bni() > 0) {
                this.gix.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.have_left_some_picture_upload), Integer.valueOf(cVar.bni())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.gix, e.d.cp_cont_e, 1);
            al.j(getView(), e.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public h En() {
        return this.giy;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
