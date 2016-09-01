package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cz extends y.a {
    public TextView aVl;
    public TextView cUW;
    public HeadImageView caC;
    public TextView csD;
    public TbImageView eoV;
    public TextView eoW;
    public int mSkinType;

    public cz(View view) {
        super(view);
        this.mSkinType = 3;
        this.caC = (HeadImageView) view.findViewById(t.g.photo);
        this.caC.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), t.e.ds40));
        this.aVl = (TextView) view.findViewById(t.g.user_name);
        this.cUW = (TextView) view.findViewById(t.g.time);
        this.csD = (TextView) view.findViewById(t.g.text);
        this.eoV = (TbImageView) view.findViewById(t.g.god_pic);
        this.eoW = (TextView) view.findViewById(t.g.god_btn);
    }
}
