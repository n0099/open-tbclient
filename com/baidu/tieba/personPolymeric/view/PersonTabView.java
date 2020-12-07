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
    private int jqd;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mwm;
    private TextView mwn;
    private View mwo;
    private View mwp;
    private View mwq;
    private View mwr;
    private a mws;

    /* loaded from: classes24.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jqd = 0;
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
                if (PersonTabView.this.mws != null) {
                    PersonTabView.this.mws.onTabSelect(PersonTabView.this.jqd);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jqd = 0;
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
                if (PersonTabView.this.mws != null) {
                    PersonTabView.this.mws.onTabSelect(PersonTabView.this.jqd);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jqd = 0;
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
                if (PersonTabView.this.mws != null) {
                    PersonTabView.this.mws.onTabSelect(PersonTabView.this.jqd);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mwm = (TextView) findViewById(R.id.main_thread_btn);
        this.mwm.setOnClickListener(this.mOnClickListener);
        this.mwn = (TextView) findViewById(R.id.reply_btn);
        this.mwn.setOnClickListener(this.mOnClickListener);
        this.mwo = findViewById(R.id.main_thread_divider);
        this.mwp = findViewById(R.id.reply_btn_divider);
        this.mwq = findViewById(R.id.main_thread_bottom_divider);
        this.mwr = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jqd) {
            this.jqd = i;
            if (i == 0) {
                this.mwo.setVisibility(0);
                this.mwp.setVisibility(4);
                this.mwm.setTextColor(this.eYi);
                this.mwn.setTextColor(this.eYj);
            } else if (i == 1) {
                this.mwo.setVisibility(4);
                this.mwp.setVisibility(0);
                this.mwm.setTextColor(this.eYj);
                this.mwn.setTextColor(this.eYi);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mws = aVar;
    }
}
