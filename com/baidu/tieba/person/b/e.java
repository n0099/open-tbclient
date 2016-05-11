package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.person.god.view.PersonInfoBaseGodView;
import com.baidu.tieba.person.god.view.PersonInfoGodEnterView;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends y.a {
    public int aej;
    public PersonInfoBaseGodView dBr;
    public PersonInfoGodEnterView dBs;
    public LinearLayout dBt;
    public PersonInfoEnterItemView dBu;
    public PersonInfoEnterItemView dBv;
    public PersonInfoEnterItemView dBw;
    public PersonInfoEnterItemView dBx;
    public PersonInfoEnterItemView dBy;
    public PersonInfoEnterItemView dBz;

    public e(View view) {
        super(view);
        this.aej = 3;
        this.dBt = (LinearLayout) view.findViewById(t.g.normal_root_layout);
        this.dBu = (PersonInfoEnterItemView) view.findViewById(t.g.enter_histroy);
        this.dBv = (PersonInfoEnterItemView) view.findViewById(t.g.enter_collect);
        this.dBw = (PersonInfoEnterItemView) view.findViewById(t.g.enter_attention);
        this.dBx = (PersonInfoEnterItemView) view.findViewById(t.g.enter_fans);
        this.dBy = (PersonInfoEnterItemView) view.findViewById(t.g.enter_friends);
        this.dBz = (PersonInfoEnterItemView) view.findViewById(t.g.enter_feeds);
        this.dBr = (PersonInfoBaseGodView) view.findViewById(t.g.base_god_info);
        this.dBs = (PersonInfoGodEnterView) view.findViewById(t.g.menbership_view);
    }
}
