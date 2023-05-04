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
/* loaded from: classes6.dex */
public class w7a extends p8a<y8a> implements r8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public AssociatedItemContainer g;
    public final CustomMessageListener h;

    @Override // com.baidu.tieba.r8a
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w7a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w7a w7aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w7aVar, Integer.valueOf(i)};
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
            this.a = w7aVar;
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

    /* loaded from: classes6.dex */
    public class b implements AssociatedItemContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w7a a;

        public b(w7a w7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w7aVar;
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
    public w7a(TbPageContext<?> tbPageContext) {
        super(tbPageContext, y8a.class);
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

    @Override // com.baidu.tieba.u8a
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) && !ListUtils.isEmpty(writeData.getItemDatas())) {
            Iterator<ItemData> it = writeData.getItemDatas().iterator();
            while (it.hasNext()) {
                D(it.next());
            }
        }
    }

    @Override // com.baidu.tieba.u8a
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
            G(writeData);
        }
    }

    @Override // com.baidu.tieba.u8a
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
            G(writeData);
        }
    }

    @Override // com.baidu.tieba.p8a, com.baidu.tieba.u8a
    public void j(@NonNull w8a w8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, w8aVar) == null) {
            super.j(w8aVar);
            this.a.registerListener(this.h);
        }
    }

    @Override // com.baidu.tieba.u8a
    public void onChangeSkinType(int i) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (associatedItemContainer = this.g) != null) {
            associatedItemContainer.c();
        }
    }

    @Override // com.baidu.tieba.p8a, com.baidu.tieba.u8a
    public void r(jd5 jd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jd5Var) == null) {
            super.r(jd5Var);
            if (jd5Var.a == 61) {
                F();
            }
        }
    }

    public final void E(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, evaluateRelevanceItemSelectedMessage) == null) {
            ItemData itemData = new ItemData();
            itemData.itemId = gg.g(evaluateRelevanceItemSelectedMessage.item_id, 0L);
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

    @Override // com.baidu.tieba.u8a
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04d0, viewGroup, false);
            this.c = inflate;
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) inflate.findViewById(R.id.obfuscated_res_0x7f0902cb);
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
            ii.P(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1748);
            return;
        }
        RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(this.a.getPageActivity(), 0);
        relevanceItemSearchActivityConfig.setSelectedIds(this.e.getItemDataIds());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
    }

    @Override // com.baidu.tieba.p8a, com.baidu.tieba.u8a
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
