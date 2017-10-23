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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView avY;
    private TbImageView dFI;
    private TextView dFJ;
    private TextView dFK;
    private InviteMsgData dFL;

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
        this.avY = (TextView) findViewById(d.h.chat_title);
        this.dFI = (TbImageView) findViewById(d.h.chat_group_img);
        this.dFJ = (TextView) findViewById(d.h.chat_group_desc);
        this.dFK = (TextView) findViewById(d.h.invite_btn);
        this.dFI.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dFL = inviteMsgData;
        p(tbPageContext);
    }

    private void p(final TbPageContext<?> tbPageContext) {
        this.dFK.setEnabled(true);
        this.dFK.setTag(String.valueOf(this.dFL.getGroupId()));
        this.dFK.setText(d.l.i_want_attent);
        this.dFK.setTextColor(getContext().getResources().getColor(d.e.cp_bg_line_d));
        this.dFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.dFK.getContext(), "" + Invite2GroupView.this.dFL.getGroupId(), Invite2GroupView.this.dFL.getFromUid(), Invite2GroupView.this.dFL.getText())));
            }
        });
        this.avY.setText(this.dFL.getTitle());
        this.dFI.setTag(this.dFL.getPortrait());
        this.dFI.c(this.dFL.getPortrait(), 10, false);
        this.dFJ.setText(this.dFL.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.dFL.getGroupId(), 7, Invite2GroupView.this.dFL.getText(), Invite2GroupView.this.dFL.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.axH().Z(String.valueOf(this.dFL.getGroupId()), 1) != null) {
            if (String.valueOf(this.dFL.getGroupId()).equals(this.dFK.getTag())) {
                this.dFK.setText(d.l.i_want_talk);
                this.dFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.dFL.getGroupId(), Invite2GroupView.this.dFL.getGroupName(), Invite2GroupView.this.dFL.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.ayY().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dFL.getGroupId()), 60000L, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.dFK.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.e.common_color_10228));
                    Invite2GroupView.this.dFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
