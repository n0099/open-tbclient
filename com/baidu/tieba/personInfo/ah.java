package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(f fVar) {
        this.diG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (view != null) {
            list = this.diG.dib;
            if (list != null && (view.getTag(t.g.tag_person_photo_item_position) instanceof Integer)) {
                int intValue = ((Integer) view.getTag(t.g.tag_person_photo_item_position)).intValue();
                list2 = this.diG.dib;
                f fVar = this.diG;
                list3 = this.diG.dib;
                fVar.a((com.baidu.tbadk.data.g) list2.get(intValue), list3, intValue);
            }
        }
    }
}
