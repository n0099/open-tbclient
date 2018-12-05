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
    private int aGe;
    private int aGf;
    private int dYL;
    private TextView gBl;
    private TextView gBm;
    private View gBn;
    private View gBo;
    private View gBp;
    private View gBq;
    private a gBr;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void tj(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.dYL = 0;
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gBr != null) {
                    PersonTabView.this.gBr.tj(PersonTabView.this.dYL);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYL = 0;
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gBr != null) {
                    PersonTabView.this.gBr.tj(PersonTabView.this.dYL);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYL = 0;
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gBr != null) {
                    PersonTabView.this.gBr.tj(PersonTabView.this.dYL);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.gBl = (TextView) findViewById(e.g.main_thread_btn);
        this.gBl.setOnClickListener(this.mOnClickListener);
        this.gBm = (TextView) findViewById(e.g.reply_btn);
        this.gBm.setOnClickListener(this.mOnClickListener);
        this.gBn = findViewById(e.g.main_thread_divider);
        this.gBo = findViewById(e.g.reply_btn_divider);
        this.gBp = findViewById(e.g.main_thread_bottom_divider);
        this.gBq = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.dYL) {
            this.dYL = i;
            if (i == 0) {
                this.gBn.setVisibility(0);
                this.gBo.setVisibility(4);
                this.gBl.setTextColor(this.aGe);
                this.gBm.setTextColor(this.aGf);
            } else if (i == 1) {
                this.gBn.setVisibility(4);
                this.gBo.setVisibility(0);
                this.gBl.setTextColor(this.aGf);
                this.gBm.setTextColor(this.aGe);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gBr = aVar;
    }
}
