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
/* loaded from: classes10.dex */
public class ConnectionWheatButtonView extends SafeFrameLayout implements View.OnClickListener {
    private TextView oNr;
    private LinearLayout oNs;
    private TextView oNt;
    private TextView oNu;
    private a oNv;

    /* loaded from: classes10.dex */
    public interface a {
        void eeo();

        void eep();

        void eeq();
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
        this.oNr.setOnClickListener(this);
        this.oNt.setOnClickListener(this);
        this.oNu.setOnClickListener(this);
        this.oNr.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oNt.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oNu.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_button_view, this);
        this.oNr = (TextView) inflate.findViewById(a.f.tv_apply_default_wheat_btn);
        this.oNs = (LinearLayout) inflate.findViewById(a.f.team_fright_connection_wheat_button_container);
        this.oNt = (TextView) inflate.findViewById(a.f.tv_apply_red_team_btn);
        this.oNu = (TextView) inflate.findViewById(a.f.tv_apply_blue_team_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oNr) {
            if (this.oNv != null) {
                this.oNv.eeo();
            }
        } else if (view == this.oNt) {
            if (this.oNv != null) {
                this.oNv.eep();
            }
        } else if (view == this.oNu && this.oNv != null) {
            this.oNv.eeq();
        }
    }

    public void setListener(a aVar) {
        this.oNv = aVar;
    }

    public void init() {
        if (q.edU().eeh()) {
            this.oNr.setVisibility(8);
            this.oNs.setVisibility(0);
        } else {
            this.oNr.setVisibility(0);
            this.oNs.setVisibility(8);
        }
        this.oNt.setSelected(false);
        this.oNu.setSelected(true);
    }

    public void ah(int i, int i2, int i3) {
        init();
        this.oNt.setEnabled(true);
        this.oNu.setEnabled(true);
        this.oNt.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_red_shape);
        this.oNu.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_blue_shape);
        this.oNt.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oNu.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        if (i > 0) {
            if (i2 > 0) {
                this.oNr.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                if (i3 < 5) {
                    this.oNu.setEnabled(false);
                    this.oNu.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                    this.oNu.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                    this.oNt.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                    this.oNu.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
                    return;
                }
                this.oNt.setEnabled(false);
                this.oNt.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                this.oNt.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                this.oNt.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
                this.oNu.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                return;
            }
            this.oNr.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.oNt.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
            this.oNu.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
            return;
        }
        this.oNr.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        this.oNt.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
        this.oNu.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
    }
}
