package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.data.p a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar, com.baidu.tieba.data.p pVar) {
        this.b = hVar;
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatService.onEvent(this.b.i, "recommend_to_pb", "click");
        UtilHelper.a(this.b.i, this.a.a(), null, null);
    }
}
