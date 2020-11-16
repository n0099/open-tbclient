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
/* loaded from: classes21.dex */
public class a {
    private static final String TAG = a.class.getName();
    private int ajv = 3;
    private TextView euO;
    private HeadImageView kxx;
    private TextView kxy;
    private TbRichTextView kxz;
    private View mBottomLine;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.official_notification_text_item, viewGroup, false);
        this.kxx = (HeadImageView) this.mRootView.findViewById(R.id.iv_head);
        this.kxx.setIsRound(true);
        this.kxx.setOnClickListener(onClickListener);
        this.kxx.setPlaceHolder(1);
        this.euO = (TextView) this.mRootView.findViewById(R.id.tv_user_name);
        this.euO.setOnClickListener(onClickListener);
        this.kxy = (TextView) this.mRootView.findViewById(R.id.tv_date);
        this.kxz = (TbRichTextView) this.mRootView.findViewById(R.id.tv_content);
        this.kxz.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.kxz.getLayoutStrategy();
        layoutStrategy.setLineSpacing(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.kxz.setLayoutStrategy(layoutStrategy);
        this.kxz.setClickable(true);
        this.kxz.setFocusable(true);
        this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
        onChangeSkinType();
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage.getUserInfo() != null) {
            this.kxx.setUserId(chatMessage.getUserInfo().getUserId());
            this.kxx.startLoad(chatMessage.getUserInfo().getPortrait(), 12, false);
            this.kxy.setText(au.getFormatTimeShort(chatMessage.getTime() * 1000));
            if (this.mPageContext != null && this.kxz != null) {
                j.a(this.mPageContext.getContext(), this.kxz, chatMessage, TAG, 0);
                if (chatMessage != null && chatMessage.getContent() != null) {
                    String[] split = chatMessage.getContent().split("#");
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : split) {
                        stringBuffer.append(str);
                    }
                    this.kxz.setContentDescription(stringBuffer.toString());
                    this.kxz.getTextView().setContentDescription(stringBuffer.toString());
                }
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ajv != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.euO, R.color.CAM_X0106);
            ap.setViewTextColor(this.kxy, R.color.CAM_X0109);
            this.kxz.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.kxz.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            this.ajv = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
