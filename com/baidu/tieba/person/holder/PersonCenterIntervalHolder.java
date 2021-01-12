package com.baidu.tieba.person.holder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PersonCenterIntervalHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public View mjB;

    public PersonCenterIntervalHolder(View view) {
        super(view);
        this.akf = -1;
        this.mjB = view.findViewById(R.id.person_center_interval_item);
    }
}
