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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gRS;
    private SignAllForumActivity gSl;
    private boolean isDestory;
    private ArrayList<d> dnU = new ArrayList<>();
    private HashMap<String, SignSingleModel> gSm = new HashMap<>();
    private boolean duS = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gSl = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gRS = cVar;
            this.dnU = cVar.btd();
            if (this.dnU.size() == 0) {
                this.duS = false;
            } else {
                this.duS = true;
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
        if (this.duS) {
            return this.dnU.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dnU.size() > i) {
            return this.dnU.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View vr(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gSl.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gSs = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gSs.setIsRound(false);
            bVar.gSs.setGifIconSupport(false);
            bVar.gSu = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gSv = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gSw = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gSx = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gSy = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gSz = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gSA = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gSB = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gSC = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gSD = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gSt = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gSE = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gSl.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gSq = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gSr = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void d(View view, View view2, int i) {
        String str;
        this.gSl.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gSl.getLayoutMode().aM(view);
        final b bVar = (b) view.getTag();
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
            bVar.gSu.setText(str);
            aj.c(bVar.gSv, BitmapHelper.getSmallGradeResourceIdNew(dVar.btq()));
            bVar.gSw.setText(dVar.btr() + "/" + dVar.bts());
            bVar.gSE.clearAnimation();
            if (dVar.XA()) {
                bVar.gSt.setVisibility(0);
                bVar.gSD.setVisibility(8);
                bVar.gSy.setVisibility(0);
                bVar.gSz.setVisibility(8);
                bVar.gSy.setText(String.format(this.gSl.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.btp())));
                if (dVar.btw()) {
                    bVar.gSw.setText(this.gSl.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.gSE.setVisibility(8);
                } else {
                    bVar.gSw.setText(dVar.btr() + "/" + dVar.bts());
                    bVar.gSE.setVisibility(0);
                }
                int btv = dVar.btv();
                if (btv > 0) {
                    bVar.gSE.setVisibility(0);
                    bVar.gSE.setText("+" + btv);
                } else {
                    bVar.gSE.setVisibility(8);
                }
            } else if (dVar.btt()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gSt.setVisibility(8);
                    bVar.gSD.setVisibility(0);
                    bVar.gSE.setVisibility(8);
                    bVar.gSD.setText(errorMsg);
                } else {
                    bVar.gSt.setVisibility(0);
                    bVar.gSD.setVisibility(8);
                    bVar.gSE.setVisibility(8);
                }
                bVar.gSy.setVisibility(8);
                bVar.gSz.setVisibility(0);
                if (dVar.btu()) {
                    bVar.gSA.setVisibility(4);
                    bVar.gSB.setVisibility(0);
                    bVar.gSC.setText(d.j.signallforum_resigning);
                } else {
                    bVar.gSA.setVisibility(0);
                    bVar.gSB.setVisibility(4);
                    bVar.gSC.setText(d.j.signallforum_resign);
                }
                bVar.gSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.btu()) {
                            bVar.gSA.setVisibility(4);
                            bVar.gSB.setVisibility(0);
                            bVar.gSC.setText(d.j.signallforum_resigning);
                            dVar.mB(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gSl);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gSm.put(str2, signSingleModel);
                            }
                            signSingleModel.bY(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gSy.setVisibility(8);
                bVar.gSz.setVisibility(8);
                bVar.gSE.setVisibility(8);
                bVar.gSt.setVisibility(0);
                bVar.gSD.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gSs.setTag(avatar);
            bVar.gSs.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.duS) {
            return asp();
        }
        int itemViewType = getItemViewType(i);
        View vr = view == null ? vr(itemViewType) : view;
        if (itemViewType == 1) {
            if (vr.getTag() != null && (vr.getTag() instanceof a)) {
                view2 = vr;
                aVar = (a) vr.getTag();
            } else {
                View vr2 = vr(itemViewType);
                view2 = vr2;
                aVar = (a) vr2.getTag();
            }
            this.gSl.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gSl.getLayoutMode().aM(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.gSq.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            p(aVar.gSr, i);
            return view2;
        }
        if (vr.getTag() == null || !(vr.getTag() instanceof b)) {
            vr = vr(itemViewType);
        }
        d(vr, viewGroup, i);
        return vr;
    }

    private void p(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gRS == null ? 7 : this.gRS.getLevel();
        if (this.dnU == null || this.dnU.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.dnU.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.btq() >= level) {
                        if (next.XA()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.XA()) {
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
            format = String.format(this.gSl.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gSl.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View asp() {
        View inflate = LayoutInflater.from(this.gSl.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.h a2 = NoDataViewFactory.a(this.gSl.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.aC(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gSl.getLayoutMode().aQ(skinType == 1);
        this.gSl.getLayoutMode().aM(inflate);
        a2.onChangeSkinType(this.gSl.getPageContext(), skinType);
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
        public ImageView gSA;
        public ProgressBar gSB;
        public TextView gSC;
        public TextView gSD;
        public TextView gSE;
        public BarImageView gSs;
        public LinearLayout gSt;
        public TextView gSu;
        public ImageView gSv;
        public TextView gSw;
        public FrameLayout gSx;
        public TextView gSy;
        public RelativeLayout gSz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gSq;
        public TextView gSr;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gSm.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void bX(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.l.showToast(this.gSl.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gSm.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.dnU.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.dnU.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mz(z);
                dVar.mA(!z);
                dVar.mB(false);
                if (z) {
                    dVar.vo(signData.count_sign_num);
                    dVar.vq(signData.sign_bonus_point);
                    dVar.vn(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> btg = this.gRS.btg();
                    if (btg.contains(dVar)) {
                        btg.remove(dVar);
                        this.gRS.btf().add(dVar);
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

    public void btB() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gSm.entrySet()) {
                    entry.getValue().btW();
                }
                this.gSm.clear();
            }
        }
    }
}
