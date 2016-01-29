package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.person.god.view.PersonInfoBaseGodView;
import com.baidu.tieba.person.god.view.PersonInfoGodEnterView;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends x.a {
    public int ahU;
    public PersonInfoBaseGodView ddI;
    public PersonInfoGodEnterView ddJ;
    public LinearLayout ddK;
    public PersonInfoEnterItemView ddL;
    public PersonInfoEnterItemView ddM;
    public PersonInfoEnterItemView ddN;
    public PersonInfoEnterItemView ddO;
    public PersonInfoEnterItemView ddP;
    public PersonInfoEnterItemView ddQ;

    public d(View view) {
        super(view);
        this.ahU = 3;
        this.ddK = (LinearLayout) view.findViewById(t.g.normal_root_layout);
        this.ddL = (PersonInfoEnterItemView) view.findViewById(t.g.enter_histroy);
        this.ddM = (PersonInfoEnterItemView) view.findViewById(t.g.enter_collect);
        this.ddN = (PersonInfoEnterItemView) view.findViewById(t.g.enter_attention);
        this.ddO = (PersonInfoEnterItemView) view.findViewById(t.g.enter_fans);
        this.ddP = (PersonInfoEnterItemView) view.findViewById(t.g.enter_friends);
        this.ddQ = (PersonInfoEnterItemView) view.findViewById(t.g.enter_feeds);
        this.ddI = (PersonInfoBaseGodView) view.findViewById(t.g.base_god_info);
        this.ddJ = (PersonInfoGodEnterView) view.findViewById(t.g.menbership_view);
    }
}
