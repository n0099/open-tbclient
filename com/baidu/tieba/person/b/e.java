package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.person.god.view.PersonInfoBaseGodView;
import com.baidu.tieba.person.god.view.PersonInfoGodEnterView;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends y.a {
    public int aeK;
    public PersonInfoBaseGodView ejU;
    public PersonInfoGodEnterView ejV;
    public LinearLayout ejW;
    public PersonInfoEnterItemView ejX;
    public PersonInfoEnterItemView ejY;
    public PersonInfoEnterItemView ejZ;
    public PersonInfoEnterItemView eka;
    public PersonInfoEnterItemView ekb;
    public PersonInfoEnterItemView ekc;

    public e(View view) {
        super(view);
        this.aeK = 3;
        this.ejW = (LinearLayout) view.findViewById(u.g.normal_root_layout);
        this.ejX = (PersonInfoEnterItemView) view.findViewById(u.g.enter_histroy);
        this.ejY = (PersonInfoEnterItemView) view.findViewById(u.g.enter_collect);
        this.ejZ = (PersonInfoEnterItemView) view.findViewById(u.g.enter_attention);
        this.eka = (PersonInfoEnterItemView) view.findViewById(u.g.enter_fans);
        this.ekb = (PersonInfoEnterItemView) view.findViewById(u.g.enter_friends);
        this.ekc = (PersonInfoEnterItemView) view.findViewById(u.g.enter_feeds);
        this.ejU = (PersonInfoBaseGodView) view.findViewById(u.g.base_god_info);
        this.ejV = (PersonInfoGodEnterView) view.findViewById(u.g.menbership_view);
    }
}
