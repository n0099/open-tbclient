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
    private TextView crw;
    private int csg = 3;
    private HeadImageView gXi;
    private TextView gXj;
    private TbRichTextView gXk;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.gXi = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.gXi.setIsRound(true);
        this.gXi.setOnClickListener(onClickListener);
        this.crw = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.crw.setOnClickListener(onClickListener);
        this.gXj = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.gXk = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.gXk.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.gXk.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.gXk.setLayoutStrategy(layoutStrategy);
        this.gXk.setClickable(true);
        this.gXk.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.gXi.setUserId(chatMessage.getUserInfo().getUserId());
            this.gXi.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.gXj.setText(aq.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.gXk != null) {
                j.a(this.mPageContext.getContext(), this.gXk, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.gXk.setContentDescription(stringBuffer.toString());
                    this.gXk.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.csg != TbadkCoreApplication.getInst().getSkinType()) {
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.crw, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.gXj, (int) R.color.cp_cont_d);
            this.gXk.setTextColor(am.getColor(R.color.cp_cont_b));
            this.gXk.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.csg = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
