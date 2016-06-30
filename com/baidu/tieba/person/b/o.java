package com.baidu.tieba.person.b;

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
    public View eky;
    public ImageView eml;
    public ImageView emm;
    public RelativeLayout emn;
    public HeadImageView emo;
    public TextView emp;
    public TextView emq;
    public LinearLayout emr;
    public RelativeLayout ems;
    public TextView emt;
    public TextView emu;
    public TextView emv;
    public int mSkinType;

    public o(View view) {
        super(view);
        this.mSkinType = 3;
        this.eky = null;
        this.eml = null;
        this.emm = null;
        this.emn = null;
        this.emo = null;
        this.emp = null;
        this.emq = null;
        this.emr = null;
        this.ems = null;
        this.emt = null;
        this.emu = null;
        this.emv = null;
        this.eky = view.findViewById(u.g.top_divider);
        this.eml = (ImageView) view.findViewById(u.g.user_god_head_image);
        this.emm = (ImageView) view.findViewById(u.g.user_god_explain_icon);
        this.emn = (RelativeLayout) view.findViewById(u.g.user_god_single_item);
        this.emo = (HeadImageView) this.emn.findViewById(u.g.user_god_single_item_forum_avatar);
        this.emp = (TextView) this.emn.findViewById(u.g.user_god_single_item_forum_name);
        this.emq = (TextView) this.emn.findViewById(u.g.user_god_single_item_tag);
        this.emr = (LinearLayout) view.findViewById(u.g.user_god_multi_item);
        this.ems = (RelativeLayout) view.findViewById(u.g.user_god_star_item);
        this.emt = (TextView) this.ems.findViewById(u.g.user_god_star_item_tag);
        this.emu = (TextView) this.ems.findViewById(u.g.user_god_star_item_content);
        this.emv = (TextView) this.ems.findViewById(u.g.user_god_star_item_title);
    }
}
