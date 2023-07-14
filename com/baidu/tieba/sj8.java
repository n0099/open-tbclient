package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.e47;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public jk8 a;
    @NonNull
    public oj8 b;
    public long c;
    public String d;
    @Nullable
    public TbPageContext e;
    public gj8 f;
    public final View.OnClickListener g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sj8 a;

        public a(sj8 sj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity pageActivity;
            jk8 jk8Var;
            long roomId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sj8 sj8Var = this.a;
                if (sj8Var.f != null && (jk8Var = sj8Var.a) != null) {
                    if (jk8Var.a() == null) {
                        roomId = this.a.c;
                    } else {
                        roomId = this.a.a.a().getRoomId();
                    }
                    if (this.a.d.equals("msgTabFragment")) {
                        sj8 sj8Var2 = this.a;
                        sj8Var2.j(sj8Var2.a, "2");
                    }
                    this.a.f.a(roomId, 0);
                }
                if (this.a.b.e() != null) {
                    this.a.b.e().setVisibility(8);
                }
                TbPageContext tbPageContext = this.a.e;
                if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
                    dq5 a = cq5.a();
                    sj8 sj8Var3 = this.a;
                    a.c(pageActivity, sj8Var3.c, "source_from_group_chat_dialog", sj8Var3.d());
                }
                this.a.c();
                this.a.b.c().setVisibility(8);
                jk8 jk8Var2 = this.a.a;
                if (jk8Var2 != null && jk8Var2.a() != null) {
                    this.a.a.a().setAtInfo(null);
                }
            }
        }
    }

    public sj8(@Nullable TbPageContext tbPageContext, @NonNull jk8 jk8Var, @NonNull oj8 oj8Var, String str, gj8 gj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jk8Var, oj8Var, str, gj8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.a = jk8Var;
        this.b = oj8Var;
        this.d = str;
        this.e = tbPageContext;
        this.f = gj8Var;
    }

    public /* synthetic */ void e(SpannableStringBuilder spannableStringBuilder) {
        this.b.d().setText(spannableStringBuilder);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK);
            jk8 jk8Var = this.a;
            if (jk8Var != null && jk8Var.a() != null) {
                statisticItem.param("fid", this.a.a().getForumId());
                statisticItem.param("fname", this.a.a().getForumName());
                statisticItem.param("room_id", this.a.a().getRoomId());
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (this.d.equals("msgTabFragment")) {
                statisticItem.param("obj_locate", 15);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            jk8 jk8Var = this.a;
            if (jk8Var != null && jk8Var.a() != null) {
                ChatRoomInfo a2 = this.a.a();
                if (a2.getName() != null) {
                    this.b.f().setText(MeasureTextLength.fitTextLabel(a2.getName(), "...", MeasureTextLength.spaceLength(this.b.i()), this.b.f().getPaint(), ""));
                }
                l(a2, this.a.b());
                if (a2.getAvatar() != null) {
                    this.b.b().N(a2.getAvatar(), 10, false);
                }
                this.c = a2.getRoomId();
            }
            this.b.h(this.a);
            this.b.j();
            this.b.g().setOnClickListener(this.g);
            j(this.a, "1");
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if ("msgTabFragment".equals(this.d)) {
                return 15;
            }
            if ("dialog".equals(this.d)) {
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public void f(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatRoomInfo) == null) {
            ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
            if (newMessage != null && !StringUtils.isNull(newMessage.getSpecialMsg())) {
                this.b.c().setVisibility(0);
                this.b.c().setText(newMessage.getSpecialMsg());
                return;
            }
            this.b.c().setVisibility(8);
        }
    }

    public void g(@NonNull ChatRoomInfo chatRoomInfo) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomInfo) == null) {
            if (chatRoomInfo.getUnreadNum() < 10) {
                i = R.drawable.icon_list_dot_one_number;
            } else if (chatRoomInfo.getUnreadNum() < 100) {
                i = R.drawable.icon_list_dot_two_number;
            } else {
                i = R.drawable.icon_list_dot_three_number;
            }
            this.b.e().setBackgroundResource(i);
        }
    }

    public void h(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatRoomInfo) == null) {
            if (chatRoomInfo.getNewMessage() != null && !StringUtils.isNull(chatRoomInfo.getNewMessage().getContent())) {
                String str = "";
                if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getFromName())) {
                    str = "" + chatRoomInfo.getNewMessage().getFromName() + ": ";
                }
                if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getContent())) {
                    str = str + chatRoomInfo.getNewMessage().getContent();
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) str);
                e47.g(this.e.getContext(), spannableStringBuilder, new e47.i() { // from class: com.baidu.tieba.hj8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.e47.i
                    public final void a(SpannableStringBuilder spannableStringBuilder2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder2) == null) {
                            sj8.this.e(spannableStringBuilder2);
                        }
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = yi.g(TbadkApplication.getInst(), R.dimen.M_H_X003);
                this.b.f().setLayoutParams(layoutParams);
                this.b.d().setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15);
            this.b.f().setLayoutParams(layoutParams2);
            this.b.d().setVisibility(8);
        }
    }

    public void i(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, chatRoomInfo, z) == null) {
            if (chatRoomInfo.getUnreadNum() != 0 && z) {
                this.b.e().setVisibility(0);
                if (chatRoomInfo.getUnreadNum() >= 100) {
                    this.b.e().setText("99+");
                } else {
                    this.b.e().setText(String.valueOf(chatRoomInfo.getUnreadNum()));
                }
                if (this.d.equals("msgTabFragment")) {
                    this.b.a(this.a);
                    return;
                } else {
                    g(chatRoomInfo);
                    return;
                }
            }
            this.b.e().setVisibility(8);
        }
    }

    public void j(jk8 jk8Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jk8Var, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c15358");
            if (jk8Var != null && jk8Var.a() != null) {
                statisticItem.param("fid", jk8Var.a().getForumId());
                statisticItem.param("room_id", jk8Var.a().getRoomId());
                if (jk8Var.a().getUnreadNum() > 0) {
                    statisticItem.param("obj_source", "1");
                } else {
                    statisticItem.param("obj_source", "2");
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public void l(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, chatRoomInfo, z) == null) {
            h(chatRoomInfo);
            i(chatRoomInfo, z);
            f(chatRoomInfo);
        }
    }
}
