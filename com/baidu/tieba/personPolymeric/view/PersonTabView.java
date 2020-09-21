package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PersonTabView extends LinearLayout {
    private int ert;
    private int eru;
    private int iuC;
    private TextView lAd;
    private TextView lAe;
    private View lAf;
    private View lAg;
    private View lAh;
    private View lAi;
    private a lAj;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes23.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.iuC = 0;
        this.ert = ap.getColor(R.color.cp_cont_b);
        this.eru = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lAj != null) {
                    PersonTabView.this.lAj.onTabSelect(PersonTabView.this.iuC);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iuC = 0;
        this.ert = ap.getColor(R.color.cp_cont_b);
        this.eru = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lAj != null) {
                    PersonTabView.this.lAj.onTabSelect(PersonTabView.this.iuC);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iuC = 0;
        this.ert = ap.getColor(R.color.cp_cont_b);
        this.eru = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lAj != null) {
                    PersonTabView.this.lAj.onTabSelect(PersonTabView.this.iuC);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.lAd = (TextView) findViewById(R.id.main_thread_btn);
        this.lAd.setOnClickListener(this.mOnClickListener);
        this.lAe = (TextView) findViewById(R.id.reply_btn);
        this.lAe.setOnClickListener(this.mOnClickListener);
        this.lAf = findViewById(R.id.main_thread_divider);
        this.lAg = findViewById(R.id.reply_btn_divider);
        this.lAh = findViewById(R.id.main_thread_bottom_divider);
        this.lAi = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.iuC) {
            this.iuC = i;
            if (i == 0) {
                this.lAf.setVisibility(0);
                this.lAg.setVisibility(4);
                this.lAd.setTextColor(this.ert);
                this.lAe.setTextColor(this.eru);
            } else if (i == 1) {
                this.lAf.setVisibility(4);
                this.lAg.setVisibility(0);
                this.lAd.setTextColor(this.eru);
                this.lAe.setTextColor(this.ert);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.lAj = aVar;
    }
}
