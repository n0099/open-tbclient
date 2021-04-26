package com.baidu.tieba.person.holder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonCenterIntervalHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f20418a;

    /* renamed from: b  reason: collision with root package name */
    public View f20419b;

    public PersonCenterIntervalHolder(View view) {
        super(view);
        this.f20418a = -1;
        this.f20419b = view.findViewById(R.id.person_center_interval_item);
    }
}
