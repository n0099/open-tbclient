package com.baidu.tieba.view.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.q0.z3.l.e;
import d.a.q0.z3.l.f;
import d.a.q0.z3.l.g;
import d.a.q0.z3.l.h.a;
/* loaded from: classes4.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, f, a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f22431e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.z3.l.h.a f22432f;

    /* renamed from: g  reason: collision with root package name */
    public e f22433g;

    /* renamed from: h  reason: collision with root package name */
    public CloudMusicData.MusicTagList f22434h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f22435i;
    public int j;
    public NoDataView k;
    public int l;
    public g m;
    public TbMusicData n;
    public CustomMessageListener o;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicListFragment f22436a;

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
            this.f22436a = cloudMusicListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921307 || this.f22436a.f22432f == null) {
                return;
            }
            this.f22436a.f22432f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicListFragment f22437e;

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
            this.f22437e = cloudMusicListFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (j.z()) {
                    this.f22437e.f22433g.a(this.f22437e.f22432f.getItem(i2), i2);
                } else {
                    l.L(this.f22437e.getPageContext().getPageActivity(), R.string.neterror);
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
        this.j = 0;
        this.l = 1;
        this.o = new a(this, 2921307);
    }

    public static CloudMusicListFragment O0(CloudMusicData.MusicTagList musicTagList) {
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

    @Override // d.a.q0.z3.l.f
    public void F(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f22433g = eVar;
        }
    }

    @Override // d.a.q0.z3.l.h.a.c
    public void F0(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, str, i2) == null) {
            Intent intent = new Intent();
            intent.putExtra(CloudMusicActivityConfig.MUSIC_RESOURCE, str);
            d.a.q0.z3.l.h.a aVar = this.f22432f;
            if (aVar != null && aVar.getItem(i2) != null) {
                intent.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(Integer.valueOf(this.f22432f.getItem(i2).music_id)));
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = String.valueOf(this.f22432f.getItem(i2).music_id);
                tbMusicData.title = this.f22432f.getItem(i2).name;
                tbMusicData.singer = this.f22432f.getItem(i2).author;
                tbMusicData.url = this.f22432f.getItem(i2).resource;
                tbMusicData.icon = this.f22432f.getItem(i2).image;
                tbMusicData.type = 2;
                tbMusicData.localPath = d.a.q0.n0.c.d.a.h().g(tbMusicData.url);
                intent.putExtra(CloudMusicActivityConfig.MUSIC_DATA, tbMusicData);
            }
            g gVar = this.m;
            if (gVar != null) {
                gVar.onSetResult(intent);
            }
            getPageContext().getPageActivity().setResult(-1, intent);
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // d.a.q0.z3.l.f
    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f22432f.f(i2, false);
            if (getPageContext() == null && getPageContext().getPageActivity() == null) {
                return;
            }
            l.L(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // d.a.q0.z3.l.f
    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f22432f.f(i2, false);
        }
    }

    public void P0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void Q0(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbMusicData) == null) {
            this.n = tbMusicData;
        }
    }

    @Override // d.a.q0.z3.l.f
    public void Y(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, musicTagList) == null) {
            this.f22434h = musicTagList;
            d.a.q0.z3.l.h.a aVar = this.f22432f;
            if (aVar != null) {
                aVar.b(musicTagList.music_list);
            }
        }
    }

    @Override // d.a.q0.z3.l.f
    public void displayNoDataView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.f22431e;
            return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.f22431e.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.z3.l.f
    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f22432f.f(i2, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            this.f22435i.d(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
            this.f22434h = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
            this.f22431e = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
            d.a.q0.z3.l.h.a aVar = new d.a.q0.z3.l.h.a(getPageContext());
            this.f22432f = aVar;
            this.f22431e.setAdapter((ListAdapter) aVar);
            this.f22431e.setExOnSrollToBottomListener(this);
            this.f22431e.setDivider(null);
            this.f22432f.e(this);
            d.a.q0.z3.l.h.a aVar2 = this.f22432f;
            if (aVar2 != null && (tbMusicData = this.n) != null) {
                aVar2.d(tbMusicData.id);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.f22435i = pbListView;
            pbListView.a();
            this.f22435i.o(R.color.CAM_X0201);
            this.f22435i.d(TbadkCoreApplication.getInst().getSkinType());
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_data_text), null);
            this.k = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList musicTagList = this.f22434h;
            if (musicTagList != null && (eVar = this.f22433g) != null && (page = musicTagList.page) != null) {
                this.j = musicTagList.tag_id;
                this.l = page.has_more;
                eVar.c(musicTagList);
            }
            this.f22431e.setOnItemClickListener(new b(this));
            registerListener(this.o);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            e eVar = this.f22433g;
            if (eVar != null) {
                eVar.cancelLoadData();
            }
            d.a.q0.z3.l.i.a.b().c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroyView();
            this.f22433g.b();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void p(BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdListView) == null) {
            if (!j.z()) {
                l.L(getPageContext().getPageActivity(), R.string.neterror);
                return;
            }
            e eVar = this.f22433g;
            if (eVar == null || this.l == 0) {
                return;
            }
            eVar.d(this.j);
        }
    }

    @Override // d.a.q0.z3.l.f
    public void u(boolean z) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (pbListView = this.f22435i) == null) {
            return;
        }
        if (z) {
            if (pbListView.b().getParent() == null) {
                this.f22431e.setNextPage(this.f22435i);
            }
            this.f22435i.M();
            this.f22435i.O();
            return;
        }
        pbListView.f();
        this.f22431e.setNextPage(null);
    }

    @Override // d.a.q0.z3.l.f
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PbListView pbListView = this.f22435i;
            if (pbListView != null) {
                if (pbListView.b().getParent() == null) {
                    this.f22431e.setNextPage(this.f22435i);
                }
                this.f22435i.A(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
                this.f22435i.f();
            }
            this.l = 0;
        }
    }
}
