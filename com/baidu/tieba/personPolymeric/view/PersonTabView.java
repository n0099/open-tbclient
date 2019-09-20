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
    private int bYJ;
    private int bYK;
    private int fNy;
    private TextView ixc;
    private TextView ixd;
    private View ixe;
    private View ixf;
    private View ixg;
    private View ixh;
    private a ixi;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void yX(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fNy = 0;
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ixi != null) {
                    PersonTabView.this.ixi.yX(PersonTabView.this.fNy);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fNy = 0;
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ixi != null) {
                    PersonTabView.this.ixi.yX(PersonTabView.this.fNy);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fNy = 0;
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.ixi != null) {
                    PersonTabView.this.ixi.yX(PersonTabView.this.fNy);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.ixc = (TextView) findViewById(R.id.main_thread_btn);
        this.ixc.setOnClickListener(this.mOnClickListener);
        this.ixd = (TextView) findViewById(R.id.reply_btn);
        this.ixd.setOnClickListener(this.mOnClickListener);
        this.ixe = findViewById(R.id.main_thread_divider);
        this.ixf = findViewById(R.id.reply_btn_divider);
        this.ixg = findViewById(R.id.main_thread_bottom_divider);
        this.ixh = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fNy) {
            this.fNy = i;
            if (i == 0) {
                this.ixe.setVisibility(0);
                this.ixf.setVisibility(4);
                this.ixc.setTextColor(this.bYJ);
                this.ixd.setTextColor(this.bYK);
            } else if (i == 1) {
                this.ixe.setVisibility(4);
                this.ixf.setVisibility(0);
                this.ixc.setTextColor(this.bYK);
                this.ixd.setTextColor(this.bYJ);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.ixi = aVar;
    }
}
