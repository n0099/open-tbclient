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
    private int dCa;
    private int dEp;
    private int hqc;
    private TextView keN;
    private TextView keO;
    private View keP;
    private View keQ;
    private View keR;
    private View keS;
    private a keT;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void AR(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hqc = 0;
        this.dEp = am.getColor(R.color.cp_cont_b);
        this.dCa = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.keT != null) {
                    PersonTabView.this.keT.AR(PersonTabView.this.hqc);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hqc = 0;
        this.dEp = am.getColor(R.color.cp_cont_b);
        this.dCa = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.keT != null) {
                    PersonTabView.this.keT.AR(PersonTabView.this.hqc);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hqc = 0;
        this.dEp = am.getColor(R.color.cp_cont_b);
        this.dCa = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.keT != null) {
                    PersonTabView.this.keT.AR(PersonTabView.this.hqc);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.keN = (TextView) findViewById(R.id.main_thread_btn);
        this.keN.setOnClickListener(this.mOnClickListener);
        this.keO = (TextView) findViewById(R.id.reply_btn);
        this.keO.setOnClickListener(this.mOnClickListener);
        this.keP = findViewById(R.id.main_thread_divider);
        this.keQ = findViewById(R.id.reply_btn_divider);
        this.keR = findViewById(R.id.main_thread_bottom_divider);
        this.keS = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hqc) {
            this.hqc = i;
            if (i == 0) {
                this.keP.setVisibility(0);
                this.keQ.setVisibility(4);
                this.keN.setTextColor(this.dEp);
                this.keO.setTextColor(this.dCa);
            } else if (i == 1) {
                this.keP.setVisibility(4);
                this.keQ.setVisibility(0);
                this.keN.setTextColor(this.dCa);
                this.keO.setTextColor(this.dEp);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.keT = aVar;
    }
}
