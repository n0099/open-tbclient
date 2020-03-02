package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonTabView extends LinearLayout {
    private int deq;
    private int der;
    private TextView jsT;
    private TextView jsU;
    private View jsV;
    private View jsW;
    private View jsX;
    private View jsY;
    private a jsZ;
    private Context mContext;
    private int mCurrentTab;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void Ai(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.mCurrentTab = 0;
        this.deq = am.getColor(R.color.cp_cont_b);
        this.der = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsZ != null) {
                    PersonTabView.this.jsZ.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTab = 0;
        this.deq = am.getColor(R.color.cp_cont_b);
        this.der = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsZ != null) {
                    PersonTabView.this.jsZ.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentTab = 0;
        this.deq = am.getColor(R.color.cp_cont_b);
        this.der = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsZ != null) {
                    PersonTabView.this.jsZ.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.jsT = (TextView) findViewById(R.id.main_thread_btn);
        this.jsT.setOnClickListener(this.mOnClickListener);
        this.jsU = (TextView) findViewById(R.id.reply_btn);
        this.jsU.setOnClickListener(this.mOnClickListener);
        this.jsV = findViewById(R.id.main_thread_divider);
        this.jsW = findViewById(R.id.reply_btn_divider);
        this.jsX = findViewById(R.id.main_thread_bottom_divider);
        this.jsY = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.jsV.setVisibility(0);
                this.jsW.setVisibility(4);
                this.jsT.setTextColor(this.deq);
                this.jsU.setTextColor(this.der);
            } else if (i == 1) {
                this.jsV.setVisibility(4);
                this.jsW.setVisibility(0);
                this.jsT.setTextColor(this.der);
                this.jsU.setTextColor(this.deq);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.jsZ = aVar;
    }
}
