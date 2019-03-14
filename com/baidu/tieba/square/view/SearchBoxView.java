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
    private String gGQ;
    private LinearLayout iDu;
    private TextView iDv;
    private TextView iDw;
    private View.OnClickListener iDx;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;

    public SearchBoxView(Context context) {
        super(context);
        this.gGQ = "sq_tb_search";
        this.iDu = null;
        this.iDv = null;
        this.iDw = null;
        this.iDx = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gGQ, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gGQ = "sq_tb_search";
        this.iDu = null;
        this.iDv = null;
        this.iDw = null;
        this.iDx = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gGQ, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gGQ = "sq_tb_search";
        this.iDu = null;
        this.iDv = null;
        this.iDw = null;
        this.iDx = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gGQ, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        LayoutInflater.from(context).inflate(d.h.widget_search_box, this);
        this.iDu = (LinearLayout) findViewById(d.g.search_bg_layout);
        this.iDv = (TextView) findViewById(d.g.search_bar_text);
        this.iDu.setOnClickListener(this.mOnClickListener);
        this.iDw = (TextView) findViewById(d.g.search_from_qr);
        this.iDw.setOnClickListener(this.iDx);
    }

    public void setClickStatKey(String str) {
        this.gGQ = str;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iDu.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.iDv.setHint(charSequence);
    }

    public void setText(int i) {
        this.iDv.setHint(i);
    }
}
