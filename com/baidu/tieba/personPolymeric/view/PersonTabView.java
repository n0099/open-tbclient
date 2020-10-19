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
    private int eDE;
    private int eDF;
    private int iJv;
    private TextView lPs;
    private TextView lPt;
    private View lPu;
    private View lPv;
    private View lPw;
    private View lPx;
    private a lPy;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes24.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.iJv = 0;
        this.eDE = ap.getColor(R.color.cp_cont_b);
        this.eDF = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lPy != null) {
                    PersonTabView.this.lPy.onTabSelect(PersonTabView.this.iJv);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iJv = 0;
        this.eDE = ap.getColor(R.color.cp_cont_b);
        this.eDF = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lPy != null) {
                    PersonTabView.this.lPy.onTabSelect(PersonTabView.this.iJv);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iJv = 0;
        this.eDE = ap.getColor(R.color.cp_cont_b);
        this.eDF = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lPy != null) {
                    PersonTabView.this.lPy.onTabSelect(PersonTabView.this.iJv);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.lPs = (TextView) findViewById(R.id.main_thread_btn);
        this.lPs.setOnClickListener(this.mOnClickListener);
        this.lPt = (TextView) findViewById(R.id.reply_btn);
        this.lPt.setOnClickListener(this.mOnClickListener);
        this.lPu = findViewById(R.id.main_thread_divider);
        this.lPv = findViewById(R.id.reply_btn_divider);
        this.lPw = findViewById(R.id.main_thread_bottom_divider);
        this.lPx = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.iJv) {
            this.iJv = i;
            if (i == 0) {
                this.lPu.setVisibility(0);
                this.lPv.setVisibility(4);
                this.lPs.setTextColor(this.eDE);
                this.lPt.setTextColor(this.eDF);
            } else if (i == 1) {
                this.lPu.setVisibility(4);
                this.lPv.setVisibility(0);
                this.lPs.setTextColor(this.eDF);
                this.lPt.setTextColor(this.eDE);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.lPy = aVar;
    }
}
