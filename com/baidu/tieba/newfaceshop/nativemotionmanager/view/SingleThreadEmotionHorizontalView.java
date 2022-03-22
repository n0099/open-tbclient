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
import c.a.d.f.p.n;
import c.a.d.f.q.h;
import c.a.p0.r2.d;
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
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
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

    /* renamed from: b  reason: collision with root package name */
    public TextView f34727b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34728c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34729d;

    /* renamed from: e  reason: collision with root package name */
    public View f34730e;

    /* renamed from: f  reason: collision with root package name */
    public c f34731f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionPackageData f34732g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f34733h;
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
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.f34732g == null) {
                return;
            }
            this.a.f34733h.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.f34733h.getPageActivity(), this.a.f34732g.id, 0)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.r2.e.b {
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

        @Override // c.a.p0.r2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.M(this.a.f34733h.getPageActivity(), R.string.obfuscated_res_0x7f0f04e7);
                this.a.j();
            }
        }

        @Override // c.a.p0.r2.e.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    n.K(this.a.f34733h.getPageActivity(), h.a(R.string.obfuscated_res_0x7f0f0d00));
                } else if (i >= 100) {
                    n.J(this.a.f34733h.getPageActivity(), R.string.obfuscated_res_0x7f0f04e2);
                }
            }
        }

        @Override // c.a.p0.r2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                n.M(this.a.f34733h.getPageActivity(), R.string.obfuscated_res_0x7f0f04e2);
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

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f34734b;

        /* renamed from: c  reason: collision with root package name */
        public int f34735c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34736d;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f34737b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f34738c;

            /* renamed from: d  reason: collision with root package name */
            public View f34739d;

            public a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view;
                view.setEnabled(false);
                this.f34737b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090887);
                this.f34738c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ab);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f090874);
                this.f34739d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f34737b.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
                    this.f34737b.J(singleEmotionData.thumbnail, 10, false);
                }
                if (i2 == 0) {
                    this.f34738c.setVisibility(0);
                } else {
                    this.f34738c.setVisibility(8);
                }
                if (i2 == 7 && z) {
                    this.f34739d.setVisibility(0);
                } else {
                    this.f34739d.setVisibility(8);
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
            this.f34735c = 0;
            this.f34736d = false;
            this.f34734b = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f34735c = i;
            this.a.clear();
            if (list.size() > 8) {
                this.a.addAll(list.subList(0, 8));
                this.f34736d = true;
            } else {
                this.a.addAll(list);
                this.f34736d = false;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f34734b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d025e, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.a.get(i), this.f34735c, this.f34736d, i);
                return view;
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
        this.f34733h = tbPageContext;
        g();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34733h.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f34733h.getPageActivity(), this.f34732g.id, 0)));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ViewHelper.checkUpIsLogin(this.f34733h.getPageActivity())) {
            if (d.m().o()) {
                n.M(this.f34733h.getPageActivity(), R.string.obfuscated_res_0x7f0f05ce);
                return;
            }
            EmotionPackageData emotionPackageData = this.f34732g;
            if (emotionPackageData == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.i == null) {
                this.i = new NewFaceGroupDownloadModel();
            }
            this.f34729d.setEnabled(false);
            this.i.y(Integer.toString(this.f34732g.id), Boolean.TRUE, new b(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d026d, this);
            this.f34728c = viewGroup;
            this.a = (HListView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090891);
            this.f34727b = (TextView) this.f34728c.findViewById(R.id.obfuscated_res_0x7f090898);
            this.f34730e = this.f34728c.findViewById(R.id.obfuscated_res_0x7f0908ac);
            TextView textView = (TextView) this.f34728c.findViewById(R.id.obfuscated_res_0x7f09088c);
            this.f34729d = textView;
            textView.setOnClickListener(this);
            setOnClickListener(this);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setOnItemClickListener(new a(this));
            this.a.setSelector(this.f34733h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081200));
            c cVar = new c(this.f34733h);
            this.f34731f = cVar;
            this.a.setAdapter((ListAdapter) cVar);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ViewGroup viewGroup = this.f34728c;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i);
            }
            TextView textView = this.f34727b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i);
            }
            TextView textView2 = this.f34729d;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
                SkinManager.setBackgroundResource(this.f34729d, R.drawable.bg_emotion_download, i);
            }
            View view = this.f34730e;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
            }
        }
    }

    public final void i() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (textView = this.f34729d) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f054f);
        SkinManager.setViewTextColor(this.f34729d, (int) R.color.CAM_X0109);
        this.f34729d.setBackgroundDrawable(null);
        this.f34729d.setEnabled(false);
    }

    public final void j() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.f34729d) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0543);
        SkinManager.setViewTextColor(this.f34729d, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f34729d, R.drawable.bg_emotion_download);
        this.f34729d.setEnabled(true);
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.f34729d) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0550);
        SkinManager.setViewTextColor(this.f34729d, (int) R.color.CAM_X0109);
        this.f34729d.setBackgroundDrawable(null);
        this.f34729d.setEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || this.f34732g == null) {
            return;
        }
        if (view.getId() == R.id.obfuscated_res_0x7f09088c && view.isShown()) {
            f();
        } else {
            e();
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionPackageData) == null) {
            this.f34732g = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.f34731f.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
            if (!TextUtils.isEmpty(this.f34732g.forum_name)) {
                TextView textView = this.f34727b;
                textView.setText(this.f34732g.forum_name + "·" + this.f34732g.name);
            } else {
                this.f34727b.setText(this.f34732g.name);
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
