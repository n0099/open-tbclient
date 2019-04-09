package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class b extends v.a {
    public ImageView hKB;
    public TextView hKC;
    private m hKD;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.g.add_pic_root);
        this.hKB = (ImageView) view.findViewById(d.g.add_image_view);
        this.hKC = (TextView) view.findViewById(d.g.tip_left_count_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.hKD = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            al.c(this.hKB, d.f.icon_mine_pic_add);
            if (cVar.bQk() > 0) {
                this.hKC.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.have_left_some_picture_upload), Integer.valueOf(cVar.bQk())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.hKC, d.C0277d.cp_cont_e, 1);
            al.l(getView(), d.C0277d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m afg() {
        return this.hKD;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
