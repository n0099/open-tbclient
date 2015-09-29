package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class n extends LinearLayout {
    private TextView aCy;
    private TextView alt;
    private TbImageView bIw;
    private EditText bdw;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdw;
    }

    public void w(String str, boolean z) {
        if (this.bIw != null) {
            this.bIw.d(str, z ? 17 : 18, false);
        }
    }

    public n(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.alt = (TextView) findViewById(i.f.share_title_view);
        am.b(this.alt, i.c.cp_cont_b, 1);
        this.bdw = (EditText) findViewById(i.f.chat_msg);
        this.bIw = (TbImageView) findViewById(i.f.chat_group_img);
        this.aCy = (TextView) findViewById(i.f.chat_group_desc);
        am.b(this.bdw, i.c.cp_cont_b, 2);
        am.b(this.aCy, i.c.cp_cont_f, 1);
        this.bdw.setHintTextColor(am.getColor(i.c.cp_cont_e));
        this.bdw.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        Od();
    }

    public void Od() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public void setDesc(String str) {
        if (this.aCy != null) {
            this.aCy.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.alt != null) {
            this.alt.setText(str);
        }
    }

    public String getLeaveMsg() {
        if (this.bdw != null) {
            return com.baidu.adp.lib.util.j.a(this.bdw.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }
}
