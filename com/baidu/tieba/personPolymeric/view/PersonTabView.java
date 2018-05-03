package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonTabView extends LinearLayout {
    private int alu;
    private int alv;
    private int dlW;
    private View fNA;
    private a fNB;
    private TextView fNv;
    private TextView fNw;
    private View fNx;
    private View fNy;
    private View fNz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void rl(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dlW = 0;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view2.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fNB != null) {
                    PersonTabView.this.fNB.rl(PersonTabView.this.dlW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dlW = 0;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view2.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fNB != null) {
                    PersonTabView.this.fNB.rl(PersonTabView.this.dlW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dlW = 0;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view2.getId() == d.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.fNB != null) {
                    PersonTabView.this.fNB.rl(PersonTabView.this.dlW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(d.i.person_button_header_view, this);
        this.fNv = (TextView) findViewById(d.g.main_thread_btn);
        this.fNv.setOnClickListener(this.mOnClickListener);
        this.fNw = (TextView) findViewById(d.g.reply_btn);
        this.fNw.setOnClickListener(this.mOnClickListener);
        this.fNx = findViewById(d.g.main_thread_divider);
        this.fNy = findViewById(d.g.reply_btn_divider);
        this.fNz = findViewById(d.g.main_thread_bottom_divider);
        this.fNA = findViewById(d.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dlW) {
            this.dlW = i;
            if (i == 0) {
                this.fNx.setVisibility(0);
                this.fNy.setVisibility(4);
                this.fNv.setTextColor(this.alu);
                this.fNw.setTextColor(this.alv);
            } else if (i == 1) {
                this.fNx.setVisibility(4);
                this.fNy.setVisibility(0);
                this.fNv.setTextColor(this.alv);
                this.fNw.setTextColor(this.alu);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.fNB = aVar;
    }
}
