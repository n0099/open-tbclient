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
    private TextView awv;
    private TbImageView dNw;
    private TextView dNx;
    private TextView dNy;
    private InviteMsgData dNz;

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
        this.awv = (TextView) findViewById(d.g.chat_title);
        this.dNw = (TbImageView) findViewById(d.g.chat_group_img);
        this.dNx = (TextView) findViewById(d.g.chat_group_desc);
        this.dNy = (TextView) findViewById(d.g.invite_btn);
        this.dNw.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.dNz = inviteMsgData;
        p(tbPageContext);
    }

    private void p(final TbPageContext<?> tbPageContext) {
        this.dNy.setEnabled(true);
        this.dNy.setTag(String.valueOf(this.dNz.getGroupId()));
        this.dNy.setText(d.j.i_want_attent);
        this.dNy.setTextColor(getContext().getResources().getColor(d.C0080d.cp_bg_line_d));
        this.dNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.dNy.getContext(), "" + Invite2GroupView.this.dNz.getGroupId(), Invite2GroupView.this.dNz.getFromUid(), Invite2GroupView.this.dNz.getText())));
            }
        });
        this.awv.setText(this.dNz.getTitle());
        this.dNw.setTag(this.dNz.getPortrait());
        this.dNw.startLoad(this.dNz.getPortrait(), 10, false);
        this.dNx.setText(this.dNz.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.dNz.getGroupId(), 7, Invite2GroupView.this.dNz.getText(), Invite2GroupView.this.dNz.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.aAc().af(String.valueOf(this.dNz.getGroupId()), 1) != null) {
            if (String.valueOf(this.dNz.getGroupId()).equals(this.dNy.getTag())) {
                this.dNy.setText(d.j.i_want_talk);
                this.dNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.dNz.getGroupId(), Invite2GroupView.this.dNz.getGroupName(), Invite2GroupView.this.dNz.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aBt().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.dNz.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.dNy.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.C0080d.common_color_10228));
                    Invite2GroupView.this.dNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
