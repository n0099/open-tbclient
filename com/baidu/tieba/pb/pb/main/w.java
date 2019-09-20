package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView evT;
    public TextView gCX;
    public HeadImageView hSk;
    public TbImageView hSl;
    public TextView hSm;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hSk = (HeadImageView) view.findViewById(R.id.photo);
        this.hSk.setRadius(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds30));
        this.evT = (TextView) view.findViewById(R.id.user_name);
        this.gCX = (TextView) view.findViewById(R.id.time);
        this.text = (TextView) view.findViewById(R.id.text);
        this.hSl = (TbImageView) view.findViewById(R.id.god_pic);
        this.hSm = (TextView) view.findViewById(R.id.god_btn);
    }
}
