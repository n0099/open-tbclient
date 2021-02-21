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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TbImageView kNH;
    private TextView kNI;
    private TextView kNJ;
    private InviteMsgData kNK;
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
        LayoutInflater.from(getContext()).inflate(R.layout.invite_to_group_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(R.id.chat_title);
        this.kNH = (TbImageView) findViewById(R.id.chat_group_img);
        this.kNI = (TextView) findViewById(R.id.chat_group_desc);
        this.kNJ = (TextView) findViewById(R.id.invite_btn);
        this.kNH.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.kNK = inviteMsgData;
        w(tbPageContext);
    }

    private void w(final TbPageContext<?> tbPageContext) {
        this.kNJ.setEnabled(true);
        this.kNJ.setTag(String.valueOf(this.kNK.getGroupId()));
        this.kNJ.setText(R.string.i_want_attent);
        this.kNJ.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
        this.kNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.kNJ.getContext(), "" + Invite2GroupView.this.kNK.getGroupId(), Invite2GroupView.this.kNK.getFromUid(), Invite2GroupView.this.kNK.getText())));
            }
        });
        this.title.setText(this.kNK.getTitle());
        this.kNH.setTag(this.kNK.getPortrait());
        this.kNH.startLoad(this.kNK.getPortrait(), 10, false);
        this.kNI.setText(this.kNK.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.kNK.getGroupId(), 7, Invite2GroupView.this.kNK.getText(), Invite2GroupView.this.kNK.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.cWL().bs(String.valueOf(this.kNK.getGroupId()), 1) != null) {
            if (String.valueOf(this.kNK.getGroupId()).equals(this.kNJ.getTag())) {
                this.kNJ.setText(R.string.i_want_talk);
                this.kNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.kNK.getGroupId(), Invite2GroupView.this.kNK.getGroupName(), Invite2GroupView.this.kNK.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.cXY().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.kNK.getGroupId()), AppStatusRules.DEFAULT_GRANULARITY, new m<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.kNJ.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(R.color.common_color_10228));
                    Invite2GroupView.this.kNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (Invite2GroupView.this.getContext() instanceof Activity) {
                                tbPageContext.showToast(R.string.has_recent_join);
                            }
                        }
                    });
                }
            }
        });
    }
}
