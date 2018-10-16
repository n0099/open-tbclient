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
    private int dRd;
    private TextView gsU;
    private TextView gsV;
    private View gsW;
    private View gsX;
    private View gsY;
    private View gsZ;
    private a gta;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void sw(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dRd = 0;
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
                if (PersonTabView.this.gta != null) {
                    PersonTabView.this.gta.sw(PersonTabView.this.dRd);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRd = 0;
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
                if (PersonTabView.this.gta != null) {
                    PersonTabView.this.gta.sw(PersonTabView.this.dRd);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dRd = 0;
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
                if (PersonTabView.this.gta != null) {
                    PersonTabView.this.gta.sw(PersonTabView.this.dRd);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.gsU = (TextView) findViewById(e.g.main_thread_btn);
        this.gsU.setOnClickListener(this.mOnClickListener);
        this.gsV = (TextView) findViewById(e.g.reply_btn);
        this.gsV.setOnClickListener(this.mOnClickListener);
        this.gsW = findViewById(e.g.main_thread_divider);
        this.gsX = findViewById(e.g.reply_btn_divider);
        this.gsY = findViewById(e.g.main_thread_bottom_divider);
        this.gsZ = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dRd) {
            this.dRd = i;
            if (i == 0) {
                this.gsW.setVisibility(0);
                this.gsX.setVisibility(4);
                this.gsU.setTextColor(this.aBP);
                this.gsV.setTextColor(this.aBQ);
            } else if (i == 1) {
                this.gsW.setVisibility(4);
                this.gsX.setVisibility(0);
                this.gsU.setTextColor(this.aBQ);
                this.gsV.setTextColor(this.aBP);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gta = aVar;
    }
}
