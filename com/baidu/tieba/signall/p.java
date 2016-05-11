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
import com.baidu.tbadk.core.util.at;
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
    private c eja;
    private boolean ejo;
    private SignAllForumActivity ejv;
    private ArrayList<e> aVJ = new ArrayList<>();
    private HashMap<String, ah> ejw = new HashMap<>();
    private boolean bbU = true;

    public p(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.ejv = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.eja = cVar;
            this.aVJ = cVar.aPO();
            if (this.aVJ.size() == 0) {
                this.bbU = false;
            } else {
                this.bbU = true;
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
        if (this.bbU) {
            return this.aVJ.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVJ.size() > i) {
            return this.aVJ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View oS(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.ejv.getPageContext().getPageActivity()).inflate(t.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.ejC = (BarImageView) inflate.findViewById(t.g.signallforum_item_avatar);
            bVar.ejC.setIsRound(false);
            bVar.ejC.setGifIconSupport(false);
            bVar.ejE = (TextView) inflate.findViewById(t.g.signallforum_item_name);
            bVar.ejF = (ImageView) inflate.findViewById(t.g.signallforum_item_level);
            bVar.ejG = (TextView) inflate.findViewById(t.g.signallforum_item_exp);
            bVar.ejH = (FrameLayout) inflate.findViewById(t.g.signallforum_item_res_container);
            bVar.ejI = (TextView) inflate.findViewById(t.g.signallforum_item_days);
            bVar.ejJ = (RelativeLayout) inflate.findViewById(t.g.signallforum_item_resign_container);
            bVar.ejK = (ImageView) inflate.findViewById(t.g.signallforum_item_resign_icon);
            bVar.ejL = (ProgressBar) inflate.findViewById(t.g.signallforum_item_resign_progress);
            bVar.ejM = (TextView) inflate.findViewById(t.g.signallforum_item_resign_text);
            bVar.ejN = (TextView) inflate.findViewById(t.g.signallforum_item_error);
            bVar.ejD = (LinearLayout) inflate.findViewById(t.g.signallforum_item_level_container);
            bVar.ejO = (TextView) inflate.findViewById(t.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.ejv.getPageContext().getPageActivity()).inflate(t.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.ejA = (TextView) inflate2.findViewById(t.g.signallforum_head_title);
        aVar.ejB = (TextView) inflate2.findViewById(t.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.ejv.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.ejv.getLayoutMode().x(view);
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
            bVar.ejE.setText(str);
            at.c(bVar.ejF, BitmapHelper.getSmallGradeResourceIdNew(eVar.getUserLevel()));
            bVar.ejG.setText(String.valueOf(eVar.aQb()) + "/" + eVar.aQc());
            bVar.ejO.clearAnimation();
            if (eVar.aQd()) {
                bVar.ejD.setVisibility(0);
                bVar.ejN.setVisibility(8);
                bVar.ejI.setVisibility(0);
                bVar.ejJ.setVisibility(8);
                bVar.ejI.setText(String.format(this.ejv.getPageContext().getString(t.j.signallforum_days), Integer.valueOf(eVar.aQa())));
                if (eVar.aQh()) {
                    bVar.ejG.setText(this.ejv.getPageContext().getString(t.j.signallforum_uplevel));
                    bVar.ejO.setVisibility(8);
                } else {
                    bVar.ejG.setText(String.valueOf(eVar.aQb()) + "/" + eVar.aQc());
                    bVar.ejO.setVisibility(0);
                }
                int aQg = eVar.aQg();
                if (aQg > 0) {
                    bVar.ejO.setVisibility(0);
                    bVar.ejO.setText("+" + aQg);
                } else {
                    bVar.ejO.setVisibility(8);
                }
            } else if (eVar.aQe()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.ejD.setVisibility(8);
                    bVar.ejN.setVisibility(0);
                    bVar.ejO.setVisibility(8);
                    bVar.ejN.setText(errorMsg);
                } else {
                    bVar.ejD.setVisibility(0);
                    bVar.ejN.setVisibility(8);
                    bVar.ejO.setVisibility(8);
                }
                bVar.ejI.setVisibility(8);
                bVar.ejJ.setVisibility(0);
                if (eVar.aQf()) {
                    bVar.ejK.setVisibility(4);
                    bVar.ejL.setVisibility(0);
                    bVar.ejM.setText(t.j.signallforum_resigning);
                } else {
                    bVar.ejK.setVisibility(0);
                    bVar.ejL.setVisibility(4);
                    bVar.ejM.setText(t.j.signallforum_resign);
                }
                bVar.ejJ.setOnClickListener(new q(this, eVar, bVar));
            } else {
                bVar.ejI.setVisibility(8);
                bVar.ejJ.setVisibility(8);
                bVar.ejO.setVisibility(8);
                bVar.ejD.setVisibility(0);
                bVar.ejN.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.ejC.setTag(avatar);
            bVar.ejC.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.bbU) {
            return Oy();
        }
        int itemViewType = getItemViewType(i);
        View oS = view == null ? oS(itemViewType) : view;
        if (itemViewType == 1) {
            if (oS.getTag() != null && (oS.getTag() instanceof a)) {
                view2 = oS;
                aVar = (a) oS.getTag();
            } else {
                View oS2 = oS(itemViewType);
                view2 = oS2;
                aVar = (a) oS2.getTag();
            }
            this.ejv.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
            this.ejv.getLayoutMode().x(view2.findViewById(t.g.sign_all_forum_tip));
            aVar.ejA.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            x(aVar.ejB, i);
            return view2;
        }
        if (oS.getTag() == null || !(oS.getTag() instanceof b)) {
            oS = oS(itemViewType);
        }
        a(oS, viewGroup, i);
        return oS;
    }

    private void x(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.eja == null ? 7 : this.eja.getLevel();
        if (this.aVJ == null || this.aVJ.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.aVJ.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.getUserLevel() >= level) {
                        if (next.aQd()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aQd()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.ejv.getPageContext().getString(t.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.ejv.getPageContext().getString(t.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View Oy() {
        View inflate = LayoutInflater.from(this.ejv.getPageContext().getPageActivity()).inflate(t.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.q a2 = NoDataViewFactory.a(this.ejv.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(t.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.v(t.j.sign_all_forum_nodata_tip, t.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.ejv.getLayoutMode().ae(skinType == 1);
        this.ejv.getLayoutMode().x(inflate);
        a2.onChangeSkinType(this.ejv.getPageContext(), skinType);
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
        public BarImageView ejC;
        public LinearLayout ejD;
        public TextView ejE;
        public ImageView ejF;
        public TextView ejG;
        public FrameLayout ejH;
        public TextView ejI;
        public RelativeLayout ejJ;
        public ImageView ejK;
        public ProgressBar ejL;
        public TextView ejM;
        public TextView ejN;
        public TextView ejO;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView ejA;
        public TextView ejB;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ah.a
    public void b(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.ejw.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ah.a
    public void onError(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.ejv.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.ejw.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.aVJ.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.aVJ.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.jk(z);
                eVar.jl(!z);
                eVar.jm(false);
                if (z) {
                    eVar.oQ(signData.getCountSignNum());
                    eVar.oR(signData.getBonusPoint());
                    eVar.oP(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aPR = this.eja.aPR();
                    if (aPR.contains(eVar)) {
                        aPR.remove(eVar);
                        this.eja.aPQ().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.ejo) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aQm() {
        this.ejo = true;
        synchronized (this) {
            for (Map.Entry<String, ah> entry : this.ejw.entrySet()) {
                entry.getValue().aQI();
            }
            this.ejw.clear();
        }
    }
}
