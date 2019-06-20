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
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dlY;
    private BdListView gvu;
    private com.baidu.tieba.video.cloudmusic.a.a joe;
    private d.a jof;
    private CloudMusicData.MusicTagList jog;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eDJ = 1;
    private CustomMessageListener joh = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.joe != null) {
                CloudMusicListFragment.this.joe.notifyDataSetChanged();
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
        this.jog = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gvu = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.joe = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gvu.setAdapter((ListAdapter) this.joe);
        this.gvu.setExOnSrollToBottomListener(this);
        this.gvu.setDivider(null);
        this.joe.a(this);
        this.dlY = new PbListView(getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.iO(R.color.cp_bg_line_d);
        this.dlY.iP(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iH(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.jog != null && this.jof != null && this.jog.page != null) {
            this.tagId = this.jog.tag_id;
            this.eDJ = this.jog.page.has_more;
            this.jof.c(this.jog);
        }
        this.gvu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jS()) {
                    CloudMusicListFragment.this.jof.a(CloudMusicListFragment.this.joe.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.joh);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jS()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.jof != null && this.eDJ != 0) {
            this.jof.Bx(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dlY.iP(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.jof = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.jog = musicTagList;
        if (this.joe != null) {
            this.joe.el(musicTagList.music_list);
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
    public void crb() {
        if (this.dlY != null) {
            if (this.dlY.getView().getParent() == null) {
                this.gvu.setNextPage(this.dlY);
            }
            this.dlY.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dlY.ajz();
        }
        this.eDJ = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rq(boolean z) {
        if (this.dlY != null) {
            if (z) {
                if (this.dlY.getView().getParent() == null) {
                    this.gvu.setNextPage(this.dlY);
                }
                this.dlY.ajE();
                this.dlY.ajy();
                return;
            }
            this.dlY.ajz();
            this.gvu.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bu(int i) {
        this.joe.Q(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bv(int i) {
        this.joe.Q(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bw(int i) {
        this.joe.Q(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jof.cdv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jof != null) {
            this.jof.bmr();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cri().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.joe != null && this.joe.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.joe.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
