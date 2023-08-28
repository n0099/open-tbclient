package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l1b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImageFileInfo> a;
    public Context b;
    public hm5 c;
    public mi5 d;
    public f e;
    public LayoutInflater f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes6.dex */
    public interface f {
        void a();

        void b(int i);

        void c(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l1b a;

        public a(l1b l1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l1bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                p1b.b(this.a.b, 13);
                this.a.e.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ l1b b;

        public b(l1b l1bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l1bVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (i = this.a) >= 0) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.b.getItem(i);
                if (imageFileInfo.isFromMoreForum) {
                    return;
                }
                boolean z = true;
                if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                    z = false;
                }
                if (!z) {
                    BdUtilHelper.showLongToast(this.b.b, (int) R.string.editor_mutiiamge_image_error);
                    return;
                }
                if (this.b.d != null) {
                    this.b.d.S(new zh5(15, 0, Integer.valueOf(this.a)));
                }
                if (this.b.e != null) {
                    this.b.e.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ l1b b;

        public c(l1b l1bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l1bVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.e != null) {
                this.b.e.c(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements em5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public d(l1b l1bVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1bVar, viewGroup};
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

        @Override // com.baidu.tieba.em5
        public void a(BdImage bdImage, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, bdImage, str, z) == null) && (tbImageView = (TbImageView) this.a.findViewWithTag(str)) != null && bdImage != null) {
                tbImageView.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ String b;

        public e(l1b l1bVar, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1bVar, viewGroup, str};
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
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) && (tbImageView = (TbImageView) this.a.findViewWithTag(this.b)) != null && bdImage != null) {
                tbImageView.invalidate();
            }
        }
    }

    public l1b(Context context, hm5 hm5Var, mi5 mi5Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hm5Var, mi5Var, fVar};
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
        this.g = false;
        this.h = false;
        this.j = false;
        this.d = mi5Var;
        this.b = context;
        this.f = LayoutInflater.from(context);
        this.c = hm5Var;
        this.e = fVar;
    }

    public final String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.b.getResources().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.j = z;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.g = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = true;
            this.h = z;
        }
    }

    public final void e(ImageFileInfo imageFileInfo, View view2, ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageFileInfo, view2, viewGroup, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && imageFileInfo != null && i > 0 && i2 > 0) {
            ImageOperation g = rm5.g(i, i2);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(g);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911fd);
            ((FrameLayout) view2.findViewById(R.id.item_root)).setForeground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0810cc));
            if (imageFileInfo.getImageType() == 0) {
                BdImage c2 = this.c.c(imageFileInfo, true);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (c2 != null) {
                    tbImageView.invalidate();
                } else {
                    this.c.d(imageFileInfo, new d(this, viewGroup), true);
                }
                tbImageView.setTagStr(this.b.getString(R.string.obfuscated_res_0x7f0f0615));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!di.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(filePath, 20);
                    tbImageView.setTag(genCacheKey);
                    BdResourceLoader.getInstance().loadResource(filePath, 20, new e(this, viewGroup, genCacheKey), 0, 0, null, null, filePath, Boolean.FALSE, null);
                }
                tbImageView.setTagStr("");
            }
        }
    }

    public void g(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, writeImagesInfo) != null) || writeImagesInfo == null) {
            return;
        }
        this.i = writeImagesInfo.getMaxImagesAllowed();
        int count = ListUtils.getCount(writeImagesInfo.getChosedFiles());
        this.a.clear();
        if (count > 0) {
            this.a.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count < this.i && this.g) {
            if (this.j || (this.h && count > 0)) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath("FLAG_ADD_ICON");
                this.a.add(imageFileInfo);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        AbsListView.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.a, i);
            if (imageFileInfo == null) {
                return null;
            }
            if (view2 == null) {
                view2 = this.f.inflate(R.layout.obfuscated_res_0x7f0d06fe, (ViewGroup) null);
            }
            int equipmentWidth = (BdUtilHelper.getEquipmentWidth(this.b) - ((BdUtilHelper.getDimens(this.b, R.dimen.tbds44) * 2) + (BdUtilHelper.getDimens(this.b, R.dimen.tbds10) * 2))) / 3;
            if (view2.getLayoutParams() instanceof AbsListView.LayoutParams) {
                layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = equipmentWidth;
            } else {
                layoutParams = new AbsListView.LayoutParams(equipmentWidth, equipmentWidth);
            }
            view2.setLayoutParams(layoutParams);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911fd);
            tbImageView.setTagTextSize(BdUtilHelper.getDimens(this.b, R.dimen.T_X10));
            tbImageView.setDrawBorder(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setAutoChangeStyle(true);
            tbImageView.setConrers(15);
            tbImageView.setRadiusById(R.string.J_X05);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09087e);
            ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090877)).setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.item_root);
            if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
                tbImageView.setVisibility(8);
                linearLayout.setVisibility(8);
                view2.setBackgroundDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080bb4, WebPManager.ResourceStateType.NORMAL_PRESS));
                view2.invalidate();
                frameLayout.setForeground(null);
                view2.setOnClickListener(new a(this));
            } else {
                tbImageView.setVisibility(0);
                linearLayout.setVisibility(0);
                view2.setBackgroundResource(0);
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(imageFileInfo.isLong());
                tbImageView.setTagStr(d(R.string.obfuscated_res_0x7f0f0615));
                tbImageView.setTagColor(this.b.getResources().getColor(R.color.CAM_X0101));
                e(imageFileInfo, view2, viewGroup, equipmentWidth, equipmentWidth);
                if (imageFileInfo.isFromMoreForum) {
                    linearLayout.setVisibility(8);
                    tbImageView.setTagStr("");
                }
                view2.setOnClickListener(new b(this, i));
                linearLayout.setOnClickListener(new c(this, i));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
