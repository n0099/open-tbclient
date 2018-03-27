package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends r.a {
    public TextView cql;
    public TextView exx;
    public HeadImageView fPM;
    public TbImageView fPN;
    public TextView fPO;
    public int mSkinType;
    public TextView text;

    public v(View view) {
        super(view);
        this.mSkinType = 3;
        this.fPM = (HeadImageView) view.findViewById(d.g.photo);
        this.fPM.setRadius(com.baidu.adp.lib.util.l.t(view.getContext(), d.e.ds30));
        this.cql = (TextView) view.findViewById(d.g.user_name);
        this.exx = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fPN = (TbImageView) view.findViewById(d.g.god_pic);
        this.fPO = (TextView) view.findViewById(d.g.god_btn);
    }
}
