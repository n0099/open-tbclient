package com.baidu.tieba.view.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.p0.q4.m.e;
import c.a.p0.q4.m.f;
import c.a.p0.q4.m.g;
import c.a.p0.q4.m.h.a;
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
/* loaded from: classes6.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, f, a.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.q4.m.h.a f37049b;

    /* renamed from: c  reason: collision with root package name */
    public e f37050c;

    /* renamed from: d  reason: collision with root package name */
    public CloudMusicData.MusicTagList f37051d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f37052e;

    /* renamed from: f  reason: collision with root package name */
    public int f37053f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f37054g;

    /* renamed from: h  reason: collision with root package name */
    public int f37055h;
    public g i;
    public TbMusicData j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CloudMusicListFragment cloudMusicListFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicListFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cloudMusicListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921307 || this.a.f37049b == null) {
                return;
            }
            this.a.f37049b.notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicListFragment a;

        public b(CloudMusicListFragment cloudMusicListFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cloudMusicListFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (l.z()) {
                    this.a.f37050c.b(this.a.f37049b.getItem(i), i);
                } else {
                    n.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }
    }

    public CloudMusicListFragment() {
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
        this.f37053f = 0;
        this.f37055h = 1;
        this.k = new a(this, 2921307);
    }

    public static CloudMusicListFragment E0(CloudMusicData.MusicTagList musicTagList) {
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

    @Override // c.a.p0.q4.m.f
    public void B(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f37050c = eVar;
        }
    }

    @Override // c.a.p0.q4.m.f
    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f37049b.f(i, false);
            if (getPageContext() == null && getPageContext().getPageActivity() == null) {
                return;
            }
            n.M(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f04e7);
        }
    }

    public void F0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.i = gVar;
        }
    }

    public void G0(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.j = tbMusicData;
        }
    }

    @Override // c.a.p0.q4.m.f
    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f37049b.f(i, false);
        }
    }

    @Override // c.a.p0.q4.m.f
    public void S(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, musicTagList) == null) {
            this.f37051d = musicTagList;
            c.a.p0.q4.m.h.a aVar = this.f37049b;
            if (aVar != null) {
                aVar.b(musicTagList.music_list);
            }
        }
    }

    @Override // c.a.p0.q4.m.f
    public void displayNoDataView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.f37054g.setVisibility(0);
            } else {
                this.f37054g.setVisibility(8);
            }
        }
    }

    @Override // c.a.p0.q4.m.f
    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f37049b.f(i, true);
        }
    }

    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.a;
            return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.a.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void o(BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdListView) == null) {
            if (!l.z()) {
                n.M(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0c15);
                return;
            }
            e eVar = this.f37050c;
            if (eVar == null || this.f37055h == 0) {
                return;
            }
            eVar.e(this.f37053f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            this.f37052e.d(i);
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
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02da, viewGroup, false);
            this.f37051d = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f090671);
            c.a.p0.q4.m.h.a aVar = new c.a.p0.q4.m.h.a(getPageContext());
            this.f37049b = aVar;
            this.a.setAdapter((ListAdapter) aVar);
            this.a.setExOnSrollToBottomListener(this);
            this.a.setDivider(null);
            this.f37049b.e(this);
            c.a.p0.q4.m.h.a aVar2 = this.f37049b;
            if (aVar2 != null && (tbMusicData = this.j) != null) {
                aVar2.d(tbMusicData.id);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.f37052e = pbListView;
            pbListView.a();
            this.f37052e.p(R.color.CAM_X0201);
            this.f37052e.d(TbadkCoreApplication.getInst().getSkinType());
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070263)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2d), null);
            this.f37054g = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList musicTagList = this.f37051d;
            if (musicTagList != null && (eVar = this.f37050c) != null && (page = musicTagList.page) != null) {
                this.f37053f = musicTagList.tag_id;
                this.f37055h = page.has_more;
                eVar.d(musicTagList);
            }
            this.a.setOnItemClickListener(new b(this));
            registerListener(this.k);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            e eVar = this.f37050c;
            if (eVar != null) {
                eVar.a();
            }
            c.a.p0.q4.m.i.a.b().c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroyView();
            this.f37050c.c();
        }
    }

    @Override // c.a.p0.q4.m.f
    public void s(boolean z) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (pbListView = this.f37052e) == null) {
            return;
        }
        if (z) {
            if (pbListView.b().getParent() == null) {
                this.a.setNextPage(this.f37052e);
            }
            this.f37052e.P();
            this.f37052e.R();
            return;
        }
        pbListView.f();
        this.a.setNextPage(null);
    }

    @Override // c.a.p0.q4.m.f
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            PbListView pbListView = this.f37052e;
            if (pbListView != null) {
                if (pbListView.b().getParent() == null) {
                    this.a.setNextPage(this.f37052e);
                }
                this.f37052e.D(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f03e5));
                this.f37052e.f();
            }
            this.f37055h = 0;
        }
    }

    @Override // c.a.p0.q4.m.h.a.c
    public void w0(View view, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, view, str, i) == null) {
            Intent intent = new Intent();
            intent.putExtra(CloudMusicActivityConfig.MUSIC_RESOURCE, str);
            c.a.p0.q4.m.h.a aVar = this.f37049b;
            if (aVar != null && aVar.getItem(i) != null) {
                intent.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(Integer.valueOf(this.f37049b.getItem(i).music_id)));
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = String.valueOf(this.f37049b.getItem(i).music_id);
                tbMusicData.title = this.f37049b.getItem(i).name;
                tbMusicData.singer = this.f37049b.getItem(i).author;
                tbMusicData.url = this.f37049b.getItem(i).resource;
                tbMusicData.icon = this.f37049b.getItem(i).image;
                tbMusicData.type = 2;
                tbMusicData.localPath = c.a.p0.y0.c.d.a.h().g(tbMusicData.url);
                intent.putExtra(CloudMusicActivityConfig.MUSIC_DATA, tbMusicData);
            }
            g gVar = this.i;
            if (gVar != null) {
                gVar.onSetResult(intent);
            }
            getPageContext().getPageActivity().setResult(-1, intent);
            getPageContext().getPageActivity().finish();
        }
    }
}
