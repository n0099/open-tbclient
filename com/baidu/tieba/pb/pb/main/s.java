package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bFC;
    public HeadImageView cAP;
    public TextView cOU;
    public TextView dse;
    public TbImageView eLO;
    public TextView eLP;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.cAP = (HeadImageView) view.findViewById(d.h.photo);
        this.cAP.setRadius(com.baidu.adp.lib.util.k.f(view.getContext(), d.f.ds30));
        this.bFC = (TextView) view.findViewById(d.h.user_name);
        this.dse = (TextView) view.findViewById(d.h.time);
        this.cOU = (TextView) view.findViewById(d.h.text);
        this.eLO = (TbImageView) view.findViewById(d.h.god_pic);
        this.eLP = (TextView) view.findViewById(d.h.god_btn);
    }
}
