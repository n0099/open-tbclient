package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.h {
    private LinearLayout Hl;
    private String bRK;
    private ImageView bRL;
    private int bRM;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private ProgressBar mProgressBar;
    private View mRoot;
    private TextView mTextView;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (bRN) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public String aeT() {
        return this.bRK;
    }

    public PbListView(Context context) {
        this.mContext = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.bRK = null;
        this.Hl = null;
        this.bRL = null;
        this.bRM = 0;
        this.mContext = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.new_pb_list_more, null);
        this.Hl = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view);
        this.mTextView = (TextView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_text);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.bRL = (ImageView) this.mRoot.findViewById(com.baidu.tieba.v.pb_more_view_top_line);
        return this.mRoot;
    }

    public void aeU() {
        this.bRL.setVisibility(0);
    }

    public void YK() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mContext.getText(com.baidu.tieba.y.loading));
        bM(TbadkApplication.m251getInst().getSkinType());
    }

    public void XW() {
        this.mProgressBar.setVisibility(8);
        if (this.bRK != null) {
            this.mTextView.setText(this.bRK);
        } else {
            this.mTextView.setText(this.mContext.getText(com.baidu.tieba.y.pb_load_more));
        }
        bM(TbadkApplication.m251getInst().getSkinType());
    }

    public void hC(int i) {
        aw.h(this.Hl, i);
    }

    public void setText(String str) {
        this.bRK = str;
        this.mTextView.setText(str);
        bM(TbadkApplication.m251getInst().getSkinType());
    }

    public void setTextColor(int i) {
        if (i > 0) {
            this.mTextView.setTextColor(i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void hD(int i) {
        this.bRM = i;
    }

    public void bM(int i) {
        String charSequence = this.mTextView.getText().toString();
        int i2 = 0;
        if (charSequence.equals(this.mContext.getText(com.baidu.tieba.y.pb_load_more))) {
            i2 = aw.getColor(com.baidu.tieba.s.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.y.loading))) {
            i2 = aw.getColor(com.baidu.tieba.s.pb_more_txt);
        } else if (charSequence.equals(this.mContext.getText(com.baidu.tieba.y.no_more_to_load))) {
            i2 = aw.getColor(com.baidu.tieba.s.pb_list_morebutton_nomore_text);
        }
        setTextColor(i2);
        aw.c(this.bRL, com.baidu.tieba.s.cp_bg_line_b);
        if (this.bRM == 0) {
            aw.h(this.Hl, com.baidu.tieba.s.cp_bg_line_d);
        } else if (this.bRM > 0) {
            aw.h(this.Hl, this.bRM);
        }
    }
}
