package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class o extends y.a {
    public View euV;
    public ImageView ewK;
    public ImageView ewL;
    public RelativeLayout ewM;
    public HeadImageView ewN;
    public TextView ewO;
    public TextView ewP;
    public LinearLayout ewQ;
    public RelativeLayout ewR;
    public TextView ewS;
    public TextView ewT;
    public TextView ewU;
    public int mSkinType;

    public o(View view) {
        super(view);
        this.mSkinType = 3;
        this.euV = null;
        this.ewK = null;
        this.ewL = null;
        this.ewM = null;
        this.ewN = null;
        this.ewO = null;
        this.ewP = null;
        this.ewQ = null;
        this.ewR = null;
        this.ewS = null;
        this.ewT = null;
        this.ewU = null;
        this.euV = view.findViewById(u.g.top_divider);
        this.ewK = (ImageView) view.findViewById(u.g.user_god_head_image);
        this.ewL = (ImageView) view.findViewById(u.g.user_god_explain_icon);
        this.ewM = (RelativeLayout) view.findViewById(u.g.user_god_single_item);
        this.ewN = (HeadImageView) this.ewM.findViewById(u.g.user_god_single_item_forum_avatar);
        this.ewO = (TextView) this.ewM.findViewById(u.g.user_god_single_item_forum_name);
        this.ewP = (TextView) this.ewM.findViewById(u.g.user_god_single_item_tag);
        this.ewQ = (LinearLayout) view.findViewById(u.g.user_god_multi_item);
        this.ewR = (RelativeLayout) view.findViewById(u.g.user_god_star_item);
        this.ewS = (TextView) this.ewR.findViewById(u.g.user_god_star_item_tag);
        this.ewT = (TextView) this.ewR.findViewById(u.g.user_god_star_item_content);
        this.ewU = (TextView) this.ewR.findViewById(u.g.user_god_star_item_title);
    }
}
