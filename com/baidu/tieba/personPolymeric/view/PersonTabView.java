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
    private int cnH;
    private int cnI;
    private int fMR;
    private TextView ivE;
    private TextView ivF;
    private View ivG;
    private View ivH;
    private View ivI;
    private View ivJ;
    private a ivK;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void xC(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fMR = 0;
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ivK != null) {
                    PersonTabView.this.ivK.xC(PersonTabView.this.fMR);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMR = 0;
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ivK != null) {
                    PersonTabView.this.ivK.xC(PersonTabView.this.fMR);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMR = 0;
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ivK != null) {
                    PersonTabView.this.ivK.xC(PersonTabView.this.fMR);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.ivE = (TextView) findViewById(R.id.main_thread_btn);
        this.ivE.setOnClickListener(this.mOnClickListener);
        this.ivF = (TextView) findViewById(R.id.reply_btn);
        this.ivF.setOnClickListener(this.mOnClickListener);
        this.ivG = findViewById(R.id.main_thread_divider);
        this.ivH = findViewById(R.id.reply_btn_divider);
        this.ivI = findViewById(R.id.main_thread_bottom_divider);
        this.ivJ = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fMR) {
            this.fMR = i;
            if (i == 0) {
                this.ivG.setVisibility(0);
                this.ivH.setVisibility(4);
                this.ivE.setTextColor(this.cnH);
                this.ivF.setTextColor(this.cnI);
            } else if (i == 1) {
                this.ivG.setVisibility(4);
                this.ivH.setVisibility(0);
                this.ivE.setTextColor(this.cnI);
                this.ivF.setTextColor(this.cnH);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.ivK = aVar;
    }
}
