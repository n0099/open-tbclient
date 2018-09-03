package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class PersonTabView extends LinearLayout {
    private int atT;
    private int atU;
    private int dCq;
    private TextView gee;
    private TextView gef;
    private View geg;
    private View geh;
    private View gei;
    private View gej;
    private a gek;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rC(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dCq = 0;
        this.atT = am.getColor(f.d.cp_cont_b);
        this.atU = am.getColor(f.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == f.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gek != null) {
                    PersonTabView.this.gek.rC(PersonTabView.this.dCq);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dCq = 0;
        this.atT = am.getColor(f.d.cp_cont_b);
        this.atU = am.getColor(f.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == f.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gek != null) {
                    PersonTabView.this.gek.rC(PersonTabView.this.dCq);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dCq = 0;
        this.atT = am.getColor(f.d.cp_cont_b);
        this.atU = am.getColor(f.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == f.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gek != null) {
                    PersonTabView.this.gek.rC(PersonTabView.this.dCq);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(f.h.person_button_header_view, this);
        this.gee = (TextView) findViewById(f.g.main_thread_btn);
        this.gee.setOnClickListener(this.mOnClickListener);
        this.gef = (TextView) findViewById(f.g.reply_btn);
        this.gef.setOnClickListener(this.mOnClickListener);
        this.geg = findViewById(f.g.main_thread_divider);
        this.geh = findViewById(f.g.reply_btn_divider);
        this.gei = findViewById(f.g.main_thread_bottom_divider);
        this.gej = findViewById(f.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dCq) {
            this.dCq = i;
            if (i == 0) {
                this.geg.setVisibility(0);
                this.geh.setVisibility(4);
                this.gee.setTextColor(this.atT);
                this.gef.setTextColor(this.atU);
            } else if (i == 1) {
                this.geg.setVisibility(4);
                this.geh.setVisibility(0);
                this.gee.setTextColor(this.atU);
                this.gef.setTextColor(this.atT);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gek = aVar;
    }
}
