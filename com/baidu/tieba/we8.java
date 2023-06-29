package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
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
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.v17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class we8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public kf8 a;
    @NonNull
    public se8 b;
    public long c;
    public String d;
    @Nullable
    public TbPageContext e;
    public ke8 f;
    public int g;
    public final View.OnClickListener h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we8 a;

        public a(we8 we8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = we8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity pageActivity;
            kf8 kf8Var;
            long roomId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                we8 we8Var = this.a;
                if (we8Var.f != null && (kf8Var = we8Var.a) != null) {
                    if (kf8Var.a() == null) {
                        roomId = this.a.c;
                    } else {
                        roomId = this.a.a.a().getRoomId();
                    }
                    if (this.a.d.equals("msgTabFragment")) {
                        we8 we8Var2 = this.a;
                        we8Var2.g(we8Var2.a, "2");
                    }
                    this.a.f.a(roomId, 0);
                }
                if (this.a.b.d() != null) {
                    this.a.b.d().setVisibility(8);
                }
                this.a.i();
                TbPageContext tbPageContext = this.a.e;
                if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
                    zo5 a = yo5.a();
                    we8 we8Var3 = this.a;
                    a.d(pageActivity, we8Var3.c, "source_from_group_chat_dialog", we8Var3.g);
                }
                this.a.b();
                this.a.b.b().setVisibility(8);
                kf8 kf8Var2 = this.a.a;
                if (kf8Var2 != null && kf8Var2.a() != null) {
                    this.a.a.a().setAtInfo(null);
                }
            }
        }
    }

    public we8(@Nullable TbPageContext tbPageContext, @NonNull kf8 kf8Var, @NonNull se8 se8Var, String str, ke8 ke8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, kf8Var, se8Var, str, ke8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.a = kf8Var;
        this.b = se8Var;
        this.d = str;
        this.e = tbPageContext;
        this.f = ke8Var;
    }

    public /* synthetic */ void c(SpannableStringBuilder spannableStringBuilder) {
        this.b.c().setText(spannableStringBuilder);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK);
            kf8 kf8Var = this.a;
            if (kf8Var != null && kf8Var.a() != null) {
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            kf8 kf8Var = this.a;
            if (kf8Var != null && kf8Var.a() != null) {
                ChatRoomInfo a2 = this.a.a();
                if (a2.getName() != null) {
                    this.b.e().setText(MeasureTextLength.fitTextLabel(a2.getName(), "...", MeasureTextLength.spaceLength(this.b.h()), this.b.e().getPaint(), ""));
                }
                j(a2, this.a.b());
                if (a2.getAvatar() != null) {
                    this.b.a().N(a2.getAvatar(), 10, false);
                }
                this.c = a2.getRoomId();
            }
            this.b.g(this.a);
            this.b.i();
            this.b.f().setOnClickListener(this.h);
            g(this.a, "1");
        }
    }

    public void d(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatRoomInfo) == null) {
            if (chatRoomInfo.getAtInfo() != null && chatRoomInfo.getAtInfo().getCountAll() > 0) {
                this.b.b().setVisibility(0);
                this.b.b().setText(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f092d));
                return;
            }
            this.b.b().setVisibility(8);
        }
    }

    public void e(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatRoomInfo) == null) {
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
                v17.g(this.e.getContext(), spannableStringBuilder, new v17.i() { // from class: com.baidu.tieba.le8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.v17.i
                    public final void a(SpannableStringBuilder spannableStringBuilder2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder2) == null) {
                            we8.this.c(spannableStringBuilder2);
                        }
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = xi.g(TbadkApplication.getInst(), R.dimen.M_H_X003);
                this.b.e().setLayoutParams(layoutParams);
                this.b.c().setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15);
            this.b.e().setLayoutParams(layoutParams2);
            this.b.c().setVisibility(8);
        }
    }

    public void f(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, chatRoomInfo, z) == null) {
            if (chatRoomInfo.getUnreadNum() != 0 && z) {
                this.b.d().setVisibility(0);
                if (chatRoomInfo.getUnreadNum() >= 100) {
                    this.b.d().setText("99+");
                } else {
                    this.b.d().setText(String.valueOf(chatRoomInfo.getUnreadNum()));
                }
                if (chatRoomInfo.getUnreadNum() < 10) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.rightMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds13);
                    layoutParams.leftMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds13);
                    layoutParams.topMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds2);
                    layoutParams.bottomMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds2);
                    this.b.d().setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.rightMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds10);
                layoutParams2.leftMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds10);
                layoutParams2.topMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds3);
                layoutParams2.bottomMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds3);
                this.b.d().setLayoutParams(layoutParams2);
                return;
            }
            this.b.d().setVisibility(8);
        }
    }

    public void g(kf8 kf8Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, kf8Var, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c15358");
            if (kf8Var != null && kf8Var.a() != null) {
                statisticItem.param("fid", kf8Var.a().getForumId());
                statisticItem.param("room_id", kf8Var.a().getRoomId());
                if (kf8Var.a().getUnreadNum() > 0) {
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

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.d.equals("msgTabFragment")) {
                this.g = 3;
            } else if (this.d.equals("dialog")) {
                this.g = 2;
            }
        }
    }

    public void j(@NonNull ChatRoomInfo chatRoomInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatRoomInfo, z) == null) {
            e(chatRoomInfo);
            f(chatRoomInfo, z);
            d(chatRoomInfo);
        }
    }
}
