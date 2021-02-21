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
    private TextView oKA;
    private TextView oKB;
    private TextView oKC;
    private a oKD;
    private TextView oKz;

    /* loaded from: classes11.dex */
    public interface a {
        int MC(int i);

        void eeP();

        void eeQ();

        void eeR();

        void eeS();
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
        this.oKz.setOnClickListener(this);
        this.oKC.setOnClickListener(this);
        this.oKA.setOnClickListener(this);
        this.oKB.setOnClickListener(this);
        this.oKB.setSelected(true);
        this.oKA.setSelected(true);
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_add_time_end_game_layout, this);
        this.oKz = (TextView) this.mView.findViewById(a.f.start_game);
        this.oKC = (TextView) this.mView.findViewById(a.f.add_time);
        this.oKA = (TextView) this.mView.findViewById(a.f.end_game);
        this.oKB = (TextView) this.mView.findViewById(a.f.next_activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oKz) {
            if (this.oKD != null) {
                this.oKD.eeP();
            }
        } else if (view == this.oKC) {
            if (this.oKD != null) {
                this.oKD.eeQ();
            }
        } else if (view == this.oKA) {
            if (this.oKD != null) {
                this.oKD.eeR();
            }
        } else if (view == this.oKB && this.oKD != null) {
            this.oKD.eeS();
        }
    }

    public void setListener(a aVar) {
        this.oKD = aVar;
    }

    public void setButtonState(int i) {
        if (i == 0) {
            this.oKz.setVisibility(0);
            this.oKC.setVisibility(8);
            this.oKA.setVisibility(8);
            this.oKB.setVisibility(8);
        } else if (i == 1) {
            this.oKz.setVisibility(8);
            this.oKC.setVisibility(0);
            if (this.oKD != null) {
                this.oKC.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oKD.MC(i))));
            }
            this.oKA.setVisibility(8);
            this.oKB.setVisibility(0);
        } else if (i == 2) {
            this.oKz.setVisibility(8);
            this.oKC.setVisibility(8);
            this.oKA.setVisibility(8);
            this.oKB.setVisibility(8);
        } else if (i == 3) {
            this.oKz.setVisibility(8);
            this.oKC.setVisibility(0);
            if (this.oKD != null) {
                this.oKC.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oKD.MC(i))));
            }
            this.oKA.setVisibility(0);
            this.oKB.setVisibility(8);
        }
    }
}
