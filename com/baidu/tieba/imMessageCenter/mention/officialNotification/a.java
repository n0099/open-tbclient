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
/* loaded from: classes7.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int MH = 3;
    private TextView bXF;
    private HeadImageView hOM;
    private TextView hON;
    private TbRichTextView hOO;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.hOM = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.hOM.setIsRound(true);
        this.hOM.setOnClickListener(onClickListener);
        this.hOM.setPlaceHolder(1);
        this.bXF = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.bXF.setOnClickListener(onClickListener);
        this.hON = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.hOO = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.hOO.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.hOO.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.hOO.setLayoutStrategy(layoutStrategy);
        this.hOO.setClickable(true);
        this.hOO.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.hOM.setUserId(chatMessage.getUserInfo().getUserId());
            this.hOM.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.hON.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.hOO != null) {
                j.a(this.mPageContext.getContext(), this.hOO, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.hOO.setContentDescription(stringBuffer.toString());
                    this.hOO.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.MH != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.bXF, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hON, (int) R.color.cp_cont_d);
            this.hOO.setTextColor(am.getColor(R.color.cp_cont_b));
            this.hOO.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.MH = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
