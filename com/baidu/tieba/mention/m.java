package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m {
    View MI;
    TextView auh;
    HeadImageView azk;
    TextView bmf;
    TextView bnr;
    TextView bns;
    p bnt;
    l bnu;

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(m mVar) {
        this();
    }

    public void f(Context context, View view) {
        this.azk = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.bns = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.bnr = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.auh = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bmf = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.MI = view.findViewById(com.baidu.tieba.v.line);
        this.bnt = new p(context);
        this.bnu = new l(context, 2);
        this.azk.setOnClickListener(this.bnt);
        this.bns.setOnClickListener(this.bnu);
    }
}
