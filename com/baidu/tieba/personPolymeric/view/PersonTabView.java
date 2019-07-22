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
    private int bXK;
    private int bXL;
    private int fKV;
    private TextView iua;
    private TextView iub;
    private View iuc;
    private View iud;
    private View iue;
    private View iuf;
    private a iug;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void yS(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fKV = 0;
        this.bXK = am.getColor(R.color.cp_cont_b);
        this.bXL = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.iug != null) {
                    PersonTabView.this.iug.yS(PersonTabView.this.fKV);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fKV = 0;
        this.bXK = am.getColor(R.color.cp_cont_b);
        this.bXL = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.iug != null) {
                    PersonTabView.this.iug.yS(PersonTabView.this.fKV);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fKV = 0;
        this.bXK = am.getColor(R.color.cp_cont_b);
        this.bXL = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.iug != null) {
                    PersonTabView.this.iug.yS(PersonTabView.this.fKV);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.iua = (TextView) findViewById(R.id.main_thread_btn);
        this.iua.setOnClickListener(this.mOnClickListener);
        this.iub = (TextView) findViewById(R.id.reply_btn);
        this.iub.setOnClickListener(this.mOnClickListener);
        this.iuc = findViewById(R.id.main_thread_divider);
        this.iud = findViewById(R.id.reply_btn_divider);
        this.iue = findViewById(R.id.main_thread_bottom_divider);
        this.iuf = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fKV) {
            this.fKV = i;
            if (i == 0) {
                this.iuc.setVisibility(0);
                this.iud.setVisibility(4);
                this.iua.setTextColor(this.bXK);
                this.iub.setTextColor(this.bXL);
            } else if (i == 1) {
                this.iuc.setVisibility(4);
                this.iud.setVisibility(0);
                this.iua.setTextColor(this.bXL);
                this.iub.setTextColor(this.bXK);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.iug = aVar;
    }
}
