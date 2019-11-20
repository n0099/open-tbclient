package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView Yu;
    public TextView evA;
    public TextView gAf;
    public HeadImageView hPY;
    public TbImageView hPZ;
    public TextView hQa;
    public int mSkinType;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hPY = (HeadImageView) view.findViewById(R.id.photo);
        this.hPY.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.ds30));
        this.evA = (TextView) view.findViewById(R.id.user_name);
        this.gAf = (TextView) view.findViewById(R.id.time);
        this.Yu = (TextView) view.findViewById(R.id.text);
        this.hPZ = (TbImageView) view.findViewById(R.id.god_pic);
        this.hQa = (TextView) view.findViewById(R.id.god_btn);
    }
}
