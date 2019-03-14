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
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dbn;
    private BdListView ger;
    private com.baidu.tieba.video.cloudmusic.a.a iVn;
    private d.a iVo;
    private CloudMusicData.MusicTagList iVp;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eon = 1;
    private CustomMessageListener iVq = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.iVn != null) {
                CloudMusicListFragment.this.iVn.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.h.fragment_cloud_music_list, viewGroup, false);
        this.iVp = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.ger = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.iVn = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.ger.setAdapter((ListAdapter) this.iVn);
        this.ger.setExOnSrollToBottomListener(this);
        this.ger.setDivider(null);
        this.iVn.a(this);
        this.dbn = new PbListView(getPageContext().getPageActivity());
        this.dbn.oM();
        this.dbn.ib(d.C0277d.cp_bg_line_d);
        this.dbn.ic(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.hU(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.iVp != null && this.iVo != null && this.iVp.page != null) {
            this.tagId = this.iVp.tag_id;
            this.eon = this.iVp.page.has_more;
            this.iVo.c(this.iVp);
        }
        this.ger.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kY()) {
                    CloudMusicListFragment.this.iVo.a(CloudMusicListFragment.this.iVn.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.iVq);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kY()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.iVo != null && this.eon != 0) {
            this.iVo.At(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dbn.ic(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.iVo = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.iVp = musicTagList;
        if (this.iVn != null) {
            this.iVn.ee(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void qz(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ciX() {
        if (this.dbn != null) {
            if (this.dbn.getView().getParent() == null) {
                this.ger.setNextPage(this.dbn);
            }
            this.dbn.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.dbn.aeD();
        }
        this.eon = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void qA(boolean z) {
        if (this.dbn != null) {
            if (z) {
                if (this.dbn.getView().getParent() == null) {
                    this.ger.setNextPage(this.dbn);
                }
                this.dbn.aeI();
                this.dbn.aeC();
                return;
            }
            this.dbn.aeD();
            this.ger.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Aq(int i) {
        this.iVn.L(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ar(int i) {
        this.iVn.L(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void As(int i) {
        this.iVn.L(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.iVo.bVu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iVo != null) {
            this.iVo.beY();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cje().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.iVn != null && this.iVn.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.iVn.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
