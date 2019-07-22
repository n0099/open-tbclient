package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getName();
    private TextView ccZ;
    private int cdL = 3;
    private HeadImageView gXl;
    private TextView gXm;
    private TbRichTextView gXn;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.gXl = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.gXl.setIsRound(true);
        this.gXl.setOnClickListener(onClickListener);
        this.ccZ = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.ccZ.setOnClickListener(onClickListener);
        this.gXm = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.gXn = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.gXn.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gXn.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.gXn.setLayoutStrategy(layoutStrategy);
        this.gXn.setClickable(true);
        this.gXn.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gXl.setUserId(chatMessage.getUserInfo().getUserId());
            this.gXl.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gXm.setText(aq.aF(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gXn != null) {
                j.a(this.mPageContext.getContext(), this.gXn, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gXn.setContentDescription(stringBuffer.toString());
                    this.gXn.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cdL != TbadkCoreApplication.getInst().getSkinType()) {
            am.l(this.mRootView, R.color.cp_bg_line_d);
            am.j(this.ccZ, R.color.cp_cont_f);
            am.j(this.gXm, R.color.cp_cont_d);
            this.gXn.setTextColor(am.getColor(R.color.cp_cont_b));
            this.gXn.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.cdL = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
