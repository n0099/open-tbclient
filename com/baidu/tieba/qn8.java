package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class qn8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<EmotionImageData> a;
    public int b;
    public EmotionView.c c;
    public PbEmotionBar.i d;
    public Set<String> e;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
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
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn8 a;

        public a(qn8 qn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qn8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && (view2 instanceof EmotionView)) {
                EmotionView emotionView = (EmotionView) view2;
                this.a.d.b(emotionView.getData(), emotionView.getIsGif());
                TiebaStatic.log("c12176");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn8 a;

        public b(qn8 qn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qn8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null) {
                ArrayList arrayList = new ArrayList();
                if (!ListUtils.isEmpty(this.a.a)) {
                    for (EmotionImageData emotionImageData : this.a.a) {
                        if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            arrayList.add(emotionImageData.getThumbUrl());
                        }
                    }
                }
                this.a.d.a(null, null, arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn8 a;

        public c(qn8 qn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qn8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.a.e == null) {
                    return Boolean.TRUE;
                }
                for (String str : this.a.e) {
                    if (!TextUtils.isEmpty(str)) {
                        TbImageMemoryCache.o().l(str);
                    }
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EmotionView a;
        public TextView b;

        public d() {
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
    }

    public qn8() {
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
        this.e = new HashSet();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new c(this).execute(new Void[0]);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!ListUtils.isEmpty(this.a)) {
                return this.a.size() + 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void e(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    public void f(EmotionView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public void g(PbEmotionBar.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.d = iVar;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && this.b != i) {
            this.b = i;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                dVar = new d();
                view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d056f, (ViewGroup) null);
                EmotionView emotionView = (EmotionView) view3.findViewById(R.id.obfuscated_res_0x7f09116e);
                dVar.a = emotionView;
                emotionView.m0();
                dVar.a.setController(this.c);
                dVar.a.setOnClickListener(new a(this));
                TextView textView = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0925bf);
                dVar.b = textView;
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                dVar.b.setOnClickListener(new b(this));
                view3.setTag(dVar);
            } else {
                view3 = view2;
                dVar = (d) view2.getTag();
            }
            if (i >= 0) {
                if (i < this.a.size()) {
                    dVar.a.getLayoutParams().width = this.b;
                    dVar.a.getLayoutParams().height = this.b;
                    dVar.a.H();
                    dVar.a.setTag(R.id.obfuscated_res_0x7f09116e, null);
                    EmotionImageData emotionImageData = this.a.get(i);
                    if (emotionImageData != null) {
                        dVar.a.o0(emotionImageData);
                        if (this.e != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            Set<String> set = this.e;
                            set.add(emotionImageData.getThumbUrl() + dVar.a.getLoadProcType());
                        }
                    }
                    dVar.a.setVisibility(0);
                    dVar.b.setVisibility(8);
                } else if (i == this.a.size()) {
                    dVar.b.getLayoutParams().width = this.b;
                    dVar.b.getLayoutParams().height = this.b;
                    dVar.a.setVisibility(8);
                    dVar.b.setVisibility(0);
                }
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
