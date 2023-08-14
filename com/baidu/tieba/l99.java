package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
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
/* loaded from: classes6.dex */
public class l99 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<FaceData> a;
    public Context b;
    public tl5 c;
    public int d;
    public int e;
    public c f;

    /* loaded from: classes6.dex */
    public interface c {
        void E0();

        void T0(FaceData faceData);
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

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public ImageView b;
        public final /* synthetic */ l99 c;

        /* loaded from: classes6.dex */
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
                    this.a.c.f.E0();
                }
            }
        }

        /* loaded from: classes6.dex */
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
                    this.a.c.f.T0((FaceData) view2.getTag());
                }
            }
        }

        public d(l99 l99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l99Var;
        }

        public final void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09107a);
                this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090878);
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.width = this.c.d;
                layoutParams.height = this.c.d;
                SkinManager.setImageResource(this.b, R.drawable.icon_live_close_n);
                this.a.setOnClickListener(new a(this));
                this.b.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ d b;

        public a(l99 l99Var, ViewGroup viewGroup, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l99Var, viewGroup, dVar};
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) && bdImage != null && (findViewWithTag = this.a.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                bdImage.drawImageTo(this.b.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ql5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public b(l99 l99Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l99Var, viewGroup};
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

        @Override // com.baidu.tieba.ql5
        public void a(BdImage bdImage, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, bdImage, str, z) == null) && (tbImageView = (TbImageView) this.a.findViewWithTag(str)) != null && bdImage != null) {
                bdImage.drawImageTo(tbImageView);
            }
        }
    }

    public l99(List<FaceData> list) {
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
        this.c = new tl5();
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.b);
        this.e = equipmentWidth;
        this.d = (equipmentWidth - (BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f070201) * 3)) / 4;
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
            imageFileInfo.addPageAction(cm5.g(i, i));
            BdImage c2 = this.c.c(imageFileInfo, false);
            dVar.a.setTag(imageFileInfo.toCachedKey(false));
            if (c2 != null) {
                c2.drawImageTo(dVar.a);
                dVar.a.setTag(null);
            } else {
                this.c.e(imageFileInfo, new b(this, viewGroup), false, false);
            }
            dVar.b.setVisibility(0);
        }
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, d dVar) {
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, dVar) == null) && emotionImageData != null) {
            Object loadResource = BdResourceLoader.getInstance().loadResource(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, dVar), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            if (loadResource != null && (loadResource instanceof BdImage)) {
                bdImage = (BdImage) loadResource;
            } else {
                bdImage = null;
            }
            if (bdImage != null) {
                bdImage.drawImageTo(dVar.a);
                dVar.a.setTag(null);
            }
            dVar.b.setVisibility(0);
        }
    }

    public final void e(EmotionImageData emotionImageData, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, dVar) == null) && emotionImageData != null) {
            dVar.a.setTag(emotionImageData.getThumbUrl());
            dVar.a.startLoad(emotionImageData.getThumbUrl(), 10, false);
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
                view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05b3, (ViewGroup) null);
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
