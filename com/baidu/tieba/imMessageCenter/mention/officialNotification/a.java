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
    private TextView aKT;
    private int aLF = 3;
    private HeadImageView fgr;
    private TextView fgs;
    private TbRichTextView fgt;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.official_notification_text_item, viewGroup, false);
        this.fgr = (HeadImageView) this.mRootView.findViewById(e.g.iv_head);
        this.fgr.setIsRound(true);
        this.fgr.setOnClickListener(onClickListener);
        this.aKT = (TextView) this.mRootView.findViewById(e.g.tv_user_name);
        this.aKT.setOnClickListener(onClickListener);
        this.fgs = (TextView) this.mRootView.findViewById(e.g.tv_date);
        this.fgt = (TbRichTextView) this.mRootView.findViewById(e.g.tv_content);
        this.fgt.setTextSize(tbPageContext.getResources().getDimension(e.C0210e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.fgt.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(e.C0210e.tbds12), 1.0f);
        this.fgt.setLayoutStrategy(layoutStrategy);
        this.fgt.setClickable(true);
        this.fgt.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.fgr.setUserId(chatMessage.getUserInfo().getUserId());
            this.fgr.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.fgs.setText(ao.N(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.fgt != null) {
                j.a(this.mPageContext.getContext(), this.fgt, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.fgt.setContentDescription(stringBuffer.toString());
                    this.fgt.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aLF != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.aKT, e.d.cp_cont_f);
            al.h(this.fgs, e.d.cp_cont_d);
            this.fgt.setTextColor(al.getColor(e.d.cp_cont_b));
            this.fgt.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aLF = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
