package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonTabView extends LinearLayout {
    private int eYi;
    private int eYj;
    private int jqf;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mwo;
    private TextView mwp;
    private View mwq;
    private View mwr;
    private View mws;
    private View mwt;
    private a mwu;

    /* loaded from: classes24.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jqf = 0;
        this.eYi = ap.getColor(R.color.CAM_X0105);
        this.eYj = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mwu != null) {
                    PersonTabView.this.mwu.onTabSelect(PersonTabView.this.jqf);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jqf = 0;
        this.eYi = ap.getColor(R.color.CAM_X0105);
        this.eYj = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mwu != null) {
                    PersonTabView.this.mwu.onTabSelect(PersonTabView.this.jqf);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jqf = 0;
        this.eYi = ap.getColor(R.color.CAM_X0105);
        this.eYj = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mwu != null) {
                    PersonTabView.this.mwu.onTabSelect(PersonTabView.this.jqf);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mwo = (TextView) findViewById(R.id.main_thread_btn);
        this.mwo.setOnClickListener(this.mOnClickListener);
        this.mwp = (TextView) findViewById(R.id.reply_btn);
        this.mwp.setOnClickListener(this.mOnClickListener);
        this.mwq = findViewById(R.id.main_thread_divider);
        this.mwr = findViewById(R.id.reply_btn_divider);
        this.mws = findViewById(R.id.main_thread_bottom_divider);
        this.mwt = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jqf) {
            this.jqf = i;
            if (i == 0) {
                this.mwq.setVisibility(0);
                this.mwr.setVisibility(4);
                this.mwo.setTextColor(this.eYi);
                this.mwp.setTextColor(this.eYj);
            } else if (i == 1) {
                this.mwq.setVisibility(4);
                this.mwr.setVisibility(0);
                this.mwo.setTextColor(this.eYj);
                this.mwp.setTextColor(this.eYi);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mwu = aVar;
    }
}
