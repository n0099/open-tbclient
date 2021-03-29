package com.baidu.tieba.setting.more.youngster.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.h0.r.f0.m.a;
/* loaded from: classes5.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21067e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21068f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21069g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21070h;
    public TextView i;
    public TBSpecificationBtn j;
    public int k;

    public YoungsterIntroduceView(Context context) {
        this(context, null);
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.youngster_introduce, this);
        this.f21067e = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.f21068f = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.f21069g = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.f21070h = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.i = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.j = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(new a());
        this.j.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.j.setOnClickListener(this);
        b();
    }

    public void b() {
        this.f21067e.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f21068f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f21069g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f21070h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.k);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    public void setFrom(int i) {
        this.k = i;
    }

    public YoungsterIntroduceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterIntroduceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
