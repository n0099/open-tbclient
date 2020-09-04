package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonTabView extends LinearLayout {
    private int epo;
    private int epp;
    private int inl;
    private TextView lrk;
    private TextView lrl;
    private View lrm;
    private View lrn;
    private View lro;
    private View lrp;
    private a lrq;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes18.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.inl = 0;
        this.epo = ap.getColor(R.color.cp_cont_b);
        this.epp = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lrq != null) {
                    PersonTabView.this.lrq.onTabSelect(PersonTabView.this.inl);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inl = 0;
        this.epo = ap.getColor(R.color.cp_cont_b);
        this.epp = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lrq != null) {
                    PersonTabView.this.lrq.onTabSelect(PersonTabView.this.inl);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inl = 0;
        this.epo = ap.getColor(R.color.cp_cont_b);
        this.epp = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lrq != null) {
                    PersonTabView.this.lrq.onTabSelect(PersonTabView.this.inl);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.lrk = (TextView) findViewById(R.id.main_thread_btn);
        this.lrk.setOnClickListener(this.mOnClickListener);
        this.lrl = (TextView) findViewById(R.id.reply_btn);
        this.lrl.setOnClickListener(this.mOnClickListener);
        this.lrm = findViewById(R.id.main_thread_divider);
        this.lrn = findViewById(R.id.reply_btn_divider);
        this.lro = findViewById(R.id.main_thread_bottom_divider);
        this.lrp = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.inl) {
            this.inl = i;
            if (i == 0) {
                this.lrm.setVisibility(0);
                this.lrn.setVisibility(4);
                this.lrk.setTextColor(this.epo);
                this.lrl.setTextColor(this.epp);
            } else if (i == 1) {
                this.lrm.setVisibility(4);
                this.lrn.setVisibility(0);
                this.lrk.setTextColor(this.epp);
                this.lrl.setTextColor(this.epo);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.lrq = aVar;
    }
}
