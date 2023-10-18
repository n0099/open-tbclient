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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.qy6;
import com.baidu.tieba.tsa;
import com.baidu.tieba.usa;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.vsa;
import com.baidu.tieba.wsa;
import com.baidu.tieba.xsa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, usa, wsa.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public wsa b;
    public tsa c;
    public CloudMusicData.MusicTagList d;
    public PbListView e;
    public int f;
    public NoDataView g;
    public int h;
    public vsa i;
    public TbMusicData j;
    public CustomMessageListener k;

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && this.a.b != null) {
                this.a.b.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                } else {
                    this.a.c.b(this.a.b.getItem(i), i);
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
        this.f = 0;
        this.h = 1;
        this.k = new a(this, 2921307);
    }

    public boolean M() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdListView bdListView = this.a;
            if (bdListView == null || bdListView.getFirstVisiblePosition() != 0 || (childAt = this.a.getChildAt(0)) == null || childAt.getTop() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            tsa tsaVar = this.c;
            if (tsaVar != null) {
                tsaVar.a();
            }
            xsa.b().c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroyView();
            this.c.c();
        }
    }

    public static CloudMusicListFragment e2(CloudMusicData.MusicTagList musicTagList) {
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

    @Override // com.baidu.tieba.usa
    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.f(i, false);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void Q(BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdListView) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                return;
            }
            tsa tsaVar = this.c;
            if (tsaVar != null && this.h != 0) {
                tsaVar.e(this.f);
            }
        }
    }

    @Override // com.baidu.tieba.usa
    public void Z0(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, musicTagList) == null) {
            this.d = musicTagList;
            wsa wsaVar = this.b;
            if (wsaVar != null) {
                wsaVar.b(musicTagList.music_list);
            }
        }
    }

    public void f2(vsa vsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vsaVar) == null) {
            this.i = vsaVar;
        }
    }

    public void g2(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbMusicData) == null) {
            this.j = tbMusicData;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            this.e.e(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tieba.usa
    public void r1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b.f(i, true);
        }
    }

    @Override // com.baidu.tieba.usa
    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.usa
    public void x0(tsa tsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tsaVar) == null) {
            this.c = tsaVar;
        }
    }

    @Override // com.baidu.tieba.usa
    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.b.f(i, false);
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
            }
        }
    }

    @Override // com.baidu.tieba.usa
    public void Z(boolean z) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (pbListView = this.e) != null) {
            if (z) {
                if (pbListView.c().getParent() == null) {
                    this.a.setNextPage(this.e);
                }
                this.e.S();
                this.e.U();
                return;
            }
            pbListView.g();
            this.a.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.wsa.c
    public void Q1(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, view2, str, i) == null) {
            Intent intent = new Intent();
            intent.putExtra(CloudMusicActivityConfig.MUSIC_RESOURCE, str);
            wsa wsaVar = this.b;
            if (wsaVar != null && wsaVar.getItem(i) != null) {
                intent.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(Integer.valueOf(this.b.getItem(i).music_id)));
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = String.valueOf(this.b.getItem(i).music_id);
                tbMusicData.title = this.b.getItem(i).name;
                tbMusicData.singer = this.b.getItem(i).author;
                tbMusicData.url = this.b.getItem(i).resource;
                tbMusicData.icon = this.b.getItem(i).image;
                tbMusicData.type = 2;
                tbMusicData.localPath = qy6.h().g(tbMusicData.url);
                intent.putExtra(CloudMusicActivityConfig.MUSIC_DATA, tbMusicData);
            }
            vsa vsaVar = this.i;
            if (vsaVar != null) {
                vsaVar.T(intent);
            }
            getPageContext().getPageActivity().setResult(-1, intent);
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.tieba.usa
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PbListView pbListView = this.e;
            if (pbListView != null) {
                if (pbListView.c().getParent() == null) {
                    this.a.setNextPage(this.e);
                }
                this.e.H(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f047a));
                this.e.g();
            }
            this.h = 0;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        tsa tsaVar;
        CloudMusicData.MusicTagList.Page page;
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0329, viewGroup, false);
            this.d = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09074c);
            wsa wsaVar = new wsa(getPageContext());
            this.b = wsaVar;
            this.a.setAdapter((ListAdapter) wsaVar);
            this.a.setExOnSrollToBottomListener(this);
            this.a.setDivider(null);
            this.b.e(this);
            wsa wsaVar2 = this.b;
            if (wsaVar2 != null && (tbMusicData = this.j) != null) {
                wsaVar2.d(tbMusicData.id);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.e.s(R.color.CAM_X0201);
            this.e.e(TbadkCoreApplication.getInst().getSkinType());
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07038f)), NoDataViewFactory.e.a(R.string.no_data_text), null);
            this.g = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList musicTagList = this.d;
            if (musicTagList != null && (tsaVar = this.c) != null && (page = musicTagList.page) != null) {
                this.f = musicTagList.tag_id;
                this.h = page.has_more;
                tsaVar.d(musicTagList);
            }
            this.a.setOnItemClickListener(new b(this));
            registerListener(this.k);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
