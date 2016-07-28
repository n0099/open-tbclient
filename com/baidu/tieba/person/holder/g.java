package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.person.god.view.PersonInfoBaseGodView;
import com.baidu.tieba.person.god.view.PersonInfoGodEnterView;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g extends y.a {
    public int afy;
    public PersonInfoEnterItemView euA;
    public PersonInfoEnterItemView euB;
    public PersonInfoBaseGodView euu;
    public PersonInfoGodEnterView euv;
    public LinearLayout euw;
    public PersonInfoEnterItemView eux;
    public PersonInfoEnterItemView euy;
    public PersonInfoEnterItemView euz;

    public g(View view) {
        super(view);
        this.afy = 3;
        this.euw = (LinearLayout) view.findViewById(u.g.normal_root_layout);
        this.eux = (PersonInfoEnterItemView) view.findViewById(u.g.enter_histroy);
        this.euy = (PersonInfoEnterItemView) view.findViewById(u.g.enter_collect);
        this.euz = (PersonInfoEnterItemView) view.findViewById(u.g.enter_attention);
        this.euA = (PersonInfoEnterItemView) view.findViewById(u.g.enter_fans);
        this.euB = (PersonInfoEnterItemView) view.findViewById(u.g.enter_friends);
        this.euu = (PersonInfoBaseGodView) view.findViewById(u.g.base_god_info);
        this.euv = (PersonInfoGodEnterView) view.findViewById(u.g.menbership_view);
    }
}
