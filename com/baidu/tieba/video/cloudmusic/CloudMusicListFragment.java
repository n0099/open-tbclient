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
    private BdListView iTX;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a mcv;
    private d.a mcw;
    private CloudMusicData.MusicTagList mcx;
    private int tagId = 0;
    private int gvX = 1;
    private CustomMessageListener mcy = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.mcv != null) {
                CloudMusicListFragment.this.mcv.notifyDataSetChanged();
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
        this.mcx = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.iTX = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.mcv = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.iTX.setAdapter((ListAdapter) this.mcv);
        this.iTX.setExOnSrollToBottomListener(this);
        this.iTX.setDivider(null);
        this.mcv.a(this);
        this.fsC = new PbListView(getPageContext().getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fsC.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.mF(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.mcx != null && this.mcw != null && this.mcx.page != null) {
            this.tagId = this.mcx.tag_id;
            this.gvX = this.mcx.page.has_more;
            this.mcw.c(this.mcx);
        }
        this.iTX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.mcw.a(CloudMusicListFragment.this.mcv.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.mcy);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.mcw != null && this.gvX != 0) {
            this.mcw.Gt(this.tagId);
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
        this.mcw = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.mcx = musicTagList;
        if (this.mcv != null) {
            this.mcv.ff(musicTagList.music_list);
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
    public void dpH() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.iTX.setNextPage(this.fsC);
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
                    this.iTX.setNextPage(this.fsC);
                }
                this.fsC.showLoadingViewWithoutEmptyView();
                this.fsC.startLoadData();
                return;
            }
            this.fsC.endLoadData();
            this.iTX.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Gq(int i) {
        this.mcv.ae(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Gr(int i) {
        this.mcv.ae(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Gs(int i) {
        this.mcv.ae(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mcw.daG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mcw != null) {
            this.mcw.ceq();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dpO().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.mcv != null && this.mcv.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.mcv.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
