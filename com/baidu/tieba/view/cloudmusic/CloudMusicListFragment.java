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
import com.baidu.tieba.cqa;
import com.baidu.tieba.dqa;
import com.baidu.tieba.eqa;
import com.baidu.tieba.fqa;
import com.baidu.tieba.gqa;
import com.baidu.tieba.i17;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, dqa, fqa.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public fqa b;
    public cqa c;
    public CloudMusicData.MusicTagList d;
    public PbListView e;
    public int f;
    public NoDataView g;
    public int h;
    public eqa i;
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
                    BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e21);
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

    public boolean B() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            cqa cqaVar = this.c;
            if (cqaVar != null) {
                cqaVar.a();
            }
            gqa.b().c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroyView();
            this.c.c();
        }
    }

    public static CloudMusicListFragment K1(CloudMusicData.MusicTagList musicTagList) {
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

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void E(BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdListView) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e21);
                return;
            }
            cqa cqaVar = this.c;
            if (cqaVar != null && this.h != 0) {
                cqaVar.e(this.f);
            }
        }
    }

    @Override // com.baidu.tieba.dqa
    public void L0(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            this.d = musicTagList;
            fqa fqaVar = this.b;
            if (fqaVar != null) {
                fqaVar.b(musicTagList.music_list);
            }
        }
    }

    public void L1(eqa eqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eqaVar) == null) {
            this.i = eqaVar;
        }
    }

    public void M1(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbMusicData) == null) {
            this.j = tbMusicData;
        }
    }

    @Override // com.baidu.tieba.dqa
    public void c1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b.f(i, true);
        }
    }

    @Override // com.baidu.tieba.dqa
    public void j0(cqa cqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cqaVar) == null) {
            this.c = cqaVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            this.e.e(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tieba.dqa
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.dqa
    public void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.b.f(i, false);
        }
    }

    @Override // com.baidu.tieba.dqa
    public void N(boolean z) {
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

    @Override // com.baidu.tieba.dqa
    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b.f(i, false);
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
            }
        }
    }

    @Override // com.baidu.tieba.dqa
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = this.e;
            if (pbListView != null) {
                if (pbListView.c().getParent() == null) {
                    this.a.setNextPage(this.e);
                }
                this.e.H(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0475));
                this.e.g();
            }
            this.h = 0;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        cqa cqaVar;
        CloudMusicData.MusicTagList.Page page;
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0320, viewGroup, false);
            this.d = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f090741);
            fqa fqaVar = new fqa(getPageContext());
            this.b = fqaVar;
            this.a.setAdapter((ListAdapter) fqaVar);
            this.a.setExOnSrollToBottomListener(this);
            this.a.setDivider(null);
            this.b.e(this);
            fqa fqaVar2 = this.b;
            if (fqaVar2 != null && (tbMusicData = this.j) != null) {
                fqaVar2.d(tbMusicData.id);
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
            if (musicTagList != null && (cqaVar = this.c) != null && (page = musicTagList.page) != null) {
                this.f = musicTagList.tag_id;
                this.h = page.has_more;
                cqaVar.d(musicTagList);
            }
            this.a.setOnItemClickListener(new b(this));
            registerListener(this.k);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fqa.c
    public void y1(View view2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, view2, str, i) == null) {
            Intent intent = new Intent();
            intent.putExtra(CloudMusicActivityConfig.MUSIC_RESOURCE, str);
            fqa fqaVar = this.b;
            if (fqaVar != null && fqaVar.getItem(i) != null) {
                intent.putExtra(CloudMusicActivityConfig.MUSIC_ID, StringUtils.string(Integer.valueOf(this.b.getItem(i).music_id)));
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = String.valueOf(this.b.getItem(i).music_id);
                tbMusicData.title = this.b.getItem(i).name;
                tbMusicData.singer = this.b.getItem(i).author;
                tbMusicData.url = this.b.getItem(i).resource;
                tbMusicData.icon = this.b.getItem(i).image;
                tbMusicData.type = 2;
                tbMusicData.localPath = i17.h().g(tbMusicData.url);
                intent.putExtra(CloudMusicActivityConfig.MUSIC_DATA, tbMusicData);
            }
            eqa eqaVar = this.i;
            if (eqaVar != null) {
                eqaVar.j0(intent);
            }
            getPageContext().getPageActivity().setResult(-1, intent);
            getPageContext().getPageActivity().finish();
        }
    }
}
