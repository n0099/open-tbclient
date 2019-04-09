package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PersonTabView extends LinearLayout {
    private int bOT;
    private int bOU;
    private int fpA;
    private TextView hUT;
    private TextView hUU;
    private View hUV;
    private View hUW;
    private View hUX;
    private View hUY;
    private a hUZ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void xf(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fpA = 0;
        this.bOT = al.getColor(d.C0277d.cp_cont_b);
        this.bOU = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hUZ != null) {
                    PersonTabView.this.hUZ.xf(PersonTabView.this.fpA);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpA = 0;
        this.bOT = al.getColor(d.C0277d.cp_cont_b);
        this.bOU = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hUZ != null) {
                    PersonTabView.this.hUZ.xf(PersonTabView.this.fpA);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpA = 0;
        this.bOT = al.getColor(d.C0277d.cp_cont_b);
        this.bOU = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hUZ != null) {
                    PersonTabView.this.hUZ.xf(PersonTabView.this.fpA);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.h.person_button_header_view, this);
        this.hUT = (TextView) findViewById(d.g.main_thread_btn);
        this.hUT.setOnClickListener(this.mOnClickListener);
        this.hUU = (TextView) findViewById(d.g.reply_btn);
        this.hUU.setOnClickListener(this.mOnClickListener);
        this.hUV = findViewById(d.g.main_thread_divider);
        this.hUW = findViewById(d.g.reply_btn_divider);
        this.hUX = findViewById(d.g.main_thread_bottom_divider);
        this.hUY = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fpA) {
            this.fpA = i;
            if (i == 0) {
                this.hUV.setVisibility(0);
                this.hUW.setVisibility(4);
                this.hUT.setTextColor(this.bOT);
                this.hUU.setTextColor(this.bOU);
            } else if (i == 1) {
                this.hUV.setVisibility(4);
                this.hUW.setVisibility(0);
                this.hUT.setTextColor(this.bOU);
                this.hUU.setTextColor(this.bOT);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.hUZ = aVar;
    }
}
