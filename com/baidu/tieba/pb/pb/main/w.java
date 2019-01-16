package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class w extends q.a {
    public TextView clZ;
    public TextView eMV;
    public HeadImageView gbF;
    public TbImageView gbG;
    public TextView gbH;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.gbF = (HeadImageView) view.findViewById(e.g.photo);
        this.gbF.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0210e.ds30));
        this.clZ = (TextView) view.findViewById(e.g.user_name);
        this.eMV = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.gbG = (TbImageView) view.findViewById(e.g.god_pic);
        this.gbH = (TextView) view.findViewById(e.g.god_btn);
    }
}
