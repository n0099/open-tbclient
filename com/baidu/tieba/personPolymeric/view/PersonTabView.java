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
    private TextView mBB;
    private TextView mBC;
    private View mBD;
    private View mBE;
    private View mBF;
    private View mBG;
    private a mBH;
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
                if (PersonTabView.this.mBH != null) {
                    PersonTabView.this.mBH.onTabSelect(PersonTabView.this.jCC);
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
                if (PersonTabView.this.mBH != null) {
                    PersonTabView.this.mBH.onTabSelect(PersonTabView.this.jCC);
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
                if (PersonTabView.this.mBH != null) {
                    PersonTabView.this.mBH.onTabSelect(PersonTabView.this.jCC);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mBB = (TextView) findViewById(R.id.main_thread_btn);
        this.mBB.setOnClickListener(this.mOnClickListener);
        this.mBC = (TextView) findViewById(R.id.reply_btn);
        this.mBC.setOnClickListener(this.mOnClickListener);
        this.mBD = findViewById(R.id.main_thread_divider);
        this.mBE = findViewById(R.id.reply_btn_divider);
        this.mBF = findViewById(R.id.main_thread_bottom_divider);
        this.mBG = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jCC) {
            this.jCC = i;
            if (i == 0) {
                this.mBD.setVisibility(0);
                this.mBE.setVisibility(4);
                this.mBB.setTextColor(this.fhI);
                this.mBC.setTextColor(this.fhJ);
            } else if (i == 1) {
                this.mBD.setVisibility(4);
                this.mBE.setVisibility(0);
                this.mBB.setTextColor(this.fhJ);
                this.mBC.setTextColor(this.fhI);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mBH = aVar;
    }
}
