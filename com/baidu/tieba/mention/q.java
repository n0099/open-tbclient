package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {
    TextView JN;
    View ML;
    TextView auq;
    TextView axz;
    HeadImageView azt;
    TextView bmt;
    TextView bnF;
    TextView bnG;
    p bnH;
    l bnI;
    TextView bnK;
    LinearLayout bnL;
    ImageView bnM;
    TextView bnN;
    LinearLayout bnO;

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(q qVar) {
        this();
    }

    public void f(Context context, View view) {
        this.bnO = (LinearLayout) view.findViewById(com.baidu.tieba.v.reply_container);
        this.azt = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.bnF = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.auq = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bnG = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.ML = view.findViewById(com.baidu.tieba.v.line);
        this.bmt = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.JN = (TextView) view.findViewById(com.baidu.tieba.v.title);
        this.axz = (TextView) view.findViewById(com.baidu.tieba.v.forum);
        this.bnK = (TextView) view.findViewById(com.baidu.tieba.v.reply_type);
        this.bnL = (LinearLayout) view.findViewById(com.baidu.tieba.v.ll_quick_reply);
        this.bnM = (ImageView) view.findViewById(com.baidu.tieba.v.iv_quick_reply_icon);
        this.bnN = (TextView) view.findViewById(com.baidu.tieba.v.tv_quick_reply_text);
        this.bnH = new p(context);
        this.bnI = new l(context, 1);
        this.azt.setOnClickListener(this.bnH);
        this.bnG.setOnClickListener(this.bnI);
    }
}
