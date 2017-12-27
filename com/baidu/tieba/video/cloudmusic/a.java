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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView bYK;
    private BdListView esG;
    private com.baidu.tieba.video.cloudmusic.a.a hxn;
    private e.a hxo;
    private CloudMusicData.MusicTagList hxp;
    private g mNoDataView;
    private int tagId = 0;
    private int cVn = 1;
    private CustomMessageListener hxq = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.hxn != null) {
                a.this.hxn.notifyDataSetChanged();
            }
        }
    };

    public static a a(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_cloud_music_list, viewGroup, false);
        this.hxp = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.esG = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hxn = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.esG.setAdapter((ListAdapter) this.hxn);
        this.esG.setExOnSrollToBottomListener(this);
        this.esG.setDivider(null);
        this.hxn.a(this);
        this.bYK = new PbListView(getPageContext().getPageActivity());
        this.bYK.su();
        this.bYK.gx(d.C0108d.cp_bg_line_d);
        this.bYK.gy(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.gp(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hxp != null && this.hxo != null && this.hxp.page != null) {
            this.tagId = this.hxp.tag_id;
            this.cVn = this.hxp.page.has_more;
            this.hxo.c(this.hxp);
        }
        this.esG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.oI()) {
                    a.this.hxo.a(a.this.hxn.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hxq);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.oI()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hxo != null && this.cVn != 0) {
            this.hxo.yh(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bYK.gy(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.hxo = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hxp = musicTagList;
        if (this.hxn != null) {
            this.hxn.dS(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nX(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bGI() {
        if (this.bYK != null) {
            if (this.bYK.getView().getParent() == null) {
                this.esG.setNextPage(this.bYK);
            }
            this.bYK.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.bYK.DU();
        }
        this.cVn = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nY(boolean z) {
        if (this.bYK != null) {
            if (z) {
                if (this.bYK.getView().getParent() == null) {
                    this.esG.setNextPage(this.bYK);
                }
                this.bYK.DX();
                this.bYK.DT();
                return;
            }
            this.bYK.DU();
            this.esG.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void ye(int i) {
        this.hxn.O(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void yf(int i) {
        this.hxn.O(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void yg(int i) {
        this.hxn.O(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hxo.bsw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hxo != null) {
            this.hxo.auK();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bGP().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hxn != null && this.hxn.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hxn.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
