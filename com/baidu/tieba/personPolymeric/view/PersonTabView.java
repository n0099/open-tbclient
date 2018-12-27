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
    private int aGf;
    private int aGg;
    private int ebC;
    private TextView gEc;
    private TextView gEd;
    private View gEe;
    private View gEf;
    private View gEg;
    private View gEh;
    private a gEi;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void tw(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.ebC = 0;
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gEi != null) {
                    PersonTabView.this.gEi.tw(PersonTabView.this.ebC);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ebC = 0;
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gEi != null) {
                    PersonTabView.this.gEi.tw(PersonTabView.this.ebC);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ebC = 0;
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gEi != null) {
                    PersonTabView.this.gEi.tw(PersonTabView.this.ebC);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.gEc = (TextView) findViewById(e.g.main_thread_btn);
        this.gEc.setOnClickListener(this.mOnClickListener);
        this.gEd = (TextView) findViewById(e.g.reply_btn);
        this.gEd.setOnClickListener(this.mOnClickListener);
        this.gEe = findViewById(e.g.main_thread_divider);
        this.gEf = findViewById(e.g.reply_btn_divider);
        this.gEg = findViewById(e.g.main_thread_bottom_divider);
        this.gEh = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.ebC) {
            this.ebC = i;
            if (i == 0) {
                this.gEe.setVisibility(0);
                this.gEf.setVisibility(4);
                this.gEc.setTextColor(this.aGf);
                this.gEd.setTextColor(this.aGg);
            } else if (i == 1) {
                this.gEe.setVisibility(4);
                this.gEf.setVisibility(0);
                this.gEc.setTextColor(this.aGg);
                this.gEd.setTextColor(this.aGf);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gEi = aVar;
    }
}
