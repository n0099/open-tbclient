package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.view.SafeFrameLayout;
/* loaded from: classes11.dex */
public class AddTimeEndGameView extends SafeFrameLayout implements View.OnClickListener {
    private View mView;
    private TextView oJZ;
    private TextView oKa;
    private TextView oKb;
    private TextView oKc;
    private a oKd;

    /* loaded from: classes11.dex */
    public interface a {
        int MB(int i);

        void eeH();

        void eeI();

        void eeJ();

        void eeK();
    }

    public AddTimeEndGameView(@NonNull Context context) {
        this(context, null);
    }

    public AddTimeEndGameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddTimeEndGameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
        initListener();
    }

    private void initListener() {
        this.oJZ.setOnClickListener(this);
        this.oKc.setOnClickListener(this);
        this.oKa.setOnClickListener(this);
        this.oKb.setOnClickListener(this);
        this.oKb.setSelected(true);
        this.oKa.setSelected(true);
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_add_time_end_game_layout, this);
        this.oJZ = (TextView) this.mView.findViewById(a.f.start_game);
        this.oKc = (TextView) this.mView.findViewById(a.f.add_time);
        this.oKa = (TextView) this.mView.findViewById(a.f.end_game);
        this.oKb = (TextView) this.mView.findViewById(a.f.next_activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oJZ) {
            if (this.oKd != null) {
                this.oKd.eeH();
            }
        } else if (view == this.oKc) {
            if (this.oKd != null) {
                this.oKd.eeI();
            }
        } else if (view == this.oKa) {
            if (this.oKd != null) {
                this.oKd.eeJ();
            }
        } else if (view == this.oKb && this.oKd != null) {
            this.oKd.eeK();
        }
    }

    public void setListener(a aVar) {
        this.oKd = aVar;
    }

    public void setButtonState(int i) {
        if (i == 0) {
            this.oJZ.setVisibility(0);
            this.oKc.setVisibility(8);
            this.oKa.setVisibility(8);
            this.oKb.setVisibility(8);
        } else if (i == 1) {
            this.oJZ.setVisibility(8);
            this.oKc.setVisibility(0);
            if (this.oKd != null) {
                this.oKc.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oKd.MB(i))));
            }
            this.oKa.setVisibility(8);
            this.oKb.setVisibility(0);
        } else if (i == 2) {
            this.oJZ.setVisibility(8);
            this.oKc.setVisibility(8);
            this.oKa.setVisibility(8);
            this.oKb.setVisibility(8);
        } else if (i == 3) {
            this.oJZ.setVisibility(8);
            this.oKc.setVisibility(0);
            if (this.oKd != null) {
                this.oKc.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oKd.MB(i))));
            }
            this.oKa.setVisibility(0);
            this.oKb.setVisibility(8);
        }
    }
}
