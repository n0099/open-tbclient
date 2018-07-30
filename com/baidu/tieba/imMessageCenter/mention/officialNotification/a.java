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
    private TextView ayY;
    private int azI = 3;
    private HeadImageView eJr;
    private TextView eJs;
    private TbRichTextView eJt;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.official_notification_text_item, viewGroup, false);
        this.eJr = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.eJr.setIsRound(true);
        this.eJr.setOnClickListener(onClickListener);
        this.ayY = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.ayY.setOnClickListener(onClickListener);
        this.eJs = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.eJt = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.eJt.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.eJt.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.eJt.setLayoutStrategy(layoutStrategy);
        this.eJt.setClickable(true);
        this.eJt.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.eJr.setUserId(chatMessage.getUserInfo().getUserId());
            this.eJr.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.eJs.setText(ap.y(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.eJt != null) {
                j.a(this.mPageContext.getContext(), this.eJt, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.eJt.setContentDescription(stringBuffer.toString());
                    this.eJt.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.azI != TbadkCoreApplication.getInst().getSkinType()) {
            am.j(this.mRootView, d.C0140d.cp_bg_line_d);
            am.h(this.ayY, d.C0140d.cp_cont_f);
            am.h(this.eJs, d.C0140d.cp_cont_d);
            this.eJt.setTextColor(am.getColor(d.C0140d.cp_cont_b));
            this.eJt.setLinkTextColor(am.getColor(d.C0140d.cp_link_tip_c));
            am.j(this.mBottomLine, d.C0140d.cp_bg_line_c);
            this.azI = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
