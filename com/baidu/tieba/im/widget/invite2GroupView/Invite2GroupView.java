package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.q0.d1.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class Invite2GroupView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50608e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f50609f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50610g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50611h;

    /* renamed from: i  reason: collision with root package name */
    public InviteMsgData f50612i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f50613e;

        public a(Invite2GroupView invite2GroupView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {invite2GroupView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50613e = invite2GroupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f50613e.f50611h.getContext();
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(context, "" + this.f50613e.f50612i.getGroupId(), this.f50613e.f50612i.getFromUid(), this.f50613e.f50612i.getText())));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50614e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f50615f;

        public b(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {invite2GroupView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50615f = invite2GroupView;
            this.f50614e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(this.f50615f.getContext(), this.f50615f.f50612i.getGroupId(), 7, this.f50615f.f50612i.getText(), this.f50615f.f50612i.getFromUid());
                if (this.f50614e.getOrignalPage() instanceof BaseActivity) {
                    this.f50614e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (this.f50614e.getOrignalPage() instanceof BaseFragmentActivity) {
                    this.f50614e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f50616e;

        public c(Invite2GroupView invite2GroupView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {invite2GroupView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50616e = invite2GroupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f50616e.getContext() instanceof Activity)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) this.f50616e.getContext(), this.f50616e.f50612i.getGroupId(), this.f50616e.f50612i.getGroupName(), this.f50616e.f50612i.getGroupOwnerId(), "invite add group")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50617a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f50618b;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f50619e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50619e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f50619e.f50618b.getContext() instanceof Activity)) {
                    this.f50619e.f50617a.showToast(R.string.has_recent_join);
                }
            }
        }

        public d(Invite2GroupView invite2GroupView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {invite2GroupView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50618b = invite2GroupView;
            this.f50617a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                if (bool.booleanValue()) {
                    return;
                }
                this.f50618b.f50611h.setTextColor(this.f50618b.getContext().getResources().getColor(R.color.common_color_10228));
                this.f50618b.f50611h.setOnClickListener(new a(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Invite2GroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.invite_to_group_view, this);
            setOrientation(1);
            this.f50608e = (TextView) findViewById(R.id.chat_title);
            this.f50609f = (TbImageView) findViewById(R.id.chat_group_img);
            this.f50610g = (TextView) findViewById(R.id.chat_group_desc);
            this.f50611h = (TextView) findViewById(R.id.invite_btn);
            this.f50609f.setIsRound(false);
        }
    }

    public final void d(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f50611h.setEnabled(true);
            this.f50611h.setTag(String.valueOf(this.f50612i.getGroupId()));
            this.f50611h.setText(R.string.i_want_attent);
            this.f50611h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
            this.f50611h.setOnClickListener(new a(this));
            this.f50608e.setText(this.f50612i.getTitle());
            this.f50609f.setTag(this.f50612i.getPortrait());
            this.f50609f.startLoad(this.f50612i.getPortrait(), 10, false);
            this.f50610g.setText(this.f50612i.getNotice());
            setOnClickListener(new b(this, tbPageContext));
            if (b.a.r0.l1.k.b.o().i(String.valueOf(this.f50612i.getGroupId()), 1) != null) {
                if (String.valueOf(this.f50612i.getGroupId()).equals(this.f50611h.getTag())) {
                    this.f50611h.setText(R.string.i_want_talk);
                    this.f50611h.setOnClickListener(new c(this));
                    return;
                }
                return;
            }
            b.a.r0.l1.t.b.k().m(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f50612i.getGroupId()), 60000L, new d(this, tbPageContext));
        }
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, inviteMsgData) == null) {
            this.f50612i = inviteMsgData;
            d(tbPageContext);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LinearLayout.LayoutParams(-2, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Invite2GroupView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }
}
