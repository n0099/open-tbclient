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
    private TextView beW;
    private int bfC = 3;
    private HeadImageView eUE;
    private TextView eUF;
    private TbRichTextView eUG;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.official_notification_text_item, viewGroup, false);
        this.eUE = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eUE.setIsRound(true);
        this.eUE.setOnClickListener(onClickListener);
        this.beW = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.beW.setOnClickListener(onClickListener);
        this.eUF = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eUG = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eUG.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eUG.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eUG.setLayoutStrategy(layoutStrategy);
        this.eUG.setClickable(true);
        this.eUG.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eUE.setUserId(chatMessage.getUserInfo().getUserId());
            this.eUE.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eUF.setText(am.A(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eUG != null) {
                j.a(this.mPageContext.getContext(), this.eUG, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eUG.setContentDescription(stringBuffer.toString());
                    this.eUG.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bfC != TbadkCoreApplication.getInst().getSkinType()) {
            aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.r(this.beW, d.C0141d.cp_cont_f);
            aj.r(this.eUF, d.C0141d.cp_cont_d);
            this.eUG.setTextColor(aj.getColor(d.C0141d.cp_cont_b));
            this.eUG.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_c);
            this.bfC = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
