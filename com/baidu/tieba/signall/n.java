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
import com.baidu.tbadk.core.util.al;
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
    private boolean cAB;
    private SignAllForumActivity cAG;
    private c cAp;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ab> cAH = new HashMap<>();
    private boolean aQA = true;

    public n(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.cAG = signAllForumActivity;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.cAp = cVar;
            this.mDatas = cVar.amN();
            if (this.mDatas.size() == 0) {
                this.aQA = false;
            } else {
                this.aQA = true;
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
        if (this.aQA) {
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

    private View jw(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.cAG.getPageContext().getPageActivity()).inflate(i.g.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.cAN = (BarImageView) inflate.findViewById(i.f.signallforum_item_avatar);
            bVar.cAN.setIsRound(false);
            bVar.cAN.setGifIconSupport(false);
            bVar.cAP = (TextView) inflate.findViewById(i.f.signallforum_item_name);
            bVar.cAQ = (ImageView) inflate.findViewById(i.f.signallforum_item_level);
            bVar.cAR = (TextView) inflate.findViewById(i.f.signallforum_item_exp);
            bVar.cAS = (FrameLayout) inflate.findViewById(i.f.signallforum_item_res_container);
            bVar.cAT = (TextView) inflate.findViewById(i.f.signallforum_item_days);
            bVar.cAU = (RelativeLayout) inflate.findViewById(i.f.signallforum_item_resign_container);
            bVar.cAV = (ImageView) inflate.findViewById(i.f.signallforum_item_resign_icon);
            bVar.cAW = (ProgressBar) inflate.findViewById(i.f.signallforum_item_resign_progress);
            bVar.cAX = (TextView) inflate.findViewById(i.f.signallforum_item_resign_text);
            bVar.cAY = (TextView) inflate.findViewById(i.f.signallforum_item_error);
            bVar.cAO = (LinearLayout) inflate.findViewById(i.f.signallforum_item_level_container);
            bVar.cAZ = (TextView) inflate.findViewById(i.f.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.cAG.getPageContext().getPageActivity()).inflate(i.g.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.cAL = (TextView) inflate2.findViewById(i.f.signallforum_head_title);
        aVar.cAM = (TextView) inflate2.findViewById(i.f.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.cAG.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cAG.getLayoutMode().k(view);
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
            bVar.cAP.setText(str);
            al.c(bVar.cAQ, com.baidu.tbadk.core.util.c.cc(eVar.ana()));
            bVar.cAR.setText(String.valueOf(eVar.anb()) + "/" + eVar.anc());
            bVar.cAZ.clearAnimation();
            if (eVar.and()) {
                bVar.cAO.setVisibility(0);
                bVar.cAY.setVisibility(8);
                bVar.cAT.setVisibility(0);
                bVar.cAU.setVisibility(8);
                bVar.cAT.setText(String.format(this.cAG.getPageContext().getString(i.C0057i.signallforum_days), Integer.valueOf(eVar.amZ())));
                if (eVar.anh()) {
                    bVar.cAR.setText(this.cAG.getPageContext().getString(i.C0057i.signallforum_uplevel));
                    bVar.cAZ.setVisibility(8);
                } else {
                    bVar.cAR.setText(String.valueOf(eVar.anb()) + "/" + eVar.anc());
                    bVar.cAZ.setVisibility(0);
                }
                int ang = eVar.ang();
                if (ang > 0) {
                    bVar.cAZ.setVisibility(0);
                    bVar.cAZ.setText("+" + ang);
                } else {
                    bVar.cAZ.setVisibility(8);
                }
            } else if (eVar.ane()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.cAO.setVisibility(8);
                    bVar.cAY.setVisibility(0);
                    bVar.cAZ.setVisibility(8);
                    bVar.cAY.setText(errorMsg);
                } else {
                    bVar.cAO.setVisibility(0);
                    bVar.cAY.setVisibility(8);
                    bVar.cAZ.setVisibility(8);
                }
                bVar.cAT.setVisibility(8);
                bVar.cAU.setVisibility(0);
                if (eVar.anf()) {
                    bVar.cAV.setVisibility(4);
                    bVar.cAW.setVisibility(0);
                    bVar.cAX.setText(i.C0057i.signallforum_resigning);
                } else {
                    bVar.cAV.setVisibility(0);
                    bVar.cAW.setVisibility(4);
                    bVar.cAX.setText(i.C0057i.signallforum_resign);
                }
                bVar.cAU.setOnClickListener(new o(this, eVar, bVar));
            } else {
                bVar.cAT.setVisibility(8);
                bVar.cAU.setVisibility(8);
                bVar.cAZ.setVisibility(8);
                bVar.cAO.setVisibility(0);
                bVar.cAY.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.cAN.setTag(avatar);
            bVar.cAN.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aQA) {
            return Ko();
        }
        int itemViewType = getItemViewType(i);
        View jw = view == null ? jw(itemViewType) : view;
        if (itemViewType == 1) {
            if (jw.getTag() != null && (jw.getTag() instanceof a)) {
                view2 = jw;
                aVar = (a) jw.getTag();
            } else {
                View jw2 = jw(itemViewType);
                view2 = jw2;
                aVar = (a) jw2.getTag();
            }
            this.cAG.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.cAG.getLayoutMode().k(view2.findViewById(i.f.sign_all_forum_tip));
            aVar.cAL.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            p(aVar.cAM, i);
            return view2;
        }
        if (jw.getTag() == null || !(jw.getTag() instanceof b)) {
            jw = jw(itemViewType);
        }
        a(jw, viewGroup, i);
        return jw;
    }

    private void p(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.cAp == null ? 7 : this.cAp.getLevel();
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
                    if (next.ana() >= level) {
                        if (next.and()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.and()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.cAG.getPageContext().getString(i.C0057i.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.cAG.getPageContext().getString(i.C0057i.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Ko() {
        View inflate = LayoutInflater.from(this.cAG.getPageContext().getPageActivity()).inflate(i.g.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.u a2 = NoDataViewFactory.a(this.cAG.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(i.f.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(i.C0057i.sign_all_forum_nodata_tip, i.C0057i.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cAG.getLayoutMode().ad(skinType == 1);
        this.cAG.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.cAG.getPageContext(), skinType);
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
        public BarImageView cAN;
        public LinearLayout cAO;
        public TextView cAP;
        public ImageView cAQ;
        public TextView cAR;
        public FrameLayout cAS;
        public TextView cAT;
        public RelativeLayout cAU;
        public ImageView cAV;
        public ProgressBar cAW;
        public TextView cAX;
        public TextView cAY;
        public TextView cAZ;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView cAL;
        public TextView cAM;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.cAH.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab.a
    public void aZ(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.cAG.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.cAH.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.fk(z);
                eVar.fl(!z);
                eVar.fm(false);
                if (z) {
                    eVar.jt(signData.getCountSignNum());
                    eVar.jv(signData.getBonusPoint());
                    eVar.js(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> amQ = this.cAp.amQ();
                    if (amQ.contains(eVar)) {
                        amQ.remove(eVar);
                        this.cAp.amP().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.cAB) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void ank() {
        this.cAB = true;
        synchronized (this) {
            for (Map.Entry<String, ab> entry : this.cAH.entrySet()) {
                entry.getValue().anB();
            }
            this.cAH.clear();
        }
    }
}
