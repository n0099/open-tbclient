package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(d dVar) {
        this.cWV = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (view != null) {
            list = this.cWV.cWs;
            if (list != null && (view.getTag(n.g.tag_person_photo_item_position) instanceof Integer)) {
                int intValue = ((Integer) view.getTag(n.g.tag_person_photo_item_position)).intValue();
                list2 = this.cWV.cWs;
                d dVar = this.cWV;
                list3 = this.cWV.cWs;
                dVar.a((com.baidu.tbadk.data.g) list2.get(intValue), list3, intValue);
            }
        }
    }
}
