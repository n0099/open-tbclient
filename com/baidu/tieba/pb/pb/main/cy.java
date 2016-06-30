package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cy extends y.a {
    public TextView aOX;
    public HeadImageView bNJ;
    public TextView cGC;
    public TextView cfp;
    public TbImageView dQB;
    public TextView dQC;
    public int mSkinType;

    public cy(View view) {
        super(view);
        this.mSkinType = 3;
        this.bNJ = (HeadImageView) view.findViewById(u.g.photo);
        this.bNJ.setRadius(com.baidu.adp.lib.util.k.c(view.getContext(), u.e.ds40));
        this.aOX = (TextView) view.findViewById(u.g.user_name);
        this.cGC = (TextView) view.findViewById(u.g.time);
        this.cfp = (TextView) view.findViewById(u.g.text);
        this.dQB = (TbImageView) view.findViewById(u.g.god_pic);
        this.dQC = (TextView) view.findViewById(u.g.god_btn);
    }
}
