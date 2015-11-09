package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends BaseAdapter implements AbsListView.OnScrollListener, ab.a {
    private c cRD;
    private boolean cRP;
    private SignAllForumActivity cRU;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ab> cRV = new HashMap<>();
    private boolean aQd = true;

    public n(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cRU = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cRD = cVar;
            this.mDatas = cVar.atS();
            if (this.mDatas.size() == 0) {
                this.aQd = false;
            } else {
                this.aQd = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aQd) {
            return this.mDatas.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mDatas.size() > i) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View kV(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.cRU.getPageContext().getPageActivity()).inflate(i.g.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.cSb = (BarImageView) inflate.findViewById(i.f.signallforum_item_avatar);
            bVar.cSb.setIsRound(false);
            bVar.cSb.setGifIconSupport(false);
            bVar.cSd = (TextView) inflate.findViewById(i.f.signallforum_item_name);
            bVar.cSe = (ImageView) inflate.findViewById(i.f.signallforum_item_level);
            bVar.cSf = (TextView) inflate.findViewById(i.f.signallforum_item_exp);
            bVar.cSg = (FrameLayout) inflate.findViewById(i.f.signallforum_item_res_container);
            bVar.cSh = (TextView) inflate.findViewById(i.f.signallforum_item_days);
            bVar.cSi = (RelativeLayout) inflate.findViewById(i.f.signallforum_item_resign_container);
            bVar.cSj = (ImageView) inflate.findViewById(i.f.signallforum_item_resign_icon);
            bVar.cSk = (ProgressBar) inflate.findViewById(i.f.signallforum_item_resign_progress);
            bVar.cSl = (TextView) inflate.findViewById(i.f.signallforum_item_resign_text);
            bVar.cSm = (TextView) inflate.findViewById(i.f.signallforum_item_error);
            bVar.cSc = (LinearLayout) inflate.findViewById(i.f.signallforum_item_level_container);
            bVar.cSn = (TextView) inflate.findViewById(i.f.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.cRU.getPageContext().getPageActivity()).inflate(i.g.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.cRZ = (TextView) inflate2.findViewById(i.f.signallforum_head_title);
        aVar.cSa = (TextView) inflate2.findViewById(i.f.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cRU.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cRU.getLayoutMode().k(view);
        b bVar = (b) view.getTag();
        e eVar = (e) getItem(i);
        if (eVar != null) {
            String forumName = eVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = String.valueOf(forumName.substring(0, i3)) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.cSd.setText(str);
            an.c(bVar.cSe, com.baidu.tbadk.core.util.c.ci(eVar.auf()));
            bVar.cSf.setText(String.valueOf(eVar.aug()) + "/" + eVar.auh());
            bVar.cSn.clearAnimation();
            if (eVar.aui()) {
                bVar.cSc.setVisibility(0);
                bVar.cSm.setVisibility(8);
                bVar.cSh.setVisibility(0);
                bVar.cSi.setVisibility(8);
                bVar.cSh.setText(String.format(this.cRU.getPageContext().getString(i.h.signallforum_days), Integer.valueOf(eVar.aue())));
                if (eVar.aum()) {
                    bVar.cSf.setText(this.cRU.getPageContext().getString(i.h.signallforum_uplevel));
                    bVar.cSn.setVisibility(8);
                } else {
                    bVar.cSf.setText(String.valueOf(eVar.aug()) + "/" + eVar.auh());
                    bVar.cSn.setVisibility(0);
                }
                int aul = eVar.aul();
                if (aul > 0) {
                    bVar.cSn.setVisibility(0);
                    bVar.cSn.setText("+" + aul);
                } else {
                    bVar.cSn.setVisibility(8);
                }
            } else if (eVar.auj()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.cSc.setVisibility(8);
                    bVar.cSm.setVisibility(0);
                    bVar.cSn.setVisibility(8);
                    bVar.cSm.setText(errorMsg);
                } else {
                    bVar.cSc.setVisibility(0);
                    bVar.cSm.setVisibility(8);
                    bVar.cSn.setVisibility(8);
                }
                bVar.cSh.setVisibility(8);
                bVar.cSi.setVisibility(0);
                if (eVar.auk()) {
                    bVar.cSj.setVisibility(4);
                    bVar.cSk.setVisibility(0);
                    bVar.cSl.setText(i.h.signallforum_resigning);
                } else {
                    bVar.cSj.setVisibility(0);
                    bVar.cSk.setVisibility(4);
                    bVar.cSl.setText(i.h.signallforum_resign);
                }
                bVar.cSi.setOnClickListener(new o(this, eVar, bVar));
            } else {
                bVar.cSh.setVisibility(8);
                bVar.cSi.setVisibility(8);
                bVar.cSn.setVisibility(8);
                bVar.cSc.setVisibility(0);
                bVar.cSm.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.cSb.setTag(avatar);
            bVar.cSb.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aQd) {
            return Kj();
        }
        int itemViewType = getItemViewType(i);
        View kV = view == null ? kV(itemViewType) : view;
        if (itemViewType == 1) {
            if (kV.getTag() != null && (kV.getTag() instanceof a)) {
                view2 = kV;
                aVar = (a) kV.getTag();
            } else {
                View kV2 = kV(itemViewType);
                view2 = kV2;
                aVar = (a) kV2.getTag();
            }
            this.cRU.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cRU.getLayoutMode().k(view2.findViewById(i.f.sign_all_forum_tip));
            aVar.cRZ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            q(aVar.cSa, i);
            return view2;
        }
        if (kV.getTag() == null || !(kV.getTag() instanceof b)) {
            kV = kV(itemViewType);
        }
        a(kV, viewGroup, i);
        return kV;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cRD == null ? 7 : this.cRD.getLevel();
        if (this.mDatas == null || this.mDatas.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.mDatas.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.auf() >= level) {
                        if (next.aui()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aui()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cRU.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cRU.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Kj() {
        View inflate = LayoutInflater.from(this.cRU.getPageContext().getPageActivity()).inflate(i.g.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.m a2 = NoDataViewFactory.a(this.cRU.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(i.f.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(i.h.sign_all_forum_nodata_tip, i.h.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cRU.getLayoutMode().ad(skinType == 1);
        this.cRU.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.cRU.getPageContext(), skinType);
        a2.setVisibility(0);
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {
        public BarImageView cSb;
        public LinearLayout cSc;
        public TextView cSd;
        public ImageView cSe;
        public TextView cSf;
        public FrameLayout cSg;
        public TextView cSh;
        public RelativeLayout cSi;
        public ImageView cSj;
        public ProgressBar cSk;
        public TextView cSl;
        public TextView cSm;
        public TextView cSn;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView cRZ;
        public TextView cSa;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.cRV.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void bc(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.cRU.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cRV.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.gj(z);
                eVar.gk(!z);
                eVar.gl(false);
                if (z) {
                    eVar.kS(signData.getCountSignNum());
                    eVar.kU(signData.getBonusPoint());
                    eVar.kR(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> atV = this.cRD.atV();
                    if (atV.contains(eVar)) {
                        atV.remove(eVar);
                        this.cRD.atU().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cRP) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aup() {
        this.cRP = true;
        synchronized (this) {
            for (Map.Entry<String, ab> entry : this.cRV.entrySet()) {
                entry.getValue().auG();
            }
            this.cRV.clear();
        }
    }
}
