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
    private int cmP;
    private int cmQ;
    private int fMa;
    private TextView iuN;
    private TextView iuO;
    private View iuP;
    private View iuQ;
    private View iuR;
    private View iuS;
    private a iuT;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void xB(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fMa = 0;
        this.cmP = am.getColor(R.color.cp_cont_b);
        this.cmQ = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.iuT != null) {
                    PersonTabView.this.iuT.xB(PersonTabView.this.fMa);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMa = 0;
        this.cmP = am.getColor(R.color.cp_cont_b);
        this.cmQ = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.iuT != null) {
                    PersonTabView.this.iuT.xB(PersonTabView.this.fMa);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMa = 0;
        this.cmP = am.getColor(R.color.cp_cont_b);
        this.cmQ = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.iuT != null) {
                    PersonTabView.this.iuT.xB(PersonTabView.this.fMa);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.iuN = (TextView) findViewById(R.id.main_thread_btn);
        this.iuN.setOnClickListener(this.mOnClickListener);
        this.iuO = (TextView) findViewById(R.id.reply_btn);
        this.iuO.setOnClickListener(this.mOnClickListener);
        this.iuP = findViewById(R.id.main_thread_divider);
        this.iuQ = findViewById(R.id.reply_btn_divider);
        this.iuR = findViewById(R.id.main_thread_bottom_divider);
        this.iuS = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fMa) {
            this.fMa = i;
            if (i == 0) {
                this.iuP.setVisibility(0);
                this.iuQ.setVisibility(4);
                this.iuN.setTextColor(this.cmP);
                this.iuO.setTextColor(this.cmQ);
            } else if (i == 1) {
                this.iuP.setVisibility(4);
                this.iuQ.setVisibility(0);
                this.iuN.setTextColor(this.cmQ);
                this.iuO.setTextColor(this.cmP);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.iuT = aVar;
    }
}
