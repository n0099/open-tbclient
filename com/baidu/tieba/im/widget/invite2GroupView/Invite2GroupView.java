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
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TbImageView eOM;
    private TextView eON;
    private TextView eOO;
    private InviteMsgData eOP;
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
        LayoutInflater.from(getContext()).inflate(d.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.eOM = (TbImageView) findViewById(d.g.chat_group_img);
        this.eON = (TextView) findViewById(d.g.chat_group_desc);
        this.eOO = (TextView) findViewById(d.g.invite_btn);
        this.eOM.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void a(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.eOP = inviteMsgData;
        m(tbPageContext);
    }

    private void m(final TbPageContext<?> tbPageContext) {
        this.eOO.setEnabled(true);
        this.eOO.setTag(String.valueOf(this.eOP.getGroupId()));
        this.eOO.setText(d.j.i_want_attent);
        this.eOO.setTextColor(getContext().getResources().getColor(d.C0140d.cp_bg_line_d));
        this.eOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.eOO.getContext(), "" + Invite2GroupView.this.eOP.getGroupId(), Invite2GroupView.this.eOP.getFromUid(), Invite2GroupView.this.eOP.getText())));
            }
        });
        this.title.setText(this.eOP.getTitle());
        this.eOM.setTag(this.eOP.getPortrait());
        this.eOM.startLoad(this.eOP.getPortrait(), 10, false);
        this.eON.setText(this.eOP.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.eOP.getGroupId(), 7, Invite2GroupView.this.eOP.getText(), Invite2GroupView.this.eOP.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aKB().an(String.valueOf(this.eOP.getGroupId()), 1) != null) {
            if (String.valueOf(this.eOP.getGroupId()).equals(this.eOO.getTag())) {
                this.eOO.setText(d.j.i_want_talk);
                this.eOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.eOP.getGroupId(), Invite2GroupView.this.eOP.getGroupName(), Invite2GroupView.this.eOP.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aLU().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.eOP.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.eOO.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.C0140d.common_color_10228));
                    Invite2GroupView.this.eOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
