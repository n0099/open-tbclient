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
    private int atS;
    private int atT;
    private int dCt;
    private TextView gef;
    private TextView geg;
    private View geh;
    private View gei;
    private View gej;
    private View gek;
    private a gel;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rC(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dCt = 0;
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gel != null) {
                    PersonTabView.this.gel.rC(PersonTabView.this.dCt);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dCt = 0;
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gel != null) {
                    PersonTabView.this.gel.rC(PersonTabView.this.dCt);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dCt = 0;
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gel != null) {
                    PersonTabView.this.gel.rC(PersonTabView.this.dCt);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.h.person_button_header_view, this);
        this.gef = (TextView) findViewById(d.g.main_thread_btn);
        this.gef.setOnClickListener(this.mOnClickListener);
        this.geg = (TextView) findViewById(d.g.reply_btn);
        this.geg.setOnClickListener(this.mOnClickListener);
        this.geh = findViewById(d.g.main_thread_divider);
        this.gei = findViewById(d.g.reply_btn_divider);
        this.gej = findViewById(d.g.main_thread_bottom_divider);
        this.gek = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dCt) {
            this.dCt = i;
            if (i == 0) {
                this.geh.setVisibility(0);
                this.gei.setVisibility(4);
                this.gef.setTextColor(this.atS);
                this.geg.setTextColor(this.atT);
            } else if (i == 1) {
                this.geh.setVisibility(4);
                this.gei.setVisibility(0);
                this.gef.setTextColor(this.atT);
                this.geg.setTextColor(this.atS);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gel = aVar;
    }
}
