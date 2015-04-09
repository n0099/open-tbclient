package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aCm;
    private EditText bos;
    private BarImageView bot;
    private BarImageView bou;
    protected TextView bov;
    private ShareFromGameCenterMsgData bow;

    public EditText getChatMsgView() {
        return this.bos;
    }

    public b(Context context) {
        super(context);
        au(context);
    }

    private void au(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, w.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bos = (EditText) findViewById(v.game_to_group_share_chat_msg);
        this.bot = (BarImageView) findViewById(v.game_to_group_share_img);
        this.bou = (BarImageView) findViewById(v.game_to_group_share_icon);
        this.aCm = (TextView) findViewById(v.game_to_group_share_desc);
        ba.i((View) this.bos, u.inputbox_share);
        ba.b(this.bos, s.cp_cont_b, 2);
        this.bos.setHintTextColor(ba.getColor(s.cp_bg_line_b));
        ba.b(this.aCm, s.cp_cont_f, 1);
        this.bos.setPadding(context.getResources().getDimensionPixelSize(t.ds20), 0, 0, 0);
        this.bov = (TextView) findViewById(v.game_to_group_share);
        ba.b(this.bov, s.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.bos != null) {
            return m.a(this.bos.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bow = shareFromGameCenterMsgData;
        tM();
    }

    private void tM() {
        this.bot.setTag(this.bow.getImageUrl());
        this.bot.c(this.bow.getImageUrl(), 17, false);
        this.bou.setTag(this.bow.getShareSourceIcon());
        this.bou.c(this.bow.getShareSourceIcon(), 17, false);
        this.aCm.setText(this.bow.getContent());
        this.bov.setText("来自" + this.bow.getShareSource());
    }
}
