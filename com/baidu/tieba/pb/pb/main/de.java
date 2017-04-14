package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class de extends y.a {
    public HeadImageView bWZ;
    public TextView bsf;
    public TextView cOV;
    public TextView cjI;
    public TbImageView elb;
    public TextView elc;
    public int mSkinType;

    public de(View view) {
        super(view);
        this.mSkinType = 3;
        this.bWZ = (HeadImageView) view.findViewById(w.h.photo);
        this.bWZ.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.bsf = (TextView) view.findViewById(w.h.user_name);
        this.cOV = (TextView) view.findViewById(w.h.time);
        this.cjI = (TextView) view.findViewById(w.h.text);
        this.elb = (TbImageView) view.findViewById(w.h.god_pic);
        this.elc = (TextView) view.findViewById(w.h.god_btn);
    }
}
