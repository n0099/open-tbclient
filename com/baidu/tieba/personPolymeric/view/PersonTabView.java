package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonTabView extends LinearLayout {
    private int dak;
    private int dal;
    private TextView jsf;
    private TextView jsg;
    private View jsh;
    private View jsi;
    private View jsj;
    private View jsk;
    private a jsl;
    private Context mContext;
    private int mCurrentTab;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes9.dex */
    public interface a {
        void Aa(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.mCurrentTab = 0;
        this.dak = am.getColor(R.color.cp_cont_b);
        this.dal = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsl != null) {
                    PersonTabView.this.jsl.Aa(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTab = 0;
        this.dak = am.getColor(R.color.cp_cont_b);
        this.dal = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsl != null) {
                    PersonTabView.this.jsl.Aa(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentTab = 0;
        this.dak = am.getColor(R.color.cp_cont_b);
        this.dal = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.jsl != null) {
                    PersonTabView.this.jsl.Aa(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.jsf = (TextView) findViewById(R.id.main_thread_btn);
        this.jsf.setOnClickListener(this.mOnClickListener);
        this.jsg = (TextView) findViewById(R.id.reply_btn);
        this.jsg.setOnClickListener(this.mOnClickListener);
        this.jsh = findViewById(R.id.main_thread_divider);
        this.jsi = findViewById(R.id.reply_btn_divider);
        this.jsj = findViewById(R.id.main_thread_bottom_divider);
        this.jsk = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.jsh.setVisibility(0);
                this.jsi.setVisibility(4);
                this.jsf.setTextColor(this.dak);
                this.jsg.setTextColor(this.dal);
            } else if (i == 1) {
                this.jsh.setVisibility(4);
                this.jsi.setVisibility(0);
                this.jsf.setTextColor(this.dal);
                this.jsg.setTextColor(this.dak);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.jsl = aVar;
    }
}
