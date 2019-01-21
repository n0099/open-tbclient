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
    private TextView aLy;
    private int aMk = 3;
    private HeadImageView fka;
    private TextView fkb;
    private TbRichTextView fkc;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.official_notification_text_item, viewGroup, false);
        this.fka = (HeadImageView) this.mRootView.findViewById(e.g.iv_head);
        this.fka.setIsRound(true);
        this.fka.setOnClickListener(onClickListener);
        this.aLy = (TextView) this.mRootView.findViewById(e.g.tv_user_name);
        this.aLy.setOnClickListener(onClickListener);
        this.fkb = (TextView) this.mRootView.findViewById(e.g.tv_date);
        this.fkc = (TbRichTextView) this.mRootView.findViewById(e.g.tv_content);
        this.fkc.setTextSize(tbPageContext.getResources().getDimension(e.C0210e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.fkc.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(e.C0210e.tbds12), 1.0f);
        this.fkc.setLayoutStrategy(layoutStrategy);
        this.fkc.setClickable(true);
        this.fkc.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.fka.setUserId(chatMessage.getUserInfo().getUserId());
            this.fka.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.fkb.setText(ao.O(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.fkc != null) {
                j.a(this.mPageContext.getContext(), this.fkc, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.fkc.setContentDescription(stringBuffer.toString());
                    this.fkc.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aMk != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.aLy, e.d.cp_cont_f);
            al.h(this.fkb, e.d.cp_cont_d);
            this.fkc.setTextColor(al.getColor(e.d.cp_cont_b));
            this.fkc.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aMk = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
