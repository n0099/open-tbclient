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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.q4b;
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
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0013H\u0016J&\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0013J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionListPageFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/verticalviewpager/transforms/IVideoFragment;", "()V", "adapter", "Lcom/baidu/tieba/videoplay/adapter/VideoAttentionPageRecomendListAdapter;", "datalist", "", "Lcom/baidu/tieba/videoplay/data/VideoAttentionPersonListData;", "headText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "headerView", "Landroid/view/View;", "lastView", "listView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "mBackHomeAnimListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCurrentType", "", "mFragmentIndex", "mFromPage", "", "mVideoItemModel", "Lcom/baidu/tieba/video/VideoItemModel;", "showWord", "getCurrentData", "getFragmentIndex", "initRecyclerView", "", "isOnViewTop", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "scrollToPosition", CriusAttrConstants.POSITION, "setFragmentIndex", "index", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoAttentionListPageFragment extends BaseFragment implements q4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoAttentionPageRecomendListAdapter a;
    public VideoItemModel b;
    public int c;
    public int d;
    public BdRecyclerView e;
    public View f;
    public View g;
    public EMTextView h;
    public List<? extends VideoAttentionPersonListData> i;
    public String j;
    public final CustomMessageListener k;

    public static final boolean w2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
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
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(View view2) {
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
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{e1, e2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e2.getX() - e1.getX() > 50.0f) {
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
        this.c = -1;
        this.k = new a(this);
    }

    @Override // com.baidu.tieba.q4b
    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.q4b
    public VideoItemModel p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    public static final boolean v2(GestureDetectorCompat detectorCompat, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, detectorCompat, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(detectorCompat, "$detectorCompat");
            return detectorCompat.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdRecyclerView bdRecyclerView = this.e;
            BdRecyclerView bdRecyclerView2 = null;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView = null;
            }
            if (bdRecyclerView.getFirstVisiblePosition() == 0) {
                View view2 = this.f;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view2 = null;
                }
                int top = view2.getTop();
                BdRecyclerView bdRecyclerView3 = this.e;
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

    @Override // com.baidu.tieba.q4b
    public void V0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.c = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
        }
    }

    public final void x2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            BdRecyclerView bdRecyclerView = this.e;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView = null;
            }
            bdRecyclerView.scrollToPosition(i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.baidu.tieba.videoplay.adapter.VideoAttentionPageRecomendListAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
                BdRecyclerView bdRecyclerView = this.e;
                if (bdRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    bdRecyclerView = null;
                }
                View view2 = this.f;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    view2 = null;
                }
                bdRecyclerView.addHeaderView(view2);
                BdRecyclerView bdRecyclerView2 = this.e;
                if (bdRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    bdRecyclerView2 = null;
                }
                View view3 = this.g;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastView");
                    view3 = null;
                }
                bdRecyclerView2.addFooterView(view3);
                String str2 = this.j;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showWord");
                    str2 = null;
                }
                if (!StringUtils.isNull(str2)) {
                    EMTextView eMTextView = this.h;
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Bundle arguments = getArguments();
            BdRecyclerView bdRecyclerView = null;
            if (arguments != null) {
                Object obj = arguments.get("from");
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                Object obj2 = arguments.get("video_data");
                if (obj2 instanceof VideoItemModel) {
                    videoItemModel = (VideoItemModel) obj2;
                } else {
                    videoItemModel = null;
                }
                this.b = videoItemModel;
                Object obj3 = arguments.get("video_attention_list");
                if (obj3 != null) {
                    this.i = (List) obj3;
                    Object obj4 = arguments.get("video_attention_showword");
                    if (obj4 != null) {
                        this.j = (String) obj4;
                        this.d = arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.videoplay.data.VideoAttentionPersonListData>");
                }
            }
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d09e8, viewGroup, false);
            if (inflate != null) {
                View inflate2 = inflater.inflate(R.layout.obfuscated_res_0x7f0d09e6, viewGroup, false);
                if (inflate2 != null) {
                    this.f = inflate2;
                    if (inflate2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerView");
                        inflate2 = null;
                    }
                    EMManager.from(inflate2).setCorner(R.string.J_X05).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0105));
                    View inflate3 = inflater.inflate(R.layout.obfuscated_res_0x7f0d09e7, viewGroup, false);
                    if (inflate3 != null) {
                        this.g = inflate3;
                        View view2 = this.f;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("headerView");
                            view2 = null;
                        }
                        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092927);
                        Intrinsics.checkNotNullExpressionValue(findViewById, "headerView.findViewById(…eo_concern_no_data_title)");
                        this.h = (EMTextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f0929a5);
                        Intrinsics.checkNotNullExpressionValue(findViewById2, "rooView.findViewById(R.id.viedo_attention_list)");
                        BdRecyclerView bdRecyclerView2 = (BdRecyclerView) findViewById2;
                        this.e = bdRecyclerView2;
                        if (bdRecyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("listView");
                        } else {
                            bdRecyclerView = bdRecyclerView2;
                        }
                        bdRecyclerView.setPadding(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds250), 0, 0);
                        u2();
                        final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new b(inflate));
                        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.u3b
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) ? VideoAttentionListPageFragment.v2(GestureDetectorCompat.this, view3, motionEvent) : invokeLL.booleanValue;
                            }
                        });
                        inflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.g4b
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnLongClickListener
                            public final boolean onLongClick(View view3) {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view3)) == null) ? VideoAttentionListPageFragment.w2(view3) : invokeL.booleanValue;
                            }
                        });
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

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdRecyclerView bdRecyclerView = this.e;
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = null;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                bdRecyclerView = null;
            }
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.a = new VideoAttentionPageRecomendListAdapter(getContext(), this.d);
            BdRecyclerView bdRecyclerView2 = this.e;
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
}
