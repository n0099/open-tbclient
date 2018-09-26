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
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView aBX;
    private int aCJ = 3;
    private HeadImageView eQC;
    private TextView eQD;
    private TbRichTextView eQE;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.official_notification_text_item, viewGroup, false);
        this.eQC = (HeadImageView) this.mRootView.findViewById(e.g.iv_head);
        this.eQC.setIsRound(true);
        this.eQC.setOnClickListener(onClickListener);
        this.aBX = (TextView) this.mRootView.findViewById(e.g.tv_user_name);
        this.aBX.setOnClickListener(onClickListener);
        this.eQD = (TextView) this.mRootView.findViewById(e.g.tv_date);
        this.eQE = (TbRichTextView) this.mRootView.findViewById(e.g.tv_content);
        this.eQE.setTextSize(tbPageContext.getResources().getDimension(e.C0141e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eQE.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(e.C0141e.tbds12), 1.0f);
        this.eQE.setLayoutStrategy(layoutStrategy);
        this.eQE.setClickable(true);
        this.eQE.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eQC.setUserId(chatMessage.getUserInfo().getUserId());
            this.eQC.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eQD.setText(ao.C(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eQE != null) {
                j.a(this.mPageContext.getContext(), this.eQE, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eQE.setContentDescription(stringBuffer.toString());
                    this.eQE.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aCJ != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.aBX, e.d.cp_cont_f);
            al.h(this.eQD, e.d.cp_cont_d);
            this.eQE.setTextColor(al.getColor(e.d.cp_cont_b));
            this.eQE.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aCJ = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
