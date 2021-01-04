package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonTabView extends LinearLayout {
    private int fhI;
    private int fhJ;
    private int jCC;
    private TextView mBC;
    private TextView mBD;
    private View mBE;
    private View mBF;
    private View mBG;
    private View mBH;
    private a mBI;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes8.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jCC = 0;
        this.fhI = ao.getColor(R.color.CAM_X0105);
        this.fhJ = ao.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mBI != null) {
                    PersonTabView.this.mBI.onTabSelect(PersonTabView.this.jCC);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCC = 0;
        this.fhI = ao.getColor(R.color.CAM_X0105);
        this.fhJ = ao.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mBI != null) {
                    PersonTabView.this.mBI.onTabSelect(PersonTabView.this.jCC);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCC = 0;
        this.fhI = ao.getColor(R.color.CAM_X0105);
        this.fhJ = ao.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mBI != null) {
                    PersonTabView.this.mBI.onTabSelect(PersonTabView.this.jCC);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mBC = (TextView) findViewById(R.id.main_thread_btn);
        this.mBC.setOnClickListener(this.mOnClickListener);
        this.mBD = (TextView) findViewById(R.id.reply_btn);
        this.mBD.setOnClickListener(this.mOnClickListener);
        this.mBE = findViewById(R.id.main_thread_divider);
        this.mBF = findViewById(R.id.reply_btn_divider);
        this.mBG = findViewById(R.id.main_thread_bottom_divider);
        this.mBH = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jCC) {
            this.jCC = i;
            if (i == 0) {
                this.mBE.setVisibility(0);
                this.mBF.setVisibility(4);
                this.mBC.setTextColor(this.fhI);
                this.mBD.setTextColor(this.fhJ);
            } else if (i == 1) {
                this.mBE.setVisibility(4);
                this.mBF.setVisibility(0);
                this.mBC.setTextColor(this.fhJ);
                this.mBD.setTextColor(this.fhI);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mBI = aVar;
    }
}
