package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class TipGuideView extends LinearLayout implements View.OnClickListener {
    private TextView oyC;
    private View oyD;

    public TipGuideView(Context context) {
        this(context, null);
    }

    public TipGuideView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipGuideView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.layout_tip_guide_view, (ViewGroup) this, false);
        inflate.findViewById(a.f.rl_root).setOnClickListener(this);
        this.oyD = inflate.findViewById(a.f.iv_top_arrows);
        this.oyC = (TextView) inflate.findViewById(a.f.tv_guide_text);
        addView(inflate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.rl_root) {
            setVisibility(8);
        }
    }

    public void setText(String str) {
        if (this.oyC != null && !TextUtils.isEmpty(str)) {
            this.oyC.setText(str);
        }
    }
}
