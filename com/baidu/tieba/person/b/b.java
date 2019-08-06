package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends v.a {
    public ImageView ijY;
    public TextView ijZ;
    private m ika;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.ijY = (ImageView) view.findViewById(R.id.add_image_view);
        this.ijZ = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void i(m mVar) {
        if (mVar instanceof com.baidu.tieba.person.data.c) {
            this.ika = mVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) mVar;
            am.c(this.ijY, (int) R.drawable.icon_mine_pic_add);
            if (cVar.cbo() > 0) {
                this.ijZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.cbo())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.f(this.ijZ, R.color.cp_cont_e, 1);
            am.l(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public m alm() {
        return this.ika;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
