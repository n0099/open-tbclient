package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.eh5;
import com.baidu.tieba.eu7;
import com.baidu.tieba.hi;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.kn7;
import com.baidu.tieba.n15;
import com.baidu.tieba.rt7;
import com.baidu.tieba.wt7;
import com.baidu.tieba.xt7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class ChatItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public FrameLayout e;
    public FrameLayout f;
    public HeadImageView g;
    public TbCornersImageView h;
    public BarImageView i;
    public RelativeLayout j;
    public TextView k;
    public TbRichTextView l;
    public TextView m;
    public eu7 n;
    public LinearLayout o;
    public TextView p;
    public long q;
    public xt7 r;
    public View s;
    public CustomMessageListener t;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatItemViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatItemViewHolder chatItemViewHolder, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatItemViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatItemViewHolder;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            eu7 eu7Var;
            ChatRoomInfo chatRoomInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if (!map.isEmpty() && (eu7Var = this.a.n) != null && eu7Var.a() != null && (chatRoomInfo = (ChatRoomInfo) map.get(Long.valueOf(this.a.n.a().getRoomId()))) != null) {
                    this.a.n.c(chatRoomInfo);
                    ChatItemViewHolder chatItemViewHolder = this.a;
                    chatItemViewHolder.o(chatRoomInfo, chatItemViewHolder.n.b());
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatItemViewHolder a;

        public b(ChatItemViewHolder chatItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity pageActivity;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.r != null) {
                    eu7 eu7Var = this.a.n;
                    if (eu7Var != null && eu7Var.a() != null) {
                        j = this.a.n.a().getRoomId();
                    } else {
                        j = this.a.q;
                    }
                    this.a.r.a(j, 0);
                }
                TextView textView = this.a.m;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TbPageContext tbPageContext = this.a.a;
                if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
                    eh5.a().c(pageActivity, this.a.q, "source_from_group_chat_dialog");
                }
                this.a.m();
                this.a.p.setVisibility(8);
                this.a.n.a().setAtInfo(null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(924808790, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/adapter/ChatItemViewHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(924808790, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/adapter/ChatItemViewHolder;");
                return;
            }
        }
        u = hi.g(TbadkApplication.getInst(), R.dimen.tbds450);
        v = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemViewHolder(@NonNull View view2, xt7 xt7Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, xt7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = new a(this, 2921766);
        this.r = xt7Var;
        this.s = view2;
        this.f = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e27);
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e23);
        this.e = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e42);
        this.g = (HeadImageView) view2.findViewById(R.id.chat_head);
        this.h = (TbCornersImageView) view2.findViewById(R.id.svg_head);
        this.i = (BarImageView) view2.findViewById(R.id.forum_head);
        this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e15);
        this.k = (TextView) view2.findViewById(R.id.chat_name);
        this.l = (TbRichTextView) view2.findViewById(R.id.last_chat_content);
        this.m = (TextView) view2.findViewById(R.id.new_message);
        this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e17);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09067d);
        this.l.setMaxLines(1);
        this.l.setAddTruncateListener(true);
        this.l.setTextEllipsize(TextUtils.TruncateAt.END);
        this.l.setClickable(false);
        this.l.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X08));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.id.chat_name);
        layoutParams.topMargin = hi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
        layoutParams.bottomMargin = hi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
        layoutParams.rightMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds162);
        this.o.setLayoutParams(layoutParams);
        this.f.setOnClickListener(new b(this));
    }

    public final void o(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, chatRoomInfo, z) == null) {
            if (chatRoomInfo.getNewMessage() != null && chatRoomInfo.getNewMessage().getContent() != null) {
                String str = "";
                if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getFromName())) {
                    str = "" + chatRoomInfo.getNewMessage().getFromName() + ": ";
                }
                if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getContent())) {
                    str = str + chatRoomInfo.getNewMessage().getContent();
                }
                this.l.setText(new TbRichText(kn7.c(str, 1)));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = hi.g(TbadkApplication.getInst(), R.dimen.M_H_X003);
                this.k.setLayoutParams(layoutParams);
                this.l.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(15);
                this.k.setLayoutParams(layoutParams2);
                this.l.setVisibility(8);
            }
            if (chatRoomInfo.getUnreadNum() != 0 && z) {
                this.m.setVisibility(0);
                if (chatRoomInfo.getUnreadNum() >= 100) {
                    this.m.setText("99+");
                } else {
                    this.m.setText(String.valueOf(chatRoomInfo.getUnreadNum()));
                }
                if (chatRoomInfo.getUnreadNum() < 10) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.rightMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds13);
                    layoutParams3.leftMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds13);
                    layoutParams3.topMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds2);
                    layoutParams3.bottomMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds2);
                    this.m.setLayoutParams(layoutParams3);
                } else {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams4.rightMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds10);
                    layoutParams4.leftMargin = hi.g(TbadkApplication.getInst(), R.dimen.tbds10);
                    this.m.setLayoutParams(layoutParams4);
                }
            } else {
                this.m.setVisibility(8);
            }
            if (chatRoomInfo.getAtInfo() != null && chatRoomInfo.getAtInfo().getCountAll() > 0) {
                this.p.setVisibility(0);
                this.p.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f087a));
                return;
            }
            this.p.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void c(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.c(recyclerView);
            MessageManager.getInstance().registerListener(this.t);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void e(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.e(recyclerView);
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            n();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    @SuppressLint({"ResourceAsColor"})
    public void d(@NonNull rt7 rt7Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rt7Var, tbPageContext, i) == null) && (rt7Var instanceof eu7)) {
            eu7 eu7Var = (eu7) rt7Var;
            this.n = eu7Var;
            if (eu7Var != null && eu7Var.a() != null) {
                ChatRoomInfo a2 = this.n.a();
                if (a2.getName() != null) {
                    this.k.setText(wt7.a(a2.getName(), StringHelper.STRING_MORE, wt7.c(u), this.k.getPaint(), ""));
                }
                o(a2, this.n.b());
                if (a2.getAvatar() != null) {
                    this.g.M(a2.getAvatar(), 10, false);
                }
                this.q = a2.getRoomId();
            }
            n();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.n = null;
            super.g();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK);
            if (this.n.a() != null) {
                statisticItem.param("fid", this.n.a().getForumId());
                statisticItem.param("fname", this.n.a().getForumName());
                statisticItem.param("room_id", this.n.a().getRoomId());
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void n() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n15 d = n15.d(this.k);
            d.A(R.dimen.T_X07);
            d.B(R.string.F_X01);
            d.w(R.color.CAM_X0105);
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            eu7 eu7Var = this.n;
            if (eu7Var != null && eu7Var.a() != null && this.n.a().isLocationScrolled()) {
                i2 = R.color.CAM_X0313;
                i = R.string.A_X03;
            } else {
                i = R.string.A_X06;
                i2 = R.color.CAM_X0211;
            }
            n15 d2 = n15.d(this.d);
            d2.o(R.string.J_X06);
            d2.e(i);
            d2.f(i2);
            n15 d3 = n15.d(this.m);
            d3.A(R.dimen.T_X10);
            d3.B(R.string.F_X01);
            d3.w(R.color.CAM_X0108);
            this.g.setBorderWidth(v);
            this.g.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
            this.g.setIsRound(true);
            this.g.setDrawBorder(true);
            this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.g.setPlaceHolder(1);
            this.g.setDrawBorder(true);
            n15 d4 = n15.d(this.p);
            d4.A(R.dimen.T_X08);
            d4.B(R.string.F_X01);
            d4.w(R.color.CAM_X0301);
        }
    }
}
