package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonTabView extends LinearLayout {
    private int fgO;
    private int fgP;
    private int jFy;
    private Context mContext;
    private View mIA;
    private a mIB;
    private TextView mIv;
    private TextView mIw;
    private View mIx;
    private View mIy;
    private View mIz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes7.dex */
    public interface a {
        void onTabSelect(int i);
    }

    public PersonTabView(Context context) {
        super(context);
        this.jFy = 0;
        this.fgO = ap.getColor(R.color.CAM_X0105);
        this.fgP = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mIB != null) {
                    PersonTabView.this.mIB.onTabSelect(PersonTabView.this.jFy);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFy = 0;
        this.fgO = ap.getColor(R.color.CAM_X0105);
        this.fgP = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mIB != null) {
                    PersonTabView.this.mIB.onTabSelect(PersonTabView.this.jFy);
                }
            }
        };
        init(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFy = 0;
        this.fgO = ap.getColor(R.color.CAM_X0105);
        this.fgP = ap.getColor(R.color.CAM_X0106);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.main_thread_btn) {
                    PersonTabView.this.setCurrentTab(0);
                } else if (view.getId() == R.id.reply_btn) {
                    PersonTabView.this.setCurrentTab(1);
                }
                if (PersonTabView.this.mIB != null) {
                    PersonTabView.this.mIB.onTabSelect(PersonTabView.this.jFy);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.person_button_header_view, this);
        this.mIv = (TextView) findViewById(R.id.main_thread_btn);
        this.mIv.setOnClickListener(this.mOnClickListener);
        this.mIw = (TextView) findViewById(R.id.reply_btn);
        this.mIw.setOnClickListener(this.mOnClickListener);
        this.mIx = findViewById(R.id.main_thread_divider);
        this.mIy = findViewById(R.id.reply_btn_divider);
        this.mIz = findViewById(R.id.main_thread_bottom_divider);
        this.mIA = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i) {
        if (i != this.jFy) {
            this.jFy = i;
            if (i == 0) {
                this.mIx.setVisibility(0);
                this.mIy.setVisibility(4);
                this.mIv.setTextColor(this.fgO);
                this.mIw.setTextColor(this.fgP);
            } else if (i == 1) {
                this.mIx.setVisibility(4);
                this.mIy.setVisibility(0);
                this.mIv.setTextColor(this.fgP);
                this.mIw.setTextColor(this.fgO);
            }
        }
    }

    public void setOnTabSelectListener(a aVar) {
        this.mIB = aVar;
    }
}
