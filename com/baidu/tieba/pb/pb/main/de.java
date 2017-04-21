package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class de extends y.a {
    public HeadImageView bZq;
    public TextView bux;
    public TextView cRm;
    public TextView clZ;
    public TbImageView ent;
    public TextView enu;
    public int mSkinType;

    public de(View view) {
        super(view);
        this.mSkinType = 3;
        this.bZq = (HeadImageView) view.findViewById(w.h.photo);
        this.bZq.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.bux = (TextView) view.findViewById(w.h.user_name);
        this.cRm = (TextView) view.findViewById(w.h.time);
        this.clZ = (TextView) view.findViewById(w.h.text);
        this.ent = (TbImageView) view.findViewById(w.h.god_pic);
        this.enu = (TextView) view.findViewById(w.h.god_btn);
    }
}
