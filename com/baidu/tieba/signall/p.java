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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.ag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements AbsListView.OnScrollListener, ag.a {
    private boolean dxA;
    private SignAllForumActivity dxH;
    private c dxm;
    private ArrayList<e> mDatas = new ArrayList<>();
    private HashMap<String, ag> dxI = new HashMap<>();
    private boolean aZg = true;

    public p(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.dxH = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.dxm = cVar;
            this.mDatas = cVar.aBB();
            if (this.mDatas.size() == 0) {
                this.aZg = false;
            } else {
                this.aZg = true;
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
        if (this.aZg) {
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

    private View mF(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.dxH.getPageContext().getPageActivity()).inflate(n.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.dxO = (BarImageView) inflate.findViewById(n.g.signallforum_item_avatar);
            bVar.dxO.setIsRound(false);
            bVar.dxO.setGifIconSupport(false);
            bVar.dxQ = (TextView) inflate.findViewById(n.g.signallforum_item_name);
            bVar.dxR = (ImageView) inflate.findViewById(n.g.signallforum_item_level);
            bVar.dxS = (TextView) inflate.findViewById(n.g.signallforum_item_exp);
            bVar.dxT = (FrameLayout) inflate.findViewById(n.g.signallforum_item_res_container);
            bVar.dxU = (TextView) inflate.findViewById(n.g.signallforum_item_days);
            bVar.dxV = (RelativeLayout) inflate.findViewById(n.g.signallforum_item_resign_container);
            bVar.dxW = (ImageView) inflate.findViewById(n.g.signallforum_item_resign_icon);
            bVar.dxX = (ProgressBar) inflate.findViewById(n.g.signallforum_item_resign_progress);
            bVar.dxY = (TextView) inflate.findViewById(n.g.signallforum_item_resign_text);
            bVar.dxZ = (TextView) inflate.findViewById(n.g.signallforum_item_error);
            bVar.dxP = (LinearLayout) inflate.findViewById(n.g.signallforum_item_level_container);
            bVar.dya = (TextView) inflate.findViewById(n.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.dxH.getPageContext().getPageActivity()).inflate(n.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.dxM = (TextView) inflate2.findViewById(n.g.signallforum_head_title);
        aVar.dxN = (TextView) inflate2.findViewById(n.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.dxH.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dxH.getLayoutMode().k(view);
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
            bVar.dxQ.setText(str);
            as.c(bVar.dxR, com.baidu.tbadk.core.util.c.cj(eVar.Sa()));
            bVar.dxS.setText(String.valueOf(eVar.aBO()) + "/" + eVar.aBP());
            bVar.dya.clearAnimation();
            if (eVar.aBQ()) {
                bVar.dxP.setVisibility(0);
                bVar.dxZ.setVisibility(8);
                bVar.dxU.setVisibility(0);
                bVar.dxV.setVisibility(8);
                bVar.dxU.setText(String.format(this.dxH.getPageContext().getString(n.j.signallforum_days), Integer.valueOf(eVar.aBN())));
                if (eVar.aBU()) {
                    bVar.dxS.setText(this.dxH.getPageContext().getString(n.j.signallforum_uplevel));
                    bVar.dya.setVisibility(8);
                } else {
                    bVar.dxS.setText(String.valueOf(eVar.aBO()) + "/" + eVar.aBP());
                    bVar.dya.setVisibility(0);
                }
                int aBT = eVar.aBT();
                if (aBT > 0) {
                    bVar.dya.setVisibility(0);
                    bVar.dya.setText("+" + aBT);
                } else {
                    bVar.dya.setVisibility(8);
                }
            } else if (eVar.aBR()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.dxP.setVisibility(8);
                    bVar.dxZ.setVisibility(0);
                    bVar.dya.setVisibility(8);
                    bVar.dxZ.setText(errorMsg);
                } else {
                    bVar.dxP.setVisibility(0);
                    bVar.dxZ.setVisibility(8);
                    bVar.dya.setVisibility(8);
                }
                bVar.dxU.setVisibility(8);
                bVar.dxV.setVisibility(0);
                if (eVar.aBS()) {
                    bVar.dxW.setVisibility(4);
                    bVar.dxX.setVisibility(0);
                    bVar.dxY.setText(n.j.signallforum_resigning);
                } else {
                    bVar.dxW.setVisibility(0);
                    bVar.dxX.setVisibility(4);
                    bVar.dxY.setText(n.j.signallforum_resign);
                }
                bVar.dxV.setOnClickListener(new q(this, eVar, bVar));
            } else {
                bVar.dxU.setVisibility(8);
                bVar.dxV.setVisibility(8);
                bVar.dya.setVisibility(8);
                bVar.dxP.setVisibility(0);
                bVar.dxZ.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.dxO.setTag(avatar);
            bVar.dxO.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.aZg) {
            return LW();
        }
        int itemViewType = getItemViewType(i);
        View mF = view == null ? mF(itemViewType) : view;
        if (itemViewType == 1) {
            if (mF.getTag() != null && (mF.getTag() instanceof a)) {
                view2 = mF;
                aVar = (a) mF.getTag();
            } else {
                View mF2 = mF(itemViewType);
                view2 = mF2;
                aVar = (a) mF2.getTag();
            }
            this.dxH.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.dxH.getLayoutMode().k(view2.findViewById(n.g.sign_all_forum_tip));
            aVar.dxM.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            u(aVar.dxN, i);
            return view2;
        }
        if (mF.getTag() == null || !(mF.getTag() instanceof b)) {
            mF = mF(itemViewType);
        }
        a(mF, viewGroup, i);
        return mF;
    }

    private void u(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.dxm == null ? 7 : this.dxm.getLevel();
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
                    if (next.Sa() >= level) {
                        if (next.aBQ()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aBQ()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.dxH.getPageContext().getString(n.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.dxH.getPageContext().getString(n.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View LW() {
        View inflate = LayoutInflater.from(this.dxH.getPageContext().getPageActivity()).inflate(n.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.o a2 = NoDataViewFactory.a(this.dxH.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(n.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(n.j.sign_all_forum_nodata_tip, n.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.dxH.getLayoutMode().ac(skinType == 1);
        this.dxH.getLayoutMode().k(inflate);
        a2.onChangeSkinType(this.dxH.getPageContext(), skinType);
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
        public BarImageView dxO;
        public LinearLayout dxP;
        public TextView dxQ;
        public ImageView dxR;
        public TextView dxS;
        public FrameLayout dxT;
        public TextView dxU;
        public RelativeLayout dxV;
        public ImageView dxW;
        public ProgressBar dxX;
        public TextView dxY;
        public TextView dxZ;
        public TextView dya;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView dxM;
        public TextView dxN;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ag.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.dxI.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ag.a
    public void bb(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.dxH.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.dxI.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.mDatas.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.mDatas.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.hh(z);
                eVar.hi(!z);
                eVar.hj(false);
                if (z) {
                    eVar.mD(signData.getCountSignNum());
                    eVar.mE(signData.getBonusPoint());
                    eVar.mC(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aBE = this.dxm.aBE();
                    if (aBE.contains(eVar)) {
                        aBE.remove(eVar);
                        this.dxm.aBD().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.dxA) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aBY() {
        this.dxA = true;
        synchronized (this) {
            for (Map.Entry<String, ag> entry : this.dxI.entrySet()) {
                entry.getValue().aCq();
            }
            this.dxI.clear();
        }
    }
}
