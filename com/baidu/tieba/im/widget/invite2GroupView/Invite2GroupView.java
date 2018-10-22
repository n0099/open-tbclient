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
    private TbImageView eSv;
    private TextView eSw;
    private TextView eSx;
    private InviteMsgData eSy;
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
        this.eSv = (TbImageView) findViewById(e.g.chat_group_img);
        this.eSw = (TextView) findViewById(e.g.chat_group_desc);
        this.eSx = (TextView) findViewById(e.g.invite_btn);
        this.eSv.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.eSy = inviteMsgData;
        n(tbPageContext);
    }

    private void n(final TbPageContext<?> tbPageContext) {
        this.eSx.setEnabled(true);
        this.eSx.setTag(String.valueOf(this.eSy.getGroupId()));
        this.eSx.setText(e.j.i_want_attent);
        this.eSx.setTextColor(getContext().getResources().getColor(e.d.cp_bg_line_d));
        this.eSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.eSx.getContext(), "" + Invite2GroupView.this.eSy.getGroupId(), Invite2GroupView.this.eSy.getFromUid(), Invite2GroupView.this.eSy.getText())));
            }
        });
        this.title.setText(this.eSy.getTitle());
        this.eSv.setTag(this.eSy.getPortrait());
        this.eSv.startLoad(this.eSy.getPortrait(), 10, false);
        this.eSw.setText(this.eSy.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.eSy.getGroupId(), 7, Invite2GroupView.this.eSy.getText(), Invite2GroupView.this.eSy.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aRy().aw(String.valueOf(this.eSy.getGroupId()), 1) != null) {
            if (String.valueOf(this.eSy.getGroupId()).equals(this.eSx.getTag())) {
                this.eSx.setText(e.j.i_want_talk);
                this.eSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.eSy.getGroupId(), Invite2GroupView.this.eSy.getGroupName(), Invite2GroupView.this.eSy.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aST().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.eSy.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.eSx.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(e.d.common_color_10228));
                    Invite2GroupView.this.eSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
