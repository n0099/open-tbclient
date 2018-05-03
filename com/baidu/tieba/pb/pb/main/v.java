package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends q.a {
    public TextView bGo;
    public TextView dRZ;
    public HeadImageView fjI;
    public TbImageView fjJ;
    public TextView fjK;
    public int mSkinType;
    public TextView text;

    public v(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fjI = (HeadImageView) view2.findViewById(d.g.photo);
        this.fjI.setRadius(com.baidu.adp.lib.util.l.e(view2.getContext(), d.e.ds30));
        this.bGo = (TextView) view2.findViewById(d.g.user_name);
        this.dRZ = (TextView) view2.findViewById(d.g.time);
        this.text = (TextView) view2.findViewById(d.g.text);
        this.fjJ = (TbImageView) view2.findViewById(d.g.god_pic);
        this.fjK = (TextView) view2.findViewById(d.g.god_btn);
    }
}
