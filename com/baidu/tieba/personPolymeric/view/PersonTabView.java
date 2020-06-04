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
    private int dQl;
    private int dSF;
    private int hFJ;
    private TextView kxN;
    private TextView kxO;
    private View kxP;
    private View kxQ;
    private View kxR;
    private View kxS;
    private a kxT;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hFJ = 0;
        this.dSF = am.getColor(R.color.cp_cont_b);
        this.dQl = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.kxT != null) {
                    PersonTabView.this.kxT.onTabSelect(PersonTabView.this.hFJ);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFJ = 0;
        this.dSF = am.getColor(R.color.cp_cont_b);
        this.dQl = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.kxT != null) {
                    PersonTabView.this.kxT.onTabSelect(PersonTabView.this.hFJ);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFJ = 0;
        this.dSF = am.getColor(R.color.cp_cont_b);
        this.dQl = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.kxT != null) {
                    PersonTabView.this.kxT.onTabSelect(PersonTabView.this.hFJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.kxN = (TextView) findViewById(R.id.main_thread_btn);
        this.kxN.setOnClickListener(this.mOnClickListener);
        this.kxO = (TextView) findViewById(R.id.reply_btn);
        this.kxO.setOnClickListener(this.mOnClickListener);
        this.kxP = findViewById(R.id.main_thread_divider);
        this.kxQ = findViewById(R.id.reply_btn_divider);
        this.kxR = findViewById(R.id.main_thread_bottom_divider);
        this.kxS = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hFJ) {
            this.hFJ = i;
            if (i == 0) {
                this.kxP.setVisibility(0);
                this.kxQ.setVisibility(4);
                this.kxN.setTextColor(this.dSF);
                this.kxO.setTextColor(this.dQl);
            } else if (i == 1) {
                this.kxP.setVisibility(4);
                this.kxQ.setVisibility(0);
                this.kxN.setTextColor(this.dQl);
                this.kxO.setTextColor(this.dSF);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.kxT = aVar;
    }
}
