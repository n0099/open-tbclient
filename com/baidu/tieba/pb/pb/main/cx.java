package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cx extends y.a {
    public HeadImageView bJK;
    public TextView bbH;
    public TextView cGZ;
    public TextView cdq;
    public TbImageView ebf;
    public TextView ebg;
    public int mSkinType;

    public cx(View view) {
        super(view);
        this.mSkinType = 3;
        this.bJK = (HeadImageView) view.findViewById(r.g.photo);
        this.bJK.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.e.ds30));
        this.bbH = (TextView) view.findViewById(r.g.user_name);
        this.cGZ = (TextView) view.findViewById(r.g.time);
        this.cdq = (TextView) view.findViewById(r.g.text);
        this.ebf = (TbImageView) view.findViewById(r.g.god_pic);
        this.ebg = (TextView) view.findViewById(r.g.god_btn);
    }
}
