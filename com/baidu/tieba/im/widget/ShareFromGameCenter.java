package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.c3.n0.b;
/* loaded from: classes3.dex */
public class ShareFromGameCenter extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f18132e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18133f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f18134g;

    /* renamed from: h  reason: collision with root package name */
    public Button f18135h;
    public TbImageView i;
    public LinearLayout j;
    public LinearLayout k;
    public LinearLayout l;
    public TextView m;
    public ShareFromGameCenterMsgData n;
    public Context o;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = context;
        a();
    }

    public void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.j = (LinearLayout) findViewById(R.id.share_info_layout);
        this.l = (LinearLayout) findViewById(R.id.game_share_content);
        this.k = (LinearLayout) findViewById(R.id.small_tail);
        this.f18132e = (TextView) findViewById(R.id.game_title);
        this.f18133f = (TextView) findViewById(R.id.game_desc);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.game_img);
        this.f18134g = headImageView;
        headImageView.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.f18134g.setAutoChangeStyle(false);
        this.f18135h = (Button) findViewById(R.id.accept_invite_button);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
        this.i = tbImageView;
        tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
        this.i.setAutoChangeStyle(false);
        this.m = (TextView) findViewById(R.id.tail_game_from);
    }

    public final void b(boolean z) {
        if (z) {
            this.j.setBackgroundDrawable(this.o.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.f18132e.setTextColor(this.o.getResources().getColor(R.color.CAM_X0111));
            this.f18133f.setTextColor(this.o.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.f18132e.setTextColor(this.o.getResources().getColor(R.color.CAM_X0105));
            this.f18133f.setTextColor(this.o.getResources().getColor(R.color.CAM_X0106));
            this.j.setBackgroundDrawable(this.o.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.k.setLayoutParams(layoutParams);
        }
        this.f18132e.setText(this.n.getTitle());
        this.f18134g.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.f18134g.setAutoChangeStyle(false);
        this.f18134g.W(this.n.getImageUrl(), 10, false);
        this.f18133f.setText(this.n.getContent());
        this.f18135h.setTextColor(this.o.getResources().getColor(R.color.CAM_X0105));
        this.f18135h.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.n.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g2, l.g(getContext(), R.dimen.ds18), g2, g2);
            this.f18135h.setLayoutParams(layoutParams2);
            this.f18135h.setVisibility(0);
            this.f18135h.setText(this.n.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g3 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g3, l.g(getContext(), R.dimen.ds20), g3, g3);
            this.f18135h.setVisibility(8);
            this.l.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.n.getShareSource())) {
            this.k.setVisibility(8);
        }
        this.m.setText(this.n.getShareSource());
        this.i.setDefaultResource(R.drawable.tb_launcher_icon);
        this.i.setAutoChangeStyle(false);
        this.i.W(this.n.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.o, "game_show", "show", 1, "dev_id", b.a(this.n.getShareSourceUrl()), "ref_id", GameCenterCoreUtils.REF_TYPE_IM);
    }

    public LinearLayout getContentBody() {
        return this.j;
    }

    public LinearLayout getTail() {
        return this.k;
    }

    public ImageView getTiebaIcon() {
        return this.i;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData == null) {
            return;
        }
        this.n = shareFromGameCenterMsgData;
        b(z);
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.i = tbImageView;
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.o = context;
        a();
    }
}
