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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes5.dex */
public class r39 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImageFileInfo> a;
    public Context b;
    public k85 c;
    public t55 d;
    public f e;
    public LayoutInflater f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r39 a;

        public a(r39 r39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
            this.a.e.a();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ r39 b;

        public b(r39 r39Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r39Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r39Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (i = this.a) < 0) {
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.b.getItem(i);
            if (imageFileInfo.isFromMoreForum) {
                return;
            }
            boolean z = true;
            if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                z = false;
            }
            if (!z) {
                ej.J(this.b.b, R.string.obfuscated_res_0x7f0f0548);
                return;
            }
            if (this.b.d != null) {
                this.b.d.K(new h55(15, 0, Integer.valueOf(this.a)));
            }
            if (this.b.e != null) {
                this.b.e.b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ r39 b;

        public c(r39 r39Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r39Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r39Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.e == null) {
                return;
            }
            this.b.e.c(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements g85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public d(r39 r39Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r39Var, viewGroup};
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

        @Override // com.baidu.tieba.g85
        public void a(on onVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, onVar, str, z) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(str)) == null || onVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ String b;

        public e(r39 r39Var, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r39Var, viewGroup, str};
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
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(this.b)) == null || onVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();

        void b(int i);

        void c(int i);
    }

    public r39(Context context, k85 k85Var, t55 t55Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, k85Var, t55Var, fVar};
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
        this.d = t55Var;
        this.b = context;
        this.f = LayoutInflater.from(context);
        this.c = k85Var;
        this.e = fVar;
    }

    public final String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.b.getResources().getString(i) : (String) invokeI.objValue;
    }

    public final void e(ImageFileInfo imageFileInfo, View view2, ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageFileInfo, view2, viewGroup, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || imageFileInfo == null || i <= 0 || i2 <= 0) {
            return;
        }
        ImageOperation g = t85.g(i, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fea);
        ((FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fcf)).setForeground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080e50));
        if (imageFileInfo.getImageType() == 0) {
            on c2 = this.c.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.c.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.b.getString(R.string.obfuscated_res_0x7f0f0534));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!dj.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g2 = zg.h().g(filePath, 20);
                tbImageView.setTag(g2);
                zg.h().k(filePath, 20, new e(this, viewGroup, g2), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            tbImageView.setTagStr("");
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.j = z;
        }
    }

    public void g(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, writeImagesInfo) == null) || writeImagesInfo == null) {
            return;
        }
        this.i = writeImagesInfo.getMaxImagesAllowed();
        int count = ListUtils.getCount(writeImagesInfo.getChosedFiles());
        this.a.clear();
        if (count > 0) {
            this.a.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.i || !this.g) {
            return;
        }
        if (this.j || (this.h && count > 0)) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath("FLAG_ADD_ICON");
            this.a.add(imageFileInfo);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.a.get(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
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
                view2 = this.f.inflate(R.layout.obfuscated_res_0x7f0d063c, (ViewGroup) null);
            }
            int k = (ej.k(this.b) - ((ej.f(this.b, R.dimen.tbds44) * 2) + (ej.f(this.b, R.dimen.tbds10) * 2))) / 3;
            if (view2.getLayoutParams() instanceof AbsListView.LayoutParams) {
                layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
                layoutParams.width = k;
                layoutParams.height = k;
            } else {
                layoutParams = new AbsListView.LayoutParams(k, k);
            }
            view2.setLayoutParams(layoutParams);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fea);
            tbImageView.setTagTextSize(ej.f(this.b, R.dimen.T_X10));
            tbImageView.setDrawBorder(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setAutoChangeStyle(true);
            tbImageView.setConrers(15);
            tbImageView.setRadiusById(R.string.J_X05);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090790);
            ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090789)).setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08081d, WebPManager.ResourceStateType.NORMAL));
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fcf);
            if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
                tbImageView.setVisibility(8);
                linearLayout.setVisibility(8);
                view2.setBackgroundDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809b3, WebPManager.ResourceStateType.NORMAL_PRESS));
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
                tbImageView.setTagStr(d(R.string.obfuscated_res_0x7f0f0534));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    tbImageView.setTagColor(this.b.getResources().getColor(R.color.CAM_X0101));
                } else {
                    tbImageView.setTagColor(this.b.getResources().getColor(R.color.CAM_X0101));
                }
                e(imageFileInfo, view2, viewGroup, k, k);
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
}
