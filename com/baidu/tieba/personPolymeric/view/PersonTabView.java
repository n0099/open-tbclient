package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonTabView extends LinearLayout {
    private int bWH;
    private int bWI;
    private int fFX;
    private TextView inJ;
    private TextView inK;
    private View inL;
    private View inM;
    private View inN;
    private View inO;
    private a inP;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void yn(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.fFX = 0;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inP != null) {
                    PersonTabView.this.inP.yn(PersonTabView.this.fFX);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFX = 0;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inP != null) {
                    PersonTabView.this.inP.yn(PersonTabView.this.fFX);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFX = 0;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_f);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.inP != null) {
                    PersonTabView.this.inP.yn(PersonTabView.this.fFX);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.inJ = (TextView) findViewById(R.id.main_thread_btn);
        this.inJ.setOnClickListener(this.mOnClickListener);
        this.inK = (TextView) findViewById(R.id.reply_btn);
        this.inK.setOnClickListener(this.mOnClickListener);
        this.inL = findViewById(R.id.main_thread_divider);
        this.inM = findViewById(R.id.reply_btn_divider);
        this.inN = findViewById(R.id.main_thread_bottom_divider);
        this.inO = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.fFX) {
            this.fFX = i;
            if (i == 0) {
                this.inL.setVisibility(0);
                this.inM.setVisibility(4);
                this.inJ.setTextColor(this.bWH);
                this.inK.setTextColor(this.bWI);
            } else if (i == 1) {
                this.inL.setVisibility(4);
                this.inM.setVisibility(0);
                this.inJ.setTextColor(this.bWI);
                this.inK.setTextColor(this.bWH);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.inP = aVar;
    }
}
