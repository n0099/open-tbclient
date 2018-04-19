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
    private int dlZ;
    private View fNA;
    private View fNB;
    private View fNC;
    private View fND;
    private a fNE;
    private TextView fNy;
    private TextView fNz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rl(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dlZ = 0;
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
                if (PersonTabView.this.fNE != null) {
                    PersonTabView.this.fNE.rl(PersonTabView.this.dlZ);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dlZ = 0;
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
                if (PersonTabView.this.fNE != null) {
                    PersonTabView.this.fNE.rl(PersonTabView.this.dlZ);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dlZ = 0;
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
                if (PersonTabView.this.fNE != null) {
                    PersonTabView.this.fNE.rl(PersonTabView.this.dlZ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.i.person_button_header_view, this);
        this.fNy = (TextView) findViewById(d.g.main_thread_btn);
        this.fNy.setOnClickListener(this.mOnClickListener);
        this.fNz = (TextView) findViewById(d.g.reply_btn);
        this.fNz.setOnClickListener(this.mOnClickListener);
        this.fNA = findViewById(d.g.main_thread_divider);
        this.fNB = findViewById(d.g.reply_btn_divider);
        this.fNC = findViewById(d.g.main_thread_bottom_divider);
        this.fND = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dlZ) {
            this.dlZ = i;
            if (i == 0) {
                this.fNA.setVisibility(0);
                this.fNB.setVisibility(4);
                this.fNy.setTextColor(this.alu);
                this.fNz.setTextColor(this.alv);
            } else if (i == 1) {
                this.fNA.setVisibility(4);
                this.fNB.setVisibility(0);
                this.fNy.setTextColor(this.alv);
                this.fNz.setTextColor(this.alu);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fNE = aVar;
    }
}
