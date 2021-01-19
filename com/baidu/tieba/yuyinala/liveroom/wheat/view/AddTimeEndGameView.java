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
/* loaded from: classes10.dex */
public class AddTimeEndGameView extends SafeFrameLayout implements View.OnClickListener {
    private View mView;
    private TextView oAq;
    private TextView oAr;
    private TextView oAs;
    private TextView oAt;
    private a oAu;

    /* loaded from: classes10.dex */
    public interface a {
        int Mf(int i);

        void ect();

        void ecu();

        void ecv();

        void ecw();
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
        this.oAq.setOnClickListener(this);
        this.oAt.setOnClickListener(this);
        this.oAr.setOnClickListener(this);
        this.oAs.setOnClickListener(this);
        this.oAs.setSelected(true);
        this.oAr.setSelected(true);
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_add_time_end_game_layout, this);
        this.oAq = (TextView) this.mView.findViewById(a.f.start_game);
        this.oAt = (TextView) this.mView.findViewById(a.f.add_time);
        this.oAr = (TextView) this.mView.findViewById(a.f.end_game);
        this.oAs = (TextView) this.mView.findViewById(a.f.next_activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oAq) {
            if (this.oAu != null) {
                this.oAu.ect();
            }
        } else if (view == this.oAt) {
            if (this.oAu != null) {
                this.oAu.ecu();
            }
        } else if (view == this.oAr) {
            if (this.oAu != null) {
                this.oAu.ecv();
            }
        } else if (view == this.oAs && this.oAu != null) {
            this.oAu.ecw();
        }
    }

    public void setListener(a aVar) {
        this.oAu = aVar;
    }

    public void setButtonState(int i) {
        if (i == 0) {
            this.oAq.setVisibility(0);
            this.oAt.setVisibility(8);
            this.oAr.setVisibility(8);
            this.oAs.setVisibility(8);
        } else if (i == 1) {
            this.oAq.setVisibility(8);
            this.oAt.setVisibility(0);
            if (this.oAu != null) {
                this.oAt.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oAu.Mf(i))));
            }
            this.oAr.setVisibility(8);
            this.oAs.setVisibility(0);
        } else if (i == 2) {
            this.oAq.setVisibility(8);
            this.oAt.setVisibility(8);
            this.oAr.setVisibility(8);
            this.oAs.setVisibility(8);
        } else if (i == 3) {
            this.oAq.setVisibility(8);
            this.oAt.setVisibility(0);
            if (this.oAu != null) {
                this.oAt.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oAu.Mf(i))));
            }
            this.oAr.setVisibility(0);
            this.oAs.setVisibility(8);
        }
    }
}
