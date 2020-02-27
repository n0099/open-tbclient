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
/* loaded from: classes9.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int Ni = 3;
    private TextView cbJ;
    private HeadImageView hQK;
    private TextView hQL;
    private TbRichTextView hQM;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.hQK = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.hQK.setIsRound(true);
        this.hQK.setOnClickListener(onClickListener);
        this.hQK.setPlaceHolder(1);
        this.cbJ = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cbJ.setOnClickListener(onClickListener);
        this.hQL = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.hQM = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.hQM.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.hQM.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.hQM.setLayoutStrategy(layoutStrategy);
        this.hQM.setClickable(true);
        this.hQM.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.hQK.setUserId(chatMessage.getUserInfo().getUserId());
            this.hQK.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.hQL.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.hQM != null) {
                j.a(this.mPageContext.getContext(), this.hQM, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.hQM.setContentDescription(stringBuffer.toString());
                    this.hQM.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.Ni != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hQL, (int) R.color.cp_cont_d);
            this.hQM.setTextColor(am.getColor(R.color.cp_cont_b));
            this.hQM.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.Ni = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
