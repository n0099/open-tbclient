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
    private TextView aCm;
    private TextView ahz;
    private HeadImageView boD;
    private ShareFromPBMsgData boE;

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
        this.ahz = (TextView) findViewById(v.chat_title);
        this.boD = (HeadImageView) findViewById(v.chat_group_img);
        this.aCm = (TextView) findViewById(v.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.ahz.setTextColor(getContext().getResources().getColor(s.cp_cont_b));
            this.aCm.setTextColor(getContext().getResources().getColor(s.cp_cont_f));
            return;
        }
        this.ahz.setTextColor(getContext().getResources().getColor(s.cp_cont_g));
        this.aCm.setTextColor(getContext().getResources().getColor(s.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.boE = shareFromPBMsgData;
        tM();
    }

    private void tM() {
        this.ahz.setText(this.boE.getTitle());
        this.boD.setDefaultResource(u.icon_default_ba_120);
        this.boD.setAutoChangeStyle(false);
        this.boD.c(this.boE.getImageUrl(), 10, false);
        this.aCm.setText(this.boE.getContent());
    }
}
