package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView epe;
    public TextView gub;
    public HeadImageView hJe;
    public TbImageView hJf;
    public TextView hJg;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hJe = (HeadImageView) view.findViewById(R.id.photo);
        this.hJe.setRadius(com.baidu.adp.lib.util.l.g(view.getContext(), R.dimen.ds30));
        this.epe = (TextView) view.findViewById(R.id.user_name);
        this.gub = (TextView) view.findViewById(R.id.time);
        this.text = (TextView) view.findViewById(R.id.text);
        this.hJf = (TbImageView) view.findViewById(R.id.god_pic);
        this.hJg = (TextView) view.findViewById(R.id.god_btn);
    }
}
