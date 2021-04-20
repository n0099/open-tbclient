package com.baidu.tieba.video.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.q3.i.e;
import d.b.i0.q3.i.f;
import d.b.i0.q3.i.g.a;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, f, a.c {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f21395e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q3.i.g.a f21396f;

    /* renamed from: g  reason: collision with root package name */
    public e f21397g;

    /* renamed from: h  reason: collision with root package name */
    public CloudMusicData.MusicTagList f21398h;
    public PbListView i;
    public NoDataView k;
    public int j = 0;
    public int l = 1;
    public CustomMessageListener m = new a(2921307);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921307 || CloudMusicListFragment.this.f21396f == null) {
                return;
            }
            CloudMusicListFragment.this.f21396f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (j.z()) {
                CloudMusicListFragment.this.f21397g.b(CloudMusicListFragment.this.f21396f.getItem(i), i);
            } else {
                l.K(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
            }
        }
    }

    public static CloudMusicListFragment G0(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        CloudMusicListFragment cloudMusicListFragment = new CloudMusicListFragment();
        cloudMusicListFragment.setArguments(bundle);
        return cloudMusicListFragment;
    }

    @Override // d.b.i0.q3.i.f
    public void G(boolean z) {
        PbListView pbListView = this.i;
        if (pbListView != null) {
            if (z) {
                if (pbListView.b().getParent() == null) {
                    this.f21395e.setNextPage(this.i);
                }
                this.i.M();
                this.i.O();
                return;
            }
            pbListView.f();
            this.f21395e.setNextPage(null);
        }
    }

    @Override // d.b.i0.q3.i.f
    public void J() {
        PbListView pbListView = this.i;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f21395e.setNextPage(this.i);
            }
            this.i.A(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.i.f();
        }
        this.l = 0;
    }

    @Override // d.b.i0.q3.i.f
    public void R(int i) {
        this.f21396f.e(i, true);
    }

    @Override // d.b.i0.q3.i.f
    public void T(CloudMusicData.MusicTagList musicTagList) {
        this.f21398h = musicTagList;
        d.b.i0.q3.i.g.a aVar = this.f21396f;
        if (aVar != null) {
            aVar.b(musicTagList.music_list);
        }
    }

    @Override // d.b.i0.q3.i.f
    public void displayNoDataView(boolean z) {
        if (z) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    @Override // d.b.i0.q3.i.f
    public void h0(int i) {
        this.f21396f.e(i, false);
        if (getPageContext() == null && getPageContext().getPageActivity() == null) {
            return;
        }
        l.K(getPageContext().getPageActivity(), R.string.download_error);
    }

    @Override // d.b.i0.q3.i.f
    public void m0(int i) {
        this.f21396f.e(i, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.i.d(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e eVar;
        CloudMusicData.MusicTagList.Page page;
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.f21398h = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.f21395e = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        d.b.i0.q3.i.g.a aVar = new d.b.i0.q3.i.g.a(getPageContext());
        this.f21396f = aVar;
        this.f21395e.setAdapter((ListAdapter) aVar);
        this.f21395e.setExOnSrollToBottomListener(this);
        this.f21395e.setDivider(null);
        this.f21396f.d(this);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.i = pbListView;
        pbListView.a();
        this.i.o(R.color.CAM_X0201);
        this.i.d(TbadkCoreApplication.getInst().getSkinType());
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_data_text), null);
        this.k = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList musicTagList = this.f21398h;
        if (musicTagList != null && (eVar = this.f21397g) != null && (page = musicTagList.page) != null) {
            this.j = musicTagList.tag_id;
            this.l = page.has_more;
            eVar.c(musicTagList);
        }
        this.f21395e.setOnItemClickListener(new b());
        registerListener(this.m);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.f21397g;
        if (eVar != null) {
            eVar.cancelLoadData();
        }
        d.b.i0.q3.i.h.a.b().c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f21397g.a();
    }

    @Override // d.b.i0.q3.i.g.a.c
    public void v0(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        d.b.i0.q3.i.g.a aVar = this.f21396f;
        if (aVar != null && aVar.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.f21396f.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }

    @Override // d.b.i0.q3.i.f
    public void x(e eVar) {
        this.f21397g = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void y(BdListView bdListView) {
        if (!j.z()) {
            l.K(getPageContext().getPageActivity(), R.string.neterror);
            return;
        }
        e eVar = this.f21397g;
        if (eVar == null || this.l == 0) {
            return;
        }
        eVar.d(this.j);
    }
}
