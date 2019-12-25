package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class x extends v.a {
    public TextView fmZ;
    public TextView hol;
    public HeadImageView iEG;
    public TbImageView iEH;
    public TextView iEI;
    public int mSkinType;
    public TextView text;

    public x(View view) {
        super(view);
        this.mSkinType = 3;
        this.iEG = (HeadImageView) view.findViewById(R.id.photo);
        this.iEG.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds30));
        this.fmZ = (TextView) view.findViewById(R.id.user_name);
        this.hol = (TextView) view.findViewById(R.id.time);
        this.text = (TextView) view.findViewById(R.id.text);
        this.iEH = (TbImageView) view.findViewById(R.id.god_pic);
        this.iEI = (TextView) view.findViewById(R.id.god_btn);
    }
}
