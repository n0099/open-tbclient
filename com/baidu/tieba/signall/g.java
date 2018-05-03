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
    private c gmV;
    private SignAllForumActivity gno;
    private boolean isDestory;
    private ArrayList<d> cFX = new ArrayList<>();
    private HashMap<String, SignSingleModel> gnp = new HashMap<>();
    private boolean cND = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gno = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gmV = cVar;
            this.cFX = cVar.bom();
            if (this.cFX.size() == 0) {
                this.cND = false;
            } else {
                this.cND = true;
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
        if (this.cND) {
            return this.cFX.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cFX.size() > i) {
            return this.cFX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View sT(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gno.getPageContext().getPageActivity()).inflate(d.i.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gnv = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gnv.setIsRound(false);
            bVar.gnv.setGifIconSupport(false);
            bVar.gnx = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gny = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gnz = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gnA = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gnB = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gnC = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gnD = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gnE = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gnF = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gnG = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gnw = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gnH = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gno.getPageContext().getPageActivity()).inflate(d.i.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gnt = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gnu = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view2, View view3, int i) {
        String str;
        this.gno.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gno.getLayoutMode().u(view2);
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
            bVar.gnx.setText(str);
            ak.c(bVar.gny, BitmapHelper.getSmallGradeResourceIdNew(dVar.boz()));
            bVar.gnz.setText(dVar.boA() + "/" + dVar.boB());
            bVar.gnH.clearAnimation();
            if (dVar.Qa()) {
                bVar.gnw.setVisibility(0);
                bVar.gnG.setVisibility(8);
                bVar.gnB.setVisibility(0);
                bVar.gnC.setVisibility(8);
                bVar.gnB.setText(String.format(this.gno.getPageContext().getString(d.k.signallforum_days), Integer.valueOf(dVar.boy())));
                if (dVar.boF()) {
                    bVar.gnz.setText(this.gno.getPageContext().getString(d.k.signallforum_uplevel));
                    bVar.gnH.setVisibility(8);
                } else {
                    bVar.gnz.setText(dVar.boA() + "/" + dVar.boB());
                    bVar.gnH.setVisibility(0);
                }
                int boE = dVar.boE();
                if (boE > 0) {
                    bVar.gnH.setVisibility(0);
                    bVar.gnH.setText("+" + boE);
                } else {
                    bVar.gnH.setVisibility(8);
                }
            } else if (dVar.boC()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gnw.setVisibility(8);
                    bVar.gnG.setVisibility(0);
                    bVar.gnH.setVisibility(8);
                    bVar.gnG.setText(errorMsg);
                } else {
                    bVar.gnw.setVisibility(0);
                    bVar.gnG.setVisibility(8);
                    bVar.gnH.setVisibility(8);
                }
                bVar.gnB.setVisibility(8);
                bVar.gnC.setVisibility(0);
                if (dVar.boD()) {
                    bVar.gnD.setVisibility(4);
                    bVar.gnE.setVisibility(0);
                    bVar.gnF.setText(d.k.signallforum_resigning);
                } else {
                    bVar.gnD.setVisibility(0);
                    bVar.gnE.setVisibility(4);
                    bVar.gnF.setText(d.k.signallforum_resign);
                }
                bVar.gnC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        if (!dVar.boD()) {
                            bVar.gnD.setVisibility(4);
                            bVar.gnE.setVisibility(0);
                            bVar.gnF.setText(d.k.signallforum_resigning);
                            dVar.mc(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gno);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gnp.put(str2, signSingleModel);
                            }
                            signSingleModel.bX(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gnB.setVisibility(8);
                bVar.gnC.setVisibility(8);
                bVar.gnH.setVisibility(8);
                bVar.gnw.setVisibility(0);
                bVar.gnG.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gnv.setTag(avatar);
            bVar.gnv.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View view3;
        a aVar;
        if (!this.cND) {
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
            this.gno.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gno.getLayoutMode().u(view3.findViewById(d.g.sign_all_forum_tip));
            aVar.gnt.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gnu, i);
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
        int level = this.gmV == null ? 7 : this.gmV.getLevel();
        if (this.cFX == null || this.cFX.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cFX.iterator();
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
            format = String.format(this.gno.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gno.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View amF() {
        View inflate = LayoutInflater.from(this.gno.getPageContext().getPageActivity()).inflate(d.i.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gno.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.C(d.k.sign_all_forum_nodata_tip, d.k.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gno.getLayoutMode().setNightMode(skinType == 1);
        this.gno.getLayoutMode().u(inflate);
        a2.onChangeSkinType(this.gno.getPageContext(), skinType);
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
        public FrameLayout gnA;
        public TextView gnB;
        public RelativeLayout gnC;
        public ImageView gnD;
        public ProgressBar gnE;
        public TextView gnF;
        public TextView gnG;
        public TextView gnH;
        public BarImageView gnv;
        public LinearLayout gnw;
        public TextView gnx;
        public ImageView gny;
        public TextView gnz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gnt;
        public TextView gnu;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gnp.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void bW(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gno.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gnp.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cFX.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cFX.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ma(z);
                dVar.mb(!z);
                dVar.mc(false);
                if (z) {
                    dVar.sQ(signData.count_sign_num);
                    dVar.sS(signData.sign_bonus_point);
                    dVar.sP(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bop = this.gmV.bop();
                    if (bop.contains(dVar)) {
                        bop.remove(dVar);
                        this.gmV.boo().add(dVar);
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
                for (Map.Entry<String, SignSingleModel> entry : this.gnp.entrySet()) {
                    entry.getValue().bpe();
                }
                this.gnp.clear();
            }
        }
    }
}
