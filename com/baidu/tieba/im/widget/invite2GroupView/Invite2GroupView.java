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
    private TextView axQ;
    private TbImageView dAl;
    private TextView dAm;
    private TextView dAn;
    private InviteMsgData dAo;

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
        this.axQ = (TextView) findViewById(d.h.chat_title);
        this.dAl = (TbImageView) findViewById(d.h.chat_group_img);
        this.dAm = (TextView) findViewById(d.h.chat_group_desc);
        this.dAn = (TextView) findViewById(d.h.invite_btn);
        this.dAl.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dAo = inviteMsgData;
        s(tbPageContext);
    }

    private void s(final TbPageContext<?> tbPageContext) {
        this.dAn.setEnabled(true);
        this.dAn.setTag(String.valueOf(this.dAo.getGroupId()));
        this.dAn.setText(d.l.i_want_attent);
        this.dAn.setTextColor(getContext().getResources().getColor(d.e.cp_bg_line_d));
        this.dAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.dAn.getContext(), "" + Invite2GroupView.this.dAo.getGroupId(), Invite2GroupView.this.dAo.getFromUid(), Invite2GroupView.this.dAo.getText())));
            }
        });
        this.axQ.setText(this.dAo.getTitle());
        this.dAl.setTag(this.dAo.getPortrait());
        this.dAl.c(this.dAo.getPortrait(), 10, false);
        this.dAm.setText(this.dAo.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.dAo.getGroupId(), 7, Invite2GroupView.this.dAo.getText(), Invite2GroupView.this.dAo.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.awy().aa(String.valueOf(this.dAo.getGroupId()), 1) != null) {
            if (String.valueOf(this.dAo.getGroupId()).equals(this.dAn.getTag())) {
                this.dAn.setText(d.l.i_want_talk);
                this.dAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.dAo.getGroupId(), Invite2GroupView.this.dAo.getGroupName(), Invite2GroupView.this.dAo.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.axO().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dAo.getGroupId()), TbConfig.USE_TIME_INTERVAL, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.dAn.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.e.common_color_10228));
                    Invite2GroupView.this.dAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
