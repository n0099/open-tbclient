package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.holder.EmojiDetailHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiDetailUserInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EmojiDetailRecyclerAdapter extends RecyclerView.Adapter<EmojiDetailHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<EmojiDetailUserInfo> a;
    @Nullable
    public EmojiDetailUserInfo b;
    public final View.OnClickListener c;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiDetailRecyclerAdapter a;

        public a(EmojiDetailRecyclerAdapter emojiDetailRecyclerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiDetailRecyclerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiDetailRecyclerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.b == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), BIMManager.getBdUidFromBdUK(this.a.b.getUk()), this.a.b.getUserName())));
        }
    }

    public EmojiDetailRecyclerAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.c = new a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void m(List<EmojiDetailUserInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(EmojiDetailHolder emojiDetailHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, emojiDetailHolder, i) == null) {
            emojiDetailHolder.getItemView().setOnClickListener(this.c);
            EmojiDetailUserInfo emojiDetailUserInfo = this.a.get(i);
            this.b = emojiDetailUserInfo;
            emojiDetailHolder.a.N(emojiDetailUserInfo.getPortrait(), 12, false);
            emojiDetailHolder.b.setText(this.b.getUserName());
            d85 d = d85.d(emojiDetailHolder.b);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X07);
            d.D(R.string.F_X01);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public EmojiDetailHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new EmojiDetailHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0288, viewGroup, false));
        }
        return (EmojiDetailHolder) invokeLI.objValue;
    }
}
