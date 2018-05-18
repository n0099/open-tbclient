package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class v extends q.a {
    public TextView bHL;
    public TextView dTg;
    public HeadImageView fkP;
    public TbImageView fkQ;
    public TextView fkR;
    public int mSkinType;
    public TextView text;

    public v(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fkP = (HeadImageView) view2.findViewById(d.g.photo);
        this.fkP.setRadius(com.baidu.adp.lib.util.l.e(view2.getContext(), d.e.ds30));
        this.bHL = (TextView) view2.findViewById(d.g.user_name);
        this.dTg = (TextView) view2.findViewById(d.g.time);
        this.text = (TextView) view2.findViewById(d.g.text);
        this.fkQ = (TbImageView) view2.findViewById(d.g.god_pic);
        this.fkR = (TextView) view2.findViewById(d.g.god_btn);
    }
}
