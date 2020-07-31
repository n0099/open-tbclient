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
    private HeadImageView jrM;
    private TextView jrN;
    private TbRichTextView jrO;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.jrM = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.jrM.setIsRound(true);
        this.jrM.setOnClickListener(onClickListener);
        this.jrM.setPlaceHolder(1);
        this.dKI = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.dKI.setOnClickListener(onClickListener);
        this.jrN = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jrO = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jrO.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jrO.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jrO.setLayoutStrategy(layoutStrategy);
        this.jrO.setClickable(true);
        this.jrO.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.jrM.setUserId(chatMessage.getUserInfo().getUserId());
            this.jrM.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.jrN.setText(as.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jrO != null) {
                j.a(this.mPageContext.getContext(), this.jrO, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jrO.setContentDescription(stringBuffer.toString());
                    this.jrO.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aho != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.dKI, R.color.cp_cont_f);
            ao.setViewTextColor(this.jrN, R.color.cp_cont_d);
            this.jrO.setTextColor(ao.getColor(R.color.cp_cont_b));
            this.jrO.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.aho = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
