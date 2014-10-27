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
    TextView JM;
    View MI;
    TextView auh;
    TextView axq;
    HeadImageView azk;
    TextView bmf;
    LinearLayout bnA;
    TextView bnr;
    TextView bns;
    p bnt;
    l bnu;
    TextView bnw;
    LinearLayout bnx;
    ImageView bny;
    TextView bnz;

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(q qVar) {
        this();
    }

    public void f(Context context, View view) {
        this.bnA = (LinearLayout) view.findViewById(com.baidu.tieba.v.reply_container);
        this.azk = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.bnr = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.auh = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bns = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.MI = view.findViewById(com.baidu.tieba.v.line);
        this.bmf = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.JM = (TextView) view.findViewById(com.baidu.tieba.v.title);
        this.axq = (TextView) view.findViewById(com.baidu.tieba.v.forum);
        this.bnw = (TextView) view.findViewById(com.baidu.tieba.v.reply_type);
        this.bnx = (LinearLayout) view.findViewById(com.baidu.tieba.v.ll_quick_reply);
        this.bny = (ImageView) view.findViewById(com.baidu.tieba.v.iv_quick_reply_icon);
        this.bnz = (TextView) view.findViewById(com.baidu.tieba.v.tv_quick_reply_text);
        this.bnt = new p(context);
        this.bnu = new l(context, 1);
        this.azk.setOnClickListener(this.bnt);
        this.bns.setOnClickListener(this.bnu);
    }
}
