package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bFh;
    public TextView cEt;
    public HeadImageView crC;
    public TextView dhq;
    public TbImageView eJu;
    public TextView eJv;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.crC = (HeadImageView) view.findViewById(d.h.photo);
        this.crC.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), d.f.ds30));
        this.bFh = (TextView) view.findViewById(d.h.user_name);
        this.dhq = (TextView) view.findViewById(d.h.time);
        this.cEt = (TextView) view.findViewById(d.h.text);
        this.eJu = (TbImageView) view.findViewById(d.h.god_pic);
        this.eJv = (TextView) view.findViewById(d.h.god_btn);
    }
}
