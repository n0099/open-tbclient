package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class NewUserRewardDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public AlphaVideo f21768e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f21769f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21770g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21771h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21772i;
    public final CustomMessageListener j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() || NewUserRewardDialogView.this.f21768e == null) {
                return;
            }
            NewUserRewardDialogView.this.f21768e.requestRender();
        }
    }

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.f21768e = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.f21769f = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.f21770g = (TextView) findViewById(R.id.new_user_dialog_title);
        this.f21771h = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.f21772i = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.f21769f.setAllCornerRound(l.g(context, R.dimen.tbds31));
        this.f21768e.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.j);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f21769f, R.color.CAM_X0211);
        SkinManager.setViewTextColor(this.f21770g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f21771h, R.color.CAM_X0107);
        SkinManager.setImageResource(this.f21772i, R.drawable.icon_use_close_n);
    }

    public void d() {
        this.f21768e.destroy();
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.f21772i.setOnClickListener(onClickListener);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData == null) {
            return;
        }
        this.f21770g.setText(iconStampData.stampTitle);
        this.f21771h.setText(iconStampData.stampText);
        int i2 = iconStampData.stampType;
        if (i2 == 1) {
            this.f21768e.setSourceAssets("post_1_times.mp4");
        } else if (i2 == 2) {
            this.f21768e.setSourceAssets("reply_1_times.mp4");
        } else if (i2 == 3) {
            this.f21768e.setSourceAssets("post_7_times.mp4");
        } else {
            this.f21768e.setSourceAssets("reply_7_times.mp4");
        }
        this.f21768e.play();
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new a(2001011);
        b(context);
        c();
    }
}
