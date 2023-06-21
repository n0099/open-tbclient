package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a78;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.ld8;
import com.baidu.tieba.p75;
import com.baidu.tieba.pi8;
import com.baidu.tieba.qd8;
import com.baidu.tieba.to5;
import com.baidu.tieba.wi;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class ChatItemViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static final int w;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout e;
    public FrameLayout f;
    public FrameLayout g;
    public HeadImageView h;
    public TbCornersImageView i;
    public BarImageView j;
    public RelativeLayout k;
    public TextView l;
    public TbRichTextView m;
    public TextView n;
    public zd8 o;
    public LinearLayout p;
    public TextView q;
    public long r;
    public qd8 s;
    public View t;
    public final pi8.a u;
    public final CustomMessageListener v;

    /* loaded from: classes6.dex */
    public class a implements pi8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatItemViewHolder a;

        public a(ChatItemViewHolder chatItemViewHolder) {
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

        @Override // com.baidu.tieba.pi8.a
        public void a(@Nullable CustomResponsedMessage<?> customResponsedMessage) {
            zd8 zd8Var;
            ChatRoomInfo chatRoomInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                if (!map.isEmpty() && (zd8Var = this.a.o) != null && zd8Var.a() != null && (chatRoomInfo = (ChatRoomInfo) map.get(Long.valueOf(this.a.o.a().getRoomId()))) != null) {
                    this.a.o.c(chatRoomInfo);
                    ChatItemViewHolder chatItemViewHolder = this.a;
                    chatItemViewHolder.o(chatRoomInfo, chatItemViewHolder.o.b());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (TbadkCoreApplication.isLogin()) {
                    if (this.a.s != null) {
                        zd8 zd8Var = this.a.o;
                        if (zd8Var != null && zd8Var.a() != null) {
                            j = this.a.o.a().getRoomId();
                        } else {
                            j = this.a.r;
                        }
                        this.a.s.a(j, 0);
                    }
                    TextView textView = this.a.n;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    TbPageContext tbPageContext = this.a.a;
                    if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
                        to5.a().c(pageActivity, this.a.r, "source_from_group_chat_dialog");
                    }
                    this.a.m();
                    this.a.q.setVisibility(8);
                    zd8 zd8Var2 = this.a.o;
                    if (zd8Var2 != null) {
                        zd8Var2.a().setAtInfo(null);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
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
        w = wi.g(TbadkApplication.getInst(), R.dimen.tbds450);
        x = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatItemViewHolder(@NonNull View view2, qd8 qd8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, qd8Var};
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
        a aVar = new a(this);
        this.u = aVar;
        this.v = new pi8(2921766, aVar);
        this.s = qd8Var;
        this.t = view2;
        this.g = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e6d);
        this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e69);
        this.f = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e8e);
        this.h = (HeadImageView) view2.findViewById(R.id.chat_head);
        this.i = (TbCornersImageView) view2.findViewById(R.id.svg_head);
        this.j = (BarImageView) view2.findViewById(R.id.forum_head);
        this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e5b);
        this.l = (TextView) view2.findViewById(R.id.chat_name);
        this.m = (TbRichTextView) view2.findViewById(R.id.last_chat_content);
        this.n = (TextView) view2.findViewById(R.id.new_message);
        this.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e5d);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906a2);
        this.m.setMaxLines(1);
        this.m.setAddTruncateListener(true);
        this.m.setTextEllipsize(TextUtils.TruncateAt.END);
        this.m.setClickable(false);
        this.m.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X08));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.id.chat_name);
        layoutParams.topMargin = wi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
        layoutParams.bottomMargin = wi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
        layoutParams.rightMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds162);
        this.p.setLayoutParams(layoutParams);
        this.g.setOnClickListener(new b(this));
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
                this.m.setText(new TbRichText(a78.c(str, 1)));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = wi.g(TbadkApplication.getInst(), R.dimen.M_H_X003);
                this.l.setLayoutParams(layoutParams);
                this.m.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(15);
                this.l.setLayoutParams(layoutParams2);
                this.m.setVisibility(8);
            }
            if (chatRoomInfo.getUnreadNum() != 0 && z) {
                this.n.setVisibility(0);
                if (chatRoomInfo.getUnreadNum() >= 100) {
                    this.n.setText("99+");
                } else {
                    this.n.setText(String.valueOf(chatRoomInfo.getUnreadNum()));
                }
                if (chatRoomInfo.getUnreadNum() < 10) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.rightMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds13);
                    layoutParams3.leftMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds13);
                    layoutParams3.topMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds2);
                    layoutParams3.bottomMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds2);
                    this.n.setLayoutParams(layoutParams3);
                } else {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams4.rightMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds10);
                    layoutParams4.leftMargin = wi.g(TbadkApplication.getInst(), R.dimen.tbds10);
                    this.n.setLayoutParams(layoutParams4);
                }
            } else {
                this.n.setVisibility(8);
            }
            if (chatRoomInfo.getAtInfo() != null && chatRoomInfo.getAtInfo().getCountAll() > 0) {
                this.q.setVisibility(0);
                this.q.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f092a));
                return;
            }
            this.q.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void c(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recyclerView) == null) {
            super.c(recyclerView);
            MessageManager.getInstance().registerListener(this.v);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void e(@Nullable RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recyclerView) == null) {
            super.e(recyclerView);
            MessageManager.getInstance().unRegisterListener(this.v);
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
    public void d(@NonNull ld8 ld8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ld8Var, tbPageContext, i) == null) && (ld8Var instanceof zd8)) {
            zd8 zd8Var = (zd8) ld8Var;
            this.o = zd8Var;
            if (zd8Var != null && zd8Var.a() != null) {
                ChatRoomInfo a2 = this.o.a();
                if (a2.getName() != null) {
                    this.l.setText(MeasureTextLength.fitTextLabel(a2.getName(), "...", MeasureTextLength.spaceLength(w), this.l.getPaint(), ""));
                }
                o(a2, this.o.b());
                if (a2.getAvatar() != null) {
                    this.h.N(a2.getAvatar(), 10, false);
                }
                this.r = a2.getRoomId();
            }
            n();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = null;
            super.g();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK);
            if (this.o.a() != null) {
                statisticItem.param("fid", this.o.a().getForumId());
                statisticItem.param("fname", this.o.a().getForumName());
                statisticItem.param("room_id", this.o.a().getRoomId());
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
            p75 d = p75.d(this.l);
            d.C(R.dimen.T_X07);
            d.D(R.string.F_X01);
            d.x(R.color.CAM_X0105);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            zd8 zd8Var = this.o;
            if (zd8Var != null && zd8Var.a() != null && this.o.a().isLocationScrolled()) {
                i2 = R.color.CAM_X0313;
                i = R.string.A_X03;
            } else {
                i = R.string.A_X06;
                i2 = R.color.CAM_X0211;
            }
            p75 d2 = p75.d(this.e);
            d2.o(R.string.J_X06);
            d2.e(i);
            d2.f(i2);
            p75 d3 = p75.d(this.n);
            d3.C(R.dimen.T_X10);
            d3.D(R.string.F_X01);
            d3.x(R.color.CAM_X0108);
            this.h.setBorderWidth(x);
            this.h.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
            this.h.setIsRound(true);
            this.h.setDrawBorder(true);
            this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.h.setPlaceHolder(1);
            this.h.setDrawBorder(true);
            p75 d4 = p75.d(this.q);
            d4.C(R.dimen.T_X08);
            d4.D(R.string.F_X01);
            d4.x(R.color.CAM_X0301);
        }
    }
}
