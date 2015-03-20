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
    private TextView aCe;
    private EditText boc;
    private BarImageView bod;
    private BarImageView boe;
    protected TextView bof;
    private ShareFromGameCenterMsgData bog;

    public EditText getChatMsgView() {
        return this.boc;
    }

    public b(Context context) {
        super(context);
        au(context);
    }

    private void au(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, w.game_to_group_share_dialog, this);
        setOrientation(1);
        this.boc = (EditText) findViewById(v.game_to_group_share_chat_msg);
        this.bod = (BarImageView) findViewById(v.game_to_group_share_img);
        this.boe = (BarImageView) findViewById(v.game_to_group_share_icon);
        this.aCe = (TextView) findViewById(v.game_to_group_share_desc);
        ba.i((View) this.boc, u.inputbox_share);
        ba.b(this.boc, s.cp_cont_b, 2);
        this.boc.setHintTextColor(ba.getColor(s.cp_bg_line_b));
        ba.b(this.aCe, s.cp_cont_f, 1);
        this.boc.setPadding(context.getResources().getDimensionPixelSize(t.ds20), 0, 0, 0);
        this.bof = (TextView) findViewById(v.game_to_group_share);
        ba.b(this.bof, s.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.boc != null) {
            return m.a(this.boc.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bog = shareFromGameCenterMsgData;
        tM();
    }

    private void tM() {
        this.bod.setTag(this.bog.getImageUrl());
        this.bod.c(this.bog.getImageUrl(), 17, false);
        this.boe.setTag(this.bog.getShareSourceIcon());
        this.boe.c(this.bog.getShareSourceIcon(), 17, false);
        this.aCe.setText(this.bog.getContent());
        this.bof.setText("来自" + this.bog.getShareSource());
    }
}
