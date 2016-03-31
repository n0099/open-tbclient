package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        if (view != null) {
            list = this.this$0.dCD;
            if (list != null && (view.getTag(t.g.tag_person_photo_item_position) instanceof Integer)) {
                int intValue = ((Integer) view.getTag(t.g.tag_person_photo_item_position)).intValue();
                list2 = this.this$0.dCD;
                f fVar = this.this$0;
                list3 = this.this$0.dCD;
                fVar.a((com.baidu.tbadk.data.h) list2.get(intValue), list3, intValue);
            }
        }
    }
}
