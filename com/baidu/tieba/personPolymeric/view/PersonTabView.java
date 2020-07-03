package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonTabView extends LinearLayout {
    private int dXd;
    private int dZx;
    private int hSW;
    private TextView kRK;
    private TextView kRL;
    private View kRM;
    private View kRN;
    private View kRO;
    private View kRP;
    private a kRQ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hSW = 0;
        this.dZx = an.getColor(R.color.cp_cont_b);
        this.dXd = an.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.kRQ != null) {
                    PersonTabView.this.kRQ.onTabSelect(PersonTabView.this.hSW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSW = 0;
        this.dZx = an.getColor(R.color.cp_cont_b);
        this.dXd = an.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.kRQ != null) {
                    PersonTabView.this.kRQ.onTabSelect(PersonTabView.this.hSW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSW = 0;
        this.dZx = an.getColor(R.color.cp_cont_b);
        this.dXd = an.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.kRQ != null) {
                    PersonTabView.this.kRQ.onTabSelect(PersonTabView.this.hSW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.kRK = (TextView) findViewById(R.id.main_thread_btn);
        this.kRK.setOnClickListener(this.mOnClickListener);
        this.kRL = (TextView) findViewById(R.id.reply_btn);
        this.kRL.setOnClickListener(this.mOnClickListener);
        this.kRM = findViewById(R.id.main_thread_divider);
        this.kRN = findViewById(R.id.reply_btn_divider);
        this.kRO = findViewById(R.id.main_thread_bottom_divider);
        this.kRP = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hSW) {
            this.hSW = i;
            if (i == 0) {
                this.kRM.setVisibility(0);
                this.kRN.setVisibility(4);
                this.kRK.setTextColor(this.dZx);
                this.kRL.setTextColor(this.dXd);
            } else if (i == 1) {
                this.kRM.setVisibility(4);
                this.kRN.setVisibility(0);
                this.kRK.setTextColor(this.dXd);
                this.kRL.setTextColor(this.dZx);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.kRQ = aVar;
    }
}
