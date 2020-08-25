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
/* loaded from: classes16.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int aiB = 3;
    private TextView dTQ;
    private HeadImageView jGM;
    private TextView jGN;
    private TbRichTextView jGO;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.jGM = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.jGM.setIsRound(true);
        this.jGM.setOnClickListener(onClickListener);
        this.jGM.setPlaceHolder(1);
        this.dTQ = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.dTQ.setOnClickListener(onClickListener);
        this.jGN = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jGO = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jGO.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jGO.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jGO.setLayoutStrategy(layoutStrategy);
        this.jGO.setClickable(true);
        this.jGO.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.jGM.setUserId(chatMessage.getUserInfo().getUserId());
            this.jGM.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.jGN.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jGO != null) {
                j.a(this.mPageContext.getContext(), this.jGO, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jGO.setContentDescription(stringBuffer.toString());
                    this.jGO.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aiB != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_f);
            ap.setViewTextColor(this.jGN, R.color.cp_cont_d);
            this.jGO.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.jGO.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.aiB = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
