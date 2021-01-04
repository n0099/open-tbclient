package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.h;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int akW = 3;
    private TextView eLt;
    private TbRichTextView jtS;
    private HeadImageView kQb;
    private TextView kQc;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kQb = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kQb.setIsRound(true);
        this.kQb.setOnClickListener(onClickListener);
        this.kQb.setPlaceHolder(1);
        this.eLt = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eLt.setOnClickListener(onClickListener);
        this.kQc = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jtS = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jtS.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jtS.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jtS.setLayoutStrategy(layoutStrategy);
        this.jtS.setClickable(true);
        this.jtS.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kQb.setUserId(chatMessage.getUserInfo().getUserId());
            this.kQb.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kQc.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jtS != null) {
                h.a(this.mPageContext.getContext(), this.jtS, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jtS.setContentDescription(stringBuffer.toString());
                    this.jtS.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.akW != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ao.setViewTextColor(this.eLt, R.color.CAM_X0106);
            ao.setViewTextColor(this.kQc, R.color.CAM_X0109);
            this.jtS.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jtS.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            this.akW = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
