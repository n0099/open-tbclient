package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonTabView extends LinearLayout {
    private int atB;
    private int atC;
    private int dwv;
    private TextView fZN;
    private TextView fZO;
    private View fZP;
    private View fZQ;
    private View fZR;
    private View fZS;
    private a fZT;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rw(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dwv = 0;
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fZT != null) {
                    PersonTabView.this.fZT.rw(PersonTabView.this.dwv);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwv = 0;
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fZT != null) {
                    PersonTabView.this.fZT.rw(PersonTabView.this.dwv);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwv = 0;
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fZT != null) {
                    PersonTabView.this.fZT.rw(PersonTabView.this.dwv);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.i.person_button_header_view, this);
        this.fZN = (TextView) findViewById(d.g.main_thread_btn);
        this.fZN.setOnClickListener(this.mOnClickListener);
        this.fZO = (TextView) findViewById(d.g.reply_btn);
        this.fZO.setOnClickListener(this.mOnClickListener);
        this.fZP = findViewById(d.g.main_thread_divider);
        this.fZQ = findViewById(d.g.reply_btn_divider);
        this.fZR = findViewById(d.g.main_thread_bottom_divider);
        this.fZS = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dwv) {
            this.dwv = i;
            if (i == 0) {
                this.fZP.setVisibility(0);
                this.fZQ.setVisibility(4);
                this.fZN.setTextColor(this.atB);
                this.fZO.setTextColor(this.atC);
            } else if (i == 1) {
                this.fZP.setVisibility(4);
                this.fZQ.setVisibility(0);
                this.fZN.setTextColor(this.atC);
                this.fZO.setTextColor(this.atB);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fZT = aVar;
    }
}
