package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aCe;
    private TextView ahr;
    private HeadImageView bon;
    private ShareFromPBMsgData boo;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), w.share_from_pb_view, this);
        setOrientation(1);
        this.ahr = (TextView) findViewById(v.chat_title);
        this.bon = (HeadImageView) findViewById(v.chat_group_img);
        this.aCe = (TextView) findViewById(v.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.ahr.setTextColor(getContext().getResources().getColor(s.cp_cont_b));
            this.aCe.setTextColor(getContext().getResources().getColor(s.cp_cont_f));
            return;
        }
        this.ahr.setTextColor(getContext().getResources().getColor(s.cp_cont_g));
        this.aCe.setTextColor(getContext().getResources().getColor(s.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.boo = shareFromPBMsgData;
        tM();
    }

    private void tM() {
        this.ahr.setText(this.boo.getTitle());
        this.bon.setDefaultResource(u.icon_default_ba_120);
        this.bon.setAutoChangeStyle(false);
        this.bon.c(this.boo.getImageUrl(), 10, false);
        this.aCe.setText(this.boo.getContent());
    }
}
