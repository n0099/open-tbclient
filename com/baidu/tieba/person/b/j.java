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
public class j extends x.a {
    public View cOr;
    public ImageView cPJ;
    public ImageView cPK;
    public RelativeLayout cPL;
    public HeadImageView cPM;
    public TextView cPN;
    public TextView cPO;
    public LinearLayout cPP;
    public RelativeLayout cPQ;
    public HeadImageView cPR;
    public TextView cPS;
    public TextView cPT;
    public RelativeLayout cPU;
    public HeadImageView cPV;
    public TextView cPW;
    public TextView cPX;
    public RelativeLayout cPY;
    public TextView cPZ;
    public TextView cQa;
    public TextView cQb;
    public int mSkinType;

    public j(View view) {
        super(view);
        this.mSkinType = 3;
        this.cOr = null;
        this.cPJ = null;
        this.cPK = null;
        this.cPL = null;
        this.cPM = null;
        this.cPN = null;
        this.cPO = null;
        this.cPP = null;
        this.cPQ = null;
        this.cPR = null;
        this.cPS = null;
        this.cPT = null;
        this.cPU = null;
        this.cPV = null;
        this.cPW = null;
        this.cPX = null;
        this.cPY = null;
        this.cPZ = null;
        this.cQa = null;
        this.cQb = null;
        this.cOr = view.findViewById(n.f.top_divider);
        this.cPJ = (ImageView) view.findViewById(n.f.user_god_head_image);
        this.cPK = (ImageView) view.findViewById(n.f.user_god_explain_icon);
        this.cPL = (RelativeLayout) view.findViewById(n.f.user_god_single_item);
        this.cPM = (HeadImageView) this.cPL.findViewById(n.f.user_god_single_item_forum_avatar);
        this.cPN = (TextView) this.cPL.findViewById(n.f.user_god_single_item_forum_name);
        this.cPO = (TextView) this.cPL.findViewById(n.f.user_god_single_item_tag);
        this.cPP = (LinearLayout) view.findViewById(n.f.user_god_multi_item);
        this.cPY = (RelativeLayout) view.findViewById(n.f.user_god_star_item);
        this.cPZ = (TextView) this.cPY.findViewById(n.f.user_god_star_item_tag);
        this.cQa = (TextView) this.cPY.findViewById(n.f.user_god_star_item_content);
        this.cQb = (TextView) this.cPY.findViewById(n.f.user_god_star_item_title);
    }
}
