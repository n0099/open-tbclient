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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class ConnectionWheatButtonView extends SafeFrameLayout implements View.OnClickListener {
    private TextView oLm;
    private LinearLayout oLn;
    private TextView oLo;
    private TextView oLp;
    private a oLq;

    /* loaded from: classes11.dex */
    public interface a {
        void eeg();

        void eeh();

        void eei();
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
        this.oLm.setOnClickListener(this);
        this.oLo.setOnClickListener(this);
        this.oLp.setOnClickListener(this);
        this.oLm.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oLo.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oLp.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_button_view, this);
        this.oLm = (TextView) inflate.findViewById(a.f.tv_apply_default_wheat_btn);
        this.oLn = (LinearLayout) inflate.findViewById(a.f.team_fright_connection_wheat_button_container);
        this.oLo = (TextView) inflate.findViewById(a.f.tv_apply_red_team_btn);
        this.oLp = (TextView) inflate.findViewById(a.f.tv_apply_blue_team_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oLm) {
            if (this.oLq != null) {
                this.oLq.eeg();
            }
        } else if (view == this.oLo) {
            if (this.oLq != null) {
                this.oLq.eeh();
            }
        } else if (view == this.oLp && this.oLq != null) {
            this.oLq.eei();
        }
    }

    public void setListener(a aVar) {
        this.oLq = aVar;
    }

    public void init() {
        if (q.edM().edZ()) {
            this.oLm.setVisibility(8);
            this.oLn.setVisibility(0);
        } else {
            this.oLm.setVisibility(0);
            this.oLn.setVisibility(8);
        }
        this.oLo.setSelected(false);
        this.oLp.setSelected(true);
    }

    public void ah(int i, int i2, int i3) {
        init();
        this.oLo.setEnabled(true);
        this.oLp.setEnabled(true);
        this.oLo.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_red_shape);
        this.oLp.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_blue_shape);
        this.oLo.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oLp.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        if (i > 0) {
            if (i2 > 0) {
                this.oLm.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                if (i3 < 5) {
                    this.oLp.setEnabled(false);
                    this.oLp.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                    this.oLp.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                    this.oLo.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                    this.oLp.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
                    return;
                }
                this.oLo.setEnabled(false);
                this.oLo.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                this.oLo.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                this.oLo.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
                this.oLp.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                return;
            }
            this.oLm.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.oLo.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
            this.oLp.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
            return;
        }
        this.oLm.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        this.oLo.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
        this.oLp.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
    }
}
