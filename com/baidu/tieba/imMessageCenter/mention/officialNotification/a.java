package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int MA = 3;
    private TextView bXt;
    private HeadImageView hLj;
    private TextView hLk;
    private TbRichTextView hLl;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.hLj = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.hLj.setIsRound(true);
        this.hLj.setOnClickListener(onClickListener);
        this.hLj.setPlaceHolder(1);
        this.bXt = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.bXt.setOnClickListener(onClickListener);
        this.hLk = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.hLl = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.hLl.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.hLl.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.hLl.setLayoutStrategy(layoutStrategy);
        this.hLl.setClickable(true);
        this.hLl.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.hLj.setUserId(chatMessage.getUserInfo().getUserId());
            this.hLj.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.hLk.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.hLl != null) {
                j.a(this.mPageContext.getContext(), this.hLl, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.hLl.setContentDescription(stringBuffer.toString());
                    this.hLl.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.MA != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.bXt, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hLk, (int) R.color.cp_cont_d);
            this.hLl.setTextColor(am.getColor(R.color.cp_cont_b));
            this.hLl.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.MA = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
