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
import com.baidu.tbadk.core.util.al;
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
    private SignAllForumActivity gzS;
    private c gzz;
    private boolean isDestory;
    private ArrayList<d> cQn = new ArrayList<>();
    private HashMap<String, SignSingleModel> gzT = new HashMap<>();
    private boolean cXP = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gzS = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gzz = cVar;
            this.cQn = cVar.btk();
            if (this.cQn.size() == 0) {
                this.cXP = false;
            } else {
                this.cXP = true;
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
        if (this.cXP) {
            return this.cQn.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cQn.size() > i) {
            return this.cQn.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View te(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gzS.getPageContext().getPageActivity()).inflate(d.i.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gzZ = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gzZ.setIsRound(false);
            bVar.gzZ.setGifIconSupport(false);
            bVar.gAb = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gAc = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gAd = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gAe = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gAf = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gAg = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gAh = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gAi = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gAj = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gAk = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gAa = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gAl = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gzS.getPageContext().getPageActivity()).inflate(d.i.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gzX = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gzY = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gzS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gzS.getLayoutMode().onModeChanged(view);
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
            bVar.gAb.setText(str);
            al.c(bVar.gAc, BitmapHelper.getSmallGradeResourceIdNew(dVar.btx()));
            bVar.gAd.setText(dVar.bty() + "/" + dVar.btz());
            bVar.gAl.clearAnimation();
            if (dVar.Tv()) {
                bVar.gAa.setVisibility(0);
                bVar.gAk.setVisibility(8);
                bVar.gAf.setVisibility(0);
                bVar.gAg.setVisibility(8);
                bVar.gAf.setText(String.format(this.gzS.getPageContext().getString(d.k.signallforum_days), Integer.valueOf(dVar.btw())));
                if (dVar.btD()) {
                    bVar.gAd.setText(this.gzS.getPageContext().getString(d.k.signallforum_uplevel));
                    bVar.gAl.setVisibility(8);
                } else {
                    bVar.gAd.setText(dVar.bty() + "/" + dVar.btz());
                    bVar.gAl.setVisibility(0);
                }
                int btC = dVar.btC();
                if (btC > 0) {
                    bVar.gAl.setVisibility(0);
                    bVar.gAl.setText("+" + btC);
                } else {
                    bVar.gAl.setVisibility(8);
                }
            } else if (dVar.btA()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gAa.setVisibility(8);
                    bVar.gAk.setVisibility(0);
                    bVar.gAl.setVisibility(8);
                    bVar.gAk.setText(errorMsg);
                } else {
                    bVar.gAa.setVisibility(0);
                    bVar.gAk.setVisibility(8);
                    bVar.gAl.setVisibility(8);
                }
                bVar.gAf.setVisibility(8);
                bVar.gAg.setVisibility(0);
                if (dVar.btB()) {
                    bVar.gAh.setVisibility(4);
                    bVar.gAi.setVisibility(0);
                    bVar.gAj.setText(d.k.signallforum_resigning);
                } else {
                    bVar.gAh.setVisibility(0);
                    bVar.gAi.setVisibility(4);
                    bVar.gAj.setText(d.k.signallforum_resign);
                }
                bVar.gAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.btB()) {
                            bVar.gAh.setVisibility(4);
                            bVar.gAi.setVisibility(0);
                            bVar.gAj.setText(d.k.signallforum_resigning);
                            dVar.mj(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gzS);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gzT.put(str2, signSingleModel);
                            }
                            signSingleModel.cf(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gAf.setVisibility(8);
                bVar.gAg.setVisibility(8);
                bVar.gAl.setVisibility(8);
                bVar.gAa.setVisibility(0);
                bVar.gAk.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gzZ.setTag(avatar);
            bVar.gzZ.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.cXP) {
            return aqK();
        }
        int itemViewType = getItemViewType(i);
        View te = view == null ? te(itemViewType) : view;
        if (itemViewType == 1) {
            if (te.getTag() != null && (te.getTag() instanceof a)) {
                view2 = te;
                aVar = (a) te.getTag();
            } else {
                View te2 = te(itemViewType);
                view2 = te2;
                aVar = (a) te2.getTag();
            }
            this.gzS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gzS.getLayoutMode().onModeChanged(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.gzX.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gzY, i);
            return view2;
        }
        if (te.getTag() == null || !(te.getTag() instanceof b)) {
            te = te(itemViewType);
        }
        a(te, viewGroup, i);
        return te;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gzz == null ? 7 : this.gzz.getLevel();
        if (this.cQn == null || this.cQn.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cQn.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.btx() >= level) {
                        if (next.Tv()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.Tv()) {
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
            format = String.format(this.gzS.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gzS.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aqK() {
        View inflate = LayoutInflater.from(this.gzS.getPageContext().getPageActivity()).inflate(d.i.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gzS.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.D(d.k.sign_all_forum_nodata_tip, d.k.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gzS.getLayoutMode().setNightMode(skinType == 1);
        this.gzS.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gzS.getPageContext(), skinType);
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
        public LinearLayout gAa;
        public TextView gAb;
        public ImageView gAc;
        public TextView gAd;
        public FrameLayout gAe;
        public TextView gAf;
        public RelativeLayout gAg;
        public ImageView gAh;
        public ProgressBar gAi;
        public TextView gAj;
        public TextView gAk;
        public TextView gAl;
        public BarImageView gzZ;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gzX;
        public TextView gzY;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gzT.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ce(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gzS.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gzT.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cQn.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cQn.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mh(z);
                dVar.mi(!z);
                dVar.mj(false);
                if (z) {
                    dVar.tb(signData.count_sign_num);
                    dVar.td(signData.sign_bonus_point);
                    dVar.ta(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> btn = this.gzz.btn();
                    if (btn.contains(dVar)) {
                        btn.remove(dVar);
                        this.gzz.btm().add(dVar);
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

    public void btI() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gzT.entrySet()) {
                    entry.getValue().buc();
                }
                this.gzT.clear();
            }
        }
    }
}
