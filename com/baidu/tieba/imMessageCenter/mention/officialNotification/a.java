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
    private TextView aGD;
    private int aHp = 3;
    private HeadImageView eYj;
    private TextView eYk;
    private TbRichTextView eYl;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.official_notification_text_item, viewGroup, false);
        this.eYj = (HeadImageView) this.mRootView.findViewById(e.g.iv_head);
        this.eYj.setIsRound(true);
        this.eYj.setOnClickListener(onClickListener);
        this.aGD = (TextView) this.mRootView.findViewById(e.g.tv_user_name);
        this.aGD.setOnClickListener(onClickListener);
        this.eYk = (TextView) this.mRootView.findViewById(e.g.tv_date);
        this.eYl = (TbRichTextView) this.mRootView.findViewById(e.g.tv_content);
        this.eYl.setTextSize(tbPageContext.getResources().getDimension(e.C0175e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eYl.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(e.C0175e.tbds12), 1.0f);
        this.eYl.setLayoutStrategy(layoutStrategy);
        this.eYl.setClickable(true);
        this.eYl.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(e.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eYj.setUserId(chatMessage.getUserInfo().getUserId());
            this.eYj.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eYk.setText(ao.E(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eYl != null) {
                j.a(this.mPageContext.getContext(), this.eYl, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eYl.setContentDescription(stringBuffer.toString());
                    this.eYl.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aHp != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.mRootView, e.d.cp_bg_line_d);
            al.h(this.aGD, e.d.cp_cont_f);
            al.h(this.eYk, e.d.cp_cont_d);
            this.eYl.setTextColor(al.getColor(e.d.cp_cont_b));
            this.eYl.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aHp = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
