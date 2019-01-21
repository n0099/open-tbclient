package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class w extends q.a {
    public TextView cma;
    public TextView eMW;
    public HeadImageView gbG;
    public TbImageView gbH;
    public TextView gbI;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.gbG = (HeadImageView) view.findViewById(e.g.photo);
        this.gbG.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0210e.ds30));
        this.cma = (TextView) view.findViewById(e.g.user_name);
        this.eMW = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.gbH = (TbImageView) view.findViewById(e.g.god_pic);
        this.gbI = (TextView) view.findViewById(e.g.god_btn);
    }
}
