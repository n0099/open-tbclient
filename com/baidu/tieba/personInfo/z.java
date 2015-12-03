package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(d dVar) {
        this.cSn = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (view != null) {
            list = this.cSn.cRP;
            if (list != null && (view.getTag(n.f.tag_person_photo_item_position) instanceof Integer)) {
                int intValue = ((Integer) view.getTag(n.f.tag_person_photo_item_position)).intValue();
                list2 = this.cSn.cRP;
                d dVar = this.cSn;
                list3 = this.cSn.cRP;
                dVar.a((com.baidu.tbadk.data.g) list2.get(intValue), list3, intValue);
            }
        }
    }
}
