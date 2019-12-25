package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonTabView extends LinearLayout {
    private int daa;
    private int dab;
    private View joA;
    private View joB;
    private View joC;
    private View joD;
    private a joE;
    private TextView joy;
    private TextView joz;
    private Context mContext;
    private int mCurrentTab;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes8.dex */
    public interface a {
        void zV(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.mCurrentTab = 0;
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.joE != null) {
                    PersonTabView.this.joE.zV(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTab = 0;
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.joE != null) {
                    PersonTabView.this.joE.zV(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentTab = 0;
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.joE != null) {
                    PersonTabView.this.joE.zV(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.joy = (TextView) findViewById(R.id.main_thread_btn);
        this.joy.setOnClickListener(this.mOnClickListener);
        this.joz = (TextView) findViewById(R.id.reply_btn);
        this.joz.setOnClickListener(this.mOnClickListener);
        this.joA = findViewById(R.id.main_thread_divider);
        this.joB = findViewById(R.id.reply_btn_divider);
        this.joC = findViewById(R.id.main_thread_bottom_divider);
        this.joD = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.joA.setVisibility(0);
                this.joB.setVisibility(4);
                this.joy.setTextColor(this.daa);
                this.joz.setTextColor(this.dab);
            } else if (i == 1) {
                this.joA.setVisibility(4);
                this.joB.setVisibility(0);
                this.joy.setTextColor(this.dab);
                this.joz.setTextColor(this.daa);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.joE = aVar;
    }
}
