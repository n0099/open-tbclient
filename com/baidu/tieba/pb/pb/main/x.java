package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class x extends v.a {
    public TextView fqi;
    public TextView hrO;
    public HeadImageView iIk;
    public TbImageView iIl;
    public TextView iIm;
    public int mSkinType;
    public TextView text;

    public x(View view) {
        super(view);
        this.mSkinType = 3;
        this.iIk = (HeadImageView) view.findViewById(R.id.photo);
        this.iIk.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds30));
        this.fqi = (TextView) view.findViewById(R.id.user_name);
        this.hrO = (TextView) view.findViewById(R.id.time);
        this.text = (TextView) view.findViewById(R.id.text);
        this.iIl = (TbImageView) view.findViewById(R.id.god_pic);
        this.iIm = (TextView) view.findViewById(R.id.god_btn);
    }
}
