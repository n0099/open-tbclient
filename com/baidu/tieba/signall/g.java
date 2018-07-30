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
import com.baidu.tbadk.core.util.am;
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
    private c gEA;
    private SignAllForumActivity gEU;
    private boolean isDestory;
    private ArrayList<d> cQR = new ArrayList<>();
    private HashMap<String, SignSingleModel> gEV = new HashMap<>();
    private boolean cYH = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gEU = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gEA = cVar;
            this.cQR = cVar.bsn();
            if (this.cQR.size() == 0) {
                this.cYH = false;
            } else {
                this.cYH = true;
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
        if (this.cYH) {
            return this.cQR.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cQR.size() > i) {
            return this.cQR.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View tm(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gEU.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gFb = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gFb.setIsRound(false);
            bVar.gFb.setGifIconSupport(false);
            bVar.gFd = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gFe = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gFf = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gFg = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gFh = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gFi = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gFj = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gFk = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gFl = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gFm = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gFc = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gFn = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gEU.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gEZ = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gFa = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gEU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gEU.getLayoutMode().onModeChanged(view);
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
            bVar.gFd.setText(str);
            am.c(bVar.gFe, BitmapHelper.getSmallGradeResourceIdNew(dVar.bsA()));
            bVar.gFf.setText(dVar.bsB() + "/" + dVar.bsC());
            bVar.gFn.clearAnimation();
            if (dVar.TX()) {
                bVar.gFc.setVisibility(0);
                bVar.gFm.setVisibility(8);
                bVar.gFh.setVisibility(0);
                bVar.gFi.setVisibility(8);
                bVar.gFh.setText(String.format(this.gEU.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.bsz())));
                if (dVar.bsG()) {
                    bVar.gFf.setText(this.gEU.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.gFn.setVisibility(8);
                } else {
                    bVar.gFf.setText(dVar.bsB() + "/" + dVar.bsC());
                    bVar.gFn.setVisibility(0);
                }
                int bsF = dVar.bsF();
                if (bsF > 0) {
                    bVar.gFn.setVisibility(0);
                    bVar.gFn.setText("+" + bsF);
                } else {
                    bVar.gFn.setVisibility(8);
                }
            } else if (dVar.bsD()) {
                bVar.gFc.setVisibility(0);
                bVar.gFm.setVisibility(8);
                bVar.gFn.setVisibility(8);
                bVar.gFh.setVisibility(8);
                bVar.gFi.setVisibility(0);
                if (dVar.bsE()) {
                    bVar.gFj.setVisibility(4);
                    bVar.gFk.setVisibility(0);
                    bVar.gFl.setText(d.j.signallforum_resigning);
                } else {
                    bVar.gFj.setVisibility(0);
                    bVar.gFk.setVisibility(4);
                    bVar.gFl.setText(d.j.signallforum_resign);
                }
                bVar.gFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bsE()) {
                            bVar.gFj.setVisibility(4);
                            bVar.gFk.setVisibility(0);
                            bVar.gFl.setText(d.j.signallforum_resigning);
                            dVar.mf(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gEU);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gEV.put(str2, signSingleModel);
                            }
                            signSingleModel.cg(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gFh.setVisibility(8);
                bVar.gFi.setVisibility(8);
                bVar.gFn.setVisibility(8);
                bVar.gFc.setVisibility(0);
                bVar.gFm.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gFb.setTag(avatar);
            bVar.gFb.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.cYH) {
            return aqF();
        }
        int itemViewType = getItemViewType(i);
        View tm = view == null ? tm(itemViewType) : view;
        if (itemViewType == 1) {
            if (tm.getTag() != null && (tm.getTag() instanceof a)) {
                view2 = tm;
                aVar = (a) tm.getTag();
            } else {
                View tm2 = tm(itemViewType);
                view2 = tm2;
                aVar = (a) tm2.getTag();
            }
            this.gEU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gEU.getLayoutMode().onModeChanged(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.gEZ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gFa, i);
            return view2;
        }
        if (tm.getTag() == null || !(tm.getTag() instanceof b)) {
            tm = tm(itemViewType);
        }
        a(tm, viewGroup, i);
        return tm;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gEA == null ? 7 : this.gEA.getLevel();
        if (this.cQR == null || this.cQR.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cQR.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bsA() >= level) {
                        if (next.TX()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.TX()) {
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
            format = String.format(this.gEU.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gEU.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aqF() {
        View inflate = LayoutInflater.from(this.gEU.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gEU.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.E(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gEU.getLayoutMode().setNightMode(skinType == 1);
        this.gEU.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gEU.getPageContext(), skinType);
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
        public BarImageView gFb;
        public LinearLayout gFc;
        public TextView gFd;
        public ImageView gFe;
        public TextView gFf;
        public FrameLayout gFg;
        public TextView gFh;
        public RelativeLayout gFi;
        public ImageView gFj;
        public ProgressBar gFk;
        public TextView gFl;
        public TextView gFm;
        public TextView gFn;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gEZ;
        public TextView gFa;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gEV.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cf(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gEU.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gEV.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cQR.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cQR.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.md(z);
                dVar.me(!z);
                dVar.mf(false);
                if (z) {
                    dVar.tj(signData.count_sign_num);
                    dVar.tl(signData.sign_bonus_point);
                    dVar.ti(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bsq = this.gEA.bsq();
                    if (bsq.contains(dVar)) {
                        bsq.remove(dVar);
                        this.gEA.bsp().add(dVar);
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

    public void bsL() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gEV.entrySet()) {
                    entry.getValue().btf();
                }
                this.gEV.clear();
            }
        }
    }
}
