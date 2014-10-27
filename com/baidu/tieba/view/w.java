package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class w extends RelativeLayout {
    private LinearLayout bRA;
    private TextView bRB;
    private TextView bRC;
    private View.OnClickListener bRD;
    private String bRz;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;

    public w(Context context) {
        super(context);
        this.bRz = "sq_tb_search";
        this.bRA = null;
        this.bRB = null;
        this.bRC = null;
        this.bRD = new x(this);
        this.mOnClickListener = new y(this);
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.widget_search_box, this);
        this.bRA = (LinearLayout) findViewById(com.baidu.tieba.v.search_bg_layout);
        this.bRB = (TextView) findViewById(com.baidu.tieba.v.search_bar_text);
        this.bRA.setOnClickListener(this.mOnClickListener);
        this.bRC = (TextView) findViewById(com.baidu.tieba.v.search_from_qr);
        this.bRC.setOnClickListener(this.bRD);
    }

    public void setClickStatKey(String str) {
        this.bRz = str;
    }

    public void onChangeSkinType(int i) {
        if (this.mCurrentActivity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mCurrentActivity;
            baseActivity.getLayoutMode().L(i == 1);
            baseActivity.getLayoutMode().h(this);
        }
        if (this.mCurrentActivity instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mCurrentActivity;
            baseFragmentActivity.getLayoutMode().L(i == 1);
            baseFragmentActivity.getLayoutMode().h(this);
        }
        this.bRB.setHintTextColor(aw.getColor(com.baidu.tieba.s.widget_searchbox_text));
        aw.i(this, com.baidu.tieba.s.search_box_bg);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.bRA.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.bRB.setHint(charSequence);
    }

    public void setText(int i) {
        this.bRB.setHint(i);
    }
}
