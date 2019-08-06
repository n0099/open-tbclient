package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonTabView extends LinearLayout {
    private int bXQ;
    private int bXR;
    private int fLJ;
    private TextView ivd;
    private TextView ive;
    private View ivf;
    private View ivg;
    private View ivh;
    private View ivi;
    private a ivj;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void yU(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fLJ = 0;
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ivj != null) {
                    PersonTabView.this.ivj.yU(PersonTabView.this.fLJ);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLJ = 0;
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ivj != null) {
                    PersonTabView.this.ivj.yU(PersonTabView.this.fLJ);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fLJ = 0;
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ivj != null) {
                    PersonTabView.this.ivj.yU(PersonTabView.this.fLJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.ivd = (TextView) findViewById(R.id.main_thread_btn);
        this.ivd.setOnClickListener(this.mOnClickListener);
        this.ive = (TextView) findViewById(R.id.reply_btn);
        this.ive.setOnClickListener(this.mOnClickListener);
        this.ivf = findViewById(R.id.main_thread_divider);
        this.ivg = findViewById(R.id.reply_btn_divider);
        this.ivh = findViewById(R.id.main_thread_bottom_divider);
        this.ivi = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fLJ) {
            this.fLJ = i;
            if (i == 0) {
                this.ivf.setVisibility(0);
                this.ivg.setVisibility(4);
                this.ivd.setTextColor(this.bXQ);
                this.ive.setTextColor(this.bXR);
            } else if (i == 1) {
                this.ivf.setVisibility(4);
                this.ivg.setVisibility(0);
                this.ivd.setTextColor(this.bXR);
                this.ive.setTextColor(this.bXQ);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.ivj = aVar;
    }
}
