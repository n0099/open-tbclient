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
    private int bOS;
    private int bOT;
    private int fpA;
    private TextView hUS;
    private TextView hUT;
    private View hUU;
    private View hUV;
    private View hUW;
    private View hUX;
    private a hUY;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void xf(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fpA = 0;
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hUY != null) {
                    PersonTabView.this.hUY.xf(PersonTabView.this.fpA);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpA = 0;
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hUY != null) {
                    PersonTabView.this.hUY.xf(PersonTabView.this.fpA);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpA = 0;
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hUY != null) {
                    PersonTabView.this.hUY.xf(PersonTabView.this.fpA);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.h.person_button_header_view, this);
        this.hUS = (TextView) findViewById(d.g.main_thread_btn);
        this.hUS.setOnClickListener(this.mOnClickListener);
        this.hUT = (TextView) findViewById(d.g.reply_btn);
        this.hUT.setOnClickListener(this.mOnClickListener);
        this.hUU = findViewById(d.g.main_thread_divider);
        this.hUV = findViewById(d.g.reply_btn_divider);
        this.hUW = findViewById(d.g.main_thread_bottom_divider);
        this.hUX = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fpA) {
            this.fpA = i;
            if (i == 0) {
                this.hUU.setVisibility(0);
                this.hUV.setVisibility(4);
                this.hUS.setTextColor(this.bOS);
                this.hUT.setTextColor(this.bOT);
            } else if (i == 1) {
                this.hUU.setVisibility(4);
                this.hUV.setVisibility(0);
                this.hUS.setTextColor(this.bOT);
                this.hUT.setTextColor(this.bOS);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.hUY = aVar;
    }
}
