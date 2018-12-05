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
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TbImageView faC;
    private TextView faD;
    private TextView faE;
    private InviteMsgData faF;
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
        LayoutInflater.from(getContext()).inflate(e.h.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(e.g.chat_title);
        this.faC = (TbImageView) findViewById(e.g.chat_group_img);
        this.faD = (TextView) findViewById(e.g.chat_group_desc);
        this.faE = (TextView) findViewById(e.g.invite_btn);
        this.faC.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.faF = inviteMsgData;
        n(tbPageContext);
    }

    private void n(final TbPageContext<?> tbPageContext) {
        this.faE.setEnabled(true);
        this.faE.setTag(String.valueOf(this.faF.getGroupId()));
        this.faE.setText(e.j.i_want_attent);
        this.faE.setTextColor(getContext().getResources().getColor(e.d.cp_bg_line_d));
        this.faE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.faE.getContext(), "" + Invite2GroupView.this.faF.getGroupId(), Invite2GroupView.this.faF.getFromUid(), Invite2GroupView.this.faF.getText())));
            }
        });
        this.title.setText(this.faF.getTitle());
        this.faC.setTag(this.faF.getPortrait());
        this.faC.startLoad(this.faF.getPortrait(), 10, false);
        this.faD.setText(this.faF.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.faF.getGroupId(), 7, Invite2GroupView.this.faF.getText(), Invite2GroupView.this.faF.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aSN().ax(String.valueOf(this.faF.getGroupId()), 1) != null) {
            if (String.valueOf(this.faF.getGroupId()).equals(this.faE.getTag())) {
                this.faE.setText(e.j.i_want_talk);
                this.faE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.faF.getGroupId(), Invite2GroupView.this.faF.getGroupName(), Invite2GroupView.this.faF.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aUi().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.faF.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.faE.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(e.d.common_color_10228));
                    Invite2GroupView.this.faE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (Invite2GroupView.this.getContext() instanceof Activity) {
                                tbPageContext.showToast(e.j.has_recent_join);
                            }
                        }
                    });
                }
            }
        });
    }
}
