package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class nt7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<FaceData> a;
    public Context b;
    public h95 c;
    public int d;
    public int e;
    public c f;

    /* loaded from: classes5.dex */
    public interface c {
        void J0();

        void X0(FaceData faceData);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public ImageView b;
        public final /* synthetic */ nt7 c;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c.f != null && view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof FaceData) && ((FaceData) view2.getTag(view2.getId())).type == 4) {
                    this.a.c.f.J0();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c.f != null && view2.getTag() != null && (view2.getTag() instanceof FaceData)) {
                    this.a.c.f.X0((FaceData) view2.getTag());
                }
            }
        }

        public d(nt7 nt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nt7Var;
        }

        public final void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eb7);
                this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907a5);
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.width = this.c.d;
                layoutParams.height = this.c.d;
                SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f0807b9);
                this.a.setOnClickListener(new a(this));
                this.b.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends rg<hn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ d b;

        public a(nt7 nt7Var, ViewGroup viewGroup, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var, viewGroup, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(hn hnVar, String str, int i) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, hnVar, str, i) == null) && hnVar != null && (findViewWithTag = this.a.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                hnVar.h(this.b.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d95 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public b(nt7 nt7Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt7Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
        }

        @Override // com.baidu.tieba.d95
        public void a(hn hnVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, hnVar, str, z) == null) && (tbImageView = (TbImageView) this.a.findViewWithTag(str)) != null && hnVar != null) {
                hnVar.h(tbImageView);
            }
        }
    }

    public nt7(List<FaceData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = BdBaseApplication.getInst().getApp();
        this.a = list;
        this.c = new h95();
        int l = xi.l(this.b);
        this.e = l;
        this.d = (l - (xi.g(this.b, R.dimen.obfuscated_res_0x7f070201) * 3)) / 4;
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f = cVar;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<FaceData> list = this.a;
            if (list != null && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, dVar) == null) && imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            int i = this.d;
            imageFileInfo.addPageAction(q95.g(i, i));
            hn c2 = this.c.c(imageFileInfo, false);
            dVar.a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.h(dVar.a);
                dVar.a.setTag(null);
            } else {
                this.c.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            dVar.b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, d dVar) {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, dVar) == null) && emotionImageData != null) {
            Object k = sg.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, dVar), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            if (k != null && (k instanceof hn)) {
                hnVar = (hn) k;
            } else {
                hnVar = null;
            }
            if (hnVar != null) {
                hnVar.h(dVar.a);
                dVar.a.setTag(null);
            }
            dVar.b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, dVar) == null) && emotionImageData != null) {
            dVar.a.setTag(emotionImageData.getThumbUrl());
            dVar.a.K(emotionImageData.getThumbUrl(), 10, false);
            dVar.b.setVisibility(0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                dVar = new d(this);
                view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d053a, (ViewGroup) null);
                dVar.b(view3);
                view3.setTag(dVar);
            } else {
                view3 = view2;
                dVar = (d) view2.getTag();
            }
            FaceData faceData = this.a.get(i);
            if (faceData != null) {
                int i2 = faceData.type;
                if (i2 == 4) {
                    SkinManager.setImageResource(dVar.a, R.drawable.emotion_icon_add_pic);
                    dVar.b.setVisibility(8);
                } else if (i2 == 1) {
                    dVar.a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, dVar);
                } else if (i2 == 2) {
                    dVar.a.setImageDrawable(null);
                    e(faceData.emotionImageData, dVar);
                } else {
                    dVar.a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, dVar);
                }
                TbImageView tbImageView = dVar.a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            dVar.b.setTag(faceData);
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
