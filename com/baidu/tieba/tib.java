package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tib extends fjb<ujb> implements hjb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ForumTabSelectedView g;
    @Nullable
    public View h;
    public String i;
    public final ForumTabSelectedView.d j;

    @Override // com.baidu.tieba.kjb
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.kjb
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements ForumTabSelectedView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tib a;

        public a(tib tibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tibVar;
        }

        @Override // com.baidu.tieba.write.view.ForumTabSelectedView.d
        public void a(FrsTabItemData frsTabItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, frsTabItemData) == null) {
                ((ujb) this.a.d).b = frsTabItemData;
                tib tibVar = this.a;
                tibVar.y(tibVar.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tib(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ujb.class);
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
        this.i = this.a.getString(R.string.obfuscated_res_0x7f0f07fa);
    }

    public final void C(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, frsTabInfoData) == null) && frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            ArrayList arrayList = new ArrayList();
            for (FrsTabItemData frsTabItemData : frsTabInfoData.tabList) {
                String str = this.i;
                if ((str != null && frsTabItemData != null && str.equals(frsTabItemData.name)) || frsTabItemData.isNoShowInPublisher) {
                    arrayList.add(frsTabItemData);
                }
            }
            frsTabInfoData.tabList.removeAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.kjb
    public void a(WriteData writeData) {
        ForumTabSelectedView forumTabSelectedView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) != null) || (forumTabSelectedView = this.g) == null || forumTabSelectedView.getVisibility() != 0 || writeData == null) {
            return;
        }
        D d = this.d;
        if (((ujb) d).a != null) {
            writeData.setIsForumBusinessAccount(((ujb) d).a.isForumBusinessAccount);
        }
        FrsTabItemData selectedTabItemData = this.g.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        writeData.setTabId(selectedTabItemData.tabId);
        writeData.setTabName(selectedTabItemData.name);
        writeData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    @Override // com.baidu.tieba.kjb
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

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public void q(@NonNull List<kjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            super.q(list);
            for (kjb<?> kjbVar : list) {
                if (kjbVar instanceof oib) {
                    w((oib) kjbVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.hjb
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
                C(frsTabInfoData);
                this.g.setData(frsTabInfoData);
                if (this.g.getVisibility() == 0) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
            }
            ((ujb) this.d).a = frsTabInfoData;
            WriteData writeData = this.e;
            if (writeData != null) {
                writeData.setFrsTabInfoData(frsTabInfoData);
                return;
            }
            return;
        }
        this.c.setVisibility(8);
    }

    @Override // com.baidu.tieba.kjb
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0556, viewGroup, false);
            this.c = inflate;
            this.g = (ForumTabSelectedView) inflate.findViewById(R.id.obfuscated_res_0x7f090deb);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f090de8);
            ForumTabSelectedView forumTabSelectedView = this.g;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.setBgColor(R.color.CAM_X0205);
                WriteData writeData = this.e;
                if (writeData != null) {
                    C(writeData.getFrsTabInfoData());
                    this.g.setData(this.e.getFrsTabInfoData());
                    if (this.g.getVisibility() == 0) {
                        this.c.setVisibility(0);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                this.g.setActivity(this.a);
                this.g.setTabSelectedListener(this.j);
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
