package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int azP = 3;
    private TextView azm;
    private HeadImageView eFx;
    private TextView eFy;
    private TbRichTextView eFz;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.official_notification_text_item, viewGroup, false);
        this.eFx = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eFx.setIsRound(true);
        this.eFx.setOnClickListener(onClickListener);
        this.azm = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.azm.setOnClickListener(onClickListener);
        this.eFy = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eFz = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eFz.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eFz.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eFz.setLayoutStrategy(layoutStrategy);
        this.eFz.setClickable(true);
        this.eFz.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eFx.setUserId(chatMessage.getUserInfo().getUserId());
            this.eFx.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eFy.setText(ap.x(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eFz != null) {
                j.a(this.mPageContext.getContext(), this.eFz, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eFz.setContentDescription(stringBuffer.toString());
                    this.eFz.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.azP != TbadkCoreApplication.getInst().getSkinType()) {
            am.j(this.mRootView, d.C0142d.cp_bg_line_d);
            am.h(this.azm, d.C0142d.cp_cont_f);
            am.h(this.eFy, d.C0142d.cp_cont_d);
            this.eFz.setTextColor(am.getColor(d.C0142d.cp_cont_b));
            this.eFz.setLinkTextColor(am.getColor(d.C0142d.cp_link_tip_c));
            am.j(this.mBottomLine, d.C0142d.cp_bg_line_c);
            this.azP = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
