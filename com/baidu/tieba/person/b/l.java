package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l extends x.a {
    public View cTb;
    public RelativeLayout cUA;
    public TextView cUB;
    public TextView cUC;
    public TextView cUD;
    public ImageView cUt;
    public ImageView cUu;
    public RelativeLayout cUv;
    public HeadImageView cUw;
    public TextView cUx;
    public TextView cUy;
    public LinearLayout cUz;
    public int mSkinType;

    public l(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTb = null;
        this.cUt = null;
        this.cUu = null;
        this.cUv = null;
        this.cUw = null;
        this.cUx = null;
        this.cUy = null;
        this.cUz = null;
        this.cUA = null;
        this.cUB = null;
        this.cUC = null;
        this.cUD = null;
        this.cTb = view.findViewById(n.g.top_divider);
        this.cUt = (ImageView) view.findViewById(n.g.user_god_head_image);
        this.cUu = (ImageView) view.findViewById(n.g.user_god_explain_icon);
        this.cUv = (RelativeLayout) view.findViewById(n.g.user_god_single_item);
        this.cUw = (HeadImageView) this.cUv.findViewById(n.g.user_god_single_item_forum_avatar);
        this.cUx = (TextView) this.cUv.findViewById(n.g.user_god_single_item_forum_name);
        this.cUy = (TextView) this.cUv.findViewById(n.g.user_god_single_item_tag);
        this.cUz = (LinearLayout) view.findViewById(n.g.user_god_multi_item);
        this.cUA = (RelativeLayout) view.findViewById(n.g.user_god_star_item);
        this.cUB = (TextView) this.cUA.findViewById(n.g.user_god_star_item_tag);
        this.cUC = (TextView) this.cUA.findViewById(n.g.user_god_star_item_content);
        this.cUD = (TextView) this.cUA.findViewById(n.g.user_god_star_item_title);
    }
}
