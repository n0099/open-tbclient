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
    private TextView oAp;
    private TextView oAq;
    private TextView oAr;
    private TextView oAs;
    private a oAt;

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
        this.oAp.setOnClickListener(this);
        this.oAs.setOnClickListener(this);
        this.oAq.setOnClickListener(this);
        this.oAr.setOnClickListener(this);
        this.oAr.setSelected(true);
        this.oAq.setSelected(true);
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_add_time_end_game_layout, this);
        this.oAp = (TextView) this.mView.findViewById(a.f.start_game);
        this.oAs = (TextView) this.mView.findViewById(a.f.add_time);
        this.oAq = (TextView) this.mView.findViewById(a.f.end_game);
        this.oAr = (TextView) this.mView.findViewById(a.f.next_activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oAp) {
            if (this.oAt != null) {
                this.oAt.ect();
            }
        } else if (view == this.oAs) {
            if (this.oAt != null) {
                this.oAt.ecu();
            }
        } else if (view == this.oAq) {
            if (this.oAt != null) {
                this.oAt.ecv();
            }
        } else if (view == this.oAr && this.oAt != null) {
            this.oAt.ecw();
        }
    }

    public void setListener(a aVar) {
        this.oAt = aVar;
    }

    public void setButtonState(int i) {
        if (i == 0) {
            this.oAp.setVisibility(0);
            this.oAs.setVisibility(8);
            this.oAq.setVisibility(8);
            this.oAr.setVisibility(8);
        } else if (i == 1) {
            this.oAp.setVisibility(8);
            this.oAs.setVisibility(0);
            if (this.oAt != null) {
                this.oAs.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oAt.Mf(i))));
            }
            this.oAq.setVisibility(8);
            this.oAr.setVisibility(0);
        } else if (i == 2) {
            this.oAp.setVisibility(8);
            this.oAs.setVisibility(8);
            this.oAq.setVisibility(8);
            this.oAr.setVisibility(8);
        } else if (i == 3) {
            this.oAp.setVisibility(8);
            this.oAs.setVisibility(0);
            if (this.oAt != null) {
                this.oAs.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oAt.Mf(i))));
            }
            this.oAq.setVisibility(0);
            this.oAr.setVisibility(8);
        }
    }
}
