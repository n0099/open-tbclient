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
import com.baidu.tieba.f;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gED;
    private SignAllForumActivity gEX;
    private boolean isDestory;
    private ArrayList<d> cQO = new ArrayList<>();
    private HashMap<String, SignSingleModel> gEY = new HashMap<>();
    private boolean cYD = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gEX = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gED = cVar;
            this.cQO = cVar.bso();
            if (this.cQO.size() == 0) {
                this.cYD = false;
            } else {
                this.cYD = true;
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
        if (this.cYD) {
            return this.cQO.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cQO.size() > i) {
            return this.cQO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View tm(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gEX.getPageContext().getPageActivity()).inflate(f.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gFe = (BarImageView) inflate.findViewById(f.g.signallforum_item_avatar);
            bVar.gFe.setIsRound(false);
            bVar.gFe.setGifIconSupport(false);
            bVar.gFg = (TextView) inflate.findViewById(f.g.signallforum_item_name);
            bVar.gFh = (ImageView) inflate.findViewById(f.g.signallforum_item_level);
            bVar.gFi = (TextView) inflate.findViewById(f.g.signallforum_item_exp);
            bVar.gFj = (FrameLayout) inflate.findViewById(f.g.signallforum_item_res_container);
            bVar.gFk = (TextView) inflate.findViewById(f.g.signallforum_item_days);
            bVar.gFl = (RelativeLayout) inflate.findViewById(f.g.signallforum_item_resign_container);
            bVar.gFm = (ImageView) inflate.findViewById(f.g.signallforum_item_resign_icon);
            bVar.gFn = (ProgressBar) inflate.findViewById(f.g.signallforum_item_resign_progress);
            bVar.gFo = (TextView) inflate.findViewById(f.g.signallforum_item_resign_text);
            bVar.gFp = (TextView) inflate.findViewById(f.g.signallforum_item_error);
            bVar.gFf = (LinearLayout) inflate.findViewById(f.g.signallforum_item_level_container);
            bVar.gFq = (TextView) inflate.findViewById(f.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gEX.getPageContext().getPageActivity()).inflate(f.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gFc = (TextView) inflate2.findViewById(f.g.signallforum_head_title);
        aVar.gFd = (TextView) inflate2.findViewById(f.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gEX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gEX.getLayoutMode().onModeChanged(view);
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
            bVar.gFg.setText(str);
            am.c(bVar.gFh, BitmapHelper.getSmallGradeResourceIdNew(dVar.bsB()));
            bVar.gFi.setText(dVar.bsC() + "/" + dVar.bsD());
            bVar.gFq.clearAnimation();
            if (dVar.Ua()) {
                bVar.gFf.setVisibility(0);
                bVar.gFp.setVisibility(8);
                bVar.gFk.setVisibility(0);
                bVar.gFl.setVisibility(8);
                bVar.gFk.setText(String.format(this.gEX.getPageContext().getString(f.j.signallforum_days), Integer.valueOf(dVar.bsA())));
                if (dVar.bsH()) {
                    bVar.gFi.setText(this.gEX.getPageContext().getString(f.j.signallforum_uplevel));
                    bVar.gFq.setVisibility(8);
                } else {
                    bVar.gFi.setText(dVar.bsC() + "/" + dVar.bsD());
                    bVar.gFq.setVisibility(0);
                }
                int bsG = dVar.bsG();
                if (bsG > 0) {
                    bVar.gFq.setVisibility(0);
                    bVar.gFq.setText("+" + bsG);
                } else {
                    bVar.gFq.setVisibility(8);
                }
            } else if (dVar.bsE()) {
                bVar.gFf.setVisibility(0);
                bVar.gFp.setVisibility(8);
                bVar.gFq.setVisibility(8);
                bVar.gFk.setVisibility(8);
                bVar.gFl.setVisibility(0);
                if (dVar.bsF()) {
                    bVar.gFm.setVisibility(4);
                    bVar.gFn.setVisibility(0);
                    bVar.gFo.setText(f.j.signallforum_resigning);
                } else {
                    bVar.gFm.setVisibility(0);
                    bVar.gFn.setVisibility(4);
                    bVar.gFo.setText(f.j.signallforum_resign);
                }
                bVar.gFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bsF()) {
                            bVar.gFm.setVisibility(4);
                            bVar.gFn.setVisibility(0);
                            bVar.gFo.setText(f.j.signallforum_resigning);
                            dVar.mf(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gEX);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gEY.put(str2, signSingleModel);
                            }
                            signSingleModel.cg(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gFk.setVisibility(8);
                bVar.gFl.setVisibility(8);
                bVar.gFq.setVisibility(8);
                bVar.gFf.setVisibility(0);
                bVar.gFp.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gFe.setTag(avatar);
            bVar.gFe.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.cYD) {
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
            this.gEX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gEX.getLayoutMode().onModeChanged(view2.findViewById(f.g.sign_all_forum_tip));
            aVar.gFc.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gFd, i);
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
        int level = this.gED == null ? 7 : this.gED.getLevel();
        if (this.cQO == null || this.cQO.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cQO.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bsB() >= level) {
                        if (next.Ua()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.Ua()) {
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
            format = String.format(this.gEX.getPageContext().getString(f.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gEX.getPageContext().getString(f.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aqF() {
        View inflate = LayoutInflater.from(this.gEX.getPageContext().getPageActivity()).inflate(f.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gEX.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(f.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.E(f.j.sign_all_forum_nodata_tip, f.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gEX.getLayoutMode().setNightMode(skinType == 1);
        this.gEX.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gEX.getPageContext(), skinType);
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
        public BarImageView gFe;
        public LinearLayout gFf;
        public TextView gFg;
        public ImageView gFh;
        public TextView gFi;
        public FrameLayout gFj;
        public TextView gFk;
        public RelativeLayout gFl;
        public ImageView gFm;
        public ProgressBar gFn;
        public TextView gFo;
        public TextView gFp;
        public TextView gFq;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gFc;
        public TextView gFd;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gEY.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cf(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gEX.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gEY.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cQO.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cQO.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.md(z);
                dVar.me(!z);
                dVar.mf(false);
                if (z) {
                    dVar.tj(signData.count_sign_num);
                    dVar.tl(signData.sign_bonus_point);
                    dVar.ti(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bsr = this.gED.bsr();
                    if (bsr.contains(dVar)) {
                        bsr.remove(dVar);
                        this.gED.bsq().add(dVar);
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

    public void bsM() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gEY.entrySet()) {
                    entry.getValue().btg();
                }
                this.gEY.clear();
            }
        }
    }
}
