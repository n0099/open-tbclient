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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.InviteMsgData;
import d.a.i0.z0.n;
/* loaded from: classes4.dex */
public final class Invite2GroupView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f18178e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f18179f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18180g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18181h;

    /* renamed from: i  reason: collision with root package name */
    public InviteMsgData f18182i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = Invite2GroupView.this.f18181h.getContext();
            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(context, "" + Invite2GroupView.this.f18182i.getGroupId(), Invite2GroupView.this.f18182i.getFromUid(), Invite2GroupView.this.f18182i.getText())));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18184e;

        public b(TbPageContext tbPageContext) {
            this.f18184e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.f18182i.getGroupId(), 7, Invite2GroupView.this.f18182i.getText(), Invite2GroupView.this.f18182i.getFromUid());
            if (this.f18184e.getOrignalPage() instanceof BaseActivity) {
                this.f18184e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
            } else if (this.f18184e.getOrignalPage() instanceof BaseFragmentActivity) {
                this.f18184e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Invite2GroupView.this.getContext() instanceof Activity) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.f18182i.getGroupId(), Invite2GroupView.this.f18182i.getGroupName(), Invite2GroupView.this.f18182i.getGroupOwnerId(), "invite add group")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18187a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Invite2GroupView.this.getContext() instanceof Activity) {
                    d.this.f18187a.showToast(R.string.has_recent_join);
                }
            }
        }

        public d(TbPageContext tbPageContext) {
            this.f18187a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                return;
            }
            Invite2GroupView.this.f18181h.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(R.color.common_color_10228));
            Invite2GroupView.this.f18181h.setOnClickListener(new a());
        }
    }

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.invite_to_group_view, this);
        setOrientation(1);
        this.f18178e = (TextView) findViewById(R.id.chat_title);
        this.f18179f = (TbImageView) findViewById(R.id.chat_group_img);
        this.f18180g = (TextView) findViewById(R.id.chat_group_desc);
        this.f18181h = (TextView) findViewById(R.id.invite_btn);
        this.f18179f.setIsRound(false);
    }

    public final void d(TbPageContext<?> tbPageContext) {
        this.f18181h.setEnabled(true);
        this.f18181h.setTag(String.valueOf(this.f18182i.getGroupId()));
        this.f18181h.setText(R.string.i_want_attent);
        this.f18181h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
        this.f18181h.setOnClickListener(new a());
        this.f18178e.setText(this.f18182i.getTitle());
        this.f18179f.setTag(this.f18182i.getPortrait());
        this.f18179f.V(this.f18182i.getPortrait(), 10, false);
        this.f18180g.setText(this.f18182i.getNotice());
        setOnClickListener(new b(tbPageContext));
        if (d.a.j0.e1.k.b.o().i(String.valueOf(this.f18182i.getGroupId()), 1) != null) {
            if (String.valueOf(this.f18182i.getGroupId()).equals(this.f18181h.getTag())) {
                this.f18181h.setText(R.string.i_want_talk);
                this.f18181h.setOnClickListener(new c());
                return;
            }
            return;
        }
        d.a.j0.e1.t.b.k().m(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f18182i.getGroupId()), 60000L, new d(tbPageContext));
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.f18182i = inviteMsgData;
        d(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public Invite2GroupView(Context context) {
        super(context);
        c();
    }
}
