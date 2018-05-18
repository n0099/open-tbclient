package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonTabView extends LinearLayout {
    private int alu;
    private int alv;
    private int dnd;
    private TextView fOB;
    private TextView fOC;
    private View fOD;
    private View fOE;
    private View fOF;
    private View fOG;
    private a fOH;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rk(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dnd = 0;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view2.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fOH != null) {
                    PersonTabView.this.fOH.rk(PersonTabView.this.dnd);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dnd = 0;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view2.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fOH != null) {
                    PersonTabView.this.fOH.rk(PersonTabView.this.dnd);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dnd = 0;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view2.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fOH != null) {
                    PersonTabView.this.fOH.rk(PersonTabView.this.dnd);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.i.person_button_header_view, this);
        this.fOB = (TextView) findViewById(d.g.main_thread_btn);
        this.fOB.setOnClickListener(this.mOnClickListener);
        this.fOC = (TextView) findViewById(d.g.reply_btn);
        this.fOC.setOnClickListener(this.mOnClickListener);
        this.fOD = findViewById(d.g.main_thread_divider);
        this.fOE = findViewById(d.g.reply_btn_divider);
        this.fOF = findViewById(d.g.main_thread_bottom_divider);
        this.fOG = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dnd) {
            this.dnd = i;
            if (i == 0) {
                this.fOD.setVisibility(0);
                this.fOE.setVisibility(4);
                this.fOB.setTextColor(this.alu);
                this.fOC.setTextColor(this.alv);
            } else if (i == 1) {
                this.fOD.setVisibility(4);
                this.fOE.setVisibility(0);
                this.fOB.setTextColor(this.alv);
                this.fOC.setTextColor(this.alu);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fOH = aVar;
    }
}
