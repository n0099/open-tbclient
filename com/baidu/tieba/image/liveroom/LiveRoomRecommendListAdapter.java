package com.baidu.tieba.image.liveroom;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.live.ImageViewLiveEvent;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ok8;
import com.baidu.tieba.vk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class LiveRoomRecommendListAdapter extends RecyclerView.Adapter<LiveRoomViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final List<vk8> b;
    public final TbPageContext c;
    public String d;
    public String e;
    public String f;

    /* loaded from: classes6.dex */
    public static class LiveRoomItemDecoration extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public LiveRoomItemDecoration() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                super.getItemOffsets(rect, view2, recyclerView, state);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) / 2;
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                if (childAdapterPosition % 2 == 1) {
                    i = dimenPixelSize2 - dimenPixelSize;
                    dimenPixelSize2 = dimenPixelSize;
                } else {
                    i = dimenPixelSize;
                }
                rect.set(dimenPixelSize2, dimenPixelSize * 2, i, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class LiveRoomViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TBLottieAnimationView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveRoomViewHolder(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903f0);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903f6);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903f2);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0903f5);
            this.e = tBLottieAnimationView;
            tBLottieAnimationView.setImageAssetsFolder("lottie_live_icon");
            this.e.setRepeatCount(-1);
            SkinManager.setLottieAnimation(this.e, R.raw.obfuscated_res_0x7f110045);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903f3);
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager.from(this.b).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X02);
                EMManager.from(this.c).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
                EMManager.from(this.d).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRoomViewHolder a;

        public a(LiveRoomRecommendListAdapter liveRoomRecommendListAdapter, LiveRoomViewHolder liveRoomViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveRoomRecommendListAdapter, liveRoomViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveRoomViewHolder;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.resumeAnimation();
                this.a.e.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.e.cancelAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk8 a;
        public final /* synthetic */ LiveRoomRecommendListAdapter b;

        public b(LiveRoomRecommendListAdapter liveRoomRecommendListAdapter, vk8 vk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveRoomRecommendListAdapter, vk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = liveRoomRecommendListAdapter;
            this.a = vk8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveRoomRecommendListAdapter liveRoomRecommendListAdapter = this.b;
                liveRoomRecommendListAdapter.n(liveRoomRecommendListAdapter.c.getPageActivity(), this.a);
            }
        }
    }

    public LiveRoomRecommendListAdapter(TbPageContext tbPageContext, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = new ArrayList();
        this.c = tbPageContext;
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public void r(List<vk8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.b.clear();
        m(list);
        this.b.addAll(list);
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

    public final void m(List<vk8> list) {
        int navigationBarHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (UtilHelper.isNavigationbarShown(this.c.getResources())) {
                navigationBarHeight = 0;
            } else {
                navigationBarHeight = AndroidUtils.getNavigationBarHeight(this.c.getPageActivity());
            }
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.c.getPageActivity());
            int dimenPixelSize = ((screenDimensions[1] - navigationBarHeight) - this.a) - UtilHelper.getDimenPixelSize(R.dimen.tbds48);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            double dimenPixelSize3 = dimenPixelSize / ((((int) ((((screenDimensions[0] - dimenPixelSize2) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X004)) / 2) * 1.25d)) + dimenPixelSize2) * 1.0d);
            if (dimenPixelSize3 > 2.0d && dimenPixelSize3 <= 3.0d) {
                while (list.size() > 4) {
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public void n(Context context, vk8 vk8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, vk8Var) == null) && context != null && vk8Var != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            ok8.c(1, this.d, this.e, TbadkCoreApplication.getCurrentAccount(), this.f, vk8Var);
            YyExtData g = vk8Var.g();
            if (g != null) {
                ImageViewLiveEvent imageViewLiveEvent = new ImageViewLiveEvent();
                String str = g.mSid;
                String str2 = g.mSsid;
                String str3 = g.mTemplateId;
                imageViewLiveEvent.initData(str, str2, str3, "" + vk8Var.d(), g.streamInfo, YYLiveUtil.SOURCE_PB_DATU_EOF);
                MutiProcessManager.publishEvent(imageViewLiveEvent);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p */
    public LiveRoomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            View inflate = LayoutInflater.from(this.c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05f9, viewGroup, false);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.c.getPageActivity());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            inflate.setLayoutParams(new FrameLayout.LayoutParams((screenDimensions[0] - dimenPixelSize) / 2, ((int) ((((screenDimensions[0] - dimenPixelSize) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X004)) / 2) * 1.25d)) + dimenPixelSize));
            return new LiveRoomViewHolder(inflate);
        }
        return (LiveRoomViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NonNull LiveRoomViewHolder liveRoomViewHolder, int i) {
        vk8 vk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, liveRoomViewHolder, i) != null) || (vk8Var = this.b.get(i)) == null) {
            return;
        }
        ok8.e(this.d, this.e, TbadkCoreApplication.getCurrentAccount(), this.f, vk8Var);
        liveRoomViewHolder.a.setDefaultBgResource(R.drawable.icon_pic_zhibo_default);
        liveRoomViewHolder.a.setConrers(15);
        liveRoomViewHolder.a.setRadius(UtilHelper.getDimenPixelSize(R.dimen.NAD_F_J_X06));
        liveRoomViewHolder.a.startLoad(vk8Var.b(), 10, false);
        liveRoomViewHolder.b.setText(vk8Var.f());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(vk8Var.a());
        stringBuffer.append("人");
        liveRoomViewHolder.c.setText(stringBuffer.toString());
        liveRoomViewHolder.d.setText(vk8Var.c());
        liveRoomViewHolder.e.addOnAttachStateChangeListener(new a(this, liveRoomViewHolder));
        liveRoomViewHolder.a.setOnClickListener(new b(this, vk8Var));
    }
}
