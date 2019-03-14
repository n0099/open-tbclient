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
    public ImageView hKO;
    public TextView hKP;
    private m hKQ;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.g.add_pic_root);
        this.hKO = (ImageView) view.findViewById(d.g.add_image_view);
        this.hKP = (TextView) view.findViewById(d.g.tip_left_count_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.hKQ = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            al.c(this.hKO, d.f.icon_mine_pic_add);
            if (cVar.bQo() > 0) {
                this.hKP.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.have_left_some_picture_upload), Integer.valueOf(cVar.bQo())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.hKP, d.C0277d.cp_cont_e, 1);
            al.l(getView(), d.C0277d.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m afj() {
        return this.hKQ;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
