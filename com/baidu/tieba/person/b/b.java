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
    private q XA;
    private View.OnClickListener mClickListener;
    private int mSkinType;
    public ImageView miX;
    public TextView miY;
    public View rootView;

    public b(View view) {
        super(view);
        this.mSkinType = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.miX = (ImageView) view.findViewById(R.id.add_image_view);
        this.miY = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void h(q qVar) {
        if (qVar instanceof com.baidu.tieba.person.data.c) {
            this.XA = qVar;
            com.baidu.tieba.person.data.c cVar = (com.baidu.tieba.person.data.c) qVar;
            ap.setImageResource(this.miX, R.drawable.icon_mine_pic_add);
            if (cVar.dyh() > 0) {
                this.miY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.dyh())));
            }
            getView().setOnClickListener(this.mClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.miY, R.color.CAM_X0110, 1);
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
            this.mSkinType = i;
        }
    }

    public q qV() {
        return this.XA;
    }

    public void F(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
