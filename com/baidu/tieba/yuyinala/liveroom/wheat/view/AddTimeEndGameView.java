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
    private TextView oEU;
    private TextView oEV;
    private TextView oEW;
    private TextView oEX;
    private a oEY;

    /* loaded from: classes11.dex */
    public interface a {
        int NM(int i);

        void egl();

        void egm();

        void egn();

        void ego();
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
        this.oEU.setOnClickListener(this);
        this.oEX.setOnClickListener(this);
        this.oEV.setOnClickListener(this);
        this.oEW.setOnClickListener(this);
        this.oEW.setSelected(true);
        this.oEV.setSelected(true);
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_add_time_end_game_layout, this);
        this.oEU = (TextView) this.mView.findViewById(a.f.start_game);
        this.oEX = (TextView) this.mView.findViewById(a.f.add_time);
        this.oEV = (TextView) this.mView.findViewById(a.f.end_game);
        this.oEW = (TextView) this.mView.findViewById(a.f.next_activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oEU) {
            if (this.oEY != null) {
                this.oEY.egl();
            }
        } else if (view == this.oEX) {
            if (this.oEY != null) {
                this.oEY.egm();
            }
        } else if (view == this.oEV) {
            if (this.oEY != null) {
                this.oEY.egn();
            }
        } else if (view == this.oEW && this.oEY != null) {
            this.oEY.ego();
        }
    }

    public void setListener(a aVar) {
        this.oEY = aVar;
    }

    public void setButtonState(int i) {
        if (i == 0) {
            this.oEU.setVisibility(0);
            this.oEX.setVisibility(8);
            this.oEV.setVisibility(8);
            this.oEW.setVisibility(8);
        } else if (i == 1) {
            this.oEU.setVisibility(8);
            this.oEX.setVisibility(0);
            if (this.oEY != null) {
                this.oEX.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oEY.NM(i))));
            }
            this.oEV.setVisibility(8);
            this.oEW.setVisibility(0);
        } else if (i == 2) {
            this.oEU.setVisibility(8);
            this.oEX.setVisibility(8);
            this.oEV.setVisibility(8);
            this.oEW.setVisibility(8);
        } else if (i == 3) {
            this.oEU.setVisibility(8);
            this.oEX.setVisibility(0);
            if (this.oEY != null) {
                this.oEX.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oEY.NM(i))));
            }
            this.oEV.setVisibility(0);
            this.oEW.setVisibility(8);
        }
    }
}
