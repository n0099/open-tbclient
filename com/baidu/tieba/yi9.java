package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.data.GameData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.wk9;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class yi9 extends lj9<zj9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ForumSelectedView g;
    @Nullable
    public wk9 h;
    @Nullable
    public SelectForumData i;
    public final wk9.b j;

    @Override // com.baidu.tieba.qj9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.qj9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements wk9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi9 a;

        public a(yi9 yi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi9Var;
        }

        @Override // com.baidu.tieba.wk9.b
        public void a(@NonNull SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, selectForumData) != null) {
                return;
            }
            this.a.i = selectForumData;
            if (this.a.e != null) {
                this.a.e.setForumId(selectForumData.forumId);
                this.a.e.setForumName(selectForumData.forumName);
            }
            if (this.a.g != null) {
                this.a.g.setSelectedForum(selectForumData.forumName);
            }
            this.a.y(selectForumData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yi9(TbPageContext<?> tbPageContext) {
        super(tbPageContext, zj9.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void q(@NonNull List<qj9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            super.q(list);
            for (qj9<?> qj9Var : list) {
                if (qj9Var instanceof zi9) {
                    w((zi9) qj9Var);
                } else if (qj9Var instanceof hj9) {
                    w((hj9) qj9Var);
                } else if (qj9Var instanceof vi9) {
                    w((vi9) qj9Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qj9
    public void c(WriteData writeData) {
        SelectForumData selectForumData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) && (selectForumData = this.i) != null) {
            writeData.setForumId(selectForumData.forumId);
            writeData.setForumName(this.i.forumName);
        }
    }

    @Override // com.baidu.tieba.qj9
    public void onChangeSkinType(int i) {
        ForumSelectedView forumSelectedView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (forumSelectedView = this.g) != null) {
            forumSelectedView.c();
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.e;
            if (writeData != null && "2".equals(writeData.getCallFrom())) {
                return TextUtils.isEmpty(this.e.getForumName());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            wk9 wk9Var = this.h;
            if (wk9Var != null) {
                wk9Var.d();
            }
        }
    }

    public final void G() {
        ThemeColorInfo themeColorInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bf6 bf6Var = new bf6(this.a, this.c);
            bf6Var.L(R.drawable.bg_tip_blue_dropup_left);
            if (ae5.b().a() != null) {
                themeColorInfo = ae5.b().a().f;
            } else {
                themeColorInfo = null;
            }
            bf6Var.M(SkinManager.getColorFromServerColor(themeColorInfo, R.color.CAM_X0301));
            bf6Var.o(32);
            bf6Var.l(4);
            bf6Var.Q(-50);
            bf6Var.R(-10);
            bf6Var.J(R.dimen.T_X08);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            bf6Var.E(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds40), dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds23));
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f128e);
            if (ae5.b().a() != null && !TextUtils.isEmpty(ae5.b().a().d)) {
                string = ae5.b().a().d;
            }
            if (StringHelper.getChineseAndEnglishLength(string) > 40) {
                bf6Var.Q(0);
            }
            bf6Var.T(string, ap6.a("springfestival", "write_select_forum"));
        }
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void j(@NonNull sj9 sj9Var) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sj9Var) == null) {
            super.j(sj9Var);
            if (this.h == null) {
                wk9 wk9Var = new wk9();
                this.h = wk9Var;
                wk9Var.c(this.j);
            }
            this.h.b(this.a.getUniqueId());
            if (be5.b.a().a("show_write_tip") && (writeData = this.e) != null && "springfestival".equals(writeData.getActiveName()) && "write_select_forum".equals(this.e.getActiveTaskName())) {
                G();
            }
        }
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (F()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a.getPageActivity())));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qj9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04bd, viewGroup, false);
            this.c = inflate;
            ForumSelectedView forumSelectedView = (ForumSelectedView) inflate.findViewById(R.id.obfuscated_res_0x7f091f31);
            this.g = forumSelectedView;
            WriteData writeData = this.e;
            if (writeData != null && forumSelectedView != null) {
                if ("main_tab".equals(writeData.getFrom()) && !this.e.isFromErrorDialog()) {
                    this.g.setVisibility(0);
                } else if (!TextUtils.isEmpty(this.e.getForumName())) {
                    this.g.setVisibility(0);
                    this.g.setSelectedForum(this.e.getForumName());
                    if (this.e.isFromGameRank()) {
                        GameData gameData = new GameData();
                        gameData.gameId = this.e.getGameId();
                        gameData.gameName = this.e.getGameName();
                        this.g.setGameData(gameData);
                    } else {
                        this.g.a();
                        this.g.setOnClickListener(null);
                    }
                } else {
                    this.g.setVisibility(8);
                }
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
