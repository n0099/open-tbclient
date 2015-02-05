package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView awr;
    private EditText bqD;
    private BarImageView bqE;
    private BarImageView bqF;
    protected TextView bqG;
    private ShareFromGameCenterMsgData bqH;

    public EditText getChatMsgView() {
        return this.bqD;
    }

    public b(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        com.baidu.adp.lib.g.b.ei().inflate(context, x.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bqD = (EditText) findViewById(w.game_to_group_share_chat_msg);
        this.bqE = (BarImageView) findViewById(w.game_to_group_share_img);
        this.bqF = (BarImageView) findViewById(w.game_to_group_share_icon);
        this.awr = (TextView) findViewById(w.game_to_group_share_desc);
        bc.i((View) this.bqD, v.inputbox_share);
        bc.b(this.bqD, t.cp_cont_b, 2);
        this.bqD.setHintTextColor(bc.getColor(t.cp_bg_line_b));
        bc.b(this.awr, t.cp_cont_f, 1);
        this.bqD.setPadding(context.getResources().getDimensionPixelSize(u.ds20), 0, 0, 0);
        this.bqG = (TextView) findViewById(w.game_to_group_share);
        bc.b(this.bqG, t.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.bqD != null) {
            return k.a(this.bqD.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bqH = shareFromGameCenterMsgData;
        qB();
    }

    private void qB() {
        this.bqE.setTag(this.bqH.getImageUrl());
        this.bqE.d(this.bqH.getImageUrl(), 17, false);
        this.bqF.setTag(this.bqH.getShareSourceIcon());
        this.bqF.d(this.bqH.getShareSourceIcon(), 17, false);
        this.awr.setText(this.bqH.getContent());
        this.bqG.setText("来自" + this.bqH.getShareSource());
    }
}
