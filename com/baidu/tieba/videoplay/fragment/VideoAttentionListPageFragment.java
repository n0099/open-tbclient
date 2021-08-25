package com.baidu.tieba.videoplay.fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.adapter.VideoAttentionPageRecomendListAdapter;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010\u000bJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0015R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u00108¨\u0006="}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionListPageFragment;", "Lc/a/q0/y3/i/a/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/video/VideoItemModel;", "getCurrentData", "()Lcom/baidu/tieba/video/VideoItemModel;", "", "getFragmentIndex", "()I", "", "initRecyclerView", "()V", "", "isOnViewTop", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "position", "scrollToPosition", "index", "setFragmentIndex", "Lcom/baidu/tieba/videoplay/adapter/VideoAttentionPageRecomendListAdapter;", "adapter", "Lcom/baidu/tieba/videoplay/adapter/VideoAttentionPageRecomendListAdapter;", "", "Lcom/baidu/tieba/videoplay/data/VideoAttentionPersonListData;", "datalist", "Ljava/util/List;", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "headText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "headerView", "Landroid/view/View;", "lastView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "listView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mBackHomeAnimListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mFragmentIndex", "I", "", "mFromPage", "Ljava/lang/String;", "mVideoItemModel", "Lcom/baidu/tieba/video/VideoItemModel;", "showWord", "<init>", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoAttentionListPageFragment extends BaseFragment implements c.a.q0.y3.i.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoAttentionPageRecomendListAdapter f57805e;

    /* renamed from: f  reason: collision with root package name */
    public VideoItemModel f57806f;

    /* renamed from: g  reason: collision with root package name */
    public int f57807g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f57808h;

    /* renamed from: i  reason: collision with root package name */
    public View f57809i;

    /* renamed from: j  reason: collision with root package name */
    public View f57810j;
    public EMTextView k;
    public List<? extends VideoAttentionPersonListData> l;
    public String m;
    public final CustomMessageListener n;

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionListPageFragment f57811a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionListPageFragment videoAttentionListPageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionListPageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57811a = videoAttentionListPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921612 && this.f57811a.isResumed() && this.f57811a.isVisible()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f57812e;

        public b(GestureDetectorCompat gestureDetectorCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gestureDetectorCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57812e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f57812e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final c f57813e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1981276373, "Lcom/baidu/tieba/videoplay/fragment/VideoAttentionListPageFragment$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1981276373, "Lcom/baidu/tieba/videoplay/fragment/VideoAttentionListPageFragment$c;");
                    return;
                }
            }
            f57813e = new c();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f57814e;

        public d(View view) {
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
            this.f57814e = view;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50) {
                    TbSingleton tbSingleton = TbSingleton.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                    if (tbSingleton.isFromFeedVideoClick()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                    }
                    this.f57814e.cancelLongPress();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    public VideoAttentionListPageFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57807g = -1;
        this.n = new a(this, 2921612);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdRecyclerView bdRecyclerView = this.f57808h;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.f57805e = new VideoAttentionPageRecomendListAdapter(getContext());
            BdRecyclerView bdRecyclerView2 = this.f57808h;
            if (bdRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = this.f57805e;
            if (videoAttentionPageRecomendListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            bdRecyclerView2.setAdapter(videoAttentionPageRecomendListAdapter);
        }
    }

    @Override // c.a.q0.y3.i.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57806f : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.q0.y3.i.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57807g : invokeV.intValue;
    }

    public final boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdRecyclerView bdRecyclerView = this.f57808h;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            if (bdRecyclerView.getFirstVisiblePosition() == 0) {
                View view = this.f57809i;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                }
                int top = view.getTop();
                BdRecyclerView bdRecyclerView2 = this.f57808h;
                if (bdRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                }
                if (top == bdRecyclerView2.getPaddingTop()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.baidu.tieba.videoplay.adapter.VideoAttentionPageRecomendListAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = this.f57805e;
            if (videoAttentionPageRecomendListAdapter == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            List<? extends VideoAttentionPersonListData> list = this.l;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("datalist");
            }
            videoAttentionPageRecomendListAdapter.setData(list);
            List<? extends VideoAttentionPersonListData> list2 = this.l;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("datalist");
            }
            if (!list2.isEmpty()) {
                BdRecyclerView bdRecyclerView = this.f57808h;
                if (bdRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                }
                View view = this.f57809i;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                }
                bdRecyclerView.addHeaderView(view);
                BdRecyclerView bdRecyclerView2 = this.f57808h;
                if (bdRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                }
                View view2 = this.f57810j;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastView");
                }
                bdRecyclerView2.addFooterView(view2);
                String str = this.m;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showWord");
                }
                if (!StringUtils.isNull(str)) {
                    EMTextView eMTextView = this.k;
                    if (eMTextView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headText");
                    }
                    String str2 = this.m;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("showWord");
                    }
                    eMTextView.setText(str2);
                }
            }
            registerListener(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                Object obj = arguments.get("from");
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj2 = arguments.get("video_data");
                this.f57806f = obj2 instanceof VideoItemModel ? obj2 : null;
                Object obj3 = arguments.get("video_attention_list");
                if (obj3 != null) {
                    this.l = (List) obj3;
                    Object obj4 = arguments.get("video_attention_showword");
                    if (obj4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    this.m = (String) obj4;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.videoplay.data.VideoAttentionPersonListData>");
                }
            }
            View inflate = layoutInflater.inflate(R.layout.video_attention_list_view, viewGroup, false);
            if (inflate != null) {
                View inflate2 = layoutInflater.inflate(R.layout.video_attention_list_head_view, viewGroup, false);
                if (inflate2 != null) {
                    this.f57809i = inflate2;
                    if (inflate2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    }
                    c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(inflate2);
                    d2.n(R.string.J_X05);
                    d2.g(SkinManager.getColor(0, R.color.CAM_X0105));
                    View inflate3 = layoutInflater.inflate(R.layout.video_attention_list_last_view, viewGroup, false);
                    if (inflate3 != null) {
                        this.f57810j = inflate3;
                        View view = this.f57809i;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("headerView");
                        }
                        View findViewById = view.findViewById(R.id.video_concern_no_data_title);
                        Intrinsics.checkExpressionValueIsNotNull(findViewById, "headerView.findViewById(…eo_concern_no_data_title)");
                        this.k = (EMTextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.viedo_attention_list);
                        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "rooView.findViewById(R.id.viedo_attention_list)");
                        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById2;
                        this.f57808h = bdRecyclerView;
                        if (bdRecyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("listView");
                        }
                        bdRecyclerView.setPadding(0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds250), 0, 0);
                        g();
                        inflate.setOnTouchListener(new b(new GestureDetectorCompat(getContext(), new d(inflate))));
                        inflate.setOnLongClickListener(c.f57813e);
                        return inflate;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.View");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        }
        return (View) invokeLLL.objValue;
    }

    public final void scrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            BdRecyclerView bdRecyclerView = this.f57808h;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            bdRecyclerView.scrollToPosition(i2);
        }
    }

    @Override // c.a.q0.y3.i.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f57807g = i2;
        }
    }
}
