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
    private int Nj = 3;
    private TextView cbW;
    private TbRichTextView hSA;
    private HeadImageView hSy;
    private TextView hSz;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.hSy = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.hSy.setIsRound(true);
        this.hSy.setOnClickListener(onClickListener);
        this.hSy.setPlaceHolder(1);
        this.cbW = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.cbW.setOnClickListener(onClickListener);
        this.hSz = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.hSA = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.hSA.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.hSA.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.hSA.setLayoutStrategy(layoutStrategy);
        this.hSA.setClickable(true);
        this.hSA.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.hSy.setUserId(chatMessage.getUserInfo().getUserId());
            this.hSy.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.hSz.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.hSA != null) {
                j.a(this.mPageContext.getContext(), this.hSA, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.hSA.setContentDescription(stringBuffer.toString());
                    this.hSA.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.Nj != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cbW, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hSz, (int) R.color.cp_cont_d);
            this.hSA.setTextColor(am.getColor(R.color.cp_cont_b));
            this.hSA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.Nj = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
