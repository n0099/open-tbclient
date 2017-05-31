package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class eb extends z.a {
    public TextView bAh;
    public TextView cQM;
    public HeadImageView cdp;
    public TextView cpu;
    public TbImageView epb;
    public TextView epc;
    public int mSkinType;

    public eb(View view) {
        super(view);
        this.mSkinType = 3;
        this.cdp = (HeadImageView) view.findViewById(w.h.photo);
        this.cdp.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.bAh = (TextView) view.findViewById(w.h.user_name);
        this.cQM = (TextView) view.findViewById(w.h.time);
        this.cpu = (TextView) view.findViewById(w.h.text);
        this.epb = (TbImageView) view.findViewById(w.h.god_pic);
        this.epc = (TextView) view.findViewById(w.h.god_btn);
    }
}
