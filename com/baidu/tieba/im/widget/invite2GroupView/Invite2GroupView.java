package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.s0.d1.s;
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
/* loaded from: classes12.dex */
public final class Invite2GroupView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45177e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45178f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45179g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45180h;

    /* renamed from: i  reason: collision with root package name */
    public InviteMsgData f45181i;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f45182e;

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
            this.f45182e = invite2GroupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f45182e.f45180h.getContext();
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(context, "" + this.f45182e.f45181i.getGroupId(), this.f45182e.f45181i.getFromUid(), this.f45182e.f45181i.getText())));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f45183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f45184f;

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
            this.f45184f = invite2GroupView;
            this.f45183e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(this.f45184f.getContext(), this.f45184f.f45181i.getGroupId(), 7, this.f45184f.f45181i.getText(), this.f45184f.f45181i.getFromUid());
                if (this.f45183e.getOrignalPage() instanceof BaseActivity) {
                    this.f45183e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (this.f45183e.getOrignalPage() instanceof BaseFragmentActivity) {
                    this.f45183e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f45185e;

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
            this.f45185e = invite2GroupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f45185e.getContext() instanceof Activity)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) this.f45185e.getContext(), this.f45185e.f45181i.getGroupId(), this.f45185e.f45181i.getGroupName(), this.f45185e.f45181i.getGroupOwnerId(), "invite add group")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements s<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f45186b;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45187e;

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
                this.f45187e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f45187e.f45186b.getContext() instanceof Activity)) {
                    this.f45187e.a.showToast(R.string.has_recent_join);
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
            this.f45186b = invite2GroupView;
            this.a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.s
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
                this.f45186b.f45180h.setTextColor(this.f45186b.getContext().getResources().getColor(R.color.common_color_10228));
                this.f45186b.f45180h.setOnClickListener(new a(this));
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
            this.f45177e = (TextView) findViewById(R.id.chat_title);
            this.f45178f = (TbImageView) findViewById(R.id.chat_group_img);
            this.f45179g = (TextView) findViewById(R.id.chat_group_desc);
            this.f45180h = (TextView) findViewById(R.id.invite_btn);
            this.f45178f.setIsRound(false);
        }
    }

    public final void d(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f45180h.setEnabled(true);
            this.f45180h.setTag(String.valueOf(this.f45181i.getGroupId()));
            this.f45180h.setText(R.string.i_want_attent);
            this.f45180h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
            this.f45180h.setOnClickListener(new a(this));
            this.f45177e.setText(this.f45181i.getTitle());
            this.f45178f.setTag(this.f45181i.getPortrait());
            this.f45178f.startLoad(this.f45181i.getPortrait(), 10, false);
            this.f45179g.setText(this.f45181i.getNotice());
            setOnClickListener(new b(this, tbPageContext));
            if (c.a.t0.t1.k.b.o().i(String.valueOf(this.f45181i.getGroupId()), 1) != null) {
                if (String.valueOf(this.f45181i.getGroupId()).equals(this.f45180h.getTag())) {
                    this.f45180h.setText(R.string.i_want_talk);
                    this.f45180h.setOnClickListener(new c(this));
                    return;
                }
                return;
            }
            c.a.t0.t1.t.b.k().m(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f45181i.getGroupId()), 60000L, new d(this, tbPageContext));
        }
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, inviteMsgData) == null) {
            this.f45181i = inviteMsgData;
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
