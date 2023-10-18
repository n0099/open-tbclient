package com.baidu.tieba.pb.bot.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.pb.bot.menu.BotSkillMenuAdapter;
import com.baidu.tieba.pb.databinding.BotSkillMenuItemViewBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.CallRobotEntrance;
import tbclient.StyleConf;
import tbclient.StyleContentInfo;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter$ViewHolder;", "()V", "dataList", "", "Ltbclient/CallRobotEntrance;", "onItemClickListener", "Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter$OnItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", CriusAttrConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "", "OnItemClickListener", "ViewHolder", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BotSkillMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CallRobotEntrance> a;
    public a b;

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2, CallRobotEntrance callRobotEntrance);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/baidu/tieba/pb/databinding/BotSkillMenuItemViewBinding;", "(Lcom/baidu/tieba/pb/bot/menu/BotSkillMenuAdapter;Lcom/baidu/tieba/pb/databinding/BotSkillMenuItemViewBinding;)V", "getBinding", "()Lcom/baidu/tieba/pb/databinding/BotSkillMenuItemViewBinding;", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BotSkillMenuItemViewBinding a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BotSkillMenuAdapter botSkillMenuAdapter, BotSkillMenuItemViewBinding binding) {
            super(binding.getRoot());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {botSkillMenuAdapter, binding};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.a = binding;
        }

        public final BotSkillMenuItemViewBinding a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (BotSkillMenuItemViewBinding) invokeV.objValue;
        }
    }

    public BotSkillMenuAdapter() {
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

    public static final void m(BotSkillMenuAdapter this$0, ViewHolder holder, CallRobotEntrance callRobotEntrance, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, this$0, holder, callRobotEntrance, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(callRobotEntrance, "$callRobotEntrance");
            a aVar = this$0.b;
            if (aVar != null) {
                RelativeLayout relativeLayout = holder.a().c;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "holder.binding.botSkillMenuItemRoot");
                aVar.a(relativeLayout, callRobotEntrance);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(final ViewHolder holder, int i) {
        StyleContentInfo styleContentInfo;
        String str;
        StyleContentInfo styleContentInfo2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final CallRobotEntrance callRobotEntrance = this.a.get(i);
            TbImage tbImage = holder.a().b;
            ScalingUtils.ScaleType CENTER_INSIDE = ScalingUtils.ScaleType.CENTER_INSIDE;
            Intrinsics.checkNotNullExpressionValue(CENTER_INSIDE, "CENTER_INSIDE");
            tbImage.setScaleType(CENTER_INSIDE);
            boolean z = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                StyleConf styleConf = callRobotEntrance.style_conf;
                if (styleConf != null && (styleContentInfo2 = styleConf.dark) != null && (str2 = styleContentInfo2.content_icon) != null) {
                    if (str2.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        holder.a().b.l(str2);
                    }
                }
            } else {
                StyleConf styleConf2 = callRobotEntrance.style_conf;
                if (styleConf2 != null && (styleContentInfo = styleConf2.day) != null && (str = styleContentInfo.content_icon) != null) {
                    if (str.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        holder.a().b.l(str);
                    }
                }
            }
            holder.a().c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ie9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        BotSkillMenuAdapter.m(BotSkillMenuAdapter.this, holder, callRobotEntrance, view2);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            BotSkillMenuItemViewBinding c = BotSkillMenuItemViewBinding.c(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.f….context), parent, false)");
            return new ViewHolder(this, c);
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public final void o(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public final void setData(List<CallRobotEntrance> dataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataList) == null) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.a.clear();
            this.a.addAll(dataList);
            notifyDataSetChanged();
        }
    }
}
