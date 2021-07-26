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
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.e.p.l;
import d.a.d.e.q.h;
import d.a.p0.s.s.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f19061e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19062f;

    /* renamed from: g  reason: collision with root package name */
    public View f19063g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19064h;

    /* renamed from: i  reason: collision with root package name */
    public View f19065i;
    public ViewGroup j;
    public TextView k;
    public ImageView l;
    public View m;
    public View n;
    public f o;
    public EmotionPackageData p;
    public TbPageContext q;
    public NewFaceGroupDownloadModel r;
    public PermissionJudgePolicy s;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f19066a;

        public a(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19066a = emotionManageHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19066a.p == null) {
                return;
            }
            this.f19066a.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f19066a.q.getPageActivity(), this.f19066a.p.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f19068f;

        public b(EmotionManageHorizontalView emotionManageHorizontalView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19068f = emotionManageHorizontalView;
            this.f19067e = i2;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921311, Integer.valueOf(this.f19067e)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f19069e;

        public c(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19069e = emotionManageHorizontalView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f19070e;

        public d(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19070e = emotionManageHorizontalView;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.q0.c2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f19071a;

        public e(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19071a = emotionManageHorizontalView;
        }

        @Override // d.a.q0.c2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f19071a.q.getPageActivity(), R.string.download_error);
                this.f19071a.l();
            }
        }

        @Override // d.a.q0.c2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f19071a.q.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f19071a.q.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // d.a.q0.c2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f19071a.q.getPageActivity(), R.string.down_state_success);
                this.f19071a.k();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f19072e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f19073f;

        /* renamed from: g  reason: collision with root package name */
        public int f19074g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19075h;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f19076a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f19077b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f19078c;

            /* renamed from: d  reason: collision with root package name */
            public View f19079d;

            public a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19076a = view;
                view.setEnabled(false);
                this.f19077b = (TbImageView) this.f19076a.findViewById(R.id.emotion_img);
                this.f19078c = (TextView) this.f19076a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f19076a.findViewById(R.id.emotion_cover_view);
                this.f19079d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i2, boolean z, int i3) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f19077b.setDefaultResource(R.drawable.img_default_100);
                    this.f19077b.M(singleEmotionData.thumbnail, 10, false);
                }
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.f19078c.setVisibility(8);
                    }
                    if (i2 == 1) {
                        this.f19078c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f19078c, R.drawable.emotion_pic_mine);
                    }
                    if (i2 == 2) {
                        this.f19078c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f19078c, R.drawable.emotion_pic_single_bar);
                    }
                } else {
                    this.f19078c.setVisibility(8);
                }
                if (i3 == 7 && z) {
                    this.f19079d.setVisibility(0);
                } else {
                    this.f19079d.setVisibility(8);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19072e = new ArrayList();
            this.f19074g = 0;
            this.f19075h = false;
            this.f19073f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f19074g = i2;
            this.f19072e.clear();
            if (list.size() > 8) {
                this.f19072e.addAll(list.subList(0, 8));
                this.f19075h = true;
            } else {
                this.f19072e.addAll(list);
                this.f19075h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f19072e;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f19072e;
                if (list == null) {
                    return null;
                }
                return list.get(i2);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f19073f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.f19072e.get(i2), this.f19074g, this.f19075h, i2);
                return view;
            }
            return (View) invokeILL.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = tbPageContext;
        h();
    }

    public final void e(EmotionPackageData emotionPackageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, emotionPackageData, i2) == null) || emotionPackageData == null) {
            return;
        }
        if (emotionPackageData.isUndownloadheader) {
            this.f19063g.setVisibility(0);
            this.f19064h.setText(String.format(h.a(R.string.emotion_manage_net_number), Integer.valueOf(i2)));
        } else {
            this.f19063g.setVisibility(8);
        }
        l();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.q.getPageActivity(), this.p.id, 0)));
        }
    }

    public final void g() {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(this.q.getPageActivity())) {
            if (d.a.q0.c2.d.m().o()) {
                l.L(this.q.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.q.getPageActivity();
            if (this.s == null) {
                this.s = new PermissionJudgePolicy();
            }
            this.s.clearRequestPermissionList();
            this.s.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.s.startRequestPermission(pageActivity) || (emotionPackageData = this.p) == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.r == null) {
                this.r = new NewFaceGroupDownloadModel();
            }
            this.k.setEnabled(false);
            this.r.w(Integer.toString(this.p.id), Boolean.TRUE, new e(this));
        }
    }

    public HListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19061e : (HListView) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_manage_grid_item_layout, this);
            this.j = viewGroup;
            this.f19061e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
            this.m = this.j.findViewById(R.id.emotion_manage_item_line);
            this.f19062f = (TextView) this.j.findViewById(R.id.emotion_manage_title);
            View findViewById = this.j.findViewById(R.id.emotion_manage_item_undownload_header);
            this.f19063g = findViewById;
            findViewById.setVisibility(8);
            this.f19064h = (TextView) this.j.findViewById(R.id.emotion_manage_undownload_total_title);
            View findViewById2 = this.j.findViewById(R.id.emotion_manage_item_grid_cover);
            this.f19065i = findViewById2;
            findViewById2.setVisibility(8);
            TextView textView = (TextView) this.j.findViewById(R.id.emotion_manage_download);
            this.k = textView;
            textView.setVisibility(8);
            this.k.setOnClickListener(this);
            ImageView imageView = (ImageView) this.j.findViewById(R.id.emotion_manage_del);
            this.l = imageView;
            imageView.setVisibility(8);
            this.l.setOnClickListener(this);
            View findViewById3 = this.j.findViewById(R.id.emotion_manage_del_container);
            this.n = findViewById3;
            findViewById3.setOnClickListener(this);
            setOnClickListener(this);
            this.f19061e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f19061e.setOnItemClickListener(new a(this));
            this.f19061e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
            f fVar = new f(this.q);
            this.o = fVar;
            this.f19061e.setAdapter((ListAdapter) fVar);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            ViewGroup viewGroup = this.j;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i2);
            }
            View view = this.m;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
            }
            View view2 = this.f19063g;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i2);
            }
            TextView textView = this.f19062f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i2);
            }
            TextView textView2 = this.f19064h;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0107, i2);
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0302, i2);
                SkinManager.setBackgroundResource(this.k, R.drawable.bg_emotion_download, i2);
            }
            ImageView imageView = this.l;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_manage_del_selector, i2);
            }
            View view3 = this.f19065i;
            if (view3 != null) {
                SkinManager.setViewTextColor(view3, R.color.white_alpha70, i2);
            }
        }
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.q == null) {
            return;
        }
        String a2 = h.a(R.string.emotion_manage_dialog_title);
        String a3 = h.a(R.string.emotion_manage_dialog_ok);
        String a4 = h.a(R.string.emotion_manage_dialog_cancel);
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.q.getPageActivity());
        aVar.setMessage(a2);
        aVar.setPositiveButton(a3, new b(this, i2));
        aVar.setNegativeButton(a4, new c(this));
        aVar.setOnCalcelListener(new d(this));
        aVar.create(this.q).show();
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (textView = this.k) == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        this.k.setBackgroundDrawable(null);
        this.k.setEnabled(false);
    }

    public final void l() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (textView = this.k) == null) {
            return;
        }
        textView.setText(R.string.emotion_manage_download);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.k, R.drawable.bg_emotion_download);
        this.k.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || this.p == null) {
            return;
        }
        if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
            g();
        } else if ((view.getId() == R.id.emotion_manage_del_container || view.getId() == R.id.emotion_manage_del) && this.l.isShown()) {
            EmotionPackageData emotionPackageData = this.p;
            if (emotionPackageData != null) {
                j(emotionPackageData.id);
            }
        } else {
            f();
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, emotionPackageData, i2) == null) {
            this.p = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.o.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
            this.f19062f.setText(this.p.name);
            if (emotionPackageData.ishasdownload) {
                this.f19065i.setVisibility(8);
                this.k.setVisibility(8);
                if (d.a.q0.c2.h.a.b().a()) {
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
            } else {
                this.l.setVisibility(8);
                this.k.setVisibility(0);
                this.f19065i.setVisibility(0);
            }
            e(emotionPackageData, i2);
        }
    }
}
