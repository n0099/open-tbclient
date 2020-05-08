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
    private int afW = 3;
    private TextView cBd;
    private HeadImageView iCv;
    private TextView iCw;
    private TbRichTextView iCx;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.iCv = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.iCv.setIsRound(true);
        this.iCv.setOnClickListener(onClickListener);
        this.iCv.setPlaceHolder(1);
        this.cBd = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cBd.setOnClickListener(onClickListener);
        this.iCw = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.iCx = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.iCx.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.iCx.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.iCx.setLayoutStrategy(layoutStrategy);
        this.iCx.setClickable(true);
        this.iCx.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.iCv.setUserId(chatMessage.getUserInfo().getUserId());
            this.iCv.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.iCw.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.iCx != null) {
                j.a(this.mPageContext.getContext(), this.iCx, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.iCx.setContentDescription(stringBuffer.toString());
                    this.iCx.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.afW != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cBd, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.iCw, (int) R.color.cp_cont_d);
            this.iCx.setTextColor(am.getColor(R.color.cp_cont_b));
            this.iCx.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.afW = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
