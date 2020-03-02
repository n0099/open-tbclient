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
    private TextView cbK;
    private HeadImageView hQM;
    private TextView hQN;
    private TbRichTextView hQO;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.hQM = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.hQM.setIsRound(true);
        this.hQM.setOnClickListener(onClickListener);
        this.hQM.setPlaceHolder(1);
        this.cbK = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cbK.setOnClickListener(onClickListener);
        this.hQN = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.hQO = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.hQO.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.hQO.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.hQO.setLayoutStrategy(layoutStrategy);
        this.hQO.setClickable(true);
        this.hQO.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.hQM.setUserId(chatMessage.getUserInfo().getUserId());
            this.hQM.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.hQN.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.hQO != null) {
                j.a(this.mPageContext.getContext(), this.hQO, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.hQO.setContentDescription(stringBuffer.toString());
                    this.hQO.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.Ni != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cbK, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hQN, (int) R.color.cp_cont_d);
            this.hQO.setTextColor(am.getColor(R.color.cp_cont_b));
            this.hQO.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.Ni = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
