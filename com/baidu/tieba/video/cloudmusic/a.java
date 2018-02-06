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
    private PbListView cbk;
    private BdListView eyN;
    private e.a hoA;
    private CloudMusicData.MusicTagList hoB;
    private com.baidu.tieba.video.cloudmusic.a.a hoz;
    private h mNoDataView;
    private int tagId = 0;
    private int dcY = 1;
    private CustomMessageListener hoC = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.hoz != null) {
                a.this.hoz.notifyDataSetChanged();
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
        this.hoB = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eyN = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hoz = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eyN.setAdapter((ListAdapter) this.hoz);
        this.eyN.setExOnSrollToBottomListener(this);
        this.eyN.setDivider(null);
        this.hoz.a(this);
        this.cbk = new PbListView(getPageContext().getPageActivity());
        this.cbk.st();
        this.cbk.gw(d.C0140d.cp_bg_line_d);
        this.cbk.gx(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.gp(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hoB != null && this.hoA != null && this.hoB.page != null) {
            this.tagId = this.hoB.tag_id;
            this.dcY = this.hoB.page.has_more;
            this.hoA.c(this.hoB);
        }
        this.eyN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.oJ()) {
                    a.this.hoA.a(a.this.hoz.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hoC);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.oJ()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hoA != null && this.dcY != 0) {
            this.hoA.wI(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.cbk.gx(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.hoA = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hoB = musicTagList;
        if (this.hoz != null) {
            this.hoz.dH(musicTagList.music_list);
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
    public void bAR() {
        if (this.cbk != null) {
            if (this.cbk.getView().getParent() == null) {
                this.eyN.setNextPage(this.cbk);
            }
            this.cbk.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.cbk.Eh();
        }
        this.dcY = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nk(boolean z) {
        if (this.cbk != null) {
            if (z) {
                if (this.cbk.getView().getParent() == null) {
                    this.eyN.setNextPage(this.cbk);
                }
                this.cbk.Ek();
                this.cbk.Eg();
                return;
            }
            this.cbk.Eh();
            this.eyN.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wF(int i) {
        this.hoz.U(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wG(int i) {
        this.hoz.U(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wH(int i) {
        this.hoz.U(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hoA.bnd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hoA != null) {
            this.hoA.awP();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAY().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hoz != null && this.hoz.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hoz.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
