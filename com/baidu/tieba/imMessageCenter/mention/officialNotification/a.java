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
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int ayX = 3;
    private TextView ayt;
    private HeadImageView eBH;
    private TextView eBI;
    private TbRichTextView eBJ;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.official_notification_text_item, viewGroup, false);
        this.eBH = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eBH.setIsRound(true);
        this.eBH.setOnClickListener(onClickListener);
        this.ayt = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.ayt.setOnClickListener(onClickListener);
        this.eBI = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eBJ = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eBJ.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eBJ.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eBJ.setLayoutStrategy(layoutStrategy);
        this.eBJ.setClickable(true);
        this.eBJ.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eBH.setUserId(chatMessage.getUserInfo().getUserId());
            this.eBH.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eBI.setText(ao.w(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eBJ != null) {
                j.a(this.mPageContext.getContext(), this.eBJ, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eBJ.setContentDescription(stringBuffer.toString());
                    this.eBJ.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ayX != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, d.C0141d.cp_bg_line_d);
            al.h(this.ayt, d.C0141d.cp_cont_f);
            al.h(this.eBI, d.C0141d.cp_cont_d);
            this.eBJ.setTextColor(al.getColor(d.C0141d.cp_cont_b));
            this.eBJ.setLinkTextColor(al.getColor(d.C0141d.cp_link_tip_c));
            al.j(this.mBottomLine, d.C0141d.cp_bg_line_c);
            this.ayX = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
