package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends r.a {
    public TextView cqu;
    public TextView exs;
    public HeadImageView fPH;
    public TbImageView fPI;
    public TextView fPJ;
    public int mSkinType;
    public TextView text;

    public v(View view) {
        super(view);
        this.mSkinType = 3;
        this.fPH = (HeadImageView) view.findViewById(d.g.photo);
        this.fPH.setRadius(com.baidu.adp.lib.util.l.t(view.getContext(), d.e.ds30));
        this.cqu = (TextView) view.findViewById(d.g.user_name);
        this.exs = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fPI = (TbImageView) view.findViewById(d.g.god_pic);
        this.fPJ = (TextView) view.findViewById(d.g.god_btn);
    }
}
