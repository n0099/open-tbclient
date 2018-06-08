package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public ImageView fPw;
    public TextView fPx;
    private h fPy;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.g.add_pic_root);
        this.fPw = (ImageView) view.findViewById(d.g.add_image_view);
        this.fPx = (TextView) view.findViewById(d.g.tip_left_count_view);
    }

    public void g(h hVar) {
        if (hVar instanceof com.baidu.tieba.person.data.c) {
            this.fPy = hVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) hVar;
            al.c(this.fPw, d.f.icon_mine_pic_add);
            if (cVar.biC() > 0) {
                this.fPx.setText(String.format(TbadkCoreApplication.getInst().getString(d.k.have_left_some_picture_upload), Integer.valueOf(cVar.biC())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.fPx, d.C0141d.cp_cont_e, 1);
            al.j(getView(), d.C0141d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public h AQ() {
        return this.fPy;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
