package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PersonTabView extends LinearLayout {
    private int eQR;
    private int eQS;
    private int jcA;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mih;
    private TextView mii;
    private View mij;
    private View mik;
    private View mil;
    private View mim;
    private a mio;

    /* loaded from: classes23.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jcA = 0;
        this.eQR = ap.getColor(R.color.CAM_X0105);
        this.eQS = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mio != null) {
                    PersonTabView.this.mio.onTabSelect(PersonTabView.this.jcA);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcA = 0;
        this.eQR = ap.getColor(R.color.CAM_X0105);
        this.eQS = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mio != null) {
                    PersonTabView.this.mio.onTabSelect(PersonTabView.this.jcA);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcA = 0;
        this.eQR = ap.getColor(R.color.CAM_X0105);
        this.eQS = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mio != null) {
                    PersonTabView.this.mio.onTabSelect(PersonTabView.this.jcA);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mih = (TextView) findViewById(R.id.main_thread_btn);
        this.mih.setOnClickListener(this.mOnClickListener);
        this.mii = (TextView) findViewById(R.id.reply_btn);
        this.mii.setOnClickListener(this.mOnClickListener);
        this.mij = findViewById(R.id.main_thread_divider);
        this.mik = findViewById(R.id.reply_btn_divider);
        this.mil = findViewById(R.id.main_thread_bottom_divider);
        this.mim = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jcA) {
            this.jcA = i;
            if (i == 0) {
                this.mij.setVisibility(0);
                this.mik.setVisibility(4);
                this.mih.setTextColor(this.eQR);
                this.mii.setTextColor(this.eQS);
            } else if (i == 1) {
                this.mij.setVisibility(4);
                this.mik.setVisibility(0);
                this.mih.setTextColor(this.eQS);
                this.mii.setTextColor(this.eQR);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mio = aVar;
    }
}
