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
    private int aiD = 3;
    private TextView dTU;
    private HeadImageView jGS;
    private TextView jGT;
    private TbRichTextView jGU;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.jGS = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.jGS.setIsRound(true);
        this.jGS.setOnClickListener(onClickListener);
        this.jGS.setPlaceHolder(1);
        this.dTU = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.dTU.setOnClickListener(onClickListener);
        this.jGT = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jGU = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jGU.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jGU.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jGU.setLayoutStrategy(layoutStrategy);
        this.jGU.setClickable(true);
        this.jGU.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.jGS.setUserId(chatMessage.getUserInfo().getUserId());
            this.jGS.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.jGT.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jGU != null) {
                j.a(this.mPageContext.getContext(), this.jGU, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jGU.setContentDescription(stringBuffer.toString());
                    this.jGU.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aiD != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.dTU, R.color.cp_cont_f);
            ap.setViewTextColor(this.jGT, R.color.cp_cont_d);
            this.jGU.setTextColor(ap.getColor(R.color.cp_cont_b));
            this.jGU.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.aiD = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
