package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class Thread2GroupShareView extends LinearLayout {
    private LinearLayout bMZ;
    private EditText fQJ;
    private ShareFromPBMsgData gLf;
    private TbImageView gpL;
    private TextView gpM;
    private TextView title;

    public EditText getChatMsgView() {
        return this.fQJ;
    }

    public void ai(String str, boolean z) {
        if (this.gpL != null) {
            this.gpL.startLoad(str, z ? 17 : 18, false);
        }
    }

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.bMZ = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        this.fQJ = (EditText) findViewById(R.id.chat_msg);
        this.gpL = (TbImageView) findViewById(R.id.chat_group_img);
        this.gpM = (TextView) findViewById(R.id.chat_group_desc);
        al.f(this.title, R.color.cp_cont_b, 1);
        al.f(this.fQJ, R.color.cp_cont_b, 2);
        al.f(this.gpM, R.color.cp_cont_f, 1);
        this.fQJ.setHintTextColor(al.getColor(R.color.cp_cont_e));
        this.fQJ.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brA();
    }

    public void brA() {
        this.bMZ.setFocusable(true);
        this.bMZ.setFocusableInTouchMode(true);
        this.bMZ.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fQJ != null) {
            return com.baidu.adp.lib.util.k.a(this.fQJ.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gLf = shareFromPBMsgData;
        Jf();
    }

    private void Jf() {
        this.title.setText(this.gLf.getTitle());
        this.gpL.setTag(this.gLf.getImageUrl());
        this.gpM.setText(this.gLf.getContent());
    }
}
