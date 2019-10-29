package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView YM;
    public TextView ewr;
    public TextView gAW;
    public HeadImageView hQP;
    public TbImageView hQQ;
    public TextView hQR;
    public int mSkinType;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hQP = (HeadImageView) view.findViewById(R.id.photo);
        this.hQP.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds30));
        this.ewr = (TextView) view.findViewById(R.id.user_name);
        this.gAW = (TextView) view.findViewById(R.id.time);
        this.YM = (TextView) view.findViewById(R.id.text);
        this.hQQ = (TbImageView) view.findViewById(R.id.god_pic);
        this.hQR = (TextView) view.findViewById(R.id.god_btn);
    }
}
