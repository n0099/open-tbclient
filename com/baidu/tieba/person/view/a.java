package com.baidu.tieba.person.view;

import android.view.View;
import com.baidu.tieba.person.data.f;
import com.baidu.tieba.personInfo.d;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PersonInfoEnterItemView exr;
    private final /* synthetic */ d exs;
    private final /* synthetic */ f exu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonInfoEnterItemView personInfoEnterItemView, d dVar, f fVar) {
        this.exr = personInfoEnterItemView;
        this.exs = dVar;
        this.exu = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exs != null) {
            this.exs.a(this.exu);
        }
    }
}
