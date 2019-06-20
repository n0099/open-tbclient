package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonTabView extends LinearLayout {
    private int bWI;
    private int bWJ;
    private int fFX;
    private TextView inK;
    private TextView inL;
    private View inM;
    private View inN;
    private View inO;
    private View inP;
    private a inQ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void yn(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fFX = 0;
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inQ != null) {
                    PersonTabView.this.inQ.yn(PersonTabView.this.fFX);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFX = 0;
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inQ != null) {
                    PersonTabView.this.inQ.yn(PersonTabView.this.fFX);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFX = 0;
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inQ != null) {
                    PersonTabView.this.inQ.yn(PersonTabView.this.fFX);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.inK = (TextView) findViewById(R.id.main_thread_btn);
        this.inK.setOnClickListener(this.mOnClickListener);
        this.inL = (TextView) findViewById(R.id.reply_btn);
        this.inL.setOnClickListener(this.mOnClickListener);
        this.inM = findViewById(R.id.main_thread_divider);
        this.inN = findViewById(R.id.reply_btn_divider);
        this.inO = findViewById(R.id.main_thread_bottom_divider);
        this.inP = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fFX) {
            this.fFX = i;
            if (i == 0) {
                this.inM.setVisibility(0);
                this.inN.setVisibility(4);
                this.inK.setTextColor(this.bWI);
                this.inL.setTextColor(this.bWJ);
            } else if (i == 1) {
                this.inM.setVisibility(4);
                this.inN.setVisibility(0);
                this.inK.setTextColor(this.bWJ);
                this.inL.setTextColor(this.bWI);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.inQ = aVar;
    }
}
