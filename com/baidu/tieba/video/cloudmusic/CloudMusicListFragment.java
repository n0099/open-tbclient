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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView bOy;
    private BdListView eKJ;
    private com.baidu.tieba.video.cloudmusic.a.a hAu;
    private d.a hAv;
    private CloudMusicData.MusicTagList hAw;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int daL = 1;
    private CustomMessageListener hAx = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hAu != null) {
                CloudMusicListFragment.this.hAu.notifyDataSetChanged();
            }
        }
    };

    public static CloudMusicListFragment a(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        CloudMusicListFragment cloudMusicListFragment = new CloudMusicListFragment();
        cloudMusicListFragment.setArguments(bundle);
        return cloudMusicListFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_cloud_music_list, viewGroup, false);
        this.hAw = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eKJ = (BdListView) inflate.findViewById(e.g.cloud_music_list_view);
        this.hAu = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eKJ.setAdapter((ListAdapter) this.hAu);
        this.eKJ.setExOnSrollToBottomListener(this);
        this.eKJ.setDivider(null);
        this.hAu.a(this);
        this.bOy = new PbListView(getPageContext().getPageActivity());
        this.bOy.oD();
        this.bOy.ex(e.d.cp_bg_line_d);
        this.bOy.ey(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds200)), NoDataViewFactory.d.eq(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hAw != null && this.hAv != null && this.hAw.page != null) {
            this.tagId = this.hAw.tag_id;
            this.daL = this.hAw.page.has_more;
            this.hAv.c(this.hAw);
        }
        this.eKJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kV()) {
                    CloudMusicListFragment.this.hAv.a(CloudMusicListFragment.this.hAu.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), e.j.neterror);
                }
            }
        });
        registerListener(this.hAx);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kV()) {
            l.showToast(getPageContext().getPageActivity(), e.j.neterror);
        } else if (this.hAv != null && this.daL != 0) {
            this.hAv.wr(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bOy.ey(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hAv = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hAw = musicTagList;
        if (this.hAu != null) {
            this.hAu.dW(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nV(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bHZ() {
        if (this.bOy != null) {
            if (this.bOy.getView().getParent() == null) {
                this.eKJ.setNextPage(this.bOy);
            }
            this.bOy.setText(getPageContext().getResources().getString(e.j.cloud_music_from_baidu_music));
            this.bOy.Fd();
        }
        this.daL = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nW(boolean z) {
        if (this.bOy != null) {
            if (z) {
                if (this.bOy.getView().getParent() == null) {
                    this.eKJ.setNextPage(this.bOy);
                }
                this.bOy.Fh();
                this.bOy.Fc();
                return;
            }
            this.bOy.Fd();
            this.eKJ.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wo(int i) {
        this.hAu.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wp(int i) {
        this.hAu.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wq(int i) {
        this.hAu.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), e.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hAv.btl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hAv != null) {
            this.hAv.aDd();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bIg().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hAu != null && this.hAu.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hAu.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
