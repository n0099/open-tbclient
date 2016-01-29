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
    public View deo;
    public ImageView dfS;
    public ImageView dfT;
    public RelativeLayout dfU;
    public HeadImageView dfV;
    public TextView dfW;
    public TextView dfX;
    public LinearLayout dfY;
    public RelativeLayout dfZ;
    public TextView dga;
    public TextView dgb;
    public TextView dgc;
    public int mSkinType;

    public m(View view) {
        super(view);
        this.mSkinType = 3;
        this.deo = null;
        this.dfS = null;
        this.dfT = null;
        this.dfU = null;
        this.dfV = null;
        this.dfW = null;
        this.dfX = null;
        this.dfY = null;
        this.dfZ = null;
        this.dga = null;
        this.dgb = null;
        this.dgc = null;
        this.deo = view.findViewById(t.g.top_divider);
        this.dfS = (ImageView) view.findViewById(t.g.user_god_head_image);
        this.dfT = (ImageView) view.findViewById(t.g.user_god_explain_icon);
        this.dfU = (RelativeLayout) view.findViewById(t.g.user_god_single_item);
        this.dfV = (HeadImageView) this.dfU.findViewById(t.g.user_god_single_item_forum_avatar);
        this.dfW = (TextView) this.dfU.findViewById(t.g.user_god_single_item_forum_name);
        this.dfX = (TextView) this.dfU.findViewById(t.g.user_god_single_item_tag);
        this.dfY = (LinearLayout) view.findViewById(t.g.user_god_multi_item);
        this.dfZ = (RelativeLayout) view.findViewById(t.g.user_god_star_item);
        this.dga = (TextView) this.dfZ.findViewById(t.g.user_god_star_item_tag);
        this.dgb = (TextView) this.dfZ.findViewById(t.g.user_god_star_item_content);
        this.dgc = (TextView) this.dfZ.findViewById(t.g.user_god_star_item_title);
    }
}
