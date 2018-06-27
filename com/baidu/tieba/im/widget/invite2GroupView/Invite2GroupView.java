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
    private TbImageView ezI;
    private TextView ezJ;
    private TextView ezK;
    private InviteMsgData ezL;
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
        LayoutInflater.from(getContext()).inflate(d.i.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.ezI = (TbImageView) findViewById(d.g.chat_group_img);
        this.ezJ = (TextView) findViewById(d.g.chat_group_desc);
        this.ezK = (TextView) findViewById(d.g.invite_btn);
        this.ezI.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.ezL = inviteMsgData;
        n(tbPageContext);
    }

    private void n(final TbPageContext<?> tbPageContext) {
        this.ezK.setEnabled(true);
        this.ezK.setTag(String.valueOf(this.ezL.getGroupId()));
        this.ezK.setText(d.k.i_want_attent);
        this.ezK.setTextColor(getContext().getResources().getColor(d.C0142d.cp_bg_line_d));
        this.ezK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.ezK.getContext(), "" + Invite2GroupView.this.ezL.getGroupId(), Invite2GroupView.this.ezL.getFromUid(), Invite2GroupView.this.ezL.getText())));
            }
        });
        this.title.setText(this.ezL.getTitle());
        this.ezI.setTag(this.ezL.getPortrait());
        this.ezI.startLoad(this.ezL.getPortrait(), 10, false);
        this.ezJ.setText(this.ezL.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.ezL.getGroupId(), 7, Invite2GroupView.this.ezL.getText(), Invite2GroupView.this.ezL.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aKX().ar(String.valueOf(this.ezL.getGroupId()), 1) != null) {
            if (String.valueOf(this.ezL.getGroupId()).equals(this.ezK.getTag())) {
                this.ezK.setText(d.k.i_want_talk);
                this.ezK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.ezL.getGroupId(), Invite2GroupView.this.ezL.getGroupName(), Invite2GroupView.this.ezL.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aMt().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.ezL.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.ezK.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.C0142d.common_color_10228));
                    Invite2GroupView.this.ezK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (Invite2GroupView.this.getContext() instanceof Activity) {
                                tbPageContext.showToast(d.k.has_recent_join);
                            }
                        }
                    });
                }
            }
        });
    }
}
