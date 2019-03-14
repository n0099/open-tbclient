package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PersonTabView extends LinearLayout {
    private int bOQ;
    private int bOR;
    private int fpO;
    private TextView hVg;
    private TextView hVh;
    private View hVi;
    private View hVj;
    private View hVk;
    private View hVl;
    private a hVm;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void xj(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fpO = 0;
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hVm != null) {
                    PersonTabView.this.hVm.xj(PersonTabView.this.fpO);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpO = 0;
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hVm != null) {
                    PersonTabView.this.hVm.xj(PersonTabView.this.fpO);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpO = 0;
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.hVm != null) {
                    PersonTabView.this.hVm.xj(PersonTabView.this.fpO);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.h.person_button_header_view, this);
        this.hVg = (TextView) findViewById(d.g.main_thread_btn);
        this.hVg.setOnClickListener(this.mOnClickListener);
        this.hVh = (TextView) findViewById(d.g.reply_btn);
        this.hVh.setOnClickListener(this.mOnClickListener);
        this.hVi = findViewById(d.g.main_thread_divider);
        this.hVj = findViewById(d.g.reply_btn_divider);
        this.hVk = findViewById(d.g.main_thread_bottom_divider);
        this.hVl = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fpO) {
            this.fpO = i;
            if (i == 0) {
                this.hVi.setVisibility(0);
                this.hVj.setVisibility(4);
                this.hVg.setTextColor(this.bOQ);
                this.hVh.setTextColor(this.bOR);
            } else if (i == 1) {
                this.hVi.setVisibility(4);
                this.hVj.setVisibility(0);
                this.hVg.setTextColor(this.bOR);
                this.hVh.setTextColor(this.bOQ);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.hVm = aVar;
    }
}
