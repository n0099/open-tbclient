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
    private int aGI;
    private int aGJ;
    private int ecj;
    private TextView gFh;
    private TextView gFi;
    private View gFj;
    private View gFk;
    private View gFl;
    private View gFm;
    private a gFn;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void tA(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.ecj = 0;
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gFn != null) {
                    PersonTabView.this.gFn.tA(PersonTabView.this.ecj);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ecj = 0;
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gFn != null) {
                    PersonTabView.this.gFn.tA(PersonTabView.this.ecj);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ecj = 0;
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gFn != null) {
                    PersonTabView.this.gFn.tA(PersonTabView.this.ecj);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.gFh = (TextView) findViewById(e.g.main_thread_btn);
        this.gFh.setOnClickListener(this.mOnClickListener);
        this.gFi = (TextView) findViewById(e.g.reply_btn);
        this.gFi.setOnClickListener(this.mOnClickListener);
        this.gFj = findViewById(e.g.main_thread_divider);
        this.gFk = findViewById(e.g.reply_btn_divider);
        this.gFl = findViewById(e.g.main_thread_bottom_divider);
        this.gFm = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.ecj) {
            this.ecj = i;
            if (i == 0) {
                this.gFj.setVisibility(0);
                this.gFk.setVisibility(4);
                this.gFh.setTextColor(this.aGI);
                this.gFi.setTextColor(this.aGJ);
            } else if (i == 1) {
                this.gFj.setVisibility(4);
                this.gFk.setVisibility(0);
                this.gFh.setTextColor(this.aGJ);
                this.gFi.setTextColor(this.aGI);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gFn = aVar;
    }
}
