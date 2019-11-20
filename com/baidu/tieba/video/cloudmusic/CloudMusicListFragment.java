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
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dvS;
    private BdListView gBx;
    private com.baidu.tieba.video.cloudmusic.a.a jwP;
    private d.a jwQ;
    private CloudMusicData.MusicTagList jwR;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eSj = 1;
    private CustomMessageListener jwS = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.jwP != null) {
                CloudMusicListFragment.this.jwP.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.jwR = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gBx = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.jwP = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gBx.setAdapter((ListAdapter) this.jwP);
        this.gBx.setExOnSrollToBottomListener(this);
        this.gBx.setDivider(null);
        this.jwP.a(this);
        this.dvS = new PbListView(getPageContext().getPageActivity());
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.dvS.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iK(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.jwR != null && this.jwQ != null && this.jwR.page != null) {
            this.tagId = this.jwR.tag_id;
            this.eSj = this.jwR.page.has_more;
            this.jwQ.c(this.jwR);
        }
        this.gBx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.jwQ.a(CloudMusicListFragment.this.jwP.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.jwS);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.jwQ != null && this.eSj != 0) {
            this.jwQ.AP(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dvS.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.jwQ = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.jwR = musicTagList;
        if (this.jwP != null) {
            this.jwP.eA(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rp(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void csJ() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.gBx.setNextPage(this.dvS);
            }
            this.dvS.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dvS.endLoadData();
        }
        this.eSj = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rq(boolean z) {
        if (this.dvS != null) {
            if (z) {
                if (this.dvS.getView().getParent() == null) {
                    this.gBx.setNextPage(this.dvS);
                }
                this.dvS.showLoadingViewWithoutEmptyView();
                this.dvS.startLoadData();
                return;
            }
            this.dvS.endLoadData();
            this.gBx.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void AM(int i) {
        this.jwP.R(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void AN(int i) {
        this.jwP.R(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void AO(int i) {
        this.jwP.R(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jwQ.cep();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jwQ != null) {
            this.jwQ.bmt();
        }
        com.baidu.tieba.video.cloudmusic.data.a.csQ().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.jwP != null && this.jwP.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.jwP.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
