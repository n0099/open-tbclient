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
    private int aGH;
    private int aGI;
    private int eci;
    private TextView gFg;
    private TextView gFh;
    private View gFi;
    private View gFj;
    private View gFk;
    private View gFl;
    private a gFm;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void tA(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.eci = 0;
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gFm != null) {
                    PersonTabView.this.gFm.tA(PersonTabView.this.eci);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eci = 0;
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gFm != null) {
                    PersonTabView.this.gFm.tA(PersonTabView.this.eci);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eci = 0;
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == e.g.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.gFm != null) {
                    PersonTabView.this.gFm.tA(PersonTabView.this.eci);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(e.h.person_button_header_view, this);
        this.gFg = (TextView) findViewById(e.g.main_thread_btn);
        this.gFg.setOnClickListener(this.mOnClickListener);
        this.gFh = (TextView) findViewById(e.g.reply_btn);
        this.gFh.setOnClickListener(this.mOnClickListener);
        this.gFi = findViewById(e.g.main_thread_divider);
        this.gFj = findViewById(e.g.reply_btn_divider);
        this.gFk = findViewById(e.g.main_thread_bottom_divider);
        this.gFl = findViewById(e.g.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.eci) {
            this.eci = i;
            if (i == 0) {
                this.gFi.setVisibility(0);
                this.gFj.setVisibility(4);
                this.gFg.setTextColor(this.aGH);
                this.gFh.setTextColor(this.aGI);
            } else if (i == 1) {
                this.gFi.setVisibility(4);
                this.gFj.setVisibility(0);
                this.gFg.setTextColor(this.aGI);
                this.gFh.setTextColor(this.aGH);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.gFm = aVar;
    }
}
