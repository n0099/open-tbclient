package com.baidu.tieba.person.holder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PersonCenterIntervalHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public View mog;

    public PersonCenterIntervalHolder(View view) {
        super(view);
        this.akW = -1;
        this.mog = view.findViewById(R.id.person_center_interval_item);
    }
}
