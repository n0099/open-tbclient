package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends q.a {
    public ImageView fTL;
    public TextView fTM;
    private h fTN;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.g.add_pic_root);
        this.fTL = (ImageView) view.findViewById(d.g.add_image_view);
        this.fTM = (TextView) view.findViewById(d.g.tip_left_count_view);
    }

    public void g(h hVar) {
        if (hVar instanceof com.baidu.tieba.person.data.c) {
            this.fTN = hVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) hVar;
            am.c(this.fTL, d.f.icon_mine_pic_add);
            if (cVar.bhB() > 0) {
                this.fTM.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.have_left_some_picture_upload), Integer.valueOf(cVar.bhB())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.fTM, d.C0140d.cp_cont_e, 1);
            am.j(getView(), d.C0140d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public h AZ() {
        return this.fTN;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
