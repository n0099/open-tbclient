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
    private int jDB;
    private Context mContext;
    private TextView mGa;
    private TextView mGb;
    private View mGc;
    private View mGd;
    private View mGe;
    private View mGf;
    private a mGg;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes8.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jDB = 0;
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
                if (PersonTabView.this.mGg != null) {
                    PersonTabView.this.mGg.onTabSelect(PersonTabView.this.jDB);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDB = 0;
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
                if (PersonTabView.this.mGg != null) {
                    PersonTabView.this.mGg.onTabSelect(PersonTabView.this.jDB);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDB = 0;
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
                if (PersonTabView.this.mGg != null) {
                    PersonTabView.this.mGg.onTabSelect(PersonTabView.this.jDB);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mGa = (TextView) findViewById(R.id.main_thread_btn);
        this.mGa.setOnClickListener(this.mOnClickListener);
        this.mGb = (TextView) findViewById(R.id.reply_btn);
        this.mGb.setOnClickListener(this.mOnClickListener);
        this.mGc = findViewById(R.id.main_thread_divider);
        this.mGd = findViewById(R.id.reply_btn_divider);
        this.mGe = findViewById(R.id.main_thread_bottom_divider);
        this.mGf = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jDB) {
            this.jDB = i;
            if (i == 0) {
                this.mGc.setVisibility(0);
                this.mGd.setVisibility(4);
                this.mGa.setTextColor(this.ffp);
                this.mGb.setTextColor(this.ffq);
            } else if (i == 1) {
                this.mGc.setVisibility(4);
                this.mGd.setVisibility(0);
                this.mGa.setTextColor(this.ffq);
                this.mGb.setTextColor(this.ffp);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mGg = aVar;
    }
}
