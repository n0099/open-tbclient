package com.baidu.tieba.square.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class SearchBoxView extends RelativeLayout {
    private String gGD;
    private LinearLayout iDe;
    private TextView iDf;
    private TextView iDg;
    private View.OnClickListener iDh;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;

    public SearchBoxView(Context context) {
        super(context);
        this.gGD = "sq_tb_search";
        this.iDe = null;
        this.iDf = null;
        this.iDg = null;
        this.iDh = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gGD, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gGD = "sq_tb_search";
        this.iDe = null;
        this.iDf = null;
        this.iDg = null;
        this.iDh = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gGD, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gGD = "sq_tb_search";
        this.iDe = null;
        this.iDf = null;
        this.iDg = null;
        this.iDh = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gGD, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        LayoutInflater.from(context).inflate(d.h.widget_search_box, this);
        this.iDe = (LinearLayout) findViewById(d.g.search_bg_layout);
        this.iDf = (TextView) findViewById(d.g.search_bar_text);
        this.iDe.setOnClickListener(this.mOnClickListener);
        this.iDg = (TextView) findViewById(d.g.search_from_qr);
        this.iDg.setOnClickListener(this.iDh);
    }

    public void setClickStatKey(String str) {
        this.gGD = str;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iDe.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.iDf.setHint(charSequence);
    }

    public void setText(int i) {
        this.iDf.setHint(i);
    }
}
