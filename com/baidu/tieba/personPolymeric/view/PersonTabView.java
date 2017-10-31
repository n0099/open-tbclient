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
    private a fsc;
    private TextView fsf;
    private TextView fsg;
    private View fsh;
    private View fsi;
    private View fsj;
    private View fsk;
    private int fsl;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void qI(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fsl = 0;
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
                if (PersonTabView.this.fsc != null) {
                    PersonTabView.this.fsc.qI(PersonTabView.this.fsl);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fsl = 0;
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
                if (PersonTabView.this.fsc != null) {
                    PersonTabView.this.fsc.qI(PersonTabView.this.fsl);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fsl = 0;
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
                if (PersonTabView.this.fsc != null) {
                    PersonTabView.this.fsc.qI(PersonTabView.this.fsl);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.h.person_button_header_view, this);
        this.fsf = (TextView) findViewById(d.g.main_thread_btn);
        this.fsf.setOnClickListener(this.mOnClickListener);
        this.fsg = (TextView) findViewById(d.g.reply_btn);
        this.fsg.setOnClickListener(this.mOnClickListener);
        this.fsh = findViewById(d.g.main_thread_divider);
        this.fsi = findViewById(d.g.reply_btn_divider);
        this.fsj = findViewById(d.g.main_thread_bottom_divider);
        this.fsk = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fsl) {
            this.fsl = i;
            if (i == 0) {
                this.fsh.setVisibility(0);
                this.fsi.setVisibility(4);
                this.fsf.setTextColor(this.ajE);
                this.fsg.setTextColor(this.ajF);
            } else if (i == 1) {
                this.fsh.setVisibility(4);
                this.fsi.setVisibility(0);
                this.fsf.setTextColor(this.ajF);
                this.fsg.setTextColor(this.ajE);
            }
        }
    }

    public void onChangeSkinType() {
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        aj.j(this, d.f.item_person_header_attention_bg_selector);
        aj.j(this.fsh, d.f.roundline);
        aj.j(this.fsi, d.f.roundline);
        aj.k(this.fsj, d.C0080d.cp_bg_line_c);
        aj.k(this.fsk, d.C0080d.cp_bg_line_c);
        if (this.fsl == 0) {
            this.fsf.setTextColor(this.ajE);
            this.fsg.setTextColor(this.ajF);
        } else if (this.fsl == 1) {
            this.fsf.setTextColor(this.ajF);
            this.fsg.setTextColor(this.ajE);
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fsc = aVar;
    }
}
