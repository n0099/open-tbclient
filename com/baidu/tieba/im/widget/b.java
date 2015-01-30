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
    private TextView awu;
    private EditText bqE;
    private BarImageView bqF;
    private BarImageView bqG;
    protected TextView bqH;
    private ShareFromGameCenterMsgData bqI;

    public EditText getChatMsgView() {
        return this.bqE;
    }

    public b(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        com.baidu.adp.lib.g.b.ei().inflate(context, x.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bqE = (EditText) findViewById(w.game_to_group_share_chat_msg);
        this.bqF = (BarImageView) findViewById(w.game_to_group_share_img);
        this.bqG = (BarImageView) findViewById(w.game_to_group_share_icon);
        this.awu = (TextView) findViewById(w.game_to_group_share_desc);
        bc.i((View) this.bqE, v.inputbox_share);
        bc.b(this.bqE, t.cp_cont_b, 2);
        this.bqE.setHintTextColor(bc.getColor(t.cp_bg_line_b));
        bc.b(this.awu, t.cp_cont_f, 1);
        this.bqE.setPadding(context.getResources().getDimensionPixelSize(u.ds20), 0, 0, 0);
        this.bqH = (TextView) findViewById(w.game_to_group_share);
        bc.b(this.bqH, t.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.bqE != null) {
            return k.a(this.bqE.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bqI = shareFromGameCenterMsgData;
        qH();
    }

    private void qH() {
        this.bqF.setTag(this.bqI.getImageUrl());
        this.bqF.d(this.bqI.getImageUrl(), 17, false);
        this.bqG.setTag(this.bqI.getShareSourceIcon());
        this.bqG.d(this.bqI.getShareSourceIcon(), 17, false);
        this.awu.setText(this.bqI.getContent());
        this.bqH.setText("来自" + this.bqI.getShareSource());
    }
}
