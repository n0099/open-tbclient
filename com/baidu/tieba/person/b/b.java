package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends v.a {
    public ImageView icE;
    public TextView icF;
    private m icG;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.icE = (ImageView) view.findViewById(R.id.add_image_view);
        this.icF = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.icG = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            al.c(this.icE, (int) R.drawable.icon_mine_pic_add);
            if (cVar.bYh() > 0) {
                this.icF.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.bYh())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.f(this.icF, R.color.cp_cont_e, 1);
            al.l(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m akf() {
        return this.icG;
    }

    public void z(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
