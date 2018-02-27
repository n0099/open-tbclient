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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView caY;
    private BdListView eyB;
    private com.baidu.tieba.video.cloudmusic.a.a hom;
    private e.a hon;
    private CloudMusicData.MusicTagList hoo;
    private h mNoDataView;
    private int tagId = 0;
    private int dcM = 1;
    private CustomMessageListener hop = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.hom != null) {
                a.this.hom.notifyDataSetChanged();
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
        this.hoo = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eyB = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hom = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eyB.setAdapter((ListAdapter) this.hom);
        this.eyB.setExOnSrollToBottomListener(this);
        this.eyB.setDivider(null);
        this.hom.a(this);
        this.caY = new PbListView(getPageContext().getPageActivity());
        this.caY.st();
        this.caY.gw(d.C0141d.cp_bg_line_d);
        this.caY.gx(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.gp(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hoo != null && this.hon != null && this.hoo.page != null) {
            this.tagId = this.hoo.tag_id;
            this.dcM = this.hoo.page.has_more;
            this.hon.c(this.hoo);
        }
        this.eyB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.oJ()) {
                    a.this.hon.a(a.this.hom.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hop);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.oJ()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hon != null && this.dcM != 0) {
            this.hon.wJ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.caY.gx(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.hon = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hoo = musicTagList;
        if (this.hom != null) {
            this.hom.dH(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nj(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bAQ() {
        if (this.caY != null) {
            if (this.caY.getView().getParent() == null) {
                this.eyB.setNextPage(this.caY);
            }
            this.caY.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.caY.Eg();
        }
        this.dcM = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nk(boolean z) {
        if (this.caY != null) {
            if (z) {
                if (this.caY.getView().getParent() == null) {
                    this.eyB.setNextPage(this.caY);
                }
                this.caY.Ej();
                this.caY.Ef();
                return;
            }
            this.caY.Eg();
            this.eyB.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wG(int i) {
        this.hom.U(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wH(int i) {
        this.hom.U(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wI(int i) {
        this.hom.U(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hon.bnc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hon != null) {
            this.hon.awO();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAX().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hom != null && this.hom.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hom.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
