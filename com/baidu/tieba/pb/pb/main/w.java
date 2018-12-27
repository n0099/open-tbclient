package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class w extends q.a {
    public TextView clo;
    public TextView eMj;
    public HeadImageView gaI;
    public TbImageView gaJ;
    public TextView gaK;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.gaI = (HeadImageView) view.findViewById(e.g.photo);
        this.gaI.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0210e.ds30));
        this.clo = (TextView) view.findViewById(e.g.user_name);
        this.eMj = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.gaJ = (TbImageView) view.findViewById(e.g.god_pic);
        this.gaK = (TextView) view.findViewById(e.g.god_btn);
    }
}
