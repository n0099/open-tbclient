package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView euj;
    public TextView gBg;
    public HeadImageView hQn;
    public TbImageView hQo;
    public TextView hQp;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hQn = (HeadImageView) view.findViewById(R.id.photo);
        this.hQn.setRadius(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds30));
        this.euj = (TextView) view.findViewById(R.id.user_name);
        this.gBg = (TextView) view.findViewById(R.id.time);
        this.text = (TextView) view.findViewById(R.id.text);
        this.hQo = (TbImageView) view.findViewById(R.id.god_pic);
        this.hQp = (TextView) view.findViewById(R.id.god_btn);
    }
}
