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
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TextView eDA;
    private TextView eDB;
    private InviteMsgData eDC;
    private TbImageView eDz;
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
        this.eDz = (TbImageView) findViewById(d.g.chat_group_img);
        this.eDA = (TextView) findViewById(d.g.chat_group_desc);
        this.eDB = (TextView) findViewById(d.g.invite_btn);
        this.eDz.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.eDC = inviteMsgData;
        n(tbPageContext);
    }

    private void n(final TbPageContext<?> tbPageContext) {
        this.eDB.setEnabled(true);
        this.eDB.setTag(String.valueOf(this.eDC.getGroupId()));
        this.eDB.setText(d.j.i_want_attent);
        this.eDB.setTextColor(getContext().getResources().getColor(d.C0140d.cp_bg_line_d));
        this.eDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.eDB.getContext(), "" + Invite2GroupView.this.eDC.getGroupId(), Invite2GroupView.this.eDC.getFromUid(), Invite2GroupView.this.eDC.getText())));
            }
        });
        this.title.setText(this.eDC.getTitle());
        this.eDz.setTag(this.eDC.getPortrait());
        this.eDz.startLoad(this.eDC.getPortrait(), 10, false);
        this.eDA.setText(this.eDC.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.eDC.getGroupId(), 7, Invite2GroupView.this.eDC.getText(), Invite2GroupView.this.eDC.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aLY().an(String.valueOf(this.eDC.getGroupId()), 1) != null) {
            if (String.valueOf(this.eDC.getGroupId()).equals(this.eDB.getTag())) {
                this.eDB.setText(d.j.i_want_talk);
                this.eDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.eDC.getGroupId(), Invite2GroupView.this.eDC.getGroupName(), Invite2GroupView.this.eDC.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aNt().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.eDC.getGroupId()), 60000L, new g<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.eDB.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(d.C0140d.common_color_10228));
                    Invite2GroupView.this.eDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
