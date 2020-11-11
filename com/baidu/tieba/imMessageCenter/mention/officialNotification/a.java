package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes22.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int ajq = 3;
    private TextView ewx;
    private HeadImageView kwN;
    private TextView kwO;
    private TbRichTextView kwP;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kwN = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kwN.setIsRound(true);
        this.kwN.setOnClickListener(onClickListener);
        this.kwN.setPlaceHolder(1);
        this.ewx = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.ewx.setOnClickListener(onClickListener);
        this.kwO = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.kwP = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.kwP.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.kwP.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.kwP.setLayoutStrategy(layoutStrategy);
        this.kwP.setClickable(true);
        this.kwP.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kwN.setUserId(chatMessage.getUserInfo().getUserId());
            this.kwN.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kwO.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.kwP != null) {
                j.a(this.mPageContext.getContext(), this.kwP, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.kwP.setContentDescription(stringBuffer.toString());
                    this.kwP.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ajq != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.ewx, R.color.cp_cont_f);
            ap.setViewTextColor(this.kwO, R.color.cp_cont_d);
            this.kwP.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.kwP.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.ajq = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
