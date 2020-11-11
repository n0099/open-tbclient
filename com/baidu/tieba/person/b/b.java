package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class b extends af.a {
    private q Wz;
    public ImageView lUy;
    public TextView lUz;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.lUy = (ImageView) view.findViewById(R.id.add_image_view);
        this.lUz = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(q qVar) {
        if (qVar instanceof com.baidu.tieba.person.data.c) {
            this.Wz = qVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) qVar;
            ap.setImageResource(this.lUy, R.drawable.icon_mine_pic_add);
            if (cVar.dtp() > 0) {
                this.lUz.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.dtp())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.lUz, R.color.cp_cont_e, 1);
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            this.mSkinType = i;
        }
    }

    public q qT() {
        return this.Wz;
    }

    public void G(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
