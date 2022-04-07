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
import com.repackage.kx8;
import com.repackage.lx8;
import com.repackage.mi;
import com.repackage.mx8;
import com.repackage.nx8;
import com.repackage.o86;
import com.repackage.oi;
import com.repackage.ox8;
/* loaded from: classes4.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, lx8, nx8.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public nx8 b;
    public kx8 c;
    public CloudMusicData.MusicTagList d;
    public PbListView e;
    public int f;
    public NoDataView g;
    public int h;
    public mx8 i;
    public TbMusicData j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921307 || this.a.b == null) {
                return;
            }
            this.a.b.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
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
                if (mi.z()) {
                    this.a.c.b(this.a.b.getItem(i), i);
                } else {
                    oi.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0c18);
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

    public static CloudMusicListFragment D0(CloudMusicData.MusicTagList musicTagList) {
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

    @Override // com.repackage.lx8
    public void B(kx8 kx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kx8Var) == null) {
            this.c = kx8Var;
        }
    }

    @Override // com.repackage.lx8
    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.f(i, false);
            if (getPageContext() == null && getPageContext().getPageActivity() == null) {
                return;
            }
            oi.M(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f04ee);
        }
    }

    public void E0(mx8 mx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mx8Var) == null) {
            this.i = mx8Var;
        }
    }

    public void F0(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.j = tbMusicData;
        }
    }

    @Override // com.repackage.lx8
    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b.f(i, false);
        }
    }

    @Override // com.repackage.lx8
    public void S(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, musicTagList) == null) {
            this.d = musicTagList;
            nx8 nx8Var = this.b;
            if (nx8Var != null) {
                nx8Var.b(musicTagList.music_list);
            }
        }
    }

    @Override // com.repackage.lx8
    public void displayNoDataView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    @Override // com.repackage.lx8
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b.f(i, true);
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
    public void n(BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdListView) == null) {
            if (!mi.z()) {
                oi.M(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0c18);
                return;
            }
            kx8 kx8Var = this.c;
            if (kx8Var == null || this.h == 0) {
                return;
            }
            kx8Var.e(this.f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            this.e.d(i);
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
        kx8 kx8Var;
        CloudMusicData.MusicTagList.Page page;
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02db, viewGroup, false);
            this.d = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09067b);
            nx8 nx8Var = new nx8(getPageContext());
            this.b = nx8Var;
            this.a.setAdapter((ListAdapter) nx8Var);
            this.a.setExOnSrollToBottomListener(this);
            this.a.setDivider(null);
            this.b.e(this);
            nx8 nx8Var2 = this.b;
            if (nx8Var2 != null && (tbMusicData = this.j) != null) {
                nx8Var2.d(tbMusicData.id);
            }
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.e.p(R.color.CAM_X0201);
            this.e.d(TbadkCoreApplication.getInst().getSkinType());
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070270)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c30), null);
            this.g = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList musicTagList = this.d;
            if (musicTagList != null && (kx8Var = this.c) != null && (page = musicTagList.page) != null) {
                this.f = musicTagList.tag_id;
                this.h = page.has_more;
                kx8Var.d(musicTagList);
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
            kx8 kx8Var = this.c;
            if (kx8Var != null) {
                kx8Var.a();
            }
            ox8.b().c();
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

    @Override // com.repackage.lx8
    public void s(boolean z) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (pbListView = this.e) == null) {
            return;
        }
        if (z) {
            if (pbListView.b().getParent() == null) {
                this.a.setNextPage(this.e);
            }
            this.e.O();
            this.e.Q();
            return;
        }
        pbListView.f();
        this.a.setNextPage(null);
    }

    @Override // com.repackage.lx8
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            PbListView pbListView = this.e;
            if (pbListView != null) {
                if (pbListView.b().getParent() == null) {
                    this.a.setNextPage(this.e);
                }
                this.e.C(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f03ec));
                this.e.f();
            }
            this.h = 0;
        }
    }

    @Override // com.repackage.nx8.c
    public void v0(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, view2, str, i) == null) {
            Intent intent = new Intent();
            intent.putExtra(CloudMusicActivityConfig.MUSIC_RESOURCE, str);
            nx8 nx8Var = this.b;
            if (nx8Var != null && nx8Var.getItem(i) != null) {
                intent.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(Integer.valueOf(this.b.getItem(i).music_id)));
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = String.valueOf(this.b.getItem(i).music_id);
                tbMusicData.title = this.b.getItem(i).name;
                tbMusicData.singer = this.b.getItem(i).author;
                tbMusicData.url = this.b.getItem(i).resource;
                tbMusicData.icon = this.b.getItem(i).image;
                tbMusicData.type = 2;
                tbMusicData.localPath = o86.h().g(tbMusicData.url);
                intent.putExtra(CloudMusicActivityConfig.MUSIC_DATA, tbMusicData);
            }
            mx8 mx8Var = this.i;
            if (mx8Var != null) {
                mx8Var.onSetResult(intent);
            }
            getPageContext().getPageActivity().setResult(-1, intent);
            getPageContext().getPageActivity().finish();
        }
    }
}
