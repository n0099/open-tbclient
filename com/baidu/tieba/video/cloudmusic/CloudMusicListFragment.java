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
    private PbListView bOB;
    private BdListView eNA;
    private com.baidu.tieba.video.cloudmusic.a.a hDF;
    private d.a hDG;
    private CloudMusicData.MusicTagList hDH;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int ddD = 1;
    private CustomMessageListener hDI = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hDF != null) {
                CloudMusicListFragment.this.hDF.notifyDataSetChanged();
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
        this.hDH = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eNA = (BdListView) inflate.findViewById(e.g.cloud_music_list_view);
        this.hDF = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eNA.setAdapter((ListAdapter) this.hDF);
        this.eNA.setExOnSrollToBottomListener(this);
        this.eNA.setDivider(null);
        this.hDF.a(this);
        this.bOB = new PbListView(getPageContext().getPageActivity());
        this.bOB.oD();
        this.bOB.ex(e.d.cp_bg_line_d);
        this.bOB.ey(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds200)), NoDataViewFactory.d.eq(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hDH != null && this.hDG != null && this.hDH.page != null) {
            this.tagId = this.hDH.tag_id;
            this.ddD = this.hDH.page.has_more;
            this.hDG.c(this.hDH);
        }
        this.eNA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kV()) {
                    CloudMusicListFragment.this.hDG.a(CloudMusicListFragment.this.hDF.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), e.j.neterror);
                }
            }
        });
        registerListener(this.hDI);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kV()) {
            l.showToast(getPageContext().getPageActivity(), e.j.neterror);
        } else if (this.hDG != null && this.ddD != 0) {
            this.hDG.wE(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bOB.ey(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hDG = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hDH = musicTagList;
        if (this.hDF != null) {
            this.hDF.dX(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nY(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bIO() {
        if (this.bOB != null) {
            if (this.bOB.getView().getParent() == null) {
                this.eNA.setNextPage(this.bOB);
            }
            this.bOB.setText(getPageContext().getResources().getString(e.j.cloud_music_from_baidu_music));
            this.bOB.Fd();
        }
        this.ddD = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nZ(boolean z) {
        if (this.bOB != null) {
            if (z) {
                if (this.bOB.getView().getParent() == null) {
                    this.eNA.setNextPage(this.bOB);
                }
                this.bOB.Fh();
                this.bOB.Fc();
                return;
            }
            this.bOB.Fd();
            this.eNA.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wB(int i) {
        this.hDF.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wC(int i) {
        this.hDF.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wD(int i) {
        this.hDF.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), e.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hDG.btW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hDG != null) {
            this.hDG.aDS();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bIV().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hDF != null && this.hDF.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hDF.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
