package com.baidu.tieba.person.holder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PersonCenterIntervalHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f19906a;

    /* renamed from: b  reason: collision with root package name */
    public View f19907b;

    public PersonCenterIntervalHolder(View view) {
        super(view);
        this.f19906a = -1;
        this.f19907b = view.findViewById(R.id.person_center_interval_item);
    }
}
