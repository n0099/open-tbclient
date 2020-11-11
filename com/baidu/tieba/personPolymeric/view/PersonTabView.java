package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonTabView extends LinearLayout {
    private int eRP;
    private int eRQ;
    private int jbO;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mhN;
    private TextView mhO;
    private View mhP;
    private View mhQ;
    private View mhR;
    private View mhS;
    private a mhT;

    /* loaded from: classes24.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jbO = 0;
        this.eRP = ap.getColor(R.color.cp_cont_b);
        this.eRQ = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mhT != null) {
                    PersonTabView.this.mhT.onTabSelect(PersonTabView.this.jbO);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jbO = 0;
        this.eRP = ap.getColor(R.color.cp_cont_b);
        this.eRQ = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mhT != null) {
                    PersonTabView.this.mhT.onTabSelect(PersonTabView.this.jbO);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jbO = 0;
        this.eRP = ap.getColor(R.color.cp_cont_b);
        this.eRQ = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mhT != null) {
                    PersonTabView.this.mhT.onTabSelect(PersonTabView.this.jbO);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mhN = (TextView) findViewById(R.id.main_thread_btn);
        this.mhN.setOnClickListener(this.mOnClickListener);
        this.mhO = (TextView) findViewById(R.id.reply_btn);
        this.mhO.setOnClickListener(this.mOnClickListener);
        this.mhP = findViewById(R.id.main_thread_divider);
        this.mhQ = findViewById(R.id.reply_btn_divider);
        this.mhR = findViewById(R.id.main_thread_bottom_divider);
        this.mhS = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jbO) {
            this.jbO = i;
            if (i == 0) {
                this.mhP.setVisibility(0);
                this.mhQ.setVisibility(4);
                this.mhN.setTextColor(this.eRP);
                this.mhO.setTextColor(this.eRQ);
            } else if (i == 1) {
                this.mhP.setVisibility(4);
                this.mhQ.setVisibility(0);
                this.mhN.setTextColor(this.eRQ);
                this.mhO.setTextColor(this.eRP);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mhT = aVar;
    }
}
