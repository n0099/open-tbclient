package com.baidu.tieba.view.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.r0.b4.k.e;
import c.a.r0.b4.k.f;
import c.a.r0.b4.k.g;
import c.a.r0.b4.k.h.a;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, f, a.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MUSIC_DATA = "music_data";
    public static final String MUSIC_ID = "music_id";
    public static final String MUSIC_RESOURCE = "music_resource";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58545e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.b4.k.h.a f58546f;

    /* renamed from: g  reason: collision with root package name */
    public e f58547g;

    /* renamed from: h  reason: collision with root package name */
    public CloudMusicData.MusicTagList f58548h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f58549i;

    /* renamed from: j  reason: collision with root package name */
    public int f58550j;
    public NoDataView k;
    public int l;
    public g m;
    public TbMusicData n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicListFragment f58551a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CloudMusicListFragment cloudMusicListFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicListFragment, Integer.valueOf(i2)};
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
            this.f58551a = cloudMusicListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921307 || this.f58551a.f58546f == null) {
                return;
            }
            this.f58551a.f58546f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicListFragment f58552e;

        public b(CloudMusicListFragment cloudMusicListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58552e = cloudMusicListFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (j.z()) {
                    this.f58552e.f58547g.a(this.f58552e.f58546f.getItem(i2), i2);
                } else {
                    l.L(this.f58552e.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        }
    }

    public CloudMusicListFragment() {
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
        this.f58550j = 0;
        this.l = 1;
        this.o = new a(this, 2921307);
    }

    public static CloudMusicListFragment newInstance(CloudMusicData.MusicTagList musicTagList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, musicTagList)) == null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("music_list_key", musicTagList);
            CloudMusicListFragment cloudMusicListFragment = new CloudMusicListFragment();
            cloudMusicListFragment.setArguments(bundle);
            return cloudMusicListFragment;
        }
        return (CloudMusicListFragment) invokeL.objValue;
    }

    @Override // c.a.r0.b4.k.f
    public void displayLoadingMore(boolean z) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pbListView = this.f58549i) == null) {
            return;
        }
        if (z) {
            if (pbListView.b().getParent() == null) {
                this.f58545e.setNextPage(this.f58549i);
            }
            this.f58549i.M();
            this.f58549i.O();
            return;
        }
        pbListView.f();
        this.f58545e.setNextPage(null);
    }

    @Override // c.a.r0.b4.k.f
    public void displayNoDataView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    @Override // c.a.r0.b4.k.f
    public void displayNoMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PbListView pbListView = this.f58549i;
            if (pbListView != null) {
                if (pbListView.b().getParent() == null) {
                    this.f58545e.setNextPage(this.f58549i);
                }
                this.f58549i.A(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
                this.f58549i.f();
            }
            this.l = 0;
        }
    }

    @Override // c.a.r0.b4.k.f
    public void downloadCancel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f58546f.f(i2, false);
        }
    }

    @Override // c.a.r0.b4.k.f
    public void downloadError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f58546f.f(i2, false);
            if (getPageContext() == null && getPageContext().getPageActivity() == null) {
                return;
            }
            l.L(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdListView bdListView = this.f58545e;
            return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.f58545e.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            this.f58549i.d(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        e eVar;
        CloudMusicData.MusicTagList.Page page;
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
            this.f58548h = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
            this.f58545e = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
            c.a.r0.b4.k.h.a aVar = new c.a.r0.b4.k.h.a(getPageContext());
            this.f58546f = aVar;
            this.f58545e.setAdapter((ListAdapter) aVar);
            this.f58545e.setExOnSrollToBottomListener(this);
            this.f58545e.setDivider(null);
            this.f58546f.e(this);
            c.a.r0.b4.k.h.a aVar2 = this.f58546f;
            if (aVar2 != null && (tbMusicData = this.n) != null) {
                aVar2.d(tbMusicData.id);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.f58549i = pbListView;
            pbListView.a();
            this.f58549i.o(R.color.CAM_X0201);
            this.f58549i.d(TbadkCoreApplication.getInst().getSkinType());
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_data_text), null);
            this.k = a2;
            a2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList musicTagList = this.f58548h;
            if (musicTagList != null && (eVar = this.f58547g) != null && (page = musicTagList.page) != null) {
                this.f58550j = musicTagList.tag_id;
                this.l = page.has_more;
                eVar.c(musicTagList);
            }
            this.f58545e.setOnItemClickListener(new b(this));
            registerListener(this.o);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            e eVar = this.f58547g;
            if (eVar != null) {
                eVar.cancelLoadData();
            }
            c.a.r0.b4.k.i.a.b().c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroyView();
            this.f58547g.b();
        }
    }

    @Override // c.a.r0.b4.k.h.a.c
    public void onMusicChooseClick(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, view, str, i2) == null) {
            Intent intent = new Intent();
            intent.putExtra("music_resource", str);
            c.a.r0.b4.k.h.a aVar = this.f58546f;
            if (aVar != null && aVar.getItem(i2) != null) {
                intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.f58546f.getItem(i2).music_id)));
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = String.valueOf(this.f58546f.getItem(i2).music_id);
                tbMusicData.title = this.f58546f.getItem(i2).name;
                tbMusicData.singer = this.f58546f.getItem(i2).author;
                tbMusicData.url = this.f58546f.getItem(i2).resource;
                tbMusicData.icon = this.f58546f.getItem(i2).image;
                tbMusicData.type = 2;
                tbMusicData.localPath = c.a.r0.p0.c.d.a.h().g(tbMusicData.url);
                intent.putExtra("music_data", tbMusicData);
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.onSetResult(intent);
            }
            getPageContext().getPageActivity().setResult(-1, intent);
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void onScrollToBottom(BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdListView) == null) {
            if (!j.z()) {
                l.L(getPageContext().getPageActivity(), R.string.neterror);
                return;
            }
            e eVar = this.f58547g;
            if (eVar == null || this.l == 0) {
                return;
            }
            eVar.d(this.f58550j);
        }
    }

    public void setCloudMusicResultIntentCallBack(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void setCurrentMusicData(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, tbMusicData) == null) {
            this.n = tbMusicData;
        }
    }

    @Override // c.a.r0.b4.k.f
    public void setPresenter(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f58547g = eVar;
        }
    }

    @Override // c.a.r0.b4.k.f
    public void showMusicListData(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, musicTagList) == null) {
            this.f58548h = musicTagList;
            c.a.r0.b4.k.h.a aVar = this.f58546f;
            if (aVar != null) {
                aVar.b(musicTagList.music_list);
            }
        }
    }

    @Override // c.a.r0.b4.k.f
    public void showMusicLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f58546f.f(i2, true);
        }
    }
}
