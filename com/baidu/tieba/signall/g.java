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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gob;
    private SignAllForumActivity gou;
    private boolean isDestory;
    private ArrayList<d> cHg = new ArrayList<>();
    private HashMap<String, SignSingleModel> gov = new HashMap<>();
    private boolean cOK = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gou = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gob = cVar;
            this.cHg = cVar.bok();
            if (this.cHg.size() == 0) {
                this.cOK = false;
            } else {
                this.cOK = true;
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
        if (this.cOK) {
            return this.cHg.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cHg.size() > i) {
            return this.cHg.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View sS(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gou.getPageContext().getPageActivity()).inflate(d.i.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.goB = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.goB.setIsRound(false);
            bVar.goB.setGifIconSupport(false);
            bVar.goD = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.goE = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.goF = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.goG = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.goH = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.goI = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.goJ = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.goK = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.goL = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.goM = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.goC = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.goN = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gou.getPageContext().getPageActivity()).inflate(d.i.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.goz = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.goA = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view2, View view3, int i) {
        String str;
        this.gou.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gou.getLayoutMode().u(view2);
        final b bVar = (b) view2.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
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
                        str = forumName.substring(0, i3) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.goD.setText(str);
            ak.c(bVar.goE, BitmapHelper.getSmallGradeResourceIdNew(dVar.box()));
            bVar.goF.setText(dVar.boy() + "/" + dVar.boz());
            bVar.goN.clearAnimation();
            if (dVar.PX()) {
                bVar.goC.setVisibility(0);
                bVar.goM.setVisibility(8);
                bVar.goH.setVisibility(0);
                bVar.goI.setVisibility(8);
                bVar.goH.setText(String.format(this.gou.getPageContext().getString(d.k.signallforum_days), Integer.valueOf(dVar.bow())));
                if (dVar.boD()) {
                    bVar.goF.setText(this.gou.getPageContext().getString(d.k.signallforum_uplevel));
                    bVar.goN.setVisibility(8);
                } else {
                    bVar.goF.setText(dVar.boy() + "/" + dVar.boz());
                    bVar.goN.setVisibility(0);
                }
                int boC = dVar.boC();
                if (boC > 0) {
                    bVar.goN.setVisibility(0);
                    bVar.goN.setText("+" + boC);
                } else {
                    bVar.goN.setVisibility(8);
                }
            } else if (dVar.boA()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.goC.setVisibility(8);
                    bVar.goM.setVisibility(0);
                    bVar.goN.setVisibility(8);
                    bVar.goM.setText(errorMsg);
                } else {
                    bVar.goC.setVisibility(0);
                    bVar.goM.setVisibility(8);
                    bVar.goN.setVisibility(8);
                }
                bVar.goH.setVisibility(8);
                bVar.goI.setVisibility(0);
                if (dVar.boB()) {
                    bVar.goJ.setVisibility(4);
                    bVar.goK.setVisibility(0);
                    bVar.goL.setText(d.k.signallforum_resigning);
                } else {
                    bVar.goJ.setVisibility(0);
                    bVar.goK.setVisibility(4);
                    bVar.goL.setText(d.k.signallforum_resign);
                }
                bVar.goI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        if (!dVar.boB()) {
                            bVar.goJ.setVisibility(4);
                            bVar.goK.setVisibility(0);
                            bVar.goL.setText(d.k.signallforum_resigning);
                            dVar.md(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gou);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gov.put(str2, signSingleModel);
                            }
                            signSingleModel.bX(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.goH.setVisibility(8);
                bVar.goI.setVisibility(8);
                bVar.goN.setVisibility(8);
                bVar.goC.setVisibility(0);
                bVar.goM.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.goB.setTag(avatar);
            bVar.goB.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View view3;
        a aVar;
        if (!this.cOK) {
            return amE();
        }
        int itemViewType = getItemViewType(i);
        View sS = view2 == null ? sS(itemViewType) : view2;
        if (itemViewType == 1) {
            if (sS.getTag() != null && (sS.getTag() instanceof a)) {
                view3 = sS;
                aVar = (a) sS.getTag();
            } else {
                View sS2 = sS(itemViewType);
                view3 = sS2;
                aVar = (a) sS2.getTag();
            }
            this.gou.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gou.getLayoutMode().u(view3.findViewById(d.g.sign_all_forum_tip));
            aVar.goz.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.goA, i);
            return view3;
        }
        if (sS.getTag() == null || !(sS.getTag() instanceof b)) {
            sS = sS(itemViewType);
        }
        a(sS, viewGroup, i);
        return sS;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gob == null ? 7 : this.gob.getLevel();
        if (this.cHg == null || this.cHg.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cHg.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.box() >= level) {
                        if (next.PX()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.PX()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.gou.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gou.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View amE() {
        View inflate = LayoutInflater.from(this.gou.getPageContext().getPageActivity()).inflate(d.i.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gou.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(d.k.sign_all_forum_nodata_tip, d.k.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gou.getLayoutMode().setNightMode(skinType == 1);
        this.gou.getLayoutMode().u(inflate);
        a2.onChangeSkinType(this.gou.getPageContext(), skinType);
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
    /* loaded from: classes3.dex */
    public class b {
        public BarImageView goB;
        public LinearLayout goC;
        public TextView goD;
        public ImageView goE;
        public TextView goF;
        public FrameLayout goG;
        public TextView goH;
        public RelativeLayout goI;
        public ImageView goJ;
        public ProgressBar goK;
        public TextView goL;
        public TextView goM;
        public TextView goN;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView goA;
        public TextView goz;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gov.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void bW(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gou.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gov.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cHg.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cHg.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mb(z);
                dVar.mc(!z);
                dVar.md(false);
                if (z) {
                    dVar.sP(signData.count_sign_num);
                    dVar.sR(signData.sign_bonus_point);
                    dVar.sO(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bon = this.gob.bon();
                    if (bon.contains(dVar)) {
                        bon.remove(dVar);
                        this.gob.bom().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void boI() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gov.entrySet()) {
                    entry.getValue().bpc();
                }
                this.gov.clear();
            }
        }
    }
}
