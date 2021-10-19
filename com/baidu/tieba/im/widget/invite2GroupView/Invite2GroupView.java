package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.d1.q;
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
/* loaded from: classes7.dex */
public final class Invite2GroupView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53362e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f53363f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53364g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53365h;

    /* renamed from: i  reason: collision with root package name */
    public InviteMsgData f53366i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f53367e;

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
            this.f53367e = invite2GroupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f53367e.f53365h.getContext();
                MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(context, "" + this.f53367e.f53366i.getGroupId(), this.f53367e.f53366i.getFromUid(), this.f53367e.f53366i.getText())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f53368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f53369f;

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
            this.f53369f = invite2GroupView;
            this.f53368e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(this.f53369f.getContext(), this.f53369f.f53366i.getGroupId(), 7, this.f53369f.f53366i.getText(), this.f53369f.f53366i.getFromUid());
                if (this.f53368e.getOrignalPage() instanceof BaseActivity) {
                    this.f53368e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                } else if (this.f53368e.getOrignalPage() instanceof BaseFragmentActivity) {
                    this.f53368e.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f53370e;

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
            this.f53370e = invite2GroupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f53370e.getContext() instanceof Activity)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig((Activity) this.f53370e.getContext(), this.f53370e.f53366i.getGroupId(), this.f53370e.f53366i.getGroupName(), this.f53370e.f53366i.getGroupOwnerId(), "invite add group")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f53371a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Invite2GroupView f53372b;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f53373e;

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
                this.f53373e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f53373e.f53372b.getContext() instanceof Activity)) {
                    this.f53373e.f53371a.showToast(R.string.has_recent_join);
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
            this.f53372b = invite2GroupView;
            this.f53371a = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
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
                this.f53372b.f53365h.setTextColor(this.f53372b.getContext().getResources().getColor(R.color.common_color_10228));
                this.f53372b.f53365h.setOnClickListener(new a(this));
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
            this.f53362e = (TextView) findViewById(R.id.chat_title);
            this.f53363f = (TbImageView) findViewById(R.id.chat_group_img);
            this.f53364g = (TextView) findViewById(R.id.chat_group_desc);
            this.f53365h = (TextView) findViewById(R.id.invite_btn);
            this.f53363f.setIsRound(false);
        }
    }

    public final void d(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            this.f53365h.setEnabled(true);
            this.f53365h.setTag(String.valueOf(this.f53366i.getGroupId()));
            this.f53365h.setText(R.string.i_want_attent);
            this.f53365h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0201));
            this.f53365h.setOnClickListener(new a(this));
            this.f53362e.setText(this.f53366i.getTitle());
            this.f53363f.setTag(this.f53366i.getPortrait());
            this.f53363f.startLoad(this.f53366i.getPortrait(), 10, false);
            this.f53364g.setText(this.f53366i.getNotice());
            setOnClickListener(new b(this, tbPageContext));
            if (c.a.r0.l1.k.b.o().i(String.valueOf(this.f53366i.getGroupId()), 1) != null) {
                if (String.valueOf(this.f53366i.getGroupId()).equals(this.f53365h.getTag())) {
                    this.f53365h.setText(R.string.i_want_talk);
                    this.f53365h.setOnClickListener(new c(this));
                    return;
                }
                return;
            }
            c.a.r0.l1.t.b.k().m(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f53366i.getGroupId()), 60000L, new d(this, tbPageContext));
        }
    }

    public void setData(TbPageContext<?> tbPageContext, InviteMsgData inviteMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, inviteMsgData) == null) {
            this.f53366i = inviteMsgData;
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
