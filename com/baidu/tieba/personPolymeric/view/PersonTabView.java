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
    private int dep;
    private int deq;
    private TextView jsR;
    private TextView jsS;
    private View jsT;
    private View jsU;
    private View jsV;
    private View jsW;
    private a jsX;
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
        this.dep = am.getColor(R.color.cp_cont_b);
        this.deq = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsX != null) {
                    PersonTabView.this.jsX.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTab = 0;
        this.dep = am.getColor(R.color.cp_cont_b);
        this.deq = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsX != null) {
                    PersonTabView.this.jsX.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentTab = 0;
        this.dep = am.getColor(R.color.cp_cont_b);
        this.deq = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsX != null) {
                    PersonTabView.this.jsX.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.jsR = (TextView) findViewById(R.id.main_thread_btn);
        this.jsR.setOnClickListener(this.mOnClickListener);
        this.jsS = (TextView) findViewById(R.id.reply_btn);
        this.jsS.setOnClickListener(this.mOnClickListener);
        this.jsT = findViewById(R.id.main_thread_divider);
        this.jsU = findViewById(R.id.reply_btn_divider);
        this.jsV = findViewById(R.id.main_thread_bottom_divider);
        this.jsW = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.jsT.setVisibility(0);
                this.jsU.setVisibility(4);
                this.jsR.setTextColor(this.dep);
                this.jsS.setTextColor(this.deq);
            } else if (i == 1) {
                this.jsT.setVisibility(4);
                this.jsU.setVisibility(0);
                this.jsR.setTextColor(this.deq);
                this.jsS.setTextColor(this.dep);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.jsX = aVar;
    }
}
