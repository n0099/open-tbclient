package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bHa;
    public TextView cHL;
    public HeadImageView ctu;
    public TextView dkF;
    public TbImageView eMB;
    public TextView eMC;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.ctu = (HeadImageView) view.findViewById(d.h.photo);
        this.ctu.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), d.f.ds30));
        this.bHa = (TextView) view.findViewById(d.h.user_name);
        this.dkF = (TextView) view.findViewById(d.h.time);
        this.cHL = (TextView) view.findViewById(d.h.text);
        this.eMB = (TbImageView) view.findViewById(d.h.god_pic);
        this.eMC = (TextView) view.findViewById(d.h.god_btn);
    }
}
