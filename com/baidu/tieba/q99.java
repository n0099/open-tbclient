package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class q99 extends ca9<ra9> implements ea9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ForumTabSelectedView g;
    @Nullable
    public View h;
    public final ForumTabSelectedView.d i;

    @Override // com.baidu.tieba.ha9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.ha9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ForumTabSelectedView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q99 a;

        public a(q99 q99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q99Var;
        }

        @Override // com.baidu.tieba.write.view.ForumTabSelectedView.d
        public void a(FrsTabItemData frsTabItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, frsTabItemData) == null) {
                ((ra9) this.a.d).b = frsTabItemData;
                q99 q99Var = this.a;
                q99Var.y(q99Var.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q99(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ra9.class);
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
        this.i = new a(this);
    }

    @Override // com.baidu.tieba.ha9
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            ForumTabSelectedView forumTabSelectedView = this.g;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.o(i);
            }
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0210);
        }
    }

    @Override // com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public void q(@NonNull List<ha9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            super.q(list);
            for (ha9<?> ha9Var : list) {
                if (ha9Var instanceof l99) {
                    w((l99) ha9Var);
                }
            }
        }
    }

    public final boolean C(FrsTabInfoData frsTabInfoData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsTabInfoData, str)) == null) {
            if (frsTabInfoData == null || ListUtils.isEmpty(frsTabInfoData.tabList)) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i < frsTabInfoData.tabList.size()) {
                    if (str.equals(frsTabInfoData.tabList.get(i).name)) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i != -1) {
                frsTabInfoData.tabList.remove(i);
            }
            if (i == -1) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ha9
    public void c(WriteData writeData) {
        ForumTabSelectedView forumTabSelectedView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) != null) || (forumTabSelectedView = this.g) == null || forumTabSelectedView.getVisibility() != 0 || writeData == null) {
            return;
        }
        D d = this.d;
        if (((ra9) d).a != null) {
            writeData.setIsForumBusinessAccount(((ra9) d).a.isForumBusinessAccount);
        }
        FrsTabItemData selectedTabItemData = this.g.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        writeData.setTabId(selectedTabItemData.tabId);
        writeData.setTabName(selectedTabItemData.name);
        writeData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    @Override // com.baidu.tieba.ea9
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, obj) != null) || !(obj instanceof SelectForumData) || this.c == null) {
            return;
        }
        SelectForumData selectForumData = (SelectForumData) obj;
        if (!ListUtils.isEmpty(selectForumData.tabInfoList)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.selectedTabId = -1;
            List<FrsTabItemData> list = selectForumData.tabInfoList;
            frsTabInfoData.tabList = list;
            if (selectForumData.isForumBusinessAccount && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                frsTabInfoData.tabList.add(0, frsTabItemData);
            }
            frsTabInfoData.isForumBusinessAccount = selectForumData.isForumBusinessAccount;
            if (this.g != null) {
                C(frsTabInfoData, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06ec));
                this.g.setData(frsTabInfoData);
                if (this.g.getVisibility() == 0) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
            }
            ((ra9) this.d).a = frsTabInfoData;
            WriteData writeData = this.e;
            if (writeData != null) {
                writeData.setFrsTabInfoData(frsTabInfoData);
                return;
            }
            return;
        }
        this.c.setVisibility(8);
    }

    @Override // com.baidu.tieba.ha9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04bf, viewGroup, false);
            this.c = inflate;
            this.g = (ForumTabSelectedView) inflate.findViewById(R.id.obfuscated_res_0x7f090c42);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f090c3f);
            ForumTabSelectedView forumTabSelectedView = this.g;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.setBgColor(R.color.CAM_X0205);
                WriteData writeData = this.e;
                if (writeData != null) {
                    C(writeData.getFrsTabInfoData(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06ec));
                    this.g.setData(this.e.getFrsTabInfoData());
                    if (this.g.getVisibility() == 0) {
                        this.c.setVisibility(0);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                this.g.setActivity(this.a);
                this.g.setTabSelectedListener(this.i);
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
