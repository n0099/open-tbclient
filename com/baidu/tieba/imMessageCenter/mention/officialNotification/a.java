package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView cbW;
    private int ccJ = 3;
    private HeadImageView gRb;
    private TextView gRc;
    private TbRichTextView gRd;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.gRb = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.gRb.setIsRound(true);
        this.gRb.setOnClickListener(onClickListener);
        this.cbW = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cbW.setOnClickListener(onClickListener);
        this.gRc = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.gRd = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.gRd.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gRd.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.gRd.setLayoutStrategy(layoutStrategy);
        this.gRd.setClickable(true);
        this.gRd.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gRb.setUserId(chatMessage.getUserInfo().getUserId());
            this.gRb.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gRc.setText(ap.aE(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gRd != null) {
                j.a(this.mPageContext.getContext(), this.gRd, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gRd.setContentDescription(stringBuffer.toString());
                    this.gRd.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ccJ != TbadkCoreApplication.getInst().getSkinType()) {
            al.l(this.mRootView, R.color.cp_bg_line_d);
            al.j(this.cbW, R.color.cp_cont_f);
            al.j(this.gRc, R.color.cp_cont_d);
            this.gRd.setTextColor(al.getColor(R.color.cp_cont_b));
            this.gRd.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            al.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.ccJ = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
