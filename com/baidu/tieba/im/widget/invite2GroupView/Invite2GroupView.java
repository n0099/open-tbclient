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
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView awD;
    private TbImageView dNB;
    private TextView dNC;
    private TextView dND;
    private InviteMsgData dNE;

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public Invite2GroupView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.invite_to_group_view, this);
        setOrientation(1);
        this.awD = (TextView) findViewById(d.g.chat_title);
        this.dNB = (TbImageView) findViewById(d.g.chat_group_img);
        this.dNC = (TextView) findViewById(d.g.chat_group_desc);
        this.dND = (TextView) findViewById(d.g.invite_btn);
        this.dNB.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dNE = inviteMsgData;
        p(tbPageContext);
    }

    private void p(final TbPageContext<?> tbPageContext) {
        this.dND.setEnabled(true);
        this.dND.setTag(String.valueOf(this.dNE.getGroupId()));
        this.dND.setText(d.j.i_want_attent);
        this.dND.setTextColor(getContext().getResources().getColor(d.C0080d.cp_bg_line_d));
        this.dND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.dND.getContext(), "" + Invite2GroupView.this.dNE.getGroupId(), Invite2GroupView.this.dNE.getFromUid(), Invite2GroupView.this.dNE.getText())));
            }
        });
        this.awD.setText(this.dNE.getTitle());
        this.dNB.setTag(this.dNE.getPortrait());
        this.dNB.startLoad(this.dNE.getPortrait(), 10, false);
        this.dNC.setText(this.dNE.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.dNE.getGroupId(), 7, Invite2GroupView.this.dNE.getText(), Invite2GroupView.this.dNE.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.aAg().af(String.valueOf(this.dNE.getGroupId()), 1) != null) {
            if (String.valueOf(this.dNE.getGroupId()).equals(this.dND.getTag())) {
                this.dND.setText(d.j.i_want_talk);
                this.dND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.dNE.getGroupId(), Invite2GroupView.this.dNE.getGroupName(), Invite2GroupView.this.dNE.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aBx().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dNE.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.dND.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.C0080d.common_color_10228));
                    Invite2GroupView.this.dND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (Invite2GroupView.this.getContext() instanceof Activity) {
                                tbPageContext.showToast(d.j.has_recent_join);
                            }
                        }
                    });
                }
            }
        });
    }
}
