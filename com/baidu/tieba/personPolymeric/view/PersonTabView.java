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
    private int bWH;
    private int bWI;
    private int fFW;
    private TextView inG;
    private TextView inH;
    private View inI;
    private View inJ;
    private View inK;
    private View inL;
    private a inM;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void yn(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fFW = 0;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inM != null) {
                    PersonTabView.this.inM.yn(PersonTabView.this.fFW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFW = 0;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inM != null) {
                    PersonTabView.this.inM.yn(PersonTabView.this.fFW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFW = 0;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inM != null) {
                    PersonTabView.this.inM.yn(PersonTabView.this.fFW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.inG = (TextView) findViewById(R.id.main_thread_btn);
        this.inG.setOnClickListener(this.mOnClickListener);
        this.inH = (TextView) findViewById(R.id.reply_btn);
        this.inH.setOnClickListener(this.mOnClickListener);
        this.inI = findViewById(R.id.main_thread_divider);
        this.inJ = findViewById(R.id.reply_btn_divider);
        this.inK = findViewById(R.id.main_thread_bottom_divider);
        this.inL = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fFW) {
            this.fFW = i;
            if (i == 0) {
                this.inI.setVisibility(0);
                this.inJ.setVisibility(4);
                this.inG.setTextColor(this.bWH);
                this.inH.setTextColor(this.bWI);
            } else if (i == 1) {
                this.inI.setVisibility(4);
                this.inJ.setVisibility(0);
                this.inG.setTextColor(this.bWI);
                this.inH.setTextColor(this.bWH);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.inM = aVar;
    }
}
