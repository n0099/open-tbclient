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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.mutiprocess.live.ImageViewLiveEvent;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.b38;
import com.baidu.tieba.bj5;
import com.baidu.tieba.ii;
import com.baidu.tieba.q25;
import com.baidu.tieba.u28;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveRoomRecommendListAdapter extends RecyclerView.Adapter<LiveRoomViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final List<b38> b;
    public final TbPageContext c;
    public String d;
    public String e;
    public String f;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903d3);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903d9);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903d5);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0903d8);
            this.e = tBLottieAnimationView;
            tBLottieAnimationView.setImageAssetsFolder("lottie_live_icon");
            this.e.setRepeatCount(-1);
            SkinManager.setLottieAnimation(this.e, R.raw.obfuscated_res_0x7f110043);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903d6);
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q25 d = q25.d(this.b);
                d.w(R.color.CAM_X0101);
                d.B(R.dimen.T_X06);
                d.C(R.string.F_X02);
                q25 d2 = q25.d(this.c);
                d2.w(R.color.CAM_X0101);
                d2.B(R.dimen.T_X09);
                d2.C(R.string.F_X01);
                q25 d3 = q25.d(this.d);
                d3.w(R.color.CAM_X0101);
                d3.B(R.dimen.T_X09);
                d3.C(R.string.F_X01);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;
        public final /* synthetic */ LiveRoomRecommendListAdapter b;

        public b(LiveRoomRecommendListAdapter liveRoomRecommendListAdapter, b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveRoomRecommendListAdapter, b38Var};
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
            this.a = b38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveRoomRecommendListAdapter liveRoomRecommendListAdapter = this.b;
                liveRoomRecommendListAdapter.m(liveRoomRecommendListAdapter.c.getPageActivity(), this.a);
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

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public void q(List<b38> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.b.clear();
        l(list);
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

    public final void l(List<b38> list) {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (UtilHelper.isNavigationbarShown(this.c.getResources())) {
                b2 = 0;
            } else {
                b2 = yh.b(this.c.getPageActivity());
            }
            int[] s = ii.s(this.c.getPageActivity());
            int dimenPixelSize = ((s[1] - b2) - this.a) - UtilHelper.getDimenPixelSize(R.dimen.tbds48);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            double dimenPixelSize3 = dimenPixelSize / ((((int) ((((s[0] - dimenPixelSize2) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X004)) / 2) * 1.25d)) + dimenPixelSize2) * 1.0d);
            if (dimenPixelSize3 > 2.0d && dimenPixelSize3 <= 3.0d) {
                while (list.size() > 4) {
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public void m(Context context, b38 b38Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, b38Var) == null) && context != null && b38Var != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ii.P(context, R.string.no_network_guide);
                return;
            }
            u28.c(1, this.d, this.e, TbadkCoreApplication.getCurrentAccount(), this.f, b38Var);
            YyExtData g = b38Var.g();
            if (g != null) {
                ImageViewLiveEvent imageViewLiveEvent = new ImageViewLiveEvent();
                String str = g.mSid;
                String str2 = g.mSsid;
                String str3 = g.mTemplateId;
                imageViewLiveEvent.initData(str, str2, str3, "" + b38Var.d(), g.streamInfo, YYLiveUtil.SOURCE_PB_DATU_EOF);
                bj5.i(imageViewLiveEvent);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public LiveRoomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            View inflate = LayoutInflater.from(this.c.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d059c, viewGroup, false);
            int[] s = ii.s(this.c.getPageActivity());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            inflate.setLayoutParams(new FrameLayout.LayoutParams((s[0] - dimenPixelSize) / 2, ((int) ((((s[0] - dimenPixelSize) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X004)) / 2) * 1.25d)) + dimenPixelSize));
            return new LiveRoomViewHolder(inflate);
        }
        return (LiveRoomViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull LiveRoomViewHolder liveRoomViewHolder, int i) {
        b38 b38Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, liveRoomViewHolder, i) != null) || (b38Var = this.b.get(i)) == null) {
            return;
        }
        u28.e(this.d, this.e, TbadkCoreApplication.getCurrentAccount(), this.f, b38Var);
        liveRoomViewHolder.a.setDefaultBgResource(R.drawable.icon_pic_zhibo_default);
        liveRoomViewHolder.a.setConrers(15);
        liveRoomViewHolder.a.setRadius(UtilHelper.getDimenPixelSize(R.dimen.NAD_F_J_X06));
        liveRoomViewHolder.a.N(b38Var.b(), 10, false);
        liveRoomViewHolder.b.setText(b38Var.f());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(b38Var.a());
        stringBuffer.append("人");
        liveRoomViewHolder.c.setText(stringBuffer.toString());
        liveRoomViewHolder.d.setText(b38Var.c());
        liveRoomViewHolder.e.addOnAttachStateChangeListener(new a(this, liveRoomViewHolder));
        liveRoomViewHolder.a.setOnClickListener(new b(this, b38Var));
    }
}
