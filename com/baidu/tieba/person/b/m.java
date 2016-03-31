package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m extends x.a {
    public TextView dAA;
    public TextView dAB;
    public ImageView dAr;
    public ImageView dAs;
    public RelativeLayout dAt;
    public HeadImageView dAu;
    public TextView dAv;
    public TextView dAw;
    public LinearLayout dAx;
    public RelativeLayout dAy;
    public TextView dAz;
    public View dyN;
    public int mSkinType;

    public m(View view) {
        super(view);
        this.mSkinType = 3;
        this.dyN = null;
        this.dAr = null;
        this.dAs = null;
        this.dAt = null;
        this.dAu = null;
        this.dAv = null;
        this.dAw = null;
        this.dAx = null;
        this.dAy = null;
        this.dAz = null;
        this.dAA = null;
        this.dAB = null;
        this.dyN = view.findViewById(t.g.top_divider);
        this.dAr = (ImageView) view.findViewById(t.g.user_god_head_image);
        this.dAs = (ImageView) view.findViewById(t.g.user_god_explain_icon);
        this.dAt = (RelativeLayout) view.findViewById(t.g.user_god_single_item);
        this.dAu = (HeadImageView) this.dAt.findViewById(t.g.user_god_single_item_forum_avatar);
        this.dAv = (TextView) this.dAt.findViewById(t.g.user_god_single_item_forum_name);
        this.dAw = (TextView) this.dAt.findViewById(t.g.user_god_single_item_tag);
        this.dAx = (LinearLayout) view.findViewById(t.g.user_god_multi_item);
        this.dAy = (RelativeLayout) view.findViewById(t.g.user_god_star_item);
        this.dAz = (TextView) this.dAy.findViewById(t.g.user_god_star_item_tag);
        this.dAA = (TextView) this.dAy.findViewById(t.g.user_god_star_item_content);
        this.dAB = (TextView) this.dAy.findViewById(t.g.user_god_star_item_title);
    }
}
