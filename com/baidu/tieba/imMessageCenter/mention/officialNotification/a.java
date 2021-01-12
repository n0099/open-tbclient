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
    private int akf = 3;
    private TextView eGI;
    private TbRichTextView jpm;
    private HeadImageView kLw;
    private TextView kLx;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kLw = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kLw.setIsRound(true);
        this.kLw.setOnClickListener(onClickListener);
        this.kLw.setPlaceHolder(1);
        this.eGI = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.eGI.setOnClickListener(onClickListener);
        this.kLx = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.jpm = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.jpm.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jpm.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.jpm.setLayoutStrategy(layoutStrategy);
        this.jpm.setClickable(true);
        this.jpm.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kLw.setUserId(chatMessage.getUserInfo().getUserId());
            this.kLw.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kLx.setText(at.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.jpm != null) {
                h.a(this.mPageContext.getContext(), this.jpm, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.jpm.setContentDescription(stringBuffer.toString());
                    this.jpm.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.akf != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ao.setViewTextColor(this.eGI, R.color.CAM_X0106);
            ao.setViewTextColor(this.kLx, R.color.CAM_X0109);
            this.jpm.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jpm.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
            ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            this.akf = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
