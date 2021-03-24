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
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class NewUserRewardDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public AlphaVideo f22141e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f22142f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22143g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22144h;
    public ImageView i;
    public final CustomMessageListener j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() || NewUserRewardDialogView.this.f22141e == null) {
                return;
            }
            NewUserRewardDialogView.this.f22141e.requestRender();
        }
    }

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.f22141e = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.f22142f = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.f22143g = (TextView) findViewById(R.id.new_user_dialog_title);
        this.f22144h = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.i = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.f22142f.setAllCornerRound(l.g(context, R.dimen.tbds31));
        this.f22141e.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.j);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f22142f, R.color.CAM_X0211);
        SkinManager.setViewTextColor(this.f22143g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f22144h, R.color.CAM_X0107);
        SkinManager.setImageResource(this.i, R.drawable.icon_use_close_n);
    }

    public void d() {
        this.f22141e.destroy();
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData == null) {
            return;
        }
        this.f22143g.setText(iconStampData.stampTitle);
        this.f22144h.setText(iconStampData.stampText);
        int i = iconStampData.stampType;
        if (i == 1) {
            this.f22141e.setSourceAssets("post_1_times.mp4");
        } else if (i == 2) {
            this.f22141e.setSourceAssets("reply_1_times.mp4");
        } else if (i == 3) {
            this.f22141e.setSourceAssets("post_7_times.mp4");
        } else {
            this.f22141e.setSourceAssets("reply_7_times.mp4");
        }
        this.f22141e.play();
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new a(2001011);
        b(context);
        c();
    }
}
