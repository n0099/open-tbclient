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
    private int axf;
    private int axg;
    private int dJg;
    private View glA;
    private a glB;
    private TextView glv;
    private TextView glw;
    private View glx;
    private View gly;
    private View glz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rZ(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dJg = 0;
        this.axf = al.getColor(e.d.cp_cont_b);
        this.axg = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.glB != null) {
                    PersonTabView.this.glB.rZ(PersonTabView.this.dJg);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJg = 0;
        this.axf = al.getColor(e.d.cp_cont_b);
        this.axg = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.glB != null) {
                    PersonTabView.this.glB.rZ(PersonTabView.this.dJg);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJg = 0;
        this.axf = al.getColor(e.d.cp_cont_b);
        this.axg = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.glB != null) {
                    PersonTabView.this.glB.rZ(PersonTabView.this.dJg);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.glv = (TextView) findViewById(e.g.main_thread_btn);
        this.glv.setOnClickListener(this.mOnClickListener);
        this.glw = (TextView) findViewById(e.g.reply_btn);
        this.glw.setOnClickListener(this.mOnClickListener);
        this.glx = findViewById(e.g.main_thread_divider);
        this.gly = findViewById(e.g.reply_btn_divider);
        this.glz = findViewById(e.g.main_thread_bottom_divider);
        this.glA = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dJg) {
            this.dJg = i;
            if (i == 0) {
                this.glx.setVisibility(0);
                this.gly.setVisibility(4);
                this.glv.setTextColor(this.axf);
                this.glw.setTextColor(this.axg);
            } else if (i == 1) {
                this.glx.setVisibility(4);
                this.gly.setVisibility(0);
                this.glv.setTextColor(this.axg);
                this.glw.setTextColor(this.axf);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.glB = aVar;
    }
}
