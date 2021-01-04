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
/* loaded from: classes11.dex */
public class ConnectionWheatButtonView extends SafeFrameLayout implements View.OnClickListener {
    private TextView oFH;
    private LinearLayout oFI;
    private TextView oFJ;
    private TextView oFK;
    private a oFL;

    /* loaded from: classes11.dex */
    public interface a {
        void efB();

        void efC();

        void efD();
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
        this.oFH.setOnClickListener(this);
        this.oFJ.setOnClickListener(this);
        this.oFK.setOnClickListener(this);
        this.oFH.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oFJ.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oFK.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_button_view, this);
        this.oFH = (TextView) inflate.findViewById(a.f.tv_apply_default_wheat_btn);
        this.oFI = (LinearLayout) inflate.findViewById(a.f.team_fright_connection_wheat_button_container);
        this.oFJ = (TextView) inflate.findViewById(a.f.tv_apply_red_team_btn);
        this.oFK = (TextView) inflate.findViewById(a.f.tv_apply_blue_team_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oFH) {
            if (this.oFL != null) {
                this.oFL.efB();
            }
        } else if (view == this.oFJ) {
            if (this.oFL != null) {
                this.oFL.efC();
            }
        } else if (view == this.oFK && this.oFL != null) {
            this.oFL.efD();
        }
    }

    public void setListener(a aVar) {
        this.oFL = aVar;
    }

    public void init() {
        if (o.eff().efv()) {
            this.oFH.setVisibility(8);
            this.oFI.setVisibility(0);
        } else {
            this.oFH.setVisibility(0);
            this.oFI.setVisibility(8);
        }
        this.oFJ.setSelected(false);
        this.oFK.setSelected(true);
    }

    public void aj(int i, int i2, int i3) {
        init();
        this.oFJ.setEnabled(true);
        this.oFK.setEnabled(true);
        this.oFJ.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_red_shape);
        this.oFK.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_blue_shape);
        this.oFJ.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oFK.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        if (i > 0) {
            if (i2 > 0) {
                this.oFH.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                if (i3 < 5) {
                    this.oFK.setEnabled(false);
                    this.oFK.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                    this.oFK.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                    this.oFJ.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                    this.oFK.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
                    return;
                }
                this.oFJ.setEnabled(false);
                this.oFJ.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                this.oFJ.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                this.oFJ.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
                this.oFK.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                return;
            }
            this.oFH.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.oFJ.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
            this.oFK.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
            return;
        }
        this.oFH.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        this.oFJ.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
        this.oFK.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
    }
}
