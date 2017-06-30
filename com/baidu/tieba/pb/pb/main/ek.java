package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ek extends z.a {
    public TextView bBa;
    public TextView cYI;
    public HeadImageView clB;
    public TextView cxj;
    public TbImageView eyk;
    public TextView eyl;
    public int mSkinType;

    public ek(View view) {
        super(view);
        this.mSkinType = 3;
        this.clB = (HeadImageView) view.findViewById(w.h.photo);
        this.clB.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.bBa = (TextView) view.findViewById(w.h.user_name);
        this.cYI = (TextView) view.findViewById(w.h.time);
        this.cxj = (TextView) view.findViewById(w.h.text);
        this.eyk = (TbImageView) view.findViewById(w.h.god_pic);
        this.eyl = (TextView) view.findViewById(w.h.god_btn);
    }
}
