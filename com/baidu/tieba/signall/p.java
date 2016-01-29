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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.signall.ah;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements AbsListView.OnScrollListener, ah.a {
    private boolean dNE;
    private SignAllForumActivity dNL;
    private c dNq;
    private ArrayList<e> aUW = new ArrayList<>();
    private HashMap<String, ah> dNM = new HashMap<>();
    private boolean bbv = true;

    public p(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.dNL = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.dNq = cVar;
            this.aUW = cVar.aII();
            if (this.aUW.size() == 0) {
                this.bbv = false;
            } else {
                this.bbv = true;
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
        if (this.bbv) {
            return this.aUW.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aUW.size() > i) {
            return this.aUW.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View nR(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.dNL.getPageContext().getPageActivity()).inflate(t.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.dNS = (BarImageView) inflate.findViewById(t.g.signallforum_item_avatar);
            bVar.dNS.setIsRound(false);
            bVar.dNS.setGifIconSupport(false);
            bVar.dNU = (TextView) inflate.findViewById(t.g.signallforum_item_name);
            bVar.dNV = (ImageView) inflate.findViewById(t.g.signallforum_item_level);
            bVar.dNW = (TextView) inflate.findViewById(t.g.signallforum_item_exp);
            bVar.dNX = (FrameLayout) inflate.findViewById(t.g.signallforum_item_res_container);
            bVar.dNY = (TextView) inflate.findViewById(t.g.signallforum_item_days);
            bVar.dNZ = (RelativeLayout) inflate.findViewById(t.g.signallforum_item_resign_container);
            bVar.dOa = (ImageView) inflate.findViewById(t.g.signallforum_item_resign_icon);
            bVar.dOb = (ProgressBar) inflate.findViewById(t.g.signallforum_item_resign_progress);
            bVar.dOc = (TextView) inflate.findViewById(t.g.signallforum_item_resign_text);
            bVar.dOd = (TextView) inflate.findViewById(t.g.signallforum_item_error);
            bVar.dNT = (LinearLayout) inflate.findViewById(t.g.signallforum_item_level_container);
            bVar.dOe = (TextView) inflate.findViewById(t.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.dNL.getPageContext().getPageActivity()).inflate(t.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.dNQ = (TextView) inflate2.findViewById(t.g.signallforum_head_title);
        aVar.dNR = (TextView) inflate2.findViewById(t.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.dNL.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dNL.getLayoutMode().x(view);
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
            bVar.dNU.setText(str);
            ar.c(bVar.dNV, BitmapHelper.getSmallGradeResourceIdNew(eVar.getUserLevel()));
            bVar.dNW.setText(String.valueOf(eVar.aIV()) + "/" + eVar.aIW());
            bVar.dOe.clearAnimation();
            if (eVar.aIX()) {
                bVar.dNT.setVisibility(0);
                bVar.dOd.setVisibility(8);
                bVar.dNY.setVisibility(0);
                bVar.dNZ.setVisibility(8);
                bVar.dNY.setText(String.format(this.dNL.getPageContext().getString(t.j.signallforum_days), Integer.valueOf(eVar.aIU())));
                if (eVar.aJb()) {
                    bVar.dNW.setText(this.dNL.getPageContext().getString(t.j.signallforum_uplevel));
                    bVar.dOe.setVisibility(8);
                } else {
                    bVar.dNW.setText(String.valueOf(eVar.aIV()) + "/" + eVar.aIW());
                    bVar.dOe.setVisibility(0);
                }
                int aJa = eVar.aJa();
                if (aJa > 0) {
                    bVar.dOe.setVisibility(0);
                    bVar.dOe.setText("+" + aJa);
                } else {
                    bVar.dOe.setVisibility(8);
                }
            } else if (eVar.aIY()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.dNT.setVisibility(8);
                    bVar.dOd.setVisibility(0);
                    bVar.dOe.setVisibility(8);
                    bVar.dOd.setText(errorMsg);
                } else {
                    bVar.dNT.setVisibility(0);
                    bVar.dOd.setVisibility(8);
                    bVar.dOe.setVisibility(8);
                }
                bVar.dNY.setVisibility(8);
                bVar.dNZ.setVisibility(0);
                if (eVar.aIZ()) {
                    bVar.dOa.setVisibility(4);
                    bVar.dOb.setVisibility(0);
                    bVar.dOc.setText(t.j.signallforum_resigning);
                } else {
                    bVar.dOa.setVisibility(0);
                    bVar.dOb.setVisibility(4);
                    bVar.dOc.setText(t.j.signallforum_resign);
                }
                bVar.dNZ.setOnClickListener(new q(this, eVar, bVar));
            } else {
                bVar.dNY.setVisibility(8);
                bVar.dNZ.setVisibility(8);
                bVar.dOe.setVisibility(8);
                bVar.dNT.setVisibility(0);
                bVar.dOd.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.dNS.setTag(avatar);
            bVar.dNS.d(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.bbv) {
            return NP();
        }
        int itemViewType = getItemViewType(i);
        View nR = view == null ? nR(itemViewType) : view;
        if (itemViewType == 1) {
            if (nR.getTag() != null && (nR.getTag() instanceof a)) {
                view2 = nR;
                aVar = (a) nR.getTag();
            } else {
                View nR2 = nR(itemViewType);
                view2 = nR2;
                aVar = (a) nR2.getTag();
            }
            this.dNL.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.dNL.getLayoutMode().x(view2.findViewById(t.g.sign_all_forum_tip));
            aVar.dNQ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            w(aVar.dNR, i);
            return view2;
        }
        if (nR.getTag() == null || !(nR.getTag() instanceof b)) {
            nR = nR(itemViewType);
        }
        a(nR, viewGroup, i);
        return nR;
    }

    private void w(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.dNq == null ? 7 : this.dNq.getLevel();
        if (this.aUW == null || this.aUW.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.aUW.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.getUserLevel() >= level) {
                        if (next.aIX()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aIX()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.dNL.getPageContext().getString(t.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.dNL.getPageContext().getString(t.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View NP() {
        View inflate = LayoutInflater.from(this.dNL.getPageContext().getPageActivity()).inflate(t.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.o a2 = NoDataViewFactory.a(this.dNL.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(t.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.y(t.j.sign_all_forum_nodata_tip, t.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.dNL.getLayoutMode().ac(skinType == 1);
        this.dNL.getLayoutMode().x(inflate);
        a2.onChangeSkinType(this.dNL.getPageContext(), skinType);
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
        public BarImageView dNS;
        public LinearLayout dNT;
        public TextView dNU;
        public ImageView dNV;
        public TextView dNW;
        public FrameLayout dNX;
        public TextView dNY;
        public RelativeLayout dNZ;
        public ImageView dOa;
        public ProgressBar dOb;
        public TextView dOc;
        public TextView dOd;
        public TextView dOe;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView dNQ;
        public TextView dNR;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ah.a
    public void c(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.dNM.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ah.a
    public void onError(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.dNL.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.dNM.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.aUW.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.aUW.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.hH(z);
                eVar.hI(!z);
                eVar.hJ(false);
                if (z) {
                    eVar.nP(signData.getCountSignNum());
                    eVar.nQ(signData.getBonusPoint());
                    eVar.nO(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aIL = this.dNq.aIL();
                    if (aIL.contains(eVar)) {
                        aIL.remove(eVar);
                        this.dNq.aIK().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.dNE) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aJf() {
        this.dNE = true;
        synchronized (this) {
            for (Map.Entry<String, ah> entry : this.dNM.entrySet()) {
                entry.getValue().aJy();
            }
            this.dNM.clear();
        }
    }
}
