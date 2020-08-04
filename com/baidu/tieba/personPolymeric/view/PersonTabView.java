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
    private int hYX;
    private TextView laJ;
    private TextView laK;
    private View laL;
    private View laM;
    private View laN;
    private View laO;
    private a laP;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes18.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hYX = 0;
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
                if (PersonTabView.this.laP != null) {
                    PersonTabView.this.laP.onTabSelect(PersonTabView.this.hYX);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYX = 0;
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
                if (PersonTabView.this.laP != null) {
                    PersonTabView.this.laP.onTabSelect(PersonTabView.this.hYX);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYX = 0;
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
                if (PersonTabView.this.laP != null) {
                    PersonTabView.this.laP.onTabSelect(PersonTabView.this.hYX);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.laJ = (TextView) findViewById(R.id.main_thread_btn);
        this.laJ.setOnClickListener(this.mOnClickListener);
        this.laK = (TextView) findViewById(R.id.reply_btn);
        this.laK.setOnClickListener(this.mOnClickListener);
        this.laL = findViewById(R.id.main_thread_divider);
        this.laM = findViewById(R.id.reply_btn_divider);
        this.laN = findViewById(R.id.main_thread_bottom_divider);
        this.laO = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hYX) {
            this.hYX = i;
            if (i == 0) {
                this.laL.setVisibility(0);
                this.laM.setVisibility(4);
                this.laJ.setTextColor(this.efK);
                this.laK.setTextColor(this.edx);
            } else if (i == 1) {
                this.laL.setVisibility(4);
                this.laM.setVisibility(0);
                this.laJ.setTextColor(this.edx);
                this.laK.setTextColor(this.efK);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.laP = aVar;
    }
}
