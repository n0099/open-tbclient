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
import d.a.m0.r.f0.m.a;
/* loaded from: classes5.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20483e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20484f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20485g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20486h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20487i;
    public TextView j;
    public TBSpecificationBtn k;
    public int l;

    public YoungsterIntroduceView(Context context) {
        this(context, null);
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.youngster_introduce, this);
        this.f20483e = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.f20484f = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.f20485g = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.f20486h = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.f20487i = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.j = (TextView) findViewById(R.id.txt_youngster_introduce_content4);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.k = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(new a());
        this.k.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.k.setOnClickListener(this);
        b();
    }

    public void b() {
        this.f20483e.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.pic_mask_qingshaonian_time, WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f20484f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f20485g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f20486h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f20487i, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        this.k.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    public void setFrom(int i2) {
        this.l = i2;
    }

    public YoungsterIntroduceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterIntroduceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
