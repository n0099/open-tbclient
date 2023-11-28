package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.underlayer.StatOnceSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.SpriteMemeInfo;
/* loaded from: classes9.dex */
public final class y3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a implements SpriteMemeReplyData.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ SpriteMemeInfo c;
        public final /* synthetic */ nwa d;

        public a(View.OnClickListener onClickListener, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, SpriteMemeInfo spriteMemeInfo, nwa nwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onClickListener, pbCommenFloorItemViewHolder, spriteMemeInfo, nwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
            this.b = pbCommenFloorItemViewHolder;
            this.c = spriteMemeInfo;
            this.d = nwaVar;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void a() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (onClickListener = this.a) != null) {
                onClickListener.onClick(this.b.I0);
                String str = this.c.use_same_guide;
                nwa nwaVar = this.d;
                y3a.i(2, str, nwaVar.C0, String.valueOf(nwaVar.q0()));
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void b() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onClickListener = this.a) != null) {
                onClickListener.onClick(this.b.I0);
                String str = this.c.use_same_text;
                nwa nwaVar = this.d;
                y3a.i(2, str, nwaVar.C0, String.valueOf(nwaVar.q0()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280610, "Lcom/baidu/tieba/y3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280610, "Lcom/baidu/tieba/y3a;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    }

    public static final void a(ImageView tagView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{tagView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            Intrinsics.checkNotNullParameter(tagView, "tagView");
            if (z) {
                tagView.setImageResource(R.drawable.pic_frs_headlines_n);
                tagView.setVisibility(0);
            } else if (z2 && z3) {
                tagView.setImageResource(R.drawable.obfuscated_res_0x7f081274);
                tagView.setVisibility(0);
            } else if (z2) {
                tagView.setImageResource(R.drawable.obfuscated_res_0x7f081272);
                tagView.setVisibility(0);
            } else if (z3) {
                tagView.setImageResource(R.drawable.obfuscated_res_0x7f081273);
                tagView.setVisibility(0);
            } else {
                tagView.setVisibility(8);
            }
            if (tagView.getVisibility() == 0 && tagView.getLayoutParams() != null) {
                tagView.getLayoutParams().height = i1a.n() - i1a.o();
            }
        }
    }

    public static final void d(PbCommenFloorItemViewHolder holder, final nwa postData, View.OnClickListener onClickListener, StatOnceSet<String> statOnceSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, holder, postData, onClickListener, statOnceSet) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(statOnceSet, "statOnceSet");
            if (holder.I0 == null) {
                return;
            }
            if (!postData.K0() && fg5.a.a()) {
                holder.I0.setVisibility(8);
                return;
            }
            final SpriteMemeInfo j0 = postData.j0();
            if (j0 == null) {
                return;
            }
            String str = j0.use_same_guide;
            Intrinsics.checkNotNullExpressionValue(str, "spriteMemeInfo.use_same_guide");
            holder.I0.a(new SpriteMemeReplyData(str, j0.use_same_text, SpriteMemeReplyData.SPRITE_SCENE.SCENE_PB, false, new a(onClickListener, holder, j0, postData), false, 32, null));
            holder.I0.setTag(j0);
            holder.I0.setVisibility(0);
            statOnceSet.c(postData.U(), new Runnable() { // from class: com.baidu.tieba.q3a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        y3a.e(SpriteMemeInfo.this, postData);
                    }
                }
            });
        }
    }

    public static final void b(List<pi> dataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dataList) == null) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            if (ListUtils.isEmpty(dataList)) {
                return;
            }
            Iterator<pi> it = dataList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof ThreadData) {
                    if (((ThreadData) next).funAdData != null) {
                        it.remove();
                    }
                } else if (!(next instanceof mwa) && !(next instanceof h36)) {
                    if ((next instanceof nwa) && ((nwa) next).A0 != null) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public static final void c(List<pi> dataList, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dataList, mwaVar) == null) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            if (ListUtils.isEmpty(dataList)) {
                return;
            }
            Iterator<pi> it = dataList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                pi next = it.next();
                lwa lwaVar = null;
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof h36)) {
                    it.remove();
                }
                if (next instanceof ThreadData) {
                    lwaVar = ((ThreadData) next).funAdData;
                } else if (next instanceof nwa) {
                    lwaVar = ((nwa) next).A0;
                }
                if (lwaVar != null && lwaVar.i()) {
                    i2 = i;
                }
                if (mwaVar != null && next == mwaVar) {
                    it.remove();
                    i3 = i;
                }
            }
        }
    }

    public static final void e(SpriteMemeInfo spriteMemeInfo, nwa postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, spriteMemeInfo, postData) == null) {
            Intrinsics.checkNotNullParameter(spriteMemeInfo, "$spriteMemeInfo");
            Intrinsics.checkNotNullParameter(postData, "$postData");
            i(1, spriteMemeInfo.use_same_guide, postData.C0, String.valueOf(postData.q0()));
        }
    }

    public static final void f(final PbFragment pbFragment, final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, pbFragment, i) == null) {
            Intrinsics.checkNotNullParameter(pbFragment, "pbFragment");
            if (i1a.z(pbFragment)) {
                pbFragment.x0 = true;
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.s3a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            y3a.g(PbFragment.this, i);
                        }
                    }
                });
                return;
            }
            h(pbFragment, i);
        }
    }

    public static final void g(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, pbFragment, i) == null) {
            Intrinsics.checkNotNullParameter(pbFragment, "$pbFragment");
            h(pbFragment, i);
        }
    }

    public static final void h(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, pbFragment, i) == null) {
            if (i > 0) {
                p2a.i(pbFragment.getListView(), i);
            } else {
                p2a.g(pbFragment.getListView());
            }
        }
    }

    public static final void i(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            xf5 xf5Var = new xf5();
            xf5Var.l(i);
            Intrinsics.checkNotNull(str);
            xf5Var.i(str);
            Intrinsics.checkNotNull(str2);
            xf5Var.g(str2);
            Intrinsics.checkNotNull(str3);
            xf5Var.k(str3);
            wf5.a.a(xf5Var);
        }
    }
}
