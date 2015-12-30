package com.baidu.tieba.person.b;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
/* loaded from: classes.dex */
public class c extends x.a {
    public int ahf;
    public PersonInfoEnterItemView cSA;
    public PersonInfoEnterItemView cSB;
    public PersonInfoEnterItemView cSC;
    public PersonInfoEnterItemView cSy;
    public PersonInfoEnterItemView cSz;

    public c(View view) {
        super(view);
        this.ahf = 3;
        this.cSy = (PersonInfoEnterItemView) view.findViewById(n.g.enter_histroy);
        this.cSz = (PersonInfoEnterItemView) view.findViewById(n.g.enter_collect);
        this.cSA = (PersonInfoEnterItemView) view.findViewById(n.g.enter_attention);
        this.cSB = (PersonInfoEnterItemView) view.findViewById(n.g.enter_fans);
        this.cSC = (PersonInfoEnterItemView) view.findViewById(n.g.enter_friends);
    }
}
