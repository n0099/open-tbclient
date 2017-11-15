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
    private int ajE;
    private int ajF;
    private TextView fsC;
    private TextView fsD;
    private View fsE;
    private View fsF;
    private View fsG;
    private View fsH;
    private int fsI;
    private a fsz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void qJ(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fsI = 0;
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fsz != null) {
                    PersonTabView.this.fsz.qJ(PersonTabView.this.fsI);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fsI = 0;
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fsz != null) {
                    PersonTabView.this.fsz.qJ(PersonTabView.this.fsI);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fsI = 0;
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fsz != null) {
                    PersonTabView.this.fsz.qJ(PersonTabView.this.fsI);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.h.person_button_header_view, this);
        this.fsC = (TextView) findViewById(d.g.main_thread_btn);
        this.fsC.setOnClickListener(this.mOnClickListener);
        this.fsD = (TextView) findViewById(d.g.reply_btn);
        this.fsD.setOnClickListener(this.mOnClickListener);
        this.fsE = findViewById(d.g.main_thread_divider);
        this.fsF = findViewById(d.g.reply_btn_divider);
        this.fsG = findViewById(d.g.main_thread_bottom_divider);
        this.fsH = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fsI) {
            this.fsI = i;
            if (i == 0) {
                this.fsE.setVisibility(0);
                this.fsF.setVisibility(4);
                this.fsC.setTextColor(this.ajE);
                this.fsD.setTextColor(this.ajF);
            } else if (i == 1) {
                this.fsE.setVisibility(4);
                this.fsF.setVisibility(0);
                this.fsC.setTextColor(this.ajF);
                this.fsD.setTextColor(this.ajE);
            }
        }
    }

    public void onChangeSkinType() {
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        aj.j(this, d.f.item_person_header_attention_bg_selector);
        aj.j(this.fsE, d.f.roundline);
        aj.j(this.fsF, d.f.roundline);
        aj.k(this.fsG, d.C0080d.cp_bg_line_c);
        aj.k(this.fsH, d.C0080d.cp_bg_line_c);
        if (this.fsI == 0) {
            this.fsC.setTextColor(this.ajE);
            this.fsD.setTextColor(this.ajF);
        } else if (this.fsI == 1) {
            this.fsC.setTextColor(this.ajF);
            this.fsD.setTextColor(this.ajE);
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fsz = aVar;
    }
}
