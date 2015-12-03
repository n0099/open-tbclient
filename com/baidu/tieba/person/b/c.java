package com.baidu.tieba.person.b;

import android.view.View;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
import com.baidu.tieba.person.view.PersonInfoEnterItemView;
/* loaded from: classes.dex */
public class c extends x.a {
    public int afY;
    public PersonInfoEnterItemView cNS;
    public PersonInfoEnterItemView cNT;
    public PersonInfoEnterItemView cNU;
    public PersonInfoEnterItemView cNV;
    public PersonInfoEnterItemView cNW;

    public c(View view) {
        super(view);
        this.afY = 3;
        this.cNS = (PersonInfoEnterItemView) view.findViewById(n.f.enter_histroy);
        this.cNT = (PersonInfoEnterItemView) view.findViewById(n.f.enter_collect);
        this.cNU = (PersonInfoEnterItemView) view.findViewById(n.f.enter_attention);
        this.cNV = (PersonInfoEnterItemView) view.findViewById(n.f.enter_fans);
        this.cNW = (PersonInfoEnterItemView) view.findViewById(n.f.enter_friends);
    }
}
