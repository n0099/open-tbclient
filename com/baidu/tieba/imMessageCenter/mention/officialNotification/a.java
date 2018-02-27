package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView beT;
    private int bfz = 3;
    private HeadImageView eUq;
    private TextView eUr;
    private TbRichTextView eUs;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.official_notification_text_item, viewGroup, false);
        this.eUq = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eUq.setIsRound(true);
        this.eUq.setOnClickListener(onClickListener);
        this.beT = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.beT.setOnClickListener(onClickListener);
        this.eUr = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eUs = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eUs.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eUs.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eUs.setLayoutStrategy(layoutStrategy);
        this.eUs.setClickable(true);
        this.eUs.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eUq.setUserId(chatMessage.getUserInfo().getUserId());
            this.eUq.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eUr.setText(am.A(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eUs != null) {
                j.a(this.mPageContext.getContext(), this.eUs, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eUs.setContentDescription(stringBuffer.toString());
                    this.eUs.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bfz != TbadkCoreApplication.getInst().getSkinType()) {
            aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.r(this.beT, d.C0141d.cp_cont_f);
            aj.r(this.eUr, d.C0141d.cp_cont_d);
            this.eUs.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
            this.eUs.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_c);
            this.bfz = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
