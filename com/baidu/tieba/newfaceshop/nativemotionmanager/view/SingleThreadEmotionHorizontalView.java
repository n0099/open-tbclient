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
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.e.q.h;
import d.a.p0.c2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SingleThreadEmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f18995e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18996f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f18997g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18998h;

    /* renamed from: i  reason: collision with root package name */
    public View f18999i;
    public c j;
    public EmotionPackageData k;
    public TbPageContext l;
    public NewFaceGroupDownloadModel m;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleThreadEmotionHorizontalView f19000a;

        public a(SingleThreadEmotionHorizontalView singleThreadEmotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19000a = singleThreadEmotionHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19000a.k == null) {
                return;
            }
            this.f19000a.l.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f19000a.l.getPageActivity(), this.f19000a.k.id, 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.p0.c2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SingleThreadEmotionHorizontalView f19001a;

        public b(SingleThreadEmotionHorizontalView singleThreadEmotionHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleThreadEmotionHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19001a = singleThreadEmotionHorizontalView;
        }

        @Override // d.a.p0.c2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.L(this.f19001a.l.getPageActivity(), R.string.download_error);
                this.f19001a.j();
            }
        }

        @Override // d.a.p0.c2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 > 0 && i2 < 100) {
                    l.J(this.f19001a.l.getPageActivity(), h.a(R.string.package_downloading_progress));
                } else if (i2 >= 100) {
                    l.I(this.f19001a.l.getPageActivity(), R.string.down_state_success);
                }
            }
        }

        @Override // d.a.p0.c2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                l.L(this.f19001a.l.getPageActivity(), R.string.down_state_success);
                this.f19001a.i();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f19002e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f19003f;

        /* renamed from: g  reason: collision with root package name */
        public int f19004g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19005h;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f19006a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f19007b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f19008c;

            /* renamed from: d  reason: collision with root package name */
            public View f19009d;

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
                this.f19006a = view;
                view.setEnabled(false);
                this.f19007b = (TbImageView) this.f19006a.findViewById(R.id.emotion_img);
                this.f19008c = (TextView) this.f19006a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f19006a.findViewById(R.id.emotion_cover_view);
                this.f19009d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i2, boolean z, int i3) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f19007b.setDefaultResource(R.drawable.img_default_100);
                    this.f19007b.M(singleEmotionData.thumbnail, 10, false);
                }
                if (i3 == 0) {
                    this.f19008c.setVisibility(0);
                } else {
                    this.f19008c.setVisibility(8);
                }
                if (i3 == 7 && z) {
                    this.f19009d.setVisibility(0);
                } else {
                    this.f19009d.setVisibility(8);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19002e = new ArrayList();
            this.f19004g = 0;
            this.f19005h = false;
            this.f19003f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f19004g = i2;
            this.f19002e.clear();
            if (list.size() > 8) {
                this.f19002e.addAll(list.subList(0, 8));
                this.f19005h = true;
            } else {
                this.f19002e.addAll(list);
                this.f19005h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f19002e;
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
                List<EmotionPackageData.SingleEmotionData> list = this.f19002e;
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
                    view = LayoutInflater.from(this.f19003f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.f19002e.get(i2), this.f19004g, this.f19005h, i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = tbPageContext;
        g();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.l.getPageActivity(), this.k.id, 0)));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ViewHelper.checkUpIsLogin(this.l.getPageActivity())) {
            if (d.m().o()) {
                l.L(this.l.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            EmotionPackageData emotionPackageData = this.k;
            if (emotionPackageData == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.m == null) {
                this.m = new NewFaceGroupDownloadModel();
            }
            this.f18998h.setEnabled(false);
            this.m.w(Integer.toString(this.k.id), Boolean.TRUE, new b(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.emotion_single_thread_grid_item_layout, this);
            this.f18997g = viewGroup;
            this.f18995e = (HListView) viewGroup.findViewById(R.id.emotion_manage_item_grid);
            this.f18996f = (TextView) this.f18997g.findViewById(R.id.emotion_manage_title);
            this.f18999i = this.f18997g.findViewById(R.id.emotion_single_line);
            TextView textView = (TextView) this.f18997g.findViewById(R.id.emotion_manage_download);
            this.f18998h = textView;
            textView.setOnClickListener(this);
            setOnClickListener(this);
            this.f18995e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f18995e.setOnItemClickListener(new a(this));
            this.f18995e.setSelector(this.l.getResources().getDrawable(R.drawable.transparent_bg));
            c cVar = new c(this.l);
            this.j = cVar;
            this.f18995e.setAdapter((ListAdapter) cVar);
            h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            ViewGroup viewGroup = this.f18997g;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i2);
            }
            TextView textView = this.f18996f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i2);
            }
            TextView textView2 = this.f18998h;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i2);
                SkinManager.setBackgroundResource(this.f18998h, R.drawable.bg_emotion_download, i2);
            }
            View view = this.f18999i;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
            }
        }
    }

    public final void i() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (textView = this.f18998h) == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_downloaded);
        SkinManager.setViewTextColor(this.f18998h, R.color.CAM_X0109);
        this.f18998h.setBackgroundDrawable(null);
        this.f18998h.setEnabled(false);
    }

    public final void j() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.f18998h) == null) {
            return;
        }
        textView.setText(R.string.emotion_manage_download);
        SkinManager.setViewTextColor(this.f18998h, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f18998h, R.drawable.bg_emotion_download);
        this.f18998h.setEnabled(true);
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.f18998h) == null) {
            return;
        }
        textView.setText(R.string.emotion_single_thread_vote);
        SkinManager.setViewTextColor(this.f18998h, R.color.CAM_X0109);
        this.f18998h.setBackgroundDrawable(null);
        this.f18998h.setEnabled(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || this.k == null) {
            return;
        }
        if (view.getId() == R.id.emotion_manage_download && view.isShown()) {
            f();
        } else {
            e();
        }
    }

    public void setData(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionPackageData) == null) {
            this.k = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.j.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
            if (!TextUtils.isEmpty(this.k.forum_name)) {
                TextView textView = this.f18996f;
                textView.setText(this.k.forum_name + "·" + this.k.name);
            } else {
                this.f18996f.setText(this.k.name);
            }
            if (emotionPackageData.ishasdownload) {
                i();
                return;
            }
            int i2 = emotionPackageData.status;
            if (i2 == 1) {
                j();
            } else if (i2 == 5) {
                k();
            }
        }
    }
}
