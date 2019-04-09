package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int bUN = 3;
    private TextView bUb;
    private HeadImageView gzK;
    private TextView gzL;
    private TbRichTextView gzM;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.official_notification_text_item, viewGroup, false);
        this.gzK = (HeadImageView) this.mRootView.findViewById(d.g.iv_head);
        this.gzK.setIsRound(true);
        this.gzK.setOnClickListener(onClickListener);
        this.bUb = (TextView) this.mRootView.findViewById(d.g.tv_user_name);
        this.bUb.setOnClickListener(onClickListener);
        this.gzL = (TextView) this.mRootView.findViewById(d.g.tv_date);
        this.gzM = (TbRichTextView) this.mRootView.findViewById(d.g.tv_content);
        this.gzM.setTextSize(tbPageContext.getResources().getDimension(d.e.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gzM.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(d.e.tbds12), 1.0f);
        this.gzM.setLayoutStrategy(layoutStrategy);
        this.gzM.setClickable(true);
        this.gzM.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(d.g.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gzK.setUserId(chatMessage.getUserInfo().getUserId());
            this.gzK.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gzL.setText(ap.aq(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gzM != null) {
                j.a(this.mPageContext.getContext(), this.gzM, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gzM.setContentDescription(stringBuffer.toString());
                    this.gzM.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bUN != TbadkCoreApplication.getInst().getSkinType()) {
            al.l(this.mRootView, d.C0277d.cp_bg_line_d);
            al.j(this.bUb, d.C0277d.cp_cont_f);
            al.j(this.gzL, d.C0277d.cp_cont_d);
            this.gzM.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            this.gzM.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
            this.bUN = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
