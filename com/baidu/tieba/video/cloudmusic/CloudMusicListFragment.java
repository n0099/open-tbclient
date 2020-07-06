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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes10.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView fnt;
    private BdListView iNm;
    private com.baidu.tieba.video.cloudmusic.a.a lVf;
    private d.a lVg;
    private CloudMusicData.MusicTagList lVh;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int iiK = 1;
    private CustomMessageListener lVi = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.lVf != null) {
                CloudMusicListFragment.this.lVf.notifyDataSetChanged();
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.lVh = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.iNm = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.lVf = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.iNm.setAdapter((ListAdapter) this.lVf);
        this.iNm.setExOnSrollToBottomListener(this);
        this.iNm.setDivider(null);
        this.lVf.a(this);
        this.fnt = new PbListView(getPageContext().getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fnt.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.mm(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.lVh != null && this.lVg != null && this.lVh.page != null) {
            this.tagId = this.lVh.tag_id;
            this.iiK = this.lVh.page.has_more;
            this.lVg.c(this.lVh);
        }
        this.iNm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.lVg.a(CloudMusicListFragment.this.lVf.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.lVi);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.lVg != null && this.iiK != 0) {
            this.lVg.FX(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fnt.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.lVg = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.lVh = musicTagList;
        if (this.lVf != null) {
            this.lVf.eZ(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vh(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dmw() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.iNm.setNextPage(this.fnt);
            }
            this.fnt.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fnt.endLoadData();
        }
        this.iiK = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vi(boolean z) {
        if (this.fnt != null) {
            if (z) {
                if (this.fnt.getView().getParent() == null) {
                    this.iNm.setNextPage(this.fnt);
                }
                this.fnt.showLoadingViewWithoutEmptyView();
                this.fnt.startLoadData();
                return;
            }
            this.fnt.endLoadData();
            this.iNm.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void FU(int i) {
        this.lVf.af(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void FV(int i) {
        this.lVf.af(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void FW(int i) {
        this.lVf.af(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.lVg.cXz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lVg != null) {
            this.lVg.caS();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dmD().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.lVf != null && this.lVf.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.lVf.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
