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
    private int aBP;
    private int aBQ;
    private int dRe;
    private TextView gsV;
    private TextView gsW;
    private View gsX;
    private View gsY;
    private View gsZ;
    private View gta;
    private a gtb;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void sw(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dRe = 0;
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gtb != null) {
                    PersonTabView.this.gtb.sw(PersonTabView.this.dRe);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRe = 0;
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gtb != null) {
                    PersonTabView.this.gtb.sw(PersonTabView.this.dRe);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dRe = 0;
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gtb != null) {
                    PersonTabView.this.gtb.sw(PersonTabView.this.dRe);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.gsV = (TextView) findViewById(e.g.main_thread_btn);
        this.gsV.setOnClickListener(this.mOnClickListener);
        this.gsW = (TextView) findViewById(e.g.reply_btn);
        this.gsW.setOnClickListener(this.mOnClickListener);
        this.gsX = findViewById(e.g.main_thread_divider);
        this.gsY = findViewById(e.g.reply_btn_divider);
        this.gsZ = findViewById(e.g.main_thread_bottom_divider);
        this.gta = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dRe) {
            this.dRe = i;
            if (i == 0) {
                this.gsX.setVisibility(0);
                this.gsY.setVisibility(4);
                this.gsV.setTextColor(this.aBP);
                this.gsW.setTextColor(this.aBQ);
            } else if (i == 1) {
                this.gsX.setVisibility(4);
                this.gsY.setVisibility(0);
                this.gsV.setTextColor(this.aBQ);
                this.gsW.setTextColor(this.aBP);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gtb = aVar;
    }
}
