package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
/* loaded from: classes4.dex */
public class Game2GroupShareDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18123e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f18124f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18125g;

    /* renamed from: h  reason: collision with root package name */
    public BarImageView f18126h;
    public TextView i;
    public TextView j;
    public TextView k;
    public ShareFromGameCenterMsgData l;

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public void a() {
        this.f18123e.setFocusable(true);
        this.f18123e.setFocusableInTouchMode(true);
        this.f18123e.requestFocus();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_to_group_share_dialog, this);
        setOrientation(1);
        this.f18123e = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.j = (TextView) findViewById(R.id.share_title_view);
        this.f18124f = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.f18125g = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.f18126h = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.i = (TextView) findViewById(R.id.game_to_group_share_desc);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f18124f, R.color.CAM_X0105, 2);
        this.f18124f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0106, 1);
        this.f18124f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        TextView textView = (TextView) findViewById(R.id.game_to_group_share);
        this.k = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
        a();
    }

    public final void c() {
        this.j.setText(this.l.getTitle());
        this.f18125g.setTag(this.l.getImageUrl());
        this.f18125g.W(this.l.getImageUrl(), 17, false);
        this.f18126h.setVisibility(0);
        this.f18126h.setTag(this.l.getShareSourceIcon());
        this.f18126h.W(this.l.getShareSourceIcon(), 17, false);
        this.i.setText(this.l.getContent());
        TextView textView = this.k;
        textView.setText("来自" + this.l.getShareSource());
    }

    public EditText getChatMsgView() {
        return this.f18124f;
    }

    public String getLeaveMsg() {
        EditText editText = this.f18124f;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.l = shareFromGameCenterMsgData;
        c();
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.j.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
        }
        this.f18125g.setTag(shareFromPBMsgData.getImageUrl());
        this.f18125g.W(shareFromPBMsgData.getImageUrl(), 17, false);
        this.f18126h.setVisibility(8);
        this.i.setText(shareFromPBMsgData.getContent());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        b(context);
    }
}
