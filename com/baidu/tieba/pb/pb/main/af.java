package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class af extends af.a {
    private String kPo;
    private CustomMessageListener kgy;
    private LinearLayout mContainer;
    private ProgressBar mProgressBar;
    private View mRoot;
    private TextView mTextView;

    public af(View view, BdUniqueId bdUniqueId) {
        super(view);
        this.kgy = new CustomMessageListener(2921471) { // from class: com.baidu.tieba.pb.pb.main.af.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        af.this.startLoadData();
                    } else {
                        af.this.endLoadData();
                    }
                }
            }
        };
        this.mRoot = view;
        this.mContainer = (LinearLayout) view.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) view.findViewById(R.id.pb_more_text);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mContainer.setVisibility(0);
        this.kgy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.kgy);
        onChangeSkinType();
    }

    public void ao(String str, int i) {
        this.kPo = str;
        this.mTextView.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        this.mTextView.setTextColor(com.baidu.tbadk.core.util.ap.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.cp_cont_d));
        this.mContainer.setBackgroundResource(R.drawable.pb_foot_more_trans_selector);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mRoot.setOnClickListener(onClickListener);
    }

    public void startLoadData() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.loading));
    }

    public void endLoadData() {
        this.mProgressBar.setVisibility(8);
        if (this.kPo != null) {
            this.mTextView.setText(this.kPo);
        } else {
            this.mTextView.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.pb_load_more));
        }
    }
}
