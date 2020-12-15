package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes22.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int aku = 3;
    private TextView eBQ;
    private TbRichTextView jhs;
    private HeadImageView kKS;
    private TextView kKT;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kKS = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kKS.setIsRound(true);
        this.kKS.setOnClickListener(onClickListener);
        this.kKS.setPlaceHolder(1);
        this.eBQ = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eBQ.setOnClickListener(onClickListener);
        this.kKT = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jhs = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jhs.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jhs.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jhs.setLayoutStrategy(layoutStrategy);
        this.jhs.setClickable(true);
        this.jhs.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kKS.setUserId(chatMessage.getUserInfo().getUserId());
            this.kKS.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kKT.setText(au.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jhs != null) {
                j.a(this.mPageContext.getContext(), this.jhs, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jhs.setContentDescription(stringBuffer.toString());
                    this.jhs.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.aku != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0106);
            ap.setViewTextColor(this.kKT, R.color.CAM_X0109);
            this.jhs.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jhs.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            this.aku = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
