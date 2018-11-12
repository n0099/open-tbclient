package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView aHt;
    private int aIf = 3;
    private HeadImageView eZC;
    private TextView eZD;
    private TbRichTextView eZE;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.official_notification_text_item, viewGroup, false);
        this.eZC = (HeadImageView) this.mRootView.findViewById(e.g.iv_head);
        this.eZC.setIsRound(true);
        this.eZC.setOnClickListener(onClickListener);
        this.aHt = (TextView) this.mRootView.findViewById(e.g.tv_user_name);
        this.aHt.setOnClickListener(onClickListener);
        this.eZD = (TextView) this.mRootView.findViewById(e.g.tv_date);
        this.eZE = (TbRichTextView) this.mRootView.findViewById(e.g.tv_content);
        this.eZE.setTextSize(tbPageContext.getResources().getDimension(e.C0200e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eZE.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(e.C0200e.tbds12), 1.0f);
        this.eZE.setLayoutStrategy(layoutStrategy);
        this.eZE.setClickable(true);
        this.eZE.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eZC.setUserId(chatMessage.getUserInfo().getUserId());
            this.eZC.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eZD.setText(ao.G(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eZE != null) {
                j.a(this.mPageContext.getContext(), this.eZE, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eZE.setContentDescription(stringBuffer.toString());
                    this.eZE.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aIf != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.aHt, e.d.cp_cont_f);
            al.h(this.eZD, e.d.cp_cont_d);
            this.eZE.setTextColor(al.getColor(e.d.cp_cont_b));
            this.eZE.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aIf = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
