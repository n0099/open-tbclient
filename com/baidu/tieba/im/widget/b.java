package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView avu;
    private EditText bpg;
    private BarImageView bph;
    private BarImageView bpi;
    protected TextView bpj;
    private ShareFromGameCenterMsgData bpk;

    public EditText getChatMsgView() {
        return this.bpg;
    }

    public b(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, x.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bpg = (EditText) findViewById(w.game_to_group_share_chat_msg);
        this.bph = (BarImageView) findViewById(w.game_to_group_share_img);
        this.bpi = (BarImageView) findViewById(w.game_to_group_share_icon);
        this.avu = (TextView) findViewById(w.game_to_group_share_desc);
        ax.i((View) this.bpg, v.inputbox_share);
        ax.b(this.bpg, t.cp_cont_b, 2);
        this.bpg.setHintTextColor(ax.getColor(t.cp_bg_line_b));
        ax.b(this.avu, t.cp_cont_f, 1);
        this.bpg.setPadding(context.getResources().getDimensionPixelSize(u.ds20), 0, 0, 0);
        this.bpj = (TextView) findViewById(w.game_to_group_share);
        ax.b(this.bpj, t.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.bpg != null) {
            return k.a(this.bpg.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bpk = shareFromGameCenterMsgData;
        qw();
    }

    private void qw() {
        this.bph.setTag(this.bpk.getImageUrl());
        this.bph.d(this.bpk.getImageUrl(), 17, false);
        this.bpi.setTag(this.bpk.getShareSourceIcon());
        this.bpi.d(this.bpk.getShareSourceIcon(), 17, false);
        this.avu.setText(this.bpk.getContent());
        this.bpj.setText("来自" + this.bpk.getShareSource());
    }
}
