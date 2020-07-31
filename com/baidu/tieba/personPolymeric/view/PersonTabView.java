package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonTabView extends LinearLayout {
    private int edx;
    private int efK;
    private int hYV;
    private TextView laH;
    private TextView laI;
    private View laJ;
    private View laK;
    private View laL;
    private View laM;
    private a laN;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes18.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hYV = 0;
        this.efK = ao.getColor(R.color.cp_cont_b);
        this.edx = ao.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.laN != null) {
                    PersonTabView.this.laN.onTabSelect(PersonTabView.this.hYV);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYV = 0;
        this.efK = ao.getColor(R.color.cp_cont_b);
        this.edx = ao.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.laN != null) {
                    PersonTabView.this.laN.onTabSelect(PersonTabView.this.hYV);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYV = 0;
        this.efK = ao.getColor(R.color.cp_cont_b);
        this.edx = ao.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.laN != null) {
                    PersonTabView.this.laN.onTabSelect(PersonTabView.this.hYV);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.laH = (TextView) findViewById(R.id.main_thread_btn);
        this.laH.setOnClickListener(this.mOnClickListener);
        this.laI = (TextView) findViewById(R.id.reply_btn);
        this.laI.setOnClickListener(this.mOnClickListener);
        this.laJ = findViewById(R.id.main_thread_divider);
        this.laK = findViewById(R.id.reply_btn_divider);
        this.laL = findViewById(R.id.main_thread_bottom_divider);
        this.laM = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hYV) {
            this.hYV = i;
            if (i == 0) {
                this.laJ.setVisibility(0);
                this.laK.setVisibility(4);
                this.laH.setTextColor(this.efK);
                this.laI.setTextColor(this.edx);
            } else if (i == 1) {
                this.laJ.setVisibility(4);
                this.laK.setVisibility(0);
                this.laH.setTextColor(this.edx);
                this.laI.setTextColor(this.efK);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.laN = aVar;
    }
}
