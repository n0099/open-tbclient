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
    private int eMa;
    private int eMb;
    private int iVR;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mbQ;
    private TextView mbR;
    private View mbS;
    private View mbT;
    private View mbU;
    private View mbV;
    private a mbW;

    /* loaded from: classes24.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.iVR = 0;
        this.eMa = ap.getColor(R.color.cp_cont_b);
        this.eMb = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mbW != null) {
                    PersonTabView.this.mbW.onTabSelect(PersonTabView.this.iVR);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVR = 0;
        this.eMa = ap.getColor(R.color.cp_cont_b);
        this.eMb = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mbW != null) {
                    PersonTabView.this.mbW.onTabSelect(PersonTabView.this.iVR);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVR = 0;
        this.eMa = ap.getColor(R.color.cp_cont_b);
        this.eMb = ap.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mbW != null) {
                    PersonTabView.this.mbW.onTabSelect(PersonTabView.this.iVR);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mbQ = (TextView) findViewById(R.id.main_thread_btn);
        this.mbQ.setOnClickListener(this.mOnClickListener);
        this.mbR = (TextView) findViewById(R.id.reply_btn);
        this.mbR.setOnClickListener(this.mOnClickListener);
        this.mbS = findViewById(R.id.main_thread_divider);
        this.mbT = findViewById(R.id.reply_btn_divider);
        this.mbU = findViewById(R.id.main_thread_bottom_divider);
        this.mbV = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.iVR) {
            this.iVR = i;
            if (i == 0) {
                this.mbS.setVisibility(0);
                this.mbT.setVisibility(4);
                this.mbQ.setTextColor(this.eMa);
                this.mbR.setTextColor(this.eMb);
            } else if (i == 1) {
                this.mbS.setVisibility(4);
                this.mbT.setVisibility(0);
                this.mbQ.setTextColor(this.eMb);
                this.mbR.setTextColor(this.eMa);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mbW = aVar;
    }
}
