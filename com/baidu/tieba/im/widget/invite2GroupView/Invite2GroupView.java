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
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.InviteMsgData;
import com.baidu.tieba.im.memorycache.b;
/* loaded from: classes.dex */
public final class Invite2GroupView extends LinearLayout {
    private TbImageView gRB;
    private TextView gRC;
    private TextView gRD;
    private InviteMsgData gRE;
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
        this.gRB = (TbImageView) findViewById(R.id.chat_group_img);
        this.gRC = (TextView) findViewById(R.id.chat_group_desc);
        this.gRD = (TextView) findViewById(R.id.invite_btn);
        this.gRB.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.gRE = inviteMsgData;
        p(tbPageContext);
    }

    private void p(final TbPageContext<?> tbPageContext) {
        this.gRD.setEnabled(true);
        this.gRD.setTag(String.valueOf(this.gRE.getGroupId()));
        this.gRD.setText(R.string.i_want_attent);
        this.gRD.setTextColor(getContext().getResources().getColor(R.color.cp_bg_line_d));
        this.gRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.gRD.getContext(), "" + Invite2GroupView.this.gRE.getGroupId(), Invite2GroupView.this.gRE.getFromUid(), Invite2GroupView.this.gRE.getText())));
            }
        });
        this.title.setText(this.gRE.getTitle());
        this.gRB.setTag(this.gRE.getPortrait());
        this.gRB.startLoad(this.gRE.getPortrait(), 10, false);
        this.gRC.setText(this.gRE.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.gRE.getGroupId(), 7, Invite2GroupView.this.gRE.getText(), Invite2GroupView.this.gRE.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.bEZ().aQ(String.valueOf(this.gRE.getGroupId()), 1) != null) {
            if (String.valueOf(this.gRE.getGroupId()).equals(this.gRD.getTag())) {
                this.gRD.setText(R.string.i_want_talk);
                this.gRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.gRE.getGroupId(), Invite2GroupView.this.gRE.getGroupName(), Invite2GroupView.this.gRE.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.bGq().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.gRE.getGroupId()), 60000L, new k<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.gRD.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(R.color.common_color_10228));
                    Invite2GroupView.this.gRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
