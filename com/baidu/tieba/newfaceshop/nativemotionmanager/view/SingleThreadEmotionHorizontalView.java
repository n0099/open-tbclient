package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.lr7;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.nr7;
import com.baidu.tieba.wj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;
    public TextView b;
    public ViewGroup c;
    public TextView d;
    public View e;
    public c f;
    public EmotionPackageData g;
    public TbPageContext h;
    public NewFaceGroupDownloadModel i;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleThreadEmotionHorizontalView a;

        public a(SingleThreadEmotionHorizontalView singleThreadEmotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = singleThreadEmotionHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.g == null) {
                return;
            }
            this.a.h.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.h.getPageActivity(), this.a.g.id, 0)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nr7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SingleThreadEmotionHorizontalView a;

        public b(SingleThreadEmotionHorizontalView singleThreadEmotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = singleThreadEmotionHorizontalView;
        }

        @Override // com.baidu.tieba.nr7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.M(this.a.h.getPageActivity(), R.string.obfuscated_res_0x7f0f050d);
                this.a.j();
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    ej.K(this.a.h.getPageActivity(), wj.a(R.string.obfuscated_res_0x7f0f0d49));
                } else if (i >= 100) {
                    ej.J(this.a.h.getPageActivity(), R.string.obfuscated_res_0x7f0f0508);
                }
            }
        }

        @Override // com.baidu.tieba.nr7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ej.M(this.a.h.getPageActivity(), R.string.obfuscated_res_0x7f0f0508);
                this.a.i();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public TbPageContext b;
        public int c;
        public boolean d;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;
            public TbImageView b;
            public TextView c;
            public View d;

            public a(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view2;
                view2.setEnabled(false);
                this.b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ac);
                this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908d0);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f090899);
                this.d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080be3);
                    this.b.K(singleEmotionData.thumbnail, 10, false);
                }
                if (i2 == 0) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                if (i2 == 7 && z) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
            }
        }

        public c(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
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
            this.c = 0;
            this.d = false;
            this.b = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.c = i;
            this.a.clear();
            if (list.size() > 8) {
                this.a.addAll(list.subList(0, 8));
                this.d = true;
            } else {
                this.a.addAll(list);
                this.d = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return null;
                }
                return list.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0256, (ViewGroup) null);
                    aVar = new a(view2);
                    view2.setTag(aVar);
                } else {
                    aVar = (a) view2.getTag();
                }
                aVar.a(this.a.get(i), this.c, this.d, i);
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleThreadEmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = tbPageContext;
        g();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.h.getPageActivity(), this.g.id, 0)));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ViewHelper.checkUpIsLogin(this.h.getPageActivity())) {
            if (lr7.o().q()) {
                ej.M(this.h.getPageActivity(), R.string.obfuscated_res_0x7f0f05f8);
                return;
            }
            EmotionPackageData emotionPackageData = this.g;
            if (emotionPackageData == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.i == null) {
                this.i = new NewFaceGroupDownloadModel();
            }
            this.d.setEnabled(false);
            this.i.z(Integer.toString(this.g.id), Boolean.TRUE, new b(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0265, this);
            this.c = viewGroup;
            this.a = (HListView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0908b6);
            this.b = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0908bd);
            this.e = this.c.findViewById(R.id.obfuscated_res_0x7f0908d1);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0908b1);
            this.d = textView;
            textView.setOnClickListener(this);
            setOnClickListener(this);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setOnItemClickListener(new a(this));
            this.a.setSelector(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081241));
            c cVar = new c(this.h);
            this.f = cVar;
            this.a.setAdapter((ListAdapter) cVar);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
                SkinManager.setBackgroundResource(this.d, R.drawable.bg_emotion_download, i);
            }
            View view2 = this.e;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i);
            }
        }
    }

    public final void i() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (textView = this.d) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0578);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        this.d.setBackgroundDrawable(null);
        this.d.setEnabled(false);
    }

    public final void j() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.d) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f056c);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.d, R.drawable.bg_emotion_download);
        this.d.setEnabled(true);
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.d) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0579);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        this.d.setBackgroundDrawable(null);
        this.d.setEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || this.g == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f0908b1 && view2.isShown()) {
            f();
        } else {
            e();
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionPackageData) == null) {
            this.g = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.f.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
            if (!TextUtils.isEmpty(this.g.forum_name)) {
                TextView textView = this.b;
                textView.setText(this.g.forum_name + "·" + this.g.name);
            } else {
                this.b.setText(this.g.name);
            }
            if (emotionPackageData.ishasdownload) {
                i();
                return;
            }
            int i = emotionPackageData.status;
            if (i == 1) {
                j();
            } else if (i == 5) {
                k();
            }
        }
    }
}
