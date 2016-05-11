package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends y.a {
    public View dBV;
    public ImageView dDA;
    public RelativeLayout dDB;
    public HeadImageView dDC;
    public TextView dDD;
    public TextView dDE;
    public LinearLayout dDF;
    public RelativeLayout dDG;
    public TextView dDH;
    public TextView dDI;
    public TextView dDJ;
    public ImageView dDz;
    public int mSkinType;

    public o(View view) {
        super(view);
        this.mSkinType = 3;
        this.dBV = null;
        this.dDz = null;
        this.dDA = null;
        this.dDB = null;
        this.dDC = null;
        this.dDD = null;
        this.dDE = null;
        this.dDF = null;
        this.dDG = null;
        this.dDH = null;
        this.dDI = null;
        this.dDJ = null;
        this.dBV = view.findViewById(t.g.top_divider);
        this.dDz = (ImageView) view.findViewById(t.g.user_god_head_image);
        this.dDA = (ImageView) view.findViewById(t.g.user_god_explain_icon);
        this.dDB = (RelativeLayout) view.findViewById(t.g.user_god_single_item);
        this.dDC = (HeadImageView) this.dDB.findViewById(t.g.user_god_single_item_forum_avatar);
        this.dDD = (TextView) this.dDB.findViewById(t.g.user_god_single_item_forum_name);
        this.dDE = (TextView) this.dDB.findViewById(t.g.user_god_single_item_tag);
        this.dDF = (LinearLayout) view.findViewById(t.g.user_god_multi_item);
        this.dDG = (RelativeLayout) view.findViewById(t.g.user_god_star_item);
        this.dDH = (TextView) this.dDG.findViewById(t.g.user_god_star_item_tag);
        this.dDI = (TextView) this.dDG.findViewById(t.g.user_god_star_item_content);
        this.dDJ = (TextView) this.dDG.findViewById(t.g.user_god_star_item_title);
    }
}
