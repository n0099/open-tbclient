package com.baidu.tieba.write.write.work.topic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.q1.c;
import c.a.r0.q1.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class VideoTopicListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f51218i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f51219e;

    /* renamed from: f  reason: collision with root package name */
    public int f51220f;

    /* renamed from: g  reason: collision with root package name */
    public long f51221g;

    /* renamed from: h  reason: collision with root package name */
    public VideoHotTopicSearchAdapter f51222h;

    /* loaded from: classes11.dex */
    public class a implements VideoHotTopicSearchAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoTopicListFragment a;

        public a(VideoTopicListFragment videoTopicListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTopicListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoTopicListFragment;
        }

        @Override // com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter.a
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, fVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1824517974, "Lcom/baidu/tieba/write/write/work/topic/fragment/VideoTopicListFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1824517974, "Lcom/baidu/tieba/write/write/work/topic/fragment/VideoTopicListFragment;");
                return;
            }
        }
        f51218i = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
    }

    public VideoTopicListFragment() {
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

    public static VideoTopicListFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new VideoTopicListFragment() : (VideoTopicListFragment) invokeV.objValue;
    }

    public void onClose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51222h.getItemCount() <= 0) {
            return;
        }
        this.f51219e.scrollToPosition(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.f51220f = getArguments().getInt("type", 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            RecyclerView recyclerView = new RecyclerView(viewGroup.getContext());
            this.f51219e = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f51219e.setFadingEdgeLength(0);
            this.f51219e.setOverScrollMode(2);
            VideoHotTopicSearchAdapter videoHotTopicSearchAdapter = new VideoHotTopicSearchAdapter(TbadkApplication.getInst().getCurrentPageContext(getContext()));
            this.f51222h = videoHotTopicSearchAdapter;
            videoHotTopicSearchAdapter.setOnClickItemListener(new a(this));
            this.f51222h.setmAdapterType(this.f51220f);
            this.f51222h.setSelectTopicId(this.f51221g);
            this.f51219e.setAdapter(this.f51222h);
            RecyclerView recyclerView2 = this.f51219e;
            int i2 = f51218i;
            recyclerView2.setPadding(i2, 0, i2, 0);
            return this.f51219e;
        }
        return (View) invokeLLL.objValue;
    }

    public void setSelectTopicId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f51221g = j2;
            VideoHotTopicSearchAdapter videoHotTopicSearchAdapter = this.f51222h;
            if (videoHotTopicSearchAdapter != null) {
                videoHotTopicSearchAdapter.setSelectTopicId(j2);
                this.f51222h.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z) {
                int i2 = this.f51220f;
                if (i2 == 1) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_TAB_SHOW);
                    statisticItem.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem);
                } else if (i2 == 2) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_TAB_SHOW);
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    public void setlist(c cVar) {
        VideoHotTopicSearchAdapter videoHotTopicSearchAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoHotTopicSearchAdapter = this.f51222h) == null || cVar == null) {
            return;
        }
        videoHotTopicSearchAdapter.setList("", cVar.c());
    }
}
