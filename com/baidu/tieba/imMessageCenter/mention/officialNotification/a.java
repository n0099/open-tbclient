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
    private int bfL = 3;
    private TextView bfg;
    private HeadImageView eUC;
    private TextView eUD;
    private TbRichTextView eUE;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.official_notification_text_item, viewGroup, false);
        this.eUC = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eUC.setIsRound(true);
        this.eUC.setOnClickListener(onClickListener);
        this.bfg = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.bfg.setOnClickListener(onClickListener);
        this.eUD = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eUE = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eUE.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eUE.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eUE.setLayoutStrategy(layoutStrategy);
        this.eUE.setClickable(true);
        this.eUE.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eUC.setUserId(chatMessage.getUserInfo().getUserId());
            this.eUC.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eUD.setText(am.A(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eUE != null) {
                j.a(this.mPageContext.getContext(), this.eUE, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eUE.setContentDescription(stringBuffer.toString());
                    this.eUE.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bfL != TbadkCoreApplication.getInst().getSkinType()) {
            aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
            aj.r(this.bfg, d.C0140d.cp_cont_f);
            aj.r(this.eUD, d.C0140d.cp_cont_d);
            this.eUE.setTextColor(aj.getColor(d.C0140d.cp_cont_b));
            this.eUE.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
            aj.t(this.mBottomLine, d.C0140d.cp_bg_line_c);
            this.bfL = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
