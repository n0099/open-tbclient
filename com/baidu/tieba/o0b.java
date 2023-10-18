package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class o0b extends h1b<q1b> implements j1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AssociatedItemContainer g;
    public final CustomMessageListener h;

    @Override // com.baidu.tieba.j1b
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o0b o0bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0bVar, Integer.valueOf(i)};
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
            this.a = o0bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                return;
            }
            this.a.E((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AssociatedItemContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o0b a;

        public b(o0b o0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o0bVar;
        }

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.b
        public void a(ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
                if (this.a.e != null) {
                    this.a.e.removeItemData(itemData);
                }
                if (ListUtils.isEmpty(this.a.g.getItemDataList())) {
                    this.a.g.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, q1b.class);
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
        this.h = new a(this, 2921516);
    }

    public final void D(ItemData itemData) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) && this.g != null && (writeData = this.e) != null) {
            writeData.addItemData(itemData);
            this.g.setVisibility(0);
            this.g.a(itemData);
        }
    }

    @Override // com.baidu.tieba.m1b
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
            G(writeData);
        }
    }

    @Override // com.baidu.tieba.m1b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) && !ListUtils.isEmpty(writeData.getItemDatas())) {
            Iterator<ItemData> it = writeData.getItemDatas().iterator();
            while (it.hasNext()) {
                D(it.next());
            }
        }
    }

    @Override // com.baidu.tieba.m1b
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
            G(writeData);
        }
    }

    @Override // com.baidu.tieba.h1b, com.baidu.tieba.m1b
    public void j(@NonNull o1b o1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, o1bVar) == null) {
            super.j(o1bVar);
            this.a.registerListener(this.h);
        }
    }

    @Override // com.baidu.tieba.m1b
    public void onChangeSkinType(int i) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (associatedItemContainer = this.g) != null) {
            associatedItemContainer.c();
        }
    }

    @Override // com.baidu.tieba.h1b, com.baidu.tieba.m1b
    public void r(cd5 cd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cd5Var) == null) {
            super.r(cd5Var);
            if (cd5Var.a == 61) {
                F();
            }
        }
    }

    public final void E(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, evaluateRelevanceItemSelectedMessage) == null) {
            ItemData itemData = new ItemData();
            itemData.itemId = JavaTypesHelper.toLong(evaluateRelevanceItemSelectedMessage.item_id, 0L);
            itemData.mTags = evaluateRelevanceItemSelectedMessage.tags;
            itemData.mScore = evaluateRelevanceItemSelectedMessage.score;
            itemData.mStar = evaluateRelevanceItemSelectedMessage.star;
            itemData.mIconUrl = evaluateRelevanceItemSelectedMessage.icon_url;
            itemData.mIconSize = evaluateRelevanceItemSelectedMessage.icon_size;
            itemData.mTitle = evaluateRelevanceItemSelectedMessage.item_name;
            D(itemData);
        }
    }

    public final void G(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
            writeData.getItemDatas().clear();
            writeData.getItemDataIds().clear();
            AssociatedItemContainer associatedItemContainer = this.g;
            if (associatedItemContainer != null) {
                for (ItemData itemData : associatedItemContainer.getItemDataList()) {
                    writeData.addItemData(itemData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.m1b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0512, viewGroup, false);
            this.c = inflate;
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) inflate.findViewById(R.id.obfuscated_res_0x7f0902df);
            this.g = associatedItemContainer;
            if (associatedItemContainer != null) {
                associatedItemContainer.setOnDeletedListener(new b(this));
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    public final void F() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (writeData = this.e) == null) {
            return;
        }
        if (!writeData.canAddItem()) {
            BdUtilHelper.showToast(this.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f18ed);
            return;
        }
        RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(this.a.getPageActivity(), 0);
        relevanceItemSearchActivityConfig.setSelectedIds(this.e.getItemDataIds());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
    }

    @Override // com.baidu.tieba.h1b, com.baidu.tieba.m1b
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            AssociatedItemContainer associatedItemContainer = this.g;
            if (associatedItemContainer != null && associatedItemContainer.getVisibility() == 0 && !ListUtils.isEmpty(this.g.getItemDataList())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
