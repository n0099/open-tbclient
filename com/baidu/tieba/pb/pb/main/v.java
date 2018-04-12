package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends q.a {
    public TextView bGp;
    public TextView dSc;
    public HeadImageView fjL;
    public TbImageView fjM;
    public TextView fjN;
    public int mSkinType;
    public TextView text;

    public v(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fjL = (HeadImageView) view2.findViewById(d.g.photo);
        this.fjL.setRadius(com.baidu.adp.lib.util.l.e(view2.getContext(), d.e.ds30));
        this.bGp = (TextView) view2.findViewById(d.g.user_name);
        this.dSc = (TextView) view2.findViewById(d.g.time);
        this.text = (TextView) view2.findViewById(d.g.text);
        this.fjM = (TbImageView) view2.findViewById(d.g.god_pic);
        this.fjN = (TextView) view2.findViewById(d.g.god_btn);
    }
}
