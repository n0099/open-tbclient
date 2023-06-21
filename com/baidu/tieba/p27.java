package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class p27 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<tw4> a;
    public String b;
    public Context c;
    public em5 d;
    public int e;
    public int f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a implements bm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public a(p27 p27Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var, viewGroup};
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

        @Override // com.baidu.tieba.bm5
        public void a(hn hnVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, hnVar, str, z) == null) && (headImageView = (HeadImageView) this.a.findViewWithTag(str)) != null && hnVar != null) {
                headImageView.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public ImageView c;

        public b(p27 p27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(p27 p27Var, a aVar) {
            this(p27Var);
        }
    }

    public p27(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context;
        this.d = new em5();
        this.f = (int) this.c.getResources().getDimension(R.dimen.obfuscated_res_0x7f07035e);
        this.e = wi.l(this.c) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public tw4 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<tw4> list = this.a;
            if (list != null && i >= 0 && i < list.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (tw4) invokeI.objValue;
    }

    public void b(List<tw4> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<tw4> list = this.a;
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
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 != null) {
                bVar = (b) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0205, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091171);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091183);
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09115e);
                bVar.c = imageView;
                SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
                view2.setTag(bVar);
            }
            bVar.a.setTag(null);
            bVar.a.setDefaultResource(R.drawable.pic_image_h_not);
            bVar.a.N(null, 12, false);
            bVar.a.invalidate();
            tw4 item = getItem(i);
            if (item != null) {
                if (!TextUtils.isEmpty(item.g())) {
                    item.g();
                    String v = wi.v(bVar.b.getPaint(), item.g(), this.e);
                    bVar.b.setText(v + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    bVar.b.setText("");
                }
                String b2 = item.b();
                if (!TextUtils.isEmpty(b2) && b2.equals(this.b)) {
                    bVar.c.setVisibility(0);
                } else {
                    bVar.c.setVisibility(8);
                }
                ImageFileInfo e = item.e();
                if (e != null) {
                    e.clearPageActions();
                    int i2 = this.f;
                    e.addPageAction(nm5.g(i2, i2));
                    hn c = this.d.c(e, false);
                    bVar.a.setTag(e.toCachedKey(false));
                    if (c != null) {
                        bVar.a.invalidate();
                    } else {
                        this.d.e(e, new a(this, viewGroup), false, false);
                    }
                }
            } else {
                bVar.b.setText("");
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
