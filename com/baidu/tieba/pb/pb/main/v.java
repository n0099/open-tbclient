package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends q.a {
    public TextView bPN;
    public TextView eet;
    public HeadImageView fwk;
    public TbImageView fwl;
    public TextView fwm;
    public int mSkinType;
    public TextView text;

    public v(View view) {
        super(view);
        this.mSkinType = 3;
        this.fwk = (HeadImageView) view.findViewById(d.g.photo);
        this.fwk.setRadius(com.baidu.adp.lib.util.l.e(view.getContext(), d.e.ds30));
        this.bPN = (TextView) view.findViewById(d.g.user_name);
        this.eet = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fwl = (TbImageView) view.findViewById(d.g.god_pic);
        this.fwm = (TextView) view.findViewById(d.g.god_btn);
    }
}
