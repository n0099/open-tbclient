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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TbImageView gSm;
    private TextView gSn;
    private TextView gSo;
    private InviteMsgData gSp;
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
        this.gSm = (TbImageView) findViewById(R.id.chat_group_img);
        this.gSn = (TextView) findViewById(R.id.chat_group_desc);
        this.gSo = (TextView) findViewById(R.id.invite_btn);
        this.gSm.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.gSp = inviteMsgData;
        p(tbPageContext);
    }

    private void p(final TbPageContext<?> tbPageContext) {
        this.gSo.setEnabled(true);
        this.gSo.setTag(String.valueOf(this.gSp.getGroupId()));
        this.gSo.setText(R.string.i_want_attent);
        this.gSo.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
        this.gSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.gSo.getContext(), "" + Invite2GroupView.this.gSp.getGroupId(), Invite2GroupView.this.gSp.getFromUid(), Invite2GroupView.this.gSp.getText())));
            }
        });
        this.title.setText(this.gSp.getTitle());
        this.gSm.setTag(this.gSp.getPortrait());
        this.gSm.startLoad(this.gSp.getPortrait(), 10, false);
        this.gSn.setText(this.gSp.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.gSp.getGroupId(), 7, Invite2GroupView.this.gSp.getText(), Invite2GroupView.this.gSp.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, groupInfoActivityConfig));
                }
            }
        });
        if (b.bCM().aN(String.valueOf(this.gSp.getGroupId()), 1) != null) {
            if (String.valueOf(this.gSp.getGroupId()).equals(this.gSo.getTag())) {
                this.gSo.setText(R.string.i_want_talk);
                this.gSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.gSp.getGroupId(), Invite2GroupView.this.gSp.getGroupName(), Invite2GroupView.this.gSp.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.bEd().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.gSp.getGroupId()), 60000L, new j<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.gSo.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(R.color.common_color_10228));
                    Invite2GroupView.this.gSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
