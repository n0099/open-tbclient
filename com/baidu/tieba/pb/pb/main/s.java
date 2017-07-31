package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bGr;
    public TextView cFO;
    public HeadImageView csN;
    public TextView diI;
    public TbImageView eKH;
    public TextView eKI;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.csN = (HeadImageView) view.findViewById(d.h.photo);
        this.csN.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), d.f.ds30));
        this.bGr = (TextView) view.findViewById(d.h.user_name);
        this.diI = (TextView) view.findViewById(d.h.time);
        this.cFO = (TextView) view.findViewById(d.h.text);
        this.eKH = (TbImageView) view.findViewById(d.h.god_pic);
        this.eKI = (TextView) view.findViewById(d.h.god_btn);
    }
}
