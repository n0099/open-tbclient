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
    private TextView cbV;
    private int ccI = 3;
    private HeadImageView gQZ;
    private TextView gRa;
    private TbRichTextView gRb;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.gQZ = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.gQZ.setIsRound(true);
        this.gQZ.setOnClickListener(onClickListener);
        this.cbV = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cbV.setOnClickListener(onClickListener);
        this.gRa = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.gRb = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.gRb.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gRb.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.gRb.setLayoutStrategy(layoutStrategy);
        this.gRb.setClickable(true);
        this.gRb.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gQZ.setUserId(chatMessage.getUserInfo().getUserId());
            this.gQZ.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gRa.setText(ap.aE(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gRb != null) {
                j.a(this.mPageContext.getContext(), this.gRb, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gRb.setContentDescription(stringBuffer.toString());
                    this.gRb.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ccI != TbadkCoreApplication.getInst().getSkinType()) {
            al.l(this.mRootView, R.color.cp_bg_line_d);
            al.j(this.cbV, R.color.cp_cont_f);
            al.j(this.gRa, R.color.cp_cont_d);
            this.gRb.setTextColor(al.getColor(R.color.cp_cont_b));
            this.gRb.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            al.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.ccI = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
