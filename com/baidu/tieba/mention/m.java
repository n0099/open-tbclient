package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    View ML;
    TextView auq;
    HeadImageView azt;
    TextView bmt;
    TextView bnF;
    TextView bnG;
    p bnH;
    l bnI;

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(m mVar) {
        this();
    }

    public void f(Context context, View view) {
        this.azt = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.bnG = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.bnF = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.auq = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bmt = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.ML = view.findViewById(com.baidu.tieba.v.line);
        this.bnH = new p(context);
        this.bnI = new l(context, 2);
        this.azt.setOnClickListener(this.bnH);
        this.bnG.setOnClickListener(this.bnI);
    }
}
