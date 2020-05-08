package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonTabView extends LinearLayout {
    private int dCe;
    private int dEt;
    private int hqi;
    private TextView keR;
    private TextView keS;
    private View keT;
    private View keU;
    private View keV;
    private View keW;
    private a keX;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void AR(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.hqi = 0;
        this.dEt = am.getColor(R.color.cp_cont_b);
        this.dCe = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.keX != null) {
                    PersonTabView.this.keX.AR(PersonTabView.this.hqi);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hqi = 0;
        this.dEt = am.getColor(R.color.cp_cont_b);
        this.dCe = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.keX != null) {
                    PersonTabView.this.keX.AR(PersonTabView.this.hqi);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hqi = 0;
        this.dEt = am.getColor(R.color.cp_cont_b);
        this.dCe = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.keX != null) {
                    PersonTabView.this.keX.AR(PersonTabView.this.hqi);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.keR = (TextView) findViewById(R.id.main_thread_btn);
        this.keR.setOnClickListener(this.mOnClickListener);
        this.keS = (TextView) findViewById(R.id.reply_btn);
        this.keS.setOnClickListener(this.mOnClickListener);
        this.keT = findViewById(R.id.main_thread_divider);
        this.keU = findViewById(R.id.reply_btn_divider);
        this.keV = findViewById(R.id.main_thread_bottom_divider);
        this.keW = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.hqi) {
            this.hqi = i;
            if (i == 0) {
                this.keT.setVisibility(0);
                this.keU.setVisibility(4);
                this.keR.setTextColor(this.dEt);
                this.keS.setTextColor(this.dCe);
            } else if (i == 1) {
                this.keT.setVisibility(4);
                this.keU.setVisibility(0);
                this.keR.setTextColor(this.dCe);
                this.keS.setTextColor(this.dEt);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.keX = aVar;
    }
}
