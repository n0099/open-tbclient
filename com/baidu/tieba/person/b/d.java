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
    public int aik;
    public PersonInfoBaseGodView dyj;
    public PersonInfoGodEnterView dyk;
    public LinearLayout dyl;
    public PersonInfoEnterItemView dym;
    public PersonInfoEnterItemView dyn;
    public PersonInfoEnterItemView dyo;
    public PersonInfoEnterItemView dyp;
    public PersonInfoEnterItemView dyq;
    public PersonInfoEnterItemView dyr;

    public d(View view) {
        super(view);
        this.aik = 3;
        this.dyl = (LinearLayout) view.findViewById(t.g.normal_root_layout);
        this.dym = (PersonInfoEnterItemView) view.findViewById(t.g.enter_histroy);
        this.dyn = (PersonInfoEnterItemView) view.findViewById(t.g.enter_collect);
        this.dyo = (PersonInfoEnterItemView) view.findViewById(t.g.enter_attention);
        this.dyp = (PersonInfoEnterItemView) view.findViewById(t.g.enter_fans);
        this.dyq = (PersonInfoEnterItemView) view.findViewById(t.g.enter_friends);
        this.dyr = (PersonInfoEnterItemView) view.findViewById(t.g.enter_feeds);
        this.dyj = (PersonInfoBaseGodView) view.findViewById(t.g.base_god_info);
        this.dyk = (PersonInfoGodEnterView) view.findViewById(t.g.menbership_view);
    }
}
