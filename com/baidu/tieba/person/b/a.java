package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends j.a {
    private f aEK;
    private View.OnClickListener aXL;
    public ImageView fdm;
    public TextView fdn;
    private int mSkinType;
    public View rootView;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(d.h.add_pic_root);
        this.fdm = (ImageView) view.findViewById(d.h.add_image_view);
        this.fdn = (TextView) view.findViewById(d.h.tip_left_count_view);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tieba.person.data.a) {
            this.aEK = fVar;
            com.baidu.tieba.person.data.a aVar = (com.baidu.tieba.person.data.a) fVar;
            ai.c(this.fdm, d.g.icon_mine_pic_add);
            if (aVar.aWS() > 0) {
                this.fdn.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.have_left_some_picture_upload), Integer.valueOf(aVar.aWS())));
            }
            getView().setOnClickListener(this.aXL);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.c(this.fdn, d.e.cp_cont_e, 1);
            ai.k(getView(), d.e.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public f xk() {
        return this.aEK;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aXL = onClickListener;
    }
}
