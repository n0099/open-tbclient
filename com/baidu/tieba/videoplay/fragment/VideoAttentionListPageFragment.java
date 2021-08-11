package com.baidu.tieba.videoplay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.l;
import c.a.o0.s.u.c;
import c.a.p0.y3.i.a.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.adapter.VideoAttentionPageRecomendListAdapter;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010\u000bJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0015R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00105¨\u0006:"}, d2 = {"Lcom/baidu/tieba/videoplay/fragment/VideoAttentionListPageFragment;", "Lc/a/p0/y3/i/a/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/video/VideoItemModel;", "getCurrentData", "()Lcom/baidu/tieba/video/VideoItemModel;", "", "getFragmentIndex", "()I", "", "initRecyclerView", "()V", "", "isOnViewTop", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/os/Bundle;)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "position", "scrollToPosition", "index", "setFragmentIndex", "Lcom/baidu/tieba/videoplay/adapter/VideoAttentionPageRecomendListAdapter;", "adapter", "Lcom/baidu/tieba/videoplay/adapter/VideoAttentionPageRecomendListAdapter;", "", "Lcom/baidu/tieba/videoplay/data/VideoAttentionPersonListData;", "datalist", "Ljava/util/List;", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "headText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "headerView", "Landroid/view/View;", "lastView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "listView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "mFragmentIndex", "I", "", "mFromPage", "Ljava/lang/String;", "mVideoItemModel", "Lcom/baidu/tieba/video/VideoItemModel;", "showWord", "<init>", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoAttentionListPageFragment extends BaseFragment implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoAttentionPageRecomendListAdapter f57629e;

    /* renamed from: f  reason: collision with root package name */
    public VideoItemModel f57630f;

    /* renamed from: g  reason: collision with root package name */
    public int f57631g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f57632h;

    /* renamed from: i  reason: collision with root package name */
    public View f57633i;

    /* renamed from: j  reason: collision with root package name */
    public View f57634j;
    public EMTextView k;
    public List<? extends VideoAttentionPersonListData> l;
    public String m;

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
        this.f57631g = -1;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdRecyclerView bdRecyclerView = this.f57632h;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.f57629e = new VideoAttentionPageRecomendListAdapter(getContext());
            BdRecyclerView bdRecyclerView2 = this.f57632h;
            if (bdRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = this.f57629e;
            if (videoAttentionPageRecomendListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            bdRecyclerView2.setAdapter(videoAttentionPageRecomendListAdapter);
        }
    }

    @Override // c.a.p0.y3.i.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57630f : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.p0.y3.i.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57631g : invokeV.intValue;
    }

    public final boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdRecyclerView bdRecyclerView = this.f57632h;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            if (bdRecyclerView.getFirstVisiblePosition() == 0) {
                View view = this.f57633i;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                }
                int top = view.getTop();
                BdRecyclerView bdRecyclerView2 = this.f57632h;
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
            VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter = this.f57629e;
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
                BdRecyclerView bdRecyclerView = this.f57632h;
                if (bdRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                }
                View view = this.f57633i;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerView");
                }
                bdRecyclerView.addHeaderView(view);
                BdRecyclerView bdRecyclerView2 = this.f57632h;
                if (bdRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                }
                View view2 = this.f57634j;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastView");
                }
                bdRecyclerView2.addFooterView(view2);
                String str = this.m;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showWord");
                }
                if (StringUtils.isNull(str)) {
                    return;
                }
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
                this.f57630f = obj2 instanceof VideoItemModel ? obj2 : null;
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
                    this.f57633i = inflate2;
                    if (inflate2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerView");
                    }
                    c d2 = c.d(inflate2);
                    d2.n(R.string.J_X05);
                    d2.g(SkinManager.getColor(0, R.color.CAM_X0105));
                    View inflate3 = layoutInflater.inflate(R.layout.video_attention_list_last_view, viewGroup, false);
                    if (inflate3 != null) {
                        this.f57634j = inflate3;
                        View view = this.f57633i;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("headerView");
                        }
                        View findViewById = view.findViewById(R.id.video_concern_no_data_title);
                        Intrinsics.checkExpressionValueIsNotNull(findViewById, "headerView.findViewById(…eo_concern_no_data_title)");
                        this.k = (EMTextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.viedo_attention_list);
                        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "rooView.findViewById(R.id.viedo_attention_list)");
                        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById2;
                        this.f57632h = bdRecyclerView;
                        if (bdRecyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("listView");
                        }
                        bdRecyclerView.setPadding(0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds250), 0, 0);
                        g();
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
            BdRecyclerView bdRecyclerView = this.f57632h;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            }
            bdRecyclerView.scrollToPosition(i2);
        }
    }

    @Override // c.a.p0.y3.i.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f57631g = i2;
        }
    }
}
