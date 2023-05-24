package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d25;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.jj;
import com.baidu.tieba.ju8;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.ri;
import com.baidu.tieba.vt8;
import com.baidu.tieba.xt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;
    public TextView b;
    public View c;
    public TextView d;
    public View e;
    public ViewGroup f;
    public TextView g;
    public ImageView h;
    public View i;
    public View j;
    public f k;
    public EmotionPackageData l;
    public TbPageContext m;
    public NewFaceGroupDownloadModel n;
    public PermissionJudgePolicy o;

    /* loaded from: classes6.dex */
    public static class f extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public TbPageContext b;
        public int c;
        public boolean d;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes6.dex */
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
                this.b = (TbImageView) this.a.findViewById(R.id.emotion_img);
                this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909b3);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f09097b);
                this.d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.b.setDefaultResource(R.drawable.img_default_100);
                    this.b.N(singleEmotionData.thumbnail, 10, false);
                }
                if (i2 == 0) {
                    if (i == 0) {
                        this.c.setVisibility(8);
                    }
                    if (i == 1) {
                        this.c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f0805c4);
                    }
                    if (i == 2) {
                        this.c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f0805c6);
                    }
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

        public f(TbPageContext tbPageContext) {
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
            if ((interceptable != null && interceptable.invokeLI(1048576, this, list, i) != null) || ListUtils.isEmpty(list)) {
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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d028a, (ViewGroup) null);
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

    /* loaded from: classes6.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public a(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.l == null) {
                return;
            }
            this.a.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.m.getPageActivity(), this.a.l.id, 0)));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ EmotionManageHorizontalView b;

        public b(EmotionManageHorizontalView emotionManageHorizontalView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionManageHorizontalView;
            this.a = i;
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                d25Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921311, Integer.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public c(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                d25Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public d(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements xt8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public e(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // com.baidu.tieba.xt8
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ri.P(this.a.m.getPageActivity(), R.string.download_error);
                this.a.l();
            }
        }

        @Override // com.baidu.tieba.xt8
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    ri.N(this.a.m.getPageActivity(), jj.a(R.string.obfuscated_res_0x7f0f0eb3));
                } else if (i >= 100) {
                    ri.M(this.a.m.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // com.baidu.tieba.xt8
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ri.P(this.a.m.getPageActivity(), R.string.down_state_success);
                this.a.k();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionManageHorizontalView(TbPageContext tbPageContext) {
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
        this.m = tbPageContext;
        h();
    }

    public final void e(EmotionPackageData emotionPackageData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, emotionPackageData, i) != null) || emotionPackageData == null) {
            return;
        }
        if (emotionPackageData.isUndownloadheader) {
            this.c.setVisibility(0);
            this.d.setText(String.format(jj.a(R.string.obfuscated_res_0x7f0f060c), Integer.valueOf(i)));
        } else {
            this.c.setVisibility(8);
        }
        l();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.m.getPageActivity(), this.l.id, 0)));
        }
    }

    public HListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (HListView) invokeV.objValue;
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (textView = this.g) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0614);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
        this.g.setBackgroundDrawable(null);
        this.g.setEnabled(false);
    }

    public final void l() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (textView = this.g) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0608);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.g, R.drawable.bg_emotion_download);
        this.g.setEnabled(true);
    }

    public final void g() {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
            return;
        }
        if (vt8.o().q()) {
            ri.P(this.m.getPageActivity(), R.string.obfuscated_res_0x7f0f06b2);
            return;
        }
        Activity pageActivity = this.m.getPageActivity();
        if (this.o == null) {
            this.o = new PermissionJudgePolicy();
        }
        this.o.clearRequestPermissionList();
        this.o.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.o.startRequestPermission(pageActivity) && (emotionPackageData = this.l) != null && emotionPackageData.id >= 0) {
            if (this.n == null) {
                this.n = new NewFaceGroupDownloadModel();
            }
            this.g.setEnabled(false);
            this.n.U(Integer.toString(this.l.id), Boolean.TRUE, new e(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d028b, this);
            this.f = viewGroup;
            this.a = (HListView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090998);
            this.i = this.f.findViewById(R.id.obfuscated_res_0x7f09099b);
            this.b = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09099f);
            View findViewById = this.f.findViewById(R.id.obfuscated_res_0x7f09099c);
            this.c = findViewById;
            findViewById.setVisibility(8);
            this.d = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0909a1);
            View findViewById2 = this.f.findViewById(R.id.obfuscated_res_0x7f090999);
            this.e = findViewById2;
            findViewById2.setVisibility(8);
            TextView textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090993);
            this.g = textView;
            textView.setVisibility(8);
            this.g.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090991);
            this.h = imageView;
            imageView.setVisibility(8);
            this.h.setOnClickListener(this);
            View findViewById3 = this.f.findViewById(R.id.obfuscated_res_0x7f090992);
            this.j = findViewById3;
            findViewById3.setOnClickListener(this);
            setOnClickListener(this);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setOnItemClickListener(new a(this));
            this.a.setSelector(this.m.getResources().getDrawable(R.drawable.transparent_bg));
            f fVar = new f(this.m);
            this.k = fVar;
            this.a.setAdapter((ListAdapter) fVar);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            ViewGroup viewGroup = this.f;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i);
            }
            View view2 = this.i;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i);
            }
            View view3 = this.c;
            if (view3 != null) {
                SkinManager.setBackgroundColor(view3, R.color.CAM_X0204, i);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0107, i);
            }
            TextView textView3 = this.g;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0302, i);
                SkinManager.setBackgroundResource(this.g, R.drawable.bg_emotion_download, i);
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.obfuscated_res_0x7f0805c1, i);
            }
            View view4 = this.e;
            if (view4 != null) {
                SkinManager.setViewTextColor(view4, R.color.white_alpha70, i);
            }
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == null) {
            return;
        }
        String a2 = jj.a(R.string.obfuscated_res_0x7f0f0607);
        String a3 = jj.a(R.string.obfuscated_res_0x7f0f0606);
        String a4 = jj.a(R.string.obfuscated_res_0x7f0f0605);
        d25 d25Var = new d25(this.m.getPageActivity());
        d25Var.setMessage(a2);
        d25Var.setPositiveButton(a3, new b(this, i));
        d25Var.setNegativeButton(a4, new c(this));
        d25Var.setOnCalcelListener(new d(this));
        d25Var.create(this.m).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || this.l == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f090993 && view2.isShown()) {
            g();
        } else if ((view2.getId() == R.id.obfuscated_res_0x7f090992 || view2.getId() == R.id.obfuscated_res_0x7f090991) && this.h.isShown()) {
            EmotionPackageData emotionPackageData = this.l;
            if (emotionPackageData != null) {
                j(emotionPackageData.id);
            }
        } else {
            f();
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, emotionPackageData, i) == null) {
            this.l = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.k.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
            this.b.setText(this.l.name);
            if (emotionPackageData.ishasdownload) {
                this.e.setVisibility(8);
                this.g.setVisibility(8);
                if (ju8.b().a()) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
            } else {
                this.h.setVisibility(8);
                this.g.setVisibility(0);
                this.e.setVisibility(0);
            }
            e(emotionPackageData, i);
        }
    }
}
