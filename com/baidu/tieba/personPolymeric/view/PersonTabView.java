package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonTabView extends LinearLayout {
    private int fda;
    private int fdb;
    private int jxW;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mwW;
    private TextView mwX;
    private View mwY;
    private View mwZ;
    private View mxa;
    private View mxb;
    private a mxc;

    /* loaded from: classes7.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jxW = 0;
        this.fda = ao.getColor(R.color.CAM_X0105);
        this.fdb = ao.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mxc != null) {
                    PersonTabView.this.mxc.onTabSelect(PersonTabView.this.jxW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jxW = 0;
        this.fda = ao.getColor(R.color.CAM_X0105);
        this.fdb = ao.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mxc != null) {
                    PersonTabView.this.mxc.onTabSelect(PersonTabView.this.jxW);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxW = 0;
        this.fda = ao.getColor(R.color.CAM_X0105);
        this.fdb = ao.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mxc != null) {
                    PersonTabView.this.mxc.onTabSelect(PersonTabView.this.jxW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mwW = (TextView) findViewById(R.id.main_thread_btn);
        this.mwW.setOnClickListener(this.mOnClickListener);
        this.mwX = (TextView) findViewById(R.id.reply_btn);
        this.mwX.setOnClickListener(this.mOnClickListener);
        this.mwY = findViewById(R.id.main_thread_divider);
        this.mwZ = findViewById(R.id.reply_btn_divider);
        this.mxa = findViewById(R.id.main_thread_bottom_divider);
        this.mxb = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jxW) {
            this.jxW = i;
            if (i == 0) {
                this.mwY.setVisibility(0);
                this.mwZ.setVisibility(4);
                this.mwW.setTextColor(this.fda);
                this.mwX.setTextColor(this.fdb);
            } else if (i == 1) {
                this.mwY.setVisibility(4);
                this.mwZ.setVisibility(0);
                this.mwW.setTextColor(this.fdb);
                this.mwX.setTextColor(this.fda);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mxc = aVar;
    }
}
