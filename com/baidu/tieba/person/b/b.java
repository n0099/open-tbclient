package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends q.a {
    public ImageView fTD;
    public TextView fTE;
    private h fTF;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(f.g.add_pic_root);
        this.fTD = (ImageView) view.findViewById(f.g.add_image_view);
        this.fTE = (TextView) view.findViewById(f.g.tip_left_count_view);
    }

    public void g(h hVar) {
        if (hVar instanceof com.baidu.tieba.person.data.c) {
            this.fTF = hVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) hVar;
            am.c(this.fTD, f.C0146f.icon_mine_pic_add);
            if (cVar.bhw() > 0) {
                this.fTE.setText(String.format(TbadkCoreApplication.getInst().getString(f.j.have_left_some_picture_upload), Integer.valueOf(cVar.bhw())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fTE, f.d.cp_cont_e, 1);
            am.j(getView(), f.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public h AW() {
        return this.fTF;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
