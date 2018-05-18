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
    private PbListView blq;
    private BdListView dUy;
    private com.baidu.tieba.video.cloudmusic.a.a gLv;
    private d.a gLw;
    private CloudMusicData.MusicTagList gLx;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cvO = 1;
    private CustomMessageListener gLy = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.gLv != null) {
                CloudMusicListFragment.this.gLv.notifyDataSetChanged();
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
        this.gLx = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.dUy = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gLv = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.dUy.setAdapter((ListAdapter) this.gLv);
        this.dUy.setExOnSrollToBottomListener(this);
        this.dUy.setDivider(null);
        this.gLv.a(this);
        this.blq = new PbListView(getPageContext().getPageActivity());
        this.blq.kz();
        this.blq.dv(d.C0126d.cp_bg_line_d);
        this.blq.dw(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dp(d.k.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gLx != null && this.gLw != null && this.gLx.page != null) {
            this.tagId = this.gLx.tag_id;
            this.cvO = this.gLx.page.has_more;
            this.gLw.c(this.gLx);
        }
        this.dUy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (j.gP()) {
                    CloudMusicListFragment.this.gLw.a(CloudMusicListFragment.this.gLv.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.k.neterror);
                }
            }
        });
        registerListener(this.gLy);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.gP()) {
            l.showToast(getPageContext().getPageActivity(), d.k.neterror);
        } else if (this.gLw != null && this.cvO != 0) {
            this.gLw.uk(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.blq.dw(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.gLw = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gLx = musicTagList;
        if (this.gLv != null) {
            this.gLv.dB(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mR(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bvY() {
        if (this.blq != null) {
            if (this.blq.getView().getParent() == null) {
                this.dUy.setNextPage(this.blq);
            }
            this.blq.setText(getPageContext().getResources().getString(d.k.cloud_music_from_baidu_music));
            this.blq.wR();
        }
        this.cvO = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mS(boolean z) {
        if (this.blq != null) {
            if (z) {
                if (this.blq.getView().getParent() == null) {
                    this.dUy.setNextPage(this.blq);
                }
                this.blq.wV();
                this.blq.wQ();
                return;
            }
            this.blq.wR();
            this.dUy.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uh(int i) {
        this.gLv.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ui(int i) {
        this.gLv.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uj(int i) {
        this.gLv.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.k.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gLw.bij();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gLw != null) {
            this.gLw.arf();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bwf().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view2, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gLv != null && this.gLv.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gLv.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
