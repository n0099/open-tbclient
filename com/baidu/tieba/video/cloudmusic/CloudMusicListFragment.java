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
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView blb;
    private BdListView dTr;
    private com.baidu.tieba.video.cloudmusic.a.a gKs;
    private d.a gKt;
    private CloudMusicData.MusicTagList gKu;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cuF = 1;
    private CustomMessageListener gKv = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.gKs != null) {
                CloudMusicListFragment.this.gKs.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.i.fragment_cloud_music_list, viewGroup, false);
        this.gKu = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.dTr = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gKs = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.dTr.setAdapter((ListAdapter) this.gKs);
        this.dTr.setExOnSrollToBottomListener(this);
        this.dTr.setDivider(null);
        this.gKs.a(this);
        this.blb = new PbListView(getPageContext().getPageActivity());
        this.blb.kA();
        this.blb.du(d.C0126d.cp_bg_line_d);
        this.blb.dv(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.m16do(d.k.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gKu != null && this.gKt != null && this.gKu.page != null) {
            this.tagId = this.gKu.tag_id;
            this.cuF = this.gKu.page.has_more;
            this.gKt.c(this.gKu);
        }
        this.dTr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (j.gP()) {
                    CloudMusicListFragment.this.gKt.a(CloudMusicListFragment.this.gKs.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.k.neterror);
                }
            }
        });
        registerListener(this.gKv);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.gP()) {
            l.showToast(getPageContext().getPageActivity(), d.k.neterror);
        } else if (this.gKt != null && this.cuF != 0) {
            this.gKt.ul(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.blb.dv(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.gKt = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gKu = musicTagList;
        if (this.gKs != null) {
            this.gKs.dy(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mQ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bwa() {
        if (this.blb != null) {
            if (this.blb.getView().getParent() == null) {
                this.dTr.setNextPage(this.blb);
            }
            this.blb.setText(getPageContext().getResources().getString(d.k.cloud_music_from_baidu_music));
            this.blb.wS();
        }
        this.cuF = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mR(boolean z) {
        if (this.blb != null) {
            if (z) {
                if (this.blb.getView().getParent() == null) {
                    this.dTr.setNextPage(this.blb);
                }
                this.blb.wW();
                this.blb.wR();
                return;
            }
            this.blb.wS();
            this.dTr.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ui(int i) {
        this.gKs.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uj(int i) {
        this.gKs.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uk(int i) {
        this.gKs.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.k.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gKt.bij();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gKt != null) {
            this.gKt.arg();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bwh().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view2, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gKs != null && this.gKs.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gKs.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
