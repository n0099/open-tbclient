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
    private c gmY;
    private SignAllForumActivity gnr;
    private boolean isDestory;
    private ArrayList<d> cGa = new ArrayList<>();
    private HashMap<String, SignSingleModel> gns = new HashMap<>();
    private boolean cNG = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gnr = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gmY = cVar;
            this.cGa = cVar.bom();
            if (this.cGa.size() == 0) {
                this.cNG = false;
            } else {
                this.cNG = true;
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
        if (this.cNG) {
            return this.cGa.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cGa.size() > i) {
            return this.cGa.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View sT(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gnr.getPageContext().getPageActivity()).inflate(d.i.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gny = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gny.setIsRound(false);
            bVar.gny.setGifIconSupport(false);
            bVar.gnA = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gnB = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gnC = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gnD = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gnE = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gnF = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gnG = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gnH = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gnI = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gnJ = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gnz = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gnK = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gnr.getPageContext().getPageActivity()).inflate(d.i.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gnw = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gnx = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view2, View view3, int i) {
        String str;
        this.gnr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gnr.getLayoutMode().u(view2);
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
            bVar.gnA.setText(str);
            ak.c(bVar.gnB, BitmapHelper.getSmallGradeResourceIdNew(dVar.boz()));
            bVar.gnC.setText(dVar.boA() + "/" + dVar.boB());
            bVar.gnK.clearAnimation();
            if (dVar.Qa()) {
                bVar.gnz.setVisibility(0);
                bVar.gnJ.setVisibility(8);
                bVar.gnE.setVisibility(0);
                bVar.gnF.setVisibility(8);
                bVar.gnE.setText(String.format(this.gnr.getPageContext().getString(d.k.signallforum_days), Integer.valueOf(dVar.boy())));
                if (dVar.boF()) {
                    bVar.gnC.setText(this.gnr.getPageContext().getString(d.k.signallforum_uplevel));
                    bVar.gnK.setVisibility(8);
                } else {
                    bVar.gnC.setText(dVar.boA() + "/" + dVar.boB());
                    bVar.gnK.setVisibility(0);
                }
                int boE = dVar.boE();
                if (boE > 0) {
                    bVar.gnK.setVisibility(0);
                    bVar.gnK.setText("+" + boE);
                } else {
                    bVar.gnK.setVisibility(8);
                }
            } else if (dVar.boC()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gnz.setVisibility(8);
                    bVar.gnJ.setVisibility(0);
                    bVar.gnK.setVisibility(8);
                    bVar.gnJ.setText(errorMsg);
                } else {
                    bVar.gnz.setVisibility(0);
                    bVar.gnJ.setVisibility(8);
                    bVar.gnK.setVisibility(8);
                }
                bVar.gnE.setVisibility(8);
                bVar.gnF.setVisibility(0);
                if (dVar.boD()) {
                    bVar.gnG.setVisibility(4);
                    bVar.gnH.setVisibility(0);
                    bVar.gnI.setText(d.k.signallforum_resigning);
                } else {
                    bVar.gnG.setVisibility(0);
                    bVar.gnH.setVisibility(4);
                    bVar.gnI.setText(d.k.signallforum_resign);
                }
                bVar.gnF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        if (!dVar.boD()) {
                            bVar.gnG.setVisibility(4);
                            bVar.gnH.setVisibility(0);
                            bVar.gnI.setText(d.k.signallforum_resigning);
                            dVar.mc(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gnr);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gns.put(str2, signSingleModel);
                            }
                            signSingleModel.bX(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gnE.setVisibility(8);
                bVar.gnF.setVisibility(8);
                bVar.gnK.setVisibility(8);
                bVar.gnz.setVisibility(0);
                bVar.gnJ.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gny.setTag(avatar);
            bVar.gny.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View view3;
        a aVar;
        if (!this.cNG) {
            return amF();
        }
        int itemViewType = getItemViewType(i);
        View sT = view2 == null ? sT(itemViewType) : view2;
        if (itemViewType == 1) {
            if (sT.getTag() != null && (sT.getTag() instanceof a)) {
                view3 = sT;
                aVar = (a) sT.getTag();
            } else {
                View sT2 = sT(itemViewType);
                view3 = sT2;
                aVar = (a) sT2.getTag();
            }
            this.gnr.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gnr.getLayoutMode().u(view3.findViewById(d.g.sign_all_forum_tip));
            aVar.gnw.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gnx, i);
            return view3;
        }
        if (sT.getTag() == null || !(sT.getTag() instanceof b)) {
            sT = sT(itemViewType);
        }
        a(sT, viewGroup, i);
        return sT;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gmY == null ? 7 : this.gmY.getLevel();
        if (this.cGa == null || this.cGa.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cGa.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.boz() >= level) {
                        if (next.Qa()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.Qa()) {
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
            format = String.format(this.gnr.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gnr.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View amF() {
        View inflate = LayoutInflater.from(this.gnr.getPageContext().getPageActivity()).inflate(d.i.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gnr.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(d.k.sign_all_forum_nodata_tip, d.k.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gnr.getLayoutMode().setNightMode(skinType == 1);
        this.gnr.getLayoutMode().u(inflate);
        a2.onChangeSkinType(this.gnr.getPageContext(), skinType);
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
        public TextView gnA;
        public ImageView gnB;
        public TextView gnC;
        public FrameLayout gnD;
        public TextView gnE;
        public RelativeLayout gnF;
        public ImageView gnG;
        public ProgressBar gnH;
        public TextView gnI;
        public TextView gnJ;
        public TextView gnK;
        public BarImageView gny;
        public LinearLayout gnz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gnw;
        public TextView gnx;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gns.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void bW(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gnr.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gns.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cGa.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cGa.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ma(z);
                dVar.mb(!z);
                dVar.mc(false);
                if (z) {
                    dVar.sQ(signData.count_sign_num);
                    dVar.sS(signData.sign_bonus_point);
                    dVar.sP(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bop = this.gmY.bop();
                    if (bop.contains(dVar)) {
                        bop.remove(dVar);
                        this.gmY.boo().add(dVar);
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

    public void boK() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gns.entrySet()) {
                    entry.getValue().bpe();
                }
                this.gns.clear();
            }
        }
    }
}
