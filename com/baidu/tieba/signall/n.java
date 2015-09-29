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
import com.baidu.tbadk.core.util.am;
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
    private c cPI;
    private boolean cPU;
    private SignAllForumActivity cPZ;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ab> cQa = new HashMap<>();
    private boolean aPK = true;

    public n(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cPZ = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cPI = cVar;
            this.mDatas = cVar.atk();
            if (this.mDatas.size() == 0) {
                this.aPK = false;
            } else {
                this.aPK = true;
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
        if (this.aPK) {
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

    private View kF(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.cPZ.getPageContext().getPageActivity()).inflate(i.g.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.cQg = (BarImageView) inflate.findViewById(i.f.signallforum_item_avatar);
            bVar.cQg.setIsRound(false);
            bVar.cQg.setGifIconSupport(false);
            bVar.cQi = (TextView) inflate.findViewById(i.f.signallforum_item_name);
            bVar.cQj = (ImageView) inflate.findViewById(i.f.signallforum_item_level);
            bVar.cQk = (TextView) inflate.findViewById(i.f.signallforum_item_exp);
            bVar.cQl = (FrameLayout) inflate.findViewById(i.f.signallforum_item_res_container);
            bVar.cQm = (TextView) inflate.findViewById(i.f.signallforum_item_days);
            bVar.cQn = (RelativeLayout) inflate.findViewById(i.f.signallforum_item_resign_container);
            bVar.cQo = (ImageView) inflate.findViewById(i.f.signallforum_item_resign_icon);
            bVar.cQp = (ProgressBar) inflate.findViewById(i.f.signallforum_item_resign_progress);
            bVar.cQq = (TextView) inflate.findViewById(i.f.signallforum_item_resign_text);
            bVar.cQr = (TextView) inflate.findViewById(i.f.signallforum_item_error);
            bVar.cQh = (LinearLayout) inflate.findViewById(i.f.signallforum_item_level_container);
            bVar.cQs = (TextView) inflate.findViewById(i.f.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.cPZ.getPageContext().getPageActivity()).inflate(i.g.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.cQe = (TextView) inflate2.findViewById(i.f.signallforum_head_title);
        aVar.cQf = (TextView) inflate2.findViewById(i.f.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cPZ.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cPZ.getLayoutMode().k(view);
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
            bVar.cQi.setText(str);
            am.c(bVar.cQj, com.baidu.tbadk.core.util.c.ci(eVar.atx()));
            bVar.cQk.setText(String.valueOf(eVar.aty()) + "/" + eVar.atz());
            bVar.cQs.clearAnimation();
            if (eVar.atA()) {
                bVar.cQh.setVisibility(0);
                bVar.cQr.setVisibility(8);
                bVar.cQm.setVisibility(0);
                bVar.cQn.setVisibility(8);
                bVar.cQm.setText(String.format(this.cPZ.getPageContext().getString(i.h.signallforum_days), Integer.valueOf(eVar.atw())));
                if (eVar.atE()) {
                    bVar.cQk.setText(this.cPZ.getPageContext().getString(i.h.signallforum_uplevel));
                    bVar.cQs.setVisibility(8);
                } else {
                    bVar.cQk.setText(String.valueOf(eVar.aty()) + "/" + eVar.atz());
                    bVar.cQs.setVisibility(0);
                }
                int atD = eVar.atD();
                if (atD > 0) {
                    bVar.cQs.setVisibility(0);
                    bVar.cQs.setText("+" + atD);
                } else {
                    bVar.cQs.setVisibility(8);
                }
            } else if (eVar.atB()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.cQh.setVisibility(8);
                    bVar.cQr.setVisibility(0);
                    bVar.cQs.setVisibility(8);
                    bVar.cQr.setText(errorMsg);
                } else {
                    bVar.cQh.setVisibility(0);
                    bVar.cQr.setVisibility(8);
                    bVar.cQs.setVisibility(8);
                }
                bVar.cQm.setVisibility(8);
                bVar.cQn.setVisibility(0);
                if (eVar.atC()) {
                    bVar.cQo.setVisibility(4);
                    bVar.cQp.setVisibility(0);
                    bVar.cQq.setText(i.h.signallforum_resigning);
                } else {
                    bVar.cQo.setVisibility(0);
                    bVar.cQp.setVisibility(4);
                    bVar.cQq.setText(i.h.signallforum_resign);
                }
                bVar.cQn.setOnClickListener(new o(this, eVar, bVar));
            } else {
                bVar.cQm.setVisibility(8);
                bVar.cQn.setVisibility(8);
                bVar.cQs.setVisibility(8);
                bVar.cQh.setVisibility(0);
                bVar.cQr.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.cQg.setTag(avatar);
            bVar.cQg.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aPK) {
            return JX();
        }
        int itemViewType = getItemViewType(i);
        View kF = view == null ? kF(itemViewType) : view;
        if (itemViewType == 1) {
            if (kF.getTag() != null && (kF.getTag() instanceof a)) {
                view2 = kF;
                aVar = (a) kF.getTag();
            } else {
                View kF2 = kF(itemViewType);
                view2 = kF2;
                aVar = (a) kF2.getTag();
            }
            this.cPZ.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cPZ.getLayoutMode().k(view2.findViewById(i.f.sign_all_forum_tip));
            aVar.cQe.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            q(aVar.cQf, i);
            return view2;
        }
        if (kF.getTag() == null || !(kF.getTag() instanceof b)) {
            kF = kF(itemViewType);
        }
        a(kF, viewGroup, i);
        return kF;
    }

    private void q(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cPI == null ? 7 : this.cPI.getLevel();
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
                    if (next.atx() >= level) {
                        if (next.atA()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.atA()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cPZ.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cPZ.getPageContext().getString(i.h.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View JX() {
        View inflate = LayoutInflater.from(this.cPZ.getPageContext().getPageActivity()).inflate(i.g.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.m a2 = NoDataViewFactory.a(this.cPZ.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(i.f.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(i.h.sign_all_forum_nodata_tip, i.h.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cPZ.getLayoutMode().ad(skinType == 1);
        this.cPZ.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.cPZ.getPageContext(), skinType);
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
        public BarImageView cQg;
        public LinearLayout cQh;
        public TextView cQi;
        public ImageView cQj;
        public TextView cQk;
        public FrameLayout cQl;
        public TextView cQm;
        public RelativeLayout cQn;
        public ImageView cQo;
        public ProgressBar cQp;
        public TextView cQq;
        public TextView cQr;
        public TextView cQs;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView cQe;
        public TextView cQf;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.cQa.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void bd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.cPZ.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cQa.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.gg(z);
                eVar.gh(!z);
                eVar.gi(false);
                if (z) {
                    eVar.kC(signData.getCountSignNum());
                    eVar.kE(signData.getBonusPoint());
                    eVar.kB(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> atn = this.cPI.atn();
                    if (atn.contains(eVar)) {
                        atn.remove(eVar);
                        this.cPI.atm().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cPU) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void atH() {
        this.cPU = true;
        synchronized (this) {
            for (Map.Entry<String, ab> entry : this.cQa.entrySet()) {
                entry.getValue().atY();
            }
            this.cQa.clear();
        }
    }
}
