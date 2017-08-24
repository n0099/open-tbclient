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
    private TextView axS;
    private TbImageView dCi;
    private TextView dCj;
    private TextView dCk;
    private InviteMsgData dCl;

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
        this.axS = (TextView) findViewById(d.h.chat_title);
        this.dCi = (TbImageView) findViewById(d.h.chat_group_img);
        this.dCj = (TextView) findViewById(d.h.chat_group_desc);
        this.dCk = (TextView) findViewById(d.h.invite_btn);
        this.dCi.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dCl = inviteMsgData;
        s(tbPageContext);
    }

    private void s(final TbPageContext<?> tbPageContext) {
        this.dCk.setEnabled(true);
        this.dCk.setTag(String.valueOf(this.dCl.getGroupId()));
        this.dCk.setText(d.l.i_want_attent);
        this.dCk.setTextColor(getContext().getResources().getColor(d.e.cp_bg_line_d));
        this.dCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.dCk.getContext(), "" + Invite2GroupView.this.dCl.getGroupId(), Invite2GroupView.this.dCl.getFromUid(), Invite2GroupView.this.dCl.getText())));
            }
        });
        this.axS.setText(this.dCl.getTitle());
        this.dCi.setTag(this.dCl.getPortrait());
        this.dCi.c(this.dCl.getPortrait(), 10, false);
        this.dCj.setText(this.dCl.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.dCl.getGroupId(), 7, Invite2GroupView.this.dCl.getText(), Invite2GroupView.this.dCl.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.axa().aa(String.valueOf(this.dCl.getGroupId()), 1) != null) {
            if (String.valueOf(this.dCl.getGroupId()).equals(this.dCk.getTag())) {
                this.dCk.setText(d.l.i_want_talk);
                this.dCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.dCl.getGroupId(), Invite2GroupView.this.dCl.getGroupName(), Invite2GroupView.this.dCl.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.ayq().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dCl.getGroupId()), TbConfig.USE_TIME_INTERVAL, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.dCk.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.e.common_color_10228));
                    Invite2GroupView.this.dCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
