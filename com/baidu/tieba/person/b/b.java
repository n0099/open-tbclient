package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public ImageView fCW;
    public TextView fCX;
    private h fCY;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.rootView = view2.findViewById(d.g.add_pic_root);
        this.fCW = (ImageView) view2.findViewById(d.g.add_image_view);
        this.fCX = (TextView) view2.findViewById(d.g.tip_left_count_view);
    }

    public void g(h hVar) {
        if (hVar instanceof com.baidu.tieba.person.data.c) {
            this.fCY = hVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) hVar;
            ak.c(this.fCW, d.f.icon_mine_pic_add);
            if (cVar.bdC() > 0) {
                this.fCX.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.have_left_some_picture_upload), Integer.valueOf(cVar.bdC())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.fCX, d.C0126d.cp_cont_e, 1);
            ak.j(getView(), d.C0126d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public h xq() {
        return this.fCY;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
