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
    public ImageView guE;
    public TextView guF;
    private h guG;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(e.g.add_pic_root);
        this.guE = (ImageView) view.findViewById(e.g.add_image_view);
        this.guF = (TextView) view.findViewById(e.g.tip_left_count_view);
    }

    public void g(h hVar) {
        if (hVar instanceof com.baidu.tieba.person.data.c) {
            this.guG = hVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) hVar;
            al.c(this.guE, e.f.icon_mine_pic_add);
            if (cVar.bpQ() > 0) {
                this.guF.setText(String.format(TbadkCoreApplication.getInst().getString(e.j.have_left_some_picture_upload), Integer.valueOf(cVar.bpQ())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.guF, e.d.cp_cont_e, 1);
            al.j(getView(), e.d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public h FP() {
        return this.guG;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
