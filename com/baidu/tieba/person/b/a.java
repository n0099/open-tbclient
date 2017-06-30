package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends z.a {
    private View.OnClickListener bkk;
    public ImageView eQM;
    public TextView eQN;
    private v eQO;
    private int mSkinType;
    public View rootView;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(w.h.add_pic_root);
        this.eQM = (ImageView) view.findViewById(w.h.add_image_view);
        this.eQN = (TextView) view.findViewById(w.h.tip_left_count_view);
    }

    public void f(v vVar) {
        if (vVar instanceof com.baidu.tieba.person.data.a) {
            this.eQO = vVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) vVar;
            as.c(this.eQM, w.g.icon_mine_pic_add);
            if (aVar.aTV() > 0) {
                this.eQN.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.have_left_some_picture_upload), Integer.valueOf(aVar.aTV())));
            }
            getView().setOnClickListener(this.bkk);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            as.c(this.eQN, w.e.cp_cont_e, 1);
            as.k(getView(), w.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public v wZ() {
        return this.eQO;
    }

    public void v(View.OnClickListener onClickListener) {
        this.bkk = onClickListener;
    }
}
