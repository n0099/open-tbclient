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
    private a fjE;
    private TextView fjH;
    private TextView fjI;
    private View fjJ;
    private View fjK;
    private View fjL;
    private View fjM;
    private int fjN;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void qt(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fjN = 0;
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
                if (PersonTabView.this.fjE != null) {
                    PersonTabView.this.fjE.qt(PersonTabView.this.fjN);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjN = 0;
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
                if (PersonTabView.this.fjE != null) {
                    PersonTabView.this.fjE.qt(PersonTabView.this.fjN);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjN = 0;
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
                if (PersonTabView.this.fjE != null) {
                    PersonTabView.this.fjE.qt(PersonTabView.this.fjN);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, this);
        this.fjH = (TextView) findViewById(d.h.main_thread_btn);
        this.fjH.setOnClickListener(this.mOnClickListener);
        this.fjI = (TextView) findViewById(d.h.reply_btn);
        this.fjI.setOnClickListener(this.mOnClickListener);
        this.fjJ = findViewById(d.h.main_thread_divider);
        this.fjK = findViewById(d.h.reply_btn_divider);
        this.fjL = findViewById(d.h.main_thread_bottom_divider);
        this.fjM = findViewById(d.h.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fjN) {
            this.fjN = i;
            if (i == 0) {
                this.fjJ.setVisibility(0);
                this.fjK.setVisibility(4);
                this.fjH.setTextColor(this.aju);
                this.fjI.setTextColor(this.ajv);
            } else if (i == 1) {
                this.fjJ.setVisibility(4);
                this.fjK.setVisibility(0);
                this.fjH.setTextColor(this.ajv);
                this.fjI.setTextColor(this.aju);
            }
        }
    }

    public void onChangeSkinType() {
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_j);
        aj.j(this, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fjJ, d.e.cp_cont_b);
        aj.k(this.fjK, d.e.cp_cont_b);
        aj.k(this.fjL, d.e.cp_bg_line_c);
        aj.k(this.fjM, d.e.cp_bg_line_c);
        if (this.fjN == 0) {
            this.fjH.setTextColor(this.aju);
            this.fjI.setTextColor(this.ajv);
        } else if (this.fjN == 1) {
            this.fjH.setTextColor(this.ajv);
            this.fjI.setTextColor(this.aju);
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fjE = aVar;
    }
}
