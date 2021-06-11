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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.r3.h.e;
import d.a.n0.r3.h.f;
import d.a.n0.r3.h.g.a;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.q, f, a.c {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f21272e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r3.h.g.a f21273f;

    /* renamed from: g  reason: collision with root package name */
    public e f21274g;

    /* renamed from: h  reason: collision with root package name */
    public CloudMusicData.MusicTagList f21275h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f21276i;
    public NoDataView k;
    public int j = 0;
    public int l = 1;
    public CustomMessageListener m = new a(2921307);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921307 || CloudMusicListFragment.this.f21273f == null) {
                return;
            }
            CloudMusicListFragment.this.f21273f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (j.z()) {
                CloudMusicListFragment.this.f21274g.c(CloudMusicListFragment.this.f21273f.getItem(i2), i2);
            } else {
                l.L(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
            }
        }
    }

    public static CloudMusicListFragment I0(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        CloudMusicListFragment cloudMusicListFragment = new CloudMusicListFragment();
        cloudMusicListFragment.setArguments(bundle);
        return cloudMusicListFragment;
    }

    @Override // d.a.n0.r3.h.g.a.c
    public void A0(View view, String str, int i2) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        d.a.n0.r3.h.g.a aVar = this.f21273f;
        if (aVar != null && aVar.getItem(i2) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.f21273f.getItem(i2).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }

    @Override // d.a.n0.r3.h.f
    public void F(CloudMusicData.MusicTagList musicTagList) {
        this.f21275h = musicTagList;
        d.a.n0.r3.h.g.a aVar = this.f21273f;
        if (aVar != null) {
            aVar.b(musicTagList.music_list);
        }
    }

    @Override // d.a.n0.r3.h.f
    public void J(int i2) {
        this.f21273f.e(i2, false);
        if (getPageContext() == null && getPageContext().getPageActivity() == null) {
            return;
        }
        l.L(getPageContext().getPageActivity(), R.string.download_error);
    }

    @Override // d.a.n0.r3.h.f
    public void L(int i2) {
        this.f21273f.e(i2, false);
    }

    @Override // d.a.n0.r3.h.f
    public void c0(e eVar) {
        this.f21274g = eVar;
    }

    @Override // d.a.n0.r3.h.f
    public void displayNoDataView(boolean z) {
        if (z) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.q
    public void g(BdListView bdListView) {
        if (!j.z()) {
            l.L(getPageContext().getPageActivity(), R.string.neterror);
            return;
        }
        e eVar = this.f21274g;
        if (eVar == null || this.l == 0) {
            return;
        }
        eVar.d(this.j);
    }

    @Override // d.a.n0.r3.h.f
    public void i0(int i2) {
        this.f21273f.e(i2, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mSkinType = i2;
        this.f21276i.d(i2);
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
        this.f21275h = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.f21272e = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        d.a.n0.r3.h.g.a aVar = new d.a.n0.r3.h.g.a(getPageContext());
        this.f21273f = aVar;
        this.f21272e.setAdapter((ListAdapter) aVar);
        this.f21272e.setExOnSrollToBottomListener(this);
        this.f21272e.setDivider(null);
        this.f21273f.d(this);
        PbListView pbListView = new PbListView(getPageContext().getPageActivity());
        this.f21276i = pbListView;
        pbListView.a();
        this.f21276i.o(R.color.CAM_X0201);
        this.f21276i.d(TbadkCoreApplication.getInst().getSkinType());
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.e.a(R.string.no_data_text), null);
        this.k = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList musicTagList = this.f21275h;
        if (musicTagList != null && (eVar = this.f21274g) != null && (page = musicTagList.page) != null) {
            this.j = musicTagList.tag_id;
            this.l = page.has_more;
            eVar.a(musicTagList);
        }
        this.f21272e.setOnItemClickListener(new b());
        registerListener(this.m);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.f21274g;
        if (eVar != null) {
            eVar.cancelLoadData();
        }
        d.a.n0.r3.h.h.a.b().c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f21274g.b();
    }

    @Override // d.a.n0.r3.h.f
    public void w(boolean z) {
        PbListView pbListView = this.f21276i;
        if (pbListView != null) {
            if (z) {
                if (pbListView.b().getParent() == null) {
                    this.f21272e.setNextPage(this.f21276i);
                }
                this.f21276i.M();
                this.f21276i.O();
                return;
            }
            pbListView.f();
            this.f21272e.setNextPage(null);
        }
    }

    @Override // d.a.n0.r3.h.f
    public void y() {
        PbListView pbListView = this.f21276i;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f21272e.setNextPage(this.f21276i);
            }
            this.f21276i.A(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.f21276i.f();
        }
        this.l = 0;
    }
}
