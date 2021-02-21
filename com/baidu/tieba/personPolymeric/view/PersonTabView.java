package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonTabView extends LinearLayout {
    private int ffp;
    private int ffq;
    private int jDP;
    private Context mContext;
    private TextView mGq;
    private TextView mGr;
    private View mGs;
    private View mGt;
    private View mGu;
    private View mGv;
    private a mGw;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes8.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jDP = 0;
        this.ffp = ap.getColor(R.color.CAM_X0105);
        this.ffq = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mGw != null) {
                    PersonTabView.this.mGw.onTabSelect(PersonTabView.this.jDP);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDP = 0;
        this.ffp = ap.getColor(R.color.CAM_X0105);
        this.ffq = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mGw != null) {
                    PersonTabView.this.mGw.onTabSelect(PersonTabView.this.jDP);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDP = 0;
        this.ffp = ap.getColor(R.color.CAM_X0105);
        this.ffq = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mGw != null) {
                    PersonTabView.this.mGw.onTabSelect(PersonTabView.this.jDP);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mGq = (TextView) findViewById(R.id.main_thread_btn);
        this.mGq.setOnClickListener(this.mOnClickListener);
        this.mGr = (TextView) findViewById(R.id.reply_btn);
        this.mGr.setOnClickListener(this.mOnClickListener);
        this.mGs = findViewById(R.id.main_thread_divider);
        this.mGt = findViewById(R.id.reply_btn_divider);
        this.mGu = findViewById(R.id.main_thread_bottom_divider);
        this.mGv = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jDP) {
            this.jDP = i;
            if (i == 0) {
                this.mGs.setVisibility(0);
                this.mGt.setVisibility(4);
                this.mGq.setTextColor(this.ffp);
                this.mGr.setTextColor(this.ffq);
            } else if (i == 1) {
                this.mGs.setVisibility(4);
                this.mGt.setVisibility(0);
                this.mGq.setTextColor(this.ffq);
                this.mGr.setTextColor(this.ffp);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mGw = aVar;
    }
}
