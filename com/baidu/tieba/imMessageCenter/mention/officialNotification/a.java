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
    private HeadImageView eph;
    private TextView epi;
    private TbRichTextView epj;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.official_notification_text_item, viewGroup, false);
        this.eph = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eph.setIsRound(true);
        this.eph.setOnClickListener(onClickListener);
        this.aqm = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.aqm.setOnClickListener(onClickListener);
        this.epi = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.epj = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.epj.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.epj.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.epj.setLayoutStrategy(layoutStrategy);
        this.epj.setClickable(true);
        this.epj.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eph.setUserId(chatMessage.getUserInfo().getUserId());
            this.eph.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.epi.setText(an.t(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.epj != null) {
                j.a(this.mPageContext.getContext(), this.epj, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.epj.setContentDescription(stringBuffer.toString());
                    this.epj.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aqQ != TbadkCoreApplication.getInst().getSkinType()) {
            ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
            ak.h(this.epi, d.C0126d.cp_cont_d);
            this.epj.setTextColor(ak.getColor(d.C0126d.cp_cont_b));
            this.epj.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_c);
            this.aqQ = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
