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
    private TbImageView evR;
    private TextView evS;
    private TextView evT;
    private InviteMsgData evU;
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
        this.evR = (TbImageView) findViewById(d.g.chat_group_img);
        this.evS = (TextView) findViewById(d.g.chat_group_desc);
        this.evT = (TextView) findViewById(d.g.invite_btn);
        this.evR.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.evU = inviteMsgData;
        n(tbPageContext);
    }

    private void n(final TbPageContext<?> tbPageContext) {
        this.evT.setEnabled(true);
        this.evT.setTag(String.valueOf(this.evU.getGroupId()));
        this.evT.setText(d.k.i_want_attent);
        this.evT.setTextColor(getContext().getResources().getColor(d.C0141d.cp_bg_line_d));
        this.evT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.evT.getContext(), "" + Invite2GroupView.this.evU.getGroupId(), Invite2GroupView.this.evU.getFromUid(), Invite2GroupView.this.evU.getText())));
            }
        });
        this.title.setText(this.evU.getTitle());
        this.evR.setTag(this.evU.getPortrait());
        this.evR.startLoad(this.evU.getPortrait(), 10, false);
        this.evS.setText(this.evU.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.evU.getGroupId(), 7, Invite2GroupView.this.evU.getText(), Invite2GroupView.this.evU.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aKr().as(String.valueOf(this.evU.getGroupId()), 1) != null) {
            if (String.valueOf(this.evU.getGroupId()).equals(this.evT.getTag())) {
                this.evT.setText(d.k.i_want_talk);
                this.evT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.evU.getGroupId(), Invite2GroupView.this.evU.getGroupName(), Invite2GroupView.this.evU.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aLN().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.evU.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.evT.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.C0141d.common_color_10228));
                    Invite2GroupView.this.evT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
