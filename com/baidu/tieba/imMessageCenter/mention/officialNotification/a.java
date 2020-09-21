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
/* loaded from: classes21.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int aiX = 3;
    private TextView dWe;
    private HeadImageView jPu;
    private TextView jPv;
    private TbRichTextView jPw;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.jPu = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.jPu.setIsRound(true);
        this.jPu.setOnClickListener(onClickListener);
        this.jPu.setPlaceHolder(1);
        this.dWe = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.dWe.setOnClickListener(onClickListener);
        this.jPv = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jPw = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jPw.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jPw.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jPw.setLayoutStrategy(layoutStrategy);
        this.jPw.setClickable(true);
        this.jPw.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.jPu.setUserId(chatMessage.getUserInfo().getUserId());
            this.jPu.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.jPv.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jPw != null) {
                j.a(this.mPageContext.getContext(), this.jPw, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jPw.setContentDescription(stringBuffer.toString());
                    this.jPw.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aiX != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.dWe, R.color.cp_cont_f);
            ap.setViewTextColor(this.jPv, R.color.cp_cont_d);
            this.jPw.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.jPw.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.aiX = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
