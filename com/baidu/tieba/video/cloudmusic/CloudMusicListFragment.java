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
/* loaded from: classes17.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView fsC;
    private BdListView iTZ;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a mcx;
    private d.a mcy;
    private CloudMusicData.MusicTagList mcz;
    private int tagId = 0;
    private int gvX = 1;
    private CustomMessageListener mcA = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.mcx != null) {
                CloudMusicListFragment.this.mcx.notifyDataSetChanged();
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
        this.mcz = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.iTZ = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.mcx = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.iTZ.setAdapter((ListAdapter) this.mcx);
        this.iTZ.setExOnSrollToBottomListener(this);
        this.iTZ.setDivider(null);
        this.mcx.a(this);
        this.fsC = new PbListView(getPageContext().getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fsC.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.mF(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.mcz != null && this.mcy != null && this.mcz.page != null) {
            this.tagId = this.mcz.tag_id;
            this.gvX = this.mcz.page.has_more;
            this.mcy.c(this.mcz);
        }
        this.iTZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.mcy.a(CloudMusicListFragment.this.mcx.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.mcA);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.mcy != null && this.gvX != 0) {
            this.mcy.Gt(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fsC.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.mcy = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.mcz = musicTagList;
        if (this.mcx != null) {
            this.mcx.ff(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vL(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dpI() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.iTZ.setNextPage(this.fsC);
            }
            this.fsC.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fsC.endLoadData();
        }
        this.gvX = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vM(boolean z) {
        if (this.fsC != null) {
            if (z) {
                if (this.fsC.getView().getParent() == null) {
                    this.iTZ.setNextPage(this.fsC);
                }
                this.fsC.showLoadingViewWithoutEmptyView();
                this.fsC.startLoadData();
                return;
            }
            this.fsC.endLoadData();
            this.iTZ.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Gq(int i) {
        this.mcx.ae(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Gr(int i) {
        this.mcx.ae(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Gs(int i) {
        this.mcx.ae(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mcy.daG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mcy != null) {
            this.mcy.ceq();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dpP().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.mcx != null && this.mcx.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.mcx.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
