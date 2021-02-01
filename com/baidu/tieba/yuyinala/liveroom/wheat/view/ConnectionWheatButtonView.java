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
    private TextView oKM;
    private LinearLayout oKN;
    private TextView oKO;
    private TextView oKP;
    private a oKQ;

    /* loaded from: classes11.dex */
    public interface a {
        void edY();

        void edZ();

        void eea();
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
        this.oKM.setOnClickListener(this);
        this.oKO.setOnClickListener(this);
        this.oKP.setOnClickListener(this);
        this.oKM.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oKO.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oKP.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_button_view, this);
        this.oKM = (TextView) inflate.findViewById(a.f.tv_apply_default_wheat_btn);
        this.oKN = (LinearLayout) inflate.findViewById(a.f.team_fright_connection_wheat_button_container);
        this.oKO = (TextView) inflate.findViewById(a.f.tv_apply_red_team_btn);
        this.oKP = (TextView) inflate.findViewById(a.f.tv_apply_blue_team_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oKM) {
            if (this.oKQ != null) {
                this.oKQ.edY();
            }
        } else if (view == this.oKO) {
            if (this.oKQ != null) {
                this.oKQ.edZ();
            }
        } else if (view == this.oKP && this.oKQ != null) {
            this.oKQ.eea();
        }
    }

    public void setListener(a aVar) {
        this.oKQ = aVar;
    }

    public void init() {
        if (q.edE().edR()) {
            this.oKM.setVisibility(8);
            this.oKN.setVisibility(0);
        } else {
            this.oKM.setVisibility(0);
            this.oKN.setVisibility(8);
        }
        this.oKO.setSelected(false);
        this.oKP.setSelected(true);
    }

    public void ah(int i, int i2, int i3) {
        init();
        this.oKO.setEnabled(true);
        this.oKP.setEnabled(true);
        this.oKO.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_red_shape);
        this.oKP.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_blue_shape);
        this.oKO.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oKP.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        if (i > 0) {
            if (i2 > 0) {
                this.oKM.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                if (i3 < 5) {
                    this.oKP.setEnabled(false);
                    this.oKP.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                    this.oKP.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                    this.oKO.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                    this.oKP.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
                    return;
                }
                this.oKO.setEnabled(false);
                this.oKO.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                this.oKO.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                this.oKO.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
                this.oKP.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                return;
            }
            this.oKM.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.oKO.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
            this.oKP.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
            return;
        }
        this.oKM.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        this.oKO.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
        this.oKP.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
    }
}
