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
    private int aji;
    private int ajj;
    private a fjp;
    private TextView fjs;
    private TextView fjt;
    private View fju;
    private View fjv;
    private View fjw;
    private View fjx;
    private int fjy;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void qs(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fjy = 0;
        this.aji = aj.getColor(d.e.cp_cont_b);
        this.ajj = aj.getColor(d.e.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.h.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fjp != null) {
                    PersonTabView.this.fjp.qs(PersonTabView.this.fjy);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjy = 0;
        this.aji = aj.getColor(d.e.cp_cont_b);
        this.ajj = aj.getColor(d.e.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.h.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fjp != null) {
                    PersonTabView.this.fjp.qs(PersonTabView.this.fjy);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjy = 0;
        this.aji = aj.getColor(d.e.cp_cont_b);
        this.ajj = aj.getColor(d.e.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.h.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.h.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fjp != null) {
                    PersonTabView.this.fjp.qs(PersonTabView.this.fjy);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.j.person_button_header_view, this);
        this.fjs = (TextView) findViewById(d.h.main_thread_btn);
        this.fjs.setOnClickListener(this.mOnClickListener);
        this.fjt = (TextView) findViewById(d.h.reply_btn);
        this.fjt.setOnClickListener(this.mOnClickListener);
        this.fju = findViewById(d.h.main_thread_divider);
        this.fjv = findViewById(d.h.reply_btn_divider);
        this.fjw = findViewById(d.h.main_thread_bottom_divider);
        this.fjx = findViewById(d.h.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fjy) {
            this.fjy = i;
            if (i == 0) {
                this.fju.setVisibility(0);
                this.fjv.setVisibility(4);
                this.fjs.setTextColor(this.aji);
                this.fjt.setTextColor(this.ajj);
            } else if (i == 1) {
                this.fju.setVisibility(4);
                this.fjv.setVisibility(0);
                this.fjs.setTextColor(this.ajj);
                this.fjt.setTextColor(this.aji);
            }
        }
    }

    public void onChangeSkinType() {
        this.aji = aj.getColor(d.e.cp_cont_b);
        this.ajj = aj.getColor(d.e.cp_cont_j);
        aj.j(this, d.g.item_person_header_attention_bg_selector);
        aj.k(this.fju, d.e.cp_cont_b);
        aj.k(this.fjv, d.e.cp_cont_b);
        aj.k(this.fjw, d.e.cp_bg_line_c);
        aj.k(this.fjx, d.e.cp_bg_line_c);
        if (this.fjy == 0) {
            this.fjs.setTextColor(this.aji);
            this.fjt.setTextColor(this.ajj);
        } else if (this.fjy == 1) {
            this.fjs.setTextColor(this.ajj);
            this.fjt.setTextColor(this.aji);
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fjp = aVar;
    }
}
