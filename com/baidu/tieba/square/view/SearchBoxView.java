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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class SearchBoxView extends RelativeLayout {
    private String gYb;
    private LinearLayout iVV;
    private TextView iVW;
    private TextView iVX;
    private View.OnClickListener iVY;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;

    public SearchBoxView(Context context) {
        super(context);
        this.gYb = "sq_tb_search";
        this.iVV = null;
        this.iVW = null;
        this.iVX = null;
        this.iVY = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gYb, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYb = "sq_tb_search";
        this.iVV = null;
        this.iVW = null;
        this.iVX = null;
        this.iVY = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gYb, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYb = "sq_tb_search";
        this.iVV = null;
        this.iVW = null;
        this.iVX = null;
        this.iVY = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, 16003)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.gYb, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.widget_search_box, this);
        this.iVV = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.iVW = (TextView) findViewById(R.id.search_bar_text);
        this.iVV.setOnClickListener(this.mOnClickListener);
        this.iVX = (TextView) findViewById(R.id.search_from_qr);
        this.iVX.setOnClickListener(this.iVY);
    }

    public void setClickStatKey(String str) {
        this.gYb = str;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.iVV.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.iVW.setHint(charSequence);
    }

    public void setText(int i) {
        this.iVW.setHint(i);
    }
}
