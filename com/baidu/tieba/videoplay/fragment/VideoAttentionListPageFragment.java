package com.baidu.tieba.videoplay.fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import c.a.p0.p4.g.m;
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
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0013H\u0016J&\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0013J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionListPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/verticalviewpager/transforms/IVideoFragment;", "()V", "adapter", "Lcom/baidu/tieba/videoplay/adapter/VideoAttentionPageRecomendListAdapter;", "datalist", "", "Lcom/baidu/tieba/videoplay/data/VideoAttentionPersonListData;", "headText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "headerView", "Landroid/view/View;", "lastView", "listView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "mBackHomeAnimListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCurrentType", "", "mFragmentIndex", "mFromPage", "", "mVideoItemModel", "Lcom/baidu/tieba/video/VideoItemModel;", "showWord", "getCurrentData", "getFragmentIndex", "initRecyclerView", "", "isOnViewTop", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "scrollToPosition", "position", "setFragmentIndex", "index", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class VideoAttentionListPageFragment extends BaseFragment implements c.a.p0.p4.j.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoAttentionPageRecomendListAdapter a;

    /* renamed from: b  reason: collision with root package name */
    public VideoItemModel f36701b;

    /* renamed from: c  reason: collision with root package name */
    public int f36702c;

    /* renamed from: d  reason: collision with root package name */
    public int f36703d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f36704e;

    /* renamed from: f  reason: collision with root package name */
    public View f36705f;

    /* renamed from: g  reason: collision with root package name */
    public View f36706g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f36707h;
    public List<? extends VideoAttentionPersonListData> i;
    public String j;
    public final CustomMessageListener k;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionListPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionListPageFragment videoAttentionListPageFragment) {
            super(2921612);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionListPageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionListPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() == 2921612 && this.a.isResumed() && this.a.isVisible()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
                    FragmentActivity activity = this.a.getActivity();
                    if (activity == null) {
                        return;
                    }
                    activity.finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(View view) {
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
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{e1, e2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e2.getX() - e1.getX() > 50.0f) {
                    if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                    }
                    this.a.cancelLongPress();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36702c = -1;
        this.k = new a(this);
    }

    public static final boolean D0(GestureDetectorCompat detectorCompat, View view, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, detectorCompat, view, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(detectorCompat, "$detectorCompat");
            return detectorCompat.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public static final boolean E0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdRecyclerView bdRecyclerView = this.f36704e;
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = null;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView = null;
            }
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.a = new VideoAttentionPageRecomendListAdapter(getContext(), this.f36703d);
            BdRecyclerView bdRecyclerView2 = this.f36704e;
            if (bdRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView2 = null;
            }
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter2 = this.a;
            if (videoAttentionPageRecomendListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                videoAttentionPageRecomendListAdapter = videoAttentionPageRecomendListAdapter2;
            }
            bdRecyclerView2.setAdapter(videoAttentionPageRecomendListAdapter);
        }
    }

    public final void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            BdRecyclerView bdRecyclerView = this.f36704e;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView = null;
            }
            bdRecyclerView.scrollToPosition(i);
        }
    }

    @Override // c.a.p0.p4.j.b.a
    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f36702c = i;
        }
    }

    @Override // c.a.p0.p4.j.b.a
    public VideoItemModel W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36701b : (VideoItemModel) invokeV.objValue;
    }

    public final boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdRecyclerView bdRecyclerView = this.f36704e;
            BdRecyclerView bdRecyclerView2 = null;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView = null;
            }
            if (bdRecyclerView.getFirstVisiblePosition() == 0) {
                View view = this.f36705f;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view = null;
                }
                int top = view.getTop();
                BdRecyclerView bdRecyclerView3 = this.f36704e;
                if (bdRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                } else {
                    bdRecyclerView2 = bdRecyclerView3;
                }
                if (top == bdRecyclerView2.getPaddingTop()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.p4.j.b.a
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36702c : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.baidu.tieba.videoplay.adapter.VideoAttentionPageRecomendListAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = this.a;
            String str = null;
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter2 = videoAttentionPageRecomendListAdapter;
            if (videoAttentionPageRecomendListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                videoAttentionPageRecomendListAdapter2 = null;
            }
            List<? extends VideoAttentionPersonListData> list = this.i;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("datalist");
                list = null;
            }
            videoAttentionPageRecomendListAdapter2.setData(list);
            List<? extends VideoAttentionPersonListData> list2 = this.i;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("datalist");
                list2 = null;
            }
            if (!list2.isEmpty()) {
                BdRecyclerView bdRecyclerView = this.f36704e;
                if (bdRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    bdRecyclerView = null;
                }
                View view = this.f36705f;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view = null;
                }
                bdRecyclerView.s(view);
                BdRecyclerView bdRecyclerView2 = this.f36704e;
                if (bdRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    bdRecyclerView2 = null;
                }
                View view2 = this.f36706g;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastView");
                    view2 = null;
                }
                bdRecyclerView2.r(view2);
                String str2 = this.j;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showWord");
                    str2 = null;
                }
                if (!StringUtils.isNull(str2)) {
                    EMTextView eMTextView = this.f36707h;
                    if (eMTextView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headText");
                        eMTextView = null;
                    }
                    String str3 = this.j;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("showWord");
                    } else {
                        str = str3;
                    }
                    eMTextView.setText(str);
                }
            }
            registerListener(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Bundle arguments = getArguments();
            BdRecyclerView bdRecyclerView = null;
            if (arguments != null) {
                Object obj = arguments.get("from");
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                Object obj2 = arguments.get("video_data");
                this.f36701b = obj2 instanceof VideoItemModel ? (VideoItemModel) obj2 : null;
                Object obj3 = arguments.get("video_attention_list");
                if (obj3 != null) {
                    this.i = (List) obj3;
                    Object obj4 = arguments.get("video_attention_showword");
                    if (obj4 != null) {
                        this.j = (String) obj4;
                        this.f36703d = arguments.getInt("current_type");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.videoplay.data.VideoAttentionPersonListData>");
                }
            }
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d0872, viewGroup, false);
            if (inflate != null) {
                View inflate2 = inflater.inflate(R.layout.obfuscated_res_0x7f0d0870, viewGroup, false);
                if (inflate2 != null) {
                    this.f36705f = inflate2;
                    if (inflate2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerView");
                        inflate2 = null;
                    }
                    c d2 = c.d(inflate2);
                    d2.n(R.string.J_X05);
                    d2.g(SkinManager.getColor(0, (int) R.color.CAM_X0105));
                    View inflate3 = inflater.inflate(R.layout.obfuscated_res_0x7f0d0871, viewGroup, false);
                    if (inflate3 != null) {
                        this.f36706g = inflate3;
                        View view = this.f36705f;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("headerView");
                            view = null;
                        }
                        View findViewById = view.findViewById(R.id.obfuscated_res_0x7f09231a);
                        Intrinsics.checkNotNullExpressionValue(findViewById, "headerView.findViewById(…eo_concern_no_data_title)");
                        this.f36707h = (EMTextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f0923a1);
                        Intrinsics.checkNotNullExpressionValue(findViewById2, "rooView.findViewById(R.id.viedo_attention_list)");
                        BdRecyclerView bdRecyclerView2 = (BdRecyclerView) findViewById2;
                        this.f36704e = bdRecyclerView2;
                        if (bdRecyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("listView");
                        } else {
                            bdRecyclerView = bdRecyclerView2;
                        }
                        bdRecyclerView.setPadding(0, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds250), 0, 0);
                        C0();
                        final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new b(inflate));
                        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: c.a.p0.p4.g.a
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? VideoAttentionListPageFragment.D0(GestureDetectorCompat.this, view2, motionEvent) : invokeLL.booleanValue;
                            }
                        });
                        inflate.setOnLongClickListener(m.a);
                        return inflate;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        return (View) invokeLLL.objValue;
    }
}
