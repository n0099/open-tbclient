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
    private TextView nZq;
    private View nZr;

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
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.layout_tip_guide_view, (ViewGroup) this, false);
        inflate.findViewById(a.g.rl_root).setOnClickListener(this);
        this.nZr = inflate.findViewById(a.g.iv_top_arrows);
        this.nZq = (TextView) inflate.findViewById(a.g.tv_guide_text);
        addView(inflate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.rl_root) {
            setVisibility(8);
        }
    }

    public void setText(String str) {
        if (this.nZq != null && !TextUtils.isEmpty(str)) {
            this.nZq.setText(str);
        }
    }
}
