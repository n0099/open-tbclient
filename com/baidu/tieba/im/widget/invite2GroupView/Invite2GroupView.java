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
    private TbImageView eTN;
    private TextView eTO;
    private TextView eTP;
    private InviteMsgData eTQ;
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
        this.eTN = (TbImageView) findViewById(e.g.chat_group_img);
        this.eTO = (TextView) findViewById(e.g.chat_group_desc);
        this.eTP = (TextView) findViewById(e.g.invite_btn);
        this.eTN.setIsRound(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.eTQ = inviteMsgData;
        n(tbPageContext);
    }

    private void n(final TbPageContext<?> tbPageContext) {
        this.eTP.setEnabled(true);
        this.eTP.setTag(String.valueOf(this.eTQ.getGroupId()));
        this.eTP.setText(e.j.i_want_attent);
        this.eTP.setTextColor(getContext().getResources().getColor(e.d.cp_bg_line_d));
        this.eTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(Invite2GroupView.this.eTP.getContext(), "" + Invite2GroupView.this.eTQ.getGroupId(), Invite2GroupView.this.eTQ.getFromUid(), Invite2GroupView.this.eTQ.getText())));
            }
        });
        this.title.setText(this.eTQ.getTitle());
        this.eTN.setTag(this.eTQ.getPortrait());
        this.eTN.startLoad(this.eTQ.getPortrait(), 10, false);
        this.eTO.setText(this.eTQ.getNotice());
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.eTQ.getGroupId(), 7, Invite2GroupView.this.eTQ.getText(), Invite2GroupView.this.eTQ.getFromUid());
                if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                    tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        });
        if (b.aQV().aw(String.valueOf(this.eTQ.getGroupId()), 1) != null) {
            if (String.valueOf(this.eTQ.getGroupId()).equals(this.eTP.getTag())) {
                this.eTP.setText(e.j.i_want_talk);
                this.eTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Invite2GroupView.this.getContext() instanceof Activity) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.eTQ.getGroupId(), Invite2GroupView.this.eTQ.getGroupName(), Invite2GroupView.this.eTQ.getGroupOwnerId(), "invite add group")));
                        }
                    }
                });
                return;
            }
            return;
        }
        com.baidu.tieba.im.settingcache.b.aSq().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.eTQ.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null) {
                    bool = false;
                }
                if (!bool.booleanValue()) {
                    Invite2GroupView.this.eTP.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(e.d.common_color_10228));
                    Invite2GroupView.this.eTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.widget.invite2GroupView.Invite2GroupView.4.1
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
