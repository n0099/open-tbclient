package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.d.f.q.h;
import c.a.s0.s.s.a;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f46274e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46275f;

    /* renamed from: g  reason: collision with root package name */
    public View f46276g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46277h;

    /* renamed from: i  reason: collision with root package name */
    public View f46278i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f46279j;
    public TextView k;
    public ImageView l;
    public View m;
    public View n;
    public f o;
    public EmotionPackageData p;
    public TbPageContext q;
    public NewFaceGroupDownloadModel r;
    public PermissionJudgePolicy s;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.a.p == null) {
                return;
            }
            this.a.q.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.q.getPageActivity(), this.a.p.id, 0)));
        }
    }

    /* loaded from: classes12.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f46281f;

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
            this.f46281f = emotionManageHorizontalView;
            this.f46280e = i2;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921311, Integer.valueOf(this.f46280e)));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f46282e;

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
            this.f46282e = emotionManageHorizontalView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f46283e;

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
            this.f46283e = emotionManageHorizontalView;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements c.a.t0.o2.e.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // c.a.t0.o2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.M(this.a.q.getPageActivity(), R.string.download_error);
                this.a.k();
            }
        }

        @Override // c.a.t0.o2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    n.K(this.a.q.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    n.J(this.a.q.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // c.a.t0.o2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                n.M(this.a.q.getPageActivity(), R.string.down_state_success);
                this.a.j();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class f extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f46284e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f46285f;

        /* renamed from: g  reason: collision with root package name */
        public int f46286g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f46287h;

        /* loaded from: classes12.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f46288b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f46289c;

            /* renamed from: d  reason: collision with root package name */
            public View f46290d;

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
                this.a = view;
                view.setEnabled(false);
                this.f46288b = (TbImageView) this.a.findViewById(R.id.emotion_img);
                this.f46289c = (TextView) this.a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.a.findViewById(R.id.emotion_cover_view);
                this.f46290d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i2, boolean z, int i3) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f46288b.setDefaultResource(R.drawable.img_default_100);
                    this.f46288b.startLoad(singleEmotionData.thumbnail, 10, false);
                }
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.f46289c.setVisibility(8);
                    }
                    if (i2 == 1) {
                        this.f46289c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f46289c, R.drawable.emotion_pic_mine);
                    }
                    if (i2 == 2) {
                        this.f46289c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f46289c, R.drawable.emotion_pic_single_bar);
                    }
                } else {
                    this.f46289c.setVisibility(8);
                }
                if (i3 == 7 && z) {
                    this.f46290d.setVisibility(0);
                } else {
                    this.f46290d.setVisibility(8);
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
            this.f46284e = new ArrayList();
            this.f46286g = 0;
            this.f46287h = false;
            this.f46285f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f46286g = i2;
            this.f46284e.clear();
            if (list.size() > 8) {
                this.f46284e.addAll(list.subList(0, 8));
                this.f46287h = true;
            } else {
                this.f46284e.addAll(list);
                this.f46287h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f46284e;
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
                List<EmotionPackageData.SingleEmotionData> list = this.f46284e;
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
                    view = LayoutInflater.from(this.f46285f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.f46284e.get(i2), this.f46286g, this.f46287h, i2);
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
            this.f46276g.setVisibility(0);
            this.f46277h.setText(String.format(h.a(R.string.emotion_manage_net_number), Integer.valueOf(i2)));
        } else {
            this.f46276g.setVisibility(8);
        }
        k();
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
            if (c.a.t0.o2.d.m().o()) {
                n.M(this.q.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            Activity pageActivity = this.q.getPageActivity();
            if (this.s == null) {
                this.s = new PermissionJudgePolicy();
            }
            this.s.clearRequestPermissionList();
            this.s.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46274e : (HListView) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_manage_grid_item_layout, this);
            this.f46279j = viewGroup;
            this.f46274e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
            this.m = this.f46279j.findViewById(R.id.emotion_manage_item_line);
            this.f46275f = (TextView) this.f46279j.findViewById(R.id.emotion_manage_title);
            View findViewById = this.f46279j.findViewById(R.id.emotion_manage_item_undownload_header);
            this.f46276g = findViewById;
            findViewById.setVisibility(8);
            this.f46277h = (TextView) this.f46279j.findViewById(R.id.emotion_manage_undownload_total_title);
            View findViewById2 = this.f46279j.findViewById(R.id.emotion_manage_item_grid_cover);
            this.f46278i = findViewById2;
            findViewById2.setVisibility(8);
            TextView textView = (TextView) this.f46279j.findViewById(R.id.emotion_manage_download);
            this.k = textView;
            textView.setVisibility(8);
            this.k.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f46279j.findViewById(R.id.emotion_manage_del);
            this.l = imageView;
            imageView.setVisibility(8);
            this.l.setOnClickListener(this);
            View findViewById3 = this.f46279j.findViewById(R.id.emotion_manage_del_container);
            this.n = findViewById3;
            findViewById3.setOnClickListener(this);
            setOnClickListener(this);
            this.f46274e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f46274e.setOnItemClickListener(new a(this));
            this.f46274e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
            f fVar = new f(this.q);
            this.o = fVar;
            this.f46274e.setAdapter((ListAdapter) fVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.q == null) {
            return;
        }
        String a2 = h.a(R.string.emotion_manage_dialog_title);
        String a3 = h.a(R.string.emotion_manage_dialog_ok);
        String a4 = h.a(R.string.emotion_manage_dialog_cancel);
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.q.getPageActivity());
        aVar.setMessage(a2);
        aVar.setPositiveButton(a3, new b(this, i2));
        aVar.setNegativeButton(a4, new c(this));
        aVar.setOnCalcelListener(new d(this));
        aVar.create(this.q).show();
    }

    public final void j() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.k) == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        this.k.setBackgroundDrawable(null);
        this.k.setEnabled(false);
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (textView = this.k) == null) {
            return;
        }
        textView.setText(R.string.emotion_manage_download);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.k, R.drawable.bg_emotion_download);
        this.k.setEnabled(true);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ViewGroup viewGroup = this.f46279j;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i2);
            }
            View view = this.m;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
            }
            View view2 = this.f46276g;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i2);
            }
            TextView textView = this.f46275f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i2);
            }
            TextView textView2 = this.f46277h;
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
            View view3 = this.f46278i;
            if (view3 != null) {
                SkinManager.setViewTextColor(view3, R.color.white_alpha70, i2);
            }
        }
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
                i(emotionPackageData.id);
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
            this.f46275f.setText(this.p.name);
            if (emotionPackageData.ishasdownload) {
                this.f46278i.setVisibility(8);
                this.k.setVisibility(8);
                if (c.a.t0.o2.h.a.b().a()) {
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
            } else {
                this.l.setVisibility(8);
                this.k.setVisibility(0);
                this.f46278i.setVisibility(0);
            }
            e(emotionPackageData, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionManageHorizontalView(TbPageContext tbPageContext, AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionManageHorizontalView(TbPageContext tbPageContext, AttributeSet attributeSet, int i2) {
        super(tbPageContext.getPageActivity(), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        h();
    }
}
