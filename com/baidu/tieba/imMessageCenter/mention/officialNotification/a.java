package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes16.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int aho = 3;
    private TextView dKI;
    private HeadImageView jrO;
    private TextView jrP;
    private TbRichTextView jrQ;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.jrO = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.jrO.setIsRound(true);
        this.jrO.setOnClickListener(onClickListener);
        this.jrO.setPlaceHolder(1);
        this.dKI = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.dKI.setOnClickListener(onClickListener);
        this.jrP = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jrQ = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jrQ.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jrQ.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jrQ.setLayoutStrategy(layoutStrategy);
        this.jrQ.setClickable(true);
        this.jrQ.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.jrO.setUserId(chatMessage.getUserInfo().getUserId());
            this.jrO.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.jrP.setText(as.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jrQ != null) {
                j.a(this.mPageContext.getContext(), this.jrQ, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jrQ.setContentDescription(stringBuffer.toString());
                    this.jrQ.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aho != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.dKI, R.color.cp_cont_f);
            ao.setViewTextColor(this.jrP, R.color.cp_cont_d);
            this.jrQ.setTextColor(ao.getColor(R.color.cp_cont_b));
            this.jrQ.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.aho = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
