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
    private TextView aLx;
    private int aMj = 3;
    private HeadImageView fjZ;
    private TextView fka;
    private TbRichTextView fkb;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.official_notification_text_item, viewGroup, false);
        this.fjZ = (HeadImageView) this.mRootView.findViewById(e.g.iv_head);
        this.fjZ.setIsRound(true);
        this.fjZ.setOnClickListener(onClickListener);
        this.aLx = (TextView) this.mRootView.findViewById(e.g.tv_user_name);
        this.aLx.setOnClickListener(onClickListener);
        this.fka = (TextView) this.mRootView.findViewById(e.g.tv_date);
        this.fkb = (TbRichTextView) this.mRootView.findViewById(e.g.tv_content);
        this.fkb.setTextSize(tbPageContext.getResources().getDimension(e.C0210e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.fkb.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(e.C0210e.tbds12), 1.0f);
        this.fkb.setLayoutStrategy(layoutStrategy);
        this.fkb.setClickable(true);
        this.fkb.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.fjZ.setUserId(chatMessage.getUserInfo().getUserId());
            this.fjZ.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.fka.setText(ao.O(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.fkb != null) {
                j.a(this.mPageContext.getContext(), this.fkb, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.fkb.setContentDescription(stringBuffer.toString());
                    this.fkb.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aMj != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.aLx, e.d.cp_cont_f);
            al.h(this.fka, e.d.cp_cont_d);
            this.fkb.setTextColor(al.getColor(e.d.cp_cont_b));
            this.fkb.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aMj = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
