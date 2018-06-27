package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonTabView extends LinearLayout {
    private int aun;
    private int auo;
    private int dzH;
    private TextView gdN;
    private TextView gdO;
    private View gdP;
    private View gdQ;
    private View gdR;
    private View gdS;
    private a gdT;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rF(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dzH = 0;
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gdT != null) {
                    PersonTabView.this.gdT.rF(PersonTabView.this.dzH);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzH = 0;
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gdT != null) {
                    PersonTabView.this.gdT.rF(PersonTabView.this.dzH);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzH = 0;
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gdT != null) {
                    PersonTabView.this.gdT.rF(PersonTabView.this.dzH);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.i.person_button_header_view, this);
        this.gdN = (TextView) findViewById(d.g.main_thread_btn);
        this.gdN.setOnClickListener(this.mOnClickListener);
        this.gdO = (TextView) findViewById(d.g.reply_btn);
        this.gdO.setOnClickListener(this.mOnClickListener);
        this.gdP = findViewById(d.g.main_thread_divider);
        this.gdQ = findViewById(d.g.reply_btn_divider);
        this.gdR = findViewById(d.g.main_thread_bottom_divider);
        this.gdS = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dzH) {
            this.dzH = i;
            if (i == 0) {
                this.gdP.setVisibility(0);
                this.gdQ.setVisibility(4);
                this.gdN.setTextColor(this.aun);
                this.gdO.setTextColor(this.auo);
            } else if (i == 1) {
                this.gdP.setVisibility(4);
                this.gdQ.setVisibility(0);
                this.gdN.setTextColor(this.auo);
                this.gdO.setTextColor(this.aun);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gdT = aVar;
    }
}
