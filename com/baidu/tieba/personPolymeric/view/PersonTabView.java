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
    private int hEW;
    private TextView kwH;
    private TextView kwI;
    private View kwJ;
    private View kwK;
    private View kwL;
    private View kwM;
    private a kwN;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hEW = 0;
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
                if (PersonTabView.this.kwN != null) {
                    PersonTabView.this.kwN.onTabSelect(PersonTabView.this.hEW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEW = 0;
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
                if (PersonTabView.this.kwN != null) {
                    PersonTabView.this.kwN.onTabSelect(PersonTabView.this.hEW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hEW = 0;
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
                if (PersonTabView.this.kwN != null) {
                    PersonTabView.this.kwN.onTabSelect(PersonTabView.this.hEW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.kwH = (TextView) findViewById(R.id.main_thread_btn);
        this.kwH.setOnClickListener(this.mOnClickListener);
        this.kwI = (TextView) findViewById(R.id.reply_btn);
        this.kwI.setOnClickListener(this.mOnClickListener);
        this.kwJ = findViewById(R.id.main_thread_divider);
        this.kwK = findViewById(R.id.reply_btn_divider);
        this.kwL = findViewById(R.id.main_thread_bottom_divider);
        this.kwM = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hEW) {
            this.hEW = i;
            if (i == 0) {
                this.kwJ.setVisibility(0);
                this.kwK.setVisibility(4);
                this.kwH.setTextColor(this.dSF);
                this.kwI.setTextColor(this.dQl);
            } else if (i == 1) {
                this.kwJ.setVisibility(4);
                this.kwK.setVisibility(0);
                this.kwH.setTextColor(this.dQl);
                this.kwI.setTextColor(this.dSF);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.kwN = aVar;
    }
}
