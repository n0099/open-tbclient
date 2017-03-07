package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dg extends y.a {
    public HeadImageView bXk;
    public TextView bsn;
    public TextView cQy;
    public TextView cli;
    public TbImageView emT;
    public TextView emU;
    public int mSkinType;

    public dg(View view) {
        super(view);
        this.mSkinType = 3;
        this.bXk = (HeadImageView) view.findViewById(w.h.photo);
        this.bXk.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.bsn = (TextView) view.findViewById(w.h.user_name);
        this.cQy = (TextView) view.findViewById(w.h.time);
        this.cli = (TextView) view.findViewById(w.h.text);
        this.emT = (TbImageView) view.findViewById(w.h.god_pic);
        this.emU = (TextView) view.findViewById(w.h.god_btn);
    }
}
