package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonTabView extends LinearLayout {
    private int epk;
    private int epl;
    private int inf;
    private TextView lqZ;
    private TextView lra;
    private View lrb;
    private View lrc;
    private View lrd;
    private View lre;
    private a lrf;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes18.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.inf = 0;
        this.epk = ap.getColor(R.color.cp_cont_b);
        this.epl = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lrf != null) {
                    PersonTabView.this.lrf.onTabSelect(PersonTabView.this.inf);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inf = 0;
        this.epk = ap.getColor(R.color.cp_cont_b);
        this.epl = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lrf != null) {
                    PersonTabView.this.lrf.onTabSelect(PersonTabView.this.inf);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inf = 0;
        this.epk = ap.getColor(R.color.cp_cont_b);
        this.epl = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.lrf != null) {
                    PersonTabView.this.lrf.onTabSelect(PersonTabView.this.inf);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.lqZ = (TextView) findViewById(R.id.main_thread_btn);
        this.lqZ.setOnClickListener(this.mOnClickListener);
        this.lra = (TextView) findViewById(R.id.reply_btn);
        this.lra.setOnClickListener(this.mOnClickListener);
        this.lrb = findViewById(R.id.main_thread_divider);
        this.lrc = findViewById(R.id.reply_btn_divider);
        this.lrd = findViewById(R.id.main_thread_bottom_divider);
        this.lre = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.inf) {
            this.inf = i;
            if (i == 0) {
                this.lrb.setVisibility(0);
                this.lrc.setVisibility(4);
                this.lqZ.setTextColor(this.epk);
                this.lra.setTextColor(this.epl);
            } else if (i == 1) {
                this.lrb.setVisibility(4);
                this.lrc.setVisibility(0);
                this.lqZ.setTextColor(this.epl);
                this.lra.setTextColor(this.epk);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.lrf = aVar;
    }
}
