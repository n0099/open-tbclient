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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView awz;
    private TbImageView dyU;
    private TextView dyV;
    private TextView dyW;
    private InviteMsgData dyX;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.j.invite_to_group_view, this);
        setOrientation(1);
        this.awz = (TextView) findViewById(d.h.chat_title);
        this.dyU = (TbImageView) findViewById(d.h.chat_group_img);
        this.dyV = (TextView) findViewById(d.h.chat_group_desc);
        this.dyW = (TextView) findViewById(d.h.invite_btn);
        this.dyU.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dyX = inviteMsgData;
        s(tbPageContext);
    }

    private void s(final TbPageContext<?> tbPageContext) {
        this.dyW.setEnabled(true);
        this.dyW.setTag(String.valueOf(this.dyX.getGroupId()));
        this.dyW.setText(d.l.i_want_attent);
        this.dyW.setTextColor(getContext().getResources().getColor(d.e.cp_bg_line_d));
        this.dyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.dyW.getContext(), "" + Invite2GroupView.this.dyX.getGroupId(), Invite2GroupView.this.dyX.getFromUid(), Invite2GroupView.this.dyX.getText())));
            }
        });
        this.awz.setText(this.dyX.getTitle());
        this.dyU.setTag(this.dyX.getPortrait());
        this.dyU.c(this.dyX.getPortrait(), 10, false);
        this.dyV.setText(this.dyX.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.dyX.getGroupId(), 7, Invite2GroupView.this.dyX.getText(), Invite2GroupView.this.dyX.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.awn().aa(String.valueOf(this.dyX.getGroupId()), 1) != null) {
            if (String.valueOf(this.dyX.getGroupId()).equals(this.dyW.getTag())) {
                this.dyW.setText(d.l.i_want_talk);
                this.dyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.dyX.getGroupId(), Invite2GroupView.this.dyX.getGroupName(), Invite2GroupView.this.dyX.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.axD().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dyX.getGroupId()), TbConfig.USE_TIME_INTERVAL, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.dyW.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.e.common_color_10228));
                    Invite2GroupView.this.dyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (Invite2GroupView.this.getContext() instanceof Activity) {
                                tbPageContext.showToast(d.l.has_recent_join);
                            }
                        }
                    });
                }
            }
        });
    }
}
