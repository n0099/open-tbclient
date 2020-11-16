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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class SearchBoxView extends RelativeLayout {
    private String kFh;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;
    private LinearLayout mUV;
    private TextView mUW;
    private TextView mUX;
    private View.OnClickListener mUY;

    public SearchBoxView(Context context) {
        super(context);
        this.kFh = "sq_tb_search";
        this.mUV = null;
        this.mUW = null;
        this.mUX = null;
        this.mUY = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, RequestResponseCode.REQUEST_CAPTURE_VIEW)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.kFh, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kFh = "sq_tb_search";
        this.mUV = null;
        this.mUW = null;
        this.mUX = null;
        this.mUY = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, RequestResponseCode.REQUEST_CAPTURE_VIEW)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.kFh, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kFh = "sq_tb_search";
        this.mUV = null;
        this.mUW = null;
        this.mUX = null;
        this.mUY = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CaptureActivityConfig(SearchBoxView.this.mCurrentActivity, RequestResponseCode.REQUEST_CAPTURE_VIEW)));
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.square.view.SearchBoxView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.search_bg_layout) {
                    TiebaStatic.eventStat(SearchBoxView.this.mCurrentActivity, SearchBoxView.this.kFh, "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(SearchBoxView.this.mCurrentActivity)));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.widget_search_box, this);
        this.mUV = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.mUW = (TextView) findViewById(R.id.search_bar_text);
        this.mUV.setOnClickListener(this.mOnClickListener);
        this.mUX = (TextView) findViewById(R.id.search_from_qr);
        this.mUX.setOnClickListener(this.mUY);
    }

    public void setClickStatKey(String str) {
        this.kFh = str;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mUV.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mUW.setHint(charSequence);
    }

    public void setText(int i) {
        this.mUW.setHint(i);
    }
}
