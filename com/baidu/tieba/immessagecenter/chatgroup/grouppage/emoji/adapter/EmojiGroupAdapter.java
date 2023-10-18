package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.holder.EmojiGroupVH;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiGroupData;
import com.baidu.tieba.sn8;
import com.baidu.tieba.un8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EmojiGroupAdapter extends RecyclerView.Adapter<EmojiGroupVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final un8 a;
    public final List<EmojiGroupData> b;

    public EmojiGroupAdapter(@NonNull un8 un8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {un8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = un8Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@NonNull EmojiGroupVH emojiGroupVH, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emojiGroupVH, i) == null) {
            EmojiGroupData emojiGroupData = this.b.get(i);
            emojiGroupVH.a.setText(emojiGroupData.getGroupName());
            EMManager.from(emojiGroupVH.a).setTextColor(R.color.CAM_X0109);
            ((sn8) emojiGroupVH.b.getAdapter()).d(emojiGroupData.getReactions());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m */
    public EmojiGroupVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            return new EmojiGroupVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0293, viewGroup, false), this.a);
        }
        return (EmojiGroupVH) invokeLI.objValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void n(@NonNull List<EmojiGroupData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list.size() <= 0) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }
}
