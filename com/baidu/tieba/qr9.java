package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.newfaceshop.facemake.PickEmotionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class qr9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<EmotionImageData> b;
    public Set<String> c;
    public LinkedHashMap<String, EmotionImageData> d;
    public or9 e;
    public int f;
    public int g;
    public int h;
    public final Runnable i;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PickEmotionView a;
        public final /* synthetic */ qr9 b;

        public a(qr9 qr9Var, PickEmotionView pickEmotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr9Var, pickEmotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qr9Var;
            this.a = pickEmotionView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tag = view2.getTag(view2.getId())) != null && (tag instanceof EmotionImageData)) {
                EmotionImageData emotionImageData = (EmotionImageData) tag;
                if (this.b.d.containsKey(emotionImageData.getPicUrl())) {
                    this.b.d.remove(emotionImageData.getPicUrl());
                    this.a.setChoosed(false);
                    if (this.b.e != null) {
                        this.b.e.k();
                    }
                } else if (this.b.e != null) {
                    if (this.b.e.o()) {
                        this.b.d.put(emotionImageData.getPicUrl(), emotionImageData);
                        this.a.setChoosed(true);
                        this.b.e.y();
                        return;
                    }
                    BdToast.makeText(this.b.a, this.b.a.getText(R.string.obfuscated_res_0x7f0f070c)).show();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr9 a;

        public b(qr9 qr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qr9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.c == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it = this.a.d.entrySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((EmotionImageData) ((Map.Entry) it.next()).getValue()).getThumbUrl() + this.a.h);
            }
            for (String str : this.a.c) {
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    TbImageMemoryCache.w().r(str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PickEmotionView a;
        public PickEmotionView b;
        public PickEmotionView c;
        public PickEmotionView d;
        public final /* synthetic */ qr9 e;

        public c(qr9 qr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qr9Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.j(this.a);
            this.e.j(this.b);
            this.e.j(this.c);
            this.e.j(this.d);
        }
    }

    public qr9(List<EmotionImageData> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new b(this);
        this.a = BdBaseApplication.getInst().getApp();
        this.b = list;
        this.h = i;
        this.c = new HashSet();
        this.d = new LinkedHashMap<>();
        this.g = BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070361);
        this.f = (int) (((BdUtilHelper.getEquipmentWidth(this.a) - BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070253)) - (this.g * 4)) * 0.333d);
    }

    public void g(Map<String, EmotionImageData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            this.d.putAll(map);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<EmotionImageData> list = this.b;
            if (list != null && i <= list.size() - 1) {
                return this.b.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    public final void j(PickEmotionView pickEmotionView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, pickEmotionView) != null) || pickEmotionView == null) {
            return;
        }
        pickEmotionView.getEmotionView().setOnClickListener(new a(this, pickEmotionView));
    }

    public void l(or9 or9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, or9Var) == null) {
            this.e = or9Var;
        }
    }

    public final void m(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pickEmotionView, emotionImageData) == null) {
            if (this.d.containsKey(emotionImageData.getPicUrl())) {
                pickEmotionView.setChoosed(true);
            } else {
                pickEmotionView.setChoosed(false);
            }
        }
    }

    public final void n(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view2, i) == null) && view2 != null && view2.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            view2.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<EmotionImageData> list = this.b;
            if (list != null) {
                if (list.size() % 4 == 0) {
                    return this.b.size() / 4;
                }
                return (this.b.size() / 4) + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                c cVar2 = new c(this);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ea, (ViewGroup) null);
                cVar2.a = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f090a42);
                cVar2.b = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f090a43);
                cVar2.c = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f090a44);
                cVar2.d = (PickEmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f090a45);
                cVar2.a();
                n(cVar2.b, this.f);
                n(cVar2.c, this.f);
                n(cVar2.d, this.f);
                inflate.setTag(cVar2);
                cVar = cVar2;
                view2 = inflate;
            } else {
                cVar = (c) view2.getTag();
            }
            int i2 = i * 4;
            int i3 = i2 + 4;
            int min = Math.min(i3, this.b.size() - 1);
            for (int i4 = i2; i4 < i3; i4++) {
                if (i4 <= min) {
                    emotionImageData = this.b.get(i4);
                } else {
                    emotionImageData = null;
                }
                int i5 = i4 - i2;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                h(cVar.d, emotionImageData);
                            }
                        } else {
                            h(cVar.c, emotionImageData);
                        }
                    } else {
                        h(cVar.b, emotionImageData);
                    }
                } else {
                    h(cVar.a, emotionImageData);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(PickEmotionView pickEmotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, pickEmotionView, emotionImageData) != null) || pickEmotionView == null) {
            return;
        }
        if (emotionImageData == null) {
            pickEmotionView.setVisibility(4);
            return;
        }
        pickEmotionView.getEmotionView().setTag(pickEmotionView.getEmotionView().getId(), emotionImageData);
        pickEmotionView.setData(emotionImageData, this.h);
        m(pickEmotionView, emotionImageData);
        if (this.c != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            Set<String> set = this.c;
            set.add(emotionImageData.getThumbUrl() + pickEmotionView.getLoadType());
        }
    }

    public LinkedHashMap<String, EmotionImageData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            lr6.a(this.i, "releaseImageCache", 3);
        }
    }
}
