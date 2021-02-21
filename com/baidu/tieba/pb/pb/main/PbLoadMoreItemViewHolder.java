package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {
    private String lUZ;
    private CustomMessageListener lla;
    private LinearLayout mContainer;
    private ProgressBar mProgressBar;
    private View mRoot;
    private TextView mTextView;

    public PbLoadMoreItemViewHolder(View view, BdUniqueId bdUniqueId) {
        super(view);
        this.lla = new CustomMessageListener(2921471) { // from class: com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PbLoadMoreItemViewHolder.this.startLoadData();
                    } else {
                        PbLoadMoreItemViewHolder.this.endLoadData();
                    }
                }
            }
        };
        this.mRoot = view;
        this.mContainer = (LinearLayout) view.findViewById(R.id.pb_more_view);
        this.mTextView = (TextView) view.findViewById(R.id.pb_more_text);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mContainer.setVisibility(0);
        this.lla.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.lla);
        onChangeSkinType();
    }

    public void av(String str, int i) {
        this.lUZ = str;
        this.mTextView.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        this.mTextView.setTextColor(com.baidu.tbadk.core.util.ap.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0109));
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
        if (this.lUZ != null) {
            this.mTextView.setText(this.lUZ);
        } else {
            this.mTextView.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.pb_load_more));
        }
    }
}
