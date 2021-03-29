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
import d.b.h0.z0.n;
/* loaded from: classes3.dex */
public final class Invite2GroupView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f18160e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f18161f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18162g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18163h;
    public InviteMsgData i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = Invite2GroupView.this.f18163h.getContext();
            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(context, "" + Invite2GroupView.this.i.getGroupId(), Invite2GroupView.this.i.getFromUid(), Invite2GroupView.this.i.getText())));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18165e;

        public b(TbPageContext tbPageContext) {
            this.f18165e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(Invite2GroupView.this.getContext(), Invite2GroupView.this.i.getGroupId(), 7, Invite2GroupView.this.i.getText(), Invite2GroupView.this.i.getFromUid());
            if (this.f18165e.getOrignalPage() instanceof BaseActivity) {
                this.f18165e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
            } else if (this.f18165e.getOrignalPage() instanceof BaseFragmentActivity) {
                this.f18165e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Invite2GroupView.this.getContext() instanceof Activity) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) Invite2GroupView.this.getContext(), Invite2GroupView.this.i.getGroupId(), Invite2GroupView.this.i.getGroupName(), Invite2GroupView.this.i.getGroupOwnerId(), "invite add group")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18168a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Invite2GroupView.this.getContext() instanceof Activity) {
                    d.this.f18168a.showToast(R.string.has_recent_join);
                }
            }
        }

        public d(TbPageContext tbPageContext) {
            this.f18168a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                return;
            }
            Invite2GroupView.this.f18163h.setTextColor(Invite2GroupView.this.getContext().getResources().getColor(R.color.common_color_10228));
            Invite2GroupView.this.f18163h.setOnClickListener(new a());
        }
    }

    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.invite_to_group_view, this);
        setOrientation(1);
        this.f18160e = (TextView) findViewById(R.id.chat_title);
        this.f18161f = (TbImageView) findViewById(R.id.chat_group_img);
        this.f18162g = (TextView) findViewById(R.id.chat_group_desc);
        this.f18163h = (TextView) findViewById(R.id.invite_btn);
        this.f18161f.setIsRound(false);
    }

    public final void d(TbPageContext<?> tbPageContext) {
        this.f18163h.setEnabled(true);
        this.f18163h.setTag(String.valueOf(this.i.getGroupId()));
        this.f18163h.setText(R.string.i_want_attent);
        this.f18163h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
        this.f18163h.setOnClickListener(new a());
        this.f18160e.setText(this.i.getTitle());
        this.f18161f.setTag(this.i.getPortrait());
        this.f18161f.W(this.i.getPortrait(), 10, false);
        this.f18162g.setText(this.i.getNotice());
        setOnClickListener(new b(tbPageContext));
        if (d.b.i0.d1.k.b.o().i(String.valueOf(this.i.getGroupId()), 1) != null) {
            if (String.valueOf(this.i.getGroupId()).equals(this.f18163h.getTag())) {
                this.f18163h.setText(R.string.i_want_talk);
                this.f18163h.setOnClickListener(new c());
                return;
            }
            return;
        }
        d.b.i0.d1.t.b.k().m(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.i.getGroupId()), 60000L, new d(tbPageContext));
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        this.i = inviteMsgData;
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
