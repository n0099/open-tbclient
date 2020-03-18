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
    private int deR;
    private int deS;
    private TextView juE;
    private TextView juF;
    private View juG;
    private View juH;
    private View juI;
    private View juJ;
    private a juK;
    private Context mContext;
    private int mCurrentTab;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes11.dex */
    public interface a {
        void Aq(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.mCurrentTab = 0;
        this.deR = am.getColor(R.color.cp_cont_b);
        this.deS = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.juK != null) {
                    PersonTabView.this.juK.Aq(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTab = 0;
        this.deR = am.getColor(R.color.cp_cont_b);
        this.deS = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.juK != null) {
                    PersonTabView.this.juK.Aq(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentTab = 0;
        this.deR = am.getColor(R.color.cp_cont_b);
        this.deS = am.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.juK != null) {
                    PersonTabView.this.juK.Aq(PersonTabView.this.mCurrentTab);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.juE = (TextView) findViewById(R.id.main_thread_btn);
        this.juE.setOnClickListener(this.mOnClickListener);
        this.juF = (TextView) findViewById(R.id.reply_btn);
        this.juF.setOnClickListener(this.mOnClickListener);
        this.juG = findViewById(R.id.main_thread_divider);
        this.juH = findViewById(R.id.reply_btn_divider);
        this.juI = findViewById(R.id.main_thread_bottom_divider);
        this.juJ = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentTab) {
            this.mCurrentTab = i;
            if (i == 0) {
                this.juG.setVisibility(0);
                this.juH.setVisibility(4);
                this.juE.setTextColor(this.deR);
                this.juF.setTextColor(this.deS);
            } else if (i == 1) {
                this.juG.setVisibility(4);
                this.juH.setVisibility(0);
                this.juE.setTextColor(this.deS);
                this.juF.setTextColor(this.deR);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.juK = aVar;
    }
}
