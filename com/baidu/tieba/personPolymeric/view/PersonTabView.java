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
    private TextView jsa;
    private TextView jsb;
    private View jsc;
    private View jsd;
    private View jse;
    private View jsf;
    private a jsg;
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
                if (PersonTabView.this.jsg != null) {
                    PersonTabView.this.jsg.Aa(PersonTabView.this.mCurrentTab);
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
                if (PersonTabView.this.jsg != null) {
                    PersonTabView.this.jsg.Aa(PersonTabView.this.mCurrentTab);
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
                if (PersonTabView.this.jsg != null) {
                    PersonTabView.this.jsg.Aa(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.jsa = (TextView) findViewById(R.id.main_thread_btn);
        this.jsa.setOnClickListener(this.mOnClickListener);
        this.jsb = (TextView) findViewById(R.id.reply_btn);
        this.jsb.setOnClickListener(this.mOnClickListener);
        this.jsc = findViewById(R.id.main_thread_divider);
        this.jsd = findViewById(R.id.reply_btn_divider);
        this.jse = findViewById(R.id.main_thread_bottom_divider);
        this.jsf = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.jsc.setVisibility(0);
                this.jsd.setVisibility(4);
                this.jsa.setTextColor(this.dak);
                this.jsb.setTextColor(this.dal);
            } else if (i == 1) {
                this.jsc.setVisibility(4);
                this.jsd.setVisibility(0);
                this.jsa.setTextColor(this.dal);
                this.jsb.setTextColor(this.dak);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.jsg = aVar;
    }
}
