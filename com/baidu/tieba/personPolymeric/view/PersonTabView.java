package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonTabView extends LinearLayout {
    private int aju;
    private int ajv;
    private a fjD;
    private TextView fjG;
    private TextView fjH;
    private View fjI;
    private View fjJ;
    private View fjK;
    private View fjL;
    private int fjM;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void qt(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fjM = 0;
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.h.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fjD != null) {
                    PersonTabView.this.fjD.qt(PersonTabView.this.fjM);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjM = 0;
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.h.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fjD != null) {
                    PersonTabView.this.fjD.qt(PersonTabView.this.fjM);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjM = 0;
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.h.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fjD != null) {
                    PersonTabView.this.fjD.qt(PersonTabView.this.fjM);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, this);
        this.fjG = (TextView) findViewById(d.h.main_thread_btn);
        this.fjG.setOnClickListener(this.mOnClickListener);
        this.fjH = (TextView) findViewById(d.h.reply_btn);
        this.fjH.setOnClickListener(this.mOnClickListener);
        this.fjI = findViewById(d.h.main_thread_divider);
        this.fjJ = findViewById(d.h.reply_btn_divider);
        this.fjK = findViewById(d.h.main_thread_bottom_divider);
        this.fjL = findViewById(d.h.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fjM) {
            this.fjM = i;
            if (i == 0) {
                this.fjI.setVisibility(0);
                this.fjJ.setVisibility(4);
                this.fjG.setTextColor(this.aju);
                this.fjH.setTextColor(this.ajv);
            } else if (i == 1) {
                this.fjI.setVisibility(4);
                this.fjJ.setVisibility(0);
                this.fjG.setTextColor(this.ajv);
                this.fjH.setTextColor(this.aju);
            }
        }
    }

    public void onChangeSkinType() {
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_j);
        aj.j(this, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fjI, d.e.cp_cont_b);
        aj.k(this.fjJ, d.e.cp_cont_b);
        aj.k(this.fjK, d.e.cp_bg_line_c);
        aj.k(this.fjL, d.e.cp_bg_line_c);
        if (this.fjM == 0) {
            this.fjG.setTextColor(this.aju);
            this.fjH.setTextColor(this.ajv);
        } else if (this.fjM == 1) {
            this.fjG.setTextColor(this.ajv);
            this.fjH.setTextColor(this.aju);
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fjD = aVar;
    }
}
