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
    private int deE;
    private int deF;
    private TextView jtf;
    private TextView jtg;
    private View jth;
    private View jti;
    private View jtj;
    private View jtk;
    private a jtl;
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
        this.deE = am.getColor(R.color.cp_cont_b);
        this.deF = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jtl != null) {
                    PersonTabView.this.jtl.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTab = 0;
        this.deE = am.getColor(R.color.cp_cont_b);
        this.deF = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jtl != null) {
                    PersonTabView.this.jtl.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentTab = 0;
        this.deE = am.getColor(R.color.cp_cont_b);
        this.deF = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jtl != null) {
                    PersonTabView.this.jtl.Ai(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.jtf = (TextView) findViewById(R.id.main_thread_btn);
        this.jtf.setOnClickListener(this.mOnClickListener);
        this.jtg = (TextView) findViewById(R.id.reply_btn);
        this.jtg.setOnClickListener(this.mOnClickListener);
        this.jth = findViewById(R.id.main_thread_divider);
        this.jti = findViewById(R.id.reply_btn_divider);
        this.jtj = findViewById(R.id.main_thread_bottom_divider);
        this.jtk = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.jth.setVisibility(0);
                this.jti.setVisibility(4);
                this.jtf.setTextColor(this.deE);
                this.jtg.setTextColor(this.deF);
            } else if (i == 1) {
                this.jth.setVisibility(4);
                this.jti.setVisibility(0);
                this.jtf.setTextColor(this.deF);
                this.jtg.setTextColor(this.deE);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.jtl = aVar;
    }
}
