package com.baidu.tieba.write.write.work.topic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tieba.v68;
import com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter;
import com.baidu.tieba.y68;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class VideoTopicListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public int b;
    public long c;
    public VideoHotTopicSearchAdapter d;

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoTopicListFragment;
        }

        @Override // com.baidu.tieba.write.write.work.topic.adapter.VideoHotTopicSearchAdapter.a
        public void a(y68 y68Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y68Var) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, y68Var));
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
        e = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
    }

    public VideoTopicListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static VideoTopicListFragment H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new VideoTopicListFragment();
        }
        return (VideoTopicListFragment) invokeV.objValue;
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d.getItemCount() > 0) {
            this.a.scrollToPosition(0);
        }
    }

    public void J1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.c = j;
            VideoHotTopicSearchAdapter videoHotTopicSearchAdapter = this.d;
            if (videoHotTopicSearchAdapter != null) {
                videoHotTopicSearchAdapter.m(j);
                this.d.notifyDataSetChanged();
            }
        }
    }

    public void K1(v68 v68Var) {
        VideoHotTopicSearchAdapter videoHotTopicSearchAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v68Var) == null) && (videoHotTopicSearchAdapter = this.d) != null && v68Var != null) {
            videoHotTopicSearchAdapter.k("", v68Var.c());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.b = getArguments().getInt("type", 1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            RecyclerView recyclerView = new RecyclerView(viewGroup.getContext());
            this.a = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.a.setFadingEdgeLength(0);
            this.a.setOverScrollMode(2);
            VideoHotTopicSearchAdapter videoHotTopicSearchAdapter = new VideoHotTopicSearchAdapter(TbadkApplication.getInst().getCurrentPageContext(getContext()));
            this.d = videoHotTopicSearchAdapter;
            videoHotTopicSearchAdapter.l(new a(this));
            this.d.n(this.b);
            this.d.m(this.c);
            this.a.setAdapter(this.d);
            RecyclerView recyclerView2 = this.a;
            int i = e;
            recyclerView2.setPadding(i, 0, i, 0);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z) {
                int i = this.b;
                if (i == 1) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_TAB_SHOW);
                    statisticItem.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem);
                } else if (i == 2) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_TAB_SHOW);
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }
}
