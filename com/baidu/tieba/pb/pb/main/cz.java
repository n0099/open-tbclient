package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cz extends y.a {
    public TextView aVU;
    public TextView cWq;
    public HeadImageView caE;
    public TextView cta;
    public TbImageView eqT;
    public TextView eqU;
    public int mSkinType;

    public cz(View view) {
        super(view);
        this.mSkinType = 3;
        this.caE = (HeadImageView) view.findViewById(r.g.photo);
        this.caE.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.e.ds40));
        this.aVU = (TextView) view.findViewById(r.g.user_name);
        this.cWq = (TextView) view.findViewById(r.g.time);
        this.cta = (TextView) view.findViewById(r.g.text);
        this.eqT = (TbImageView) view.findViewById(r.g.god_pic);
        this.eqU = (TextView) view.findViewById(r.g.god_btn);
    }
}
