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
    private TextView oME;
    private TextView oMF;
    private TextView oMG;
    private TextView oMH;
    private a oMI;

    /* loaded from: classes10.dex */
    public interface a {
        int MG(int i);

        void eeX();

        void eeY();

        void eeZ();

        void efa();
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
        this.oME.setOnClickListener(this);
        this.oMH.setOnClickListener(this);
        this.oMF.setOnClickListener(this);
        this.oMG.setOnClickListener(this);
        this.oMG.setSelected(true);
        this.oMF.setSelected(true);
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_add_time_end_game_layout, this);
        this.oME = (TextView) this.mView.findViewById(a.f.start_game);
        this.oMH = (TextView) this.mView.findViewById(a.f.add_time);
        this.oMF = (TextView) this.mView.findViewById(a.f.end_game);
        this.oMG = (TextView) this.mView.findViewById(a.f.next_activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oME) {
            if (this.oMI != null) {
                this.oMI.eeX();
            }
        } else if (view == this.oMH) {
            if (this.oMI != null) {
                this.oMI.eeY();
            }
        } else if (view == this.oMF) {
            if (this.oMI != null) {
                this.oMI.eeZ();
            }
        } else if (view == this.oMG && this.oMI != null) {
            this.oMI.efa();
        }
    }

    public void setListener(a aVar) {
        this.oMI = aVar;
    }

    public void setButtonState(int i) {
        if (i == 0) {
            this.oME.setVisibility(0);
            this.oMH.setVisibility(8);
            this.oMF.setVisibility(8);
            this.oMG.setVisibility(8);
        } else if (i == 1) {
            this.oME.setVisibility(8);
            this.oMH.setVisibility(0);
            if (this.oMI != null) {
                this.oMH.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oMI.MG(i))));
            }
            this.oMF.setVisibility(8);
            this.oMG.setVisibility(0);
        } else if (i == 2) {
            this.oME.setVisibility(8);
            this.oMH.setVisibility(8);
            this.oMF.setVisibility(8);
            this.oMG.setVisibility(8);
        } else if (i == 3) {
            this.oME.setVisibility(8);
            this.oMH.setVisibility(0);
            if (this.oMI != null) {
                this.oMH.setText(String.format(getContext().getString(a.h.yuyin_ala_add_time_btn_text), Integer.valueOf(this.oMI.MG(i))));
            }
            this.oMF.setVisibility(0);
            this.oMG.setVisibility(8);
        }
    }
}
