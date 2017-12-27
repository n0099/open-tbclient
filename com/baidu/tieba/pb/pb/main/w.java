package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class w extends r.a {
    public TextView cLm;
    public TextView erp;
    public HeadImageView fKD;
    public TbImageView fKE;
    public TextView fKF;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fKD = (HeadImageView) view.findViewById(d.g.photo);
        this.fKD.setRadius(com.baidu.adp.lib.util.l.s(view.getContext(), d.e.ds30));
        this.cLm = (TextView) view.findViewById(d.g.user_name);
        this.erp = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fKE = (TbImageView) view.findViewById(d.g.god_pic);
        this.fKF = (TextView) view.findViewById(d.g.god_btn);
    }
}
