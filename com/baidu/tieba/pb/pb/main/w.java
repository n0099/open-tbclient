package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class w extends r.a {
    public TextView cQi;
    public TextView etj;
    public TextView fMA;
    public HeadImageView fMy;
    public TbImageView fMz;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fMy = (HeadImageView) view.findViewById(d.g.photo);
        this.fMy.setRadius(com.baidu.adp.lib.util.l.s(view.getContext(), d.e.ds30));
        this.cQi = (TextView) view.findViewById(d.g.user_name);
        this.etj = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fMz = (TbImageView) view.findViewById(d.g.god_pic);
        this.fMA = (TextView) view.findViewById(d.g.god_btn);
    }
}
