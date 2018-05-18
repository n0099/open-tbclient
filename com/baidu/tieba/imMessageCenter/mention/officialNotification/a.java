package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int aqQ = 3;
    private TextView aqm;
    private HeadImageView eqq;
    private TextView eqr;
    private TbRichTextView eqs;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.official_notification_text_item, viewGroup, false);
        this.eqq = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eqq.setIsRound(true);
        this.eqq.setOnClickListener(onClickListener);
        this.aqm = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.aqm.setOnClickListener(onClickListener);
        this.eqr = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eqs = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eqs.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eqs.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eqs.setLayoutStrategy(layoutStrategy);
        this.eqs.setClickable(true);
        this.eqs.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eqq.setUserId(chatMessage.getUserInfo().getUserId());
            this.eqq.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eqr.setText(an.t(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eqs != null) {
                j.a(this.mPageContext.getContext(), this.eqs, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eqs.setContentDescription(stringBuffer.toString());
                    this.eqs.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aqQ != TbadkCoreApplication.getInst().getSkinType()) {
            ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
            ak.h(this.eqr, d.C0126d.cp_cont_d);
            this.eqs.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
            this.eqs.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_c);
            this.aqQ = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
