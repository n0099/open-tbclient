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
    private TextView oFG;
    private LinearLayout oFH;
    private TextView oFI;
    private TextView oFJ;
    private a oFK;

    /* loaded from: classes11.dex */
    public interface a {
        void efC();

        void efD();

        void efE();
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
        this.oFG.setOnClickListener(this);
        this.oFI.setOnClickListener(this);
        this.oFJ.setOnClickListener(this);
        this.oFG.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oFI.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oFJ.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.yuyin_layout_dialog_connection_wheat_button_view, this);
        this.oFG = (TextView) inflate.findViewById(a.f.tv_apply_default_wheat_btn);
        this.oFH = (LinearLayout) inflate.findViewById(a.f.team_fright_connection_wheat_button_container);
        this.oFI = (TextView) inflate.findViewById(a.f.tv_apply_red_team_btn);
        this.oFJ = (TextView) inflate.findViewById(a.f.tv_apply_blue_team_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oFG) {
            if (this.oFK != null) {
                this.oFK.efC();
            }
        } else if (view == this.oFI) {
            if (this.oFK != null) {
                this.oFK.efD();
            }
        } else if (view == this.oFJ && this.oFK != null) {
            this.oFK.efE();
        }
    }

    public void setListener(a aVar) {
        this.oFK = aVar;
    }

    public void init() {
        if (o.efg().efw()) {
            this.oFG.setVisibility(8);
            this.oFH.setVisibility(0);
        } else {
            this.oFG.setVisibility(0);
            this.oFH.setVisibility(8);
        }
        this.oFI.setSelected(false);
        this.oFJ.setSelected(true);
    }

    public void aj(int i, int i2, int i3) {
        init();
        this.oFI.setEnabled(true);
        this.oFJ.setEnabled(true);
        this.oFI.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_red_shape);
        this.oFJ.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_apply_btn_blue_shape);
        this.oFI.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oFJ.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        if (i > 0) {
            if (i2 > 0) {
                this.oFG.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                if (i3 < 5) {
                    this.oFJ.setEnabled(false);
                    this.oFJ.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                    this.oFJ.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                    this.oFI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                    this.oFJ.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
                    return;
                }
                this.oFI.setEnabled(false);
                this.oFI.setTextColor(getContext().getResources().getColor(a.c.sdk_color_B8B8B8));
                this.oFI.setBackgroundResource(a.e.yuyin_sdk_wheat_connection_wheat_button_gray_bg);
                this.oFI.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
                this.oFJ.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                return;
            }
            this.oFG.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.oFI.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
            this.oFJ.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
            return;
        }
        this.oFG.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        this.oFI.setText(getContext().getString(a.h.yuyin_ala_apply_red_team_btn));
        this.oFJ.setText(getContext().getString(a.h.yuyin_ala_apply_blue_team_btn));
    }
}
