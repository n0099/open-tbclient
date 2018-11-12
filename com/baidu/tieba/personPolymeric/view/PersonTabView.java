package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonTabView extends LinearLayout {
    private int aCE;
    private int aCF;
    private int dSj;
    private View guA;
    private a guB;
    private TextView guv;
    private TextView guw;
    private View gux;
    private View guy;
    private View guz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void sP(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dSj = 0;
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.guB != null) {
                    PersonTabView.this.guB.sP(PersonTabView.this.dSj);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSj = 0;
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.guB != null) {
                    PersonTabView.this.guB.sP(PersonTabView.this.dSj);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSj = 0;
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.guB != null) {
                    PersonTabView.this.guB.sP(PersonTabView.this.dSj);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.guv = (TextView) findViewById(e.g.main_thread_btn);
        this.guv.setOnClickListener(this.mOnClickListener);
        this.guw = (TextView) findViewById(e.g.reply_btn);
        this.guw.setOnClickListener(this.mOnClickListener);
        this.gux = findViewById(e.g.main_thread_divider);
        this.guy = findViewById(e.g.reply_btn_divider);
        this.guz = findViewById(e.g.main_thread_bottom_divider);
        this.guA = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dSj) {
            this.dSj = i;
            if (i == 0) {
                this.gux.setVisibility(0);
                this.guy.setVisibility(4);
                this.guv.setTextColor(this.aCE);
                this.guw.setTextColor(this.aCF);
            } else if (i == 1) {
                this.gux.setVisibility(4);
                this.guy.setVisibility(0);
                this.guv.setTextColor(this.aCF);
                this.guw.setTextColor(this.aCE);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.guB = aVar;
    }
}
