package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TbImageView iLr;
    private TextView iLs;
    private TextView iLt;
    private InviteMsgData iLu;
    private TextView title;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(R.id.chat_title);
        this.iLr = (TbImageView) findViewById(R.id.chat_group_img);
        this.iLs = (TextView) findViewById(R.id.chat_group_desc);
        this.iLt = (TextView) findViewById(R.id.invite_btn);
        this.iLr.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.iLu = inviteMsgData;
        t(tbPageContext);
    }

    private void t(final TbPageContext<?> tbPageContext) {
        this.iLt.setEnabled(true);
        this.iLt.setTag(String.valueOf(this.iLu.getGroupId()));
        this.iLt.setText(R.string.i_want_attent);
        this.iLt.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
        this.iLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.iLt.getContext(), "" + Invite2GroupView.this.iLu.getGroupId(), Invite2GroupView.this.iLu.getFromUid(), Invite2GroupView.this.iLu.getText())));
            }
        });
        this.title.setText(this.iLu.getTitle());
        this.iLr.setTag(this.iLu.getPortrait());
        this.iLr.startLoad(this.iLu.getPortrait(), 10, false);
        this.iLs.setText(this.iLu.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.iLu.getGroupId(), 7, Invite2GroupView.this.iLu.getText(), Invite2GroupView.this.iLu.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.cnY().bg(String.valueOf(this.iLu.getGroupId()), 1) != null) {
            if (String.valueOf(this.iLu.getGroupId()).equals(this.iLt.getTag())) {
                this.iLt.setText(R.string.i_want_talk);
                this.iLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.iLu.getGroupId(), Invite2GroupView.this.iLu.getGroupName(), Invite2GroupView.this.iLu.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.cpp().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.iLu.getGroupId()), 60000L, new l<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.iLt.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(R.color.common_color_10228));
                    Invite2GroupView.this.iLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (Invite2GroupView.this.getContext() instanceof Activity) {
                                tbPageContext.showToast(R.string.has_recent_join);
                            }
                        }
                    });
                }
            }
        });
    }
}
