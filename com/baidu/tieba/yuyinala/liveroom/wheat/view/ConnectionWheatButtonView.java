package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes10.dex */
public class ConnectionWheatButtonView extends SafeFrameLayout implements View.OnClickListener {
    private TextView oBc;
    private LinearLayout oBd;
    private TextView oBe;
    private TextView oBf;
    private a oBg;

    /* loaded from: classes10.dex */
    public interface a {
        void ebK();

        void ebL();

        void ebM();
    }

    public ConnectionWheatButtonView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatButtonView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatButtonView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
        initListener();
    }

    private void initListener() {
        this.oBc.setOnClickListener(this);
        this.oBe.setOnClickListener(this);
        this.oBf.setOnClickListener(this);
        this.oBc.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oBe.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oBf.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_button_view, this);
        this.oBc = (TextView) inflate.findViewById(a.f.tv_apply_default_wheat_btn);
        this.oBd = (LinearLayout) inflate.findViewById(a.f.team_fright_connection_wheat_button_container);
        this.oBe = (TextView) inflate.findViewById(a.f.tv_apply_red_team_btn);
        this.oBf = (TextView) inflate.findViewById(a.f.tv_apply_blue_team_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oBc) {
            if (this.oBg != null) {
                this.oBg.ebK();
            }
        } else if (view == this.oBe) {
            if (this.oBg != null) {
                this.oBg.ebL();
            }
        } else if (view == this.oBf && this.oBg != null) {
            this.oBg.ebM();
        }
    }

    public void setListener(a aVar) {
        this.oBg = aVar;
    }

    public void init() {
        if (o.ebo().ebE()) {
            this.oBc.setVisibility(8);
            this.oBd.setVisibility(0);
        } else {
            this.oBc.setVisibility(0);
            this.oBd.setVisibility(8);
        }
        this.oBe.setSelected(false);
        this.oBf.setSelected(true);
    }

    public void aj(int i, int i2, int i3) {
        init();
        this.oBe.setEnabled(true);
        this.oBf.setEnabled(true);
        this.oBe.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_red_shape);
        this.oBf.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_blue_shape);
        this.oBe.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oBf.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        if (i > 0) {
            if (i2 > 0) {
                this.oBc.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                if (i3 < 5) {
                    this.oBf.setEnabled(false);
                    this.oBf.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                    this.oBf.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                    this.oBe.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                    this.oBf.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
                    return;
                }
                this.oBe.setEnabled(false);
                this.oBe.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                this.oBe.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                this.oBe.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
                this.oBf.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                return;
            }
            this.oBc.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.oBe.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
            this.oBf.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
            return;
        }
        this.oBc.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        this.oBe.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
        this.oBf.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
    }
}
